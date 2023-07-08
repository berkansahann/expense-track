package com.berkansahan.expensetrack.expense.controller.contract.impl;

import com.berkansahan.expensetrack.expense.controller.contract.ExpenseControllerContract;
import com.berkansahan.expensetrack.expense.dto.ExpenseDTO;
import com.berkansahan.expensetrack.expense.dto.ExpenseSaveRequest;
import com.berkansahan.expensetrack.expense.entity.Expense;
import com.berkansahan.expensetrack.expense.mapper.ExpenseMapper;
import com.berkansahan.expensetrack.expense.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author berkansahan
 */
@Service
@RequiredArgsConstructor
public class ExpenseControllerImpl implements ExpenseControllerContract {

    private final ExpenseService expenseService;

    @Override
    public ExpenseDTO save(ExpenseSaveRequest request) {
        Expense expense = expenseService.saveExpense(request);
        return ExpenseMapper.INSTANCE.convertToExpenseDTO(expense);
    }

    @Override
    public List<ExpenseDTO> expenseListByUserId(Long userId) {
        List<Expense> expenseList = expenseService.findByUserId(userId);
        return ExpenseMapper.INSTANCE.convertToExpenseDTOList(expenseList);
    }
}
