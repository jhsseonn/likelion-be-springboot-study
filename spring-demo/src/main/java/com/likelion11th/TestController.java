package com.likelion11th;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/test")
    public UserDto test() {

        UserDto userDto = new UserDto();
        userDto.setAge(23);
        userDto.setName("hongsi");

        return userDto;
    }
}
