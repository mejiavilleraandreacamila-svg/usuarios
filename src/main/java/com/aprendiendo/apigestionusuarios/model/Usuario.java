package com.aprendiendo.apigestionusuarios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {


    private DatosPersonales datosPersonales;

    private Contacto contacto;

    private Direccion direccion;

    private Cuenta cuenta;

    private InformacionAdicional informacionAdicional;

}

