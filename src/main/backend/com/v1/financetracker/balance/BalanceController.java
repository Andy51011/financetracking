package com.v1.financetracker.balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path = "api/v1/balance")
public class BalanceController {

    private BalanceService balanceService;

    @Autowired
    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Balance> getBalance(@PathVariable("id") Long id) {
        try {
            Balance bal = balanceService.findBalanceById(id);
            if (bal == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(bal, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

