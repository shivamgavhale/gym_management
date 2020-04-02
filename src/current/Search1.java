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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;


public class Search1 {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public String value1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search1 window = new Search1();
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
	public Search1() {
		try {
			initialize();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 800, 600);
		// frame.setBounds(550, 250, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Class.forName("java.sql.DriverManager");
        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "shivam", "password");
        Statement stmt = con.createStatement();
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				
				Mainframe1 window = new Mainframe1();
				 window.frame.setVisible(true);
			}
		});
		btnBack.setBounds(286, 471, 114, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel lblEnterId = new JLabel("ENTER ID");
		lblEnterId.setBounds(59, 232, 84, 25);
		frame.getContentPane().add(lblEnterId);
		
		textField = new JTextField();
		textField.setBounds(163, 235, 124, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
        
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				value1=textField.getText();
				
		        //System.out.println(value1); 
		        

		        String query = "select * from gymdetails where ID='"+value1+"'";
		        //String query = "select * from gymdetails where ID=1";
		        ResultSet rs;
		        System.out.println(value1);
		
					
			
		        try {
		        	rs = stmt.executeQuery(query);
					if(rs.next())
					{
						textField_1.setText(rs.getString(1));
						textField_2.setText(rs.getString(2));
						textField_3.setText(rs.getString(3));
						textField_4.setText(rs.getString(5));
						textField_5.setText(rs.getString(4));
						String b=rs.getString(7);
					
					
						
						
					}
					//JOptionPane.showMessageDialog(null, "Details Searched Successfully");
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnOk.setBounds(105, 269, 114, 25);
		frame.getContentPane().add(btnOk);
		
		JLabel lblMemberDetails = new JLabel("DETAILS");
		lblMemberDetails.setBounds(538, 131, 150, 36);
		frame.getContentPane().add(lblMemberDetails);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(447, 199, 66, 15);
		frame.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(447, 242, 66, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setBounds(447, 294, 66, 15);
		frame.getContentPane().add(lblAge);
		
		JLabel lblWeight = new JLabel("WEIGHT");
		lblWeight.setBounds(447, 336, 66, 15);
		frame.getContentPane().add(lblWeight);
		
		JLabel lblHeight = new JLabel("HEIGHT");
		lblHeight.setBounds(447, 382, 66, 15);
		frame.getContentPane().add(lblHeight);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(564, 197, 124, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(564, 240, 124, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(564, 292, 124, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(564, 334, 124, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(564, 380, 124, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
	}
}
