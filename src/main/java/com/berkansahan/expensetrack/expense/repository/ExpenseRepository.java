package com.berkansahan.expensetrack.expense.repository;

import com.berkansahan.expensetrack.expense.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author berkansahan
 */
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByUserId(Long userId);
}
