package tp1;

/**
 * The "Date" automaton.
 */
public class Date {
    private static Automate automate;

    /**
     * Creation of the "Date" automaton.
     * The different states through which the automaton can pass are first created and then the different transitions between them.
     * We also set the start state and the end state.
     */
    public Date(){
        automate = new Automate("Date");
        State E0 = new State("E0");
        State J1 = new State("J1");
        State J2 = new State("J2");
        State J3 = new State("J3");
        State J4 = new State("J4");
        State J5 = new State("J5");
        State J6 = new State("J6");
        State J7 = new State("J7");
        State T1 = new State("T1");
        State T2 = new State("T2");
        State T3 = new State("T3");
        State M1 = new State("M1");
        State M2 = new State("M2");
        State M3 = new State("M3");
        State M4 = new State("M4");
        State M5 = new State("M5");
        State M6 = new State("M6");
        State M7 = new State("M7");
        State A1 = new State("A1");
        State A2 = new State("A2");
        State A3 = new State("A3");
        State A4 = new State("A4");
        State A5 = new State("A5");
        State A6 = new State("A6");
        State A7 = new State("A7");
        State A8 = new State("A8");
        String Chiffres = "0123456789";
        automate.addTransition(E0,'0',J1);
        automate.addTransition(E0,'1',J2);
        automate.addTransition(E0,'2',J3);
        automate.addTransition(E0,'3',J4);
        for (int i = 1; i < 10; i++){
            automate.addTransition(J1, Chiffres.charAt(i),J5);
        }
        for (int i = 0; i < 10; i++){
            automate.addTransition(J2, Chiffres.charAt(i),J5);
        }
        for (int i = 0; i < 9; i++){
            automate.addTransition(J3, Chiffres.charAt(i),J6);
        }
        automate.addTransition(J3,'9',J6);
        automate.addTransition(J4,'0',J7);
        automate.addTransition(J4,'1',J7);
        automate.addTransition(J5,'/',T1);
        automate.addTransition(J6,'/',T2);
        automate.addTransition(J7,'/',T3);
        automate.addTransition(T1,'0',M1);
        automate.addTransition(T1,'1',M2);
        automate.addTransition(T2,'0',M3);
        automate.addTransition(T2,'1',M4);
        automate.addTransition(T3,'0',M5);
        automate.addTransition(T3,'1',M6);
        for (int i = 1; i < 10; i++){
            automate.addTransition(M1, Chiffres.charAt(i),M7);
        }
        for (int i = 0; i < 3; i++){
            automate.addTransition(M2, Chiffres.charAt(i),M7);
        }
        automate.addTransition(M3,'1',M7);
        for (int i = 3; i < 10; i++){
            automate.addTransition(M3, Chiffres.charAt(i),M7);
        }
        for (int i = 0; i < 3; i++){
            automate.addTransition(M4, Chiffres.charAt(i),M7);
        }
        automate.addTransition(M5,'1',M7);
        automate.addTransition(M5,'3',M7);
        automate.addTransition(M5,'5',M7);
        automate.addTransition(M5,'7',M7);
        automate.addTransition(M5,'8',M7);
        automate.addTransition(M6,'0',M7);
        automate.addTransition(M6,'2',M7);
        automate.addTransition(M7,'/',A1);
        automate.addTransition(A1,'0',A3);
        for (int i = 1; i < 10; i++){
            automate.addTransition(A1, Chiffres.charAt(i),A2);
        }
        for (int i = 0; i < 10; i++){
            automate.addTransition(A2, Chiffres.charAt(i),A4);
        }
        automate.addTransition(A3,'0',A5);
        for (int i = 1; i < 10; i++){
            automate.addTransition(A3, Chiffres.charAt(i),A4);
        }
        for (int i = 0; i < 10; i++){
            automate.addTransition(A4, Chiffres.charAt(i),A6);
        }
        automate.addTransition(A5,'0',A7);
        for (int i = 1; i < 10; i++){
            automate.addTransition(A5, Chiffres.charAt(i),A6);
        }
        for (int i = 0; i < 10; i++){
            automate.addTransition(A6, Chiffres.charAt(i),A8);
        }
        for (int i = 1; i < 10; i++){
            automate.addTransition(A7, Chiffres.charAt(i),A8);
        }
        automate.finalstate(A8);
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
