package google.com;

import javax.swing.*;
import java.io.File;
import java.util.HashSet;

public class Main {
    static HashSet number = new HashSet();
    static HashSet id = new HashSet();
    static HashSet operator = new HashSet();
    static HashSet keyword = new HashSet();
   static HashSet letter = new HashSet();
    static HashSet digit = new HashSet();
    private static File getDataFolderFromSystem() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDragEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int choice = chooser.showOpenDialog(null);
        if (choice != JFileChooser.APPROVE_OPTION) {
            System.out.println("File not selected");
        }
        return chooser.getSelectedFile();

    }
    static void set_letter(HashSet letter){
        letter.add("a");letter.add("b");letter.add("c");letter.add("d");letter.add("e");
        letter.add("f");letter.add("g");letter.add("h");letter.add("i");letter.add("j");
        letter.add("k");letter.add("l");letter.add("m");letter.add("n");letter.add("o");
        letter.add("p");letter.add("q");letter.add("r");letter.add("s");letter.add("t");
        letter.add("u");letter.add("v");letter.add("w");letter.add("x");letter.add("y");letter.add("z");

        letter.add("A");letter.add("B");letter.add("C");letter.add("D");letter.add("E");
        letter.add("F");letter.add("G");letter.add("H");letter.add("I");letter.add("J");
        letter.add("K");letter.add("L");letter.add("M");letter.add("N");letter.add("O");
        letter.add("P");letter.add("Q");letter.add("R");letter.add("S");letter.add("T");
        letter.add("U");letter.add("V");letter.add("W");letter.add("X");letter.add("Y");letter.add("Z");
    }
    static void set_digit(HashSet digit){
        digit.add(0);  digit.add(1); digit.add(2); digit.add(3); digit.add(4);
        digit.add(5); digit.add(6); digit.add(7); digit.add(8); digit.add(9);
    }
    static void set_num(HashSet Num){
        for (int i=0;i<100;i++)
            Num.add(i);
    }
    static void set_id(HashSet id){
    }
    static void set_oper(HashSet Oper){}
    static void set_key(HashSet key ){}


    public static void main(String[] args) {
        File a = getDataFolderFromSystem();
        Extractor EX=new Extractor();
        set_letter(letter);
        set_digit(digit);
        set_num(number);
        set_id(id);
        set_key(keyword);
        set_oper(operator);
        }

    }
