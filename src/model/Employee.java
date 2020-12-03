package model;

public abstract class Employee {

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

    public abstract String getInfo();

    // GETTERS
    public String getName() {
        return name;
    }
    public String getID() {
        return ID;
    }
    public int getSalary() {
        return salary;
    }
    public String getStatus() {
        if(status) return "Active"; else return "Inactive";
    }
    public Team getTeam() {
        return team;
    }
    public String getTeamName() {

        if(team == null) return "N/A"; else return team.getName();

    }

    // SETTERS
    public void setTeam(Team team) {
        this.team = team;
    }
}
