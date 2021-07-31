package br.com.podrao.pesquisa.app.models;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LancheDto {

	private Long id;
	private String nome;
	private BigDecimal valor;
	private Long carrinhoId;
}
