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

    @GetMapping()
    public ResponseEntity<List<ExpenseDTO>> expenseListByUserId(@RequestParam Long userId) {
        var expenseDTOList = expenseControllerContract.expenseListByUserId(userId);
        return ResponseEntity.ok(expenseDTOList);
    }

}
