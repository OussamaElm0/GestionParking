public non-sealed class Camion extends Vehicule{
    private int capaciteCharge;

    Camion(String matricule, int capaciteCharge){
        super(matricule);
        this.capaciteCharge = capaciteCharge;
    }

    @Override
    public double calculerTarif(){
        return 1.00;
    }
}
