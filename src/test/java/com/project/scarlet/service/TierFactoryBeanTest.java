package com.project.scarlet.service;

import com.project.scarlet.service.impl.TierFactoryBean;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TierFactoryBeanTest {

    TierFactory tierFactory = new TierFactoryBean();

    @Test
    public void testRightXpRound18() {
        int xpForSingleLevel = tierFactory.getXpForSingleLevel(18);

        int xpLevel18 = 380;
        assertEquals(xpForSingleLevel, xpLevel18);
    }

    @Test
    public void testRightXpRound25() {
        int xpForSingleLevel = tierFactory.getXpForSingleLevel(25);

        int xpLevel18 = 620;
        assertEquals(xpForSingleLevel, xpLevel18);
    }

    @Test
    public void testRightXpRound89() {
        int xpForSingleLevel = tierFactory.getXpForSingleLevel(89);

        int xpLevel89 = 5130;
        assertEquals(xpForSingleLevel, xpLevel89);
    }

}
