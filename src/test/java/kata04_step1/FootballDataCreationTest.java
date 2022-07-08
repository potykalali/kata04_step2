package kata04_step1;

import static org.junit.Assert.assertEquals;

import com.potyka.football.model.Team;

import org.apache.log4j.Logger;
import org.junit.Test;

public class FootballDataCreationTest {

  private static final Logger logger = Logger.getLogger(FootballDataCreationTest.class);

  @Test
  public void testCreate() {
    String oneLine = "    1. Arsenal         38    26   9   3    79  -  36    87";
    Team teamParsed = new Team();
    teamParsed.create(oneLine);
    logger.debug(teamParsed);

    Team teamOK = new Team("Arsenal", 79, 36);
    logger.debug(teamOK);

    assertEquals(teamOK, teamParsed);
    
  }

}
