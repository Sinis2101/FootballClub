package model;

public class DressingRoom implements MatrixTools {

    private Player[][] layout;
    private Team team;

    public DressingRoom(int rows, int columns, Team team) {

        layout = new Player[rows][columns];
        this.team = team;

    }

    public String sitPlayer(Player player) {

        for(int i = 0; i < layout.length; i += 2) {

            for(int j = 0; j < layout[0].length; j += 2) {

                if(layout[i][j] == null) {

                    layout[i][j] = player;

                    return "A seat has been assigned for this player in the team's dressing room.";

                }

            }

        }

        return "There is no available seats for this player in the team's dressing room.";

    }

    @Override
    public String showMatrix() {

        String message = "";

        for(int i = 0; i < layout.length; i++) {

            for(int j = 0; j < layout[0].length; j++) {

                if(layout[i][j] == null) message += "[  ]" + "     ";

                if(layout[i][j] != null) {

                    if(layout[i][j].getJerseyNumber()<10) message += "[" + layout[i][j].getJerseyNumber() + "]" + "      ";

                    if(layout[i][j].getJerseyNumber()>9 && layout[i][j].getJerseyNumber()<100) message += "[" + layout[i][j].getJerseyNumber() + "]" + "     ";

                    if(layout[i][j].getJerseyNumber()>99) message += "[" + layout[i][j].getJerseyNumber() + "]" + "    ";

                }

            }

            message += "\n";

        }

        return message;

    }

    // GETTERS
    public Team getTeam() {
        return team;
    }

}
