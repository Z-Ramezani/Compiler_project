package google.com;

import javax.swing.*;
import java.io.File;
import java.util.HashSet;

public class Main {

    static HashSet<Character> operator = new HashSet<Character>();
    static HashSet<String> keyword = new HashSet<String>();
    static HashSet<Character> letter = new HashSet<Character>();
    static HashSet<Character> digit = new HashSet<Character>();

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

    static void setLetter(HashSet<Character> letter) {
        letter.add('a');letter.add('b');letter.add('c');letter.add('d');letter.add('e');
        letter.add('f');letter.add('g');letter.add('h');letter.add('i');letter.add('j');
        letter.add('k');letter.add('l');letter.add('m');letter.add('n');letter.add('o');
        letter.add('p');letter.add('q');letter.add('r');letter.add('s');letter.add('t');
        letter.add('u');letter.add('v');letter.add('w');letter.add('x');letter.add('y');
        letter.add('z');

        letter.add('A');letter.add('B');letter.add('C');letter.add('D');letter.add('E');
        letter.add('F');letter.add('G');letter.add('H');letter.add('I');letter.add('J');
        letter.add('K');letter.add('L');letter.add('M');letter.add('N');letter.add('O');
        letter.add('P');letter.add('Q');letter.add('R');letter.add('S');letter.add('T');
        letter.add('U');letter.add('V');letter.add('W');letter.add('X');letter.add('Y');
        letter.add('Z');
    }

    static void setDigit(HashSet<Character> digit) {
        digit.add('0');  digit.add('1'); digit.add('2'); digit.add('3'); digit.add('4');
        digit.add('5');  digit.add('6'); digit.add('7'); digit.add('8'); digit.add('9');
    }

    static void setOperator(HashSet<Character> operator){
        operator.add('('); operator.add(')'); operator.add('{'); operator.add('}');
        operator.add('<'); operator.add('>'); operator.add('['); operator.add(']');
        operator.add('+'); operator.add('_'); operator.add('*'); operator.add('/');
        operator.add('%'); operator.add('='); operator.add('!'); operator.add('?');
        operator.add('&'); operator.add('|'); operator.add(':'); operator.add(',');
    }
    static void setKey(HashSet<String> key){
        key.add("if");     key.add("else");     key.add("while");    key.add("switch");
        key.add("int");    key.add("long");     key.add("double");   key.add("float");
        key.add("return"); key.add("break");    key.add("for");      key.add("short");
        key.add("char");   key.add("const");    key.add("continue"); key.add("default");
        key.add("do");     key.add("register"); key.add("signed");   key.add("sizeof");
        key.add("case");   key.add("static");   key.add("struct");   key.add("typedef");
        key.add("union");  key.add("unsigned"); key.add("extern");   key.add("enum");
        key.add("goto");   key.add("auto");     key.add("void");     key.add("main");
    }


    public static void main(String[] args) {
        File a = getDataFolderFromSystem();
        Extractor EX = new Extractor();
        setLetter(letter);
        setDigit(digit);
        setKey(keyword);
        setOperator(operator);
        }

    }
