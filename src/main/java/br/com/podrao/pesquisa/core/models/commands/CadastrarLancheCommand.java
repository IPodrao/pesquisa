package br.com.podrao.pesquisa.core.models.commands;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CadastrarLancheCommand {

	private Long id;
	private String nome;
	private BigDecimal valor;
	private Long carrinhoId;
}
