package libreria;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class insertQuery14 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ordineField;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public insertQuery14() {
		setTitle("COMPLETA ORDINE");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 788, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ordineLabel = new JLabel("Inserisci l'ID dell'ordine da completare:");
		ordineLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		ordineLabel.setBounds(10, 52, 359, 27);
		contentPane.add(ordineLabel);
		
		ordineField = new JTextField();
		ordineField.setFont(new Font("Tahoma", Font.BOLD, 14));
		ordineField.setBounds(10, 92, 118, 35);
		contentPane.add(ordineField);
		ordineField.setColumns(10);
		
		JLabel tableLabel = new JLabel("I tuoi ordini in corso:");
		tableLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		tableLabel.setBounds(401, 52, 237, 27);
		contentPane.add(tableLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(401, 85, 361, 235);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			String o = "SELECT idOrdine, importoTotale, dataOrdine FROM ordine WHERE accountref =\""+Login.user+"\" AND stato = 0;";
			PreparedStatement s = Login.con.prepareStatement (o);
			ResultSet rso = s.executeQuery(o);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			String[] colName = new String[3];
			colName[0] = "ID";
			colName[1] = "IMPORTO";
			colName[2] = "DATA";
			model.setColumnIdentifiers(colName);
			String id, imp, date;
			while(rso.next()) {
				id = rso.getString(1);
				imp = rso.getString(2);
				date = rso.getString(3);
				String[] row = {id, imp, date};
				model.addRow(row);
			}
			s.close();
			
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton addButton = new JButton("INVIA");
		addButton.setBackground(new Color(255, 255, 255));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query14 = "UPDATE ordine SET stato = 1 WHERE idOrdine = ?;";
					PreparedStatement ps14 = Login.con.prepareStatement(query14);
					ps14.setString(1, ordineField.getText());
					int r = ps14.executeUpdate();
					if(r!=0) {
					JOptionPane.showMessageDialog(addButton, "ORDINE COMPLETATO");
					ps14.close();
					setVisible(false);
					dispose();
					}
					else
						JOptionPane.showMessageDialog(addButton, "ERRORE, IMPOSSIBILE COMPLETARE L'ORDINE");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		addButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		addButton.setBounds(111, 164, 118, 35);
		contentPane.add(addButton);
		
		JButton closeButton = new JButton("CHIUDI");
		closeButton.setBackground(new Color(255, 255, 255));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeButton.setBounds(111, 223, 118, 35);
		contentPane.add(closeButton);
	}
}
