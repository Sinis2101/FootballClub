package model;

public class Manager extends Employee {

    private int experienceYears;

    public Manager(String name, String ID, int salary, int status, int experienceYears) {

        super(name, ID, salary, status);

        this.experienceYears = experienceYears;

    }
}
