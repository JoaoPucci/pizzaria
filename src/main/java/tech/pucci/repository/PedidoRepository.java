package tech.pucci.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.pucci.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
