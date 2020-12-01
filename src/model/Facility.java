package model;

public class Facility {

    private DressingRoom dressingRoomA;
    private DressingRoom dressingRoomB;
    private OfficeArea officeArea;

    public Facility() {

        dressingRoomA = new DressingRoom(7, 7);
        dressingRoomB = new DressingRoom(7, 6);
        officeArea = new OfficeArea(6, 6);

    }

}
