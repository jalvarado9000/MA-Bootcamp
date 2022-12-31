package com.techelevator.challenge;

import java.math.BigDecimal;

public class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private BigDecimal balance;

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }


    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolderName, String accountNumber, String strBalance ) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        balance = new BigDecimal(strBalance);
    }


    public BigDecimal deposit(String amountToDeposit){
        BigDecimal amount = new BigDecimal(amountToDeposit);
        if(amount.compareTo(BigDecimal.valueOf(0)) <  0)
            return balance;
        else
            balance = balance.add(amount);
        return balance;

    }

    public BigDecimal withdraw(String amountToWithdraw){
        BigDecimal amount = new BigDecimal(amountToWithdraw);
       balance = balance.subtract(amount);
        return balance;

    }
}