package com.project.scarlet.service;

import com.project.scarlet.DummyHero;
import com.project.scarlet.dto.HeroLevelDTO;
import com.project.scarlet.service.impl.XpManagerBean;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XpManagerBeanTest {

    XpManager xpManagerBean = new XpManagerBean();

    @Test
    public void testMultiplyAndDivideValue() {
        double multiplyValue = xpManagerBean.multiplyValue(80, 1.1);
        double dividedValue = xpManagerBean.divideValue(80, 2);

        assertEquals(multiplyValue, 88);
        assertEquals(dividedValue, 40);
    }

    @Test
    public void testAddingAndRemovingHeroXP() {
        HeroLevelDTO hero = DummyHero.createExpertHero171();

        xpManagerBean.addHeroXP(hero, 105);
        assertEquals(hero.getGainedXP(), 105);

        xpManagerBean.removeHeroXP(hero, 100);
        assertEquals(hero.getGainedXP(), 5);
    }

    @Test
    public void testMKWillNotAdd() {
        double valueWithoutMK = xpManagerBean.addMonkeyKnowledge(false, 5000);
        double valueWithMK = xpManagerBean.addMonkeyKnowledge(true, 100);

        assertEquals(valueWithoutMK, 5000);
        assertEquals(valueWithMK, 124);
    }

    @Test
    public void testThatCalculationXPWorksAsExpected(){
        double value = xpManagerBean.calculateXpForLevel(13, true, 1.3);
        assertEquals(value, 453);
    }

}
