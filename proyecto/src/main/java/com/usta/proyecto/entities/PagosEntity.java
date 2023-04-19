package com.usta.proyecto.entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "pagos")

public class PagosEntity implements Serializable {

         private static final long serialVersionUID=1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "idPago")
private Long idPago;
@JoinColumn(name = "idRegistro")
@OneToOne(cascade = CascadeType.REMOVE,optional = true)
private RegistrosEntity idRegistro;

@NotNull
@Column(name = "PagoAlDia")   //si es false que lo mande a la tabla de deudores//
private Boolean PagoAlDia;

@JoinColumn(name = "idDetalles")
@OneToOne(cascade = CascadeType.REMOVE,optional = true)
    private DetallesEntity idDetalles;


    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Boolean getPagoAlDia() {
        return PagoAlDia;
    }

    public void setPagoAlDia(Boolean pagoAlDia) {
        PagoAlDia = pagoAlDia;
    }
}
