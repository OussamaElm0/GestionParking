package parking;

import java.util.HashSet;
import vehicules.Vehicule;
import exceptions.MatriculAlreadyExist;

public class Parking {
    private static final int MAX_PLACES = 30;
    private static final HashSet<Vehicule> listeVehicules = new HashSet<>(MAX_PLACES);

    public static int getMaxPlaces(){
        return MAX_PLACES;
    }

    public static HashSet<Vehicule> getListeVehicules(){
        return listeVehicules;
    }

    public static int placesDisponibles(){
        return MAX_PLACES - listeVehicules.size();
    }

    public static int ajouterVehicule(Vehicule vehicule){
        int placesDispo = Parking.placesDisponibles();
        if(placesDispo <= 0){
            return -1;
        }
        listeVehicules.add(vehicule);
        return 0;
    }

    private static Vehicule findByMatricule(String matricule){
        Vehicule vehiculeToFind = null;
        for(Vehicule vehicule: listeVehicules){
            boolean isMatricule = vehicule
                    .getMatricule()
                    .equalsIgnoreCase(matricule);
            if(isMatricule){
                vehiculeToFind = vehicule;
            }
        }
        return vehiculeToFind;
    }

    public static void checkMatriculeExist(String matricule) throws MatriculAlreadyExist{

        Vehicule vehicule = findByMatricule(matricule);

        if (vehicule != null){
            throw new MatriculAlreadyExist("The provided matricul already exist");
        }

    }

    public static int retirerVehicule(String matricule){
        boolean deleted = false;

        Vehicule vehicule = findByMatricule(matricule);

        if(vehicule != null){
            listeVehicules.remove(vehicule);
            double tarif = vehicule.calculerTarif();
            System.out.println("The tarif of this vehicle is : " + tarif + "MAD");
            deleted = true;
        }

        return deleted ? 0 : -1;
    }

    public static void displayParking(){
        int index = 0;

        for(Vehicule vehicule: listeVehicules){
            System.out.println((++index)  + "- " + vehicule);
        }
    }

}
