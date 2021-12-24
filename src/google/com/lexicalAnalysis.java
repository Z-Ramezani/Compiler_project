package google.com;

import java.util.LinkedList;

public class lexicalAnalysis extends Main{
    LinkedList<String> token_error = new LinkedList<String>();


    public LinkedList<String> lexicalAnalysis(String s) {
         int i = 0;

         while (i < s.length()) {
             String  token = "";
             char c = s.charAt(i);
             int int_state = 0, int_c = defineChar(c);
             System.out.println("333333");
             if (int_c == -1) {
                 token_error.add("error");
                 i++;
             }
             else while (true ) {
                 if (dfa_state[int_state][int_c]==70 || dfa_state[int_state][int_c]==-1  )break;
                 int_state = dfa_state[int_state][int_c];
                 if (dfa_state[int_state][int_c]==70 || dfa_state[int_state][int_c]==-1  )break;
                 token += s.charAt(i);
                 i++;
                 if (i==s.length()){
                     int_state = dfa_state[int_state][int_c];
                     break;
                 }
                 int_c = defineChar(s.charAt(i));
             }


             if (dfa_state[int_state][int_c] == -1) {
                 if (!token.equals(" ")) token_error.add(token);
             }
           else token_error.add("error");
         }
         return token_error;
     }

     int defineChar(char c) {
         int int_c = -1;
         if (letter.contains(c))
             int_c=2;
         else if (digit.contains(c))
             int_c=1;
         else if (c == ' ') int_c=0;
         else {
             String characters = "+-=!/)(}{><.;,&|%*_'“\n";
             for (int i = 3; i < 23; i++) {
                 if (c == characters.charAt(i - 3)) {
                     int_c = i;
                     break;
                 }
             }
         }
         return int_c;
     }
}

