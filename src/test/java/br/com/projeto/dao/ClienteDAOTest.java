package br.com.projeto.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import org.junit.Test;

import br.com.projeto.domain.Cliente;
import br.com.projeto.domain.Pessoa;

public class ClienteDAOTest {
	@Test
	public void salvar() throws ParseException{
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		Cliente cliente = new Cliente();
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2016"));
		cliente.setLiberado(false);
		cliente.setPessoa(pessoa);
		
		ClienteDAO clienteDAO = new ClienteDAO();
	    clienteDAO.salvar(cliente);
	    System.out.println("Cliente Salvo com sucesso");
	}
	
}
