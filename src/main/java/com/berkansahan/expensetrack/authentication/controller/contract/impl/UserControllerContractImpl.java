package com.berkansahan.expensetrack.authentication.controller.contract.impl;

import com.berkansahan.expensetrack.authentication.controller.contract.UserControllerContract;
import com.berkansahan.expensetrack.authentication.dto.UserDTO;
import com.berkansahan.expensetrack.authentication.entity.User;
import com.berkansahan.expensetrack.authentication.mapper.UserMapper;
import com.berkansahan.expensetrack.authentication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author berkansahan
 */
@Service
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContract {

    private final UserService userService;
    @Override
    public List<UserDTO> findAll() {
        List<User> userList = userService.findAll();
        return UserMapper.INSTANCE.convertToUserDTOList(userList);
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userService.findByIdWithControl(id);
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }
}
