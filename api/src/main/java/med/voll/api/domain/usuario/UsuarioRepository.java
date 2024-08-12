package med.voll.api.domain.usuario;

import org.hibernate.sql.exec.spi.JdbcParametersList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    UserDetails findByLogin(String username);
}
