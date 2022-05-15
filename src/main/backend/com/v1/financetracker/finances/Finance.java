package com.v1.financetracker.finances;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.v1.financetracker.balance.Balance;
import com.v1.financetracker.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="finance")
public class Finance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="finance_id", nullable = false)
    private Long financeId;

    @Column(name="description")
    private String description;

    @Column(name="amount")
    private double amount;

    @Column(name="type")
    private String type;

    @Column(name="duedate")
    private String dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, updatable = false)
    @JsonIgnore
    @ToString.Exclude
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "balance_id", referencedColumnName = "balance_id")
    @JsonIgnore
    @ToString.Exclude
    private Balance balance;
}
