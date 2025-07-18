package libreria;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class insertQuery15 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public insertQuery15() {
		setTitle("LASCIA UNA RECENSIONE");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1069, 700);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(355, 162));
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Titolo:");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleLabel.setBounds(34, 127, 68, 46);
		contentPane.add(titleLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.BOLD, 14));
		textArea.setMaximumSize(new Dimension(104, 146));
		textArea.setName("");
		textArea.setMargin(new Insets(1, 1, 1, 1));
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setAutoscrolls(false);
		textArea.setLineWrap(true);
		textArea.setBounds(34, 281, 355, 162);
		contentPane.add(textArea);
		
		JLabel textLabel = new JLabel("Testo:");
		textLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		textLabel.setBounds(34, 247, 68, 20);
		contentPane.add(textLabel);
		
		JLabel votoLabel = new JLabel("Voto:");
		votoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		votoLabel.setBounds(34, 492, 68, 20);
		contentPane.add(votoLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(5, 1, 5, 1));
		spinner.setFont(new Font("Tahoma", Font.BOLD, 14));
		spinner.setBounds(83, 480, 62, 46);
		contentPane.add(spinner);
		
		JLabel idLabel = new JLabel("Inserisci l'ID dell'opera da recensire ");
		idLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		idLabel.setBounds(34, 39, 355, 33);
		contentPane.add(idLabel);
		
		idField = new JTextField();
		idField.setFont(new Font("Tahoma", Font.BOLD, 14));
		idField.setColumns(10);
		idField.setBorder(new LineBorder(new Color(171, 173, 179)));
		idField.setBounds(34, 83, 77, 33);
		contentPane.add(idField);
		
		JTextArea titleArea = new JTextArea();
		titleArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		titleArea.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleArea.setMaximumSize(new Dimension(355, 65));
		titleArea.setLineWrap(true);
		titleArea.setBounds(34, 160, 355, 65);
		contentPane.add(titleArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(487, 94, 450, 349);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		try {
			String a = "SELECT DISTINCT idOpera, opera.nome, mediaVoti, autore.nome, categoria FROM ordine INNER JOIN acquistopera INNER JOIN opera INNER JOIN autore ON idOrdine = acquistopera.ordine && acquistopera.opera = idOpera && autore = idAutore WHERE accountref =\""+Login.user+"\" && stato = 1;";
			String b = "SELECT DISTINCT idOpera, opera.nome, mediaVoti, autore.nome, categoria FROM ordine INNER JOIN noleggiopera INNER JOIN opera INNER JOIN autore ON idOrdine = noleggiopera.ordine && noleggiopera.opera = idOpera && autore = idAutore WHERE accountref =\""+Login.user+"\" && stato = 1;";
			PreparedStatement s = Login.con.prepareStatement (a);
			ResultSet rsa = s.executeQuery(a);
			PreparedStatement s2 = Login.con.prepareStatement (b);
			ResultSet rsb = s2.executeQuery(b);
			
			String[] colName = new String[5];
			colName[0] = "ID";
			colName[1] = "NOME";
			colName[2] = "VALUTAZIONE";
			colName[3] = "AUTORE";
			colName[4] = "CATEGORIA";
			
			model.setColumnIdentifiers(colName);
			String id, nome, voto, autore, categoria;
			while(rsa.next()) {
				id = rsa.getString(1);
				nome = rsa.getString(2);
				voto = rsa.getString(3);
				autore = rsa.getString(4);
				categoria = rsa.getString(5);
				String[] row = {id, nome, voto, autore, categoria};
				model.addRow(row);
			}
			while(rsb.next()) {
				id = rsb.getString(1);
				nome = rsb.getString(2);
				voto = rsb.getString(3);
				autore = rsb.getString(4);
				categoria = rsb.getString(5);
				String[] row2 = {id, nome, voto, autore, categoria};
				model.addRow(row2);
			}
			s.close();
			s2.close();
			
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel booksLabel = new JLabel("Le opere che hai acquistato e noleggiato:");
		booksLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		booksLabel.setBounds(487, 63, 293, 20);
		contentPane.add(booksLabel);
		
		JButton sendButton = new JButton("INVIA");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				String query15 = "INSERT INTO recensione(titolo, testo, voto, data, accountref, opera) VALUES(?, ?, ?, NOW(), ?, ?);";
				PreparedStatement ps15 = Login.con.prepareStatement(query15);
				ps15.setString(1, titleArea.getText());
				ps15.setString(2, textArea.getText());
				ps15.setInt(3, (int)spinner.getValue());
				ps15.setString(4, Login.user);
				ps15.setString(5, idField.getText());
				String query152 = "UPDATE opera SET mediaVoti = (SELECT AVG(voto)FROM recensione WHERE opera = ?) WHERE idOpera = ?;";
				PreparedStatement ps152 = Login.con.prepareStatement(query152);
				ps152.setString(1, idField.getText());
				ps152.setString(2, idField.getText());
				int r = ps15.executeUpdate();
				int r2 = ps152.executeUpdate();
				if(r!=0 && r2!=0) {
				JOptionPane.showMessageDialog(sendButton, "RECENSIONE AGGIUNTA");
				ps15.close();
				ps152.close();
				setVisible(false);
				dispose();
				}
				else
					JOptionPane.showMessageDialog(sendButton, "ERRORE, RECENSIONE NON AGGIUNTA");
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		sendButton.setBackground(new Color(255, 255, 255));
		sendButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		sendButton.setBounds(435, 509, 108, 46);
		contentPane.add(sendButton);
		
		JButton clearButton = new JButton("CLEAR");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleArea.setText("");
				textArea.setText("");
				idField.setText("");
			
			}
		});
		clearButton.setBackground(new Color(255, 255, 255));
		clearButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		clearButton.setBounds(143, 562, 89, 39);
		contentPane.add(clearButton);
		
		JButton closeButton = new JButton("CHIUDI");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeButton.setBackground(Color.WHITE);
		closeButton.setBounds(435, 583, 108, 46);
		contentPane.add(closeButton);
	}
}
