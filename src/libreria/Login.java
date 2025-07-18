package libreria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;


public class Login extends JFrame {
	public static String user;
	public static Connection con;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Accesso");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 373, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLabel = new JLabel("username");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernameLabel.setBounds(28, 68, 109, 34);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("password");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordLabel.setBounds(28, 147, 80, 23);
		contentPane.add(passwordLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(28, 102, 200, 34);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JButton loginButton = new JButton("ACCEDI");
		loginButton.setBackground(new Color(255, 255, 255));
		loginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				user = usernameField.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3307/libreria","root","<password>");
						String s = "SELECT* FROM accountuser where username = ? AND passw = ?;";
						PreparedStatement ps2 = con.prepareStatement(s);
						ps2.setString(1, usernameField.getText());
						ps2.setString(2, passwordField.getText());
						ResultSet rs = ps2.executeQuery();
						if(rs.next()) {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										home frame = new home();
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
							ps2.close();
							setVisible(false);
							dispose();
							
						}
						else{
						String msg = "USERNAME O PASSWORD ERRATI!!";
						JOptionPane.showMessageDialog(loginButton, msg);
						ps2.close();
						con.close();
						}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginButton.setBounds(128, 262, 100, 34);
		contentPane.add(loginButton);
		
		JLabel titleLabel = new JLabel("EFFETTUA L'ACCESSO");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		titleLabel.setBounds(88, 24, 214, 34);
		contentPane.add(titleLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(28, 181, 200, 34);
		contentPane.add(passwordField);
		
		JLabel outLabel = new JLabel("");
		outLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		outLabel.setForeground(new Color(255, 0, 0));
		outLabel.setBounds(28, 222, 200, 29);
		contentPane.add(outLabel);
		
		JButton closeButton = new JButton("CHIUDI");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeButton.setBackground(new Color(255, 255, 255));
		closeButton.setBounds(128, 315, 100, 34);
		contentPane.add(closeButton);
	}
}
