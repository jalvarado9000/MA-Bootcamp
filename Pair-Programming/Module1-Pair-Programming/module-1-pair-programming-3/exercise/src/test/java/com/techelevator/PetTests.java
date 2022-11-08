package com.techelevator;

import com.techelevator.crm.Pet;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PetTests {

    @Test
    public void returnsTheElementsAsCommaDelimitedString() {
       List<String> testing = new ArrayList<>();
       Pet petTest = new Pet("Casper","Pitbull");
       petTest.setVaccinations("Rabies");
       petTest.setVaccinations("Distemper");
       petTest.setVaccinations("Parvo");

       assertEquals("\"" + "Rabies, Distemper, Parvo" + "\"", petTest.listVaccinantions());







    }
}
