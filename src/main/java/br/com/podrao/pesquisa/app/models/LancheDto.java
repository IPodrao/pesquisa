package br.com.podrao.pesquisa.app.models;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LancheDto {

	private Long id;
	private String nome;
	private BigDecimal valor;
	private Long carrinhoId;
}
