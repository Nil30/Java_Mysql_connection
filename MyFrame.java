package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtbox1;
	private JTextField txtbox2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FirstName");
		lblNewLabel.setBounds(70, 77, 215, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LastName");
		lblNewLabel_1.setBounds(69, 141, 136, 41);
		contentPane.add(lblNewLabel_1);
		
		txtbox1 = new JTextField();
		txtbox1.setBounds(206, 83, 96, 19);
		contentPane.add(txtbox1);
		txtbox1.setColumns(10);
		
		txtbox2 = new JTextField();
		txtbox2.setBounds(206, 152, 96, 19);
		contentPane.add(txtbox2);
		txtbox2.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 String FirstName=txtbox1.getText();
			 String Lastname=txtbox2.getText();
			 
			 try{  
					Class.forName("com.mysql.jdbc.Driver");  	
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
					if(con != null)
					{
						System.out.println("connection Successful");
					}
					Statement stmt =con.createStatement();  			
					
					String sql="INSERT INTO `data`(`firstname`, `lastname`) VALUES ('"+FirstName+"','"+Lastname+"')";
					
					stmt.executeUpdate(sql);
					
					JOptionPane.showMessageDialog(null,"Value Inserted ");
				 
						con.close();
					}
			 	catch(Exception e1){ System.out.println(e1);}  
			}
		});
		btnNewButton.setBounds(200, 216, 85, 21);
		contentPane.add(btnNewButton);
	}
	
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
