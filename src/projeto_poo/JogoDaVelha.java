package projeto_poo;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class JogoDaVelha {
	public JogoDaVelha(String simbolo1, String simbolo2) {
		
	} // construtor do jogo para 2 jogadores.
	
	public JogoDaVelha(String nomeJogador1, int nivel) {
		
	} // construtor do jogo para um jogador e a máquina, onde nível de esperteza da máquina é 1-baixo ou 2-alto)
	
	public void jogaJogador(numeroJogador, posicao) {
		
	} // valida a posição e efetiva a jogada para o jogador.
	
	public void jogaMaquina(){
		
	} // escolhe uma posição para a máquina.
	
	public boolean terminou() {
		
	} // retorna true quando um jogador ganha ou não há mais células livres, e retorna false caso contrário.
	
	public int getResultado() {
		
	} // retorna -1(inexistente), 0(empate), 1(vitória do jogador1), 2(vitória do jogador2/máquina)
	
	public String getSimbolo(int numeroJogador) {
		
	} // retorna o símbolo do jogador
	
	public String getFoto() {
		
	} // retorna um texto com as 9 posições (livres e ocupadas) do tabuleiro dispostas de forma bidimensional
	
	public ArrayList<Integer> getPosicoesDisponiveis(){
		
	} // retorna uma lista com as posições ainda não utilizadas pelo jogo
	
	public LinkedHashMap<Integer, String> getHistorico(){
		
	} // retorna pares <posição, símbolo> jogados durante o jogo
}
