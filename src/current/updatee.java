package current;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class updatee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatee frame = new updatee();
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
	public updatee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		// setBounds(550, 250, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(400, 173, 124, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(400, 263, 124, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textField.getText();
				String wei = textField_1.getText();
				String hei = textField_2.getText();
				
				
				float h=Integer.parseInt(hei);
                h=h/100;
                h=h*h;
                float w=Integer.parseInt(wei);
                float b=w/h;
                String bmi= String.valueOf(b);
			
				
				
				 try {
					  Class.forName("com.mysql.jdbc.Driver");
			            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","shivam","password");
	                    String query = "update gymdetails set weight="+wei+" WHERE ID=" + id;
	                    String query1 = "update gymdetails set height="+hei+" WHERE ID=" + id;
	                    String query2 = "update gymdetails set BMI="+bmi+" WHERE ID=" + id;
	                   // System.out.print(query);
	                    Statement smt3=con.createStatement();
	                    Statement smt4=con.createStatement();
	                    Statement smt5=con.createStatement();
	                   // Statement sta;
						smt3.executeUpdate(query);
						smt4.executeUpdate(query1);
						smt3.executeUpdate(query2);
	                  
	                    
	                   
	                    con.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	               
	                }
				    
				 JOptionPane.showMessageDialog(null, "Details Updated Successfully");
				
				
				
			}
		});
		btnNewButton.setBounds(339, 358, 114, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(316, 174, 66, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("WEIGHT");
		lblNewLabel_1.setBounds(316, 265, 66, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUpdateRecord = new JLabel("UPDATE RECORD");
		lblUpdateRecord.setBounds(339, 129, 113, 15);
		contentPane.add(lblUpdateRecord);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
				Mainframe1 window = new Mainframe1();
				window.frame.setVisible(true);
				
			}
		});
		btnBack.setBounds(338, 433, 114, 25);
		contentPane.add(btnBack);
		
		JLabel lblHeight = new JLabel("HEIGHT");
		lblHeight.setBounds(316, 217, 66, 15);
		contentPane.add(lblHeight);
		
		textField_2 = new JTextField();
		textField_2.setBounds(400, 215, 124, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}
