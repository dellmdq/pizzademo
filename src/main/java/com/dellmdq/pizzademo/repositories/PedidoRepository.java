package com.dellmdq.pizzademo.repositories;

import com.dellmdq.pizzademo.entities.PedidoCabecera;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PedidoRepository extends CrudRepository<PedidoCabecera, UUID> {
}
