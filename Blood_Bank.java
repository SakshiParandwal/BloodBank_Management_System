package pkg1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Blood_Bank {
	static JFrame frame;
	private static JTextField textField_donor_id;
	private static JTextField textField_bloodBankId;
	private static JTextField textField_bloodBankName;
	private static JTextField textField_bloodBankAddr;
	private static JTextField textField_stk_id;
	private static JLabel donor_id;
	private static JLabel bloodBank_name;
	private static JLabel bloodBank_addr;
	private static JLabel stk_id;
	private static JButton btn1;
	
	public static void Blood_Bank_Registration()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 192, 203));
	    frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
	    frame.getContentPane().setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("Enter Following Details Correctly");
	    lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 30));
	    lblNewLabel.setBounds(121, 38, 604, 56);
	    frame.getContentPane().add(lblNewLabel);
	    
	    JLabel bloodbank_id = new JLabel("Blood Bank Id : ");
	    bloodbank_id.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    bloodbank_id.setBounds(181, 132, 136, 24);
	    frame.getContentPane().add(bloodbank_id);
	    
	    JLabel donor_id = new JLabel("Donor Id : ");
	   donor_id.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    donor_id.setBounds(181, 100, 136, 24);
	    frame.getContentPane().add(donor_id);
	    
	    textField_donor_id=new JTextField();
	    textField_donor_id.setBounds(376, 95, 274, 29);
	    frame.getContentPane().add(textField_donor_id);
	    textField_donor_id.setColumns(10);
	    
	    textField_bloodBankId = new JTextField();
	    textField_bloodBankId.setBounds(376, 132, 274, 29);
	    frame.getContentPane().add(textField_bloodBankId);
	    textField_bloodBankId.setColumns(10);
	    
	    textField_bloodBankName = new JTextField();
	    textField_bloodBankName.setColumns(10);
	    textField_bloodBankName.setBounds(376, 185, 274, 29);
	    frame.getContentPane().add(textField_bloodBankName);
	    
	    textField_bloodBankAddr = new JTextField();
	    textField_bloodBankAddr.setColumns(10);
	    textField_bloodBankAddr.setBounds(376, 236, 274, 29);
	    frame.getContentPane().add(textField_bloodBankAddr);
	    
	    textField_stk_id = new JTextField();
	    textField_stk_id.setColumns(10);
	    textField_stk_id.setBounds(376, 250, 274, 29);
	    frame.getContentPane().add(textField_stk_id);
	    
	    bloodBank_name = new JLabel("Blood Bank Name : ");
	    bloodBank_name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    bloodBank_name.setBounds(181, 185, 170, 24);
	    frame.getContentPane().add(bloodBank_name);
	    
	    bloodBank_addr = new JLabel("Blood Bank Address : ");
	    bloodBank_addr.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    bloodBank_addr.setBounds(181, 241, 185, 24);
	    frame.getContentPane().add(bloodBank_addr);
	    
	    stk_id = new JLabel("Stock id : ");
	    stk_id.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    stk_id.setBounds(181, 260, 185, 24);
	    frame.getContentPane().add(stk_id);
	    
	    btn1 = new JButton("Submit");
	    btn1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//write sql query to insert data
	    		Connection connection=MyConnection.getConnection();	 
	    		int i=0;
	    		
	    		try {
	    			PreparedStatement ps=connection.prepareStatement("insert into bloodbank values(?,?,?,?,?)");
	    			ps.setString(1,textField_donor_id.getText());
					ps.setString(2,  textField_bloodBankId.getText());
					ps.setString(3, textField_bloodBankName.getText());
					ps.setString(4,  textField_bloodBankAddr.getText());
					ps.setString(5,  textField_stk_id.getText());
					i=ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Successfully Updated");
					setVisible(false);
					new Donor().setVisible(true);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "e1");
					//e1.printStackTrace();
				}
				
	    		}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
				
			}
	    	
	    });
	    btn1.setForeground(new Color(255, 255, 255));
	    btn1.setBackground(new Color(240, 128, 128));
	    btn1.setBounds(181, 298, 119, 29);
	    frame.getContentPane().add(btn1);
	    
	    frame.setSize(883,708);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
     public static void display_blood_bank_and_hospitals() {
    	 Scanner sc=new Scanner(System.in);
 		Connection connection=MyConnection.getConnection();	 
 		ResultSet i=null;
 		
 		try {
 			Statement ps=connection.createStatement();
 			//ps.setString(1, letter);
 			i=ps.executeQuery("select blood_bank_name,hosptAddr,blood_bank_address from bloodbank inner join patient on blood_bank.blood_bank_address=patient.hosptAddr");
 			while(i.next()) {
 				String bloodbankname=i.getString("blood_bank_name");
 				String bloodbankaddress=i.getString("blood_bank_address");
 				String hosptAddress=i.getString("hosptAddr");
 				System.out.println("Blood_bank_name: "+bloodbankname+"Blood_Bank_address: "+bloodbankaddress+"Hospital Address: "+hosptAddress);
 			}
 			
 			
 		} catch (SQLException e1) {
 			// TODO Auto-generated catch block
 			
 			e1.printStackTrace();
 		}
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Blood_Bank_Registration();
	}

}
