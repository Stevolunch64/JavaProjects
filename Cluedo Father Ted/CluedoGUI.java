// Name: Stephen Lynch
// Date: 02/12/2024
// Function : Make Cluedo GUI class to showcase game

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CluedoGUI extends JFrame 
{

    private Board gameBoard; //Create Board object
    private Player[] players; //Create array of players
    private int currentPlayerIndex; //int to store the current player's index (which player is currently playing)
    private boolean win; //Boolean to see if a win has taken place
    private Dice dice; //Create dice object to roll a dice
    private Envelope envelope; //Create envelope object to store 3 random cards
    private JButton[][] buttons; //Create 2d array to store buttons on the board
    private ArrayList<String> allCards; //Create arraylist to store every card in the game
    private ArrayList<String> deckCombine; //Create arraylist to story all cards to give to players
    private int[][] playerPositions; //Ceate 2d array to store players' positions
    private JLabel remainingMovesLabel; //Create label to show the amount of moves remiaining
    private int remainingMoves; //Int to store the amount of moves remaining
    private JButton checkHandButton; //Button to check a player's hand
    private JButton checkAllButton; //Button to check every card in the game

    public CluedoGUI() 
    {
        gameBoard = new Board();
        players = new Player[]{new Player("Father Ted", 'T'), new Player("Father Dougal", 'D')};//Add players to players array
        currentPlayerIndex = 0;
        win = false;
        dice = new Dice();

        // Create suspects, drinks and room decks
        Suspects suspectsDeck = new Suspects();
        Drinks driDeck = new Drinks();
        Rooms roomsDeck = new Rooms();


        //Make deck object and instantiate it
        Deck deck = new Deck()
        {
            @Override
            public void makeDeck() 
            {
                
            }
        };

        
        //Make deck that contains all cards in the game
        allCards = new ArrayList<>();
        allCards.addAll(suspectsDeck.cards);
        allCards.addAll(driDeck.cards);
        allCards.addAll(roomsDeck.cards);

        envelope = new Envelope(suspectsDeck, driDeck, roomsDeck);//Create envelope, and add 3 random cards to it


        // Print the elements of the envelope (for testing purposes)
        for (String card : envelope.getEnvelopeCards()) 
        {
            System.out.println(card);
        }

        deckCombine = deck.makeTotal(suspectsDeck, driDeck, roomsDeck);//Create combined deck to be given out to players

        
        

        // Create players' hands
        players[0].makeHand(deckCombine);
        players[1].makeHand(deckCombine);

        // Place player marks on the board
        gameBoard.placeMark(players[0], 2, 1);
        gameBoard.placeMark(players[1], 4, 5);

        // Set initial positions for players
        playerPositions = new int[][]{{2, 1}, {4, 5}};

        // Create GUI title, size, layout
        setTitle("Cluedo: Father Ted Edition!");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Display Board in the form of buttons on a 7x7 grid
        JPanel boardPanel = new JPanel(new GridLayout(7, 7));
        buttons = new JButton[7][7];
        
        //Create the buttons using a loop
        for (int i = 0; i < 7; i++) 
        {
            for (int j = 0; j < 7; j++) 
            {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                boardPanel.add(buttons[i][j]);
            }
        }

        //Give each of the rooms a colour
        buttons[0][0].setBackground(Color.RED);
        buttons[0][3].setBackground(Color.ORANGE);
        buttons[0][6].setBackground(Color.YELLOW);
        buttons[3][0].setBackground(Color.GREEN);
        buttons[3][3].setBackground(Color.BLUE);
        buttons[3][6].setBackground(Color.CYAN);
        buttons[6][0].setBackground(Color.MAGENTA);
        buttons[6][3].setBackground(Color.PINK);
        buttons[6][6].setBackground(Color.WHITE);


        //Create another panel to show the remaining moves and player's hand
        JPanel bottomPanel = new JPanel(new BorderLayout());
        remainingMovesLabel = new JLabel("Remaining moves: 0");
        remainingMovesLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        //Create a buttton to check the current player's hand
        checkHandButton = new JButton("Check Hand");
        checkHandButton.setFont(new Font("Arial", Font.PLAIN, 16));
        checkHandButton.addActionListener(e -> showCurrentPlayerHand());

        //Create a buttton to check every card in the game
        checkAllButton = new JButton("All Cards");
        checkAllButton.setFont(new Font("Arial", Font.PLAIN, 16));
        checkAllButton.addActionListener(e -> showAllCards());

        bottomPanel.add(remainingMovesLabel, BorderLayout.WEST);
        bottomPanel.add(checkHandButton, BorderLayout.EAST);
        bottomPanel.add(checkAllButton, BorderLayout.CENTER);

        add(boardPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        rollDice(); // method to roll the dice
        updateBoard();//Method to update the board if changes have taken place
    }

    //Method to roll the dice
    private void rollDice() 
    {
        remainingMoves = dice.roll();//Make remaing moves equal to the dice roll
        updateRemainingMovesLabel();// Call the update method to update the label

        //Print out the value (for testing purposes)
        System.out.println(players[currentPlayerIndex].getName() + " rolled a: " + remainingMoves);
    }

    //Method to update the label showing the moves remaining
    private void updateRemainingMovesLabel() 
    {
        remainingMovesLabel.setText(players[currentPlayerIndex].getName() + " - Remaining moves: " + remainingMoves);
    }

    //Method to update the board when changes take place
    private void updateBoard() 
    {
        //Create a character 2d array that gets the board array
        char[][] boardArray = gameBoard.getBoard();

        //Update each element using nested for loops
        for (int i = 0; i < 7; i++) 
        {
            for (int j = 0; j < 7; j++) 
            {
                buttons[i][j].setText(String.valueOf(boardArray[i][j]));
            }
        }
    }

    //Method to show the player's hand (when the button is clicked)
    private void showCurrentPlayerHand() 
    {

        //Create Player object to represent the current player
        Player currPlayer = players[currentPlayerIndex];

        //Make a stringbuilder to store every card in the player's hand
        StringBuilder hand = new StringBuilder(currPlayer.getName() + "'s Hand:\n");
        
        //Output each card using a for loop
        for (String card : currPlayer.getHand()) 
        {
            hand.append(card).append("\n");
        }
        JOptionPane.showMessageDialog(this, hand.toString(), "Current Player's Hand", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    //Method to show all cards in the game
    private void showAllCards() 
    {
        //Make a stringbuilder to store every card in the player's hand
        StringBuilder all = new StringBuilder("All cards:\n");

        //Output each card using a for loop
        for (String card : allCards) 
        {
            all.append(card).append("\n");
        }
        JOptionPane.showMessageDialog(this, all.toString(), "All Cards", JOptionPane.INFORMATION_MESSAGE);
    }


    //Class to be executed if a button has been clicked
    private class ButtonClickListener implements ActionListener 
    {
        //Create instance variables to store the row and column clicked
        private int row;
        private int col;


        public ButtonClickListener(int row, int col) 
        {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) //Method to be called when an action has taken place
        {   
            //Only excute if the remaining moves are not 0
            if (remainingMoves > 0) 
            {
                //Make player object to represent the current player
                Player currPlayer = players[currentPlayerIndex];

                //Store the player's old position (row and col)
                int oldRow = playerPositions[currentPlayerIndex][0];
                int oldCol = playerPositions[currentPlayerIndex][1];

                //Call the movemark method which returns an int, depending on the validity of the move
                int moveResult = gameBoard.moveMark(currPlayer, oldRow, oldCol, row, col);

                //0 and 1 is returned if the move was valid
                if (moveResult == 0 || moveResult == 1) 
                {
                    //Update the player's position and update the board after
                    playerPositions[currentPlayerIndex][0] = row;
                    playerPositions[currentPlayerIndex][1] = col;
                    updateBoard();

                    //Decrement the remainingMoves variable and update its label
                    remainingMoves--;
                    updateRemainingMovesLabel();

                    //moveResult is 1 if a player has entered a room
                    if (moveResult == 1) 
                    {
                        //Call checkroom method
                        handleAccusation(currPlayer, row, col);
                    } 
                    else if (remainingMoves == 0) 
                    {
                        switchPlayer();
                    }
                } 
                else
                {
                    JOptionPane.showMessageDialog(CluedoGUI.this, "Invalid move. Try again.");
                }
            }
        }
    }


    //Method called when a player enters a room so they can make a guess
    private void handleAccusation(Player player, int row, int col) 
    {
        // The room is based on what room they entered
        String room = gameBoard.checkRoom(row, col);
        System.out.println("Handling accusation for player: " + player.getName());
    
        // Show the player what room they entered
        JOptionPane.showMessageDialog(this, player.getName() + " you entered the " + room);
    
        // Ask player to input a suspect
        String suspect = JOptionPane.showInputDialog(this, player.getName() + ", enter a suspect:");
        if (suspect == null) return; // Handle cancelled input
    
        // Ask player to input a drink
        String drink = JOptionPane.showInputDialog(this, "Enter a drink:");
        if (drink == null) return; // handle cancelled input
    
        // Call containsCards method to see if the player was correct
        if (envelope.containsCards(suspect, drink, room)) 
        {
            // If they are, the player is told that they won
            JOptionPane.showMessageDialog(this, player.getName() + " wins!");
            win = true;
        } 
        else 
        {
            // If they guessed wrong, their guesses are checked in the other player's hand
            Player otherPlayer = players[(currentPlayerIndex + 1) % 2];
            boolean inHand = false;
    
            // Using a loop, the other player's hand is checked for a matching card
            for (String guess : new String[]{suspect, drink, room}) 
            {
                if (otherPlayer.checkHand(guess)) // the checkHand method is called for this
                { 
                    // Show the player the matching card and declare inHand true
                    JOptionPane.showMessageDialog(this, otherPlayer.getName() + " has this card: " + guess);
                    inHand = true;
                    break;
                }
            }
            if (!inHand) // State that the other player has none of the cards if inHand is still false
            { 
                JOptionPane.showMessageDialog(this, otherPlayer.getName() + " has none of those cards.");
            }
        }
    
        // Set remainingMoves to 0 to move to the next player
        remainingMoves = 0;
        updateRemainingMovesLabel();
    
        switchPlayer();
    }
    
    //Method to switch a player's turn
    private void switchPlayer()
    {
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;

        if(!win)
        {
            rollDice();
        }
    }
    

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> 
        {
            CluedoGUI gui = new CluedoGUI();
            gui.setVisible(true);
        });
    }

    //Unique features
    //Player can check all the cards that are in the game with the 'Check All' button.
    //The dice roll is automatic for a player, lessening tedium during play
}

