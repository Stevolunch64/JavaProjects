// Name: Stephen Lynch and Lauren Brampton
// Date: 01/10/24
// Function: Create Simple Minesweeper game (ver 2)

// Import Scanner library
import java.util.Scanner;

import java.util.Random;

public class MinesweeperVer2
{
	static String[] checkInp(String[] nums)
	{
		// Create Scanner class
		Scanner scan = new Scanner(System.in);
		
		//Create random class
		Random rand = new Random();
		
		boolean gamefinish = true;// This will become false when the game finishes
		
		String[] mines = new String[3]; //Create an array for the mine values
			
		
		// Assign random values to the mines array (the prevent the same number being randomnly chosen, each number is generated from different parts of the array)
        mines[0] = nums[rand.nextInt(4)];
		mines[1] = nums[4 + rand.nextInt(4)]; 
		mines[2] = nums[8 + rand.nextInt(8)];
		
		
		
		/* // Print the array of mines
        System.out.println("The mines are: ");
        for (String value : mines) 
		{
            System.out.print(value + " ");
        }*/
		
		
		
		int chicken = 0;//This variable is used to end the game if the user wins
				
		do//game loops until a mine is chosen or all non-mine elements are chosen
		{
			
			
			
			
			
			//Grid of numbers is displayed and input is asked
			System.out.println("[ " +   nums[0]    + " ] [ " +  nums[1]   + " ] [ " +  nums[2]   + " ] [ " +   nums[3]   + " ]");
			System.out.println("[ " +   nums[4]    + " ] [ " +  nums[5]   + " ] [ " +  nums[6]   + " ] [ " +   nums[7]   + " ]");
			System.out.println("[ " +   nums[8]    + " ] [ " +  nums[9]  + " ] [ " + nums[10] + " ] [ " +  nums[11] + " ]");
			System.out.println("[ " +  nums[12]  + " ] [ " + nums[13] + " ] [ " + nums[14] + " ] [ " +  nums[15] + " ]");
			System.out.println("Enter a number you think is NOT a mine");
			System.out.println("Or, enter a unique letter to place a flag");
			String inputt = scan.nextLine();
			
			
			
			
			
		
			// Input is checked if it is not the mine and it is in the array
			
			boolean notMine = true;
			
			for (String element : mines) 
			{
				if (element.equals(inputt))// This is executed if the user inputs the mine number
				{
					System.out.println("KABOOOMMM!!!!! Game Over....");
					
					// Print the array of mines to show the player what the mines were
					System.out.println("The mines are: ");
					for (String value : mines) 
					{
						System.out.print(value + " ");
					}
		
					notMine = false;
					gamefinish = false;
					break;
				}
			}
			
			
			
			
			boolean notGrid = true;
			
			//Input is checked to see if it's on the grid
			for (int i = 0; i < nums.length; i++) 
			{
				if ((nums[i].equals(inputt)) && notMine) 
				{
					System.out.println(inputt + " is in the array");
					nums[i] = "0";
					chicken++;
					notGrid = false;
					break;
				}
				
				
				
				
				//Input is checked if it's a letter for flagging
				boolean isLetter = true;

				for (int j = 0; j < inputt.length(); j++)//A loop to check if the input is NOT a letter
				{
					if (!Character.isLetter(inputt.charAt(j)))
					{
						isLetter = false;
						break;
					}
				}

				if ((isLetter) && (notGrid) && (notMine)) //Gives user the option to flag if the input is a letter, not on the grid and not a mine
				{
					System.out.println("Enter the number you want to flag");
					String inputt2 = scan.nextLine();
					
					
					
					//The inputted number is changed to the inputted letter (the letter shows that an element has been flagged)
					for (int k = 0; k < nums.length; k++) 
					{
						if (nums[k].equals(inputt2)) 
						{
							nums[k] = inputt;
							System.out.println(inputt2 + " has been flagged");
							break;
						}
					}
					
					//Changes the mine number if the player flagged a mine
					for (int m = 0; m < mines.length; m++) 
					{
						if (mines[m].equals(inputt2)) 
						{
							
							mines[m] = inputt;
							break;
						}
					}
					break;
				} 
				
				
				
			}
			
			
			
					
					
				
		
			  
			 
				 
			
			
			
		
			
			
			if(chicken == 13)// This is executed when the user correctly chooses all non-mine integers
			{
				System.out.println("Yippee!! You are safe from harm (for now >:))");
				gamefinish = false;
			}
			
			
		
		}while(gamefinish);
		
		return nums;
	
	}
	
	
	
	
	public static void main(String[] args) 
	{
		// Create numbers to be used on grid
		String nums[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14" ,"15" , "16"};
		
		// Create Scanner class
		Scanner scan = new Scanner(System.in);
		
		//Create random class
		Random rand = new Random();
		
		// Ask user to play game
		boolean playy = true;
		
		do
		{
			//Welcome message displayed and choice to play 
			System.out.println("Welcome to Minesweeper!!");
			System.out.println("1.Play");
			System.out.println("2.Exit");
			
			// Input is taken from user
			int input = scan.nextInt();
			
			if(input == 1)
			{
				playy = false;
				
				checkInp(nums);
			}
			//This executes if the user chooses to exit (for some reason)
			else if(input  == 2)
			{
				playy = false;
				System.out.println("Oh, you're leaving already? Goodbye!");
			}
			else // This executes if an invalid input was received
			{
				System.out.println("Ummm, that's not one of the options :/");
			}
			
		
		}while(playy);

	}
}	