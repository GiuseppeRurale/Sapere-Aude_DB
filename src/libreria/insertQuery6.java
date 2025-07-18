package libreria;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class insertQuery6 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField numberCardField;
	private JTextField CVVField;
	private JTextField scadenzaField;
	private JLabel lblIntestatario;
	private JTextField ownerField;
	private JButton sendButton;
	private JButton clearButton;
	private JButton closeButton;

	/**
	 * Create the frame.
	 */
	public insertQuery6() {
		setBackground(new Color(240, 240, 240));
		setTitle("AGGIUNGI CARTA DI CREDITO");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 389, 472);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel numberCardLabel = new JLabel("Numero Carta:");
		numberCardLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		numberCardLabel.setBounds(31, 26, 144, 28);
		getContentPane().add(numberCardLabel);
		
		numberCardField = new JTextField();
		numberCardField.setFont(new Font("Tahoma", Font.BOLD, 14));
		numberCardField.setBounds(31, 57, 226, 33);
		getContentPane().add(numberCardField);
		numberCardField.setColumns(10);
		
		JLabel CVVLabel = new JLabel("CVV:");
		CVVLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		CVVLabel.setBounds(31, 101, 64, 28);
		getContentPane().add(CVVLabel);
		
		CVVField = new JTextField();
		CVVField.setFont(new Font("Tahoma", Font.BOLD, 14));
		CVVField.setColumns(10);
		CVVField.setBounds(31, 129, 86, 33);
		getContentPane().add(CVVField);
		
		JLabel scadenzaLabel = new JLabel("Scadenza:");
		scadenzaLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		scadenzaLabel.setBounds(210, 101, 122, 28);
		getContentPane().add(scadenzaLabel);
		
		scadenzaField = new JTextField();
		scadenzaField.setText("aaaa/mm");
		scadenzaField.setFont(new Font("Tahoma", Font.BOLD, 14));
		scadenzaField.setBounds(210, 129, 122, 33);
		getContentPane().add(scadenzaField);
		scadenzaField.setColumns(10);
		
		lblIntestatario = new JLabel("Intestatario:");
		lblIntestatario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIntestatario.setBounds(31, 173, 144, 28);
		getContentPane().add(lblIntestatario);
		
		ownerField = new JTextField();
		ownerField.setFont(new Font("Tahoma", Font.BOLD, 14));
		ownerField.setColumns(10);
		ownerField.setBounds(31, 204, 226, 33);
		getContentPane().add(ownerField);
		
		sendButton = new JButton("INVIA");
		sendButton.setBackground(new Color(255, 255, 255));
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query6 = "INSERT INTO creditcard(numeroCarta, codiceSicurezza, scadenza, intestatario, accountref) VALUES(?, ?, ?, ?, ?);";
					PreparedStatement ps6 = Login.con.prepareStatement(query6);
					ps6.setString(1, numberCardField.getText());
					ps6.setString(2, CVVField.getText());
					ps6.setString(3, scadenzaField.getText());
					ps6.setString(4, ownerField.getText());
					ps6.setString(5, Login.user);
					int rs = ps6.executeUpdate();
					if(rs != 0) {
						String msg = "CARTA DI CREDITO AGGIUNTA";
						JOptionPane.showMessageDialog(sendButton, msg);
						setVisible(false);
						dispose();						
					}
					else{
					String errmsg = "ERRORE, IMPOSSIBILE AGGIUNGERE LA CARTA DI CREDITO!";
					JOptionPane.showMessageDialog(sendButton, errmsg);
					}
				}catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		sendButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		sendButton.setBounds(131, 277, 89, 33);
		getContentPane().add(sendButton);
		
		clearButton = new JButton("CLEAR");
		clearButton.setBackground(new Color(255, 255, 255));
		clearButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberCardField.setText("");
				ownerField.setText("");
				scadenzaField.setText("");
				CVVField.setText("");
			}
		});
		clearButton.setBounds(131, 327, 89, 33);
		contentPane.add(clearButton);
		
		closeButton = new JButton("CHIUDI");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		closeButton.setBackground(new Color(255, 255, 255));
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeButton.setBounds(131, 375, 89, 33);
		contentPane.add(closeButton);

	}

}
