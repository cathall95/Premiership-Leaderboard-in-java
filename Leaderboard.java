public class Leaderboard
{
  public int gamesPlayed = 0;
  public int homeWins = 0;
  public int homeDraws = 0;
  public int homeLosses = 0;
  public int homeGoalsFor = 0;
  public int homeGoalsAgainst = 0;
  public int awayWins = 0;
  public int awayDraws = 0;
  public int awayLosses = 0;
  public int awayGoalsFor = 0;
  public int awayGoalsAgainst = 0;
  public int goalDifference = 0;
  public int totalPoints = 0;
  public void setGamesPlayed()
  {
  gamesPlayed++;
  }
  public void sethomeWins()
  {
  homeWins++;
  }
  public void sethomeDraws()
  {
  homeDraws++;
  }
  public void setHomeLosses()
  {
  homeLosses++;
  }
  public void setHomeGoalsFor(int homeGoalFor)
  {
  homeGoalsFor = homeGoalsFor + homeGoalFor;
  }
  public void setHomeGoalsAgainst(int homeGoalAgainst)
  {
  homeGoalsAgainst = homeGoalsAgainst + homeGoalAgainst;
  }
  public void setawayWins()
  {
  awayWins++;
  }
  public void setawayDraws()
  {
  awayDraws++;
  }
  public void setawayLosses()
  {
  awayLosses++;
  }
  public void setAwayGoalsFor(int awayGoalFor)
  {
  awayGoalsFor = awayGoalsFor + awayGoalFor;
  }
  public void setAwayGoalsAgainst(int awayGoalAgainst)
  {
  awayGoalsAgainst = awayGoalsAgainst + awayGoalAgainst;
  }
  public void setGoalsDifference(int GoalsDifference)
  {
  goalDifference = GoalsDifference;
  }
  public void setTotalPoints(int Points)
  {
  totalPoints += Points;
  }
  public int getGamesPlayed()
  {
  return gamesPlayed;
  }
  public int getHomeWins()
  {
  return homeWins;
  }
  public int getHomeDraws()
  {
  return homeDraws;
  }
  public int getHomeLosses()
  {
  return homeLosses;
  }
  public int getHomeGoalsFor()
  {
  return homeGoalsFor;
  }
  public int getHomeGoalsAgainst()
  {
  return homeGoalsAgainst;
  }
  public int getAwayWins()
  {
  return awayWins;
  }
  public int getAwayDraws()
  {
  return awayDraws;
  }
  public int getAwayLosses()
  {
  return awayLosses;
  }
  public int getAwayGoalsFor()
  {
  return awayGoalsFor;
  }
  public int getAwayGoalsAgainst()
  {
  return awayGoalsAgainst;
  }
  public int getGoalsDifference()
  {
  return goalDifference;
  }
  public int getTotalPoints()
  {
  return totalPoints;
  }
}