import java.io.*;
import java.util.*;
import javax.swing.*;
public class Project4
{
  public static void main(String [] args) throws IOException
  {
   	boolean continuePlaying = true;
   	ArrayList<String> Outcome = new ArrayList<String>(); //setting up several array lists to store files
  	ArrayList<String> fixture = new ArrayList<String>();
  	ArrayList<String> name = new ArrayList<String>();
   	ArrayList<String> teamName = new ArrayList<String>();
   	ArrayList<Integer> teamNumber= new ArrayList<Integer>();
  	String temp,temporary,temps;
   	String [] split = new String[2];
   	File Results = new File("PremiershipResults.txt"); //setting up the Results file
   	Scanner keyboard = new Scanner(Results);
  		while(keyboard.hasNext()) //Reading the file
  			{
	 		temp = keyboard.nextLine();
	 		Outcome.add(temp); 	
  			}
  		keyboard.close();
  	File fixturesFile = new File("PremiershipFixtures.txt"); //setting up the Fixtures file
   	Scanner in = new Scanner(fixturesFile);
  		while(in.hasNext()) //Reading the file
  			{
			 temporary = in.nextLine();
	 	     fixture.add(temporary); 	
  			}
  		in.close();
  	File names = new File("PremiershipTeamsOrPlayers.txt"); //setting up the Names file
   	Scanner input = new Scanner(names);
  		while(input.hasNext()) //Reading the file
  			{
	 		temps = input.nextLine();
	 		name.add(temps); 	
  			}
  		input.close();
  			for(int counter = 0;counter<name.size();counter++)
  				{
	 			split = (name.get(counter)).split(",");
	 			teamName.add(split[1]); //putting the team names into an ArrayList
	 			teamNumber.add(Integer.parseInt(split[0])); 	
  				}
  	ArrayList<Integer> homeNum = new ArrayList<Integer>(); //setting up ArrayLists 
  	ArrayList<Integer> awayNum = new ArrayList<Integer>();
  	ArrayList<Integer> homeScore = new ArrayList<Integer>();
  	ArrayList<Integer> awayScore = new ArrayList<Integer>();
  	String [] splits = new String [3];
  	String [] splitst = new String [3];
  		for(int counter = 0;counter<fixture.size();counter++) //splitting up the data from files into their own arrayLists
  			{
	 		splits = (fixture.get(counter)).split(",");
	 		homeNum.add(Integer.parseInt(splits[1]));
			awayNum.add(Integer.parseInt(splits[2]));	
  			}
  		for(int counter = 0;counter<Outcome.size();counter++)
  			{
	 		splitst = (Outcome.get(counter)).split(",");
			homeScore.add(Integer.parseInt(splitst[1]));
	 		awayScore.add(Integer.parseInt(splitst[2]));	
  			}
  	ArrayList<TeamOrPlayer> aTeam = new ArrayList<TeamOrPlayer>(); //putting all of the data from files into their own objects
  		for(int  counter = 0;counter<teamName.size();counter++)
 			{
 			TeamOrPlayer aTeamEntry = new TeamOrPlayer();
  			aTeam.add(aTeamEntry);
  			(aTeam.get(counter)).setNumber(counter + 1);	
  			(aTeam.get(counter)).setName(teamName.get(counter));	  
  			}
  	ArrayList<Fixture> aFixture = new ArrayList<Fixture>();
  		for(int  counter = 0;counter<fixture.size();counter++) //putting all of the data from files into their own objects
  			{
  			Fixture aFixtureEntry = new Fixture();
  			aFixture.add(aFixtureEntry);
  			(aFixture.get(counter)).setFixtureNumber(counter + 1);	
  			(aFixture.get(counter)).setHomeNumber(homeNum.get(counter));	
  			(aFixture.get(counter)).setAwayNumber(awayNum.get(counter));	   
  			}
  	ArrayList<Outcome> aOutcome = new ArrayList<Outcome>();
  		for(int  counter = 0;counter<Outcome.size();counter++) //putting all of the data from files into their own objects
  			{
  			Outcome aOutcomeEntry = new Outcome();
  			aOutcome.add(aOutcomeEntry);
  			(aOutcome.get(counter)).setFixtureNumber(counter + 1);	
  			(aOutcome.get(counter)).setHomeScore(homeScore.get(counter));	
  			(aOutcome.get(counter)).setAwayScore(awayScore.get(counter));	   
  			}
  	Object[] menuItems1 = {"Run", "Quit"}; //setting up the menu
    Object selectedValue1 = JOptionPane.showInputDialog(null,"Choose one", "Input", 1, null, menuItems1, menuItems1[0]);
		if (selectedValue1 == null || selectedValue1.equals("Quit")) //allowing the user to quit
	  		continuePlaying = false;
				else if (selectedValue1.equals("Run"))
					{
	  					while(continuePlaying) //making sure the user doesn't leave the program until they choose to
	  						{
							Object[] menuItems = {"View a list of fixures played to date", "View a list of fixtures yet to be played","View an up to date leaderboard of the league","Quit"};
        					Object selectedValue = JOptionPane.showInputDialog(null,"Choose one","Run Again?", 1, null, menuItems, menuItems[0]);
	    						if (selectedValue == null || selectedValue.equals("Quit")) //allowing the user to exit
	      							continuePlaying = false;
	    								else if(selectedValue.equals("View a list of fixures played to date")) //deciding which method to run
											{
	     									Outcomes(teamName,aOutcome,aFixture);
											}
												else if(selectedValue.equals("View a list of fixtures yet to be played"))
													{
	    				 							futureFixtures(teamName,aOutcome,aFixture);
													}
														else if(selectedValue.equals("View an up to date leaderboard of the league"))
															{
	     													leaderboards(teamName,aOutcome,aFixture,awayScore,homeScore,awayNum,homeNum);
															}
	  						}  
						}
  }
  
  public static void Outcomes(ArrayList<String> teamName,ArrayList<Outcome> aOutcome,ArrayList<Fixture> aFixture) //a method for displaying all results so far
  {
  	System.out.println("\nResults from fixtures played so far:\n\n");
  	for(int counter = 0;counter<aOutcome.size();counter++) //printing out the results
  		{
			int fixtureNum = (aOutcome.get(counter)).getFixturesNumber(); //getting the values to print out
			int homeN = (aFixture.get(counter)).getHomeNumber();
			int awayN = (aFixture.get(counter)).getAwayNumber();
			String homeT = teamName.get(homeN - 1);
			String awayT = teamName.get(awayN - 1);
			int hScore = (aOutcome.get(counter)).getHomeScore();
			int aScore = (aOutcome.get(counter)).getAwayScore();
			String a = homeT + " vs. " + awayT;
			String b = "Result: " + hScore + "-" + aScore;
			String templates = "%-4d %-45s %-12s";
			System.out.printf(templates,fixtureNum,a,b); //printing out the results
			System.out.println();
  	}	
 	 System.out.println();
 	 System.out.println();  
  }
  
  public static void futureFixtures(ArrayList<String> teamName,ArrayList<Outcome> aOutcome,ArrayList<Fixture> aFixture) //a method for displaying all fixtures yet to be played
  {
  	int start = aOutcome.size();
 	 System.out.println("\nFixtures yet to be played:\n\n");
  		for(int counter = start;counter<aFixture.size();counter++) //printing out the future fixtures
  			{
 			 int fixtureNum = (aFixture.get(counter)).getFixtureNumber(); //getting the values to print out
  			 int homeN = (aFixture.get(counter)).getHomeNumber();
  			 int awayN = (aFixture.get(counter)).getAwayNumber();
 			 String homeT = teamName.get(homeN - 1);
 			 String awayT = teamName.get(awayN - 1);
 			 System.out.print(fixtureNum + "  " + homeT + " vs. " + awayT);
			 System.out.println();	  
 			}
  	System.out.println();
  	System.out.println();	  
  }
  
  public static void leaderboards(ArrayList<String> teamName,ArrayList<Outcome> aOutcome,ArrayList<Fixture> aFixture,
  ArrayList<Integer> awayScore,ArrayList<Integer> homeScore,ArrayList<Integer> awayNum,ArrayList<Integer> homeNum) // method to display a leaderboard for the league
  {
  	int tem,temps;
  	ArrayList<Leaderboard> aLeaderboard = new ArrayList<Leaderboard>(); //putting data into the leaderboard object
 		 for(int  counter = 0;counter<teamName.size();counter++)
 			 {
 				 Leaderboard aLeaderboardEntry = new Leaderboard();
 				 aLeaderboard.add(aLeaderboardEntry);	  
 			 }
 		 for(int counter = 0;counter<aOutcome.size();counter++) //adding to games played for both teams
  			{
  			tem = (aFixture.get(counter)).getHomeNumber();
  			temps = (aFixture.get(counter)).getAwayNumber();
 			 (aLeaderboard.get(tem - 1)).setGamesPlayed();	 
 			 (aLeaderboard.get(temps - 1)).setGamesPlayed(); 
 			 }
  	ArrayList<Results> aResult = new ArrayList<Results>();
  		for(int  counter = 0;counter<aOutcome.size();counter++) //creating an object with both fixtures and results
  			{
 			 Results aResultsEntry = new Results();
  			 aResult.add(aResultsEntry);
  			(aResult.get(counter)).setFixtureNumber(counter + 1);
  			(aResult.get(counter)).setHomeNumber(homeNum.get(counter));	
 		    (aResult.get(counter)).setAwayNumber(awayNum.get(counter));	
 			(aResult.get(counter)).setHomeScore(homeScore.get(counter));	
 			(aResult.get(counter)).setAwayScore(awayScore.get(counter));	   
 			}
 		for(int counter = 0;counter<aResult.size();counter++) //adding the rest of the data to the leaderboard
  			{
 			 if(((aResult.get(counter)).getHomeScore()) > ((aResult.get(counter)).getAwayScore())) //adding data if the home team wins
 				 {
 				 (aLeaderboard.get(((aResult.get(counter)).getHomeNumber())- 1)).sethomeWins();
  				 (aLeaderboard.get(((aResult.get(counter)).getHomeNumber())- 1)).setTotalPoints(3);
 				 (aLeaderboard.get(((aResult.get(counter)).getAwayNumber())- 1)).setawayLosses();
 				 }
  			else if(((aResult.get(counter)).getHomeScore()) == ((aResult.get(counter)).getAwayScore())) //adding data if they draw
  				{
  				(aLeaderboard.get(((aResult.get(counter)).getHomeNumber())- 1)).sethomeDraws();
  				(aLeaderboard.get(((aResult.get(counter)).getHomeNumber())- 1)).setTotalPoints(1);	
  				(aLeaderboard.get(((aResult.get(counter)).getAwayNumber()) - 1)).setawayDraws();
  				(aLeaderboard.get(((aResult.get(counter)).getAwayNumber())- 1)).setTotalPoints(1);
  				}
  		    else if(((aResult.get(counter)).getHomeScore()) < ((aResult.get(counter)).getAwayScore())) //adding data if the away team wins
  				{
  				(aLeaderboard.get(((aResult.get(counter)).getHomeNumber())- 1)).setHomeLosses();
  				(aLeaderboard.get(((aResult.get(counter)).getAwayNumber())- 1)).setawayWins();
  				(aLeaderboard.get(((aResult.get(counter)).getAwayNumber())- 1)).setTotalPoints(3);
  				}  
  		 }
  	   for(int counter = 0;counter<aResult.size();counter++) //adding data for goals scored and goals let in for both teams
  			{
			(aLeaderboard.get(((aResult.get(counter)).getHomeNumber())- 1)).setHomeGoalsFor((aResult.get(counter)).getHomeScore()); 
			(aLeaderboard.get(((aResult.get(counter)).getHomeNumber())- 1)).setHomeGoalsAgainst((aResult.get(counter)).getAwayScore());
			(aLeaderboard.get(((aResult.get(counter)).getAwayNumber())- 1)).setAwayGoalsFor((aResult.get(counter)).getAwayScore()); 
			(aLeaderboard.get(((aResult.get(counter)).getAwayNumber())- 1)).setAwayGoalsAgainst((aResult.get(counter)).getHomeScore()); 
  			}
  		for(int counter = 0;counter<aLeaderboard.size();counter++) //adding data for goals difference
  			{
  			int goalsFor = (aLeaderboard.get(counter)).getHomeGoalsFor() + (aLeaderboard.get(counter)).getAwayGoalsFor();
 			int goalsAgainst = (aLeaderboard.get(counter)).getHomeGoalsAgainst() + (aLeaderboard.get(counter)).getAwayGoalsAgainst();	 
  			int goalDifference = goalsFor - goalsAgainst;
  			(aLeaderboard.get(counter)).setGoalsDifference(goalDifference); 
  			}
  	ArrayList<Integer> points = new ArrayList<Integer>(); 
 		 for(int counter = 0;counter<aLeaderboard.size();counter++) //getting the position of each team
  			points.add((aLeaderboard.get(counter)).getTotalPoints());	  
  	HashSet<Integer> hs = new HashSet<Integer>();
 	 hs.addAll(points);
 	 points.clear();
  	points.addAll(hs);
  	Collections.sort(points);
  	Collections.reverse(points);
  	ArrayList<Integer> position = new ArrayList<Integer>();
  		for(int counter = 0;counter<points.size();counter++)
  			{
  				for(int count = 0;count<aLeaderboard.size();count++)
  					{
  						if((aLeaderboard.get(count)).getTotalPoints() == points.get(counter))
  							position.add(count);  
  					}	  
  			}
  	int pos = 0;
  	String titleTemplate = "%-5s %-23s %-15s %-12s %-13s %-14s %-17s %-20s %-12s %-13s %-14s %-17s %-20s %-17s %-15s%n"; //setting up templates for printing out
  	String template = "%-5d %-23s %-15d %-12d %-13d %-14d %-17d %-20d %-12d %-13d %-14d %-17d %-20d %-17d %-15d%n";
  	System.out.printf(titleTemplate,"Pos.","Team","Games Played","Home Wins","Home Draws","Home Losses","Home Goals For","Home Goals Against",
  	"Away Wins","Away Draws","Away Losses","Away Goals For","Away Goals Against","Goal Difference","Total Points"); // printing out the title
  		for(int counter = 0;counter<teamName.size();counter++)
 	 		{
	 		pos = position.get(counter);
  		    System.out.printf(template,(counter + 1),teamName.get(pos),(aLeaderboard.get(pos)).getGamesPlayed(),(aLeaderboard.get(pos)).getHomeWins(), //printing out the data for each team
  		   (aLeaderboard.get(pos)).getHomeDraws(),(aLeaderboard.get(pos)).getHomeLosses(),
  		   (aLeaderboard.get(pos)).getHomeGoalsFor(),(aLeaderboard.get(pos)).getHomeGoalsAgainst(),(aLeaderboard.get(pos)).getAwayWins(),(aLeaderboard.get(pos)).getAwayDraws(),
  		   (aLeaderboard.get(pos)).getAwayLosses(),(aLeaderboard.get(pos)).getAwayGoalsFor(),
  		   (aLeaderboard.get(pos)).getAwayGoalsAgainst(),(aLeaderboard.get(pos)).getGoalsDifference(),(aLeaderboard.get(pos)).getTotalPoints());
  		   System.out.println();
  	        }
  	System.out.println();
 	System.out.println();
  }
}