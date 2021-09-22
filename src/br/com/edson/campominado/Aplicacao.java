package br.com.edson.campominado;

import br.com.edson.campominado.modelo.Tabuleiro;
import br.com.edson.campominado.visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		
		new TabuleiroConsole(tabuleiro);
		
		
		System.out.println(tabuleiro);
		
		
		
	}
}
