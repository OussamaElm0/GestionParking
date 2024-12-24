package vehicules;

public non-sealed class Moto extends Vehicule{
    private String cylindre;

    public Moto(String matricule){
        super(matricule);
    }

    public Moto(String matricule, String cylindre){
        super(matricule);
        this.cylindre = cylindre;
    }

    public String getCylindre(){
        return cylindre ;
    }

    @Override
    public double calculerTarif(){
        return 1.00;
    }
}
