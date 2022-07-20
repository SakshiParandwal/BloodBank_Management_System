package pkg1;
import pkg1.Blood_Stock;
import pkg1.Blood_Bank;
import pkg1.Doctor;
import pkg1.Donor;
import pkg1.Patient;
import pkg1.BloodDelivery;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Home {
	static JFrame frame;
	static JLabel image1Label;
	static JButton btn1;
	static JButton btn2;
	static JButton btn3;
	static JButton btn4;
	static JButton btn5;
	static JButton btn6;
	
	public static void HomePage()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
	    frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
	    frame.getContentPane().setLayout(null);
	    
	    image1Label = new JLabel("");
	    image1Label.setBounds(0, 0, 868, 390);
	    
	    ImageIcon img = new ImageIcon("C:\\Users\\Vedant\\eclipse-workspace\\DBMS_Project\\src\\pkg1\\blood-donation.jpg");
	    Image scaledImage = (img.getImage()).getScaledInstance(image1Label.getWidth(), image1Label.getHeight(), Image.SCALE_SMOOTH);
	    image1Label.setIcon(new ImageIcon(scaledImage));
	    
	    frame.getContentPane().add(image1Label);
	    
	    btn2 = new JButton("");
	    btn2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Donor.Donor_Registration();
	    	}
	    });
	    btn2.setBounds(359, 437, 152, 85);
	    ImageIcon img2 = new ImageIcon("C:\\Users\\Vedant\\eclipse-workspace\\DBMS_Project\\src\\pkg1\\DonorRegistration.png");
	    Image scaledImage2 = (img2.getImage()).getScaledInstance(btn2.getWidth(), btn2.getHeight(), Image.SCALE_SMOOTH);
	    btn2.setIcon(new ImageIcon(scaledImage2));
	    frame.getContentPane().add(btn2);
	    
	    btn3 = new JButton("");
	    btn3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Patient.Patient_Registration();
	    	}
	    });
	    btn3.setBounds(571, 437, 152, 85);
	    ImageIcon img3 = new ImageIcon("C:\\Users\\Vedant\\eclipse-workspace\\DBMS_Project\\src\\pkg1\\PatientRegistration.png");
	    Image scaledImage3 = (img3.getImage()).getScaledInstance(btn3.getWidth(), btn3.getHeight(), Image.SCALE_SMOOTH);
	    btn3.setIcon(new ImageIcon(scaledImage3));
	    frame.getContentPane().add(btn3);
	    
	    btn1 = new JButton("");
	    btn1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Blood_Stock b=new Blood_Stock();
	    	}
	    });
	    btn1.setBounds(149, 437, 152, 85);
	    ImageIcon img1 = new ImageIcon("C:/Users/Vedant/eclipse-workspace/DBMS_Project/src/pkg1/BloodAvailability.png");
	    Image scaledImage1 = (img1.getImage()).getScaledInstance(btn1.getWidth(), btn1.getHeight(), Image.SCALE_SMOOTH);
	    btn1.setIcon(new ImageIcon(scaledImage1));
	    frame.getContentPane().add(btn1);
	    
	    btn4 = new JButton("");
	    btn4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Doctor.Doctor_Registration();
	    	}
	    });
	    btn4.setBounds(149, 543, 152, 85);
	    ImageIcon img4 = new ImageIcon("C:\\Users\\Vedant\\eclipse-workspace\\DBMS_Project\\src\\pkg1\\DoctorRegistration.png");
	    Image scaledImage4 = (img4.getImage()).getScaledInstance(btn4.getWidth(), btn4.getHeight(), Image.SCALE_SMOOTH);
	    btn4.setIcon(new ImageIcon(scaledImage4));
	    frame.getContentPane().add(btn4);
	    
	    btn5 = new JButton("");
	    btn5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Blood_Bank.Blood_Bank_Registration();
	    	}
	    });
	    btn5.setBounds(359, 543, 152, 85);
	    ImageIcon img5 = new ImageIcon("C:\\Users\\Vedant\\eclipse-workspace\\DBMS_Project\\src\\pkg1\\BloodBankRegistration.png");
	    Image scaledImage5 = (img5.getImage()).getScaledInstance(btn5.getWidth(), btn5.getHeight(), Image.SCALE_SMOOTH);
	    btn5.setIcon(new ImageIcon(scaledImage5));
	    frame.getContentPane().add(btn5);
	    
	    btn6 = new JButton("");
	    btn6.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		BloodDelivery.BloodDeliveryData();
	    	}
	    });
	    btn6.setBounds(571, 543, 152, 85);
	    ImageIcon img6 = new ImageIcon("C:\\Users\\Vedant\\eclipse-workspace\\DBMS_Project\\src\\pkg1\\BloodDelivery.png");
	    Image scaledImage6 = (img6.getImage()).getScaledInstance(btn6.getWidth(), btn6.getHeight(), Image.SCALE_SMOOTH);
	    btn6.setIcon(new ImageIcon(scaledImage6));
	    frame.getContentPane().add(btn6);
	    
	    
	    frame.setSize(883,708);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
		HomePage();
		//System.out.println("Enter the starting letter of the donor:");
		//String letter=sc.next();
		int ch;
		System.out.println("*********WELCOME TO BLOOD BANK MANAGEMENT SYSTEM****************");
		do {
		System.out.println("***************Choose any one option********************\n1.Search name starting with letter S\n2.Find the donors between age group\n3.Display Donor name in ascending order\n4.Display blood stock details according to blood group\n5.Display blood bank and hospitals with same address(inner join)\n6.Display donor who donates blood with blood group B+ and gender=female(left join)\n7.check if blood with blood group=B+ is available in the blood stock  or not.(right join)\n8.Check availability(status) of particular blood group(group by query) \n9.Display details of max stock number(subquery)\n10.View Query  of donor id and blood grouop donated\n11.Quit");
		System.out.println("Enter your choice:");
		ch=sc.nextInt();
		switch(ch) {
		case 1:
			Donor.getDonorNameStartingWith();
			break;
		case 2:
			String a=sc.next();
			String b=sc.next();
			Donor.agedonors(a,b);
			break;
		case 3:
			Donor.display_donor_names_in_ascending_order();
			break;
		case 4:
			Blood_Stock.display_bloodstock_details();
			break;
		case 5:
			Blood_Bank.display_blood_bank_and_hospitals();
			break;
		case 6:
			Donor.display_donors_with_particular_gender_and_blood_group();
			break;
		case 7:
		    Blood_Stock.check_status_of_blood();
		    break;
		case 8:
			Blood_Stock.check_availability_blood_group_by();
			break;
		case 9:
			Blood_Stock.count_stk_num();
			break;
		case 10:
			Donor.view();
			break;
		case 11:
			System.out.println("Thank You!");
			break;
			
		}
		}while(ch!=9);
		//Donor.getDonorNameStartingWith();
       // Donor.BloodGroupInUpperCase();
		
	}

}
