// Name: Stephen Lynch
// Date: 14/11/2024
// Function : Make abstract Deck superclass

import java.util.ArrayList; //import Arraylist library
import java.util.Collections; //import collections Library (to shuffle decks)

public abstract class Deck 
{
    protected ArrayList<String> cards;//Make arrayList for card deck
    protected int size;//Make int to store size of deck

    public Deck() 
    {
        cards = new ArrayList<>();
        size = cards.size();
    }

    

    //Method to make the arraylist of all the cards dealable to the players
    public ArrayList<String> makeTotal(Deck susDeck, Deck driDeck, Deck roomDeck) 
    {
        //Make an arraylist to hold all the cards to be given out to the players
        ArrayList<String> deckCombine = new ArrayList<>();
        
        //Add all the elements from each deck to deckCombine
        deckCombine.addAll(susDeck.cards);
        deckCombine.addAll(driDeck.cards);
        deckCombine.addAll(roomDeck.cards);

        //Shuffle deckCombine for extra randomness
        Collections.shuffle(deckCombine);
    
        return deckCombine;
    }

   //Method to return the size of a deck
    public int getSize() 
    {
        return size;
    }

    //Abstract method to make a deck (MUST be used my any subclass)
    public abstract void makeDeck();

    // method to remove one card from the deck (to be given to the envelope)
    public String giveCard()
    {
        Collections.shuffle(cards);//Shuffle the deck to randomly choose a card
        return cards.remove(0); //remove the card from the deck
    }
}
