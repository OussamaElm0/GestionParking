package vehicules;

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

    @Override
    public double calculerTarif(){
        return 1.00;
    }
}
