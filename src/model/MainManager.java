package model;

public class MainManager extends Manager {

    private int managedTeams;
    private int championshipsWon;


    public MainManager(String name, String ID, int salary, int status, int experienceYears, int managedTeams, int championshipsWon) {

        super(name, ID, salary, status, experienceYears);

        this.managedTeams = managedTeams;
        this.championshipsWon = championshipsWon;

    }

    @Override
    public String getInfo() {

        return  "Name: " + getName() + "\n" +
                "ID: " + getID() + "\n" +
                "Salary: " + getSalary() + "\n" +
                "Status: " + getStatus() + "\n" +
                "Team: " + getTeamName() + "\n" +
                "----------------------------------------" + "\n" +
                "Experience Years: " + getExperienceYears() + "\n" +
                "----------------------------------------" + "\n" +
                "Managed Teams: " + managedTeams + "\n" +
                "Championships Won: " + championshipsWon;

    }

}
