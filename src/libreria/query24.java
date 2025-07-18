package libreria;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class query24 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public query24() {
		setBackground(new Color(135, 225, 176));
		setTitle("AUDIOLIBRI ACQUISTATI");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 567, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel indexLabel = new JLabel("Gli audiolibri che hai acquistato:");
		indexLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		indexLabel.setBounds(10, 11, 336, 27);
		contentPane.add(indexLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 50, 510, 238);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		try {
			String l = "SELECT opera.nome, mediaVoti, autore.nome, categoria, durata, linguaAudio FROM ordine INNER JOIN acquistopera INNER JOIN opera INNER JOIN autore INNER JOIN audiolibro ON idOrdine = ordine && acquistopera.opera = idOpera && autore = idAutore && audiolibro.opera = idOpera WHERE accountref =\""+Login.user+"\" && stato = 1 && tipoOpera = 1;";
			PreparedStatement s = Login.con.prepareStatement (l);
			ResultSet rs = s.executeQuery(l);
			
			String[] colName = new String[6];
			colName[0] = "NOME";
			colName[1] = "VALUTAZIONE";
			colName[2] = "AUTORE";
			colName[3] = "CATEGORIA";
			colName[4] = "DURATA";
			colName[5] = "LINGUA";
			
			model.setColumnIdentifiers(colName);
			String nome, voto, autore, categoria, durata, lingua;
			while(rs.next()) {
				nome = rs.getString(1);
				voto = rs.getString(2);
				autore = rs.getString(3);
				categoria = rs.getString(4);
				durata = rs.getString(5);
				lingua = rs.getString(6);
				String[] row = {nome, voto, autore, categoria, durata, lingua};
				model.addRow(row);
			}
			s.close();
			
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton closeButton = new JButton("CHIUDI");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		closeButton.setBackground(new Color(255, 255, 255));
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeButton.setBounds(231, 300, 89, 33);
		contentPane.add(closeButton);
	}

}