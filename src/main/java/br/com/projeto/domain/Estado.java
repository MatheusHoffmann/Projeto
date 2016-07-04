package br.com.projeto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Estado extends GenericDomain {
	@Column(length = 2, nullable = false)// define o tamanho e nao permite que seja vazio
	private String sigla;
	@Column(length = 50, nullable = false)
	private String nome;
	
	
	public String getNome() {
		return nome;
	}
	public String getSigla() {
		return sigla;
	}
    public void setNome(String nome) {
		this.nome = nome;
	}
    public void setSigla(String sigla) {
		this.sigla = sigla;
	}
    
}
