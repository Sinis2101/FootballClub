package model;

public class AssistantManager extends Manager {

    private boolean wasPlayer;
    private Expertise expertise;

    public AssistantManager(String name, String ID, int salary, int experienceYears, int wasPlayer, int expertise) {

        super(name, ID, salary, experienceYears);

        if(wasPlayer == 1) this.wasPlayer = true; else this.wasPlayer = false;

        this.expertise = Expertise.values()[expertise-1];

    }

    @Override
    public String getInfo() {

        return  "Name: " + getName() + "\n" +
                "ID: " + getID() + "\n" +
                "Salary: " + getSalary() + "\n" +
                "Status: " + getStatusText() + "\n" +
                "Team: " + getTeamName() + "\n" +
                "----------------------------------------" + "\n" +
                "Experience Years: " + getExperienceYears() + "\n" +
                "----------------------------------------" + "\n" +
                "Was a player: " + getWasPlayer() + "\n" +
                "Expertise: " + expertise.name();

    }

    // GETTERS
    public String getWasPlayer() {
        if(wasPlayer) return "Yes"; else return "No";
    }
    public Expertise getExpertise() {
        return expertise;
    }

    // SETTERS
    public void setExpertise(int expertise) {
        this.expertise = Expertise.values()[expertise-1];
    }
}
