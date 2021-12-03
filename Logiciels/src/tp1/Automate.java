package tp1;
import java.util.*;

/**
 * The class that takes care of the creation and verification of automata.
 */
public class Automate {

    ArrayList<State> S = new ArrayList<State>();
    State S0;
    ArrayList<State> SF;
    String newnom;

    public Automate(String nom){
        newnom = nom;
        SF = new ArrayList<State>();
    }

    /**
     * Defines the starting state.
     * @param Etat The starting state.
     */
    public void state1(State Etat){S0 = Etat;}

    /**
     * Adds a final state.
     * @param Etat The final state.
     */
    public void finalstate(State Etat){SF.add(Etat);}


    /**
     * Adds a transition between two states.
     * @param actuel The current state before the transition.
     * @param Caractere The character that allows the transition.
     * @param Etat The current state after the transition.
     */
    public void addTransition(State actuel, char Caractere, State Etat){
        actuel.addTransition(Caractere, Etat);
    }

    /**
     * Checks if the character string to analyze passes from the start state to an end state.
     * @param chaine The character string to analyze.
     * @throws AutomateException if the parsed character string is incorrect.
     * @return The result of the analysis.
     */
    public String verif(String chaine) throws AutomateException {
        State actuel = S0;
        int i = 0;
        String mot = "";
        while (!(SF.contains(actuel)) || !(mot.equals(chaine)) ){
            if (i > chaine.length()-1){
                throw new AutomateException();
            }
            try{
                actuel = (State) actuel.getMap().get(chaine.charAt(i));
            } catch (Exception e){
                throw new AutomateException();
            }
            mot = mot + chaine.charAt(i);
            i = i + 1;
        }
        return "The parsed character string is correct.";
    }
}
