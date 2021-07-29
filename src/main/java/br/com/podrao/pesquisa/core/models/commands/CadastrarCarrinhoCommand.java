package br.com.podrao.pesquisa.core.models.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CadastrarCarrinhoCommand {

	private Long id;
	private String nome;
	private Double latitude;
	private Double longitude;
}