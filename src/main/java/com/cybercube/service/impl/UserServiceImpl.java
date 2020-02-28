package com.cybercube.service.impl;

import com.cybercube.dto.UserDTO;
import com.cybercube.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

  @Value("${calculation.seed}")
  private Integer calculationSeed;

  @Value("${kafka.topic}")
  private String topic;

  private final KafkaTemplate<Integer, Object> kafkaTemplate;
  private final ObjectMapper objectMapper;

  @Override
  public ResponseEntity<UserDTO> sendMessage(UserDTO userDTO) throws JsonProcessingException {
    log.info("userDTO: " + userDTO);
    if (userDTO == null) {
      log.error("UserDTO is null");
      return ResponseEntity.badRequest().build();
    } else {
      String userMessage = objectMapper.writeValueAsString(userDTO);
      kafkaTemplate.send(topic, calculationSeed, userMessage);
      log.info("User sent. user: " + userMessage);
      return ResponseEntity.ok().build();
    }
  }
}
