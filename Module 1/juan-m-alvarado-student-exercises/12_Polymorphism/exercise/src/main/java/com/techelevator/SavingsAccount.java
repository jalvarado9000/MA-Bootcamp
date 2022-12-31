package com.techelevator;

public class SavingsAccount extends BankAccount {

    private int savingsBalance;
    private CheckingAccount c;

    public SavingsAccount(String accountHolder, String accountNumber, int balance) {
        super(accountHolder, accountNumber, balance);
    }

    public SavingsAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

    public int getBalance() {
        return super.getBalance();
    }



    public int transferTo(CheckingAccount destinationAcccount, int transferAmount){
        savingsBalance = super.transferTo(destinationAcccount,transferAmount);
        return savingsBalance;

    }



/*
    public int transferTo(CheckingAccount destinationAcccount, int transferAmount){
        savingsBalance = destinationAcccount.deposit(transferAmount);
        super.withdraw(transferAmount);
        return savingsBalance;

    }
    */

    @Override
    public int withdraw(int amountToWithdraw) {
        // only perform transaction of positive $ and room for fee
        if (getBalance() - amountToWithdraw >= 2) {
            super.withdraw(amountToWithdraw);
            // Assess $2 fee if it goes below $150
            if (getBalance() < 150) {
                super.withdraw(2);
            }
        }
        return getBalance();
    }
}
