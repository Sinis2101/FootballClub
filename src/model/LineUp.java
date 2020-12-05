package model;

public class LineUp implements MatrixTools {

    private String date;
    private Tactic tactic;
    private int[][] lineup;

    public LineUp(String date, int tactic) {



    }

    @Override
    public String showMatrix() {

        String message = "";

        for(int i = 0; i < lineup.length; i++) {

            for(int j = 0; j < lineup[0].length; j++) {

                message += lineup[i][j] + "     ";

            }

            message += "\n";

        }

        return message;

    }

}
