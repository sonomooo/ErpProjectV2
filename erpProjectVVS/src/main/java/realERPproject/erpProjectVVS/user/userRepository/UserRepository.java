package realERPproject.erpProjectVVS.user.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import realERPproject.erpProjectVVS.user.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLoginId(String loginId);
}
