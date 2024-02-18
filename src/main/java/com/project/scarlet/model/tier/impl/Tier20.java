package com.project.scarlet.model.tier.impl;

public class Tier20 extends AbstractTier {

    public Tier20() {
        this.setBaseXpSingleLevel(20);
        this.setUntilLevel(20);
        this.setXpPerLevel(20);
    }

    @Override
    public int calculateXpForSingleLevel(int level) {
        return getBaseXpSingleLevel() + (getXpPerLevel() * level);
    }



}
