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

    public static int retirerVehicule(String matricule){
        int index = 0;
        boolean deleted = false;
        for(Vehicule vehicule: listeVehicules){
            boolean isMatricule = vehicule.getMatricule()
                    .equalsIgnoreCase(matricule);
            if(isMatricule){
                listeVehicules.remove(index);
                deleted = true;
                break;
            }
            index++;
        }
        return deleted ? 0 : -1;
    }

}
