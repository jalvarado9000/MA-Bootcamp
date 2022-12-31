package com.techelevator;

public class Employee {



    private int employeeid;
    private String firstName;
    private String lastName;
    private String fullName;
    private String department;
    private double annualSalary;

    //constructor


    public Employee(int employeeid, String firstName, String lastName, double annualSalary) {
        this.employeeid = employeeid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
    }

    //Setter
    public void setDepartment(String department) {this.department = department;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    //Getters
    public int getEmployeeId() {return employeeid;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getFullName() {return getLastName() + ", " + getFirstName();}
    public String getDepartment() {return department;}
    public double getAnnualSalary() {return annualSalary;}

    public void raiseSalary(double percent){
        annualSalary = (annualSalary*percent/100) + annualSalary ;
    }








}
