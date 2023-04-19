package com.usta.proyecto.entities;

import jakarta.persistence.*;
import org.springframework.data.repository.NoRepositoryBean;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "Detalles")

public class DetallesEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalles")
    private Long idDetalles;


    @NotNull
    @Column(name = "CostoAPagar")    //que contabilice la medicion y genere un costo a pagar ej:20000 por una medicion de 1000 mts^3//
    private Integer  CostoAPagar;

    @JoinColumn(name = "medicion")
    @OneToOne(cascade = CascadeType.REMOVE, optional = true)   //aca se debe mostrar la medicion registrada en registros//
    private RegistrosEntity medicion;

    @JoinColumn(name = "medicionPasada")
    @OneToOne(cascade = CascadeType.REMOVE,optional = true)
    private RegistrosEntity medicionPasada;


    @NotNull
    @Column(name = "costo pasado")
    private Integer CostoPasado;


    @Column(name = "DeudaTotal")
    private Integer DeudaTotal;


    public Long getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(Long idDetalles) {
        this.idDetalles = idDetalles;
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
}
