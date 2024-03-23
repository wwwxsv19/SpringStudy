/*
package bssm.devcoop.test.controller;

import bssm.devcoop.test.dto.UserRequestDto;
import bssm.devcoop.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/create")
    public void insert(@RequestBody UserRequestDto userRequestDto) {
        userService.create(userRequestDto);
    }
}
*/