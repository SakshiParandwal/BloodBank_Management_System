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
public class Patient {
	static JFrame frame;
	private static JTextField textField_patientId;
	private static JTextField textField_patientName;
	private static JTextField textField_bloodType;
	private static JTextField textField_hosptAddr;
	private static JTextField textField_patientAddr;
	private static JLabel patient_name;
	private static JLabel blood_type;
	private static JLabel hospt_add;
	private static JLabel patient_add;
	private static JButton btn1;
	
	public static void Patient_Registration()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 192, 203));
	    frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
	    frame.getContentPane().setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("Enter Following Details Correctly");
	    lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 30));
	    lblNewLabel.setBounds(121, 38, 604, 56);
	    frame.getContentPane().add(lblNewLabel);
	    
	    JLabel patient_id = new JLabel("Patient Id : ");
	    patient_id.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    patient_id.setBounds(181, 132, 98, 24);
	    frame.getContentPane().add(patient_id);
	    
	    textField_patientId = new JTextField();
	    textField_patientId.setBounds(361, 132, 274, 29);
	    frame.getContentPane().add(textField_patientId);
	    textField_patientId.setColumns(10);
	    
	    textField_patientName = new JTextField();
	    textField_patientName.setColumns(10);
	    textField_patientName.setBounds(361, 185, 274, 29);
	    frame.getContentPane().add(textField_patientName);
	    
	    textField_bloodType = new JTextField();
	    textField_bloodType.setColumns(10);
	    textField_bloodType.setBounds(361, 236, 274, 29);
	    frame.getContentPane().add(textField_bloodType);
	    
	    textField_hosptAddr = new JTextField();
	    textField_hosptAddr.setColumns(10);
	    textField_hosptAddr.setBounds(361, 290, 274, 29);
	    frame.getContentPane().add(textField_hosptAddr);
	    
	    textField_patientAddr = new JTextField();
	    textField_patientAddr.setColumns(10);
	    textField_patientAddr.setBounds(361, 341, 274, 29);
	    frame.getContentPane().add(textField_patientAddr);
	    
	    patient_name = new JLabel("Patient Name : ");
	    patient_name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    patient_name.setBounds(181, 185, 122, 24);
	    frame.getContentPane().add(patient_name);
	    
	    blood_type = new JLabel("Blood Type : ");
	    blood_type.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    blood_type.setBounds(181, 236, 122, 24);
	    frame.getContentPane().add(blood_type);
	    
	    hospt_add = new JLabel("Hospital Address : ");
	    hospt_add.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    hospt_add.setBounds(181, 290, 153, 24);
	    frame.getContentPane().add(hospt_add);
	    
	    patient_add = new JLabel("Patient Address : ");
	    patient_add.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    patient_add.setBounds(181, 341, 153, 24);
	    frame.getContentPane().add(patient_add);
	    
	    btn1 = new JButton("Submit");
	    btn1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//write sql query to insert data
	    		Connection connection=MyConnection.getConnection();	 
	    		int i=0;
	    		
	    		try {
	    			PreparedStatement ps=connection.prepareStatement("insert into patient values(?,?,?,?,?)");
					ps.setString(1,   textField_patientId.getText());
					ps.setString(2,  textField_patientName.getText());
					ps.setString(3, textField_bloodType.getText());
					ps.setString(4,textField_hosptAddr.getText());
					ps.setString(5,  textField_patientAddr.getText());
					
					i=ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Successfully Updated");
					setVisible(false);
					new Patient().setVisible(true);
					
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
	    btn1.setBounds(181, 405, 119, 29);
	    frame.getContentPane().add(btn1);
	    
	    frame.setSize(883,708);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Patient_Registration();
	}

}
