package google.com;

import javax.swing.*;
import java.io.File;
import java.util.HashSet;

public class Main {

    static HashSet<Character> operator = new HashSet<Character>();
    static HashSet<String> keyword = new HashSet<String>();
    static HashSet<Character> letter = new HashSet<Character>();
    static HashSet<Character> digit = new HashSet<Character>();
    static HashSet<Integer> final_token = new HashSet<Integer>();
    static int[][] dfa_state = new int[70][70];

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

    static void setFinal_token() {
        final_token.add(4); final_token.add(7); final_token.add(9); final_token.add(13);
        final_token.add(17); final_token.add(20); final_token.add(23); final_token.add(28);
        final_token.add(29); final_token.add(31); final_token.add(33); final_token.add(36);
        final_token.add(39); final_token.add(42); final_token.add(44); final_token.add(46);
        final_token.add(48); final_token.add(50); final_token.add(52); final_token.add(54);
        final_token.add(56); final_token.add(59); final_token.add(62); final_token.add(65);
        final_token.add(69); final_token.add(70);
    }

    static void setDfa_state() { // F = -1 , N = -2
        //state0
        dfa_state[0][0] = 8; dfa_state[0][1] = 1; dfa_state[0][2] = 5; dfa_state[0][3] = 10; dfa_state[0][4] = 14;
        dfa_state[0][5] = 18; dfa_state[0][6] = 21; dfa_state[0][7] = 24; dfa_state[0][8] = 45; dfa_state[0][9] = 43;
        dfa_state[0][10] = 49; dfa_state[0][11] = 47; dfa_state[0][12] = 37; dfa_state[0][13] = 40; dfa_state[0][14] = -2;
        dfa_state[0][15] = 51; dfa_state[0][16] = 53; dfa_state[0][17] = 57; dfa_state[0][18] = 60; dfa_state[0][19] = 63;
        dfa_state[0][20] = 34; dfa_state[0][21] = -2; dfa_state[0][22] = 66; dfa_state[0][23] = 68; dfa_state[0][24] = 8;

        //state1
        dfa_state[1][0] = 4; dfa_state[1][1] = 1; dfa_state[1][2] = 70; dfa_state[1][3] = 4; dfa_state[1][4] = 4;
        dfa_state[1][5] = 4; dfa_state[1][6] = 4; dfa_state[1][7] = 4; dfa_state[1][8] = 4; dfa_state[1][9] = 4;
        dfa_state[1][10] = 4; dfa_state[1][11] = 4; dfa_state[1][12] = 4; dfa_state[1][13] = 4; dfa_state[1][14] = 2;
        dfa_state[1][15] = 4; dfa_state[1][16] = 4; dfa_state[1][17] = 4; dfa_state[1][18] = 4; dfa_state[1][19] = 4;
        dfa_state[1][20] = 4; dfa_state[1][21] = 70; dfa_state[1][22] = 70; dfa_state[1][23] = 70; dfa_state[1][24] = 4;

        //state2
        dfa_state[2][0] = 70; dfa_state[2][1] = 3; dfa_state[2][2] = 70; dfa_state[2][3] = 70; dfa_state[2][4] = 70;
        dfa_state[2][5] = 70; dfa_state[2][6] = 70; dfa_state[2][7] = 70; dfa_state[2][8] = 70; dfa_state[2][9] = 70;
        dfa_state[2][10] = 70; dfa_state[2][11] = 70; dfa_state[2][12] = 70; dfa_state[2][13] = 70; dfa_state[2][14] = 70;
        dfa_state[2][15] = 70; dfa_state[2][16] = 70; dfa_state[2][17] = 70; dfa_state[2][18] = 70; dfa_state[2][19] = 70;
        dfa_state[2][20] = 70; dfa_state[2][21] = 70; dfa_state[2][22] = 70; dfa_state[2][23] = 70; dfa_state[2][24] = 4;

        //state3
        dfa_state[3][0] = 4; dfa_state[3][1] = 3; dfa_state[3][2] = 70; dfa_state[3][3] = 70; dfa_state[3][4] = 70;
        dfa_state[3][5] = 70; dfa_state[3][6] = 70; dfa_state[3][7] = 70; dfa_state[3][8] = 70; dfa_state[3][9] = 70;
        dfa_state[3][10] = 70; dfa_state[3][11] = 70; dfa_state[3][12] = 70; dfa_state[3][13] = 70; dfa_state[3][14] = 70;
        dfa_state[3][15] = 70; dfa_state[3][16] = 70; dfa_state[3][17] = 70; dfa_state[3][18] = 70; dfa_state[3][19] = 70;
        dfa_state[3][20] = 70; dfa_state[3][21] = 70; dfa_state[3][22] = 70; dfa_state[3][23] = 70; dfa_state[3][24] = 4;

        //state4
        dfa_state[4][0] = -1; dfa_state[4][1] = -1; dfa_state[4][2] = -1; dfa_state[4][3] = -1; dfa_state[4][4] = -1;
        dfa_state[4][5] = -1; dfa_state[4][6] = -1; dfa_state[4][7] = -1; dfa_state[4][8] = -1; dfa_state[4][9] = -1;
        dfa_state[4][10] = -1; dfa_state[4][11] = -1; dfa_state[4][12] = -1; dfa_state[4][13] = -1; dfa_state[4][14] = -1;
        dfa_state[4][15] = -1; dfa_state[4][16] = -1; dfa_state[4][17] = -1; dfa_state[4][18] = -1; dfa_state[4][19] = -1;
        dfa_state[4][20] = -1; dfa_state[4][21] = -1; dfa_state[4][22] = -1; dfa_state[4][23] = -1; dfa_state[4][24] = -1;

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
