package model;

public class OfficeArea implements MatrixTools {

    private Manager[][] layout;

    public OfficeArea(int rows, int columns) {

        layout = new Manager[rows][columns];

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
