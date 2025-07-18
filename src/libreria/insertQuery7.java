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
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class insertQuery7 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField numberField;

	/**
	 * Create the frame.
	 */
	public insertQuery7() {
		setTitle("CREA UN ORDINE");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel indexLabel = new JLabel("Inserisci il numero della carta di credito da utilizzare per l'ordine:");
		indexLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		indexLabel.setBounds(10, 27, 414, 93);
		contentPane.add(indexLabel);
		
		numberField = new JTextField();
		numberField.setFont(new Font("Tahoma", Font.BOLD, 14));
		numberField.setBounds(91, 106, 237, 32);
		contentPane.add(numberField);
		numberField.setColumns(10);
		
		JButton sendButton = new JButton("FATTO");
		sendButton.setBackground(new Color(255, 255, 255));
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query7 = "INSERT INTO ordine(dataOrdine, accountref, creditCard) VALUES(NOW(), ?, ?);";
					PreparedStatement ps7 = Login.con.prepareStatement(query7);
					ps7.setString(1, Login.user);
					ps7.setString(2, numberField.getText());
					int rs = ps7.executeUpdate();
					if(rs != 0) {
						String msg = "ORDINE AGGIUNTO";
						JOptionPane.showMessageDialog(sendButton, msg);
						setVisible(false);
						dispose();						
					}
					else{
					String errmsg = "ERRORE, CARTA DI CREDITO NON REGISTRATA!";
					JOptionPane.showMessageDialog(sendButton, errmsg);
					}
				}catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		sendButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		sendButton.setBounds(82, 161, 89, 32);
		contentPane.add(sendButton);
		
		JButton showCardButton = new JButton("MOSTRAMI LE MIE CARTE");
		showCardButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		showCardButton.setBackground(new Color(255, 255, 255));
		showCardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							printCards frame = new printCards();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		showCardButton.setBounds(190, 164, 221, 30);
		contentPane.add(showCardButton);
		
		JButton closeButton = new JButton("CHIUDI");
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeButton.setBackground(new Color(255, 255, 255));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		closeButton.setBounds(173, 229, 89, 32);
		contentPane.add(closeButton);
	}

}
