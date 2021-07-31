package br.com.podrao.pesquisa.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.podrao.pesquisa.infra.entities.LancheEntity;

public interface LancheRepository extends JpaRepository<LancheEntity, Long> {

}
