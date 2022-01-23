package Semantic;
import Syntax.*;
import google.com.Main;
import google.com.SymbolTable;

import java.util.ArrayList;
import java.util.Arrays;


public class SemanticAnalysis {
    //ArrayList<String> operators = new ArrayList<String>(Arrays.asList("=","+","-","*","%" ,"/"));

    public void checkError(Tree<String> tree){
        Tree.Node<String> root = new Tree.Node<String>();
        root = tree.getRoot();
        while (root.getParent() != null){
            root = root.getParent();
        }

        ArrayList<String> leaf = new ArrayList<String>();
        while (root.getChildren() != null){

            if (root.getChildren().get(0).getChildren()==null){
                leaf.add(root.getChildren().get(0).getData());
                root = root.getChildren().get(1);
            }
            if (root.getChildren()!=null && root.getChildren().get(1).getChildren() == null){
                leaf.add(root.getChildren().get(1).getData());
                root= root.getChildren().get(0);
            }
            else if (root.getChildren() == null){
                leaf.add(root.getData());
            }

        }

        if (hasInteger(leaf)){
            if (hasFloatOrDouble(leaf)){
                System.out.println("Error");
            }
            if (hasCharacter(leaf)){
                System.out.println("Error");
            }
            if (hasId(leaf)){
                for (String i:leaf) {
                    if (Main.letter.contains(i)){
                        for (int j = 0; j < Main.symbolTable.symbol_table.size(); j++) {
                            if (Main.symbolTable.symbol_table.get(j).get(2).equals(i)){
                                if (!Main.symbolTable.symbol_table.get(j).get(1).equals("int")){
                                    System.out.println("Error");
                                }
                            }
                        }
                    }
                }

            }
        }

        else {
            int tempFloat = 0;
            int tempDouble = 0;

            if (hasFloatOrDouble(leaf)) {
                if (hasInteger(leaf)) {
                    System.out.println("Error");
                }
                if (hasCharacter(leaf)) {
                    System.out.println("Error");
                }
                if (hasId(leaf)) {
                    for (String i : leaf) {
                        if (Main.letter.contains(i)) {
                            for (int j = 0; j < Main.symbolTable.symbol_table.size(); j++) {
                                if (Main.symbolTable.symbol_table.get(j).get(2).equals(i)) {

                                    if (Main.symbolTable.symbol_table.get(j).get(1).equals("float")) {
                                        if (tempDouble != 1) {
                                            tempFloat = 1;
                                        } else System.out.println("Error");
                                    }
                                    if (!Main.symbolTable.symbol_table.get(j).get(1).equals("float")) {
                                        if (Main.symbolTable.symbol_table.get(j).get(1).equals("double")) {
                                            if (tempFloat != 1) {
                                                tempDouble = 1;
                                            } else System.out.println("Error");
                                        } else System.out.println("Error");
                                    }

                                }
                            }
                        }
                    }

                }
            }
            else {
                if (hasCharacter(leaf)){
                    if (hasFloatOrDouble(leaf)){
                        System.out.println("Error");
                    }
                    if (hasInteger(leaf)){
                        System.out.println("Error");
                    }
                    if (hasId(leaf)){
                        for (String i:leaf) {
                            if (Main.letter.contains(i)){
                                for (int j = 0; j < Main.symbolTable.symbol_table.size(); j++) {
                                    if (Main.symbolTable.symbol_table.get(j).get(2).equals(i)){
                                        if (!Main.symbolTable.symbol_table.get(j).get(1).equals("char")){
                                            System.out.println("Error");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                else {
                    ArrayList<String> type = new ArrayList<String>();
                    for (String i:leaf) {
                        for (int j = 0; j < Main.symbolTable.symbol_table.size(); j++) {
                            if (Main.symbolTable.symbol_table.get(j).get(2).equals(i)){
                                type.add(Main.symbolTable.symbol_table.get(j).get(1));
                            }
                        }
                    }
                    for (String i:type) {
                        for (int j = 1; j < type.size(); j++) {
                            if (!i.equals(type.get(j))){
                                System.out.println("Error");
                            }
                        }
                    }
                }
            }
        }


    }
    public boolean hasInteger(ArrayList<String> leaf){
        for (String i:leaf) {
            if (i.contains("0") || i.contains("1") || i.contains("2") ||i.contains("3") ||
                    i.contains("4") ||i.contains("5") ||i.contains("6") ||i.contains("7") ||i.contains("8") || i.contains("9")){
                if (!i.contains(".")){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasFloatOrDouble(ArrayList<String> leaf){
        for (String i:leaf) {
            if (i.contains("0") || i.contains("1") || i.contains("2") ||i.contains("3") ||
                    i.contains("4") ||i.contains("5") ||i.contains("6") ||i.contains("7") ||i.contains("8") || i.contains("9")){
                if (i.contains(".")){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasId(ArrayList<String> leaf){
        for (String i:leaf) {
            if (Main.letter.contains(i)){
                if (!i.contains("'")){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasCharacter(ArrayList<String> leaf){
        for (String i:leaf) {
            if (i.contains("'")){
                return true;
           }
        }
        return false;
    }
}
