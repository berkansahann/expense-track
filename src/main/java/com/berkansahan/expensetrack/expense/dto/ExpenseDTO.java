package com.berkansahan.expensetrack.expense.dto;

/**
 * @author berkansahan
 */
public record ExpenseDTO(Long id,
                         Long userId,
                         Double amount,
                         String sector) {
}
