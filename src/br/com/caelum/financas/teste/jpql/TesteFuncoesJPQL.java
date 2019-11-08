package br.com.caelum.financas.teste.jpql;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();

		String jpql2 = "select m from Movimentacao m";

		Query query2 = manager.createQuery(jpql2);

		List<Movimentacao> movimentacaos2 = query2.getResultList();

		for (Movimentacao movimentacao : movimentacaos2) {
	//J		System.out.println("Descricao: " + Optional.ofNullable(movimentacao.getConta().getCliente().getNome()).orElse("N/D"));
			System.out.println("Descricao: " + Optional.ofNullable(movimentacao.getDescricao()).orElse("N/D"));
			System.out.println("Conta.id " + Optional.ofNullable(movimentacao.getValor()).orElse(new BigDecimal(0)));
		}

	}

}
