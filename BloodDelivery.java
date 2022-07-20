package pkg1;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BloodDelivery {
	static JFrame frame;
	private static JTextField textField_bloodBankId;
	private static JTextField textField_patientId;
	private static JLabel patientId;
	private static JButton btn1;
	
	public static void BloodDeliveryData()
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
	    
	    textField_bloodBankId = new JTextField();
	    textField_bloodBankId.setBounds(376, 132, 274, 29);
	    frame.getContentPane().add(textField_bloodBankId);
	    textField_bloodBankId.setColumns(10);
	    
	    textField_patientId = new JTextField();
	    textField_patientId.setColumns(10);
	    textField_patientId.setBounds(376, 185, 274, 29);
	    frame.getContentPane().add(textField_patientId);
	    
	    patientId = new JLabel("Patient Id : ");
	    patientId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    patientId.setBounds(181, 185, 170, 24);
	    frame.getContentPane().add(patientId);

	    btn1 = new JButton("Submit");
	    btn1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//write sql query to insert data
	    		Connection connection=MyConnection.getConnection();	 
	    		int i=0;
	    		
	    		try {
	    			PreparedStatement ps=connection.prepareStatement("insert into donor values(?,?)");
					ps.setString(1,  textField_bloodBankId.getText());
					ps.setString(2, textField_patientId.getText());
					
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
	    btn1.setBounds(181, 242, 119, 29);
	    frame.getContentPane().add(btn1);
	    
	    frame.setSize(883,708);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BloodDeliveryData();
	}

}
