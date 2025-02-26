package com.parking_management;

import java.util.*;
import factories.*;
import parking.Parking;
import vehicules.Vehicule;
import vehicules.VehiculeTypes;
import exceptions.VehiculeNotFoundException;
import exceptions.ParkingEmptyException;
import vehicules.Voiture;

//TODO  -categorize messages
//      -add logs for debugging

public class Main {
    public static  Locale currentLocale = Locale.getDefault();
    public static ResourceBundle bundle = ResourceBundle.getBundle("ressources.messages", currentLocale);

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println(bundle.getString("welcome_message").replace("{0}", currentLocale.toString()));
        MAIN_LOOP : while(true){ // giving the loop a name to avoid break issues within the switch statement
            displayMenuOptions(bundle);

            try {
                choice = sc.nextInt();

                switch (choice){
                    case 0:
                        System.out.println(bundle.getString("goodbye_message"));
                        break MAIN_LOOP; // break the while loop
                    case 1 :
                        parkVehicleOption(sc);
                        break;
                    case 2:
                        removeVehicleOption(sc);
                        break;
                    case 3:
                        displayParkingOption();
                        break;
                    case 4:
                        displayTotalAmountOption();
                        break;
                    default:
                        System.out.println(bundle.getString("option_not_available"));
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(bundle.getString("invalid_input"));
            } finally {
                sc.nextLine(); // Consume the input to prevent the loop from getting stuck
            }
        }
    }

    private static void displayMenuOptions(ResourceBundle bundle){
        System.out.println("""
                -----------------------------------------------------------
                """ + bundle.getString("choose_menu") + """
                \n-----------------------------------------------------------""");
    }

    private static void parkVehicleOption(Scanner sc){
        System.out.println(bundle.getString("park_vehicle"));
        Vehicule vehicule = null;
        System.out.println(bundle.getString("choose_type"));
        int vehiculeType = sc.nextInt();
        String[] vehiculeInformations;

        switch (vehiculeType){
            case 1:
                System.out.println(bundle.getString("enter_information_format_car"));
                vehiculeInformations = sc.next()
                        .split("_");

                try {
                    if (vehiculeInformations.length == 2) {
                        vehicule = VehiculeFactory.createVehicule(VehiculeTypes.VOITURE, vehiculeInformations[0], Integer.parseInt(vehiculeInformations[1]));
                    } else if (vehiculeInformations.length == 1) {
                        vehicule = VehiculeFactory.createVehicule(VehiculeTypes.VOITURE, vehiculeInformations[0]);
                    }
                    vehicule.park();
                } catch (NumberFormatException e) {
                    System.out.println(bundle.getString("number_format_error"));
                }
                break;
            case 2:
                System.out.println(bundle.getString("enter_information_format_moto"));
                vehiculeInformations = sc.next()
                        .split("_");

                if(vehiculeInformations.length == 1){
                    vehicule = VehiculeFactory.createVehicule(VehiculeTypes.MOTO,vehiculeInformations[0]);
                } else if (vehiculeInformations.length == 2) {
                    vehicule = VehiculeFactory.createVehicule(VehiculeTypes.MOTO, vehiculeInformations[0], vehiculeInformations[1]);
                }
                vehicule.park();
                break;
            case 3:
                System.out.println(bundle.getString("enter_information_format_truck"));
                vehiculeInformations = sc.next()
                        .split("_");

                try{
                    if(vehiculeInformations.length == 1){
                        vehicule = VehiculeFactory.createVehicule(VehiculeTypes.CAMION, vehiculeInformations[0]);
                    } else if(vehiculeInformations.length == 2){
                        vehicule = VehiculeFactory.createVehicule(VehiculeTypes.CAMION, vehiculeInformations[0], vehiculeInformations[1]);
                    }
                    vehicule.park();
                } catch (ClassCastException e) {
                    System.out.println(bundle.getString("number_format_error"));
                }

                break;
            default:
                System.out.println(bundle.getString("option_not_available"));
        }
    }

    private static void removeVehicleOption(Scanner sc){
        System.out.println(bundle.getString("remove_vehicle"));
        System.out.println(bundle.getString("enter_matricule"));
        try {
            String matricule = sc.next();
            int vehiculeToFind = Parking.retirerVehicule(matricule);
            if(vehiculeToFind < 0){
                throw new VehiculeNotFoundException(bundle.getString("vehicle_not_found"));
            }

            System.out.println(bundle.getString("vehicle_removed"));
            System.out.println(
                    bundle.getString("free_places")
                            .replace("{0}", Integer.toString(Parking.placesDisponibles()))
            );
        } catch (VehiculeNotFoundException e) {
            System.out.println(e);
        }
    }

    private static void displayParkingOption(){
        System.out.println(bundle.getString("display_parking"));
        try {
            Parking.displayParking();
        } catch (ParkingEmptyException e){
            System.out.println(e.getMessage());
        }
    }

    private static void displayTotalAmountOption(){
        System.out.println(bundle.getString("display_amount"));
        System.out.println(Parking.getTotalAmount());
    }
}