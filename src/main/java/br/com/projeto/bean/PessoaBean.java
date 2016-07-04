package br.com.projeto.bean;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.projeto.dao.EstadoDAO;
import br.com.projeto.dao.PessoaDAO;
import br.com.projeto.domain.Cidade;
import br.com.projeto.domain.Estado;
import br.com.projeto.domain.Pessoa;



@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {
	private Pessoa pessoa;
	private List<Pessoa> pessoas;

	private Estado estado;
	private List<Estado> estados;

	private List<Cidade> cidades;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@PostConstruct
	public void listar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();
		} catch (RuntimeException erro) {
			
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			pessoa = new Pessoa();
			
			estado = new Estado();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
			cidades = new ArrayList<>();
		} catch (RuntimeException erro) {
			
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {

	}

	public void salvar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.merge(pessoa);
			
			pessoas = pessoaDAO.listar();
			
			pessoa = new Pessoa();
			
			estado = new Estado();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

			cidades = new ArrayList<>();
		} catch (RuntimeException erro) {
	
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {

	}


}

