package model;

public abstract class Employee {

    private String name;
    private String ID;
    private int salary;
    private boolean status;
    private Team team;

    public Employee(String name, String ID, int salary) {

        this.name = name;
        this.ID = ID;
        this.salary = salary;
        status = true;
        team = null;

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
    public boolean getStatus() {
        return status;
    }
    public String getStatusText() {
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
    public void setStatus(boolean status) {
        this.status = status;
    }
}
