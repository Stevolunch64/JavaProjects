// Name: Stephen Lynch
// Date: 18/11/2024
// Function: Make player class with methods to return values and check hand

import java.util.ArrayList;

public class Player 
{
    //Give name, symbol and arraylist to a player
    private String name;
    private char symbol;
    private ArrayList<String> hand;

    public Player(String name, char symbol) 
    {
        this.name = name;
        this.symbol = symbol;
        this.hand = new ArrayList<>();
    }

    //Method to make the arraylist (hand) for a player
    public ArrayList<String> makeHand(ArrayList<String> deckCombine) 
    {
        //Remove 9 cards from deckCombine and add it to the playerHand arraylist
        for(int i = 0; i < 9; ++i)
        {
                hand.add(deckCombine.remove(0));
        }
            
            return hand;
    }

    
    //Method to return a player's name
    public String getName()
    {
        return name;
    }

    //Method to return a player's hand
    public ArrayList<String> getHand() 
    {
        return hand;
    }

    //Method to return a player's symbol
    public char getSymbol() 
    {
        return symbol;
    }

    //Method to check if a player has a card
    public boolean checkHand(String card) 
    {
        return hand.contains(card);
    }


}
