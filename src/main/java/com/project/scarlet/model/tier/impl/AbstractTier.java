package com.project.scarlet.model.tier.impl;

import com.project.scarlet.model.tier.Tier;
import lombok.Data;

@Data
public abstract class AbstractTier implements Tier {
    private int xpPerLevel;
    private int baseXpSingleLevel;
    private int untilLevel;
}
