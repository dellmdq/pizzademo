package com.dellmdq.pizzademo.entities;

import com.dellmdq.pizzademo.enums.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Table(name = "pedidos_cabecera")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidoCabecera {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
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

    @CreationTimestamp
    private LocalTime horario;

    @CreationTimestamp
    private LocalDate fechaAlta;

    @NotNull
    @Column(nullable = false)
    private Double montoTotal;

    private Boolean aplicoDescuento;

    @Column(name = "estado", nullable = false, columnDefinition = "TEXT")
    private Enum<Estado> estado;

}
