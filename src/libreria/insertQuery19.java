package libreria;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class insertQuery19 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public insertQuery19() {
		setTitle("RECENSIONI OPERA");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 788, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel operaLabel = new JLabel("Inserisci l'ID dell'opera di cui vuoi vedere le recensioni:");
		operaLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		operaLabel.setBounds(10, 52, 381, 27);
		contentPane.add(operaLabel);
		
		idField = new JTextField();
		idField.setFont(new Font("Tahoma", Font.BOLD, 14));
		idField.setBounds(10, 92, 118, 35);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JLabel recensioniLabel = new JLabel("Le recensioni:");
		recensioniLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		recensioniLabel.setBounds(401, 52, 237, 27);
		contentPane.add(recensioniLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(401, 85, 361, 235);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton showButton = new JButton("MOSTRA");
		showButton.setBackground(new Color(255, 255, 255));
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String b = "SELECT opera, titolo, testo, voto FROM recensione WHERE opera ="+idField.getText()+";";
					PreparedStatement s = Login.con.prepareStatement (b);
					ResultSet rso = s.executeQuery(b);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					String[] colName = new String[4];
					colName[0] = "OPERA";
					colName[1] = "TITOLO";
					colName[2] = "TESTO";
					colName[3] = "VOTO";
					model.setColumnIdentifiers(colName);
					String opera, titolo, testo, voto;
					while(rso.next()) {
						opera = rso.getString(1);
						titolo = rso.getString(2);
						testo = rso.getString(3);
						voto = rso.getString(4);
						String[] row = {opera, titolo, testo, voto};
						model.addRow(row);
					}
					s.close();
					
				}catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		showButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		showButton.setBounds(111, 174, 118, 35);
		contentPane.add(showButton);
		
		JButton closeButton = new JButton("CHIUDI");
		closeButton.setBackground(new Color(255, 255, 255));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeButton.setBounds(111, 228, 118, 35);
		contentPane.add(closeButton);
	}

}
