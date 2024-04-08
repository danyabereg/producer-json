package ru.danyabereg.producerjson.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.danyabereg.producerjson.model.dto.UserDto;
import ru.danyabereg.producerjson.model.entity.User;

@RequiredArgsConstructor
@Component
public class UserMapper implements Mapper<UserDto, User>{
    private final ProfileMapper profileMapper;
    @Override
    public User mapFrom(UserDto dto) {
        return User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .profile(profileMapper.mapFrom(dto.getProfileDto()))
                .build();
    }

    @Override
    public UserDto mapTo(User entity) {
        return UserDto.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .profileDto(profileMapper.mapTo(entity.getProfile()))
                .build();
    }
}
