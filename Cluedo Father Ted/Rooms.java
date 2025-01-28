// Name: Stephen Lynch
// Date: 14/11/2024
// Function : Make Rooms subclass to Deck class

public class Rooms extends Deck 
{
    public Rooms() 
    {
        super();
        makeDeck();
    }


    // makeDeck method is overridden to make a room deck
    @Override
    public void makeDeck() 
    {
        cards.add("Living Room");
        cards.add("Kitchen");
        cards.add("Hall");
        cards.add("Shed");
        cards.add("Bedroom");
        cards.add("Bathroom");
        cards.add("Garden");
        cards.add("Jacks Bedroom");
        cards.add("Attic");
        
        size = cards.size();
    }

    
}

