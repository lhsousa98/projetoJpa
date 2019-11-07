package br.com.caelum.financas.teste.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJpaJpql {

	public static void main(String[] args) {
		Categoria categoria = new Categoria();

		categoria.setId(5);
		categoria.setNome("Luizão");

		EntityManager em1 = new JPAUtil().getEntityManager();

		em1.getTransaction().begin();

		String jpql = "select c from categoria where nome = 'Luizão'";
		
		//Para aparecer e criar a minha query em JPQL tenho de colocar um Query
		Query sql = em1.createQuery(jpql);
		
		//Na JPQL diferentemente do modo criteria não precisa da instância anterior
		List<Categoria> consulta = sql.getResultList();
	
		em1.getTransaction().commit();

		em1.close();
	}

}
