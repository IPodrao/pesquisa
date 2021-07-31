package br.com.podrao.pesquisa.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarrinhoDto {

    private Long id;
    private String nome;
    private Double latitude;
    private Double longitude;
}
