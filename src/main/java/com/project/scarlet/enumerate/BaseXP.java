package com.project.scarlet.enumerate;

import lombok.Getter;

@Getter
public enum BaseXP {
    LEVEL_TWO(180, 1),
    LEVEL_TREE(460, 2),
    LEVEL_FOUR(1000, 3),
    LEVEL_FIVE(1860, 4),
    LEVEL_SIX(3280, 5),
    LEVEL_SEVEN(5180, 6),
    LEVEL_EIGHT(8320, 7),
    LEVEL_NINE(9380, 8),
    LEVEL_TEN(13620, 9),
    LEVEL_ELEVEN(16380, 10),
    LEVEL_TWELVE(14400, 11),
    LEVEL_THIRTEEN(16650, 12),
    LEVEL_FOURTEEN(14940, 13),
    LEVEL_FIFTEEN(16380, 14),
    LEVEL_SIXTEEN(17820, 15),
    LEVEL_SEVENTEEN(19260, 16),
    LEVEL_EIGHTEEN(20700, 17),
    LEVEL_NINETEEN(16470, 18),
    LEVEL_TWENTY(17280, 19);

    final int xpNeeded;
    final int currentLevel;

    BaseXP(int xpNeeded, int currentLevel) {
        this.xpNeeded = xpNeeded;
        this.currentLevel = currentLevel;
    }

    public BaseXP getNext() {
        int nextOrdinal = this.ordinal() + 1;
        int maxOrdinal = BaseXP.values().length - 1;

        return nextOrdinal > maxOrdinal ? null : BaseXP.values()[nextOrdinal];
    }

    public static BaseXP getByLevel(int level) {
        for (BaseXP baseXP : BaseXP.values()) {
            if (baseXP.getCurrentLevel() == level) {
                return baseXP;
            }
        }
        return BaseXP.LEVEL_TWO;
    }
}