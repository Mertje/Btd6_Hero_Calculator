package com.project.scarlet;

import com.project.scarlet.dto.HeroLevelDTO;

public class DummyHero {

    public static HeroLevelDTO createExpertHero171() {
        return new HeroLevelDTO(
            1.71,
            "expert",
            1,
            100,
            false,
            1,
            1
        );
    }

    public static void heroXPAndDifficultyError() {
        new HeroLevelDTO(
            1.90,
            "dadad",
            1,
            100,
            true,
            1,
            1
        );
    }

}
