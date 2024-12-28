import java.util.*;

import factories.*;
import vehicules.Vehicule;
import vehicules.VehiculeTypes;
import exceptions.VehiculeNotFound;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to our parking management application!");
        MAIN_LOOP : while(true){ // giving the loop a name to avoid break issues within the switch statement
            displayMenuOptions();

            try {
                choice = sc.nextInt();

                switch (choice){
                    case 0:
                        System.out.println("See you next time \uD83D\uDE01. Goodbye!");
                        break MAIN_LOOP; // break the while loop
                    case 1 :
                        System.out.println("You've choose to park a vehicule.");
                        Vehicule vehicule = null;
                        System.out.println("""
                            Choose vehicul's type by number :
                            1. Car
                            2. Moto
                            3. Truck""");
                        int vehiculeType = sc.nextInt();
                        String[] vehiculeInformations;

                        switch (vehiculeType){
                            case 1:
                                System.out.println("Please enter informations as the following format : {MATRICULE}_{NUMBER OF DOORS}");
                                 vehiculeInformations = sc.next()
                                        .split("_");

                                try {
                                    if (vehiculeInformations.length == 2) {
                                        vehicule = VehiculeFactory.createVehicule(VehiculeTypes.VOITURE, vehiculeInformations[0], Integer.parseInt(vehiculeInformations[1]));
                                    } else if (vehiculeInformations.length == 1) {
                                        vehicule = VehiculeFactory.createVehicule(VehiculeTypes.VOITURE, vehiculeInformations[0]);
                                    }
                                    Parking.ajouterVehicule(vehicule);
                                    System.out.println("Car parked successfully!");
                                    System.out.println("Free places : " + Parking.placesDisponibles());
                                } catch (NumberFormatException e) {
                                    System.out.println("The second parameter must be an integer");
                                }
                                break;
                            case 2:
                                System.out.println("Please enter informations as the following format : {MATRICULE}_{CYLINDRE}");
                                vehiculeInformations = sc.next()
                                        .split("_");

                                if(vehiculeInformations.length == 1){
                                    vehicule = VehiculeFactory.createVehicule(VehiculeTypes.MOTO,vehiculeInformations[0]);
                                } else if (vehiculeInformations.length == 2) {
                                    vehicule = VehiculeFactory.createVehicule(VehiculeTypes.MOTO, vehiculeInformations[0], vehiculeInformations[1]);
                                }
                                Parking.ajouterVehicule(vehicule);
                                System.out.println("Moto parked successfully!");
                                System.out.println("Free places : " + Parking.placesDisponibles());
                                break;
                            case 3:
                                System.out.println("Please enter informations as the following format : {MATRICULE}_{CHARGE CAPACITY}");
                                vehiculeInformations = sc.next()
                                        .split("_");

                                try{
                                    if(vehiculeInformations.length == 1){
                                        vehicule = VehiculeFactory.createVehicule(VehiculeTypes.CAMION, vehiculeInformations[0]);
                                    } else if(vehiculeInformations.length == 2){
                                        vehicule = VehiculeFactory.createVehicule(VehiculeTypes.CAMION, vehiculeInformations[0], vehiculeInformations[1]);
                                    }
                                    Parking.ajouterVehicule(vehicule);
                                    System.out.println("Truck parked successfully!");
                                    System.out.println("Free places : " + Parking.placesDisponibles());
                                } catch (ClassCastException e) {
                                    System.out.println("The second parameter must be an integer");
                                }

                                break;
                            default:
                                System.out.println("Sorry the number provided isn't available!");
                        }

                        break;
                    case 2:
                        System.out.println("You've choose to remove a vehicle.");
                        System.out.println("Please enter MATRICULE of the vehicle");
                        try {
                            String matricule = sc.next();
                            int vehiculeToFind = Parking.retirerVehicule(matricule);
                            if(vehiculeToFind < 0){
                                throw new VehiculeNotFound("Vehicule with this matricule doesn't exist");
                            }

                            System.out.println("Vehicule taked away successfully!");
                            System.out.println("Free places : " + Parking.placesDisponibles());
                        } catch (VehiculeNotFound e) {
                            System.out.println(e);
                        }

                        break;
                    case 3:
                        System.out.println("You've choose to display parked vehicles.");
                        break;
                    default:
                        System.out.println("Sorry! this option isn't available.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
            } finally {
                sc.nextLine(); // Consume the input to prevent the loop from getting stuck
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
                -----------------------------------------------------------""");
    }
}