package com.ritvan.ecommerce.controllers;


import com.ritvan.ecommerce.models.LoginUser;
import com.ritvan.ecommerce.models.Product;
import com.ritvan.ecommerce.models.User;
import com.ritvan.ecommerce.services.ProductService;
import com.ritvan.ecommerce.services.UserService;
import com.ritvan.ecommerce.uploads.FileStorageService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    FileStorageService fileStorageService;



    @GetMapping("/")
    public String index(Model model, @ModelAttribute("newUser") User newUser, @ModelAttribute("newLogin") User newLogin, HttpSession session) {
        Long loggedInUserID = (Long) session.getAttribute("loggedInUserID");

        if (loggedInUserID != null) {
            return "redirect:/home";
        }

        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
        userService.register(newUser, result);

        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index";
        }
        session.setAttribute("loggedInUserID", newUser.getId());
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
        User user = userService.login(newLogin, result);

        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index";
        }
        session.setAttribute("loggedInUserID", user.getId());
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String dashboard(HttpSession session, Model model) {
        Long loggedInUserID = (Long) session.getAttribute("loggedInUserID");

        if (loggedInUserID == null) {
            return "redirect:/";
        }

        User loggedInUser = userService.findOneUser(loggedInUserID);
        model.addAttribute("user", loggedInUser);
        model.addAttribute("topCards", productService.getTopCards());
        
        return "dashboard";
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}