package Syntax;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;


public class Parser {

    public void parsing (ArrayList<String> tokens , HashMap<Pair<String , String>, String> table , String[][] token_type){


        ArrayList action [] = new ArrayList[3];
        action[0] = new ArrayList();
        action[1] = new ArrayList();
        action[2] = new ArrayList();

        Stack <String> stack = new Stack<String>();
        stack.push("Main-Stmt");

        String body = "" , input = "";
        String body_tmp [] ;
        int indx = 0;
        while (! stack.isEmpty()) {
            if (indx < tokens.size()){
                input = tokens.get(indx);
                if (token_type[indx][0].equals("Number")){
                    input = "digit";
                }
                else if (token_type[indx][0].equals("Identifier")){
                    input = "id";
                }
                if (containNonTerminal(stack.peek() , table)){

                    Pair pair1 = new Pair(stack.peek() , input);
                    body = table.get(pair1);
                    action[0].add("output");
                    action[1].add(stack.pop());
                    body_tmp = body.split(" ");
                    for (int i =body_tmp.length-1  ; i >=0  ; i--){
                        stack.push(body_tmp[i]);
                    }
                    action[2].add(body_tmp);
                }
                else{
                    if (stack.peek().equals(input)){
                        action[0].add("match");
                        action[1].add(input);
                        action[2].add("");
                        stack.pop();
                        indx++;
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
