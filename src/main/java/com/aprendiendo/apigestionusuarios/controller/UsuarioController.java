package com.aprendiendo.apigestionusuarios.controller;

import com.aprendiendo.apigestionusuarios.model.Usuario;
import com.aprendiendo.apigestionusuarios.model.dto.UsuarioDto;
import com.aprendiendo.apigestionusuarios.model.response.UsuarioResponse;
import com.aprendiendo.apigestionusuarios.service.UsuarioService;
import com.aprendiendo.apigestionusuarios.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(Constantes.API)
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioResponse> crearUsuario(
            @RequestHeader("ClientId") String clientId,
            @RequestHeader("Channel") String channel,
            @RequestBody Usuario usuario) {

        UsuarioResponse usuarioResponse = usuarioService.crearUsuario(usuario, clientId, channel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponse);
    }
    @GetMapping("/usuarios/{nroDocumento}")
    public Optional<UsuarioDto> buscarUsuario(
            @PathVariable Long nroDocumento,
            @RequestHeader("ClientId") String clientId,
            @RequestHeader("Channel") String channel)
             {

        return usuarioService.buscarUsuario(nroDocumento);
    }

}
