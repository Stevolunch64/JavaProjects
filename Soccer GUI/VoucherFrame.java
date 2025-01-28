//Name: Stephen Lynch
//Date: 17/04/2024
//Function: Create Voucher JFrame

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class VoucherFrame extends JFrame
{
    private JButton btnBuy;
    private JButton btnDis;
    private JButton btnExit;
   

    private JLabel lblWel;
	private JLabel lblDesc;
	private JLabel lblDis;
	private JLabel lblMes;
    private JLabel lblImg;
    
    private double price = 60;
    private double code = 1257;

    private JTextField codeField;
    
    ImageIcon jersey = new ImageIcon("Jersey.jpg"); //Image of Jersey is initialised here


    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 500;

    public VoucherFrame()
    {
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }


    //What happens when buttons are clicked are mentioned here
    class ClickListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {   

            //btnBuy "buys" the jersey if clicked
            if (event.getSource() == btnBuy)
            {
              lblDesc.setText("Jersey bought for $" + price);
            }
           
            
            //btnDis checks if the discount code matches, and applies the discount if it is
			if (event.getSource() == btnDis)
            {
				double vouInput = Double.parseDouble(codeField.getText());
				
				if(vouInput == code)
				{
					price = price/2;
					lblDesc.setText("Price: $" + price);
					lblMes.setText("Discount Applied");
				}
				else
				{
					lblMes.setText("Voucher Code Incorrect");
				}
            }
			

            //btnExit exits the program
			if (event.getSource() == btnExit)
            {
              System.exit(0);
            }
        
		}
    } 

    //Buttons, labels and other elements are created here
    private void createComponents()
    {
        JPanel panel = new JPanel();

        lblWel = new JLabel("Get your jersey here!");
		panel.add(lblWel);
		
		
		lblDesc = new JLabel("Arsenal Jersey");
        panel.add(lblDesc);
		
		lblDesc = new JLabel("Price: $" + price);
        panel.add(lblDesc);

		btnBuy = new JButton("Buy Jersey");
        panel.add(btnBuy);

        lblImg = new JLabel(jersey);
        panel.add(lblImg);

        lblDis = new JLabel("Secret Discount code: " + code);
        panel.add(lblDis);
		
		lblMes = new JLabel("Get a 50% discount when using this code!");
        panel.add(lblMes);

       
        final int codeWid = 10;
		codeField = new JTextField(codeWid);
		codeField.setText("[CODE]");
        panel.add(codeField);
        
		btnDis = new JButton("Add Discount");
        panel.add(btnDis);

		btnExit = new JButton("Exit");
        panel.add(btnExit);
        
		
		

        
       ClickListener listener = new ClickListener();
        btnBuy.addActionListener(listener);
        btnDis.addActionListener(listener);
        btnExit.addActionListener(listener); 


        add(panel);
    }
}//Image taken from unsplash
