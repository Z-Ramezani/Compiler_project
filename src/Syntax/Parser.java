package Syntax;

import Semantic.SemanticAnalysis;
import javafx.util.Pair;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;


public class Parser {

    ArrayList[] action = new ArrayList[3];
    JFrame f;
    Stack<String> match = new Stack<String>();
    Tree<String> parseTree = new Tree<String>("Main-Stmt");
    Tree<String> subTree = new Tree<String>("=");
    public void parsing (ArrayList<String> tokens , HashMap<Pair<String , String>, String> table , String[][] token_type){
        Boolean Error=true;
        f=new JFrame();
        action[0] = new ArrayList<String>();
        action[1] = new ArrayList<String>();
        action[2] = new ArrayList<String[]>();

        DefaultMutableTreeNode parent1=new DefaultMutableTreeNode("Main-Stmt");
        Stack <Tree.Node<String>> stack = new Stack<Tree.Node<String>>();
        Stack <DefaultMutableTreeNode> stack1 = new Stack<DefaultMutableTreeNode>();

        stack.push(parseTree.getRoot());
        stack1.push(parent1);

        String body = "" , input = "";
        String[] body_tmp;
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
                if (containNonTerminal(stack.peek().getData() , table)) {

                    Pair pair1 = new Pair(stack.peek().getData(), input);
                    body = table.get(pair1);
                    if (body == null) {
                        System.out.println("Syntax Error");
                        return;
                    } else {
                        if (!body.equals("e")) {
                            action[0].add("output");
                            action[1].add(stack.peek().getData());
                            body_tmp = body.split(" ");
                            ArrayList<Tree.Node<String>> children = new ArrayList<Tree.Node<String>>();
                            ArrayList<DefaultMutableTreeNode> children1 = new ArrayList<DefaultMutableTreeNode>();
                            for (int i = 0; i < body_tmp.length; i++) {
                                Tree.Node<String> child = new Tree.Node<String>();
                                child.setParent(stack.peek());
                                child.setData(body_tmp[i]);
                                children.add(child);
                                DefaultMutableTreeNode child1 = new DefaultMutableTreeNode(body_tmp[i]);
                                children1.add(child1);
                            }
                            stack.peek().setChildren(children);
                            for (DefaultMutableTreeNode j : children1) {
                                stack1.peek().add(j);
                            }
                            Tree.Node<String> parent = stack.pop();
                            stack1.pop();
                            for (int i = body_tmp.length - 1; i >= 0; i--) {
                                stack.push(parent.getChildren().get(i));
                                stack1.push(children1.get(i));
                            }
                            action[2].add(body_tmp);
                        } else {
                            stack.pop();
                            stack1.pop();
                        }
                    }
                }
                else{
                    if (stack.peek().getData().equals(input)){
                        action[0].add("match");
                        action[1].add(input);
                        action[2].add("");
                        stack.pop();
                        stack1.pop();
                        indx++;
                    }
                }
            }
            else {
                stack.pop();
            }
        }
        for (String i:tokens) {
            match.push(i);
        }

        JTree jt=new JTree(parent1);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane jScrollPane = new JScrollPane(jt);
        f.add(jScrollPane);
        //f.add(jt);
        f.setSize(500,500);
        f.setVisible(true);

        createParseTree(match);
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
    public void createParseTree(Stack<String> match) {

        Stack<String> matched = new Stack<String>();
        while (!match.isEmpty()){
            matched.push(match.pop());
        }


        while (!matched.isEmpty()) {

            String pop = matched.pop();
            if (!matched.isEmpty()) {
                if (matched.peek().equals("=")) {


                    Tree.Node<String> child = new Tree.Node<String>();

                    child.setData(pop);
                    child.setParent(subTree.getRoot());
                    ArrayList<Tree.Node<String>> children = new ArrayList<Tree.Node<String>>();
                    children.add(child);
                    subTree.getRoot().setChildren(children);
                    matched.pop();
                    subTree.setRoot(findChildren(subTree.getRoot(), matched));
                    SemanticAnalysis semanticAnalysis = new SemanticAnalysis();
                    semanticAnalysis.checkError(subTree);
                }
            }
        }
    }

    private Tree.Node<String> findChildren(Tree.Node<String> root, Stack<String> matched) {
        String pop = matched.pop();
        if (matched.peek().equals("+") || matched.peek().equals("-") || matched.peek().equals("*") ||
                matched.peek().equals("%") || matched.peek().equals("/") ){

            Tree.Node<String> parent = new Tree.Node<String>();
            parent.setData(matched.pop());
            parent.setParent(root);
            root.getChildren().add(parent);

            Tree.Node<String> child = new Tree.Node<String>();
            child.setData(pop);
            //child.setParent(parent);
            ArrayList<Tree.Node<String>> children=new ArrayList<Tree.Node<String>>();
            children.add(child);
            parent.setChildren(children);

            root=findChildren(parent , matched);
        }
        else {
            if (matched.peek().equals(";")){
                Tree.Node<String> child = new Tree.Node<String>();
                child.setData(pop);
                //child.setParent(root);
                root.getChildren().add(child);
                matched.pop();
                return root;
            }
        }
        return root;
    }
}

