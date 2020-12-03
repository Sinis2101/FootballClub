package model;

import java.util.ArrayList;

public class Team {

    private final static int MAX_ASSISTANTS = 3;
    private final static int MAX_PLAYERS = 25;

    private String name;
    private MainManager manager;
    private ArrayList<AssistantManager> assistantManagers;
    private ArrayList<Player> players;
    private ArrayList<LineUp> lineups;

    public Team(String name) {

        this.name = name;
        assistantManagers = new ArrayList<>();
        players = new ArrayList<>();
        lineups = new ArrayList<>();

    }

    public String addEmployee(Employee employee, ArrayList<Employee> noTeamEmployees) {

        if(employee instanceof MainManager) {

            if(manager == null) {

                manager = (MainManager) employee;
                noTeamEmployees.remove(employee);
                return employee.getName() + " was set as " + name + "'s Main Manager.";

            } else {

                return "The team has already a Main Manager.";

            }

        }

        if(employee instanceof AssistantManager) {

            if(assistantManagers.size() < MAX_ASSISTANTS) {

                assistantManagers.add((AssistantManager) employee);
                noTeamEmployees.remove(employee);
                return employee.getName() + " was set as " + name + "'s Assistant Manager. " + "[" + assistantManagers.size() + "/" + MAX_ASSISTANTS + "]" ;

            } else {

                return "No more Assistant Managers can be added to the team.";

            }

        }

        if(employee instanceof Player) {

            if(players.size() < MAX_PLAYERS) {

                players.add((Player) employee);
                noTeamEmployees.remove(employee);
                return employee.getName() + " was set as " + name + "'s Player. " + "[" + players.size() + "/" + MAX_PLAYERS + "]" ;

            } else {

                return "No more Players can be added to the team.";

            }

        }

        return null;

    }
    public void removeEmployee(Employee employee) {

        players.remove(employee);

    }

    // GETTERS
    public String getName() {
        return name;
    }
    public ArrayList<AssistantManager> getAssistantManagers() {
        return assistantManagers;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }

    // SETTERS
    public void setManager(MainManager manager) {
        this.manager = manager;
    }
}
