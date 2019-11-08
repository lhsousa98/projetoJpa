package br.com.caelum.financas.teste.select;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		// Realiza igual inner join me mostra todas as movimentações
		String jpql = "Select Distinct c from Conta c left join fetch c.movimentacoes";

		Query query = em.createQuery(jpql);

		List<Conta> listarContas = query.getResultList();

		for (Conta conta : listarContas) {

			System.out.println("Titular" + conta.getTitular());
			System.out.println("Movimentação: ");
			System.out.println(conta.getMovimentacoes());
		}

	}

}
