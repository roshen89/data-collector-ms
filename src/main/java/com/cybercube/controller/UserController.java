package com.cybercube.controller;

import com.cybercube.dto.UserDTO;
import com.cybercube.service.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(value = "/api/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

  private final UserServiceImpl userServiceImpl;

  @PostMapping(path = "collect")
  public ResponseEntity<UserDTO> collectData(@RequestBody UserDTO userDTO) throws JsonProcessingException {
    return userServiceImpl.sendMessage(userDTO);
  }
}
