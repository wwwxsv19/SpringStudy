package bssm.devcoop.test.service;

import bssm.devcoop.test.dto.LoginResponseDto;
import bssm.devcoop.test.entity.JwtUtil;
import bssm.devcoop.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Value("${jwt.secret}")
    private String secretKey;

    private String loginToken(LoginResponseDto loginResponseDto) throws Exception {
        Long id = loginResponseDto.getId();
        String email = loginResponseDto.getEmail();

        try {
            if(id == null || email == null) {
                throw new RuntimeException("Bad Request Auth Error");
            }
            String token = jwtUtil.createJwt(id, email, secretKey, 1000 * 60 * 60L);
            return token;
        } catch (Exception e) {
            throw new Exception("Internal server Error");
        }
    }

}
