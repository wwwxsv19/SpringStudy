
package bssm.devcoop.test.service;

import bssm.devcoop.test.dto.UserRequestDto;
import bssm.devcoop.test.entity.User;
import bssm.devcoop.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void create(UserRequestDto userRequestDto) {
        String name = userRequestDto.getName();
        String email = userRequestDto.getEmail();
        String password = userRequestDto.getPassword();

        if (name == null) {
            throw new RuntimeException("이름이 존재하지 않습니다.");
        }

        User user = User.builder()
                .name(name).email(email).password(password)
                .build(); // 체이닝 메소드

        userRepository.save(user);
    }
}
