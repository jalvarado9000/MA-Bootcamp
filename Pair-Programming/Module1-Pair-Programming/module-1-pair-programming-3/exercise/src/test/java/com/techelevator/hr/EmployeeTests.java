package com.techelevator.hr;

import com.techelevator.crm.Customer;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EmployeeTests {

    @Test
    public void allDueShouldReturnFortyThreeDollarsAndTwelveCents() {
        Map<String, Double> testing = new HashMap<>();
        Employee employee = new Employee("Garfield", "Andrew");
        testing.put("Gromming", 25.95);
        testing.put("Walking", 19.95);
        testing.put("PetSitting", 40.34);


        Assertions.assertEquals(43.12,employee.getBalanceDue(testing));
    }
}