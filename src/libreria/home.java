package libreria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;

public class home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton query6Button;

	/**
	 * Create the frame.
	 */
	public home() {
		setBackground(new Color(240, 240, 240));
		setType(Type.UTILITY);
		setTitle("HOME");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 705, 471);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton query7Button = new JButton("Operazione 7");
		query7Button.setBackground(new Color(255, 255, 255));
		query7Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							insertQuery7 frame = new insertQuery7();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query7Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query7Button.setBounds(195, 55, 146, 33);
		contentPane.add(query7Button);
		
		JButton query8Button = new JButton("Operazione 8");
		query8Button.setBackground(new Color(255, 255, 255));
		query8Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query8Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							insertQuery8 frame = new insertQuery8();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query8Button.setBounds(351, 55, 144, 33);
		contentPane.add(query8Button);
		
		JButton query11Button = new JButton("Operazione 11");
		query11Button.setBackground(new Color(255, 255, 255));
		query11Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							insertQuery11 frame = new insertQuery11();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query11Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query11Button.setBounds(195, 120, 146, 33);
		contentPane.add(query11Button);
		
		JButton query10Button = new JButton("Operazione 10");
		query10Button.setBackground(new Color(255, 255, 255));
		query10Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							insertQuery10 frame = new insertQuery10();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query10Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query10Button.setBounds(39, 120, 146, 33);
		contentPane.add(query10Button);
		
		JButton query9Button = new JButton("Operazione 9");
		query9Button.setBackground(new Color(255, 255, 255));
		query9Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							query9 frame = new query9();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query9Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query9Button.setBounds(505, 55, 146, 33);
		contentPane.add(query9Button);
		
		JButton query12Button = new JButton("Operazione 12");
		query12Button.setBackground(new Color(255, 255, 255));
		query12Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							insertQuery12 frame = new insertQuery12();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query12Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query12Button.setBounds(351, 120, 144, 33);
		contentPane.add(query12Button);
		
		JButton query13Button = new JButton("Operazione 13");
		query13Button.setBackground(new Color(255, 255, 255));
		query13Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							insertQuery13 frame = new insertQuery13();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query13Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query13Button.setBounds(507, 120, 144, 33);
		contentPane.add(query13Button);
		
		JButton query14Button = new JButton("Operazione 14");
		query14Button.setBackground(new Color(255, 255, 255));
		query14Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							insertQuery14 frame = new insertQuery14();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query14Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query14Button.setBounds(39, 179, 146, 33);
		contentPane.add(query14Button);
		
		JButton query15Button = new JButton("Operazione 15");
		query15Button.setBackground(new Color(255, 255, 255));
		query15Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							insertQuery15 frame = new insertQuery15();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query15Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query15Button.setBounds(195, 179, 146, 33);
		contentPane.add(query15Button);
		
		JButton query17Button = new JButton("Operazione 17");
		query17Button.setBackground(new Color(255, 255, 255));
		query17Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							query17 frame = new query17();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query17Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query17Button.setBounds(351, 179, 144, 33);
		contentPane.add(query17Button);
		
		JButton query18Button = new JButton("Operazione 18");
		query18Button.setBackground(new Color(255, 255, 255));
		query18Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							query18 frame = new query18();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query18Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query18Button.setBounds(507, 179, 144, 33);
		contentPane.add(query18Button);
		
		JButton query19Button = new JButton("Operazione 19");
		query19Button.setBackground(new Color(255, 255, 255));
		query19Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							insertQuery19 frame = new insertQuery19();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query19Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query19Button.setBounds(39, 241, 146, 33);
		contentPane.add(query19Button);
		
		JButton query20Button = new JButton("Operazione 20");
		query20Button.setBackground(new Color(255, 255, 255));
		query20Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							query20 frame = new query20();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query20Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query20Button.setBounds(195, 241, 146, 33);
		contentPane.add(query20Button);
		
		JButton query21Button = new JButton("Operazione 21");
		query21Button.setBackground(new Color(255, 255, 255));
		query21Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							query21 frame = new query21();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query21Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query21Button.setBounds(351, 241, 144, 33);
		contentPane.add(query21Button);
		
		JButton query22Button = new JButton("Operazione 22");
		query22Button.setBackground(new Color(255, 255, 255));
		query22Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							query22 frame = new query22();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query22Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query22Button.setBounds(507, 241, 144, 33);
		contentPane.add(query22Button);
		
		JButton query23Button = new JButton("Operazione 23");
		query23Button.setBackground(new Color(255, 255, 255));
		query23Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							query23 frame = new query23();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query23Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query23Button.setBounds(39, 304, 146, 33);
		contentPane.add(query23Button);
		
		JButton query24Button = new JButton("Operazione 24");
		query24Button.setBackground(new Color(255, 255, 255));
		query24Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							query24 frame = new query24();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query24Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query24Button.setBounds(195, 304, 146, 33);
		contentPane.add(query24Button);
		
		JButton query25Button = new JButton("Operazione 25");
		query25Button.setBackground(new Color(255, 255, 255));
		query25Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							query25 frame = new query25();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query25Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query25Button.setBounds(351, 304, 144, 33);
		contentPane.add(query25Button);
		
		query6Button = new JButton("Operazione 6");
		query6Button.setBackground(new Color(255, 255, 255));
		query6Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							insertQuery6 win = new insertQuery6();
							win.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		query6Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		query6Button.setBounds(39, 55, 146, 33);
		contentPane.add(query6Button);
		
		JLabel homeLabel = new JLabel("Scegli l'operazione da eseguire:");
		homeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		homeLabel.setBounds(50, 11, 336, 33);
		contentPane.add(homeLabel);
		
		JButton closeButton = new JButton("CHIUDI");
		closeButton.setBackground(new Color(255, 255, 255));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeButton.setBounds(297, 382, 89, 39);
		contentPane.add(closeButton);
	}
}
