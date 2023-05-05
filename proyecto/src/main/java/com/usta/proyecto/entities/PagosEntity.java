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
@JoinColumn(name = "idRegistro",referencedColumnName = "idRegistro")
@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,optional = true)
private RegistrosEntity idRegistro;

@NotNull
@Column(name = "PagoAlDia")   //si es false que lo mande a la tabla de deudores//
private Boolean PagoAlDia;

@JoinColumn(name = "idDetalles",referencedColumnName = "idDetalles")
@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,optional = true)
    private DetallesEntity idDetalles;

@NotNull
@Column(name = "estado")
private Boolean estado;


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

    public RegistrosEntity getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(RegistrosEntity idRegistro) {
        this.idRegistro = idRegistro;
    }

    public DetallesEntity getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(DetallesEntity idDetalles) {
        this.idDetalles = idDetalles;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
