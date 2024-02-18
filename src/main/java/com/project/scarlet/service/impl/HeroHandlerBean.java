package com.project.scarlet.service.impl;

import com.project.scarlet.dto.HeroLevelDTO;
import com.project.scarlet.exception.InvalidFieldException;
import com.project.scarlet.service.HeroHandler;
import com.project.scarlet.service.LevelCalculator;
import org.springframework.stereotype.Service;


@Service
public class HeroHandlerBean implements HeroHandler {

    private final LevelCalculator levelCalculatorBean;

    public HeroHandlerBean(LevelCalculator levelCalculatorBean) {
        this.levelCalculatorBean = levelCalculatorBean;
    }

    @Override
    public void initLevels(HeroLevelDTO hero) {
        checkFieldStartingUntil(hero);
        setUntilLevelMaxDifference(hero);
        levelCalculatorBean.calculateLevels(hero);
    }

    private void checkFieldStartingUntil(HeroLevelDTO hero) {
        if (hero.getStartingRound() >= hero.getUntilRound()) {
            throw new InvalidFieldException("The starting round can't be bigger then the until round");
        }
    }

    private void setUntilLevelMaxDifference(HeroLevelDTO hero) {
        int maxLooping = 200;
        int levelDifference = hero.getUntilRound() - hero.getStartingRound();

        if (levelDifference > maxLooping) {
            int newUntilRound = hero.getStartingRound() + maxLooping;
            hero.setUntilRound(newUntilRound);
        }
    }
}
