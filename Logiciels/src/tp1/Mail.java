package tp1;

/**
 * The "Mail" automaton.
 */
public class Mail {
    private static Automate automate;

    /**
     * Creation of the "Mail" automaton.
     * The different states through which the automaton can pass are first created and then the different transitions between them.
     * We also set the start state and the end state.
     */
    public Mail(){
        automate = new Automate("Mail");
        State E0 = new State("E0");
        State E1 = new State("E1");
        State E2 = new State("E2");
        State E3 = new State("E3");
        State E4 = new State("E4");
        State E5 = new State("E5");
        State E6 = new State("E6");
        State E7 = new State("E7");
        String Lettres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String Lettresetchiffres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < Lettres.length(); i++){
            automate.addTransition(E0, Lettres.charAt(i),E1);
        }
        for (int i = 0; i < Lettresetchiffres.length(); i++){
            automate.addTransition(E1, Lettresetchiffres.charAt(i),E1);
        }
        automate.addTransition(E1,'.',E2);
        automate.addTransition(E1,'-',E2);
        automate.addTransition(E1,'@',E4);
        for (int i = 0; i < Lettres.length(); i++){
            automate.addTransition(E2, Lettres.charAt(i),E3);
        }
        automate.addTransition(E3,'-',E2);
        for (int i = 0; i < Lettresetchiffres.length(); i++){
            automate.addTransition(E3, Lettresetchiffres.charAt(i),E3);
        }
        automate.addTransition(E3,'@',E4);
        for (int i = 0; i < Lettres.length(); i++){
            automate.addTransition(E4, Lettres.charAt(i),E5);
        }
        for (int i = 0; i < Lettresetchiffres.length(); i++){
            automate.addTransition(E5, Lettresetchiffres.charAt(i),E5);
        }
        automate.addTransition(E5,'-',E4);
        automate.addTransition(E5,'.',E6);
        for (int i = 0; i < Lettres.length(); i++){
            automate.addTransition(E6, Lettres.charAt(i),E7);
        }
        automate.addTransition(E7,'-',E4);
        automate.addTransition(E7,'.',E6);
        for (int i = 0; i < Lettresetchiffres.length(); i++){
            automate.addTransition(E7, Lettresetchiffres.charAt(i),E7);
        }
        automate.finalstate(E7);
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
