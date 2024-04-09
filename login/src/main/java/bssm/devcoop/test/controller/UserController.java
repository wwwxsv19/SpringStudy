package bssm.devcoop.test.controller;

import bssm.devcoop.test.dto.UserRequestDto;
import bssm.devcoop.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
