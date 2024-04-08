package ru.danyabereg.producerjson.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import ru.danyabereg.producerjson.mapper.UserMapper;
import ru.danyabereg.producerjson.model.dto.UserDto;
import ru.danyabereg.producerjson.model.entity.User;
import ru.danyabereg.producerjson.model.repository.UserRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static ru.danyabereg.producerjson.service.ServiceMessage.CREATED;
import static ru.danyabereg.producerjson.service.ServiceMessage.READ;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final UserMapper mapper;
    private final UserRepository repository;

    private final String topic = "user-events-topic";
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDto createUser(UserDto userDto) throws ExecutionException, InterruptedException, JsonProcessingException {
        UserDto saveResult = mapper.mapTo(repository.save((mapper.mapFrom(userDto))));

        SendResult<String, Object> result = kafkaTemplate
                .send(topic, CREATED.name(), userDto).get();

        LOGGER.info("Topic: {}", result.getRecordMetadata().topic());
        LOGGER.info("Partition: {}", result.getRecordMetadata().partition());
        LOGGER.info("Offset: {}", result.getRecordMetadata().offset());

        LOGGER.info("Return: {}", CREATED);

        return saveResult;
    }

    @Override
    public UserDto readUser(UserDto userDto) throws ExecutionException, InterruptedException, JsonProcessingException {
        UserDto readResult = repository.findByFirstName(userDto.getFirstName()).map(mapper::mapTo).orElseThrow();

        SendResult<String, Object> result = kafkaTemplate
                .send(topic, READ.name(), readResult).get();

        LOGGER.info("Topic: {}", result.getRecordMetadata().topic());
        LOGGER.info("Partition: {}", result.getRecordMetadata().partition());
        LOGGER.info("Offset: {}", result.getRecordMetadata().offset());

        LOGGER.info("Return: {}", READ.name());

        return readResult;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto deleteUser(UserDto userDto) {
        return null;
    }
}
