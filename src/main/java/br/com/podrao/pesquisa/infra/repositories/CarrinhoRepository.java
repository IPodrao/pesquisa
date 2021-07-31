package br.com.podrao.pesquisa.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.podrao.pesquisa.infra.entities.CarrinhoEntity;

public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long>{

}
