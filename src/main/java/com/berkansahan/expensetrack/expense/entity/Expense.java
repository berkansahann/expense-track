package com.berkansahan.expensetrack.expense.entity;

import com.berkansahan.expensetrack.authentication.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author berkansahan
 */
@Getter
@Setter
@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(generator = "Expense", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Expense", sequenceName = "expense_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "sector", length = 50, nullable = false)
    private String sector;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

}
