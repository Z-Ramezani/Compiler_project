package google.com;
import static google.com.Main.*;

public class check {
    String str=",;()!=><";
    char []symbol=str.toCharArray();
     check(String[]s){
        for (int i=0;i<s.length;i++)
                if (letter.contains(s[i].charAt(0)) ) {
                    if (keyword.contains(s[i]))
                        System.out.println("keyword :: " + s[i]);
                    else if (id.contains(s[i]))
                        System.out.println("Identifier :: " + s[i]);
                }
                else if (digit.contains(s[i].charAt(0))) {
                    if (number.contains(s[i]))
                        System.out.println("number :: " + s[i]);
                }
                else if (s[i].charAt(0)==symbol[0] ) { // ,
                    System.out.println("Operator :: ,");
                }
                else if (s[i].charAt(0)==symbol[1] ) { // ;
                    System.out.println("Operator :: ;");
                }
                else if (s[i].charAt(0)==symbol[2] ) { // (
                    System.out.println("Operator :: (");
                }
                else if (s[i].charAt(0)==symbol[3] ) { // )
                    System.out.println("Operator :: )");
                }
                else if (s[i].charAt(0)==symbol[4] ) { // !
                    if (s[i].charAt(1)==symbol[5]) //!=
                        System.out.println("Operator :: !=");
                    else System.out.println("illegal Operator");
                }
                else if (s[i].charAt(0)==symbol[5] ) { // =
                    if (s[i].charAt(1)==symbol[5]) //==
                        System.out.println("Operator :: ==");
                    else System.out.println("Operator :: =");
                }
                else if (s[i].charAt(0)==symbol[6] ) { // >
                    if (s[i].charAt(1)==symbol[5]) //>=
                        System.out.println("Operator :: >=");
                    else System.out.println("Operator :: >");
                }
                else if (s[i].charAt(0)==symbol[7] ) { // <
                    if (s[i].charAt(1)==symbol[5]) //<=
                        System.out.println("Operator :: <=");
                    else System.out.println("Operator :: <");
                }

     }
}

