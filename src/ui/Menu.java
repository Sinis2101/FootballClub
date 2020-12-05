package ui;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import model.*;

import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    Club club = new Club(true);

    private static final int EXIT = 0;

    public void start() {

        int choice;

        do {

            showMenu();
            choice = getChoice();
            if(choice != EXIT) System.out.println("\n"+"\n"+"\n");
            doChoice(choice);
            if(choice != EXIT) sc.nextLine();
            if(choice != EXIT) System.out.println("\n"+"\n"+"\n");

        } while (choice != EXIT);

    }
    public void showMenu() {

        System.out.println("----------------------------------------");
        System.out.println("             FOOTBALL CLUB              ");
        System.out.println("----------------------------------------");
        System.out.println("[1] Hire employee");
        System.out.println("[2] Fire employee");
        System.out.println("[3] Add employee to a team");
        System.out.println("[4] Show employee data");
        System.out.println("[5] Update employee data");
        System.out.println("----------------------------------------");
        System.out.println("[6] Add line up to a team");
        System.out.println("[7] Show team lineups");
        System.out.println("[8] Show team data");
        System.out.println("----------------------------------------");
        System.out.println("[9] Show dressing rooms");
        System.out.println("[10] Show office area");
        System.out.println("----------------------------------------");
        System.out.println("[11] Show club data");
        System.out.println("----------------------------------------");
        System.out.println("[0] Exit");
        System.out.println("----------------------------------------");
        System.out.print("Please choose an option [0-11]: ");

    }
    public int getChoice() {

        int choice = sc.nextInt();
        sc.nextLine();

        return choice;

    }
    public void doChoice(int choice) {

        switch(choice) {

            case(1):

                System.out.println("----------------------------------------");
                System.out.println("            HIRING EMPLOYEE             ");

                int type = 0;

                do {

                    System.out.println("----------------------------------------");
                    System.out.println("[1] Add Main Manager");
                    System.out.println("[2] Add Assistant Manager");
                    System.out.println("[3] Add Player");
                    System.out.println("----------------------------------------");
                    System.out.print("Please choose the type of employee [1-3]: ");
                    type = sc.nextInt(); sc.nextLine();

                } while(type < 1 || type >3);

                System.out.println("----------------------------------------");
                Employee newEmployee = registerEmployee(type);
                System.out.println("----------------------------------------");
                System.out.print(club.hireEmployee(newEmployee));

                break;

            case(2):

                System.out.println("----------------------------------------");
                System.out.println("            FIRING EMPLOYEE             ");

                if(!club.getRoster().isEmpty()){

                    Employee employee = null;
                    do {

                        employee = chooseEmployee("Please choose an employee to fire");

                    } while (employee == null);
                    System.out.println("----------------------------------------");
                    System.out.print(club.fireEmployee(employee));

                } else {

                    System.out.println("----------------------------------------");
                    System.out.print("There are no employees to choose from. Press ENTER to go back.");

                }

                break;

            case(3):

                System.out.println("----------------------------------------");
                System.out.println("         ADD EMPLOYEE TO A TEAM         ");

                if(!club.getNoTeamEmployees().isEmpty()) {

                    Employee employee = null;

                    do {

                        employee = chooseNoTeamEmployee("Please choose an employee to add to a team");

                    } while (employee == null);

                    Team team = null;

                    do {

                        team = chooseTeam("Please choose a team to add the employee to");

                    } while (team == null);

                    System.out.println("----------------------------------------");
                    System.out.print(club.addEmployeeToTeam(employee, team));

                } else {

                    System.out.println("----------------------------------------");
                    System.out.print("All employees already have a team. Press ENTER to go back.");

                }

                break;

            case(4):

                System.out.println("----------------------------------------");
                System.out.println("           SHOWING EMPLOYEES            ");

                    if(!club.getRoster().isEmpty()) {

                        int mainManagers = 0;
                        int assistantManagers = 0;
                        int players = 0;

                        for(Employee employee : club.getRoster()) {

                            if(employee instanceof MainManager && employee.getStatus()) {

                                mainManagers ++;

                                System.out.println("----------------------------------------");
                                System.out.println("            MAIN MANAGER " + mainManagers + "             ");
                                System.out.println("----------------------------------------");
                                System.out.println(employee.getInfo());

                            }

                        }

                        for(Employee employee : club.getRoster()) {

                            if(employee instanceof AssistantManager && employee.getStatus()) {

                                assistantManagers ++;

                                System.out.println("----------------------------------------");
                                System.out.println("         ASSISTANT MANAGER " + assistantManagers + "           ");
                                System.out.println("----------------------------------------");
                                System.out.println(employee.getInfo());

                            }

                        }

                        for(Employee employee : club.getRoster()) {

                            if(employee instanceof Player && employee.getStatus()) {

                                players ++;

                                System.out.println("----------------------------------------");
                                System.out.println("               PLAYER " + players + "                ");
                                System.out.println("----------------------------------------");
                                System.out.println(employee.getInfo());

                            }

                        }

                        System.out.println("----------------------------------------");
                        System.out.print("All employees have been showed. Press ENTER to continue.");

                    } else {

                        System.out.println("----------------------------------------");
                        System.out.print("There are no employees to show. Press ENTER to go back.");

                    }

                break;

            case(5):

                System.out.println("----------------------------------------");
                System.out.println("           UPDATING EMPLOYEE            ");

                if(!club.getRoster().isEmpty()) {

                    Employee employee = null;

                    do {

                        employee = chooseEmployee("Please choose an employee to update");

                    } while (employee == null);

                    System.out.println("----------------------------------------");
                    System.out.println("[1] Salary");

                    if(employee instanceof Manager) {

                        System.out.println("[2] Experience Years");

                        if(employee instanceof AssistantManager) {

                            System.out.println("[3] Expertise");

                            System.out.println("----------------------------------------");
                            System.out.print("Please choose the data to update [1-3]: ");
                            choice = sc.nextInt(); sc.nextLine();

                            switch (choice) {

                                case(1):

                                    System.out.println("----------------------------------------");
                                    System.out.print("New Salary " + "(Currently: " + ((AssistantManager) employee).getSalary() + "): ");
                                    int salary = sc.nextInt(); sc.nextLine();
                                    employee.setSalary(salary);

                                    break;

                                case(2):

                                    System.out.println("----------------------------------------");
                                    System.out.print("Updated Experience Years " + "(Currently: " + ((AssistantManager) employee).getExperienceYears() + "): ");
                                    int experienceYears = sc.nextInt(); sc.nextLine();
                                    ((AssistantManager) employee).setExperienceYears(experienceYears);

                                    break;

                                case(3):

                                    System.out.println("----------- CHOOSE EXPERTISE -----------");
                                    for(int i = 0; i < Expertise.values().length; i++) {

                                        System.out.println("[" + (i+1) + "] " + Expertise.values()[i].name());

                                    }
                                    System.out.println("----------------------------------------");
                                    System.out.print("Change expertise [1-4] " + "(Currently: " + ((AssistantManager) employee).getExpertise().name() + "): ");
                                    int expertise = sc.nextInt(); sc.nextLine();

                                    ((AssistantManager) employee).setExpertise(expertise);

                                    break;

                            }

                        } else {

                            System.out.println("[3] Managed Teams");
                            System.out.println("[4] Championships Won");

                            System.out.println("----------------------------------------");
                            System.out.print("Please choose the data to update [1-4]: ");
                            choice = sc.nextInt(); sc.nextLine();

                            switch (choice) {

                                case(1):

                                    System.out.println("----------------------------------------");
                                    System.out.print("New Salary " + "(Currently: " + ((MainManager) employee).getSalary() + "): ");
                                    int salary = sc.nextInt(); sc.nextLine();
                                    employee.setSalary(salary);

                                    break;

                                case(2):

                                    System.out.println("----------------------------------------");
                                    System.out.print("Updated Experience Years " + "(Currently: " + ((MainManager) employee).getExperienceYears() + "): ");
                                    int experienceYears = sc.nextInt(); sc.nextLine();
                                    ((MainManager) employee).setExperienceYears(experienceYears);

                                    break;

                                case(3):

                                    System.out.println("----------------------------------------");
                                    System.out.print("Updated Managed Teams " + "(Currently: " + ((MainManager) employee).getManagedTeams() + "): ");
                                    int managedTeams = sc.nextInt(); sc.nextLine();
                                    ((MainManager) employee).setManagedTeams(managedTeams);

                                    break;

                                case(4):

                                    System.out.println("----------------------------------------");
                                    System.out.print("Updated Championships Won " + "(Currently: " + ((MainManager) employee).getChampionshipsWon() + "): ");
                                    int championshipsWon = sc.nextInt(); sc.nextLine();
                                    ((MainManager) employee).setChampionshipsWon(championshipsWon);

                                    break;

                            }

                        }

                    } else {

                        System.out.println("[2] Jersey Number");
                        System.out.println("[3] Club Goals");
                        System.out.println("[4] Average Rating");
                        System.out.println("[5] Position");

                        System.out.println("----------------------------------------");
                        System.out.print("Please choose the data to update [1-5]: ");
                        choice = sc.nextInt(); sc.nextLine();

                        switch (choice) {

                            case(1):

                                System.out.println("----------------------------------------");
                                System.out.print("New Salary " + "(Currently: " + employee.getSalary() + "): " );
                                int salary = sc.nextInt(); sc.nextLine();
                                employee.setSalary(salary);

                                break;

                            case(2):

                                System.out.println("----------------------------------------");
                                System.out.print("New Jersey Number " + "(Currently: " + ((Player) employee).getJerseyNumber() + "): ");
                                int jerseyNumber = sc.nextInt(); sc.nextLine();
                                ((Player) employee).setJerseyNumber(jerseyNumber);

                                break;

                            case(3):

                                System.out.println("----------------------------------------");
                                System.out.print("Updated Club Goals " + "(Currently: " + ((Player) employee).getClubGoals() + "): ");
                                int clubGoals = sc.nextInt(); sc.nextLine();
                                ((Player) employee).setClubGoals(clubGoals);

                                break;

                            case(4):

                                System.out.println("----------------------------------------");
                                System.out.print("New Average Rating [0,0 - 10,0] " + "(Currently: " + ((Player) employee).getAverageRating() + "): ");
                                double averageRating = sc.nextDouble(); sc.nextLine();
                                ((Player) employee).setAverageRating(averageRating);

                                break;

                            case(5):

                                System.out.println("------------ CHOOSE POSITION -----------");
                                for(int i = 0; i < Position.values().length; i++) {

                                    System.out.println("[" + (i+1) + "] " + Position.values()[i].name());

                                }
                                System.out.println("----------------------------------------");
                                System.out.print("Change position [1-4] " + "(Currently: " + ((Player) employee).getPosition().name() + "): ");
                                int position = sc.nextInt(); sc.nextLine();

                                ((Player) employee).setPosition(position);

                                break;

                        }

                    }

                    System.out.println("----------------------------------------");
                    System.out.print("Employee data updated. Press ENTER to continue.");


                } else {

                    System.out.println("----------------------------------------");
                    System.out.print("There are no employees to update. Press ENTER to go back.");

                }

                break;

            case(6):

                System.out.println("----------------------------------------");
                System.out.println("           ADDING TEAM LINEUP           ");

                Team team = chooseTeam("Please choose a team to add the lineup to");
                System.out.println("----------------------------------------");

                LineUp lineUp = registerLineup();

                System.out.println("----------------------------------------");

                if(team == club.getTeamA()) {

                    System.out.print(club.getTeamA().addLineup(lineUp));

                } else {

                    System.out.print(club.getTeamB().addLineup(lineUp));

                }

                break;

            case(7):

                System.out.println("----------------------------------------");
                System.out.println("            SHOWING LINEUPS             ");

                Team teamChoice = chooseTeam("Please choose a team to show its lineups");

                if(teamChoice == club.getTeamA()) {

                    for(LineUp lineup : club.getTeamA().getLineups()) {

                        System.out.println("----------------------------------------");
                        System.out.println("               LINEUP " + ((club.getTeamA().getLineups().indexOf(lineup))+1) + "                ");
                        System.out.println("----------------------------------------");
                        System.out.println("Date: " + lineup.getDate());
                        System.out.println("Tactic: " + lineup.getTactic().name());
                        System.out.println("Lineup: " + lineup.getLineupInput());
                        System.out.println("----------------------------------------");
                        System.out.println(lineup.showMatrix());
                        System.out.print("\n"+"\n"+"\n");

                    }

                } else {

                    for(LineUp lineup : club.getTeamB().getLineups()) {

                        System.out.println(lineup.showMatrix());

                    }

                }

                break;

            case(8):

                System.out.println("----------------------------------------");
                System.out.println("             SHOWING TEAMS              ");
                System.out.println("----------------------------------------");
                System.out.println("                 TEAM A                 ");
                System.out.println("----------------------------------------");
                System.out.println(club.getTeamA().getInfo());
                System.out.println("----------------------------------------");
                System.out.println("                 TEAM B                 ");
                System.out.println("----------------------------------------");
                System.out.println(club.getTeamB().getInfo());
                System.out.println("----------------------------------------");
                System.out.print("All team data has been showed. Press ENTER to continue.");

                break;

            case(9):

                System.out.println("----------------------------------------");
                System.out.println("         SHOWING DRESSING ROOMS         ");
                System.out.println("----------------------------------------");
                System.out.println("             DRESSING ROOM A            ");
                System.out.println("----------------------------------------");
                System.out.println(club.getFacility().getDressingRoomA().showMatrix());

                System.out.println("\n"+"\n"+"\n");

                System.out.println("----------------------------------------");
                System.out.println("             DRESSING ROOM B            ");
                System.out.println("----------------------------------------");
                System.out.println(club.getFacility().getDressingRoomB().showMatrix());

                break;

            case(10):

                System.out.println("----------------------------------------");
                System.out.println("          SHOWING OFFICE AREA          ");
                System.out.println("----------------------------------------");
                System.out.println(club.getFacility().showMatrix());
                break;

            case(11):

                System.out.println("----------------------------------------");
                System.out.println("           SHOWING CLUB DATA            ");
                System.out.println("----------------------------------------");
                System.out.println(club.getInfo());
                System.out.println("----------------------------------------");
                System.out.print("All club data has been showed. Press ENTER to continue.");

                break;

            case(EXIT):

                break;

            default:

                System.out.println("----------------------------------------");
                System.out.print("Please choose a valid option. Press ENTER to try again.");

        }

    }

    public Employee registerEmployee(int type) {

        System.out.print("Name: " );
        String name = sc.nextLine();

        System.out.print("ID: " );
        String ID = sc.nextLine();

        System.out.print("Salary: " );
        int salary = sc.nextInt(); sc.nextLine();

        switch(type) {

            case(1): // MAIN MANAGER

                System.out.print("Experience Years: " );
                int experienceYears = sc.nextInt(); sc.nextLine();

                System.out.print("Managed Teams: " );
                int managedTeams = sc.nextInt(); sc.nextLine();

                System.out.print("Championships Won: " );
                int championshipsWon = sc.nextInt(); sc.nextLine();

                return new MainManager(name, ID, salary, experienceYears, managedTeams, championshipsWon);

            case(2): // ASSISTANT MANAGER

                System.out.print("Experience Years: " );
                experienceYears = sc.nextInt(); sc.nextLine();

                System.out.println("------------ CHOOSE HISTORY ------------");
                System.out.println("[1] Was a player");
                System.out.println("[2] Was not a player");
                System.out.println("----------------------------------------");
                System.out.print("Please choose manager history [1-2]: ");
                int wasPlayer = sc.nextInt(); sc.nextLine();

                System.out.println("----------- CHOOSE EXPERTISE -----------");
                for(int i = 0; i < Expertise.values().length; i++) {

                    System.out.println("[" + (i+1) + "] " + Expertise.values()[i].name());

                }
                System.out.println("----------------------------------------");
                System.out.print("Please choose manager expertise [1-4]: ");
                int expertise = sc.nextInt(); sc.nextLine();

                return new AssistantManager(name, ID, salary, experienceYears, wasPlayer, expertise);

            case(3): // PLAYER

                System.out.print("Number: " );
                int number = sc.nextInt(); sc.nextLine();

                System.out.print("Club Goals: " );
                int clubGoals = sc.nextInt(); sc.nextLine();

                System.out.print("Average Rating [0,0 - 10,0]: " );
                double averageRating = sc.nextDouble(); sc.nextLine();

                System.out.println("------------ CHOOSE POSITION -----------");
                for(int i = 0; i < Position.values().length; i++) {

                    System.out.println("[" + (i+1) + "] " + Position.values()[i].name());

                }
                System.out.println("----------------------------------------");
                System.out.print("Please choose player position [1-4]: ");
                int position = sc.nextInt(); sc.nextLine();

                return new Player(name, ID, salary, number, clubGoals, averageRating, position);

        }

        return null;

    }
    public Employee chooseEmployee(String message) {

        System.out.println("----------------------------------------");

        int employee = 0;

        for (Employee i : club.getRoster()) {

            if(i.getStatus()) {

                employee ++;

                if(i.getTeam() == null) {

                    System.out.println("[" + (club.getRoster().indexOf(i)+1) + "] " + i.getName() + " (" + i.getClass().getSimpleName() + ")");

                } else {

                    System.out.println("[" + (club.getRoster().indexOf(i)+1) + "] " + i.getName() + " (" + i.getTeamName() + "'s " + i.getClass().getSimpleName() + ")");

                }

            }

        }

        System.out.println("----------------------------------------");
        System.out.print(message + " [1-" + employee + "]: ");
        int userChoice = sc.nextInt(); sc.nextLine();

        if(userChoice > employee || userChoice < 1) return null; else return club.getRoster().get(userChoice-1);

    }
    public Employee chooseNoTeamEmployee(String message) {

        System.out.println("----------------------------------------");

        for (Employee i : club.getNoTeamEmployees()) {

            System.out.println("[" + (club.getNoTeamEmployees().indexOf(i)+1) + "] " + i.getName() + " (" + i.getClass().getSimpleName() + ")");

        }

        System.out.println("----------------------------------------");
        System.out.print(message + " [1-" + club.getNoTeamEmployees().size() + "]: ");
        int userChoice = sc.nextInt(); sc.nextLine();

        if(userChoice > club.getNoTeamEmployees().size() || userChoice < 1) return null; else return club.getNoTeamEmployees().get(userChoice-1);

    }

    public LineUp registerLineup() {

        System.out.print("Date [dd/mm/aa]: ");
        String date = sc.nextLine();

        System.out.println("------------- CHOOSE TACTIC ------------");
        for(int i = 0; i < Tactic.values().length; i++) {

            System.out.println("[" + (i+1) + "] " + Tactic.values()[i].name());

        }
        System.out.println("----------------------------------------");
        System.out.print("Please choose lineup tactic [1-4]: ");
        int tactic = sc.nextInt(); sc.nextLine();

        System.out.println("----------------------------------------");
        System.out.print("Lineup [e.g. 4-4-2]: ");
        String lineupInput = sc.nextLine();

        return new LineUp(date, tactic, lineupInput);

    }

    public Team chooseTeam(String message) {

        System.out.println("----------------------------------------");
        System.out.println("[1] " + club.getTeamA().getName());
        System.out.println("[2] " + club.getTeamB().getName());
        System.out.println("----------------------------------------");
        System.out.print(message + " [1-2]: ");
        int userChoice = sc.nextInt(); sc.nextLine();

        if(userChoice == 1) {

            return club.getTeamA();

        } else if (userChoice == 2) {

            return club.getTeamB();

        } else return null;

    }

}
