public non-sealed class Voiture extends Vehicule{
    private int nombrePortes;

    Voiture(String matricule){
        super(matricule);
        this.nombrePortes = 4;
    }

    Voiture(String matricule, int nbrPortes){
        super(matricule);
        this.nombrePortes = nbrPortes;
    }

    @Override
    public double calculerTarif(){
        return 1.00;
    }
}
