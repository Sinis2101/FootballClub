package model;

public abstract class Manager extends Employee {

    private int experienceYears;

    public Manager(String name, String ID, int salary, int experienceYears) {

        super(name, ID, salary);

        this.experienceYears = experienceYears;

    }

    public abstract String getInfo();

    // GETTERS
    public int getExperienceYears() {
        return experienceYears;
    }
}
