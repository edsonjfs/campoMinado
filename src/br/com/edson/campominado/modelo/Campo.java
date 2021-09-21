package br.com.edson.campominado.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.edson.campominado.excecao.ExplosaoException;

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
	
	void alternarMarcacaoDoCampo(){
		if (!aberto) {
			marcado = !marcado;
		}
	}
	
	boolean abrir() {
		if (!aberto && !marcado) {
			aberto = true;
			
			if (minado) {
				throw new ExplosaoException();
			}
			
			if (vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}
			return true;
		}else {
			return false;
		}
	}
	
	boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
		}
	
	void colocarMinasNoCampo() {
		if(!minado) {
			minado = true;
		}
	}
	
	public boolean isMarcado() {
		return marcado;
	}
	
	public boolean isMinado() {
		return minado;
	}
	
	public boolean isAberto() {
		return aberto;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
	
	boolean objetivoAlcancado() {
		boolean desvendado = !minado && aberto;
		boolean bombaMarcada = minado && marcado;
		return desvendado || bombaMarcada;
	}
	
	long minasNaVizinhanca() {
		return vizinhos.stream().filter(v -> v.minado).count();
	}
	
	void reiniciar() {
		aberto = false;
		marcado = false;
		minado = false;
	}
	
	public String toString() {
		if(marcado) {
			return "x";
		}else if(aberto && minado){
			return "*";
		}else if(aberto && minasNaVizinhanca() > 0) {
			return Long.toString(minasNaVizinhanca());
		}else if(aberto) {
			return ".";
		}else {
			return "?";
		}
	}
	
}

	
	
