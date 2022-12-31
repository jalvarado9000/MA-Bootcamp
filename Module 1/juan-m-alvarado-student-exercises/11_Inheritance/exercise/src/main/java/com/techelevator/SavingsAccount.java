package com.techelevator;

public class SavingsAccount extends BankAccount implements Status{

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }


    public int withdraw(int amountToWithdraw) {
        int balance = getBalance();
        balance -= amountToWithdraw;
        if(balance < 150 && balance >= 2)
            amountToWithdraw+=2;
        else
        {
            if(getBalance() < amountToWithdraw)
                amountToWithdraw = 0;
        }

        if(amountToWithdraw < 100){
            balanceDropped();
        }

        return SavingsAccount.super.withdraw(amountToWithdraw);



    }


    @Override
    public void balanceDropped() {
        System.out.println("BALANCED DROPPED");
        System.out.println("Low Balance");
        System.out.println("The available balance on SAVINGS ACCOUNT");
        System.out.println("has dropped below $100");
    }
}
