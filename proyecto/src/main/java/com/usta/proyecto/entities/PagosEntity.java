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
@Column(name = "id_pago")
private Long id_pago;
@JoinColumn(name = "id_Registro",referencedColumnName = "id_Registro")
@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,optional = true)
private RegistrosEntity id_Registro;

@NotNull
@Column(name = "PagoAlDia")
private Boolean PagoAlDia;



@NotNull
@Column(name = "estado")
private Boolean estado;


    public Long getIdPago() {
        return id_pago;
    }

    public void setIdPago(Long idPago) {
        this.id_pago = idPago;
    }

    public Boolean getPagoAlDia() {
        return PagoAlDia;
    }

    public void setPagoAlDia(Boolean pagoAlDia) {
        PagoAlDia = pagoAlDia;
    }

    public RegistrosEntity getIdRegistro() {
        return id_Registro;
    }

    public void setIdRegistro(RegistrosEntity idRegistro) {
        this.id_Registro = idRegistro;
    }


    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
