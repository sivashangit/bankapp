package com.exam.BankApp.mapper;

import com.exam.BankApp.model.Account;
import dto.AccountDto;

public class AccountMapper {

   public static Account maptoaccount(AccountDto accountDto){

       Account account=new Account(accountDto.getId(),accountDto.getName(),accountDto.getBalance());
       return account;

    }

    public static AccountDto maptodto(Account account){

       AccountDto accountDto=new AccountDto(account.getId(),account.getName(),account.getBalance());
       return accountDto;

   }
}

