package br.com.podrao.pesquisa.util;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LancheDtoSerializable implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private BigDecimal valor;
	private Long carrinhoId;
}
