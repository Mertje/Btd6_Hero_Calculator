package com.project.scarlet.model.tier.impl;

public class Tier100 extends AbstractTier {

    public Tier100() {
        this.setBaseXpSingleLevel(2880);
        this.setUntilLevel(100);
        this.setXpPerLevel(90);
    }

    @Override
    public int calculateXpForSingleLevel(int level) {
        return (getXpPerLevel() * level) - getBaseXpSingleLevel();
    }
}
