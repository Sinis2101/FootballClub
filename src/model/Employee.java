package model;

public class Employee {

    private String name;
    private String ID;
    private int salary;
    private boolean status;
    private Team team;

    public Employee(String name, String ID, int salary, int status) {

        this.name = name;
        this.ID = ID;
        this.salary = salary;

        if(status == 1) this.status = true; else this.status = false;

        this.team = null;

    }

    // GETTERS
    public String getName() {
        return name;
    }
    public String getID() {
        return ID;
    }
    public Team getTeam() {
        return team;
    }

    // SETTERS
    public void setTeam(Team team) {
        this.team = team;
    }
}
