package bssm.devcoop.test.repository;

import bssm.devcoop.test.dto.UserResponseDto;
import bssm.devcoop.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
