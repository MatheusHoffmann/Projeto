package br.com.projeto.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.projeto.domain.Cidade;
import br.com.projeto.domain.Estado;

public class CidadeDAOTest {
	@Test
	@Ignore
	public void salvar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado =  estadoDAO.buscar(1L);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Maringa");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}
	@Test
	@Ignore
	public void listar(){
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();
		
		for(Cidade cidade : resultado){
			System.out.println("Codigo"+ cidade.getCodigo());
			System.out.println("Nome da cidade"+ cidade.getNome());
			System.out.println("codigo do estado"+ cidade.getEstado().getNome());
		}
	}
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		System.out.println("Codigo "+ cidade.getCodigo());
		System.out.println("Nome da cidade "+ cidade.getNome());
		System.out.println("codigo do estado "+ cidade.getEstado().getNome());
		
	}
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 1L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		cidadeDAO.excluir(cidade);
		System.out.println("cidade excluida");
		System.out.println("Codigo "+ cidade.getCodigo());
		System.out.println("Nome da cidade "+ cidade.getNome());
		System.out.println("codigo do estado "+ cidade.getEstado().getNome());
	}
	@Test
	public void editar(){
		Long codigoCidade = 2L;
		Long codigoEstado = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);
	
	
		System.out.println("Codigo "+ estado.getCodigo());
		System.out.println("Nome da cidade "+ estado.getNome());
		System.out.println("codigo do estado "+ estado.getNome());
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		System.out.println("cidade a ser editada");
		System.out.println("Codigo "+ cidade.getCodigo());
		System.out.println("Nome da cidade "+ cidade.getNome());
		System.out.println("codigo do estado "+ cidade.getEstado().getNome());
		
		cidade.setNome("Rolandia");
		estado.setNome("Parana");
		
		cidadeDAO.editar(cidade);
		
		System.out.println("cidade  editada");
		System.out.println("Codigo "+ cidade.getCodigo());
		System.out.println("Nome da cidade "+ cidade.getNome());
		System.out.println("codigo do estado "+ cidade.getEstado().getNome());
	}

}
