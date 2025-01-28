// Name: Stephen Lynch
// Date: 02/12/2024
// Function : Make Board class

import java.util.ArrayList;

public class Board 
{
    private char[][] board;//2D char array for the board
    private static final int SIZE = 7;
    private static final char empty = '-'; //Empty spaces symbolised by '-'

    // Create the board
    public Board() 
    {
        board = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) 
        {
            for (int j = 0; j < SIZE; j++) 
            {
                board[i][j] = empty;
            }
        }

        // Add the rooms to the board after adding the empty symbols
        board[0][0] = 'L';
        board[0][3] = 'K';
        board[0][6] = 'H';
        board[3][0] = 'S';
        board[3][3] = 'B';
        board[3][6] = 'W';
        board[6][0] = 'G';
        board[6][3] = 'J';
        board[6][6] = 'A';
    }

    // Method to place a player mark on the board at the start of the game
    public boolean placeMark(Player player, int row, int col) 
    {
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == empty) 
        {
            board[row][col] = player.getSymbol();
            return true;
        }
        return false;
    }

    // Method to move the player mark on the board
    public int moveMark(Player player, int currentRow, int currentCol, int newRow, int newCol) 
    {
        // Check if the new position is valid (within board and adjacent)
        if (isValidMove(newRow, newCol, currentRow, currentCol)) 
        {
            // Check if the new position is empty
            if (board[newRow][newCol] == empty) 
            {
                // Update the board with the new player position
                board[currentRow][currentCol] = replaceRoom(currentRow, currentCol);
                board[newRow][newCol] = player.getSymbol();
                return 0;//0 is returned if player moves to empty position
            } 
            else if (board[newRow][newCol] == player.getSymbol()) //Check if the space has a player on it
            {
                // Player lands on an occupied space by another player
                return -1;
            } 
            else if (isRoom(newRow, newCol)) //Check if the space is a room (by calling the isRoom method)
            {
                board[currentRow][currentCol] = replaceRoom(currentRow, currentCol);
                board[newRow][newCol] = player.getSymbol();
                return 1; // Indicate that the player has entered a room
            }
        } 
        else 
        {
            return -1; // Invalid move
        }
        
        return -1; // Player lands on occupied space or invalid move
    }

    // Method to check for valid move (within board and adjacent)
    private boolean isValidMove(int newRow, int newCol, int currentRow, int currentCol) 
    {
        return newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE &&
               (Math.abs(newRow - currentRow) == 1 && currentCol == newCol ||
                Math.abs(newCol - currentCol) == 1 && currentRow == newRow);
    }

    // Method to check if a position is a room
    public boolean isRoom(int row, int col) 
    {
        char cell = board[row][col];
        return cell == 'L' || cell == 'K' || cell == 'H' || cell == 'S' ||
               cell == 'B' || cell == 'W' || cell == 'G' || cell == 'J' || cell == 'A';
    }

    // Method to check what room the player entered, and return a room string
    // (to show the player what room they entered)
    public String checkRoom(int newRow, int newCol) 
    {
        // Check which room was entered
        int roomCode = newRow * 10 + newCol;
        switch (roomCode) 
        {
            case 00:
                return "Living Room";
            case 03:
                return "Kitchen";
            case 06:
                return "Hall";
            case 30:
                return "Shed";
            case 33:
                return "Bedroom";
            case 36:
                return "Bathroom";
            case 60:
                return "Garden";
            case 63:
                return "Jacks Bedroom";
            case 66:
                return "Attic";
            default:
                return null;
        }
    }

    // Method to add the room icon back onto the board after the player leaves a room
    public char replaceRoom(int currentRow, int currentCol) 
    {
        // Check which room is being left
        int roomCode = currentRow * 10 + currentCol;
        switch (roomCode) 
        {
            case 00:
                return 'L';
            case 03:
                return 'K';
            case 06:
                return 'H';
            case 30:
                return 'S';
            case 33:
                return 'B';
            case 36:
                return 'W';
            case 60:
                return 'G';
            case 63:
                return 'J';
            case 66:
                return 'A';
            default:
                return '-';
        }
    }

    // Method to display the board (console-based)
    public void display() 
    {
        for (int i = 0; i < SIZE; i++) 
        {
            for (int j = 0; j < SIZE; j++) 
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to get the board for checking (read-only access)
    public char[][] getBoard() 
    {
        return board;
    }
}
