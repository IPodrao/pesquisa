package br.com.podrao.pesquisa.infra.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "carrinho")
@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class CarrinhoEntity {

    @Id
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

	public CarrinhoEntity(Long id, String nome, Double latitude, Double longitude) {
		this.id = id;
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
	}
}