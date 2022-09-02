package com.dellmdq.pizzademo.entities;

import com.dellmdq.pizzademo.enums.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
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

    @NotBlank
    @Size(min = 1, message = "La dirección debe tener más de un caracter")
    @Column(nullable = false)
    private String direccion;

    //todo regex mail validacion
    @NotBlank
    @Size(min = 1, message = "El email debe tener más de un caracter")
    @Column(nullable = false)
    private String email;

    private String telefono;

    private LocalTime horario;//viene por request

    @CreationTimestamp
    private LocalDate fechaAlta;

    @NotNull
    @Column(nullable = false)
    private Double montoTotal;

    private Boolean aplicoDescuento;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_cabecera_id")
    private List<PedidoDetalle> detalles;

    public PedidoCabecera(String direccion, String email, String telefono, LocalTime horario) {
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.horario = horario;
    }
}
