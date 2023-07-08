package com.berkansahan.expensetrack.expense.dto;

/**
 * @author berkansahan
 */
public record ExpenseSaveRequest(Long userId,
                                 Double amount,
                                 String sector) {
}
