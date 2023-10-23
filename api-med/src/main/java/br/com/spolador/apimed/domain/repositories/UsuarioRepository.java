package br.com.spolador.apimed.domain.repositories;

import br.com.spolador.apimed.domain.entidades.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login); // faz a consulta do usuário no db
}
