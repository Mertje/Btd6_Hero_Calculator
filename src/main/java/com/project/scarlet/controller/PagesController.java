package com.project.scarlet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class PagesController {

    @GetMapping("/")
    public String home() {
        return "pages/index";
    }

}
