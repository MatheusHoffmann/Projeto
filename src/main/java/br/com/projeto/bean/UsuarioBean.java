package br.com.projeto.bean;



import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.projeto.dao.PessoaDAO;
import br.com.projeto.dao.UsuarioDAO;
import br.com.projeto.domain.Pessoa;
import br.com.projeto.domain.Usuario;



@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {
	private Usuario usuario;
	
	private List<Pessoa> pessoas;
	private List<Usuario> usuarios;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@PostConstruct
	public void listar(){
		try{
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar();
		}catch(RuntimeException erro){
			
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		try {
			usuario = new Usuario();

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();
		} catch (RuntimeException erro) {
			
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.merge(usuario);
			
			usuario = new Usuario();
			usuarios = usuarioDAO.listar();
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();
			
		
		} catch (RuntimeException erro) {
		
			erro.printStackTrace();
		}
	}
}
