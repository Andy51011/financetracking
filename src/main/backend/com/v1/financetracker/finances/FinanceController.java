package com.v1.financetracker.finances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path = "api/v1/finances")
public class FinanceController {

    private FinanceService financeService;

    @Autowired
    public FinanceController(FinanceService financeService) {
        this.financeService = financeService;
    }

    @GetMapping
    public ResponseEntity<List> getListOfFinances() {
        try {
            List<Finance> allUsers = financeService.getAllFinances();
            if (allUsers != null) {
                return new ResponseEntity<>(allUsers, HttpStatus.OK);
            } else {
                if (allUsers == null) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Finance> findSingleFinance(@PathVariable("id") Long id) {
        try {
            Finance finance = financeService.findFinanceById(id);
            if (finance == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(finance, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create-user")
    public ResponseEntity<Finance> createUser(@RequestBody Finance finance) {
        try {
            Finance newUser = financeService.addNewFinance(finance);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<Finance> updateUser(@PathVariable("id") Long id, @RequestBody Finance finance){
        try {
            Finance currFinance = financeService.updateFinance(id, finance);
            if (currFinance == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(currFinance, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @DeleteMapping
@DeleteMapping("/delete-finance/{id}")
public ResponseEntity<Finance> deleteFinance(@PathVariable("id") Long id) {
    try {
        financeService.deleteFinanceById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
}
