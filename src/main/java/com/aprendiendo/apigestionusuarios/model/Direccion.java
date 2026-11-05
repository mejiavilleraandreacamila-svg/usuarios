package com.aprendiendo.apigestionusuarios.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Direccion {
    private String ciudad;
    private String pais;
}
