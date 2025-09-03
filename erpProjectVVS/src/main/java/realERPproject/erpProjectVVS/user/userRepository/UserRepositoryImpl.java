package realERPproject.erpProjectVVS.user.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import realERPproject.erpProjectVVS.user.entity.User;

import java.util.Optional;

@Repository
public interface UserRepositoryImpl extends JpaRepository<User, Long> {

    User save(User user);

    Optional<User> findById(Long Id);

    User findByloginId(String loginId);
}
