package vehicules;

import java.time.Duration;
import java.time.LocalDateTime;

public non-sealed class Moto extends Vehicule{
    private String cylindre;

    public Moto(String matricule){
        super(matricule);
    }

    public Moto(String matricule, String cylindre){
        super(matricule);
        this.cylindre = cylindre;
    }

    public String getCylindre(){
        return cylindre ;
    }

    @Override
    public double calculerTarif(){
        //Calculate how long a vehicle is parked
        LocalDateTime now = LocalDateTime.now();
        long duration = Duration.between(getHeureEntre(), now)
                .toHours();

        return 2.50 * (duration + 1);
    }
}
