package Syntax;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.*;
import java.util.Iterator;

public class ParseTree {
    JFrame f;
     void LevelOrderTraversal(Tree.Node<String> root) {
        f=new JFrame();
        if (root == null)
            return;

        // Standard level order traversal code
        // using queue
        Queue<Tree.Node<String>> q = new LinkedList(); // Create a queue
        Queue<Tree.Node<String>> q2 = new LinkedList(); // Create a queue
        q.add(root); // Enqueue root
        while (!q.isEmpty()) {
            int n = q.size();

            // If this node has children
            while (n > 0) {

                Tree.Node<String> p = q.peek();
                q.remove();
                q2.add(p);
                // Enqueue all children of
                // the dequeued item
                for (int i = 0; i < p.getChildren().size(); i++)
                    q.add(p.getChildren().get(i));
                n--;
            }
        }
         DefaultMutableTreeNode root1 =new DefaultMutableTreeNode(q2.peek().getData());
        int t = q2.remove().getChildren().size();
        while ( t != 0 ){
            DefaultMutableTreeNode child=new DefaultMutableTreeNode("Style");
        }
    }
    public void showTree(Tree<String> parse_tree){


        DefaultMutableTreeNode style=new DefaultMutableTreeNode("Style");
        DefaultMutableTreeNode color=new DefaultMutableTreeNode("color");
        DefaultMutableTreeNode font=new DefaultMutableTreeNode("font");
        style.add(color);
        style.add(font);
        DefaultMutableTreeNode red=new DefaultMutableTreeNode("red");
        DefaultMutableTreeNode blue=new DefaultMutableTreeNode("blue");
        DefaultMutableTreeNode black=new DefaultMutableTreeNode("black");
        DefaultMutableTreeNode green=new DefaultMutableTreeNode("green");
        color.add(red); color.add(blue); color.add(black); color.add(green);
        JTree jt=new JTree(style);
        f.add(jt);
        f.setSize(200,200);
        f.setVisible(true);
    }
}

class Tree<T>  {
    private Node<T> root;

    public Tree(T rootData) {
        root = new Node<T>();
        root.data = rootData;
        root.children = new ArrayList<Node<T>>();
    }

    public Node<T> getRoot() {
        return root;
    }


    public static class Node<T> {
        private T data;
        private Node<T> parent;
        private ArrayList<Node<T>> children;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public ArrayList<Node<T>> getChildren() {
            return children;
        }

        public void setChildren(ArrayList<Node<T>> children) {
            this.children = children;
        }
    }
}
