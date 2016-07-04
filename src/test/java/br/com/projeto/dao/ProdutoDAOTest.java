package br.com.projeto.dao;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.projeto.domain.Fabricante;
import br.com.projeto.domain.Produto;

public class ProdutoDAOTest {
	
	@Test
	public void salvar(){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(new Long("1"));
		
		Produto produto = new Produto();
		produto.setDescricao("Memoria 4GB ddr3");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("199.90"));
		produto.setQuantidade(new Short("3"));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
		System.out.println("Produto salvo com sucesso");
	}

}
