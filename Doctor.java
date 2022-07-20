package pkg1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Doctor {

	static JFrame frame;
	private static JTextField textField_doctorId;
	private static JTextField textField_doctorName;
	private static JTextField textField_phNo;
	private static JTextField textField_podTime;
	private static JLabel doctor_name;
	private static JLabel doct_phno;
	private static JLabel pod_time;
	private static JButton btn1;
	public static void Doctor_Registration()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 192, 203));
	    frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
	    frame.getContentPane().setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("Enter Following Details Correctly");
	    lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 30));
	    lblNewLabel.setBounds(121, 38, 604, 56);
	    frame.getContentPane().add(lblNewLabel);
	    
	    JLabel doctor_id = new JLabel("Doctor Id : ");
	    doctor_id.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    doctor_id.setBounds(181, 132, 98, 24);
	    frame.getContentPane().add(doctor_id);
	    
	    textField_doctorId = new JTextField();
	    textField_doctorId.setBounds(361, 132, 274, 29);
	    frame.getContentPane().add(textField_doctorId);
	    textField_doctorId.setColumns(10);
	    
	    textField_doctorName = new JTextField();
	    textField_doctorName.setColumns(10);
	    textField_doctorName.setBounds(361, 185, 274, 29);
	    frame.getContentPane().add(textField_doctorName);
	    
	    textField_phNo = new JTextField();
	    textField_phNo.setColumns(10);
	    textField_phNo.setBounds(361, 236, 274, 29);
	    frame.getContentPane().add(textField_phNo);
	    
	    textField_podTime = new JTextField();
	    textField_podTime.setColumns(10);
	    textField_podTime.setBounds(361, 290, 274, 29);
	    frame.getContentPane().add(textField_podTime);
	    
	    doctor_name = new JLabel("Doctor Name : ");
	    doctor_name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    doctor_name.setBounds(181, 185, 136, 24);
	    frame.getContentPane().add(doctor_name);
	    
	    doct_phno = new JLabel("Phone No : ");
	    doct_phno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    doct_phno.setBounds(181, 236, 122, 24);
	    frame.getContentPane().add(doct_phno);
	    
	    pod_time = new JLabel("OPD Time : ");
	    pod_time.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    pod_time.setBounds(181, 290, 153, 24);
	    frame.getContentPane().add(pod_time);
	    
	    btn1 = new JButton("Submit");
	    btn1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//write sql query to insert data
	    		Connection connection=MyConnection.getConnection();	 
	    		int i=0;
	    		
	    		try {
	    			PreparedStatement ps=connection.prepareStatement("insert into doctor values(?,?,?,?)");
					ps.setString(1,  textField_doctorId.getText());
					ps.setString(2,  textField_doctorName.getText());
					ps.setString(3,  textField_phNo.getText());
					ps.setString(4, textField_podTime.getText());
					
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
	    btn1.setBounds(181, 348, 119, 29);
	    frame.getContentPane().add(btn1);
	    
	    frame.setSize(883,708);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Doctor_Registration();
	}

}
