package com.project.scarlet.enumerate;

import com.project.scarlet.exception.InvalidFieldException;
import lombok.Getter;

@Getter
public enum DifficultyMapXP  {
    beginner(1),
    intermediate (1.1),
    advanced(1.2),
    expert(1.3);

    final double difficulty;

    DifficultyMapXP(double difficultyValue) {
        this.difficulty = difficultyValue;
    }

    public static DifficultyMapXP getByLevel(String name) {
        for (DifficultyMapXP difficulty : DifficultyMapXP.values()) {
            if (difficulty.name().equals(name)) {
                return difficulty;
            }
        }
        throw new InvalidFieldException("The given difficulty can't be find");
    }
}
