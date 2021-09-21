package br.com.edson.campominado;

import br.com.edson.campominado.modelo.Tabuleiro;

public class Aplicacao {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 2);
		
		tabuleiro.abrir(2, 3);
		tabuleiro.abrir(3, 3);
		
		
		System.out.println(tabuleiro);
		
		
		
	}
}
