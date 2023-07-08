package com.berkansahan.expensetrack.authentication.mapper;

import com.berkansahan.expensetrack.authentication.dto.LoginResponse;
import com.berkansahan.expensetrack.authentication.dto.RegisterRequest;
import com.berkansahan.expensetrack.authentication.dto.UserDTO;
import com.berkansahan.expensetrack.authentication.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author berkansahan
 */
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User convertToUser(RegisterRequest request);

    UserDTO convertToUserDTO(User user);

    List<UserDTO> convertToUserDTOList(List<User> userList);
}
