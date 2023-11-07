package com.seabank.quanlytruonghoc.controller;

import com.seabank.quanlytruonghoc.entity.Account;
import com.seabank.quanlytruonghoc.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping(path = "/get-all")
    public ResponseEntity<List<Account>> getAll() {
        return new ResponseEntity<>(accountRepository.findAll(), HttpStatus.OK);
    }


    @PostMapping(path = "/result", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> result(@RequestBody String string) {
        return new ResponseEntity<>(string, HttpStatus.OK);
    }

    // them
    @PostMapping(path = "/add-new")
    public Account addAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    // sua
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Integer id, @RequestBody Account accountDetail) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setStk(accountDetail.getStk());
            account.setTen(accountDetail.getTen());
            account.setSoTien(accountDetail.getSoTien());

            Account updatedAccount = accountRepository.save(account);
            return ResponseEntity.ok(updatedAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // xoa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Integer id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            accountRepository.delete(optionalAccount.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
