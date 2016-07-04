package br.com.projeto.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.projeto.domain.Estado;

public class EstadoDaoTest {
	@Test
	//@Ignore
	public void salvar(){
	  Estado estado = new Estado ();
	  estado.setNome("Bahia");
	  estado.setSigla("BH");
	  
	  EstadoDAO estadoDAO = new EstadoDAO();
	  estadoDAO.salvar(estado);
	  
	  
	}
	@Test
	@Ignore
   public void listar(){
	   EstadoDAO estadoDAO = new EstadoDAO();
	   List<Estado> resultado = estadoDAO.listar();
	   
	   for (Estado estado : resultado){
		   System.out.println(estado.getSigla() + " - " + estado.getNome());
	   }
   }
	@Test
	@Ignore
	public void buscar(){
		
		Long codigo = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum Registro Encontrado");
		} else{
			System.out.println("Registro encontrado");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		
		}
		
		
	}
	@Test
	@Ignore
	public void excluir(){
    Long codigo =1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		
		if(estado == null){
			System.out.println("Nenhum Registro Encontrado");
		} else{
			estadoDAO.excluir(estado);
			System.out.println("Registro removido");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		
		}
		
	}
	@Test
	@Ignore
	public void editar(){
		Long codigo = 1L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		estado.setSigla("SC");
		estado.setNome("Santa Catarina");
		estadoDAO.editar(estado);
	}
}
