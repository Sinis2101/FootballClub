package model;

public class Facility implements MatrixTools {

    private DressingRoom dressingRoomA;
    private DressingRoom dressingRoomB;
    private Manager[][] officeArea;

    public Facility(Team teamA, Team teamB) {

        dressingRoomA = new DressingRoom(7, 7, teamA);
        dressingRoomB = new DressingRoom(7, 6, teamB);
        officeArea = new Manager[6][6];

    }

    public String sitManager(Manager manager) {

        for(int i = 0; i < officeArea.length; i += 2) {

            for(int j = 0; j < officeArea[0].length; j += 2) {

                System.out.println("[" + i + "][" + j + "]");

                if(officeArea[i][j] == null) {

                    officeArea[i][j] = manager;

                    return "An office has been assigned for this manager in the team's facility.";

                }

            }

        }

        return "There is no available office for this manager in the team's facility.";

    }

    @Override
    public String showMatrix() {

        String message = "";

        for(int i = 0; i < officeArea.length; i++) {

            for(int j = 0; j < officeArea[0].length; j++) {

                if(officeArea[i][j] == null) message += "[  ]" + "     ";

                if(officeArea[i][j] != null) {

                    message += "[" + officeArea[i][j].getName() + "]" + "      ";

                }

            }

            message += "\n";

        }

        return message;

    }

    // GETTERS
    public DressingRoom getDressingRoomA() {
        return dressingRoomA;
    }
    public DressingRoom getDressingRoomB() {
        return dressingRoomB;
    }
}
