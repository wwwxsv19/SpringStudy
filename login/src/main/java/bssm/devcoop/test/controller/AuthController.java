package bssm.devcoop.test.controller;

import bssm.devcoop.test.dto.LoginRequestDto;
import bssm.devcoop.test.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public String show(@RequestBody LoginRequestDto userResponseDto) {
        return authService.login(userResponseDto);
    }
}
