package projeto_poo;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class TelaDoJogo extends JPanel {

    private static final long serialVersionUID = 1L;
    private JButton[] botoes = new JButton[9];
    private JButton botaoReiniciar;
    private JLabel labelResultado;
    private JogoDaVelha jogo;
    private boolean contraMaquina = false;
    private int jogadorAtual = 0; // 0 = jogador 1, 1 = jogador 2 (ou máquina)
    private String simboloJogador1;
    private String simboloJogador2;
    private JLabel historico_texto;

    public TelaDoJogo(String simbolo1, String simbolo2, boolean contraMaquina, int nivelMaquina) {
        this.simboloJogador1 = simbolo1;
        this.simboloJogador2 = simbolo2;
        this.contraMaquina = contraMaquina;

        if (contraMaquina) {
            jogo = new JogoDaVelha("Jogador", nivelMaquina);
        } else {
            jogo = new JogoDaVelha(simbolo1, simbolo2);
        }

        setLayout(null);
        inicializarComponentes();
    }

    public TelaDoJogo(String simbolo1, String simbolo2) {
        this(simbolo1, simbolo2, false, 0);
    }

    public TelaDoJogo() {
        this("X", "O", false, 0);
    }

    private void inicializarComponentes() {
        int x = 92, y = 16, w = 89, h = 65, dx = 89, dy = 65;

        for (int i = 0; i < 9; i++) {
            final int index = i;
            botoes[i] = new JButton("");
            botoes[i].setBounds(x + (i % 3) * dx, y + (i / 3) * dy, w, h);
            botoes[i].setFont(new Font("Arial", Font.BOLD, 28));
            add(botoes[i]);

            botoes[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (botoes[index].getText().isEmpty() && !jogo.terminou()) {
                        if (!contraMaquina) {
                            // Modo 2 jogadores
                            String simboloAtual = (jogadorAtual == 0) ? simboloJogador1 : simboloJogador2;
                            botoes[index].setText(simboloAtual);
                            jogo.jogaJogador(jogadorAtual, index);
                            if (jogo.terminou()) {
                                atualizarTabuleiro();
                                mostrarResultado();
                            } else {
                                jogadorAtual = 1 - jogadorAtual; // troca a vez
                                atualizarTabuleiro();
                            }
                        } else {
                            // Modo contra máquina
                            jogo.jogaJogador(0, index);
                            atualizarTabuleiro();

                            if (!jogo.terminou()) {
                                jogo.jogaMaquina();
                                atualizarTabuleiro();
                            }

                            if (jogo.terminou()) {
                                mostrarResultado();
                            }
                        }
                    }
                }
            });
        }

        botaoReiniciar = new JButton("Reiniciar");
        botaoReiniciar.setBounds(175, 247, 89, 23);
        botaoReiniciar.setEnabled(false);
        add(botaoReiniciar);

        botaoReiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame telaInicial = new TelaInicial();
                telaInicial.setLocationRelativeTo(null); // centraliza
                telaInicial.setVisible(true);

                SwingUtilities.getWindowAncestor(TelaDoJogo.this).dispose();
            }
        });

        labelResultado = new JLabel("");
        labelResultado.setHorizontalAlignment(SwingConstants.CENTER);
        labelResultado.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        labelResultado.setBounds(68, 212, 313, 33);
        add(labelResultado);
        
        historico_texto = new JLabel("Histórico: ");
        historico_texto.setHorizontalAlignment(SwingConstants.CENTER);
        historico_texto.setBounds(35, 281, 375, 14);
        add(historico_texto);
        
    }

    private void atualizarTabuleiro() {
        for (int i = 0; i < 9; i++) {
            botoes[i].setText(jogo.getHistorico().getOrDefault(i, ""));
        }
        historico_texto.setText(this.jogo.getHistorico().toString());
    }

    private void mostrarResultado() {
        int resultado = jogo.getResultado();
        String msg = switch (resultado) {
            case 1 -> "Jogador 1 venceu!";
            case 2 -> contraMaquina ? "Máquina venceu!" : "Jogador 2 venceu!";
            case 0 -> "Empate!";
            default -> "";
        };
        labelResultado.setText(msg);
        botaoReiniciar.setEnabled(true);
    }
}
