import java.util.HashSet;
import vehicules.Vehicule;

public class Parking {
    private static final int MAX_PLACES = 30;
    private static final HashSet<Vehicule> listeVehicules = new HashSet<>(MAX_PLACES);

    public static int getMaxPlaces(){
        return MAX_PLACES;
    }

    public static HashSet<Vehicule> getListeVehicules(){
        return listeVehicules;
    }

    public static int placeDisponible(){
        return MAX_PLACES - listeVehicules.size();
    }

    public static int ajouterVehicule(Vehicule vehicule){
        int placesDispo = Parking.placeDisponible();
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

    public static int retirerVehicule(String matricule){
        boolean deleted = false;

        Vehicule vehicule = findByMatricule(matricule);

        if(vehicule != null){
            listeVehicules.remove(vehicule);
            deleted = true;
        }

        return deleted ? 0 : -1;
    }

}
