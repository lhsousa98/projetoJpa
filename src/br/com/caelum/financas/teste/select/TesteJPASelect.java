package br.com.caelum.financas.teste.select;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPASelect {
	public static void main(String[] args) {

		Conta conta = new Conta();

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		CriteriaBuilder builder = em.getCriteriaBuilder();

		// criando select
		CriteriaQuery<Conta> criteria = builder.createQuery(Conta.class);

		// Root é o from
		Root<Conta> root = criteria.from(Conta.class);

		// criteria select
		criteria.select(root);

		// criteria where equal criar o root get
		criteria.where(builder.equal(root.get(conta.getTitular()), "Luiz Henrique"));
		// criar um list com a createquery e o resultado da lista

		List<Conta> selecionarNome = em.createQuery(criteria).getResultList();

		em.persist(conta);
		em.getTransaction().commit();
		em.close();

	}
}
