package tp1;
import java.util.Scanner;

/**
 * The main program which allows you to launch the different automatons and display the results.
 */
public class Monapplication {

    private int demande;
    Scanner saisieUtilisateur = new Scanner(System.in);
    private String chaine;
    private String resultat;

    /**
     * The main program.
     * @throws InterruptedException to temporarily interrupt the program.
     */
    public Monapplication() throws InterruptedException {
        int i = 0;
        while (i == 0){
            demande = lancement();
            chaine = getChaine();
            resultat = automate(demande,chaine);
            System.out.println(resultat);
            Thread.sleep(2000);
        }
    }

    /**
     * This starts the program.
     * @throws InterruptedException to temporarily interrupt the program.
     */
    public static void main(String[]args) throws InterruptedException {
        Monapplication a = new Monapplication();
    }

    /**
     * The launch menu to choose which automaton to run.
     * @return The chosen automaton.
     */
    public int lancement(){
        System.out.println("--------------- My TP menu ---------------");
        System.out.println("1. Smiley (recognize smileys)");
        System.out.println("2. HH:MM (recognize a well-formed hour)");
        System.out.println("3. DD/MM/YYYY (recognize a well formed date)");
        System.out.println("4. Email adress (recognize a well-formed email address)");
        System.out.println("5. Polynomial (recognize a well-formed polynomial under the form aX**2±bX±c with a, b and c between 1 and 25)");
        System.out.println("9. Stop");
        System.out.println("Your choice (1-9) ?");
        System.out.println("I will then ask you for the channel to analyze, thank you.");
        demande = saisieUtilisateur.nextInt();
        if (choix(demande) == false){
            demande = lancement();
        }
        return demande;
    }

    /**
     * Allows you to know if the choice is coherent or not.
     * @param demande User request.
     * @return If the choice is coherent or not.
     */
    public boolean choix(int demande){
        if ((demande == 1) || (demande == 2) || (demande == 3) || (demande == 4) || (demande == 5)){
            return true;
        }
        else if (demande == 9){
            System.out.println("Good bye !");
            System.exit(1);
        }
        return false;
    }

    /**
     * Request the character string to analyze.
     * @return The character string to analyze.
     */
    public String getChaine(){
        System.out.println("Please enter the character string to analyze, thank you.");
        chaine = saisieUtilisateur.next();
        return chaine;
    }

    /**
     * Launches the chosen automaton.
     * @param demande User request.
     * @param chaine The character string to analyze.
     * @return The result of the analysis.
     */
    public String automate(int demande,String chaine) {
        if (demande == 1){
            new Smiley();
            try{
                resultat = Smiley.verif(chaine);
            }
            catch (AutomateException e){
                resultat = "The parsed character string is incorrect.";
            }
        }
        else if (demande == 2){
            new Heure();
            try{
                resultat = Heure.verif(chaine);
            }
            catch (AutomateException e){
                resultat = "The parsed character string is incorrect.";
            }

        }
        else if (demande == 3){
            new Date();
            try{
                resultat = Date.verif(chaine);
            }
            catch (AutomateException e){
                resultat = "The parsed character string is incorrect.";
            }
        }
        else if (demande == 4){
            new Mail();
            try{
                resultat = Mail.verif(chaine);
            }
            catch (AutomateException e){
                resultat = "The parsed character string is incorrect.";
            }
        }
        else if (demande == 5){
            new Polynome();
            try{
                resultat = Polynome.verif(chaine);
            }
            catch (AutomateException e){
                resultat = "The parsed character string is incorrect.";
            }
        }
        return resultat;
    }


}