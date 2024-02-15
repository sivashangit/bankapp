package com.exam.BankApp.controller;

import com.exam.BankApp.model.Account;
import com.exam.BankApp.service.AccountService;
import dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){

        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<AccountDto> getAccBuId(@PathVariable int id){

        return new ResponseEntity<>(accountService.getaccountById(id),HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<AccountDto>> getAllAcc(){

        return new ResponseEntity<>(accountService.getallAcc(),HttpStatus.OK);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> amtdeposit(
            @PathVariable int id,
            @RequestBody Map<String,Double> request){

        Double amount=request.get("amount");
        System.out.println(amount);
        AccountDto accountDto=accountService.amtDeposit(id,amount);
        return ResponseEntity.ok(accountDto);

    }

    @PutMapping("/{id}/with  draw")
    public ResponseEntity<AccountDto> amtwithdraw(@PathVariable int id,@RequestBody Map<String,Double> request){

        Double amt=request.get("amount");
        AccountDto accountDto=accountService.withdraw(id,amt);
        return ResponseEntity.ok(accountDto);

    }

   /* @DeleteMapping("/{id}")
    public void deleteByid(int id){

        return new ResponseEntity<>(accountService.deleteByid(id),HttpStatus.OK)
    }*/
}
