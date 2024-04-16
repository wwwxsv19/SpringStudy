package bssm.devcoop.test.service;

import bssm.devcoop.test.dto.LoginRequestDto;
import bssm.devcoop.test.dto.LoginResponseDto;
import bssm.devcoop.test.entity.TestUser;
import bssm.devcoop.test.util.JwtUtil;
import bssm.devcoop.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPWEncoder;

    @Value("${jwt.secret}")
    private String secretKey;

    Long exprTime = 1000 * 60 * 60L;

    @Transactional
    public LoginResponseDto login(LoginRequestDto userResponseDto) {
        String email = userResponseDto.getEmail();
        String password = userResponseDto.getPassword();
        try {
            TestUser user = userRepository.findByEmail(email);

            if(user == null) {
                throw new RuntimeException("can not found user");
            }

            if(!bCryptPWEncoder.matches(user.getPassword(), password)) {
                throw new RuntimeException("not correct password");
            }

            String token = JwtUtil.createJwt(user.getId(), email, secretKey, exprTime);

            LoginResponseDto response = LoginResponseDto.builder()
                    .token(token)
                    .name(user.getName())
                    .email(email)
                    .build();

            return response;
        } catch (Exception e) {
            throw new RuntimeException("Internal server Error");
        }
    }
}
