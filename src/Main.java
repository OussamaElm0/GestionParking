
public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to our parking management application!");
        displayMenuOptions();
    }

    private static void displayMenuOptions(){
        System.out.println("""
                -----------------------------------------------------------
                Choose by number :
                1. Park a vehicule
                2. Remove a car from parking
                3. Display parking
                -----------------------------------------------------------
                """);
    }
}