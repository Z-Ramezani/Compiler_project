package Syntax;

import java.util.ArrayList;

public class ParseTree {

    Tree<String> parse_tree = new Tree<String>("Main-Stmt");

    public void Tree (ArrayList<String>[] action) {
        int i = 0;
        for (String out_mac: action[0]) {
            if (out_mac.equals("output")) {

            }
            i++;
        }
    }
}

class Tree<T> {
    private Node<T> root;

    public Tree(T rootData) {
        root = new Node<T>();
        root.data = rootData;
        root.children = new ArrayList<Node<T>>();
    }

    public static class Node<T> {
        private T data;
        private Node<T> parent;
        private ArrayList<Node<T>> children;
    }
}
