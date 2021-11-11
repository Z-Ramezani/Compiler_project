package google.com;

public class Check extends Main{
    StringBuilder token = new StringBuilder();

     Check(String s) {
         int index_first = 0, index_current = 0;
         //char end = '\n';
         while (index_first < s.length()) { //while (s.charAt(index_first) != end)

             char c = s.charAt(index_first);
             token.append(c);
             if (letter.contains(c)) isKeywordOrIdentifiers();
             else if (digit.contains(c)) isNumber();
             else if (operator.contains(c)) isOperator();
             else {
                 isError();
                 break;
             }

         }

     }

     void isKeywordOrIdentifiers() {

     }

    void isNumber() {

    }

    void isOperator() {

    }

    void isError() {}
}

