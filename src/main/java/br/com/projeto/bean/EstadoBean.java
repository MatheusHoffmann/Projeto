package br.com.projeto.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.projeto.dao.EstadoDAO;
import br.com.projeto.domain.Estado;

@ManagedBean
@ViewScoped
@SuppressWarnings("serial")
public class EstadoBean implements Serializable{
	
	    private Estado estado;
	    private List<Estado> estados;
	    
	    
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
	    @PostConstruct // ele constroi 
	    public void litar(){
	    	try{
	    		
	    		EstadoDAO estadoDAO = new EstadoDAO();
	    		estados = estadoDAO.listar();
	    		
	    	}catch (RuntimeException erro){
	    		String  texto = " Ocorreu um erro ao tentar salvar o estado";
	    	    FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, texto); 
	    	    FacesContext contexto= FacesContext.getCurrentInstance();
	    	    contexto.addMessage(null, mensagem); 	
	    	    erro.printStackTrace();
	    	}
	    }
	    public void novo(){
	    	estado = new Estado();
	    }
	    
	    
	public void salvar(){
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	    
        novo();
		String  texto = " Estado Salvo com sucesso!!!";
	    FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, texto); 
	    FacesContext contexto= FacesContext.getCurrentInstance();
	    contexto.addMessage(null, mensagem);   
	    
	  
	}
	public void excluir(ActionEvent evento){
		
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.excluir(estado);
		
		String  texto = " Estado excluido com sucesso!!!";
	    FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, texto); 
	    FacesContext contexto= FacesContext.getCurrentInstance();
	    contexto.addMessage(null, mensagem); 
		
	}

}
