package com.techelevator.challenge;

//import com.techelevator.BankAccount;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {


    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, String strBalance) {
        super(accountHolderName, accountNumber, strBalance);
    }

    @Override
    public BigDecimal withdraw(String amountToWithdraw) {
        BigDecimal balance = new BigDecimal(String.valueOf(SavingsAccount.super.getBalance()));
        BigDecimal amount = new BigDecimal(amountToWithdraw);



        //BigDecimal limitAmount = new BigDecimal(-100);
        balance = balance.subtract(amount);

        if (balance.compareTo(BigDecimal.valueOf(150)) < 0 && balance.compareTo(BigDecimal.valueOf(2)) >= 0)
            amount = amount.add(BigDecimal.valueOf(2));
        else{
            if (balance.compareTo(amount) < 0)
                amount = BigDecimal.valueOf(0);
        }
        //setBalance(balance);
        return SavingsAccount.super.withdraw(amount.toPlainString());

    }

}
