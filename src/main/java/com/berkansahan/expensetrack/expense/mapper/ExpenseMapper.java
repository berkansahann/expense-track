package com.berkansahan.expensetrack.expense.mapper;

import com.berkansahan.expensetrack.expense.dto.ExpenseDTO;
import com.berkansahan.expensetrack.expense.dto.ExpenseSaveRequest;
import com.berkansahan.expensetrack.expense.entity.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author berkansahan
 */
@Mapper
public interface ExpenseMapper {

    ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);

    Expense convertToExpense(ExpenseSaveRequest request);

    @Mapping(target = "userId", source = "user.id")
    ExpenseDTO convertToExpenseDTO(Expense expense);

    List<ExpenseDTO> convertToExpenseDTOList(List<Expense> expenseList);
}