package factories;

import vehicules.Vehicule;
import vehicules.VehiculeTypes;

public class VehiculeFactory {
    public static Vehicule createVehicule(VehiculeTypes type, Object ...params){
        Vehicule vehicule = null;

        switch (type){
            case VOITURE :
                if(params.length == 2){
                    vehicule = VoitureFactory.createVoiture((String) params[0], (Integer) params[1]);
                } else if(params.length == 1){
                    vehicule = VoitureFactory.createVoiture((String) params[0]);
                }
                break;
            case MOTO:
                if(params.length == 2){
                    vehicule = MotoFactory.createMoto((String) params[0], (String) params[1]);
                } else if(params.length == 1){
                    vehicule = MotoFactory.createMoto((String) params[0]);
                }
                break;
            case CAMION:
                if(params.length == 2){
                    vehicule = CamionFactory.createCamion((String) params[0], (Integer) params[1]);
                } else if(params.length == 1){
                    vehicule = CamionFactory.createCamion((String) params[0]);
                }
                break;
            default:
                break;
        }

        return vehicule;
    };
}
