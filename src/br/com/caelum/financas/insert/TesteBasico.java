package br.com.caelum.financas.insert;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBasico {

	public static void main(String[] args) {
		
		Conta c1 = new Conta();
		
		c1.setTitular("Luiz Henrique");
		c1.setBanco("Santander");
		c1.setAgencia("9876");
		c1.setNumero("10756");
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		//abrindo transação
		entityManager.getTransaction().begin();
		entityManager.persist(c1);
		
		c1.setTitular("Luiz Henrique");
		
		entityManager.getTransaction().commit();
		
		System.out.println(c1.getTitular());
		System.out.println(c1.getBanco());
		entityManager.close();
		
	}

}
