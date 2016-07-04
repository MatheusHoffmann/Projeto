package br.com.main;

import org.hibernate.Session;

import br.com.projeto.util.HibernateUtil;

public class hibernateutiltest {
	public static void main(String[]args){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}

}
