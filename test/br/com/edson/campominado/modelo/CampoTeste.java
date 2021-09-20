package br.com.edson.campominado.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CampoTeste {
	
	private Campo campoteste = new Campo(2,2);
	
	@Test
	void testeVizinhoNorte() {
		Campo vizinho = new Campo (1,2);
		boolean resultado = campoteste.adicionarVizinho(vizinho);
		assertTrue(resultado);	
	}
	
	@Test
	void testeVizinhoSul() {
		Campo vizinho = new Campo (3,2);
		boolean resultado = campoteste.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoLeste() {
		Campo vizinho = new Campo (2,3);
		boolean resultado = campoteste.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoOeste() {
		Campo vizinho = new Campo (2,1);
		boolean resultado = campoteste.adicionarVizinho(vizinho);
		assertTrue(resultado);
		
	}
	
	
	@Test
	void testeVizinhoNorteLeste() {
		Campo vizinho = new Campo (1,1);
		boolean resultado = campoteste.adicionarVizinho(vizinho);
		assertTrue(resultado);
		
	}
	
	@Test
	void testeVizinhoNorteOeste() {
		Campo vizinho = new Campo (1,3);
		boolean resultado = campoteste.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoSulOeste() {
		Campo vizinho = new Campo (3,3);
		boolean resultado = campoteste.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoSulLeste() {
		Campo vizinho = new Campo (3,1);
		boolean resultado = campoteste.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoFalsoColuna() {
		Campo vizinho = new Campo (3,4);
		boolean resultado = campoteste.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testeVizinhoFalsoLinha() {
		Campo vizinho = new Campo (4,3);
		boolean resultado = campoteste.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	void testeVizinhoFalsoLonge() {
		Campo vizinho = new Campo (10,7);
		boolean resultado = campoteste.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	
	

}
