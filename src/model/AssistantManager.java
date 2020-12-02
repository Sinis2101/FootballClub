package model;

public class AssistantManager extends Manager {

    private boolean wasPlayer;
    private Expertise expertise;

    public AssistantManager(String name, String ID, int salary, int status, int experienceYears, int wasPlayer, int expertise) {

        super(name, ID, salary, status, experienceYears);

        if(wasPlayer == 1) this.wasPlayer = true; else this.wasPlayer = false;

        this.expertise = Expertise.values()[expertise-1];

    }
}
