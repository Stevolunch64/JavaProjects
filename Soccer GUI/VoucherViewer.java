// Name: Stephen Lynch
// Date: 16/04/2024
// Function: View Voucher JFrame

import javax.swing.JFrame;

public class VoucherViewer
{
    public static void main(String[] args) 
	{
      JFrame frame = new VoucherFrame();
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setVisible(true);
	  frame.setTitle("Voucher System");
	}
}