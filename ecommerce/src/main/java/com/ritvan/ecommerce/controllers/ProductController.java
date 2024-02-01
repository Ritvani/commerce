package com.ritvan.ecommerce.controllers;

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

import java.io.IOException;


@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    FileStorageService fileStorageService;


    @GetMapping("/new/card")
    public String newProject(@ModelAttribute("card")Product product, Model model, HttpSession session){
        User user = userService.findOneUser((Long)session.getAttribute("loggedInUserID"));
        if (session.getAttribute("loggedInUserID")==null){
            return "redirect:/logout";
        }
        model.addAttribute("user", user);
        return "new";
    }

    @PostMapping("/add/card")
    public String addCard(@Valid @ModelAttribute("card") Product product, @RequestParam("file") MultipartFile file, HttpSession session, Model model) {
        User user = userService.findOneUser((Long) session.getAttribute("loggedInUserID"));
        if (session.getAttribute("loggedInUserID")==null){
            return "redirect:/logout";
        }

        product.setPhoto(file.getOriginalFilename());
        model.addAttribute("uploadedFile", file);
        product.setUser(user);
        productService.create(product);
        return "redirect:/home";
    }


    @GetMapping("/card/{id}")
    public String cardDetails(@PathVariable("id") Long id, Model model, HttpSession session){
        Long loggedInUserID = (Long) session.getAttribute("loggedInUserID");

        if (loggedInUserID ==null){
            return "redirect:/logout";
        }
        Product product = productService.findProductById(id);
        model.addAttribute("card", product);

        return "details";
    }

    @GetMapping("/card/edit/{id}")
    public String editCard(@PathVariable("id") Long id, Model model, HttpSession session){
        Long loggedInUserID = (Long) session.getAttribute("loggedInUserID");

        if (loggedInUserID ==null){
            return "redirect:/logout";
        }
        Product editProduct = productService.findProductById(id);
        model.addAttribute("editCard", editProduct);

        return "edit";
    }

    @PostMapping("/card/update/{id}")
    public String updateProject(@Valid @ModelAttribute("editProduct") Product editProduct, BindingResult result, Model model, @PathVariable("id") Long id, HttpSession session){
        Long loggedInUserID = (Long) session.getAttribute("loggedInUserID");

        if (loggedInUserID ==null){
            return "redirect:/logout";
        }
        User user = userService.findOneUser((Long) session.getAttribute("loggedInUserID"));
        editProduct.setUser(user);
        productService.updateProduct(editProduct);
        user.getProducts().add(editProduct);
        userService.updateUser(user);
        return "redirect:/home";
    }

    @GetMapping("/card/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id, HttpSession session){
        Long loggedInUserID = (Long) session.getAttribute("loggedInUserID");

        if (loggedInUserID ==null){
            return "redirect:/logout";
        }
        productService.deleteProduct(id);
        return "redirect:/home";
    }
}
