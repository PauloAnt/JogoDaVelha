package projeto_poo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton button;
	private JButton button_1;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Jogo da Velha");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		lblNewLabel.setBounds(109, 37, 227, 46);
		contentPane.add(lblNewLabel);
		
		button = new JButton("2 jogadores");
		button.setBounds(62, 130, 109, 39);
		contentPane.add(button);
		
		button_1 = new JButton("Contra máquina");
		button_1.setBounds(260, 130, 109, 39);
		contentPane.add(button_1);
		
		radioButton = new JRadioButton("X");
		radioButton.setSelected(true);
		radioButton.setBounds(93, 196, 46, 23);
		contentPane.add(radioButton);
		
		radioButton_1 = new JRadioButton("O");
		radioButton_1.setBounds(93, 222, 46, 23);
		contentPane.add(radioButton_1);
		
		radioButton_2 = new JRadioButton("Fácil");
		radioButton_2.setSelected(true);
		radioButton_2.setBounds(288, 196, 69, 23);
		contentPane.add(radioButton_2);
		
		radioButton_3 = new JRadioButton("Difícil");
		radioButton_3.setBounds(288, 222, 69, 23);
		contentPane.add(radioButton_3);
		
		label = new JLabel("Símbolo");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(93, 175, 46, 14);
		contentPane.add(label);
		
		label_1 = new JLabel("Nível");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(290, 175, 46, 14);
		contentPane.add(label_1);
	}
}
