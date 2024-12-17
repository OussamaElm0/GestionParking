import java.time.LocalDateTime;
import java.time.ZoneId;

public sealed abstract class Vehicule
        implements Tarification
        permits Moto, Voiture, Camion
{
    private String matricule;
    private LocalDateTime heureEntre;

    Vehicule(String matricule){
        this.matricule = matricule;
        this.heureEntre = LocalDateTime.now();
    }

    public String getMatricule() {
        return matricule;
    }

    public LocalDateTime getHeureEntre() {
        return heureEntre;
    }

    public abstract double calculerTarif();
}
