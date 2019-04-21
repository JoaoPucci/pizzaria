package tech.pucci.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.pucci.model.Tamanho;

public interface TamanhoRepository extends JpaRepository<Tamanho, Long> {
	
}
