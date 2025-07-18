package libreria;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class insertQuery8 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField IDField;
	
	/**
	 * Create the frame.
	 */
	public insertQuery8() {
		setTitle("RIMUOVI ORDINE");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(301, 59, 246, 217);
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
		
		JLabel indexLabel = new JLabel("Inserisci l'ID dell'ordine da rimuovere:");
		indexLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		indexLabel.setBounds(10, 105, 281, 34);
		contentPane.add(indexLabel);
		
		IDField = new JTextField();
		IDField.setFont(new Font("Tahoma", Font.BOLD, 14));
		IDField.setBounds(10, 143, 157, 34);
		contentPane.add(IDField);
		IDField.setColumns(10);
		
		JButton removeButton = new JButton("RIMUOVI");
		removeButton.setBackground(new Color(255, 255, 255));
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query8 = "DELETE FROM ordine WHERE idOrdine=? && stato = 0 && accountref =\""+Login.user+"\";";
					PreparedStatement ps8 = Login.con.prepareStatement(query8);
					ps8.setString(1, IDField.getText());
					int r = ps8.executeUpdate();
					if(r!= 0) {
						JOptionPane.showMessageDialog(removeButton, "ORDINE RIMOSSO");
						setVisible(false);
						dispose();
						ps8.close();
					}
					else
						JOptionPane.showMessageDialog(removeButton, "ORDINE NON RIMOSSO");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		removeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		removeButton.setBounds(89, 213, 115, 37);
		contentPane.add(removeButton);
		
		JLabel listLabel = new JLabel("I tuoi ordini in corso:");
		listLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		listLabel.setBounds(301, 32, 191, 26);
		contentPane.add(listLabel);
		
		JButton closeButton = new JButton("CHIUDI");
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		closeButton.setBackground(new Color(255, 255, 255));
		closeButton.setBounds(89, 270, 115, 32);
		contentPane.add(closeButton);
	}
}
