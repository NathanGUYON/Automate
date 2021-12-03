package tp1;

/**
 * The "Smiley" automaton.
 */
public class Smiley {
    private static Automate automate;

    /**
     * Creation of the "Smiley" automaton.
     * The different states through which the automaton can pass are first created and then the different transitions between them.
     * We also set the start state and the end state.
     */
    public Smiley(){
        automate = new Automate("Smiley");
        State E0 = new State("E0");
        State A1 = new State("A1");
        State A2 = new State("A2");
        State B3 = new State("B3");
        State C4 = new State("C4");
        automate.addTransition(E0,':',A1);
        automate.addTransition(E0,';',A2);
        automate.addTransition(A1,'-',B3);
        automate.addTransition(A1,'=',B3);
        automate.addTransition(A2,'-',B3);
        automate.addTransition(B3,'(',C4);
        automate.addTransition(B3,')',C4);
        automate.finalstate(C4);
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
