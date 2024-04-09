package bssm.devcoop.test.service;

import bssm.devcoop.test.dto.LoginResponseDto;
import bssm.devcoop.test.entity.User;
import bssm.devcoop.test.util.JwtUtil;
import bssm.devcoop.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Value("${jwt.secret}")
    private String secretKey;

    Long exprTime = 1000 * 60 * 60L;

    public String login(LoginResponseDto userResponseDto) {
        String email = userResponseDto.getEmail();
        String password = userResponseDto.getPassword();

        User findUser = userRepository.findByEmail(email);

        if(findUser == null) {
            throw new RuntimeException("can not found user");
        }

        try {
            if(!findUser.checkPW(password)) {
                throw new RuntimeException("not correct password");
            }
            String token = jwtUtil.createJwt(findUser.getId(), email, secretKey, exprTime);
            return token;
        } catch (Exception e) {
            throw new RuntimeException("Internal server Error");
        }
    }
}
