package com.project.scarlet.enumerate;


import com.project.scarlet.exception.InvalidFieldException;
import lombok.Getter;

@Getter
public enum DifficultyHeroXP {
    XP_1(1.0),
    XP_1425(1.425),
    XP_15(1.5),
    XP_171(1.71);

    final double heroDifficultyLevel;

    DifficultyHeroXP(double heroDifficultyLevel) {
        this.heroDifficultyLevel = heroDifficultyLevel;
    }

    public static DifficultyHeroXP getDifficulty(Double value) {
        for (DifficultyHeroXP difficulty : DifficultyHeroXP.values()) {
            if (difficulty.getHeroDifficultyLevel() == value ) {
                return difficulty;
            }
        }
        throw new InvalidFieldException("The given difficulty can't be find");
    }
}
