package com.project.scarlet.service.impl;

import com.project.scarlet.model.tier.Tier;
import com.project.scarlet.model.tier.impl.Tier100;
import com.project.scarlet.model.tier.impl.Tier20;
import com.project.scarlet.model.tier.impl.Tier50;
import com.project.scarlet.service.TierFactory;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TierFactoryBean implements TierFactory {

    private final Tier tier20 = new Tier20();
    private final Tier tier50 = new Tier50();
    private final Tier tier100 = new Tier100();

    @Override
    public int getXpForSingleLevel(int level) {

        if (level <= tier20.getUntilLevel()) {
            return tier20.calculateXpForSingleLevel(level);
        } else if (level <= tier50.getUntilLevel()) {
            return tier50.calculateXpForSingleLevel(level);
        }

        return tier100.calculateXpForSingleLevel(level);
    }

}
