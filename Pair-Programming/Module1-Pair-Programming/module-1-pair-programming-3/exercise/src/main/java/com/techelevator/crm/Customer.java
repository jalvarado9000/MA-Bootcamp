package com.techelevator.crm;

import com.techelevator.Billable;
import com.techelevator.Person;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer  extends Person implements Billable {
    private String phoneNumber;
    private List<String> pets = new ArrayList<>();

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List getPets() {
        return pets;
    }

    public void setPets(List pets) {
        this.pets = pets;
    }

    public Customer(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
    }

    public Customer(String firstName, String lastName) {
        super(firstName, lastName);
    }


    @Override
    public double getBalanceDue(Map<String, Double> servicesRendered) {

        double due = 0;

        DecimalFormat f = new DecimalFormat("##.00");
        for(String service : servicesRendered.keySet()) {
            if (servicesRendered.containsKey(service))
                due += servicesRendered.get(service);
        }



        return Double.parseDouble(f.format(due));
    }
}
