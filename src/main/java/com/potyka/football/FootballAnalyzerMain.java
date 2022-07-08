package com.potyka.football;

import com.potyka.football.model.FootballLeague;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * @author horakb
 */
public class FootballAnalyzerMain {

  private static final Logger logger = Logger.getLogger(FootballAnalyzerMain.class);

  public static final File footballDataFile = new File("e:\\_SRC\\git\\kata04_step2\\target\\classes\\football.dat");

  public static void main(String[] args) {

    FootballLeague league = new FootballLeague();
    league.loadFromFile(footballDataFile);
    logger.info("Ennek a csapatnak volt a legkisebb a gólkülönbsége: " + league.getTeamWithSmallestGoalDifference());

  }

}
