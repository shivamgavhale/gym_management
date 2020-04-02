package current;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Login1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login1 frame = new Login1();
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
	public Login1() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
	//	setBounds(550, 250, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("USERNAME");
		lblUser.setBounds(244, 256, 104, 17);
		contentPane.add(lblUser);
		
		JLabel lblPass = new JLabel("PASSWORD");
		lblPass.setBounds(244, 299, 104, 15);
		contentPane.add(lblPass);
		
		textField = new JTextField();
		textField.setBounds(358, 255, 124, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(358, 298, 124, 17);
		contentPane.add(passwordField);
		JButton btnSubmit = new JButton("LOGIN");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String res = " "; 
				String value1=textField.getText();
				  String value2=passwordField.getText();
				  if (value1.equals("s") && value2.equals("s")) {
					  
					  dispose();
					 
					  Mainframe1 window = new Mainframe1();
					    window.frame.setVisible(true);
					   
						//System.out.println(string);
					  
				  }
				  
				  /*if (value1.equals("a") && value2.equals("a")) {
					  if(string=="Member") {
						  User window = new User();
							window.frame.setVisible(true);
						System.out.println(string);
					  }
				  }*/
				  else{
						res = "Incorrect Login ID or Password"; 
						// MessageDialog to show information selected radion buttons. 
						JOptionPane.showMessageDialog(null, "Invalid Entries");
				  }
				
			}
		});
		btnSubmit.setBounds(306, 346, 114, 25);
		contentPane.add(btnSubmit);
		
		JLabel lblAdmin = new JLabel("TRAINER LOGIN");
		lblAdmin.setBounds(306, 206, 104, 25);
		contentPane.add(lblAdmin);
		
		JButton btnOk = new JButton("Member Login");
		btnOk.setForeground(Color.BLACK);
		btnOk.setFont(new Font("Dialog", Font.BOLD, 14));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
				User window = null;
				try {
					window = new User();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				window.frame.setVisible(true);
				
			}
		});
		btnOk.setBounds(259, 128, 207, 25);
		contentPane.add(btnOk);
		
		JLabel lblNewLabel = new JLabel("BUILD YOUR BODY TRANSFORM YOUR LIFE");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel.setBounds(73, 12, 679, 115);
		contentPane.add(lblNewLabel);
	}
}
