package com.aprendiendo.apigestionusuarios.service;

import com.aprendiendo.apigestionusuarios.exception.UsuarioExistenteException;
import com.aprendiendo.apigestionusuarios.model.Usuario;
import com.aprendiendo.apigestionusuarios.model.dto.UsuarioDto;
import com.aprendiendo.apigestionusuarios.model.response.UsuarioResponse;
import com.aprendiendo.apigestionusuarios.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioResponse crearUsuario(Usuario usuario, String clientId, String channel) {
        if (usuarioRepository.existsByNroDocumento(usuario.getDatosPersonales().getNroDocumento())) {
            throw new UsuarioExistenteException(
                    "El número de documento " + usuario.getDatosPersonales().getNroDocumento() + " ya existe"
            );
        }
        UsuarioDto usuarioGuardado = usuarioRepository.save(setUsuarioDto(usuario, clientId, channel));
        Long nroDocumento = usuarioGuardado.getNroDocumento();
        return new UsuarioResponse(nroDocumento);
    }

    private UsuarioDto setUsuarioDto(Usuario usuario, String channel, String clientId) {
        return UsuarioDto.builder()
                .nombre(usuario.getDatosPersonales().getNombre())
                .apellido(usuario.getDatosPersonales().getApellido())
                .nroDocumento(usuario.getDatosPersonales().getNroDocumento())
                .email(usuario.getContacto().getEmail())
                .telefono(usuario.getContacto().getTelefono())
                .ciudad(usuario.getDireccion().getCiudad())
                .pais(usuario.getDireccion().getPais())
                .username(usuario.getCuenta().getUsername())
                .password(usuario.getCuenta().getPassword())
                .edad(usuario.getInformacionAdicional().getEdad())
                .estado(usuario.getInformacionAdicional().getEstado())
                .cliente(channel)
                .canal(clientId)
                .build();
    }

    public Optional<UsuarioDto> buscarUsuario(Long nroDocumento) {
        validacion(nroDocumento);
        return Optional.ofNullable(usuarioRepository.findByNroDocumento(nroDocumento));
    }

    private void validacion(Long nroDocumento) {
        if (!usuarioRepository.existsByNroDocumento(nroDocumento)) {
            throw new UsuarioExistenteException(
                    "El número de documento " + nroDocumento + " no existe"
            );
        }
    }
}
