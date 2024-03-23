package bssm.devcoop.test.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// default import
@Entity(name = "user") // Entity 설계한다고 선언
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 인자가 없는 기본 생성자 구현!
public class User {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가
//    @Column(name = "user_id")
    private Long id;
    private String name;
    private String email;
    private String password;

    @Builder // insert into 넣을 때 사용
    public User(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}