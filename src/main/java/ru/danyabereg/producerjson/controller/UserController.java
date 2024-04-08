package ru.danyabereg.producerjson.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.danyabereg.producerjson.model.dto.UserDto;
import ru.danyabereg.producerjson.service.UserService;

import java.util.Date;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {
        UserDto result = null;
        try {
            result = userService.readUser(userDto);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage(new Date(), e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
