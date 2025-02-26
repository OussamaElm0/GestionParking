package vehicules;

import exceptions.MatriculAlreadyExistException;

import java.time.LocalDateTime;
import parking.Parking;

public sealed abstract class Vehicule
        implements Tarification, Parkable
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

    @Override
    public void park() throws MatriculAlreadyExistException {
        try {
            Parking.checkMatriculeExist(this.matricule);
            Parking.ajouterVehicule(this);
            System.out.println("Car parked successfully!");
            System.out.println("Free places : " + Parking.placesDisponibles());
        } catch (MatriculAlreadyExistException e){
            System.out.println(e);
        }
    }

    @Override
    public String toString(){
        return "Type: " + this.getClass().getName() + " | " + "Matricule: " + this.matricule + "    "  ;
    }

    public abstract double calculerTarif();
}
