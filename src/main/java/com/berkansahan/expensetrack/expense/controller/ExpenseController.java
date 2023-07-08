package com.berkansahan.expensetrack.expense.controller;

import com.berkansahan.expensetrack.expense.controller.contract.ExpenseControllerContract;
import com.berkansahan.expensetrack.expense.dto.ExpenseDTO;
import com.berkansahan.expensetrack.expense.dto.ExpenseSaveRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author berkansahan
 */
@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController  {

    private final ExpenseControllerContract expenseControllerContract;

    @PostMapping()
    public ResponseEntity<ExpenseDTO> save(@RequestBody ExpenseSaveRequest request) {
        var expenseDTO = expenseControllerContract.save(request);
        return ResponseEntity.ok(expenseDTO);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ExpenseDTO>> expenseListByUserId(@PathVariable Long userId) {
        var expenseDTOList = expenseControllerContract.expenseListByUserId(userId);
        return ResponseEntity.ok(expenseDTOList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        expenseControllerContract.deleteById(id);
        return ResponseEntity.ok("delete is ok.");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ExpenseDTO> updateExpenseAmount(@PathVariable Long id, @RequestParam Double newAmount) {
       var expenseDTO = expenseControllerContract.updateExpenseAmount(id, newAmount);
        return ResponseEntity.ok(expenseDTO);
    }

    @GetMapping("/total/{userId}")
    public ResponseEntity<Double> getTotalExpensesByUserId(@PathVariable Long userId) {
        Double totalExpense = expenseControllerContract.totalExpenseByUserId(userId);
        return ResponseEntity.ok(totalExpense);
    }
}
