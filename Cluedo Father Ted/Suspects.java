// Name: Stephen Lynch
// Date: 14/11/2024
// Function : Make Suspect subclass to Deck class

public class Suspects extends Deck 
{
    public Suspects() 
    {
        super();
        makeDeck();
    }


    // makeDeck method is overridden to make a suspect deck
    @Override
    public void makeDeck() 
    {
        cards.add("Father Ted");
        cards.add("Father Dougal");
        cards.add("Father Jack");
        cards.add("Mrs.Doyle");
        cards.add("Bishop Brennan");
        cards.add("Pat Mustard");
        
        size = cards.size();
    }

}

