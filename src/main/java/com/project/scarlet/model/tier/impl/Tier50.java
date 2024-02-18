package com.project.scarlet.model.tier.impl;


public class Tier50 extends AbstractTier {

    public Tier50() {
        this.setBaseXpSingleLevel(380);
        this.setUntilLevel(50);
        this.setXpPerLevel(40);
    }

    @Override
    public int calculateXpForSingleLevel(int level) {
        return (getXpPerLevel() * level) - getBaseXpSingleLevel();
    }
}
