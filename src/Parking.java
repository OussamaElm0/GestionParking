import java.util.ArrayList;

public class Parking {
    private static final int MAX_PLACES = 30;
    private static ArrayList<Vehicule> listeVehicules = new ArrayList<Vehicule>();

    public static int getMaxPlaces(){
        return MAX_PLACES;
    }

    public static ArrayList<Vehicule> getListeVehicules(){
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
