package com.berkansahan.expensetrack.expense;

import com.berkansahan.expensetrack.authentication.entity.User;
import com.berkansahan.expensetrack.authentication.entity.UserRepository;
import com.berkansahan.expensetrack.expense.entity.Expense;
import com.berkansahan.expensetrack.expense.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ExpenseAggregationJob {

    private final UserRepository userRepository;
    private final ExpenseRepository expenseRepository;

//    @Scheduled(fixedRate = 5000)
//    public void aggregateExpenses() {
//        transaction();
//    }
//
//    @Scheduled(cron = "*/1 * * * * *")
//    public void minuteAggregateExpenses() {
//        transaction();
//        System.out.println("dasojsadoj");
//    }

    @Scheduled(cron = "0 0 0 * * *")
    public void dailyAggregateExpenses() {
        transaction();
    }

    @Scheduled(cron = "0 0 0 * * 1")
    public void weeklyAggregateExpenses() {
        transaction();
    }

    @Scheduled(cron = "0 0 0 1 * *")
    public void monthlyAggregateExpenses() {
        transaction();
    }

    public void transaction() {
        LocalDate now = LocalDate.now();

        List<User> users = userRepository.findAll();

        for (User user : users) {
            List<Expense> userExpenses = expenseRepository.findAllByUserId(user.getId());

            double totalAmount = userExpenses.stream()
                    .mapToDouble(Expense::getAmount)
                    .sum();
            System.out.println(totalAmount);
        }
    }
}
