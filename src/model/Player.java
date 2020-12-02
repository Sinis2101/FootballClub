package model;

public class Player extends Employee {

    private int number;
    private int clubGoals;
    private double averageRating;
    private Position position;

    public Player(String name, String ID, int salary, int status, int number, int clubGoals, double averageRating, int position) {

        super(name, ID, salary, status);

        this.number = number;
        this.clubGoals = clubGoals;
        this.averageRating = averageRating;
        this.position = Position.values()[position-1];

    }
}
