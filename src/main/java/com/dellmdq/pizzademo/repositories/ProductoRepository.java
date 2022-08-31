package com.dellmdq.pizzademo.repositories;

import com.dellmdq.pizzademo.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductoRepository extends JpaRepository<Producto, UUID> {
}
