package libreria;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class printCards extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbl;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public printCards() {
		setTitle("CARTE DI CREDITO");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 22, 320, 277);
		contentPane.add(scrollPane);
		
		tbl = new JTable();
		scrollPane.setViewportView(tbl);
		
		JButton closeButton = new JButton("CHIUDI");
		closeButton.setBackground(new Color(255, 255, 255));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeButton.setBounds(161, 310, 89, 36);
		contentPane.add(closeButton);
		
		try {
			String c = "SELECT numeroCarta, scadenza FROM creditcard WHERE accountref =\""+Login.user+"\";";
			PreparedStatement s = Login.con.prepareStatement(c);
			ResultSet rscd = s.executeQuery(c);
			DefaultTableModel model = (DefaultTableModel) tbl.getModel();
			
			String[] colName = new String[2];
			colName[0] = "NUMERO";
			colName[1] = "SCADENZA";
			model.setColumnIdentifiers(colName);
			String number, date;
			while(rscd.next()) {
				number = rscd.getString(1);
				date = rscd.getString(2);
				String[] row = {number, date};
				model.addRow(row);
			}
			s.close();
			
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
