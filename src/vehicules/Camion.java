package vehicules;

import java.time.Duration;
import java.time.LocalDateTime;

public non-sealed class Camion extends Vehicule{
    private int capaciteCharge;

    public Camion(String matricule){
        super(matricule);
    }

    public Camion(String matricule, int capaciteCharge){
        super(matricule);
        this.capaciteCharge = capaciteCharge;
    }

    public int getCapaciteCharge(){
        return capaciteCharge;
    }

    @Override
    public double calculerTarif(){
        //Calculate how long a vehicle is parked
        LocalDateTime now = LocalDateTime.now();
        long duration = Duration.between(getHeureEntre(), now)
                .toHours();

        return 8.50 * (duration + 1);
    }
}
