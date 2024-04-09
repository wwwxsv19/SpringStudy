package bssm.devcoop.test.dto;

import bssm.devcoop.test.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private String email;
    private String password;
}
