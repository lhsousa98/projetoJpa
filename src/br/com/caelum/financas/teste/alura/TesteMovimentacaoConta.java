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
		// integrando com a conex�o
		EntityManager em = new JPAUtil().getEntityManager();

		// iniciando transa��o com o banco
		em.getTransaction().begin();
		
		//realizar� um select from
		Movimentacao movimentacao = em.find(Movimentacao.class, 3);

		// Possuem relacionamento entre movimenta��o e conta
		Conta conta = movimentacao.getConta();

		System.out.println(conta.getTitular());
		System.out.println(conta.getMovimentacoes().size());
	}
}
