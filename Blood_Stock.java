package pkg1;
import javax.swing.JFrame;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Blood_Stock extends JFrame implements ActionListener {
//static JFrame frame;
	 JFrame frame1;
	    JLabel l0, l1, l2;
	    JComboBox c1;
	    JButton b1;
	    Connection con;
	    ResultSet rs, rs1;
	    Statement st, st1;
	    PreparedStatement pst;
	    String ids;
	    static JTable table;
	    String[] columnNames = {"donor_id", "blood_bank_id", "blood_bank_name", "blood_bank_address","stk_id"};
	    String from;
	 Blood_Stock()
	{
		/*frame = new JFrame();
		frame.setBackground(new Color(240, 240, 240));
		frame.getContentPane().setBackground(Color.WHITE);
	    frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
	    frame.getContentPane().setLayout(null);
	    
	    JTextPane txtpnDisplayStockDetails = new JTextPane();
	    txtpnDisplayStockDetails.setBackground(new Color(255, 192, 203));
	    txtpnDisplayStockDetails.setFont(new Font("Tahoma", Font.PLAIN, 50));
	    txtpnDisplayStockDetails.setText("Display Stock Details Inside this Text Area");
	    txtpnDisplayStockDetails.setBounds(171, 80, 541, 451);
	    frame.getContentPane().add(txtpnDisplayStockDetails);
	    
	    frame.setSize(883,708);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);*/
		l0 = new JLabel("Fetching BloodBank Information");
        l0.setForeground(Color.red);
        l0.setFont(new Font("Serif", Font.BOLD, 20));
        l1 = new JLabel("Select donor id:");
        b1 = new JButton("submit");
        l0.setBounds(100, 50, 350, 40);
        l1.setBounds(100, 130, 100, 20);
        b1.setBounds(150, 157, 150, 20);
        b1.addActionListener(this);
        setTitle("Fetching BloodBank Info From DataBase");
        setLayout(null);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(l0);
        add(l1);;
        add(b1);
	    
        Connection connection=MyConnection.getConnection();	
        try {
			//Statement ps=connection.createStatement();
			//ps.setString(1, letter);
			 st = connection.createStatement();
	            rs = st.executeQuery("select donor_id from bloodbank");
	            Vector v = new Vector();
	            while (rs.next()) {
	                ids = rs.getString(1);
	                v.add(ids);
	            }
	            c1 = new JComboBox(v);
	            c1.setBounds(200, 130, 175, 20);
	            //c1.setVisible(true);            
	            add(c1);
	            //c1.setVisible(true);   
	            st.close();
	            rs.close();
	        } catch (Exception e) {
	        }
			
			
		}
	 public void actionPerformed(ActionEvent ae) {
	        if (ae.getSource() == b1) {
	            showTableData();
	        }
	    }
	   
	
	public void showTableData() {
		// TODO Auto-generated method stub
		 frame1 = new JFrame("Database Search Result");
	        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame1.setLayout(new BorderLayout());
	        //TableModel tm = new TableModel();
	        DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(columnNames);
	        //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
	        //table = new JTable(model);
	        table = new JTable();
	        table.setModel(model);
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        table.setFillsViewportHeight(true);
	        JScrollPane scroll = new JScrollPane(table);
	        scroll.setHorizontalScrollBarPolicy(
	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scroll.setVerticalScrollBarPolicy(
	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        from = (String) c1.getSelectedItem();
	        //String textvalue = textbox.getText();
	        Connection connection=MyConnection.getConnection();	
	        String donorid = "";
	        String bloodbankid = "";
	        String bloodbankname = "";
	        String bloodbankaddress = "";
	        String stkid = "";
	        
	        try {
	            pst = connection.prepareStatement("select * from bloodbank where donor_id='" + from + "'");
	            ResultSet rs = pst.executeQuery();
	            int i = 0;
	            if (rs.next()) {
	            	donorid = rs.getString("donor_id");
	            	bloodbankid = rs.getString("blood_bank_id");
	            	bloodbankname = rs.getString("blood_bank_name");
	            	bloodbankaddress=rs.getString("blood_bank_address");
	            	stkid = rs.getString("stk_id");
	                model.addRow(new Object[]{donorid, bloodbankid, bloodbankname, bloodbankaddress,stkid});
	                i++;
	            }
	            if (i < 1) {
	                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	            if (i == 1) {
	                System.out.println(i + " Record Found");
	            } else {
	                System.out.println(i + " Records Found");
	            }
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        frame1.add(scroll);
	        frame1.setVisible(true);
	        frame1.setSize(400, 300);
	        
	}
	public static void display_bloodstock_details() {
		Scanner sc=new Scanner(System.in);
		Connection connection=MyConnection.getConnection();	 
		ResultSet i=null;
		
		try {
			Statement ps=connection.createStatement();
			//ps.setString(1, letter);
			i=ps.executeQuery("select stk_desc,stk_id,stk_num from bloodstock group by stk_id");
			while(i.next()) {
				String stockid=i.getString("stk_id");
				String stockdesc=i.getString("stk_desc");
				String stocknum=i.getString("stk_num");
				System.out.println("Stock Id:   "+stockid+"|"+"Stock num: "+stocknum+"|"+"Stock description:  "+stockdesc);
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}
    }
	public static void check_status_of_blood() {
		Scanner sc=new Scanner(System.in);
		Connection connection=MyConnection.getConnection();	 
		ResultSet i=null;
		
		try {
			Statement ps=connection.createStatement();
			//ps.setString(1, letter);
			i=ps.executeQuery("select blood.bloodtype,bloodstock.stk_desc from blood right join bloodstock on blood.stk_id=bloodstock.stk_id where bloodtype='B+'");
			while(i.next()) {
				String donorblood=i.getString("bloodtype");
				String stkdesc=i.getString("stk_desc");
				
				
				System.out.println("Donor blood group: "+donorblood+"  "+"Blood stock desc: "+stkdesc);
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}
	}
	public static void  check_availability_blood_group_by() {
		Scanner sc=new Scanner(System.in);
		Connection connection=MyConnection.getConnection();	 
		ResultSet i=null;
		
		try {
			Statement ps=connection.createStatement();
			//ps.setString(1, letter);
			i=ps.executeQuery("select stk_desc from bloodstock where stk_id=1 group by stk_id");
			while(i.next()) {
				String stkdesc=i.getString("stk_desc");
				
				
				
				System.out.println("Blood stock desc: "+stkdesc);
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}
	}
	public static void count_stk_num() {
		Scanner sc=new Scanner(System.in);
		Connection connection=MyConnection.getConnection();	 
		ResultSet i=null;
		
		try {
			Statement ps=connection.createStatement();
			//ps.setString(1, letter);
			i=ps.executeQuery("select stk_id,stk_num,stk_desc from bloodstock where stk_num=(select max(stk_num) from bloodstock)");
			while(i.next()) {
				String stkdesc=i.getString("stk_desc");
				
				
				
				System.out.println("Blood stock desc: "+stkdesc);
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Blood_Stock_Details();
        new Blood_Stock();
	}
	

}
