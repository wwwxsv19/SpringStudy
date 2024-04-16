package bssm.devcoop.test.repository;

import bssm.devcoop.test.entity.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<TestUser, Long> {
    TestUser findByEmail(@Param("email")String email);
}
