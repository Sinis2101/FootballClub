package model;

import java.util.ArrayList;

public class Club {

    private String name;
    private String NIT;
    private String foundationDate;
    private ArrayList<Employee> roster;
    private Team teamA;
    private Team teamB;
    private Facility facility;

    public Club() {

        name = "America de Cali";
        NIT = "890.305.773-4";
        foundationDate = "13/02/1927";
        teamA = new Team("America de Cali");
        teamB = new Team("America de Cali Femenino");
        facility = new Facility(teamA, teamB);

    }
}
