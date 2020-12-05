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


            Employee testMainManager = new MainManager("Juan Cruz Real", "66862027", 8000000, 5, 3, 1);
            roster.add(testMainManager);
            noTeamEmployees.add(testMainManager);
            Employee testAssistantManager = new AssistantManager("Sergi Escobar", "63485167", 5000000, 9, 1, 2);
            roster.add(testAssistantManager);
            noTeamEmployees.add(testAssistantManager);
            Employee testPlayer = new Player("Duvan Vergara", "1005891890", 10000000, 11, 10, 8.7, 4);
            roster.add(testPlayer);
            noTeamEmployees.add(testPlayer);
            Employee testMainManager2 = new MainManager("Juan Carlos Osorio", "86862027", 9000000, 8, 5, 3);
            roster.add(testMainManager2);
            noTeamEmployees.add(testMainManager2);
            Employee testAssistantManager2 = new AssistantManager("Juan Robledo", "93185167", 2000000, 4, 2, 1);
            roster.add(testAssistantManager2);
            noTeamEmployees.add(testAssistantManager2);
            Employee testPlayer2 = new Player("Adrian Ramos", "2045891190", 20000000, 20, 20, 8.5, 4);
            roster.add(testPlayer2);
            noTeamEmployees.add(testPlayer2);

            teamA = new Team("America de Cali");
            teamB = new Team("America de Cali B");
            facility = new Facility(teamA, teamB);

            /**
            Employee testPlayer = new Player("Duvan Vergara", "1005891890", 10000000, 9, 10, 8.7, 4);
            roster.add(testPlayer);
            noTeamEmployees.add(testPlayer);
            Employee testPlayer2 = new Player("Duvan Vergara", "1005891890", 10000000, 11, 10, 8.7, 4);
            roster.add(testPlayer2);
            noTeamEmployees.add(testPlayer2);
            Employee testPlayer3 = new Player("Duvan Vergara", "1005891890", 10000000, 120, 10, 8.7, 4);
            roster.add(testPlayer3);
            noTeamEmployees.add(testPlayer3);
            Employee testPlayer4 = new Player("Duvan Vergara", "1005891890", 10000000, 13, 10, 8.7, 4);
            roster.add(testPlayer4);
            noTeamEmployees.add(testPlayer4);
            Employee testPlayer5 = new Player("Duvan Vergara", "1005891890", 10000000, 14, 10, 8.7, 4);
            roster.add(testPlayer5);
            noTeamEmployees.add(testPlayer5);
            Employee testPlayer6 = new Player("Duvan Vergara", "1005891890", 10000000, 15, 10, 8.7, 4);
            roster.add(testPlayer6);
            noTeamEmployees.add(testPlayer6);
            Employee testPlayer7 = new Player("Duvan Vergara", "1005891890", 10000000, 16, 10, 8.7, 4);
            roster.add(testPlayer7);
            noTeamEmployees.add(testPlayer7);
            Employee testPlayer8 = new Player("Duvan Vergara", "1005891890", 10000000, 17, 10, 8.7, 4);
            roster.add(testPlayer8);
            noTeamEmployees.add(testPlayer8);
            Employee testPlayer9 = new Player("Duvan Vergara", "1005891890", 10000000, 18, 10, 8.7, 4);
            roster.add(testPlayer9);
            noTeamEmployees.add(testPlayer9);
            Employee testPlayer10 = new Player("Duvan Vergara", "1005891890", 10000000, 19, 10, 8.7, 4);
            roster.add(testPlayer10);
            noTeamEmployees.add(testPlayer10);
            Employee testPlayer11 = new Player("Duvan Vergara", "1005891890", 10000000, 20, 10, 8.7, 4);
            roster.add(testPlayer11);
            noTeamEmployees.add(testPlayer11);
            Employee testPlayer12 = new Player("Duvan Vergara", "1005891890", 10000000, 21, 10, 8.7, 4);
            roster.add(testPlayer12);
            noTeamEmployees.add(testPlayer12);
            Employee testPlayer13 = new Player("Duvan Vergara", "1005891890", 10000000, 22, 10, 8.7, 4);
            roster.add(testPlayer13);
            noTeamEmployees.add(testPlayer13);
            Employee testPlayer14 = new Player("Duvan Vergara", "1005891890", 10000000, 23, 10, 8.7, 4);
            roster.add(testPlayer14);
            noTeamEmployees.add(testPlayer14);
            Employee testPlayer15 = new Player("Duvan Vergara", "1005891890", 10000000, 24, 10, 8.7, 4);
            roster.add(testPlayer15);
            noTeamEmployees.add(testPlayer15);
            Employee testPlayer16 = new Player("Duvan Vergara", "1005891890", 10000000, 25, 10, 8.7, 4);
            roster.add(testPlayer16);
            noTeamEmployees.add(testPlayer16);
            */

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

        if(employee.getTeam() != null) { // REMOVES PLAYER FROM TEAM

            if(employee instanceof MainManager) employee.getTeam().setManager(null);

            if(employee instanceof AssistantManager) employee.getTeam().getAssistantManagers().remove(employee);

            if(employee instanceof Player) employee.getTeam().getPlayers().remove(employee);

        }

        roster.remove(employee);
        noTeamEmployees.remove(employee);
        employee.setStatus(false);
        roster.add(roster.size(), employee);

        return employee.getName() + " with ID: (" + employee.getID() + ") was fired from the club.";

    }
    public String addEmployeeToTeam(Employee employee, Team team) {

        employee.setTeam(team);

        if(employee instanceof Player) {

            if(facility.getDressingRoomA().getTeam() == team) {

                return team.addEmployee(employee, noTeamEmployees) + "\n" + facility.getDressingRoomA().sitPlayer((Player) employee);

            }

            if(facility.getDressingRoomB().getTeam() == team) {

                return team.addEmployee(employee, noTeamEmployees) + "\n" + facility.getDressingRoomB().sitPlayer((Player) employee);

            }

        }

        if(employee instanceof Manager) {

            return team.addEmployee(employee, noTeamEmployees) + "\n" + facility.sitManager((Manager) employee);

        }

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
    public Facility getFacility() {
        return facility;
    }
}
