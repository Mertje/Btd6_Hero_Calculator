package com.project.scarlet.service.impl;

import com.project.scarlet.dto.HeroLevelDTO;
import com.project.scarlet.dto.HeroLevelHistoryRecordDTO;
import com.project.scarlet.enumerate.BaseXP;
import com.project.scarlet.service.LevelHistoryManagement;
import com.project.scarlet.service.XpManager;
import org.springframework.stereotype.Service;

@Service
public class LevelHistoryManagementBean implements LevelHistoryManagement {

    private final XpManager xpManager;

    public LevelHistoryManagementBean(XpManager xpManager) {
        this.xpManager = xpManager;
    }

    @Override
    public void addLevelList(HeroLevelDTO hero, int currentLevel) {
        BaseXP baseXP = hero.getBaseXP();

        if (baseXP == null) {
            return;
        }

        double neededXP = xpManager.multiplyValue(baseXP.getXpNeeded(), hero.getHeroTier().getHeroDifficultyLevel());

        if (neededXP > hero.getGainedXP()) {
            return;
        }

        if (currentLevel == hero.getStartingRound()) {
            currentLevel = currentLevel + 1;
        }

        xpManager.removeHeroXP(hero, neededXP);
        hero.getLevelHistories().add(new HeroLevelHistoryRecordDTO(baseXP.getCurrentLevel() + 1, currentLevel));
        hero.setCalculatedLevel(baseXP.getCurrentLevel() + 1);
        hero.setBaseXP(baseXP.getNext());
    }
}
