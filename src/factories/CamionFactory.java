package factories;

import vehicules.Camion;

public class CamionFactory {
    public static Camion createCamion(String matricule){
        return new Camion(matricule);
    }

    public static Camion createCamion(String matricule, int capaciteCharge){
        return new Camion(matricule, capaciteCharge);
    }
}
