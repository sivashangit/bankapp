package com.exam.BankApp.exception;

public class AccountNotFoundException extends RuntimeException{


    private int accId;
     public AccountNotFoundException(int accId,String str){

            super(str);
            this.accId=accId;

    }
    public int getAccId(){

         return accId;
    }
}
