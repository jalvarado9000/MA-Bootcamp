package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();

    //Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts(){
        Accountable[] accountable = new Accountable[accounts.size()];

        for(int i = 0; i < accounts.size(); i++)
            accountable[i] = accounts.get(i);

        return accountable;

    }

    public void addAccount(Accountable newAccount){
        accounts.add(newAccount);

    }

    public boolean isVip(){
        int total = 0;
        boolean flag = false;
        for(int i = 0; i < accounts.size(); i++)
            total += accounts.get(i).getBalance();

        if(total >= 25000)
            flag = true;
        return flag;

    }



}
