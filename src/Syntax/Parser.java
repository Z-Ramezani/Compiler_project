package Syntax;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Stack;


public class Parser {

    public void parseTree (ArrayList<String> tokens){

        ArrayList arrayList [] = new ArrayList[3];
        Stack <String> stack = new Stack<String>();
        ParsingTable parsingTable = new ParsingTable();

        stack.push("$");
        stack.push("Main-Stmt");

        String body = "" ;
        for (String input : tokens){

            if (parsingTable.table.containsValue(stack.peek())) {

            }
            Pair pair1 = new Pair(stack.peek() , input);
            body = parsingTable.table.get(pair1);

            if (body.isEmpty()) {

            }
            else{
                if (body.equals(input)){

                }
            }

        }

    }
}
