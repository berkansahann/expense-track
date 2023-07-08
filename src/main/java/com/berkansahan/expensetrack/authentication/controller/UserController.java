package com.berkansahan.expensetrack.authentication.controller;

import com.berkansahan.expensetrack.authentication.controller.contract.UserControllerContract;
import com.berkansahan.expensetrack.authentication.dto.LoginResponse;
import com.berkansahan.expensetrack.authentication.dto.UserDTO;
import com.berkansahan.expensetrack.authentication.entity.User;
import com.berkansahan.expensetrack.authentication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author berkansahan
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserControllerContract userControllerContract;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        var userDTOList = userControllerContract.findAll();
        return ResponseEntity.ok(userDTOList);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        var userDTO = userControllerContract.findById(id);
        return ResponseEntity.ok(userDTO);
    }


}
