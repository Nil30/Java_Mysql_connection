package database;

import java.sql.*;

public class MysqlCon {

	public static void main(String[] args) 	throws Exception  {
		// TODO Auto-generated method stub
		try{  
			Class.forName("com.mysql.jdbc.Driver");  	
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
			
			Statement stmt =con.createStatement();  
				
			/*String s = "INSERT INTO `developers`(`id`, `fullName`, `gender`, `email`, `mobile`, `address`, `city`, `state`, `created_at`, `updated_at`) VALUES (NULL ,'Pratik Kumbhar','Male','pratik1234@gmail.com',+918123964522,'Nipani','Nipani','karnataka','2022-05-12 22:09:07.912240','0000-00-00 00:00:00.000000')";
			
			stmt.execute(s);
			System.out.println("Query Insterted"); */
			
			
			ResultSet rs = stmt.executeQuery("select * from developers");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+ rs.getString(3)+ " "+ rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+ " "+rs.getString(7)+"  "+rs.getString(8) );  
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			}  

	}

