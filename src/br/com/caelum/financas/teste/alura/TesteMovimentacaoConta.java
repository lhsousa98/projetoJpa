package br.com.caelum.financas.teste.alura;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

/**
 * 
 * @author lhsousa
 *
 */
public class TesteMovimentacaoConta {
	public static void main(String[] args) {
		// integrando com a conexão
		EntityManager em = new JPAUtil().getEntityManager();

		// iniciando transação com o banco
		em.getTransaction().begin();
		
		//realizará um select from
		Movimentacao movimentacao = em.find(Movimentacao.class, 2);

		// Possuem relacionamento entre movimentação e conta
		Conta conta = movimentacao.getConta();

		System.out.println(conta.getTitular());
		System.out.println(conta.getMovimentacoes().size());
	}
}
