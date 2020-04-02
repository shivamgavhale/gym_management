package current;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class User {
	String user;
	public JFrame frame;
	public JTextField textField;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JTextField textField_6;
	public JTextField textField_7;
	public JTextField textField_1;
	public String value1;
	/**
	 * Launch the application.
	 */	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User window = new User();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public User() throws ClassNotFoundException, SQLException {
		initialize();
	}
	public User(String a) throws SQLException {
		user=a;
		//initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		
		// Normal , Under , Over 
       String[] DietPln = {"fruits, vegetables, whole grains, and fat-free or low-fat milk products,meats, poultry, fish, beans, eggs, and nuts", "milk,rice,Nuts and nut butter,Whole-grain breads,potatoes,corn,Eggs,Yogurt,pasta" , " Vegetables,FruitsNuts and seeds,Herbs and spices , Avoid fast food"};
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 800, 600);
		// frame.setBounds(550, 250, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMemberDetails = new JLabel("Details");
		lblMemberDetails.setBounds(334, 135, 161, 32);
		frame.getContentPane().add(lblMemberDetails);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(287, 191, 66, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(287, 239, 66, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(287, 289, 66, 15);
		frame.getContentPane().add(lblAge);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(287, 335, 66, 15);
		frame.getContentPane().add(lblWeight);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(287, 378, 66, 15);
		frame.getContentPane().add(lblHeight);
		
		JButton btnExit = new JButton("LOGOUT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Login1 frame = new Login1();
				frame.setVisible(true);
			}
		});
		btnExit.setBounds(315, 485, 114, 25);
		frame.getContentPane().add(btnExit);
		
		JLabel lblDietplan = new JLabel("DietPlan");
		lblDietplan.setBounds(287, 428, 66, 15);
		frame.getContentPane().add(lblDietplan);
		
		textField = new JTextField();
		textField.setBounds(371, 426, 417, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(371, 376, 124, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(371, 333, 124, 19);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(371, 287, 124, 19);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(371, 237, 124, 19);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(371, 189, 124, 19);
		textField_7.setText(user);
		frame.getContentPane().add(textField_7);
		
		JLabel lblEnterId = new JLabel("Enter ID");
		lblEnterId.setBounds(221, 99, 66, 15);
		frame.getContentPane().add(lblEnterId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(315, 97, 124, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		
		Class.forName("java.sql.DriverManager");
        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "shivam", "password");
        Statement stmt = con.createStatement();
        
        String member;
       // member=Login1.class.value1;
        JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			value1=textField_1.getText();
			
	        //System.out.println(value1); 
	        

	        String query = "select * from gymdetails where ID='"+value1+"'";
	        //String query = "select * from gymdetails where ID=1";
	        ResultSet rs;
	
				
		
	        try {
	        	rs = stmt.executeQuery(query);
				if(rs.next())
				{
					textField_7.setText(rs.getString(1));
					textField_6.setText(rs.getString(2));
					textField_5.setText(rs.getString(3));
					textField_4.setText(rs.getString(5));
					textField_3.setText(rs.getString(4));
					String b=rs.getString(7);
					Double d= Double.parseDouble(b);
					if(d<18.5) {
						textField.setText(DietPln[1]);
					}
					else if(18.5<=d && d<25) {
						textField.setText(DietPln[0]); 
					}
					else if(d>25) {
						textField.setText(DietPln[2]); 
					}
					
					
				}
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				 
			}
		});
		btnOk.setBounds(451, 94, 114, 25);
		frame.getContentPane().add(btnOk);
		
		JLabel lblBeginYourFitness = new JLabel("BEGIN YOUR FITNESS JOURNEY");
		lblBeginYourFitness.setFont(new Font("Dialog", Font.BOLD, 20));
		lblBeginYourFitness.setBounds(221, 29, 360, 41);
		frame.getContentPane().add(lblBeginYourFitness);
		

		//frame.setVisible(true);
	}

}
