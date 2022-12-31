package com.techelevator;

public class CheckingAccount extends BankAccount implements Status {


    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int balance = getBalance();


        int limitAmount = -100;
        balance -= amountToWithdraw;

        if (balance < 0 && balance > limitAmount)
            amountToWithdraw+= 10;
        else{
            if (balance <= limitAmount)
                amountToWithdraw = 0;
        }

        if(amountToWithdraw < 100){
            balanceDropped();
        }
        //setBalance(balance);
        return CheckingAccount.super.withdraw(amountToWithdraw);

    }

    @Override
    public void balanceDropped() {
        System.out.println("BALANCED DROPPED");
        System.out.println("Low Balance");
        System.out.println("The available balance on CHECKING ACCOUNT");
        System.out.println("has dropped below $100");
    }
}
