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
        System.out.println("[7] Show team data");
        System.out.println("----------------------------------------");
        System.out.println("[8] Show dressing rooms");
        System.out.println("[9] Show office area");
        System.out.println("----------------------------------------");
        System.out.println("[10] Show club data");
        System.out.println("----------------------------------------");
        System.out.println("[0] Exit");
        System.out.println("----------------------------------------");
        System.out.print("Please choose an option [0-10]: ");

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



                } else {

                    System.out.println("----------------------------------------");
                    System.out.print("There are no employees to update. Press ENTER to go back.");

                }

                break;

            case(6):

                System.out.println("----------------------------------------");
                System.out.println("           ADDING TEAM LINEUP           ");

                break;

            case(7):

                System.out.println("----------------------------------------");
                System.out.println("             SHOWING TEAMS              ");

                break;

            case(8):

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

            case(9):

                System.out.println("----------------------------------------");
                System.out.println("          SHOWING OFFICE AREA          ");
                System.out.println("----------------------------------------");
                System.out.println(club.getFacility().showMatrix());
                break;

            case(10):

                System.out.println("----------------------------------------");
                System.out.println("           SHOWING CLUB DATA            ");

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
                double averageRating = sc.nextDouble();

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
