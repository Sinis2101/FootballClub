package model;

public class Player extends Employee {

    private int jerseyNumber;
    private int clubGoals;
    private double averageRating;
    private Position position;

    public Player(String name, String ID, int salary, int jerseyNumber, int clubGoals, double averageRating, int position) {

        super(name, ID, salary);

        this.jerseyNumber = jerseyNumber;
        this.clubGoals = clubGoals;
        this.averageRating = averageRating;
        this.position = Position.values()[position-1];

    }

    @Override
    public String getInfo() {

        return  "Name: " + getName() + "\n" +
                "ID: " + getID() + "\n" +
                "Salary: " + getSalary() + "\n" +
                "Status: " + getStatusText() + "\n" +
                "Team: " + getTeamName() + "\n" +
                "----------------------------------------" + "\n" +
                "Jersey Number: " + jerseyNumber + "\n" +
                "Club Goals: " + clubGoals + "\n" +
                "Average Rating: " + averageRating + "\n" +
                "Position: " + position.name();

    }

    // GETTERS
    public int getJerseyNumber() {
        return jerseyNumber;
    }
    public int getClubGoals() {
        return clubGoals;
    }
    public double getAverageRating() {
        return averageRating;
    }
    public Position getPosition() {
        return position;
    }

    // SETTERS
    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }
    public void setClubGoals(int clubGoals) {
        this.clubGoals = clubGoals;
    }
    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
    public void setPosition(int position) {
        this.position = Position.values()[position-1];
    }
}
