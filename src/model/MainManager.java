package model;

public class MainManager extends Manager {

    private int managedTeams;
    private int championshipsWon;


    public MainManager(String name, String ID, int salary, int status, int experienceYears, int managedTeams, int championshipsWon) {

        super(name, ID, salary, status, experienceYears);

        this.managedTeams = managedTeams;
        this.championshipsWon = championshipsWon;

    }
}
