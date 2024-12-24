package factories;

import vehicules.Voiture;

public class VoitureFactory {
    public static Voiture createVoiture(String matricule){
        return new Voiture(matricule);
    }

    public static Voiture createVoiture(String matricule, int nbrPortes){
        return new Voiture(matricule, nbrPortes);
    }
}
