package pkg1;
import java.sql.*;
import java.util.Scanner;
public class MyConnection {
	Scanner sc=new Scanner(System.in);
	private final static String url="jdbc:mysql:// localhost:3306/dbms_project";
	private final static String username="root";
	private final static String password="1262002Sp*";
	public static Connection connection=null;
	public static Connection getConnection() {
	try {
		connection=DriverManager.getConnection(url,username,password);
		
		
	}
	catch(SQLException e) {
		System.out.println("Oops Error!");
		e.printStackTrace();
	}
	return connection;
}
}
