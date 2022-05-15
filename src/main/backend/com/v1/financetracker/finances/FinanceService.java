package com.v1.financetracker.finances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinanceService {

    private final FinanceRepository financeRepository;

    @Autowired
    public FinanceService(FinanceRepository financeRepository) {
        this.financeRepository = financeRepository;
    }

    //find all users
    public List<Finance> getAllFinances() {
        return financeRepository.findAll();
    }

    // find a single user
    public Finance findFinanceById(Long id) {
        return financeRepository.getById(id);
    }

    // return true if deleted
    public void deleteFinanceById(Long id) {
        financeRepository.deleteById(id);
    }

    // adds new user
    public Finance addNewFinance(Finance finance) {
        return financeRepository.save(finance);
    }

    //update user
    public Finance updateFinance(Long id , Finance updatedFinance) {
        Optional<Finance> finance = financeRepository.findById(id);
        if (finance.isPresent()) {
            Finance _finance = finance.get();
            _finance.setFinanceId(updatedFinance.getFinanceId());
            _finance.setDescription(updatedFinance.getDescription());
            _finance.setAmount(updatedFinance.getAmount());
            _finance.setType(updatedFinance.getType());
            _finance.setDueDate(updatedFinance.getDueDate());
            return financeRepository.save(_finance);
        } else {
            return null;
        }
    }
}
