package com.project.scarlet.service.impl;

import com.project.scarlet.dto.HeroLevelDTO;
import com.project.scarlet.service.TierFactory;
import com.project.scarlet.service.XpManager;
import org.springframework.stereotype.Service;

@Service
public class XpManagerBean implements XpManager {

    private final TierFactory tierFactory = new TierFactoryBean();

    @Override
    public double calculateXpForLevel(int currentLevel, boolean allMonkeyKnowledge, double mapDifficulty) {
        double baseGainedXP = tierFactory.getXpForSingleLevel(currentLevel);
        baseGainedXP = addMonkeyKnowledge(allMonkeyKnowledge, baseGainedXP);

        return multiplyValue(baseGainedXP, mapDifficulty);
    }

    @Override
    public double addMonkeyKnowledge(boolean monkeyKnowledgeEnabled, double baseGainedXP) {
        if (!monkeyKnowledgeEnabled) {
            return baseGainedXP;
        }

        double allMonkeyKnowledge = 1.2474;
        return multiplyValue(baseGainedXP, allMonkeyKnowledge);
    }

    @Override
    public double multiplyValue(double gainedXp, double multiplyBy) {
        return Math.floor(gainedXp * multiplyBy);
    }

    @Override
    public double divideValue(double gainedXp, double divideBy) {
        return Math.floor(gainedXp / divideBy);
    }

    @Override
    public void addHeroXP(HeroLevelDTO hero, double xp) {
        hero.setGainedXP(Math.floor(hero.getGainedXP() + xp));
    }

    @Override
    public void removeHeroXP(HeroLevelDTO hero, double xp) {
        hero.setGainedXP(Math.floor(hero.getGainedXP() - xp));
    }

}
