package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class CustomerController {
    @GetMapping("/customerForm")
    public String customerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customerForm";
        } else {
            return "processForm";
        }

    }
}
