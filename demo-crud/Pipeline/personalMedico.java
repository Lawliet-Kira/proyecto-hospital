package com.example.democrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class personalMedico{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonalMed;

    @Column
    private String cargo;
    
    @Column
    private String permisos;

    @Column
    private String tipoPersonal;

    @Column
    private Boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id")
    private Persona Persona;

    public Long getidGestor() {
        return idPersonalMed;
    }

    public void setidGestor(Long id) {
        this.idPersonalMed = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public String getTipoPersonal() {
        return tipoPersonal;
    }

    public void setTipoPersonal(String tipoPersonal) {
        this.tipoPersonal = tipoPersonal;
    }



    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}