package ui;

import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);

    private static final int EXIT = 0;

    public void start() {

        int choice;

        do {

            showMenu();
            choice = getChoice();
            doChoice(choice);
            if(choice != EXIT) sc.nextLine();

        } while (choice != EXIT);

    }
    public void showMenu() {

        System.out.println("----------------------------------------");
        System.out.println("             FOOTBALL CLUB              ");
        System.out.println("----------------------------------------");
        System.out.println("[1] Option");
        System.out.println("----------------------------------------");
        System.out.println("[0] Exit");
        System.out.println("----------------------------------------");
        System.out.print("Please choose an option [0-1]: ");

    }
    public int getChoice() {

        int choice = sc.nextInt();
        sc.nextLine();

        return choice;

    }
    public void doChoice(int choice) {

        switch(choice) {

            case(1): // OPTION 1

                System.out.println("----------------------------------------");
                System.out.println("              OPTION NAME               ");
                System.out.println("----------------------------------------");
                // PROCESS
                System.out.println("----------------------------------------");
                System.out.print(""); // RETURNS

                break;

            case(EXIT):

                break;

            default:

                System.out.println("----------------------------------------");
                System.out.print("Please choose a valid option. Press ENTER to try again.");

        }

    }

}
