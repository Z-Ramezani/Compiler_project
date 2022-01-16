package Syntax;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;


public class Parser {

    public void parsing (ArrayList<String> tokens , HashMap<Pair<String , String>, String> table){


        ArrayList action [] = new ArrayList[3];
        Stack <String> stack = new Stack<String>();



        stack.push("$");
        stack.push("Main-Stmt");

        String body = "" , input = "";
        String body_tmp [] ;
        int indx = 0;
        while (! stack.isEmpty()) {
            if (indx < tokens.size()){
                input = tokens.get(indx);
                if (containNonTerminal(stack.peek() , table)){

                    Pair pair1 = new Pair(stack.peek() , input);
                    body = table.get(pair1);
                    action[0].add("output");
                    action[1].add(stack.pop());
                    body_tmp = body.split(" ");
                    for (int i = body_tmp.length ; i >= 0 ; i --){
                        stack.push(body_tmp[i]);
                    }
                    action[2].add(body_tmp);
                }
                else{
                    if (body.equals(input)){
                        action[0].add("match");
                        action[1].add(input);
                        action[2].add("");
                        stack.pop();
                    }
                }
            }
        }

    }
    boolean containNonTerminal (String peek , HashMap<Pair<String , String>, String> table){

        Set<Pair<String, String>> pairKeys = table.keySet();
        for (Pair <String, String> pair : pairKeys ) {
            if (pair.getKey().equals(peek)){
                return true;
            }
        }
        return false;
    }
}
