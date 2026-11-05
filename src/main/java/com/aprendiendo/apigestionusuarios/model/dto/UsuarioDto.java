package com.aprendiendo.apigestionusuarios.model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "usuarios")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long nroDocumento;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String ciudad;
    private String pais;
    private String username;
    private String password;
    private String edad;
    private String estado;
    private String cliente;
    private String canal;

}


