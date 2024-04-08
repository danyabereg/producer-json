package ru.danyabereg.producerjson.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.danyabereg.producerjson.model.dto.UserDto;

import java.util.concurrent.ExecutionException;

public interface UserService {
    UserDto createUser(UserDto userDto) throws ExecutionException, InterruptedException, JsonProcessingException;
    UserDto readUser(UserDto userDto) throws ExecutionException, InterruptedException, JsonProcessingException;
    UserDto updateUser(UserDto userDto);
    UserDto deleteUser(UserDto userDto);
}
