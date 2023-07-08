package com.berkansahan.expensetrack.authentication.dto;

public record RegisterRequest(String firstname,
                              String lastname,
                              String email,
                              String password) {
}
