package com.berkansahan.expensetrack.authentication.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author berkansahan
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
