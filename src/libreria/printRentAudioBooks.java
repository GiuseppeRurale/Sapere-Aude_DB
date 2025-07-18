package libreria;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class printRentAudioBooks extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public printRentAudioBooks() {
		setType(Type.UTILITY);
		setTitle("AUDIOLIBRI");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel indexLabel = new JLabel("Catalogo Audiolibri:");
		indexLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		indexLabel.setBounds(10, 33, 203, 28);
		contentPane.add(indexLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 586, 195);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			String b = "SELECT idOpera, opera.nome, mediaVoti, autore.nome, durata, linguaAudio, costoNoleggio FROM opera INNER JOIN audiolibro INNER JOIN autore ON idOpera = opera && autore=idAutore;";
			PreparedStatement s = Login.con.prepareStatement (b);
			ResultSet rso = s.executeQuery(b);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			String[] colName = new String[7];
			colName[0] = "ID";
			colName[1] = "NOME";
			colName[2] = "VALUTAZIONE";
			colName[3] = "AUTORE";
			colName[4] = "DURATA";
			colName[5] = "LINGUA";
			colName[6] = "PREZZO";
			model.setColumnIdentifiers(colName);
			String id, nome, voto, autore, durata, lingua, prezzo;
			while(rso.next()) {
				id = rso.getString(1);
				nome = rso.getString(2);
				voto = rso.getString(3);
				autore = rso.getString(4);
				durata = rso.getString(5);
				lingua = rso.getString(6);
				prezzo = rso.getString(7);
				String[] row = {id, nome, voto, autore, durata, lingua, prezzo};
				model.addRow(row);
			}
			s.close();
			
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton closeButton = new JButton("CHIUDI");
		closeButton.setBackground(new Color(255, 255, 255));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeButton.setBounds(269, 310, 89, 37);
		contentPane.add(closeButton);
	}

}
