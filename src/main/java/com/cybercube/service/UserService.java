package com.cybercube.service;

import com.cybercube.dto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface UserService {

  /**
   * This method is for send userDTO to kafka
   *
   * @param userDTO UserDTO object
   * @return ResponseEntity<UserDTO>
   *
   * @throws JsonProcessingException exception
   */
  ResponseEntity<UserDTO> sendMessage(UserDTO userDTO) throws JsonProcessingException;

}
