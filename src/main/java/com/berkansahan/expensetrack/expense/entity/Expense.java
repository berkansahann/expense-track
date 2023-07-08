package com.berkansahan.expensetrack.expense.entity;

import com.berkansahan.expensetrack.authentication.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "amount")
    private Double amount;

}
