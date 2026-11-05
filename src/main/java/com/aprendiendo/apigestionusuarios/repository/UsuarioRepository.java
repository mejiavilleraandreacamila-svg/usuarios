package com.aprendiendo.apigestionusuarios.repository;

import com.aprendiendo.apigestionusuarios.model.Usuario;
import com.aprendiendo.apigestionusuarios.model.dto.UsuarioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioDto, Long> {

    boolean existsByNroDocumento(Long nroDocumento);

    UsuarioDto findByNroDocumento(Long nroDocumento);
}
