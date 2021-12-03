package tp1;

/**
 * The "Polynome" automaton.
 */
public class Polynome {
    private static Automate automate;

    /**
     * Creation of the "Polynome" automaton.
     * The different states through which the automaton can pass are first created and then the different transitions between them.
     * We also define the start state and the various end states.
     */
    public Polynome(){
        automate = new Automate("Polynome");
        State E0 = new State("E0");
        State E1 = new State("E1");
        State E2 = new State("E2");
        State E3 = new State("E3");
        State E4 = new State("E4");
        State E5 = new State("E5");
        State E6 = new State("E6");
        State E7 = new State("E7");
        State E8 = new State("E8");
        State E9 = new State("E9");
        State E10 = new State("E10");
        State E11 = new State("E11");
        State E12 = new State("E12");
        State E13 = new State("E13");
        State E14 = new State("E14");
        State E15 = new State("E15");
        State E16 = new State("E16");
        State E17 = new State("E17");
        State E18 = new State("E18");
        State E19 = new State("E19");
        State E20 = new State("E20");
        State E21 = new State("E21");
        State E22 = new State("E22");
        String Chiffres = "0123456789";
        automate.addTransition(E0,'1',E1);
        automate.addTransition(E0,'2',E2);
        for (int i = 3; i < 10; i++){
            automate.addTransition(E0, Chiffres.charAt(i),E3);
        }
        for (int i = 0; i < 10; i++){
            automate.addTransition(E1, Chiffres.charAt(i),E4);
        }
        automate.addTransition(E1,'X',E6);
        for (int i = 0; i < 6; i++){
            automate.addTransition(E2, Chiffres.charAt(i),E5);
        }
        automate.addTransition(E2,'X',E6);
        automate.addTransition(E3,'X',E6);
        automate.addTransition(E4,'X',E6);
        automate.addTransition(E5,'X',E6);
        automate.addTransition(E6,'*',E7);
        automate.addTransition(E7,'*',E8);
        automate.addTransition(E8,'2',E9);
        automate.addTransition(E9,'-',E10);
        automate.addTransition(E9,'+',E10);
        automate.addTransition(E10,'1',E11);
        automate.addTransition(E10,'2',E12);
        for (int i = 3; i < 10; i++){
            automate.addTransition(E10, Chiffres.charAt(i),E13);
        }
        for (int i = 0; i < 10; i++){
            automate.addTransition(E11, Chiffres.charAt(i),E14);
        }
        automate.addTransition(E11,'X',E16);
        for (int i = 0; i < 6; i++){
            automate.addTransition(E12, Chiffres.charAt(i),E15);
        }
        automate.addTransition(E12,'X',E16);
        automate.addTransition(E13,'X',E16);
        automate.addTransition(E14,'X',E16);
        automate.addTransition(E15,'X',E16);
        automate.addTransition(E16,'-',E17);
        automate.addTransition(E16,'+',E17);
        automate.addTransition(E17,'1',E18);
        automate.addTransition(E17,'2',E19);
        for (int i = 3; i < 10; i++){
            automate.addTransition(E17, Chiffres.charAt(i),E20);
        }
        for (int i = 0; i < 10; i++){
            automate.addTransition(E18, Chiffres.charAt(i),E21);
        }
        for (int i = 0; i < 6; i++){
            automate.addTransition(E19, Chiffres.charAt(i),E22);
        }
        automate.finalstate(E20);
        automate.finalstate(E21);
        automate.finalstate(E22);
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
