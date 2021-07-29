package br.com.podrao.pesquisa.util;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CarrinhoDtoStub {

    private Long id = 1L;
    private String nome = "Carrinho do Zé";
    private Double latitude = 12356D;
    private Double longitude = 805645D;
}