package com.berkansahan.expensetrack.authentication.service;

import com.berkansahan.expensetrack.authentication.entity.User;
import com.berkansahan.expensetrack.authentication.entity.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author berkansahan
 */
@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public User findByIdWithControl(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
