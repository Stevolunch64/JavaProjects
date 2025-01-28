// Name: Stephen Lynch
// Date: 16/04/2024
// Function: View Jframe Soccer Scoring Program

import javax.swing.JFrame;

public class SoccerViewer
{
    public static void main(String[] args) 
	{
      JFrame frame = new SoccerFrame();
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setVisible(true);
	  frame.setTitle("Soccer Scoring System");
	}
}