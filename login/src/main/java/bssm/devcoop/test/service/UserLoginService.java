package bssm.devcoop.test.service;

import bssm.devcoop.test.dto.UserRequestDto;
import bssm.devcoop.test.dto.UserResponseDto;
import bssm.devcoop.test.entity.User;
import bssm.devcoop.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserLoginService {
    private final UserRepository userRepository;

    public User login(UserResponseDto userResponseDto) {
        String email = userResponseDto.getEmail();
        String password = userResponseDto.getPassword();

        Optional<User> findUser = userRepository.findByEmail(email);
        if(!findUser.orElseThrow(()->new RuntimeException("해당 이메일이 존재하지 않습니다."))
                .checkPW(password)) {
            throw new RuntimeException("이메일과 비밀번호가 일치하지 않습니다.");
        }

        return findUser.get();
    }
}
