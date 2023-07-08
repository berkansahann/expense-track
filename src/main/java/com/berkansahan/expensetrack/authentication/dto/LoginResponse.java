package com.berkansahan.expensetrack.authentication.dto;

public record LoginResponse(Long userId,
                            String token) {
}
