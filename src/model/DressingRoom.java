package model;

public class DressingRoom implements MatrixTools {

    private Player[][] layout;
    private Team team;

    public DressingRoom(int rows, int columns, Team team) {

        layout = new Player[rows][columns];
        this.team = team;

    }

    @Override
    public String showMatrix() {

        String message = "";

        for(int i = 0; i < layout.length; i++) {

            for(int j = 0; j < layout[0].length; j++) {

                message += layout[i][j] + "     ";

            }

            message += "\n";

        }

        return message;

    }

}
