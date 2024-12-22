import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to our parking management application!");
        MAIN_LOOP : while(true){ // giving the loop a name to avoid break issues within the switch statement
            displayMenuOptions();

            choice = sc.nextInt();

            switch (choice){
                case 0:
                    System.out.println("See you next time \uD83D\uDE01. Goodbye!");
                    break MAIN_LOOP; // break the while loop
                case 1 :
                    System.out.println("You've choose to park a vehicule.");
                    break;
                case 2:
                    System.out.println("You've choose to remove a vehicule.");
                    break;
                case 3:
                    System.out.println("You've choose to display parked vehicules.");
                    break;
                default:
                    System.out.println("Sorry! this option isn't available.");
                    break;
            }
        }
    }

    private static void displayMenuOptions(){
        System.out.println("""
                -----------------------------------------------------------
                Choose by number :
                0. To quit
                1. Park a vehicule
                2. Remove a car from parking
                3. Display parking
                -----------------------------------------------------------
                """);
    }
}