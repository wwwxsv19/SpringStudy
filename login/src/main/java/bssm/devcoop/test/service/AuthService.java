package bssm.devcoop.test.service;

import bssm.devcoop.test.dto.LoginRequestDto;
import bssm.devcoop.test.entity.User;
import bssm.devcoop.test.util.JwtUtil;
import bssm.devcoop.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    @Value("${jwt.secret}")
    private String secretKey;

    Long exprTime = 1000 * 60 * 60L;

    public String login(LoginRequestDto userResponseDto) {
        String email = userResponseDto.getEmail();
        String password = userResponseDto.getPassword();
        try {
            User user = userRepository.findByEmail(email);

            if(user == null) {
                throw new RuntimeException("can not found user");
            }

            if(!user.checkPW(password)) {
                throw new RuntimeException("not correct password");
            }

            String token = JwtUtil.createJwt(user.getId(), email, secretKey, exprTime);
            return token;
        } catch (Exception e) {
            throw new RuntimeException("Internal server Error");
        }
    }
}
