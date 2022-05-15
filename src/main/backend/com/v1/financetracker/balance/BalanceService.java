package com.v1.financetracker.balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {

    private final BalanceRepository balanceRepository;

    @Autowired
    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    // find single balance or can change to user id
    public Balance findBalanceById(Long id) {
        return balanceRepository.getById(id);
    }
}