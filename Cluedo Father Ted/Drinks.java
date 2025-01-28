// Name: Stephen Lynch
// Date: 14/11/2024
// Function : Make Drinks subclass to Deck class

public class Drinks extends Deck 
{
    public Drinks() 
    {
        super();
        makeDeck();
    }


    // makeDeck method is overridden to make a drinks deck
    @Override
    public void makeDeck() 
    {
        cards.add("Jameson");
        cards.add("Paddys");
        cards.add("Baileys");
        cards.add("Guinness");
        cards.add("Bulmers");
        cards.add("Beamish");
        size = cards.size();
    }

    
    
}

