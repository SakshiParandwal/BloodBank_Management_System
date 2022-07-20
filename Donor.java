package pkg1;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Scanner;
public class Donor {
	static JFrame frame;
	private static JTable table;
	private static JTextField textField_donorId;
	private static JTextField textField_donorName;
	private static JTextField textField_bloodType;
	private static JTextField textField_age;
	private static JTextField textField_phNo;
	private static JTextField textField_addr;
	private static JTextField textField_gender;
	private static JTextField textField_wt;
	private static JTextField textField_bp;
	private static JButton btn1;
	public static void Donor_Registration()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 192, 203));
	    frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
	    frame.getContentPane().setLayout(null);
	    
	    table = new JTable();
	    table.setBounds(268, 424, 302, -117);
	    frame.getContentPane().add(table);
	    
	    JLabel lblNewLabel = new JLabel("Enter Following Details Correctly");
	    lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 30));
	    lblNewLabel.setBounds(115, 29, 604, 56);
	    frame.getContentPane().add(lblNewLabel);
	    
	    JLabel donor_id = new JLabel("Donor Id: ");
	    donor_id.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    donor_id.setBounds(197, 132, 98, 24);
	    frame.getContentPane().add(donor_id);
	    
	    JLabel donor_name = new JLabel("Donor Name: ");
	    donor_name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    donor_name.setBounds(197, 182, 119, 24);
	    frame.getContentPane().add(donor_name);
	    
	    JLabel blood_type = new JLabel("Blood Type: ");
	    blood_type.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    blood_type.setBounds(197, 231, 109, 24);
	    frame.getContentPane().add(blood_type);
	    
	    JLabel age = new JLabel("Age: ");
	    age.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    age.setBounds(197, 281, 55, 24);
	    frame.getContentPane().add(age);
	    
	    JLabel ph_no = new JLabel("Ph No: ");
	    ph_no.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    ph_no.setBounds(197, 331, 98, 24);
	    frame.getContentPane().add(ph_no);
	    
	    JLabel addr = new JLabel("Address:  ");
	    addr.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    addr.setBounds(197, 377, 81, 24);
	    frame.getContentPane().add(addr);
	    
	    JLabel gender = new JLabel("Gender:  ");
	    gender.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    gender.setBounds(197, 429, 81, 24);
	    frame.getContentPane().add(gender);
	    
	    JLabel wt = new JLabel("Weight:   ");
	    wt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    wt.setBounds(197, 476, 81, 24);
	    frame.getContentPane().add(wt);
	    
	    JLabel bp = new JLabel("BP:   ");
	    bp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    bp.setBounds(197, 523, 66, 24);
	    frame.getContentPane().add(bp);
	    
	    textField_donorId = new JTextField();
	    textField_donorId.setBounds(344, 132, 274, 29);
	    frame.getContentPane().add(textField_donorId);
	    textField_donorId.setColumns(10);
	    
	    textField_donorName = new JTextField();
	    textField_donorName.setColumns(10);
	    textField_donorName.setBounds(344, 182, 274, 29);
	    frame.getContentPane().add(textField_donorName);
	    
	    textField_bloodType = new JTextField();
	    textField_bloodType.setColumns(10);
	    textField_bloodType.setBounds(344, 231, 274, 29);
	    frame.getContentPane().add(textField_bloodType);
	    
	    textField_age = new JTextField();
	    textField_age.setColumns(10);
	    textField_age.setBounds(344, 281, 274, 29);
	    frame.getContentPane().add(textField_age);
	    
	    textField_phNo = new JTextField();
	    textField_phNo.setColumns(10);
	    textField_phNo.setBounds(344, 331, 274, 29);
	    frame.getContentPane().add(textField_phNo);
	    
	    textField_addr = new JTextField();
	    textField_addr.setColumns(10);
	    textField_addr.setBounds(344, 377, 274, 29);
	    frame.getContentPane().add(textField_addr);
	    
	    textField_gender = new JTextField();
	    textField_gender.setColumns(10);
	    textField_gender.setBounds(344, 429, 274, 29);
	    frame.getContentPane().add(textField_gender);
	    
	    textField_wt = new JTextField();
	    textField_wt.setColumns(10);
	    textField_wt.setBounds(344, 476, 274, 29);
	    frame.getContentPane().add(textField_wt);
	    
	    textField_bp = new JTextField();
	    textField_bp.setColumns(10);
	    textField_bp.setBounds(344, 523, 274, 29);
	    frame.getContentPane().add(textField_bp);
	    
	    btn1 = new JButton("Submit");
	    btn1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//write sql query to insert data
	    		Connection connection=MyConnection.getConnection();	 
	    		int i=0;
	    		
	    		try {
	    			PreparedStatement ps=connection.prepareStatement("insert into donor values(?,?,?,?,?,?,?,?,?)");
					ps.setString(1,  textField_donorId.getText());
					ps.setString(2, textField_donorName.getText());
					ps.setString(3, textField_bloodType.getText());
					ps.setString(4,textField_age.getText());
					ps.setString(5,  textField_phNo.getText());
					ps.setString(6,  textField_addr.getText());
					ps.setString(7, textField_gender.getText());
					ps.setString(8,  textField_wt.getText());
					ps.setString(9,textField_bp.getText());
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
	    btn1.setBounds(197, 594, 119, 29);
	    frame.getContentPane().add(btn1);
	    
	    frame.setSize(883,708);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public static void getDonorNameStartingWith() {
		Scanner sc=new Scanner(System.in);
		Connection connection=MyConnection.getConnection();	 
		ResultSet i=null;
		
		try {
			Statement ps=connection.createStatement();
			//ps.setString(1, letter);
			i=ps.executeQuery("select donor_name from donor where donor_name like 'S%'");
			while(i.next()) {
				String donorname=i.getString("donor_name");
				System.out.println(donorname);
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}
	}
	//Trigger Query
	/*public static int  BloodGroupInUpperCase() {
		Scanner sc=new Scanner(System.in);
		Connection connection=MyConnection.getConnection();	 
		int i = 0;
		
		try {
			Statement ps=connection.createStatement();
			//ps.setString(1, letter);
			i=ps.executeUpdate("create trigger _before_uppercase before insert on donor"+"for each row"+"begin"+"set bloodtype=upper(bloodtype)"+"END"
					);
		//	while(i.next()) {
				//String donorname=i.getString("donor_name");
				//System.out.println(donorname);
						
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}
		return i;
	}*/
	
	public static void display_donor_names_in_ascending_order() {
		Scanner sc=new Scanner(System.in);
		Connection connection=MyConnection.getConnection();	 
		ResultSet i=null;
		
		try {
			Statement ps=connection.createStatement();
			//ps.setString(1, letter);
			i=ps.executeQuery("select donor_name,donor_id from donor order by donor_name asc");
			while(i.next()) {
				String donorname=i.getString("donor_name");
				String donorid=i.getString("donor_id");
				System.out.println("Donor name: "+donorname+"   "+"Donor Id: "+donorid);
				
				
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}
	}
	
	//display donors between age a and b
	public static void agedonors(String a,String b) {
		Connection connection=MyConnection.getConnection();	 
		//ResultSet i=null;
		CallableStatement ps = null;
		try {
			//Statement ps=connection.createStatement();
			//ps.setString(1, letter);
			String sql="{call view_range(?,?,?,?,?,?,?,?,?,?,?)}";
			 ps = connection.prepareCall(sql);
			ps.setString(1, a);
			ps.setString(2, b);
			ps.registerOutParameter(3, java.sql.Types.CHAR);
			ps.registerOutParameter(4, java.sql.Types.CHAR);
			ps.registerOutParameter(5, java.sql.Types.CHAR);
			ps.registerOutParameter(6, java.sql.Types.CHAR);
			ps.registerOutParameter(7, java.sql.Types.CHAR);
			ps.registerOutParameter(8, java.sql.Types.CHAR);
			ps.registerOutParameter(9, java.sql.Types.CHAR);
			ps.registerOutParameter(10, java.sql.Types.CHAR);
			ps.registerOutParameter(11, java.sql.Types.CHAR);
			System.out.println("Executing stored procedure");
			ps.execute();
			
			String donorid=ps.getString(3);
			String donorname=ps.getString(4);
			String bloodtype=ps.getString(5);
			String age=ps.getString(6);
			String phno=ps.getString(7);
			String address=ps.getString(8);
			String gender=ps.getString(9);
			String weight=ps.getString(10);
			String bp=ps.getString(11);
			
			System.out.println(donorid+" "+donorname+" "+bloodtype+" "+age+" "+phno+" "+address+"  "+gender+" "+weight+"  "+bp);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
		}
			finally {
				try {
					ps.close();
					connection.close();
				}
				catch(Exception e) {
					
				}
			}
		
		}
	public static void display_donors_with_particular_gender_and_blood_group() {
		Scanner sc=new Scanner(System.in);
		Connection connection=MyConnection.getConnection();	 
		ResultSet i=null;
		
		try {
			Statement ps=connection.createStatement();
			//ps.setString(1, letter);
			i=ps.executeQuery("select donor.donor_id,donor.donor_name,donor.age,donor.gender,blood.bloodtype from donor left join blood on donor.donor_id=blood.donor_id where donor.bloodtype='B+' AND gender='female'");
			while(i.next()) {
				String donorid=i.getString("donor_id");
				String donorname=i.getString("donor_name");
				String donorage=i.getString("age");
				String donorgender=i.getString("gender");
				String donorblood=i.getString("bloodtype");
				System.out.println("Donor Id: \t"+" |"+"Donor name: \t"+" |"+"Donor age: \t"+" |"+"Donor Gender: \t"+" |"+"Blood Type: \t");
				System.out.println(donorid+" |"+donorname+" |"+donorage+" |"+donorgender+" |"+donorblood);
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}
	}
	public static void view() {
		Scanner sc=new Scanner(System.in);
		Connection connection=MyConnection.getConnection();	 
		ResultSet i=null;
		
		try {
			Statement ps=connection.createStatement();
			//ps.setString(1, letter);
			i=ps.executeQuery("select * from donor_Bloodgroup");
			System.out.println("DONOR ID: \t "+"BLOOD GROUP:  \t");
			if(i.next()) {
						do {
							System.out.println(i.getString(1)+"\t\t\t  "+i.getString(2));
						}while(i.next());
			}
			else {
				System.out.println("Record not found....");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Donor_Registration();
		

		
	}

}
