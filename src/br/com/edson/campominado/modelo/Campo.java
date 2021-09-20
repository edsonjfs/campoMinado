package br.com.edson.campominado.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	
	private final int linha;
	private final int coluna;
	
	private boolean aberto;
	private boolean minado;
	private boolean marcado;
	
	private List<Campo> vizinhos = new ArrayList<>();
	
	Campo(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
	}
	
	boolean adicionarVizinho(Campo isVizinho) {
		int diferencaLinha = Math.abs(linha - isVizinho.linha);
		int diferencaColuna = Math.abs(coluna - isVizinho.coluna);	
		int somaDasDiferencas = diferencaColuna + diferencaLinha;
		
		if (somaDasDiferencas == 1) {
			vizinhos.add(isVizinho);
			return true;
		} else if (somaDasDiferencas == 2) {
			vizinhos.add(isVizinho);
			return true;
		}
		
		return false;	
	}
}

	
	
