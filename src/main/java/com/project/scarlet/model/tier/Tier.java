package com.project.scarlet.model.tier;

public interface Tier {

    /**
     *  Calculates xp gained for the given level.
     *  Calculation is made for a base hero on a base map
     *
     * @param level the level for the calculation
     * @return Gained XP for that level.
     */
    int calculateXpForSingleLevel(int level);

    /**
     * Get the level in int for the current calculation method.
     *
     * @return int value of the max number for this method
     */
    int getUntilLevel();

}
