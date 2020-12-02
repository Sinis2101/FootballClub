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
        roster = new ArrayList<>();
        teamA = new Team("America de Cali");
        teamB = new Team("America de Cali Femenino");
        facility = new Facility(teamA, teamB);

    }

    public String hireEmployee(Employee newEmployee) {

        roster.add(newEmployee);

        if(newEmployee instanceof MainManager) return newEmployee.getName() + " with ID: (" + newEmployee.getID() + ") was hired as a Main Manager.";
        if(newEmployee instanceof AssistantManager) return newEmployee.getName() + " with ID: (" + newEmployee.getID() + ") was hired as an Assistant Manager.";
        if(newEmployee instanceof Player) return newEmployee.getName() + " with ID: (" + newEmployee.getID() + ") was hired as a Player.";

        return null;

    }
    public String fireEmployee(Employee employee) {

        roster.remove(employee);

        return employee.getName() + " with ID: (" + employee.getID() + ") was fired from the club.";

    }

    // GETTERS
    public ArrayList<Employee> getRoster() {
        return roster;
    }
}
