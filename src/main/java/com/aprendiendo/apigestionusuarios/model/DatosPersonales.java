package com.aprendiendo.apigestionusuarios.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class DatosPersonales {

    private String nombre;
    private String apellido;
    private Long nroDocumento;
}
