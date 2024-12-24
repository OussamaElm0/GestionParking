package vehicules;

public non-sealed class Camion extends Vehicule{
    private int capaciteCharge;

    Camion(String matricule){
        super(matricule);
    }

    Camion(String matricule, int capaciteCharge){
        super(matricule);
        this.capaciteCharge = capaciteCharge;
    }

    public int getCapaciteCharge(){
        return capaciteCharge;
    }

    @Override
    public double calculerTarif(){
        return 1.00;
    }
}
