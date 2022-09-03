package com.dellmdq.pizzademo.repositories;

import com.dellmdq.pizzademo.entities.PedidoCabecera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<PedidoCabecera, UUID> {

    List<PedidoCabecera> findByFechaAlta(LocalDate date);
}
