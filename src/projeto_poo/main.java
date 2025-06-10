package projeto_poo;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        System.out.println("==== JOGO DA VELHA ====");
	        System.out.println("1 - Jogador vs Jogador");
	        System.out.println("2 - Jogador vs Máquina");
	        System.out.print("Escolha o modo de jogo: ");
	        int modo = sc.nextInt();
	        sc.nextLine(); // Limpa quebra de linha

	        JogoDaVelha jogo;

	        if (modo == 1) {
	            System.out.print("Digite símbolo do Jogador 1 (ex: X): ");
	            String s1 = sc.nextLine();
	            System.out.print("Digite símbolo do Jogador 2 (ex: O): ");
	            String s2 = sc.nextLine();
	            jogo = new JogoDaVelha(s1, s2);

	        } else {
	            System.out.print("Digite seu nome: ");
	            String nome = sc.nextLine();
	            System.out.print("Escolha nível da máquina (1 = burra, 2 = esperta): ");
	            int nivel = sc.nextInt();
	            jogo = new JogoDaVelha(nome, nivel);
	        }

	        int jogadorAtual = 0;

	        while (!jogo.terminou()) {
	            System.out.println("\nTabuleiro atual:");
	            System.out.println(jogo.getFoto());

	            if (modo == 2 && jogadorAtual == 1) {
	                System.out.println("Máquina está jogando...");
	                jogo.jogaMaquina();
	            } else {
	                System.out.print("Jogador " + (jogadorAtual + 1) + " (" + jogo.getSimbolo(jogadorAtual) + ") - escolha posição (0 a 8): ");
	                int pos = sc.nextInt();
	                jogo.jogaJogador(jogadorAtual, pos);
	            }

	            jogadorAtual = 1 - jogadorAtual; // alterna jogador
	        }

	        System.out.println("\n=== FIM DE JOGO ===");
	        System.out.println(jogo.getFoto());

	        int resultado = jogo.getResultado();
	        if (resultado == 0) {
	            System.out.println("Empate!");
	        } else if (resultado == 1) {
	            System.out.println("Jogador 1 venceu!");
	        } else if (resultado == 2) {
	            if (modo == 2) {
	                System.out.println("Máquina venceu!");
	            } else {
	                System.out.println("Jogador 2 venceu!");
	            }
	        }

	        System.out.println("\nHistórico de jogadas:");
	        for (var entrada : jogo.getHistorico().entrySet()) {
	            System.out.println("Posição " + entrada.getKey() + " → " + entrada.getValue());
	        }

	        sc.close();
	    }

	}


