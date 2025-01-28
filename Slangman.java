//Name: Stephen Lynch
//Date:21/11/2023
//Function: Create a hangman like game


import java.util.Random;
import java.util.Scanner;


public class Slangman
{
    public static void main(String[] args) 
	{
       

	   //Showcasing Arrays, random selection and output
		Scanner scan = new Scanner(System.in);
		String[] words = {"yoke", "gaff", "feck", "slag", "sesh", "scan", "grand", "manky", "gowl" ,"kip","sound", "aye"};
        Random random = new Random();
        int randoms = random.nextInt(words.length);
        String answer = words[randoms];
        
		System.out.println("Welcome to Slangman! Enter a Number to continue");
		System.out.println("1.Play Game");
		System.out.println("2.How to Play");
		System.out.println("3.Encyclopedia (Dont read until after playing game)");
		int select = scan.nextInt();
		
		
		//Selection Structures
		if(select == 1)
		{
			int score = 5;
			int incorrect = 0;
			int counter = 0;
			
			
			//Repition structure
			while(score > 0 && counter < answer.length())
			{
				System.out.println("Score: " + score);
				System.out.println("The word is " + answer.length() + " letters long");
				System.out.println("Enter a letter you think is in the word");
				
				
				char guess = scan.next().charAt(0);
				
				if(answer.contains(Character.toString(guess)))
				{
					//Arithmetic Operation
					counter++;
					score++;
					System.out.println(guess + " is in the word!");
				}
				else
				{
					score--;
					System.out.println("WRONG!");
				}
			
			}
				
				if (score == 0) 
				{ 
					System.out.println("GAME OVER!!! The word was: " + answer); 
					System.out.println("Score: " + score);
				} 
				else
				{
					System.out.println("Congratulations! You correctly guessed the letters for: " + answer ); 
					System.out.println("Score: " + score);
				}
				
		}
			
			
			
		
		else if(select == 2)
		{
			System.out.println("How to play:");
			System.out.println("To play Slangman, enter a letter you think is in a randomly selected word.");
			System.out.println("Your score is your life. You start with a score of 5 and decreases with");
			System.out.println("the more words you guess incorrectly.");
			System.out.println("Your score also increases with every correct answer.");
			System.out.println("If your score goes down to 0, then it's GAME OVER");
			System.out.println("So, ready to play? Just reset this program and press '1'");
	    }	
		else if(select == 3)
		{
			System.out.println("Encyclopedia. See the meaning of the words in this game");
			System.out.println("Yoke: A noun used to name any object a person doesn't know. eg, 'What's that yoke over there?'");
			System.out.println("Gaff: A noun that's a synonym for 'house'. eg 'Let's go down to Sean's gaff.'");
			System.out.println("Feck: A word used to express annoyance or anger. A subsitute for another F word you definitley know already.");
			System.out.println("Slag: A verb that specifically means to make fun of someone/something in a playful/joking manner.");
			System.out.println("Sesh: An abbreviation of 'session', usually used to describe a party happening soon.");
			System.out.println("Scan: A gesture given out by a driver when they see a friend while driving.");
			System.out.println("Grand: A synonym for 'okay', when describing one's feeling or something else.");
			System.out.println("Manky: An adjective meaning disgusting or rotten.");
			System.out.println("Gowl: General term used to call someone an idiot eg 'you're some proper gowl'.");
			System.out.println("Kip: A noun to label a place that looks very poor quality eg 'Herbertstown is a kip'.");
			System.out.println("Sound: A positive adjective for someone or another way of saying 'Thank you'");
			System.out.println("Aye: A comfirmation word that works the same as 'okay' (used mostly in northern Connacht/Ulster).");
		}

    }
}

//Unique features
//1.The words in the game are Irish slang words,instead of completley random words
//2.It has a life system (instead of dawing a man) where it decreases with every wrong guess, and increases with every correct guess
//3.Position of words arent shown to the player (the words are short to balance out the difficuly)
//4.The player can view an encyclopedia, to see the meanings of this game's words
//To add intensity, a player has to input repeated letters again (words are short to balance this out too) 
