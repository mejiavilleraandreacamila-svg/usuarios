package com.aprendiendo.apigestionusuarios.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Contacto {
    private String email;
    private String telefono;
}
