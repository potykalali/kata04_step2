package com.potyka.football.model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class FootballLeague {

  private static final Logger logger = Logger.getLogger(FootballLeague.class);

  private List<Team> baseData = new ArrayList<>();

  public void addDailyWeather(Team dailyWeather) {
    this.baseData.add(dailyWeather);
  }

  public String getTeamWithSmallestGoalDifference() {
    String teamWithSmallestDiff = null;
    int smallestDiff = 0;
    for (Team oneTeam : baseData) {

      logger.debug(oneTeam.getName() + " csapatnál a gólkülönbség: " + oneTeam.getGoalDifference());

      if (teamWithSmallestDiff == null
          || oneTeam.getGoalDifference() < smallestDiff) {
        smallestDiff = oneTeam.getGoalDifference();
        teamWithSmallestDiff = oneTeam.getName();
      }
    }

    return teamWithSmallestDiff;
  }

  public void loadFromFile(File dataFile) {
    try {
      for (String oneLine : Files.readAllLines(dataFile.toPath(), StandardCharsets.UTF_8)) {
        if (lineIsDataRecord(oneLine)) {
          Team t = new Team();
          t.create(oneLine);
          baseData.add(t);
        }
      }
    } catch (IOException e) {
      logger.error("Hiba az adatok beolvasása közben!", e);
    }
  }

  private boolean lineIsDataRecord(String oneLine) {
    try {
      return StringUtils.isNumeric(oneLine.replace(" ", "").substring(0, 1));
    } catch (Exception e) {
      return false;
    }
  }
  
}
