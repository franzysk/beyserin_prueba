package com.beyserin.prueba.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonIgnore
    private char tipoDocumento;

    @JsonIgnore
    private String numeroDocumento;

    private String primerNombre;

    private String segundoNombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String telefono;

    private String direccion;

    private String ciudadResidencia;
}
