public non-sealed class Moto extends Vehicule{
    private String cylindre;

    Moto(String matricule, String cylindre){
        super(matricule);
        this.cylindre = cylindre;
    }

    @Override
    public double calculerTarif(){
        return 1.00;
    }
}
