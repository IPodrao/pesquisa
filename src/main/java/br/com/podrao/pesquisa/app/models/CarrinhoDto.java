package br.com.podrao.pesquisa.app.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CarrinhoDto {

    private Long id;
    private String nome;
    private Double latitude;
    private Double longitude;
}
