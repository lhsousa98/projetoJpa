package br.com.caelum.financas.modelo;

import java.util.List;

import javax.persistence.*;



@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String titular;
	@Column
	private String banco;
	@Column
	private String agencia;
	@Column
	private String numero;

	@OneToOne
	@JoinColumn(unique = true)
	private Cliente cliente;
	
	//Ele cria um espelho da minha conta, é a bidirecional que foi declarada em movimentacao é um espelhamento
	@OneToMany(mappedBy="conta")
	private List<Movimentacao> movimentacoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	
	
}
