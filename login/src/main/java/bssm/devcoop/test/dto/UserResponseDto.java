package bssm.devcoop.test.dto;

import bssm.devcoop.test.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private String email;
    private String password;

    public UserResponseDto(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
