package com.project.scarlet.service;

import com.project.scarlet.dto.HeroLevelDTO;

public interface XpManager {

    void addHeroXP(HeroLevelDTO hero, double xp);

    void removeHeroXP(HeroLevelDTO hero, double xp);

    double multiplyValue(double gainedXp, double multiplyBy);

    double divideValue(double gainedXp, double divideBy);

    double calculateXpForLevel(int currentLevel, boolean allMonkeyKnowledge, double mapDifficulty);

    double addMonkeyKnowledge(boolean monkeyKnowledgeEnabled, double baseGainedXP);
}
