package com.techelevator;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    public static List<Department> departments = new ArrayList();
    public static List<Employee> employees = new ArrayList();
    public static List<Employee> deptMarketing = new ArrayList();
    public static List<Employee> deptSales = new ArrayList();
    public static List<Employee> deptEngineering = new ArrayList();
    public static Map<String, Project> projects = new HashMap();

    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {

        // create departments
        createDepartments();

        // print each department
        printDepartments();

        // create employees
        createEmployees();

        // Angie gets a 10% raise

        // Assign departmental list
        assignDepartmentToList();

        // print employees
        printEmployees();

        // create the TEams project
        createTeamsProject();

        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the number of employees on the project
        printProjectsReport();


    }

    /**
     * Create departments and add them to the collection of departments
     */
    private static void createDepartments() {

        Department depMarketing = new Department (1, "Marketing");
        departments.add(depMarketing);

        Department depSales = new Department(2, "Sales");
        departments.add(depSales);

        Department depEngineering = new Department(3, "Engineering");
        departments.add(depEngineering);

    }

    /**
     * Print out each department in the collection.
     */
    private static void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");

        for(Department loopy : departments) {
            System.out.println(loopy.getName());
        }
    }

    /**
     * Create employees and add them to the collection of employees
     */
    private static void createEmployees() {

        //Creating the three employees and storing their info
        Employee employee1 = new Employee (0, "Dean", "Johnson", "djohnson@teams.com",60000, departments.get(2), "08/21/2020");
        employees.add(employee1);

        Employee employee2 = new Employee (2, "Angie", "Smith", "asmith@teams.com",60000, departments.get(2), "08/21/2020");
        employees.add(employee2);

        Employee employee3 = new Employee (3, "Margaret", "Thompson", "mthompson@teams.com", 60000, departments.get(0), "08/21/2020");
        employees.add(employee3);


        //Angie gets a raise

        employee2.setSalary(employee2.raiseSalary(.10));

    }

    private static void assignDepartmentToList() {

        for(Employee loop : employees) {
            if (loop.getDepartment().getName() == "Marketing") {
                deptMarketing.add(loop);
            }
            if (loop.getDepartment().getName() == "Engineering") {
                deptEngineering.add(loop);
            }
            if (loop.getDepartment().getName() == "Sales") {
                deptSales.add(loop);
            }

        }
    }


    private static void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        for(Employee loopy : employees) {
            System.out.println(loopy.getFullName() +
                    " (" + currency.format(loopy.getSalary()) + ") " + loopy.getDepartment().getName());
        }
    }

    /**
     * Create the 'TEams' project.
     */
    private static void createTeamsProject() {

        Project teams = new Project ("TEams", "Project Management Software", "10/10/2020", "10/17/2020");

        teams.setTeamMembers(deptEngineering);

        projects.put("TEams", teams);
    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private static void createLandingPageProject() {

        Project marketing = new Project ("Marketing Landing Page", "Lead Capture Landing Page for Marketing", "10/10/2020", "10/17/2020");

        marketing.setTeamMembers(deptMarketing);

        projects.put("Marketing Landing Page", marketing);

    }

    /**
     * Print out each project in the collection.
     */
    private static void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");

        for (Map.Entry<String, Project> loopy : projects.entrySet()) {
            System.out.println(loopy.getKey() + ": " + loopy.getValue().getTeamMembers().size());

        }



    }

}