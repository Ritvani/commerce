package com.ritvan.ecommerce.services;


import com.ritvan.ecommerce.models.LoginUser;
import com.ritvan.ecommerce.models.User;
import com.ritvan.ecommerce.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User newUser, BindingResult result){

        Optional<User> potentialUser = this.userRepository.findByEmail(newUser.getEmail());

        if (potentialUser.isPresent()){
            result.rejectValue("email", "EmailTaken", "Email address is already taken");
        }

        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }

        if(result.hasErrors()) {
            return null;
        }else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepository.save(newUser);
        }
    }

    public User login(LoginUser newLogInObject, BindingResult result){

        Optional<User>potentialUser = this.userRepository.findByEmail(newLogInObject.getEmail());

        if (!potentialUser.isPresent()){
            result.rejectValue("email", "EmailNotFound", "No user found with this email");
        } else {
            if (!BCrypt.checkpw(newLogInObject.getPassword(), potentialUser.get().getPassword())){
                result.rejectValue("password", "Matches", "Invalid password");
            }
        }
        if (result.hasErrors()){
            return null;
        }else {
            return potentialUser.get();
        }
    }

    public User findOneUser(Long id){
        return this.userRepository.findById(id).orElse(null);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }
}