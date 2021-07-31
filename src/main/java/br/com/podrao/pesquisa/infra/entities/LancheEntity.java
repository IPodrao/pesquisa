package br.com.podrao.pesquisa.infra.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "lanche")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LancheEntity {

	@Id
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@Column(nullable = false)
	private Long carrinhoId;

	public LancheEntity(Long id, String nome, BigDecimal valor, Long carrinhoId) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.carrinhoId = carrinhoId;
	}
}