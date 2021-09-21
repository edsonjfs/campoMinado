package br.com.edson.campominado.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.descriptor.CompositeTestSource;

import br.com.edson.campominado.excecao.ExplosaoException;

public class CampoTeste {
	
	private Campo campo22 = new Campo(2,2);
	
	@Test
	void testeVizinhoNorte() {
		Campo vizinho = new Campo (1,2);
		boolean resultado = campo22.adicionarVizinho(vizinho);
		assertTrue(resultado);	
	}
	
	@Test
	void testeVizinhoSul() {
		Campo vizinho = new Campo (3,2);
		boolean resultado = campo22.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoLeste() {
		Campo vizinho = new Campo (2,3);
		boolean resultado = campo22.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoOeste() {
		Campo vizinho = new Campo (2,1);
		boolean resultado = campo22.adicionarVizinho(vizinho);
		assertTrue(resultado);
		
	}
	
	
	@Test
	void testeVizinhoNorteLeste() {
		Campo vizinho = new Campo (1,1);
		boolean resultado = campo22.adicionarVizinho(vizinho);
		assertTrue(resultado);
		
	}
	
	@Test
	void testeVizinhoNorteOeste() {
		Campo vizinho = new Campo (1,3);
		boolean resultado = campo22.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoSulOeste() {
		Campo vizinho = new Campo (3,3);
		boolean resultado = campo22.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoSulLeste() {
		Campo vizinho = new Campo (3,1);
		boolean resultado = campo22.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoFalsoColuna() {
		Campo vizinho = new Campo (3,4);
		boolean resultado = campo22.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testeVizinhoFalsoLinha() {
		Campo vizinho = new Campo (4,3);
		boolean resultado = campo22.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testeVizinhoFalsoLonge() {
		Campo vizinho = new Campo (10,7);
		boolean resultado = campo22.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testeValorPadraoAtributoMarcacao() {
		assertFalse(campo22.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo22.alternarMarcacaoDoCampo();
		assertTrue(campo22.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo22.alternarMarcacaoDoCampo();
		assertTrue(campo22.isMarcado());
		campo22.alternarMarcacaoDoCampo();
		assertFalse(campo22.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo22.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo22.alternarMarcacaoDoCampo();
		assertFalse(campo22.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo22.alternarMarcacaoDoCampo();
		campo22.colocarMinasNoCampo();
		assertFalse(campo22.abrir());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo22.colocarMinasNoCampo();
		
		assertThrows(ExplosaoException.class, () -> {
			campo22.abrir();
		});
	}
	
	@Test
	void testeAbrirComVizinhos() {
		Campo campo13 = new Campo(1,3);
		Campo campo14 = new Campo(1,4);
		Campo campo12 = new Campo(1,2);
		
		campo12.colocarMinasNoCampo();
		
		campo22.adicionarVizinho(campo12);
		campo22.adicionarVizinho(campo13);
		campo13.adicionarVizinho(campo14);
		
		campo22.abrir();
		
		assertTrue(!campo13.isAberto() && !campo14.isAberto());
		
	}
	

}
