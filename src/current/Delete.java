package current;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Delete {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete window = new Delete();
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
	public Delete() {
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
		
		JLabel lblNewLabel = new JLabel("DELETE");
		lblNewLabel.setBounds(358, 195, 109, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(316, 265, 66, 15);
		frame.getContentPane().add(lblId);
		
		textField = new JTextField();
		textField.setBounds(389, 263, 124, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDeleteRecord = new JButton("Delete Record");
		btnDeleteRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String id = textField.getText();
				
				 try {
					  Class.forName("com.mysql.jdbc.Driver");
			            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","shivam","password");
	                    String query = "DELETE FROM gymdetails WHERE ID=" + id;
	                   // System.out.print(query);
	                    Statement smt3=con.createStatement();
	                   // Statement sta;
						smt3.executeUpdate(query);
	                  
	                    
	                   
	                    con.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	               
	                }
				    JOptionPane.showMessageDialog(frame,"Succesfully deleted");
				
				
				
			}
		});
		btnDeleteRecord.setBounds(332, 307, 156, 25);
		
		frame.getContentPane().add(btnDeleteRecord);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(325, 460, 114, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new Mainframe1();
			}
		});
		frame.getContentPane().add(btnBack);
		frame.setVisible(true);
	}

}
