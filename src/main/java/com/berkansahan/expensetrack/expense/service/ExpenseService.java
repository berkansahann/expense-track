package com.berkansahan.expensetrack.expense.service;

import com.berkansahan.expensetrack.authentication.entity.User;
import com.berkansahan.expensetrack.authentication.entity.UserRepository;
import com.berkansahan.expensetrack.authentication.service.UserService;
import com.berkansahan.expensetrack.expense.dto.ExpenseSaveRequest;
import com.berkansahan.expensetrack.expense.entity.Expense;
import com.berkansahan.expensetrack.expense.mapper.ExpenseMapper;
import com.berkansahan.expensetrack.expense.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * @author berkansahan
 */
@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final UserService userService;
    private final ExpenseRepository expenseRepository;

    public Expense saveExpense(ExpenseSaveRequest request){
        Expense expense = ExpenseMapper.INSTANCE.convertToExpense(request);
        User user = userService.findByIdWithControl(request.userId());
        expense.setUser(user);
        expense.setCreatedDate(LocalDateTime.now());
        expenseRepository.save(expense);
        return expense;
    }
    public void updateExpenseAmount(Expense expense){
        expenseRepository.save(expense);
    }

    public List<Expense> findByUserId(Long userId) {
        return expenseRepository.findAllByUserId(userId);
    }

    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }

    public Expense findByIdWithControl(Long id) {
        return expenseRepository.findById(id).orElseThrow();
    }
}
