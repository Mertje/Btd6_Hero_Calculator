package com.project.scarlet.controller;

import com.project.scarlet.dto.HeroLevelDTO;
import com.project.scarlet.service.HeroHandler;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(("/api/v1/hero_calculate"))
public class HeroCalculationController {

    private final HeroHandler heroHandler;

    public HeroCalculationController(HeroHandler heroHandler) {
        this.heroHandler = heroHandler;
    }

    @PostMapping()
    public String greetingSubmit(@Valid @ModelAttribute HeroLevelDTO heroDetails, Model model) {
        heroHandler.initLevels(heroDetails);
        model.addAttribute("details", heroDetails);
        return "fragments/index/heroResult";
    }
}
