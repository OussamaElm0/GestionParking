package vehicules;

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
        return 1.00;
    }
}
