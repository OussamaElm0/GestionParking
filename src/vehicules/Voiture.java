package vehicules;

import java.time.Duration;
import java.time.LocalDateTime;

public non-sealed class Voiture extends Vehicule{
    private int nombrePortes;

    public Voiture(String matricule){
        super(matricule);
        this.nombrePortes = 4;
    }

    public Voiture(String matricule, int nbrPortes){
        super(matricule);

        if(nbrPortes != 2 || nbrPortes != 4){
            this.nombrePortes = 4;
        } else {
            this.nombrePortes = nbrPortes;
        }
    }

    public int getNombrePortes(){
        return nombrePortes;
    }

    public void a(){
        System.out.println(getHeureEntre());
    }
    @Override
    public double calculerTarif(){
        //Calculate how long a vehicle is parked
        LocalDateTime now = LocalDateTime.now();
        long duration = Duration.between(getHeureEntre(), now)
                .toHours();

        return 5.00 * ( duration + 1);
    }
}
