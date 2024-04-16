package bssm.devcoop.test.service;

import bssm.devcoop.test.dto.UserRequestDto;
import bssm.devcoop.test.entity.TestUser;
import bssm.devcoop.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void create(UserRequestDto userRequestDto) {
        String name = userRequestDto.getName();
        String email = userRequestDto.getEmail();
        String password = userRequestDto.getPassword();

        if (name == null) {
            throw new RuntimeException("이름이 존재하지 않습니다.");
        } else if (email == null) {
            throw new RuntimeException("이메일이 존재하지 않습니다.");
        } else if (password == null) {
            throw new RuntimeException("비밀번호가 존재하지 않습니다.");
        }

        TestUser testUser = TestUser.builder()
                .name(name).email(email).password(password)
                .build();

        userRepository.save(testUser);
    }

}
