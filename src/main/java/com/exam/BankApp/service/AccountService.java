package com.exam.BankApp.service;

import com.exam.BankApp.exception.AccountNotFoundException;
import com.exam.BankApp.mapper.AccountMapper;
import com.exam.BankApp.model.Account;
import com.exam.BankApp.repository.AccountRepository;
import dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDto createAccount(AccountDto accountDto){

        Account account=AccountMapper.maptoaccount(accountDto);
        Account savedaccount=accountRepository.save(account);
        AccountDto accountDto1=AccountMapper.maptodto(account);
        return accountDto1;
    }

    public AccountDto getaccountById(int id){

        Account account=accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException(id,"Account does not exists"));
        AccountDto accountDto=AccountMapper.maptodto(account);
        return accountDto;

    }

    public List<AccountDto> getallAcc(){

        List<Account> aclist=accountRepository.findAll();

        List<AccountDto> li=aclist.stream().map(list->AccountMapper.maptodto(list)).collect(Collectors.toList());
        return li;

    }

    public void deleteByid(int id){

        accountRepository.deleteById(id);


    }
    public AccountDto amtDeposit(int id,Double amount){

        if(amount==null){
            throw new IllegalArgumentException("amt should not be null");
        }

        System.out.println("amtdeposi called..............");
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("accunt not found"));
        Double total=account.getBalance()+amount;
        account.setBalance(total);
        Account account1=accountRepository.save(account);
        AccountDto accountDto=AccountMapper.maptodto(account1);
        return accountDto;
    }


    public  AccountDto withdraw(int id,Double amount){

        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("acc not found...."));
        Double balance=account.getBalance()-amount;
        account.setBalance(balance);
        Account account1=accountRepository.save(account);
        return AccountMapper.maptodto(account1);

     }

}
