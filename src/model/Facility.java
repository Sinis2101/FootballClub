package model;

public class Facility {

    private DressingRoom dressingRoomA;
    private DressingRoom dressingRoomB;
    private OfficeArea officeArea;

    public Facility(Team teamA, Team teamB) {

        dressingRoomA = new DressingRoom(7, 7, teamA);
        dressingRoomB = new DressingRoom(7, 6, teamB);
        officeArea = new OfficeArea(6, 6);

    }
}
