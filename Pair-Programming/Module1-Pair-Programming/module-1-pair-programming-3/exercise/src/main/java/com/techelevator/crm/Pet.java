package com.techelevator.crm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pet {
    private String name;
    private String species;
    private List<String> vaccinations = new ArrayList<>();

    public Pet(String name,String species){
        name = this.name;
        species = this.species;

    }

    public String listVaccinantions(){
        int listSize = vaccinations.size();
        String[] temp = new String[listSize];

        for(int i = 0; i < listSize; i++)
            temp[i] = vaccinations.get(i);

        String formatedString = "\"" + Arrays.toString(temp).replace("[","")
                .replace("]","") + "\"";

        return  formatedString;


    }






    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public List getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(String vaccine) {vaccinations.add(vaccine);
    }
}
