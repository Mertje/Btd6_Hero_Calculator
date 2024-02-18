package com.project.scarlet.service;

import com.project.scarlet.DummyHero;
import com.project.scarlet.dto.HeroLevelDTO;
import com.project.scarlet.dto.HeroLevelHistoryRecordDTO;
import com.project.scarlet.enumerate.BaseXP;
import com.project.scarlet.service.impl.LevelHistoryManagementBean;
import com.project.scarlet.service.impl.XpManagerBean;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LevelHistoryCalculatorTest {

    LevelHistoryManagement levelHistoryManagementBean = new LevelHistoryManagementBean(new XpManagerBean());

    @Test
    void testHeroHistoryAddsRight() {
        HeroLevelDTO hero = DummyHero.createExpertHero171();
        hero.setGainedXP(5000);

        levelHistoryManagementBean.addLevelList(hero, 23);

        assertEquals(hero.getBaseXP(), BaseXP.LEVEL_TREE);
        assertEquals(new HeroLevelHistoryRecordDTO(2, 23), hero.getLevelHistories().getFirst());
        assertEquals(hero.getCalculatedLevel(), 2);
        assertEquals(hero.getGainedXP(), 4693);
    }
}
