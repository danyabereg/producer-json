package ru.danyabereg.producerjson.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danyabereg.producerjson.model.dto.UserDto;
import ru.danyabereg.producerjson.model.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByFirstName(String name);
}
