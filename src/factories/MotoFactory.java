package factories;

import vehicules.Moto;

public class MotoFactory {
    public static Moto createMoto(String matricule){
        return new Moto(matricule);
    }

    public static Moto createMoto(String matricule, String cylindre){
        return new Moto(matricule, cylindre);
    }
}
