package com.project.scarlet.dto;


import com.project.scarlet.enumerate.BaseXP;
import com.project.scarlet.enumerate.DifficultyHeroXP;
import com.project.scarlet.enumerate.DifficultyMapXP;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
public class HeroLevelDTO {
    private final DifficultyMapXP mapDifficulty;
    private final DifficultyHeroXP heroTier;
    private final int startingRound;
    private final boolean allMonkeyKnowledge;
    private final ArrayList<HeroLevelHistoryRecordDTO> levelHistories;
    private final int playerAmount;

    @Setter
    private int calculatedLevel;
    @Setter
    private BaseXP baseXP;
    @Setter
    private double gainedXP;
    @Setter
    private int untilRound;

    public HeroLevelDTO(
            double heroTier,
            String mapDifficulty,
            int startingRound,
            int untilRound,
            boolean allMonkeyKnowledge,
            int startingLevel,
            int playerAmount
        ) {
        this.heroTier = DifficultyHeroXP.getDifficulty(heroTier);
        this.mapDifficulty = DifficultyMapXP.getByLevel(mapDifficulty);
        this.startingRound = startingRound;
        this.untilRound = untilRound;
        this.allMonkeyKnowledge = allMonkeyKnowledge;
        this.levelHistories = new ArrayList<>();
        this.baseXP = BaseXP.getByLevel(startingLevel);
        this.playerAmount = playerAmount;
    }

}
