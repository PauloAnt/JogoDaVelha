package projeto_poo;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaDoJogo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JLabel label;

	/**
	 * Create the panel.
	 */
	public TelaDoJogo() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(196, 99, 1, 1);
		add(table);
		
		button = new JButton("");
		button.setBounds(92, 16, 89, 65);
		add(button);
		
		button_1 = new JButton("");
		button_1.setBounds(181, 16, 89, 65);
		add(button_1);
		
		button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(270, 16, 89, 65);
		add(button_2);
		
		button_3 = new JButton("");
		button_3.setBounds(92, 81, 89, 65);
		add(button_3);
		
		button_4 = new JButton("");
		button_4.setBounds(181, 81, 89, 64);
		add(button_4);
		
		button_5 = new JButton("");
		button_5.setBounds(270, 81, 89, 64);
		add(button_5);
		
		button_6 = new JButton("");
		button_6.setBounds(92, 146, 89, 65);
		add(button_6);
		
		button_7 = new JButton("");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_7.setBounds(181, 146, 89, 65);
		add(button_7);
		
		button_8 = new JButton("");
		button_8.setBounds(270, 146, 89, 65);
		add(button_8);
		
		button_9 = new JButton("Reiniciar");
		button_9.setEnabled(false);
		button_9.setBounds(181, 266, 89, 23);
		add(button_9);
		
		label = new JLabel("");
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		label.setBounds(92, 232, 267, 23);
		add(label);

	}
}
