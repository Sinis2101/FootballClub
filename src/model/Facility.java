package model;

public class Facility {

    private DressingRoom dressingRoomA;
    private DressingRoom dressingRoomB;
    private Manager[][] officeArea;

    public Facility(Team teamA, Team teamB) {

        dressingRoomA = new DressingRoom(7, 7, teamA);
        dressingRoomB = new DressingRoom(7, 6, teamB);
        officeArea = new Manager[6][6];

    }

    // GETTERS
    public DressingRoom getDressingRoomA() {
        return dressingRoomA;
    }
    public DressingRoom getDressingRoomB() {
        return dressingRoomB;
    }
}
