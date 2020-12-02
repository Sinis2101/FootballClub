package model;

import java.util.ArrayList;

public class Team {

    private String name;
    private MainManager manager;
    private ArrayList<AssistantManager> assistantManagers;
    private ArrayList<Player> players;
    private ArrayList<LineUp> lineups;

    public Team(String name) {

        this.name = name;

    }
}
