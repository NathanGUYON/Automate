package tp1;
import java.util.*;

/**
 * The class that takes care of the creation of states.
 */
public class State {

    private Map<Character, State> Map;
    private String nom;

    /**
     * Create a map containing the transitions from which the state begins.
     * @param newnom The name of the state.
     */
    public State(String newnom){

        nom = newnom;
        Map = new HashMap<Character, State>();

    }

    /**
     * Sends the different transitions from which a state starts.
     * @return The different transitions from which a state starts.
     */
    Map getMap(){
        return Map;
    }

    /**
     * Checks if the character string to analyze passes from the start state to an end state.
     * @param Caractere The character string to analyze.
     * @param Etat The character string to analyze.
     */
    public void addTransition(char Caractere, State Etat){
        Map.put(Caractere, Etat);
    }
}
