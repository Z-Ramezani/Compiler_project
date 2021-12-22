package google.com;

import java.util.LinkedList;

public class lexicalAnalysis extends Main{
    LinkedList<String> tokens = new LinkedList<String>();

     String lexicalAnalysis(String s) {
         int i = 0;

         while (i < s.length()) {
             String  token = "";
             char c = s.charAt(i);
             int int_state = 0, int_c = defineChar(c);

             if (int_c == -1) return "error";
             while (int_state != -1 && int_state != 70) {
                 token += s.charAt(i++);
                 int_state = dfa_state[int_state][int_c];
                 int_c = defineChar(s.charAt(i));
             }

             if (int_state == -1) {
                 tokens.add(token);
                 return token;
             }
             else return "error";
         }
         return "\n";
     }

     int defineChar(char c) {
         int int_c = -1;
         String characters = "+-=!/)(}{><.;,&|%*_'“\n";
         for (int i = 0; i < 23; i++) {
             if (c == characters.charAt(i)) {
                 int_c = i + 3;
                 break;
             }
         }
         return int_c;
     }
}

