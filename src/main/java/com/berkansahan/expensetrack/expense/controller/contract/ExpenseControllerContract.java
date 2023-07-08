package com.berkansahan.expensetrack.expense.controller.contract;

import com.berkansahan.expensetrack.expense.dto.ExpenseDTO;
import com.berkansahan.expensetrack.expense.dto.ExpenseSaveRequest;

import java.util.List;

/**
 * @author berkansahan
 */
public interface ExpenseControllerContract {

    ExpenseDTO save(ExpenseSaveRequest request);

    List<ExpenseDTO> expenseListByUserId(Long userId);

    void deleteById(Long id);

    ExpenseDTO updateExpenseAmount(Long id, Double newAmount);

    Double totalExpenseByUserId(Long userId);
}
