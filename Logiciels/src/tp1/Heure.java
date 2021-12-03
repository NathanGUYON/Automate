package tp1;

/**
 * The "Heure" automaton.
 */
public class Heure {
    private static Automate automate;

    /**
     * Creation of the "Heure" automaton.
     * The different states through which the automaton can pass are first created and then the different transitions between them.
     * We also set the start state and the end state.
     */
    public Heure(){
        automate = new Automate("Heure");
        State E0 = new State("E0");
        State H1 = new State("H1");
        State H2 = new State("H2");
        State H = new State("H");
        State M1 = new State("M1");
        State M2 = new State("M2");
        State M = new State("M");
        String Chiffres = "0123456789";
        automate.addTransition(E0,'0',H1);
        automate.addTransition(E0,'1',H1);
        automate.addTransition(E0,'2',H2);
        for (int i = 0; i < 10; i++){
            automate.addTransition(H1, Chiffres.charAt(i),H);
        }
        for (int i = 0; i < 4; i++){
            automate.addTransition(H2, Chiffres.charAt(i),H);
        }
        automate.addTransition(H,':',M1);
        for (int i = 0; i < 6; i++){
            automate.addTransition(M1, Chiffres.charAt(i),M2);
        }
        for (int i = 0; i < 10; i++){
            automate.addTransition(M2, Chiffres.charAt(i),M);
        }
        automate.finalstate(M);
        automate.state1(E0);
    }

    /**
     * Requests the verification of the automaton character string.
     * @param chaine The character string to analyze.
     * @throws AutomateException if the parsed character string is incorrect.
     * @return The result of the analysis.
     */
    public static String verif(String chaine) throws AutomateException {
        return automate.verif(chaine);
    }
}
