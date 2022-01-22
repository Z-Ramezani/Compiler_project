package Semantic;
import Syntax.*;

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
            if (root.getChildren().get(1).getChildren() == null){
                leaf.add(root.getChildren().get(1).getData());
                root= root.getChildren().get(0);
            }

        }
        /////// continue from here
    }

}
