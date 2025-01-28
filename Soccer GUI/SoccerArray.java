import java.util.ArrayList;

// Name: Stephen Lynch
// Date : 22/04/2024
// Function: Create Team and Player array


public class SoccerArray 
{
    private ArrayList<String> teamNames = new ArrayList<>();
    private ArrayList<String> playerNames = new ArrayList<>();

    public SoccerArray() 
    {

        teamNames.add("ManCity");
        teamNames.add("Arsenal");
        teamNames.add("Everton");
        teamNames.add("ManUTD");

        
        playerNames.add("Ramsdale");
        playerNames.add("Tossard");
        playerNames.add("Sacka");
        playerNames.add("Alvarez");
        playerNames.add("Silva");
        playerNames.add("Haaland");
        playerNames.add("Rashford");
        playerNames.add("Maguire");
        playerNames.add("Eriksen");
        playerNames.add("Coleman");
        playerNames.add("Young");
    }

    public boolean addTeam2(String teamAdd) 
    {
        if (teamNames.contains(teamAdd)) 
        {
            System.out.println(teamAdd + "is already here");
            return false;
        }
        else 
        {
            teamNames.add(teamAdd);
            System.out.println(teamAdd + " added");
            return true;
        }
    }

    public boolean removeTeam2(String teamRem) 
    {
        if (teamNames.contains(teamRem)) 
        {
            teamNames.remove(teamRem);
            System.out.println(teamRem + " removed successfully.");
            return true;
        } 
        else 
        {
            System.out.println(teamRem + " not found in the list.");
            return false;
        }
    }


    public boolean addPlayer2(String playerAdd)
    {
        

        if (playerNames.contains(playerAdd)) 
        {
            System.out.println(playerAdd + " is already there");
            return false;
        }
        else 
        {
            playerNames.add(playerAdd);
            System.out.println(playerAdd + " added");
            return true;
        }
        
    }

    public boolean removePlayer2(String playerRem) 
    {
        if (playerNames.contains(playerRem)) 
        {
            playerNames.remove(playerRem);
            System.out.println(playerRem + " removed");
            return true;
        }
        else 
        {
            
            System.out.println(playerRem + " not found in arraylist");
            return false;
            
        }
    }
}

    




    
    
   

