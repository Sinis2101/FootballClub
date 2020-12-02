package model;

public class Employee {

    private String name;
    private String ID;
    private int salary;
    private boolean status;

    public Employee(String name, String ID, int salary, int status) {

        this.name = name;
        this.ID = ID;
        this.salary = salary;

        if(status == 1) this.status = true; else this.status = false;

    }

    // GETTERS
    public String getName() {
        return name;
    }
    public String getID() {
        return ID;
    }
}
