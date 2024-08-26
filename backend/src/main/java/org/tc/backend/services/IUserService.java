package org.tc.backend.services;

import org.tc.backend.dtos.UpdateUserDTO;
import org.tc.backend.dtos.UserDTO;
import org.tc.backend.exceptions.DataNotFoundException;
import org.tc.backend.models.User;

public interface IUserService {
    User createUser(UserDTO userDTO) throws Exception;
    String login(String phoneNumber, String password, Long roleId) throws Exception;
    User getUserDetailsFromToken(String token) throws Exception;
    User updateUser(Long userId, UpdateUserDTO updatedUserDTO) throws Exception;
}
