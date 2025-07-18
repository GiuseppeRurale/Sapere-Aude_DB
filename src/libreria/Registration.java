package libreria;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Registration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField birthdateField;
	private JTextField lnameField;
	private JTextField countryField;
	private JTextField usernameField;
	private JTextField emailField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public Registration() {
		setType(Type.UTILITY);
		setTitle("Registrazione");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLabel = new JLabel("Nome:");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameLabel.setBounds(22, 36, 66, 17);
		contentPane.add(nameLabel);
		
		JLabel lnameLabel = new JLabel("Cognome:");
		lnameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lnameLabel.setBounds(231, 33, 82, 23);
		contentPane.add(lnameLabel);
		
		JLabel usernameLabel = new JLabel("username:");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernameLabel.setBounds(22, 203, 82, 23);
		contentPane.add(usernameLabel);
		
		JLabel emailLabel = new JLabel("e-mail:");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		emailLabel.setBounds(231, 203, 66, 23);
		contentPane.add(emailLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordLabel.setBounds(22, 285, 100, 23);
		contentPane.add(passwordLabel);
		
		JLabel birthdateLabel = new JLabel("Data di Nascita:");
		birthdateLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		birthdateLabel.setBounds(22, 119, 120, 26);
		contentPane.add(birthdateLabel);
		
		JLabel countryLabel = new JLabel("Nazionalità:");
		countryLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		countryLabel.setBounds(231, 121, 100, 23);
		contentPane.add(countryLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameField.setBounds(22, 64, 173, 26);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		birthdateField = new JTextField();
		birthdateField.setText("aaaa/mm/gg");
		birthdateField.setFont(new Font("Tahoma", Font.BOLD, 14));
		birthdateField.setColumns(10);
		birthdateField.setBounds(22, 156, 173, 26);
		contentPane.add(birthdateField);
		
		lnameField = new JTextField();
		lnameField.setFont(new Font("Tahoma", Font.BOLD, 14));
		lnameField.setColumns(10);
		lnameField.setBounds(231, 64, 173, 26);
		contentPane.add(lnameField);
		
		countryField = new JTextField();
		countryField.setFont(new Font("Tahoma", Font.BOLD, 14));
		countryField.setColumns(10);
		countryField.setBounds(231, 156, 173, 26);
		contentPane.add(countryField);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernameField.setColumns(10);
		usernameField.setBounds(22, 237, 173, 26);
		contentPane.add(usernameField);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Tahoma", Font.BOLD, 14));
		emailField.setColumns(10);
		emailField.setBounds(231, 237, 173, 26);
		contentPane.add(emailField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(22, 313, 173, 23);
		contentPane.add(passwordField);
		
		JButton sendButton = new JButton("INVIA");
		sendButton.setBackground(new Color(255, 255, 255));
		sendButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/libreria","root","<password>");
					String query1 = "INSERT INTO accountuser(username, nome, cognome, email, passw, dataNascita, nazionalita) VALUES (?, ?, ?, ?, ?, ?, ?);";
					PreparedStatement ps1 = con.prepareStatement(query1);
					ps1.setString(1, usernameField.getText());
					ps1.setString(2, nameField.getText());
					ps1.setString(3, lnameField.getText());
					ps1.setString(4, emailField.getText());
					ps1.setString(5, passwordField.getText());
					ps1.setString(6, birthdateField.getText());
					ps1.setString(7, countryField.getText());
					
					ps1.executeUpdate();
					JOptionPane.showMessageDialog(sendButton, "Registrazione effettuata!");
					ps1.close();
					con.close();
					setVisible(false);
					dispose();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		sendButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		sendButton.setBounds(74, 376, 89, 32);
		contentPane.add(sendButton);
		
		JButton clearButton = new JButton("CLEAR");
		clearButton.setBackground(new Color(255, 255, 255));
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");
				lnameField.setText("");
				usernameField.setText("");
				emailField.setText("");
				birthdateField.setText("");
				countryField.setText("");
				passwordField.setText("");
			}
		});
		clearButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		clearButton.setBounds(208, 376, 105, 32);
		contentPane.add(clearButton);
		
		JButton closeButton = new JButton("CHIUDI");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		closeButton.setBackground(new Color(255, 255, 255));
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeButton.setBounds(138, 418, 105, 32);
		contentPane.add(closeButton);
	}
}
