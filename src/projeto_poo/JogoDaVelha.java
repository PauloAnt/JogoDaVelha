package projeto_poo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class JogoDaVelha {
	
	private String[] celulas = new String[9];
	private String[] simbolos = new String[2]; 
	private java.util.LinkedHashMap<Integer, String> historico = new java.util.LinkedHashMap<>();
	private int quantidadeJogadas;
	private int nivelEsperteza;
	
	
	
	
	public JogoDaVelha(String simbolo1, String simbolo2) {
		simbolos[0] = simbolo1;
		simbolos[1] = simbolo2;
		for(int i = 0; i < celulas.length; i++) {
			celulas[i] = " ";
		}
		
		historico.clear();
		
		setQuantidadeJogadas(0);
		
	} // construtor do jogo para 2 jogadores.
	
	public JogoDaVelha(String simboloJogador1, int nivel) {
		simbolos[0] = simboloJogador1;
	    simbolos[1] = simboloJogador1.equalsIgnoreCase("X") ? "O" : "X"; // usa o oposto, ou um padrão
		
		for(int i = 0; i < celulas.length; i++) {
			celulas[i] = " ";
		}
	
		historico.clear();
		
		setQuantidadeJogadas(0);
		
		nivelEsperteza = nivel;
		
		
	} // construtor do jogo para um jogador e a máquina, onde nível de esperteza da máquina é 1-baixo ou 2-alto)
	
	public void jogaJogador(int numeroJogador, int posicao) {
		if (posicao >=0 && posicao <= 8 && celulas[posicao].isBlank()) {
			celulas[posicao] = simbolos[numeroJogador-1];
			historico.put(posicao, simbolos[numeroJogador-1]);
			setQuantidadeJogadas(getQuantidadeJogadas() + 1);
		}
		
	} // valida a posição e efetiva a jogada para o jogador.
	
	public int jogaMaquina(){
		if(nivelEsperteza == 1){
			ArrayList<Integer> livres = getPosicoesDisponiveis();
			
			if(!livres.isEmpty()) {
				Random random = new Random();
				int sorteio = random.nextInt(livres.size());
				int posicao = livres.get(sorteio);
				
				celulas[posicao] = simbolos[1];
				historico.put(posicao, simbolos[1]);
				return posicao;
			}
		
		}
		else if(nivelEsperteza == 2) {
			  int[][] vitorias = {
			            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // linhas
			            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // colunas
			            {0, 4, 8}, {2, 4, 6}             // diagonais
			        };

			        // Tentar vencer
			        for (int[] linha : vitorias) {
			            int a = linha[0], b = linha[1], c = linha[2];
			            if (celulas[a].equals(simbolos[1]) && celulas[b].equals(simbolos[1]) && celulas[c].equals(" ")) {
			                celulas[c] = simbolos[1];
			                historico.put(c, simbolos[1]);
			                setQuantidadeJogadas(getQuantidadeJogadas() + 1);
			                return c;
			            }
			            if (celulas[a].equals(simbolos[1]) && celulas[c].equals(simbolos[1]) && celulas[b].equals(" ")) {
			                celulas[b] = simbolos[1];
			                historico.put(b, simbolos[1]);
			                setQuantidadeJogadas(getQuantidadeJogadas() + 1);
			                return b;
			            }
			            if (celulas[b].equals(simbolos[1]) && celulas[c].equals(simbolos[1]) && celulas[a].equals(" ")) {
			                celulas[a] = simbolos[1];
			                historico.put(a, simbolos[1]);
			                setQuantidadeJogadas(getQuantidadeJogadas() + 1);
			                return a;
			            }
			        }

			        // Tentar bloquear o jogador
			        for (int[] linha : vitorias) {
			            int a = linha[0], b = linha[1], c = linha[2];
			            if (celulas[a].equals(simbolos[0]) && celulas[b].equals(simbolos[0]) && celulas[c].equals(" ")) {
			                celulas[c] = simbolos[1];
			                historico.put(c, simbolos[1]);
			                setQuantidadeJogadas(getQuantidadeJogadas() + 1);
			                return c;
			            }
			            if (celulas[a].equals(simbolos[0]) && celulas[c].equals(simbolos[0]) && celulas[b].equals(" ")) {
			                celulas[b] = simbolos[1];
			                historico.put(b, simbolos[1]);
			                setQuantidadeJogadas(getQuantidadeJogadas() + 1);
			                return b;
			            }
			            if (celulas[b].equals(simbolos[0]) && celulas[c].equals(simbolos[0]) && celulas[a].equals(" ")) {
			                celulas[a] = simbolos[1];
			                historico.put(a, simbolos[1]);
			                setQuantidadeJogadas(getQuantidadeJogadas() + 1);
			                return a;
			            }
			        }

			        // Se não puder vencer ou bloquear, joga aleatório
			        ArrayList<Integer> livres = getPosicoesDisponiveis();
			        if (!livres.isEmpty()) {
			            int pos = livres.get((int)(Math.random() * livres.size()));
			            celulas[pos] = simbolos[1];
			            historico.put(pos, simbolos[1]);
			            setQuantidadeJogadas(getQuantidadeJogadas() + 1);
			            return pos;
			        }
			        
		}
		// Fallback se nenhuma jogada foi feita (ex: tabuleiro cheio)
        return -1;
		
	} // escolhe uma posição para a máquina.
	
	public boolean terminou() {
		return getResultado() != -1;

	} // retorna true quando um jogador ganha ou não há mais células livres, e retorna false caso contrário.
	
	public int getResultado() {
		  int[][] combinacoes = {
			        {0,1,2}, {3,4,5}, {6,7,8},
			        {0,3,6}, {1,4,7}, {2,5,8},
			        {0,4,8}, {2,4,6}
			    };

			    // Verifica se o jogador 1 ganhou
			    for (int[] c : combinacoes) {
			        String s1 = celulas[c[0]];
			        String s2 = celulas[c[1]];
			        String s3 = celulas[c[2]];

			        if (!s1.isBlank() && s1.equals(s2) && s2.equals(s3)) {
			            if (s1.equals(simbolos[0])) return 1; // Jogador 1 venceu
			            if (s1.equals(simbolos[1])) return 2; // Jogador 2 ou máquina venceu
			        }
			    }

			    // Verifica se ainda tem células vazias → jogo não terminou
			    for (String celula : celulas) {
			        if (celula.isBlank()) return -1;
			    }

			    // Não tem mais espaço e ninguém ganhou → empate
			    return 0;
		
	} // retorna -1(inexistente), 0(empate), 1(vitória do jogador1), 2(vitória do jogador2/máquina)
	
	public String getSimbolo(int numeroJogador) {
		return simbolos[numeroJogador-1];
		
	} // retorna o símbolo do jogador
	
	public String getFoto() {
		 StringBuilder sb = new StringBuilder();

		    for (int i = 0; i < celulas.length; i++) {
		        sb.append("[").append(celulas[i]).append("]");

		        // Quebra a linha a cada 3 posições
		        if ((i + 1) % 3 == 0) {
		            sb.append("\n");
		        }
		    }

		    return sb.toString();
	} // retorna um texto com as 9 posições (livres e ocupadas) do tabuleiro dispostas de forma bidimensional
	
	public ArrayList<Integer> getPosicoesDisponiveis(){
		ArrayList<Integer> disponiveis = new ArrayList<>();
		
		for(int i = 0; i < celulas.length; i++) {
			if(celulas[i].isBlank()) {
				disponiveis.add(i);
			}
		}
		return disponiveis;
	} // retorna uma lista com as posições ainda não utilizadas pelo jogo
	
	public LinkedHashMap<Integer, String> getHistorico(){
		return historico;
	} // retorna pares <posição, símbolo> jogados durante o jogo

	public int getQuantidadeJogadas() {
		return quantidadeJogadas;
	}

	public void setQuantidadeJogadas(int quantidadeJogadas) {
		this.quantidadeJogadas = quantidadeJogadas;
	}
	
	public int getTotalJogadas() {
		return quantidadeJogadas;
	}
}
