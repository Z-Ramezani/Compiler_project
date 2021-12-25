package google.com;
///debug3


import java.util.ArrayList;

public class LexicalAnalysis extends Main{
    ArrayList<String> token_error = new ArrayList<String>();

    //here we used the algorithm that we send the picture of it on GitHub and DFA table.
    // also, here we complete symbol table for tokens that are identifier.
    public ArrayList<String> lexicalAnalysis(String s) {
        int i = 0;
        while (i < s.length()) {
            String  token = "";
            String c = String.valueOf(s.charAt(i));
            int int_state = 0, int_c = defineChar(c);

            if (int_c == -1) {
                token_error.add("error");
                i++;
            }
            else while (true ) {
                if (dfa_state[int_state][int_c]==70 || dfa_state[int_state][int_c]==-1  )break;
                int_state = dfa_state[int_state][int_c];
                if (dfa_state[int_state][int_c]==70 || dfa_state[int_state][int_c]==-1  ){
                    break;
                }
                token += s.charAt(i);
                i++;
                if (i==s.length()){
                    int_state = dfa_state[int_state][int_c];
                    break;
                }
                int_c = defineChar(String.valueOf(s.charAt(i)));
            }


            if (dfa_state[int_state][int_c] == -1) {
                if (!token.equals(" ") && token.charAt(0) != ' ' ) {
                    token_error.add(token);
                    if (!keyword.contains(token) && !operator.contains(token) && !digit.contains(token)) {
                        String type ="";
                        // define the type of token to complete symbol table.
                        for (int ind = token_error.indexOf(token) - 1; ind >= 0; ind--) {
                            if (keyword_type.contains(token_error.get(ind))) {
                                type = token_error.get(ind);
                                break;
                            }
                        }
                        symbolTable.setSymbol_table(Extractor.count, "identifier", type, token);
                        Extractor.count ++ ;
                    }
                }
            }
            else {
                int_c = 0 ;
                int_state = dfa_state[int_state][int_c];
                if (dfa_state[int_state][int_c] == -1) token_error.add(token);
                else token_error.add("error");
            }
        }
        return token_error;
    }

    //here we understand that the input is which column of DFA table.
    int defineChar(String c) {
        int int_c = -1;
        if (letter.contains(c))
            int_c=2;
        else if (digit.contains(c))
            int_c=1;
        else if (c.equals(" ")) int_c=0;
        else {
            String characters = "+-=!/)(}{><.;,&|%*_'“\n";
            for (int i = 3; i < 23; i++) {
                if (c.equals(String.valueOf(characters.charAt(i - 3)))) {
                    int_c = i;
                    break;
                }
            }
        }
        return int_c;
    }
}
