package com.berkansahan.expensetrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExpenseTrackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpenseTrackApplication.class, args);
    }

}
