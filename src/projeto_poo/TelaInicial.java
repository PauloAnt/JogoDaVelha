package projeto_poo;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JRadioButton radioX, radioO, radioFacil, radioDificil;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TelaInicial frame = new TelaInicial();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TelaInicial() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel titulo = new JLabel("Jogo da Velha");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
        titulo.setBounds(109, 37, 227, 46);
        contentPane.add(titulo);

        JButton btn2Jogadores = new JButton("2 jogadores");
        btn2Jogadores.setBounds(62, 130, 109, 39);
        contentPane.add(btn2Jogadores);

        JButton btnContraMaquina = new JButton("VS máquina");
        btnContraMaquina.setBounds(260, 130, 109, 39);
        contentPane.add(btnContraMaquina);

        radioX = new JRadioButton("X");
        radioX.setSelected(true);
        radioX.setBounds(93, 196, 46, 23);
        contentPane.add(radioX);

        radioO = new JRadioButton("O");
        radioO.setBounds(93, 222, 46, 23);
        contentPane.add(radioO);

        radioFacil = new JRadioButton("Fácil");
        radioFacil.setSelected(true);
        radioFacil.setBounds(288, 196, 69, 23);
        contentPane.add(radioFacil);

        radioDificil = new JRadioButton("Difícil");
        radioDificil.setBounds(288, 222, 69, 23);
        contentPane.add(radioDificil);

        JLabel lblSimbolo = new JLabel("Símbolo");
        lblSimbolo.setHorizontalAlignment(SwingConstants.CENTER);
        lblSimbolo.setBounds(93, 175, 46, 14);
        contentPane.add(lblSimbolo);

        JLabel lblNivel = new JLabel("Nível");
        lblNivel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNivel.setBounds(290, 175, 46, 14);
        contentPane.add(lblNivel);

        ButtonGroup grupoSimbolos = new ButtonGroup();
        grupoSimbolos.add(radioX);
        grupoSimbolos.add(radioO);

        ButtonGroup grupoNivel = new ButtonGroup();
        grupoNivel.add(radioFacil);
        grupoNivel.add(radioDificil);

        // Ação para 2 jogadores
        btn2Jogadores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String simbolo1 = radioX.isSelected() ? "X" : "O";
                String simbolo2 = simbolo1.equals("X") ? "O" : "X";

                TelaDoJogo jogoPainel = new TelaDoJogo(simbolo1, simbolo2, false, 0); // modo 2 jogadores
                JFrame frameJogo = new JFrame("Jogo da Velha");
                frameJogo.setContentPane(jogoPainel);
                frameJogo.setSize(450, 350);
                frameJogo.setLocationRelativeTo(null);
                frameJogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameJogo.setVisible(true);
                dispose(); // fecha a tela inicial
            }
        });

        // Ação para jogar contra máquina
        btnContraMaquina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int nivel = radioFacil.isSelected() ? 1 : 2;

                String simboloJogador = radioX.isSelected() ? "X" : "O";

                // O JogoDaVelha atribui o símbolo da máquina automaticamente
                TelaDoJogo painelJogo = new TelaDoJogo(simboloJogador, null, true, nivel);

                JFrame frameJogo = new JFrame("Jogo da Velha");
                frameJogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameJogo.setSize(450, 350);
                frameJogo.setContentPane(painelJogo);
                frameJogo.setLocationRelativeTo(null);
                frameJogo.setVisible(true);

                dispose(); // fecha a tela inicial
            }
        });
    }
}
