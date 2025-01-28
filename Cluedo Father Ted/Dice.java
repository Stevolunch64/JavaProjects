// Name: Stephen Lynch
// Date : 19/11/2024
// Function : Make Dice class to make random number


import java.util.Random;

public class Dice 
{
    // Make random object
    private Random rand;

    public Dice() 
    {
        this.rand = new Random();
    }

    //roll method to generate an int between 1 and 6 inclusive
    public int roll() 
    {
        return rand.nextInt(6) + 1; 
    }

}
