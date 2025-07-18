package libreria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class index extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public index() {
		setTitle("LIBRERIA");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton logButton = new JButton("ACCEDI");
		logButton.setBackground(new Color(255, 255, 255));
		logButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Login frame = new Login();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		logButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		logButton.setBounds(126, 172, 162, 42);
		contentPane.add(logButton);
		
		JButton regButton = new JButton("REGISTRATI");
		regButton.setBackground(new Color(255, 255, 255));
		regButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Registration frame = new Registration();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		regButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		regButton.setBounds(126, 67, 162, 42);
		contentPane.add(regButton);
		
		JButton closeButton = new JButton("CHIUDI");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		closeButton.setBackground(new Color(255, 255, 255));
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeButton.setBounds(166, 267, 89, 31);
		contentPane.add(closeButton);
	}
}
