package com.project.scarlet.service.impl;

import com.project.scarlet.dto.HeroLevelDTO;
import com.project.scarlet.enumerate.DifficultyMapXP;
import com.project.scarlet.service.LevelCalculator;
import com.project.scarlet.service.LevelHistoryManagement;
import com.project.scarlet.service.XpManager;
import org.springframework.stereotype.Service;


@Service
public class LevelCalculatorBean implements LevelCalculator {

    private final XpManager xpManager;
    private final LevelHistoryManagement levelHistoryManagement;

    public LevelCalculatorBean(XpManager xpManager, LevelHistoryManagement levelHistoryManagement) {
        this.xpManager = xpManager;
        this.levelHistoryManagement = levelHistoryManagement;
    }

    @Override
    public void calculateLevels(HeroLevelDTO hero) {
        double difficulty = hero.getMapDifficulty().getDifficulty();

        for (int currentLevel = hero.getStartingRound(); currentLevel <= hero.getUntilRound(); currentLevel++) {
            double xp = xpManager.calculateXpForLevel(currentLevel, hero.isAllMonkeyKnowledge(), difficulty);
            xp = xpManager.divideValue(xp, hero.getPlayerAmount());

            xpManager.addHeroXP(hero,xp);
            levelHistoryManagement.addLevelList(hero, currentLevel);
        }
    }
}
