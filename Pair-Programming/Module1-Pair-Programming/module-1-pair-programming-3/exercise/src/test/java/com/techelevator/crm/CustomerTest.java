package com.techelevator.crm;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void sumOfAllServicesShouldBeEightySixDollarsWithTwentyFiveCents() {
        Map <String, Double> testing = new HashMap<String, Double>();
        Customer customer = new Customer("Garfield", "Andrew");
        testing.put("Gromming", 25.95);
        testing.put("Walking", 19.95);
        testing.put("PetSitting",40.35);


        assertEquals(86.25,customer.getBalanceDue(testing));
    }
}