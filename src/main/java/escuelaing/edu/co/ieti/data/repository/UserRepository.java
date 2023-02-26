package escuelaing.edu.co.ieti.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import escuelaing.edu.co.ieti.data.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
