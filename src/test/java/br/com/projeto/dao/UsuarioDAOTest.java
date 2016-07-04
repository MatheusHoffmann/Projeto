package br.com.projeto.dao;

import org.junit.Test;

import br.com.projeto.domain.Pessoa;
import br.com.projeto.domain.Usuario;

public class UsuarioDAOTest {
	@Test
	public void salvar(){
		
		PessoaDAO pessoaDAO = new PessoaDAO();		
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		System.out.println("Pessoa encontrada");
		System.out.println("Nome: "+pessoa.getNome());
		System.out.println("Nome: "+pessoa.getCpf());
		
		Usuario usuario = new Usuario();	
	    usuario.setAtivo(true);
	    usuario.setPessoa(pessoa);
	    usuario.setSenha("aus1057");
	    usuario.setTipo('A');// A = administrador
	    
	    UsuarioDAO usuarioDAO = new UsuarioDAO();
	    usuarioDAO.salvar(usuario);
	    
	    System.out.println("Usuario cadastrado com sucesso");
	   
	}

}
