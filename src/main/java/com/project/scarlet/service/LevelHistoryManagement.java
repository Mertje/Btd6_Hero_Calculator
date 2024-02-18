package com.project.scarlet.service;

import com.project.scarlet.dto.HeroLevelDTO;

public interface LevelHistoryManagement {

   void addLevelList(HeroLevelDTO hero, int currentLevel);

}
