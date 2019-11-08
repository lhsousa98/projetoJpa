package br.com.caelum.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by leonardocordeiro on 19/12/16.
 */
@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;

	// quando declaro como deprecated ela esse meu contrutor vazio e para o
	// hibernate
	@Deprecated
	public Categoria() {
	}

	public Categoria(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
