package ru.danyabereg.producerjson.mapper;

import org.springframework.stereotype.Component;
import ru.danyabereg.producerjson.model.dto.ProfileDto;
import ru.danyabereg.producerjson.model.entity.Profile;
import ru.danyabereg.producerjson.model.entity.Sex;

@Component
public class ProfileMapper implements Mapper<ProfileDto, Profile>{
    @Override
    public Profile mapFrom(ProfileDto dto) {
        return Profile.builder()
                .phone(dto.getPhone())
                .city(dto.getCity())
                .sex(Sex.valueOf(dto.getSex()))
                .hobbies(dto.getHobbies())
                .build();
    }

    @Override
    public ProfileDto mapTo(Profile entity) {
        return ProfileDto.builder()
                .phone(entity.getPhone())
                .city(entity.getCity())
                .sex(entity.getSex().name())
                .hobbies(entity.getHobbies())
                .build();
    }
}
