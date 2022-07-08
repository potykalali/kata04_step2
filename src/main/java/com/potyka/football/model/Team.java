package com.potyka.football.model;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

public class Team {
  
  private static final Logger logger = Logger.getLogger(Team.class);

  //        Team            P     W    L   D    F      A     Pts
  private String name;
  
  private int scoredFor;
  
  private int scoredAgainst;
  
  public Team() {
    
  }
  
  public Team(String name, int scoredFor, int scoredAgainst) {
    super();
    this.name = name;
    this.scoredFor = scoredFor;
    this.scoredAgainst = scoredAgainst;
  }

  public void create(String oneDataRow) {
    try {
      
      List<String> splittedDataRow = Arrays.asList(oneDataRow.trim().replaceAll(" +", " ").split(" "));
      name = splittedDataRow.get(1);
      scoredFor = Integer.valueOf(splittedDataRow.get(6));
      scoredAgainst = Integer.valueOf(splittedDataRow.get(8));
      logger.debug(splittedDataRow);
      
    } catch (Exception e) {
      logger.error("Nem sikerült a sor feldolgozása: " + oneDataRow, e);
    }
  }
  
  
  public int getGoalDifference() {
    return Math.abs(scoredFor-scoredAgainst);
  }

  public String getName() {
    return name;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + scoredAgainst;
    result = prime * result + scoredFor;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Team other = (Team) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (scoredAgainst != other.scoredAgainst)
      return false;
    if (scoredFor != other.scoredFor)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Team [name=" + name + ", scoredFor=" + scoredFor + ", scoredAgainst=" + scoredAgainst + "]";
  }

}
