//Name: Stephen Lynch
//Date: 17/04/2024
//Function: Create Soccer Scoring JFrame

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Comparator;
import java.util.ArrayList;




public class SoccerFrame extends JFrame
{
    private JButton btnHom;
    private JButton btnAwa;
    private JButton btnWin;
    private JButton btnExit;
    private JButton btnAddP;
    private JButton btnRemP;
    private JButton btnAddT;
    private JButton btnRemT;
    private JButton btnGet;

    private JLabel lblWel;
    private JLabel lblScore;
	private JLabel lblNo;
    
    private int homScore;
    private int awaScore;

    private JTextField teamField;
    private JTextField playerField;
    

    private String homTeam = "ManCity";
    private String awaTeam = "Arsenal";
    private String addTeam;
    private String remTeam;
    private String addPlayer;
    private String remPlayer;

    ImageIcon trolley = new ImageIcon("Trolley.png");

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 300;

    

    public SoccerFrame()
    {
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
		getContentPane().setBackground(new Color(0, 0, 255));

    }

    //Contains what occurs when the buttons are clicked    
    class ClickListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            //btnHom and btnAwa add scores to the home/away team
            if (event.getSource() == btnHom)
            {
                homScore++;
            }
            else if (event.getSource() == btnAwa)
            {
                awaScore++;
            }

            lblScore.setText(homTeam + " VS " + awaTeam + "\n" + "    " + homScore + " - "  + awaScore);
       
            //btnWin declares a winner/draw when pressed
            if (event.getSource() == btnWin)
            {
                if (homScore > awaScore)
                {
                    lblScore.setText(homTeam + " won!");
                }
                else if(homScore < awaScore)
                {
                    lblScore.setText(awaTeam + " won!");
                }
                else
                {
                    lblScore.setText("It's a draw!");
                }
            }

            //btnExit exits the program
            if(event.getSource() == btnExit)
            {
                System.exit(0);
            }

            
            //Create a clubArray object (for adding/removing players/teams from the arraylists)
            //Functions in SoccerArray are used to check conditons before adding/removing elements
            SoccerArray clubArray = new SoccerArray();

            
            //btnAddP adds a player to the arraylist
            if (event.getSource() == btnAddP) 
            {
                addPlayer = playerField.getText();
                boolean result = clubArray.addPlayer2(addPlayer);
            
                if (result)
                {
                    playerField.setText(addPlayer + " added!");
                } 
                else 
                {
                    playerField.setText(addPlayer + " already there");
                }
            }
            else if(event.getSource() == btnRemP) //btnRemP removes a player to the arraylist
            {
                remPlayer = playerField.getText();
                boolean result = clubArray.removePlayer2(remPlayer);
                
                if (result)
                {
                    playerField.setText(remPlayer + " removed!");
                } 
                else 
                {
                    playerField.setText(remPlayer + " not there");
                }
                
            }
            

            //btnAddT adds a team to the arraylist
            if(event.getSource() == btnAddT)
            {
                
                addTeam = teamField.getText();
                boolean result = clubArray.addTeam2(addTeam);

                if (result)
                {
                    teamField.setText(addTeam + " added!");
                } 
                else 
                {
                    teamField.setText(addTeam + " already there");
                }

            }
            else if(event.getSource() == btnRemT)//btnAddT removes a team to the arraylist
            {
                remTeam = teamField.getText();
                boolean result = clubArray.removeTeam2(remTeam);
                
                if (result)
                {
                    teamField.setText(remTeam + " removed!");
                } 
                else 
                {
                    teamField.setText(remTeam + " not there");
                }
            }

            //btnGet opens the shop program called VoucherViewer.java
            if(event.getSource() == btnGet)
            {
                runVoucherViewer();
            }
        }
    }


    //All components in the UI are created here
    private void createComponents()
    {
        JPanel panel = new JPanel();

        lblWel = new JLabel("Welcome to the Soccer Scoring System!");
        panel.add(lblWel);

        lblScore = new JLabel(homTeam + " VS " + awaTeam + "\n" + "    " + homScore + " - "  + awaScore);
        panel.add(lblScore);

       btnWin = new JButton("Match End");
        panel.add(btnWin);
		
		btnHom= new JButton("Add Home Score");
        panel.add(btnHom);

        btnAwa = new JButton("Add Away Score");
        panel.add(btnAwa);


        btnAddP = new JButton("Add Player");
        panel.add(btnAddP);
        
		btnRemP = new JButton("Remove Player");
        panel.add(btnRemP);
		
		final int playerWid = 20;
		playerField = new JTextField(playerWid);
		playerField.setText("Enter player here");
        panel.add(playerField);
        
        
        btnAddT = new JButton("Add Team");
        panel.add(btnAddT);
		
		btnRemT = new JButton("Remove Team");
        panel.add(btnRemT);
        
		
		final int teamWid = 20;
		teamField = new JTextField(teamWid);
		teamField.setText("Enter team here");
        panel.add(teamField);
        
        
        lblNo = new JLabel("Each team has 11 players");
        panel.add(lblNo);
        
        
        btnGet = new JButton(trolley);
        panel.add(btnGet);
        
        btnExit = new JButton("Exit");
        panel.add(btnExit);

        
        //Action events are added to all the buttons
        ClickListener listener = new ClickListener();
        btnHom.addActionListener(listener);
        btnAwa.addActionListener(listener);
        btnWin.addActionListener(listener);
        btnExit.addActionListener(listener);
        btnAddP.addActionListener(listener);
        btnRemP.addActionListener(listener);
        btnAddT.addActionListener(listener);
        btnRemT.addActionListener(listener);
        btnGet.addActionListener(listener);


        add(panel);
    }


    //Function used to open the VoucherFrame.java
    private void runVoucherViewer() 
    {
        try 
        {
            String voucherFilePath = "VoucherViewer.java";

            ProcessBuilder processBuilder = new ProcessBuilder("java", voucherFilePath);
            Process process = processBuilder.start();

            int exitCode = process.waitFor();
            System.out.println("VoucherViewer has been exited with code: " + exitCode);
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }

  
}

