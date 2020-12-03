package model;

import java.util.ArrayList;

public class Club {

    private String name;
    private String NIT;
    private String foundationDate;
    private ArrayList<Employee> roster;
    private ArrayList<Employee> noTeamEmployees;
    private Team teamA;
    private Team teamB;
    private Facility facility;

    public Club(boolean test) {

        if(!test) {

            name = "America de Cali";
            NIT = "890.305.773-4";
            foundationDate = "13/02/1927";
            roster = new ArrayList<>();
            noTeamEmployees = new ArrayList<>();
            teamA = new Team("America de Cali");
            teamB = new Team("America de Cali B");
            facility = new Facility(teamA, teamB);

        } else {

            name = "America de Cali";
            NIT = "890.305.773-4";
            foundationDate = "13/02/1927";
            roster = new ArrayList<>();
            noTeamEmployees = new ArrayList<>();

            // TEST EMPLOYEES
            Employee testMainManager = new MainManager("Juan Cruz Real", "66862027", 8000000, 1, 5, 5, 1);
            roster.add(testMainManager);
            noTeamEmployees.add(testMainManager);
            Employee testAssistantManager = new AssistantManager("Sergi Escobar", "63485167", 5000000, 1, 5, 1, 2);
            roster.add(testAssistantManager);
            noTeamEmployees.add(testAssistantManager);
            Employee testPlayer = new Player("Duvan Vergara", "1005891890", 10000000, 1, 10, 500, 10, 4);
            roster.add(testPlayer);
            noTeamEmployees.add(testPlayer);
            Employee testMainManager2 = new MainManager("Juan Carlos Osorio", "86862027", 9000000, 1, 8, 10, 3);
            roster.add(testMainManager2);
            noTeamEmployees.add(testMainManager2);
            Employee testAssistantManager2 = new AssistantManager("Juan Robledo", "93185167", 2000000, 1, 3, 0, 1);
            roster.add(testAssistantManager2);
            noTeamEmployees.add(testAssistantManager2);
            Employee testPlayer2 = new Player("Adrian Ramos", "2045891190", 20000000, 1, 20, 100, 8, 4);
            roster.add(testPlayer2);
            noTeamEmployees.add(testPlayer2);

            teamA = new Team("America de Cali");
            teamB = new Team("America de Cali B");
            facility = new Facility(teamA, teamB);

        }
    }

    public String hireEmployee(Employee employee) {

        roster.add(employee);
        noTeamEmployees.add(employee);

        if(employee instanceof MainManager) return employee.getName() + " with ID: (" + employee.getID() + ") was hired as a Main Manager.";
        if(employee instanceof AssistantManager) return employee.getName() + " with ID: (" + employee.getID() + ") was hired as an Assistant Manager.";
        if(employee instanceof Player) return employee.getName() + " with ID: (" + employee.getID() + ") was hired as a Player.";

        return null;

    }
    public String fireEmployee(Employee employee) {

        if(employee instanceof MainManager) employee.getTeam().setManager(null);

        if(employee instanceof AssistantManager) employee.getTeam().getAssistantManagers().remove(employee);

        if(employee instanceof Player) employee.getTeam().getPlayers().remove(employee);

        roster.remove(employee);
        noTeamEmployees.remove(employee);

        return employee.getName() + " with ID: (" + employee.getID() + ") was fired from the club.";

    }
    public String addEmployeeToTeam(Employee employee, Team team) {

        employee.setTeam(team);

        return team.addEmployee(employee, noTeamEmployees);

    }

    // GETTERS
    public ArrayList<Employee> getRoster() {
        return roster;
    }
    public ArrayList<Employee> getNoTeamEmployees() {
        return noTeamEmployees;
    }
    public Team getTeamA() {
        return teamA;
    }
    public Team getTeamB() {
        return teamB;
    }
}
