// Name: Stephen Lynch
// Date: 18/11/2024
// Function: Make Envelope class


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Envelope 
{   
    //Make envelope arraystring
    private ArrayList<String> envelopeCards;

    
    public Envelope(Deck susDeck, Deck driDeck, Deck roomDeck) 
    {
        this.envelopeCards = new ArrayList<>();
        makeEnvelope(susDeck, driDeck, roomDeck);
    }


    //This method adds 1 card each from suspects, drinks and rooms to the envelope
    private void makeEnvelope(Deck susDeck, Deck driDeck, Deck roomDeck) 
    {
        //Add a card from each deck by calling the giveCard() method
        envelopeCards.add(susDeck.giveCard());
        envelopeCards.add(driDeck.giveCard());
        envelopeCards.add(roomDeck.giveCard());
    }


    //Method to return what's in the envelope
    public ArrayList<String> getEnvelopeCards() 
    {
        return envelopeCards;
    }


    //Method to check if a player has guesses the envelope correctly
    public boolean containsCards(String suspect, String drink, String room) 
    { 
        return envelopeCards.contains(suspect) && envelopeCards.contains(drink) && envelopeCards.contains(room);
    }

   
}
