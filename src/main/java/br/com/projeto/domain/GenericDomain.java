package br.com.projeto.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@SuppressWarnings("serial")// vai ignorar erros amarelos de serial
@MappedSuperclass
public class GenericDomain implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // o banco vai gerenciar
	private long codigo;
    
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	public void setCodigo(Long codigo){
		
		this.codigo =codigo;
	}
}
