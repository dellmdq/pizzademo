package com.dellmdq.pizzademo.entities;

import com.dellmdq.pizzademo.enums.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Table(name = "pedidos_cabecera")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidoCabecera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @NotEmpty
    @Size(min = 1, message = "La dirección debe tener más de un caracter")
    @Column(nullable = false)
    private String direccion;

    @NotNull
    @NotEmpty
    @Size(min = 1, message = "El email debe tener más de un caracter")
    @Column(nullable = false)
    private String email;

    @Temporal(value = TemporalType.TIME)
    @CreationTimestamp
    private String horario;

    @Temporal(value = TemporalType.TIMESTAMP)
    @CreationTimestamp
    private String fechaAlta;

    @NotNull
    @Column(nullable = false)
    private Double montoTotal;

    private Boolean aplicoDescuento;

    @Column(nullable = false, columnDefinition = "TEXT")
    private Enum<Estado> estado;

}
