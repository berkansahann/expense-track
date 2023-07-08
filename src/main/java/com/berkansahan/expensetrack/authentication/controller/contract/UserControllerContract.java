package com.berkansahan.expensetrack.authentication.controller.contract;

import com.berkansahan.expensetrack.authentication.dto.UserDTO;

import java.util.List;

/**
 * @author berkansahan
 */
public interface UserControllerContract {
    List<UserDTO> findAll();

    UserDTO findById(Long id);
}
