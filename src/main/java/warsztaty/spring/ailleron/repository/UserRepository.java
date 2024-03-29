package warsztaty.spring.ailleron.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import warsztaty.spring.ailleron.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByName(@Param("Name") String name);
}
