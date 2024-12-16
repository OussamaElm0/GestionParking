import java.time.LocalDateTime;
import java.time.ZoneId;

public abstract class Vehicule implements Tarification{
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

    public abstract double calculerTarf();
}
