package bssm.devcoop.test.service;

import bssm.devcoop.test.dto.UserRequestDto;
import bssm.devcoop.test.dto.UserResponseDto;
import bssm.devcoop.test.entity.User;
import bssm.devcoop.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserLoginService {
    private final UserRepository userRepository;

    public String login(UserResponseDto userResponseDto) {
        String email = userResponseDto.getEmail();
        String password = userResponseDto.getPassword();

        if ( email == null ) {
            throw new RuntimeException("not correct email");
        }

        userRepository.findByEmail(email)
                .ifPresent( user -> {
                   if(!user.checkPW(password)) {
                       throw new RuntimeException("not correct password");
                   }
                });

        return "login success";
    }
}
