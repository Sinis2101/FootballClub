package model;

public class LineUp implements MatrixTools {

    private String date;
    private Tactic tactic;
    private String lineupInput;
    private int[][] lineup;

    public LineUp(String date, int tactic, String lineupInput) {

        this.date = date;
        this.tactic = Tactic.values()[tactic-1];
        lineup = new int[10][7];
        this.lineupInput = lineupInput;

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

    // GETTERS
    public String getDate() {
        return date;
    }
    public Tactic getTactic() {
        return tactic;
    }
    public String getLineupInput() {
        return lineupInput;
    }
}
