package br.com.podrao.pesquisa.util;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LancheDtoStub {

	private Long id = 1L;
	private String nome = "Enourmous Mac";
	private BigDecimal valor = BigDecimal.valueOf(23L);
	private Long carrinhoId = 1L;
}
