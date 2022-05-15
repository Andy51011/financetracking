package com.v1.financetracker.balance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.v1.financetracker.finances.Finance;
import com.v1.financetracker.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name="balance")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "balance_id", nullable = false)
    private Long balanceId;

    @Column(name="balance")
    private double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    @ToString.Exclude
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "balance", cascade = CascadeType.ALL)
    private List<Finance> finance;
}
