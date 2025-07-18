package libreria;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class query9 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public query9() {
		setTitle("I TUOI ORDINI");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 544, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel indexLabel = new JLabel("I tuoi ordini:");
		indexLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		indexLabel.setBounds(20, 28, 112, 31);
		contentPane.add(indexLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 60, 498, 190);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			String o = "SELECT idOrdine, importoTotale, dataOrdine, stato FROM ordine WHERE accountref =\""+Login.user+"\";";
			PreparedStatement s = Login.con.prepareStatement (o);
			ResultSet rso = s.executeQuery(o);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			String[] colName = new String[4];
			colName[0] = "ID";
			colName[1] = "DATA e ORA";
			colName[2] = "IMPORTO";
			colName[3] = "STATO";
			model.setColumnIdentifiers(colName);
			String id, date, imp, x;
			while(rso.next()) {
				id = rso.getString(1);
				date = rso.getString(2);
				imp = rso.getString(3);
				x = rso.getString(4);
				if(x.equals("0"))
					x = "IN CORSO" ;
				else
					x = "COMPLETATO";
				String[] row = {id, imp, date, x};
				model.addRow(row);
			}
			s.close();
			
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton closeButton = new JButton("CHIUDI");
		closeButton.setBackground(new Color(255, 255, 255));
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		closeButton.setBounds(221, 275, 89, 31);
		contentPane.add(closeButton);
	}

}
