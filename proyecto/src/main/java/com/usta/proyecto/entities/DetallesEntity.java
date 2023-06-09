package com.usta.proyecto.entities;

import jakarta.persistence.*;
import org.springframework.data.repository.NoRepositoryBean;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "Detalles")

public class DetallesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalles")
    private Long id_detalles;

    @JoinColumn(name = "id_Pago", referencedColumnName = "id_Pago")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, optional = true)
    private PagosEntity id_Pago;


    @NotNull
    @Column(name = "MedicionActual")
    private Integer MedicionActual;

    @NotNull
    @Column(name = "CostoAPagar")
    //que contabilice la medicion y genere un costo a pagar ej:20000 por una medicion de 1000 mts^3//
    private Integer CostoAPagar;

    @NotNull
    @Column(name="MedicionPasada")
    private Integer MedicionPasada;


    @NotNull
    @Column(name = "costo pasado")
    private Integer CostoPasado;


    @Column(name = "DeudaTotal")
    private Integer DeudaTotal;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;


    public Long getIdDetalles() {
        return id_detalles;
    }

    public void setIdDetalles(Long idDetalles) {
        this.id_detalles = idDetalles;
    }

    public Integer getMedicionPasada() {
        return MedicionPasada;
    }

    public void setMedicionPasada(Integer medicionPasada) {
        MedicionPasada = medicionPasada;
    }

    public Integer getCostoAPagar() {
        return CostoAPagar;
    }

    public void setCostoAPagar(Integer costoAPagar) {
        CostoAPagar = costoAPagar;
    }

    public Integer getCostoPasado() {
        return CostoPasado;
    }

    public void setCostoPasado(Integer costoPasado) {
        CostoPasado = costoPasado;
    }

    public Integer getDeudaTotal() {
        return DeudaTotal;
    }

    public void setDeudaTotal(Integer deudaTotal) {
        DeudaTotal = deudaTotal;
    }

    public Integer getMedicionActual() {
        return MedicionActual;
    }

    public void setMedicionActual(Integer medicionActual) {
        MedicionActual = medicionActual;
    }


    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public PagosEntity getIdpago() {
        return id_Pago;
    }

    public void setIdpago(PagosEntity idpago) {
        this.id_Pago = idpago;
    }
}
