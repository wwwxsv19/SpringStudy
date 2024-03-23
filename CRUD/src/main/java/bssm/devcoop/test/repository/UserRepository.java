package bssm.devcoop.test.repository;

import bssm.devcoop.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 레퍼지토리다 선언!
public interface UserRepository extends JpaRepository<User, Long> { // 엔티티, 기본키 자료형 ( 래퍼클래스 )

}
