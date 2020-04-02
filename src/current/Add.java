package current;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.jdi.connect.spi.Connection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Add {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add window = new Add();
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
	public Add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 800, 600);
		// frame.setBounds(550, 250, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddDetails = new JLabel("INSERT DETAILS");
		lblAddDetails.setBounds(345, 57, 210, 23);
		frame.getContentPane().add(lblAddDetails);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(312, 115, 66, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setBounds(312, 164, 66, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AGE");
		lblNewLabel_2.setBounds(312, 211, 66, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("HEIGHT");
		lblNewLabel_3.setBounds(312, 238, 66, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("WEIGHT");
		lblNewLabel_4.setBounds(312, 284, 66, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("STATUS");
		lblNewLabel_5.setBounds(312, 325, 66, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(396, 113, 124, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(396, 162, 124, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(396, 206, 124, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(396, 244, 124, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(396, 282, 124, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(396, 323, 124, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String que = textField.getText();
				
				String id = textField.getText();
				String name = textField_1.getText();
				String age = textField_2.getText();
				String height = textField_3.getText();
				String weight = textField_4.getText();
				String status = textField_5.getText();
				//String BMI = textField_3.getText();
				 float h=Integer.parseInt(height);
	                h=h/100;
	                h=h*h;
	                float w=Integer.parseInt(weight);
	                float b=w/h;
	                String BMI= String.valueOf(b);
			
				 
         
				  try {
					  Class.forName("com.mysql.jdbc.Driver");
			            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","shivam","password");
	                    String query = "insert into gymdetails values('" + id+ "','" + name + "','" + age + "','" + height + "','" + weight + "','" + status + "','" + BMI + "');";
	                   // System.out.print(query);
	                    Statement smt3=con.createStatement();
	                   // Statement sta;
						smt3.executeUpdate(query);
	                  
	                    
	                   
	                    con.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	               
	                }
				    JOptionPane.showMessageDialog(frame,"Details Succesfully Added");
                 
				
			}
		});
		btnSave.setBounds(345, 369, 114, 25);
		//////////
		frame.getContentPane().add(btnSave);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new Mainframe1();
			}
		});
		btnBack.setBounds(345, 472, 114, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel label = new JLabel("");
		label.setBounds(218, 272, 66, 15);
		frame.getContentPane().add(label);
		frame.setVisible(true);
	}

}
