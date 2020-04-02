package current;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

//import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Mainframe1 {

	public JFrame frame;
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
            try {
					Mainframe1 window = new Mainframe1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mainframe1() {
		initialize();
		table.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1066, 803);
		// frame.setBounds(550, 250, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("ALL MEMBERS");
		btnNewButton.setBounds(39, 57, 259, 25);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					  
		          table.setVisible(true);
		 // Connectivity code           
		            Class.forName("java.sql.DriverManager");
		            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "shivam", "password");

		            Statement stmt = con.createStatement();
		             String query = "select * from gymdetails order by id";
		            ResultSet rs=stmt.executeQuery(query);
		 //                
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		           
				}
		        catch(Exception exception){	
		        }
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("FIT ");
		btnNewButton_1.setBounds(39, 113, 160, 25);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setVisible(true);
				try {
					 
					Class.forName("java.sql.DriverManager");
		            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "shivam", "password");

		            Statement stmt = con.createStatement();
		             String query = "select * from gymdetails where BMI>18.5 and BMI<25 order by id";
		            ResultSet rs=stmt.executeQuery(query);
		           
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		           
				}
		        catch(Exception Ex){	
		        }
			}
		});	
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("UNDER WEIGHT");
		btnNewButton_2.setBounds(254, 113, 160, 25);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setVisible(true);
				try {
					 
					Class.forName("java.sql.DriverManager");
		            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "shivam", "password");

		            Statement stmt = con.createStatement();
		             String query = "select * from gymdetails where BMI<18.5 order by id";
		            ResultSet rs=stmt.executeQuery(query);
		           
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		           
				}
		        catch(Exception Ex){	
		        }
			}
		});	
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("OVER WEIGHT");
		btnNewButton_3.setBounds(466, 113, 160, 25);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setVisible(true);
				try {
					 
					Class.forName("java.sql.DriverManager");
		            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "shivam", "password");

		            Statement stmt = con.createStatement();
		             String query = "select * from gymdetails where BMI>25 order by id";
		            ResultSet rs=stmt.executeQuery(query);
		           
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		           
				}
		        catch(Exception Ex){	
		        }
			}
		});
		frame.getContentPane().add(btnNewButton_3);
		
		table = new JTable();
		table.setFont(new Font("Dialog", Font.PLAIN, 14));
		table.setBounds(22, 188, 930, 293);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "NAME", "AGE", "HEIGHT", "WEIGHT", "STATUS", "BMI"
			}
		));
		frame.getContentPane().add(table);
		
		JButton btnSearch = new JButton("SEARCH MEMBER");
		btnSearch.setBounds(39, 569, 259, 25);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				
				Search1 window = new Search1();
				window.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnSearch);
		
		JButton btnUpdate = new JButton(" UPDATE MEMBER");
		btnUpdate.setBounds(254, 633, 161, 25);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				
				updatee frame = new updatee();
				frame.setVisible(true);
				//frame.setVisible(false);
				//new Update();
			}
		});
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE MEMBER");
		btnDelete.setBounds(466, 633, 160, 25);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new Delete();
			}
		});
		frame.getContentPane().add(btnDelete);
		
		JButton btnBack = new JButton("LOGOUT");
		btnBack.setBounds(902, 26, 114, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Login1 frame = new Login1();
				frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(49, 161, 114, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setBounds(196, 161, 105, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AGE");
		lblNewLabel_2.setBounds(328, 161, 66, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblHeight = new JLabel("HEIGHT");
		lblHeight.setBounds(466, 161, 66, 15);
		frame.getContentPane().add(lblHeight);
		
		JLabel lblWeight = new JLabel("WEIGHT");
		lblWeight.setBounds(597, 161, 66, 15);
		frame.getContentPane().add(lblWeight);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setBounds(730, 161, 66, 15);
		frame.getContentPane().add(lblStatus);
		
		JLabel lblBmi = new JLabel("BMI");
		lblBmi.setBounds(863, 161, 66, 15);
		frame.getContentPane().add(lblBmi);
		
		JButton btnAdd = new JButton("ADD MEMBER");
		btnAdd.setBounds(39, 633, 160, 25);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				
				Add window = new Add();
				window.frame.setVisible(true);
			}
			
		});
		frame.getContentPane().add(btnAdd);
		frame.setVisible(true);
	}


}
