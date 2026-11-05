package com.aprendiendo.apigestionusuarios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InformacionAdicional {

    private String edad;
    private String estado;
    private String cliente;
    private String canal;
}
