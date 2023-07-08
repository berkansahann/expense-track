package com.berkansahan.expensetrack.authentication.dto;

/**
 * @author berkansahan
 */
public record UserDTO(Long id,
                      String firstname,
                      String lastname,
                      String email) {
}
