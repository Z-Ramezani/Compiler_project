package google.com;
///debug
import javax.swing.*;
import java.io.File;
import java.util.HashSet;


public class Main {

    static HashSet<String> operator = new HashSet<String>();
    static HashSet<String> letter = new HashSet<String>();
    static HashSet<String> digit = new HashSet<String>();
    public static HashSet<String> keyword = new HashSet<String>();
    public static HashSet<String> keyword_type = new HashSet<String>();
    public static HashSet<String> keyword_no_type = new HashSet<String>();
    static HashSet<Integer> final_state = new HashSet<Integer>();
    static int[][] dfa_state = new int[71][25];
    static SymbolTable symbolTable = new SymbolTable();
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

    static void setLetter(HashSet<String> letter) {
        letter.add("a");letter.add("b");letter.add("c");letter.add("d");letter.add("e");
        letter.add("f");letter.add("g");letter.add("h");letter.add("i");letter.add("j");
        letter.add("k");letter.add("l");letter.add("m");letter.add("n");letter.add("o");
        letter.add("p");letter.add("q");letter.add("r");letter.add("s");letter.add("t");
        letter.add("u");letter.add("v");letter.add("w");letter.add("x");letter.add("y");
        letter.add("z");

        letter.add("A");letter.add("B");letter.add("C");letter.add("D");letter.add("E");
        letter.add("F");letter.add("G");letter.add("H");letter.add("I");letter.add("J");
        letter.add("K");letter.add("L");letter.add("M");letter.add("N");letter.add("O");
        letter.add("P");letter.add("Q");letter.add("R");letter.add("S");letter.add("T");
        letter.add("U");letter.add("V");letter.add("W");letter.add("X");letter.add("Y");
        letter.add("Z");
    }
    static void setDigit(HashSet<String> digit) {
        digit.add("0");  digit.add("1"); digit.add("2"); digit.add("3"); digit.add("4");
        digit.add("5");  digit.add("6"); digit.add("7"); digit.add("8"); digit.add("9");
    }
    static void setOperator(HashSet<String> operator){
        operator.add("("); operator.add(")"); operator.add("{"); operator.add("}");
        operator.add("<"); operator.add(">"); operator.add("["); operator.add("]");
        operator.add("+"); operator.add("_"); operator.add("*"); operator.add("/");
        operator.add("%"); operator.add("="); operator.add("!"); operator.add("?");
        operator.add("&"); operator.add("|"); operator.add(":"); operator.add(",");
        operator.add(";");
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
    static void setKeyword_type(HashSet<String> key){
        key.add("int");    key.add("long");     key.add("double");   key.add("float");
        key.add("short");   key.add("char");
    }
    static void setKeyword_no_type(HashSet<String> key){
        key.add("if");     key.add("else");     key.add("while");    key.add("switch");
        key.add("return"); key.add("break");    key.add("for");
        key.add("const");    key.add("continue"); key.add("default");
        key.add("do");     key.add("register"); key.add("signed");   key.add("sizeof");
        key.add("case");   key.add("static");   key.add("struct");   key.add("typedef");
        key.add("union");  key.add("unsigned"); key.add("extern");   key.add("enum");
        key.add("goto");   key.add("auto");     key.add("void");     key.add("main");
    }
    static void setFinal_token() {
        final_state.add(4); final_state.add(7); final_state.add(9); final_state.add(13);
        final_state.add(17); final_state.add(20); final_state.add(23); final_state.add(28);
        final_state.add(29); final_state.add(31); final_state.add(33); final_state.add(36);
        final_state.add(39); final_state.add(42); final_state.add(44); final_state.add(46);
        final_state.add(48); final_state.add(50); final_state.add(52); final_state.add(54);
        final_state.add(56); final_state.add(59); final_state.add(62); final_state.add(65);
        final_state.add(69); final_state.add(70);
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

        //state5
        dfa_state[5][0] = 7; dfa_state[5][1] = 6; dfa_state[5][2] = 5; dfa_state[5][3] = 7; dfa_state[5][4] = 7;
        dfa_state[5][5] = 7; dfa_state[5][6] = 7; dfa_state[5][7] = 7; dfa_state[5][8] = 7; dfa_state[5][9] = 7;
        dfa_state[5][10] = 7; dfa_state[5][11] = 7; dfa_state[5][12] = 7; dfa_state[5][13] = 7; dfa_state[5][14] = 70;
        dfa_state[5][15] = 7; dfa_state[5][16] = 7; dfa_state[5][17] = 7; dfa_state[5][18] = 7; dfa_state[5][19] = 7;
        dfa_state[5][20] = 7; dfa_state[5][21] = 5; dfa_state[5][22] = 70 ; dfa_state[5][23] = 70; dfa_state[5][24] = 7;

        //state6
        dfa_state[6][0] = 7; dfa_state[6][1] = 6; dfa_state[6][2] = 5; dfa_state[6][3] = 7; dfa_state[6][4] = 7;
        dfa_state[6][5] = 7; dfa_state[6][6] = 7; dfa_state[6][7] = 7; dfa_state[6][8] = 7; dfa_state[6][9] = 7;
        dfa_state[6][10] = 7; dfa_state[6][11] = 7; dfa_state[6][12] = 7; dfa_state[6][13] = 7; dfa_state[6][14] = 70;
        dfa_state[6][15] = 7; dfa_state[6][16] = 7; dfa_state[6][17] = 7; dfa_state[6][18] = 7; dfa_state[6][19] = 7;
        dfa_state[6][20] = 7; dfa_state[6][21] = 5; dfa_state[6][22] = 70; dfa_state[6][23] = 70; dfa_state[6][24] = 7;

        //state7
        dfa_state[7][0] = -1; dfa_state[7][1] = -1; dfa_state[7][2] = -1; dfa_state[7][3] = -1; dfa_state[7][4] = -1;
        dfa_state[7][5] = -1; dfa_state[7][6] = -1; dfa_state[7][7] = -1; dfa_state[7][8] = -1; dfa_state[7][9] = -1;
        dfa_state[7][10] = -1; dfa_state[7][11] = -1; dfa_state[7][12] = -1; dfa_state[7][13] = -1; dfa_state[7][14] = -1;
        dfa_state[7][15] = -1; dfa_state[7][16] = -1; dfa_state[7][17] = -1; dfa_state[7][18] = -1; dfa_state[7][19] = -1;
        dfa_state[7][20] = -1; dfa_state[7][21] = -1; dfa_state[7][22] = -1; dfa_state[7][23] = -1; dfa_state[7][24] = -1;

        //state8
        dfa_state[8][0] = 8; dfa_state[8][1] = 9; dfa_state[8][2] = 9; dfa_state[8][3] = 9; dfa_state[8][4] = 9;
        dfa_state[8][5] = 9; dfa_state[8][6] = 9; dfa_state[8][7] = 9; dfa_state[8][8] = 9; dfa_state[8][9] = 9;
        dfa_state[8][10] = 9; dfa_state[8][11] = 9; dfa_state[8][12] = 9; dfa_state[8][13] = 9; dfa_state[8][14] = 9;
        dfa_state[8][15] = 9; dfa_state[8][16] = 9; dfa_state[8][17] = 9; dfa_state[8][18] = 9; dfa_state[8][19] = 9;
        dfa_state[8][20] = 9; dfa_state[8][21] = 9; dfa_state[8][22] = 9; dfa_state[8][23] = 9; dfa_state[8][24] = 8;

        //state9
        dfa_state[9][0] = -1; dfa_state[9][1] = -1; dfa_state[9][2] = -1; dfa_state[9][3] = -1; dfa_state[9][4] = -1;
        dfa_state[9][5] = -1; dfa_state[9][6] = -1; dfa_state[9][7] = -1; dfa_state[9][8] = -1; dfa_state[9][9] = -1;
        dfa_state[9][10] = -1; dfa_state[9][11] = -1; dfa_state[9][12] = -1; dfa_state[9][13] = -1; dfa_state[9][14] = -1;
        dfa_state[9][15] = -1; dfa_state[9][16] = -1; dfa_state[9][17] = -1; dfa_state[9][18] = -1; dfa_state[9][19] = -1;
        dfa_state[9][20] = -1; dfa_state[9][21] = -1; dfa_state[9][22] = -1; dfa_state[9][23] = -1; dfa_state[9][24] = -1;

        //state10
        dfa_state[10][0] = 13; dfa_state[10][1] = 13; dfa_state[10][2] = 13; dfa_state[10][3] = 11; dfa_state[10][4] = 70;
        dfa_state[10][5] = 12; dfa_state[10][6] = 70; dfa_state[10][7] = 70; dfa_state[10][8] = 70; dfa_state[10][9] = 13;
        dfa_state[10][10] = 70; dfa_state[10][11] = 70; dfa_state[10][12] = 70; dfa_state[10][13] = 70; dfa_state[10][14] = 70;
        dfa_state[10][15] = 70; dfa_state[10][16] = 70; dfa_state[10][17] = 70; dfa_state[10][18] = 70; dfa_state[10][19] = 70;
        dfa_state[10][20] = 70; dfa_state[10][21] = 70; dfa_state[10][22] = 70; dfa_state[10][23] = 70; dfa_state[10][24] = 13;

        //state11
        dfa_state[11][0] = 13; dfa_state[11][1] = 70; dfa_state[11][2] = 13; dfa_state[11][3] = 70; dfa_state[11][4] = 70;
        dfa_state[11][5] = 13; dfa_state[11][6] = 13; dfa_state[11][7] = 13; dfa_state[11][8] = 13; dfa_state[11][9] = 70;
        dfa_state[11][10] = 70; dfa_state[11][11] = 70; dfa_state[11][12] = 13; dfa_state[11][13] = 13; dfa_state[11][14] = 70;
        dfa_state[11][15] = 13; dfa_state[11][16] = 70; dfa_state[11][17] = 70; dfa_state[11][18] = 13; dfa_state[11][19] = 13;
        dfa_state[11][20] = 13; dfa_state[11][21] = 13; dfa_state[11][22] = 70; dfa_state[11][23] = 70; dfa_state[11][24] = 13;

        //state12
        dfa_state[12][0] = 13; dfa_state[12][1] = 13; dfa_state[12][2] = 13; dfa_state[12][3] = 70; dfa_state[12][4] = 70;
        dfa_state[12][5] = 70; dfa_state[12][6] = 70; dfa_state[12][7] = 70; dfa_state[12][8] = 70; dfa_state[12][9] = 13;
        dfa_state[12][10] = 70; dfa_state[12][11] = 70; dfa_state[12][12] = 70; dfa_state[12][13] = 70; dfa_state[12][14] = 70;
        dfa_state[12][15] = 70; dfa_state[12][16] = 70; dfa_state[12][17] = 70; dfa_state[12][18] = 70; dfa_state[12][19] = 70;
        dfa_state[12][20] = 70; dfa_state[12][21] = 70; dfa_state[12][22] = 70; dfa_state[12][23] = 70; dfa_state[12][24] = 13;

        //state13
        dfa_state[13][0] = -1; dfa_state[13][1] = -1; dfa_state[13][2] = -1; dfa_state[13][3] = -1; dfa_state[13][4] = -1;
        dfa_state[13][5] = -1; dfa_state[13][6] = -1; dfa_state[13][7] = -1; dfa_state[13][8] = -1; dfa_state[13][9] = -1;
        dfa_state[13][10] = -1; dfa_state[13][11] = -1; dfa_state[13][12] = -1; dfa_state[13][13] = -1; dfa_state[13][14] = -1;
        dfa_state[13][15] = -1; dfa_state[13][16] = -1; dfa_state[13][17] = -1; dfa_state[13][18] = -1; dfa_state[13][19] = -1;
        dfa_state[13][20] = -1; dfa_state[13][21] = -1; dfa_state[13][22] = -1; dfa_state[13][23] = -1; dfa_state[13][24] = -1;

        //state14
        dfa_state[14][0] = 17; dfa_state[14][1] = 17; dfa_state[14][2] = 17; dfa_state[14][3] = 15; dfa_state[14][4] = 70;
        dfa_state[14][5] = 16; dfa_state[14][6] = 70; dfa_state[14][7] = 70; dfa_state[14][8] = 70; dfa_state[14][9] = 17;
        dfa_state[14][10] = 70; dfa_state[14][11] = 70; dfa_state[14][12] = 70; dfa_state[14][13] = 70; dfa_state[14][14] = 70;
        dfa_state[14][15] = 17; dfa_state[14][16] = 17; dfa_state[14][17] = 17; dfa_state[14][18] = 17; dfa_state[14][19] = 17;
        dfa_state[14][20] = 17; dfa_state[14][21] = 17; dfa_state[14][22] = 70; dfa_state[14][23] = 70; dfa_state[14][24] = 17;

        //state15
        dfa_state[15][0] = 17; dfa_state[15][1] = 70; dfa_state[15][2] = 17; dfa_state[15][3] = 70; dfa_state[15][4] = 70;
        dfa_state[15][5] = 17; dfa_state[15][6] = 17; dfa_state[15][7] = 17; dfa_state[15][8] = 17; dfa_state[15][9] = 70;
        dfa_state[15][10] = 70; dfa_state[15][11] = 70; dfa_state[15][12] = 17; dfa_state[15][13] = 17; dfa_state[15][14] = 70;
        dfa_state[15][15] = 17; dfa_state[15][16] = 70; dfa_state[15][17] = 70; dfa_state[15][18] = 17; dfa_state[15][19] = 17;
        dfa_state[15][20] = 17; dfa_state[15][21] = 17; dfa_state[15][22] = 70; dfa_state[15][23] = 70; dfa_state[15][24] = 17;

        //state16
        dfa_state[16][0] = 17; dfa_state[16][1] = 17; dfa_state[16][2] = 17; dfa_state[16][3] = 70; dfa_state[16][4] = 70;
        dfa_state[16][5] = 70; dfa_state[16][6] = 70; dfa_state[16][7] = 70; dfa_state[16][8] = 70; dfa_state[16][9] = 17;
        dfa_state[16][10] = 70; dfa_state[16][11] = 70; dfa_state[16][12] = 70; dfa_state[16][13] = 70; dfa_state[16][14] = 70;
        dfa_state[16][15] = 70; dfa_state[16][16] = 70; dfa_state[16][17] = 70; dfa_state[16][18] = 70; dfa_state[16][19] = 70;
        dfa_state[16][20] = 70; dfa_state[16][21] = 70; dfa_state[16][22] = 70; dfa_state[16][23] = 70; dfa_state[16][24] = 17;

        //state17
        dfa_state[17][0] = -1; dfa_state[17][1] = -1; dfa_state[17][2] = -1; dfa_state[17][3] = -1; dfa_state[17][4] = -1;
        dfa_state[17][5] = -1; dfa_state[17][6] = -1; dfa_state[17][7] = -1; dfa_state[17][8] = -1; dfa_state[17][9] = -1;
        dfa_state[17][10] = -1; dfa_state[17][11] = -1; dfa_state[17][12] = -1; dfa_state[17][13] = -1; dfa_state[17][14] = -1;
        dfa_state[17][15] = -1; dfa_state[17][16] = -1; dfa_state[17][17] = -1; dfa_state[17][18] = -1; dfa_state[17][19] = -1;
        dfa_state[17][20] = -1; dfa_state[17][21] = -1; dfa_state[17][22] = -1; dfa_state[17][23] = -1; dfa_state[17][24] = -1;

        //state18
        dfa_state[18][0] = 20; dfa_state[18][1] = 20; dfa_state[18][2] = 20; dfa_state[18][3] = 70; dfa_state[18][4] = 70;
        dfa_state[18][5] = 19; dfa_state[18][6] = 20; dfa_state[18][7] = 70; dfa_state[18][8] = 70; dfa_state[18][9] = 20;
        dfa_state[18][10] = 70; dfa_state[18][11] = 70; dfa_state[18][12] = 70; dfa_state[18][13] = 70; dfa_state[18][14] = 70;
        dfa_state[18][15] = 70; dfa_state[18][16] = 70; dfa_state[18][17] = 70; dfa_state[18][18] = 70; dfa_state[18][19] = 70;
        dfa_state[18][20] = 70; dfa_state[18][21] = 70; dfa_state[18][22] = 20; dfa_state[18][23] = 20; dfa_state[18][24] = 20;

        //state19
        dfa_state[19][0] = 20; dfa_state[19][1] = 20; dfa_state[19][2] = 20; dfa_state[19][3] = 70; dfa_state[19][4] = 70;
        dfa_state[19][5] = 70; dfa_state[19][6] = 20; dfa_state[19][7] = 70; dfa_state[19][8] = 70; dfa_state[19][9] = 20;
        dfa_state[19][10] = 70; dfa_state[19][11] = 70; dfa_state[19][12] = 70; dfa_state[19][13] = 70; dfa_state[19][14] = 70;
        dfa_state[19][15] = 70; dfa_state[19][16] = 70; dfa_state[19][17] = 70; dfa_state[19][18] = 70; dfa_state[19][19] = 70;
        dfa_state[19][20] = 70; dfa_state[19][21] = 70; dfa_state[19][22] = 20; dfa_state[19][23] = 20; dfa_state[19][24] = 20;

        //state20
        dfa_state[20][0] = -1; dfa_state[20][1] = -1; dfa_state[20][2] = -1; dfa_state[20][3] = -1; dfa_state[20][4] = -1;
        dfa_state[20][5] = -1; dfa_state[20][6] = -1; dfa_state[20][7] = -1; dfa_state[20][8] = -1; dfa_state[20][9] = -1;
        dfa_state[20][10] = -1; dfa_state[20][11] = -1; dfa_state[20][12] = -1; dfa_state[20][13] = -1; dfa_state[20][14] = -1;
        dfa_state[20][15] = -1; dfa_state[20][16] = -1; dfa_state[20][17] = -1; dfa_state[20][18] = -1; dfa_state[20][19] = -1;
        dfa_state[20][20] = -1; dfa_state[20][21] = -1; dfa_state[20][22] = -1; dfa_state[20][23] = -1; dfa_state[20][24] = -1;

        //state21
        dfa_state[21][0] = 23; dfa_state[21][1] = 23; dfa_state[21][2] = 23; dfa_state[21][3] = 70; dfa_state[21][4] = 70;
        dfa_state[21][5] = 22; dfa_state[21][6] = 70; dfa_state[21][7] = 70; dfa_state[21][8] = 70; dfa_state[21][9] = 23;
        dfa_state[21][10] = 70; dfa_state[21][11] = 70; dfa_state[21][12] = 70; dfa_state[21][13] = 70; dfa_state[21][14] = 70;
        dfa_state[21][15] = 70; dfa_state[21][16] = 70; dfa_state[21][17] = 70; dfa_state[21][18] = 70; dfa_state[21][19] = 70;
        dfa_state[21][20] = 70; dfa_state[21][21] = 70; dfa_state[21][22] = 70; dfa_state[21][23] = 70; dfa_state[21][24] = 23;

        //state22
        dfa_state[22][0] = 23; dfa_state[22][1] = 23; dfa_state[22][2] = 23; dfa_state[22][3] = 70; dfa_state[22][4] = 70;
        dfa_state[22][5] = 70; dfa_state[22][6] = 70; dfa_state[22][7] = 70; dfa_state[22][8] = 70; dfa_state[22][9] = 23;
        dfa_state[22][10] = 70; dfa_state[22][11] = 70; dfa_state[22][12] = 70; dfa_state[22][13] = 70; dfa_state[22][14] = 70;
        dfa_state[22][15] = 70; dfa_state[22][16] = 70; dfa_state[22][17] = 70; dfa_state[22][18] = 70; dfa_state[22][19] = 70;
        dfa_state[22][20] = 70; dfa_state[22][21] = 70; dfa_state[22][22] = 23; dfa_state[22][23] = 23; dfa_state[22][24] = 23;

        //state23
        dfa_state[23][0] = -1; dfa_state[23][1] = -1; dfa_state[23][2] = -1; dfa_state[23][3] = -1; dfa_state[23][4] = -1;
        dfa_state[23][5] = -1; dfa_state[23][6] = -1; dfa_state[23][7] = -1; dfa_state[23][8] = -1; dfa_state[23][9] = -1;
        dfa_state[23][10] = -1; dfa_state[23][11] = -1; dfa_state[23][12] = -1; dfa_state[23][13] = -1; dfa_state[23][14] = -1;
        dfa_state[23][15] = -1; dfa_state[23][16] = -1; dfa_state[23][17] = -1; dfa_state[23][18] = -1; dfa_state[23][19] = -1;
        dfa_state[23][20] = -1; dfa_state[23][21] = -1; dfa_state[23][22] = -1; dfa_state[23][23] = -1; dfa_state[23][24] = -1;

        //state24
        dfa_state[24][0] = 29; dfa_state[24][1] = 29; dfa_state[24][2] = 29; dfa_state[24][3] = 70; dfa_state[24][4] = 70;
        dfa_state[24][5] = 30; dfa_state[24][6] = 70; dfa_state[24][7] = 32; dfa_state[24][8] = 70; dfa_state[24][9] = 29;
        dfa_state[24][10] = 70; dfa_state[24][11] = 70; dfa_state[24][12] = 70; dfa_state[24][13] = 70; dfa_state[24][14] = 70;
        dfa_state[24][15] = 70; dfa_state[24][16] = 70; dfa_state[24][17] = 70; dfa_state[24][18] = 70; dfa_state[24][19] = 70;
        dfa_state[24][20] = 25; dfa_state[24][21] = 70; dfa_state[24][22] = 70; dfa_state[24][23] = 70; dfa_state[24][24] = 29;

        //state25
        dfa_state[25][0] = 25; dfa_state[25][1] = 25; dfa_state[25][2] = 25; dfa_state[25][3] = 25; dfa_state[25][4] = 25;
        dfa_state[25][5] = 25; dfa_state[25][6] = 25; dfa_state[25][7] = 25; dfa_state[25][8] = 25; dfa_state[25][9] = 25;
        dfa_state[25][10] = 25; dfa_state[25][11] = 25; dfa_state[25][12] = 25; dfa_state[25][13] = 25; dfa_state[25][14] = 25;
        dfa_state[25][15] = 25; dfa_state[25][16] = 25; dfa_state[25][17] = 25; dfa_state[25][18] = 25; dfa_state[25][19] = 25;
        dfa_state[25][20] = 25; dfa_state[25][21] = 25; dfa_state[25][22] = 25; dfa_state[25][23] = 25; dfa_state[25][24] = 25;

        //state26
        dfa_state[26][0] = 25; dfa_state[26][1] = 25; dfa_state[26][2] = 25; dfa_state[26][3] = 25; dfa_state[26][4] = 25;
        dfa_state[26][5] = 25; dfa_state[26][6] = 25; dfa_state[26][7] = 27; dfa_state[26][8] = 25; dfa_state[26][9] = 25;
        dfa_state[26][10] = 25; dfa_state[26][11] = 25; dfa_state[26][12] = 25; dfa_state[26][13] = 25; dfa_state[26][14] = 25;
        dfa_state[26][15] = 25; dfa_state[26][16] = 25; dfa_state[26][17] = 25; dfa_state[26][18] = 25; dfa_state[26][19] = 25;
        dfa_state[26][20] = 26; dfa_state[26][21] = 25; dfa_state[26][22] = 25; dfa_state[26][23] = 25; dfa_state[26][24] = 25;

        //state27
        dfa_state[27][0] = 28; dfa_state[27][1] = 70; dfa_state[27][2] = 70; dfa_state[27][3] = 70; dfa_state[27][4] = 70;
        dfa_state[27][5] = 70; dfa_state[27][6] = 70; dfa_state[27][7] = 70; dfa_state[27][8] = 70; dfa_state[27][9] = 70;
        dfa_state[27][10] = 70; dfa_state[27][11] = 70; dfa_state[27][12] = 70; dfa_state[27][13] = 70; dfa_state[27][14] = 70;
        dfa_state[27][15] = 70; dfa_state[27][16] = 70; dfa_state[27][17] = 70; dfa_state[27][18] = 70; dfa_state[27][19] = 70;
        dfa_state[27][20] = 70; dfa_state[27][21] = 70; dfa_state[27][22] = 70; dfa_state[27][23] = 70; dfa_state[27][24] = 70;

        //state28
        dfa_state[28][0] = -1; dfa_state[28][1] = -1; dfa_state[28][2] = -1; dfa_state[28][3] = -1; dfa_state[28][4] = -1;
        dfa_state[28][5] = -1; dfa_state[28][6] = -1; dfa_state[28][7] = -1; dfa_state[28][8] = -1; dfa_state[28][9] = -1;
        dfa_state[28][10] = -1; dfa_state[28][11] = -1; dfa_state[28][12] = -1; dfa_state[28][13] = -1; dfa_state[28][14] = -1;
        dfa_state[28][15] = -1; dfa_state[28][16] = -1; dfa_state[28][17] = -1; dfa_state[28][18] = -1; dfa_state[28][19] = -1;
        dfa_state[28][20] = -1; dfa_state[28][21] = -1; dfa_state[28][22] = -1; dfa_state[28][23] = -1; dfa_state[28][24] = -1;

        //state29
        dfa_state[29][0] = -1; dfa_state[29][1] = -1; dfa_state[29][2] = -1; dfa_state[29][3] = -1; dfa_state[29][4] = -1;
        dfa_state[29][5] = -1; dfa_state[29][6] = -1; dfa_state[29][7] = -1; dfa_state[29][8] = -1; dfa_state[29][9] = -1;
        dfa_state[29][10] = -1; dfa_state[29][11] = -1; dfa_state[29][12] = -1; dfa_state[29][13] = -1; dfa_state[29][14] = -1;
        dfa_state[29][15] = -1; dfa_state[29][16] = -1; dfa_state[29][17] = -1; dfa_state[29][18] = -1; dfa_state[29][19] = -1;
        dfa_state[29][20] = -1; dfa_state[29][21] = -1; dfa_state[29][22] = -1; dfa_state[29][23] = -1; dfa_state[29][24] = -1;

        //state30
        dfa_state[30][0] = 31; dfa_state[30][1] = 31; dfa_state[30][2] = 31; dfa_state[30][3] = 70; dfa_state[30][4] = 70;
        dfa_state[30][5] = 70; dfa_state[30][6] = 70; dfa_state[30][7] = 70; dfa_state[30][8] = 70; dfa_state[30][9] = 31;
        dfa_state[30][10] = 70; dfa_state[30][11] = 70; dfa_state[30][12] = 70; dfa_state[30][13] = 70; dfa_state[30][14] = 70;
        dfa_state[30][15] = 70; dfa_state[30][16] = 70; dfa_state[30][17] = 70; dfa_state[30][18] = 70; dfa_state[30][19] = 70;
        dfa_state[30][20] = 70; dfa_state[30][21] = 70; dfa_state[30][22] = 70; dfa_state[30][23] = 70; dfa_state[30][24] = 31;

        //state31
        dfa_state[31][0] = -1; dfa_state[31][1] = -1; dfa_state[31][2] = -1; dfa_state[31][3] = -1; dfa_state[31][4] = -1;
        dfa_state[31][5] = -1; dfa_state[31][6] = -1; dfa_state[31][7] = -1; dfa_state[31][8] = -1; dfa_state[31][9] = -1;
        dfa_state[31][10] = -1; dfa_state[31][11] = -1; dfa_state[31][12] = -1; dfa_state[31][13] = -1; dfa_state[31][14] = -1;
        dfa_state[31][15] = -1; dfa_state[31][16] = -1; dfa_state[31][17] = -1; dfa_state[31][18] = -1; dfa_state[31][19] = -1;
        dfa_state[31][20] = -1; dfa_state[31][21] = -1; dfa_state[31][22] = -1; dfa_state[31][23] = -1; dfa_state[31][24] = -1;

        //state32
        dfa_state[32][0] = 33; dfa_state[32][1] = 33; dfa_state[32][2] = 33; dfa_state[32][3] = 33; dfa_state[32][4] = 33;
        dfa_state[32][5] = 33; dfa_state[32][6] = 33; dfa_state[32][7] = 33; dfa_state[32][8] = 33; dfa_state[32][9] = 33;
        dfa_state[32][10] = 33; dfa_state[32][11] = 33; dfa_state[32][12] = 33; dfa_state[32][13] = 33; dfa_state[32][14] = 33;
        dfa_state[32][15] = 33; dfa_state[32][16] = 33; dfa_state[32][17] = 33; dfa_state[32][18] = 33; dfa_state[32][19] = 33;
        dfa_state[32][20] = 33; dfa_state[32][21] = 33; dfa_state[32][22] = 33; dfa_state[32][23] = 33; dfa_state[32][24] = 33;

        //state33
        dfa_state[33][0] = -1; dfa_state[33][1] = -1; dfa_state[33][2] = -1; dfa_state[33][3] = -1; dfa_state[33][4] = -1;
        dfa_state[33][5] = -1; dfa_state[33][6] = -1; dfa_state[33][7] = -1; dfa_state[33][8] = -1; dfa_state[33][9] = -1;
        dfa_state[33][10] = -1; dfa_state[33][11] = -1; dfa_state[33][12] = -1; dfa_state[33][13] = -1; dfa_state[33][14] = -1;
        dfa_state[33][15] = -1; dfa_state[33][16] = -1; dfa_state[33][17] = -1; dfa_state[33][18] = -1; dfa_state[33][19] = -1;
        dfa_state[33][20] = -1; dfa_state[33][21] = -1; dfa_state[33][22] = -1; dfa_state[33][23] = -1; dfa_state[33][24] = -1;

        //state34
        dfa_state[34][0] = 36; dfa_state[34][1] = 36; dfa_state[34][2] = 36; dfa_state[34][3] = 70; dfa_state[34][4] = 70;
        dfa_state[34][5] = 35; dfa_state[34][6] = 70; dfa_state[34][7] = 70; dfa_state[34][8] = 70; dfa_state[34][9] = 36;
        dfa_state[34][10] = 70; dfa_state[34][11] = 70; dfa_state[34][12] = 70; dfa_state[34][13] = 70; dfa_state[34][14] = 70;
        dfa_state[34][15] = 70; dfa_state[34][16] = 70; dfa_state[34][17] = 70; dfa_state[34][18] = 70; dfa_state[34][19] = 70;
        dfa_state[34][20] = 70; dfa_state[34][21] = 70; dfa_state[34][22] = 70; dfa_state[34][23] = 70; dfa_state[34][24] = 36;

        //state35
        dfa_state[35][0] = 36; dfa_state[35][1] = 36; dfa_state[35][2] = 36; dfa_state[35][3] = 70; dfa_state[35][4] = 70;
        dfa_state[35][5] = 70; dfa_state[35][6] = 70; dfa_state[35][7] = 70; dfa_state[35][8] = 70; dfa_state[35][9] = 36;
        dfa_state[35][10] = 70; dfa_state[35][11] = 70; dfa_state[35][12] = 70; dfa_state[35][13] = 70; dfa_state[35][14] = 70;
        dfa_state[35][15] = 70; dfa_state[35][16] = 70; dfa_state[35][17] = 70; dfa_state[35][18] = 70; dfa_state[35][19] = 70;
        dfa_state[35][20] = 70; dfa_state[35][21] = 70; dfa_state[35][22] = 70; dfa_state[35][23] = 70; dfa_state[35][24] = 36;

        //state36
        dfa_state[36][0] = -1; dfa_state[36][1] = -1; dfa_state[36][2] = -1; dfa_state[36][3] = -1; dfa_state[36][4] = -1;
        dfa_state[36][5] = -1; dfa_state[36][6] = -1; dfa_state[36][7] = -1; dfa_state[36][8] = -1; dfa_state[36][9] = -1;
        dfa_state[36][10] = -1; dfa_state[36][11] = -1; dfa_state[36][12] = -1; dfa_state[36][13] = -1; dfa_state[36][14] = -1;
        dfa_state[36][15] = -1; dfa_state[36][16] = -1; dfa_state[36][17] = -1; dfa_state[36][18] = -1; dfa_state[36][19] = -1;
        dfa_state[36][20] = -1; dfa_state[36][21] = -1; dfa_state[36][22] = -1; dfa_state[36][23] = -1; dfa_state[36][24] = -1;

        //state37
        dfa_state[37][0] = 39; dfa_state[37][1] = 39; dfa_state[37][2] = 39; dfa_state[37][3] = 70; dfa_state[37][4] = 70;
        dfa_state[37][5] = 38; dfa_state[37][6] = 70; dfa_state[37][7] = 70; dfa_state[37][8] = 70; dfa_state[37][9] = 39;
        dfa_state[37][10] = 70; dfa_state[37][11] = 70; dfa_state[37][12] = 70; dfa_state[37][13] = 70; dfa_state[37][14] = 70;
        dfa_state[37][15] = 70; dfa_state[37][16] = 70; dfa_state[37][17] = 70; dfa_state[37][18] = 70; dfa_state[37][19] = 70;
        dfa_state[37][20] = 70; dfa_state[37][21] = 70; dfa_state[37][22] = 70; dfa_state[37][23] = 70; dfa_state[37][24] = 39;

        //state38
        dfa_state[38][0] = 39; dfa_state[38][1] = 39; dfa_state[38][2] = 39; dfa_state[38][3] = 70; dfa_state[38][4] = 70;
        dfa_state[38][5] = 70; dfa_state[38][6] = 70; dfa_state[38][7] = 70; dfa_state[38][8] = 70; dfa_state[38][9] = 39;
        dfa_state[38][10] = 70; dfa_state[38][11] = 70; dfa_state[38][12] = 70; dfa_state[38][13] = 70; dfa_state[38][14] = 70;
        dfa_state[38][15] = 70; dfa_state[38][16] = 70; dfa_state[38][17] = 70; dfa_state[38][18] = 70; dfa_state[38][19] = 70;
        dfa_state[38][20] = 70; dfa_state[38][21] = 70; dfa_state[38][22] = 70; dfa_state[38][23] = 70; dfa_state[38][24] = 39;

        //state39
        dfa_state[39][0] = -1; dfa_state[39][1] = -1; dfa_state[39][2] = -1; dfa_state[39][3] = -1; dfa_state[39][4] = -1;
        dfa_state[39][5] = -1; dfa_state[39][6] = -1; dfa_state[39][7] = -1; dfa_state[39][8] = -1; dfa_state[39][9] = -1;
        dfa_state[39][10] = -1; dfa_state[39][11] = -1; dfa_state[39][12] = -1; dfa_state[39][13] = -1; dfa_state[39][14] = -1;
        dfa_state[39][15] = -1; dfa_state[39][16] = -1; dfa_state[39][17] = -1; dfa_state[39][18] = -1; dfa_state[39][19] = -1;
        dfa_state[39][20] = -1; dfa_state[39][21] = -1; dfa_state[39][22] = -1; dfa_state[39][23] = -1; dfa_state[39][24] = -1;

        //state40
        dfa_state[40][0] = 42; dfa_state[40][1] = 42; dfa_state[40][2] = 42; dfa_state[40][3] = 70; dfa_state[40][4] = 70;
        dfa_state[40][5] = 43; dfa_state[40][6] = 70; dfa_state[40][7] = 70; dfa_state[40][8] = 70; dfa_state[40][9] = 42;
        dfa_state[40][10] = 70; dfa_state[40][11] = 70; dfa_state[40][12] = 70; dfa_state[40][13] = 70; dfa_state[40][14] = 70;
        dfa_state[40][15] = 70; dfa_state[40][16] = 70; dfa_state[40][17] = 70; dfa_state[40][18] = 70; dfa_state[40][19] = 70;
        dfa_state[40][20] = 70; dfa_state[40][21] = 70; dfa_state[40][22] = 70; dfa_state[40][23] = 70; dfa_state[40][24] = 42;

        //state41
        dfa_state[41][0] = 42; dfa_state[41][1] = 42; dfa_state[41][2] = 42; dfa_state[41][3] = 70; dfa_state[41][4] = 70;
        dfa_state[41][5] = 70; dfa_state[41][6] = 70; dfa_state[41][7] = 70; dfa_state[41][8] = 70; dfa_state[41][9] = 42;
        dfa_state[41][10] = 70; dfa_state[41][11] = 70; dfa_state[41][12] = 70; dfa_state[41][13] = 70; dfa_state[41][14] = 70;
        dfa_state[41][15] = 70; dfa_state[41][16] = 70; dfa_state[41][17] = 70; dfa_state[41][18] = 70; dfa_state[41][19] = 70;
        dfa_state[41][20] = 70; dfa_state[41][21] = 70; dfa_state[41][22] = 70; dfa_state[41][23] = 70; dfa_state[41][24] = 42;

        //state42
        dfa_state[42][0] = -1; dfa_state[42][1] = -1; dfa_state[42][2] = -1; dfa_state[42][3] = -1; dfa_state[42][4] = -1;
        dfa_state[42][5] = -1; dfa_state[42][6] = -1; dfa_state[42][7] = -1; dfa_state[42][8] = -1; dfa_state[42][9] = -1;
        dfa_state[42][10] = -1; dfa_state[42][11] = -1; dfa_state[42][12] = -1; dfa_state[42][13] = -1; dfa_state[42][14] = -1;
        dfa_state[42][15] = -1; dfa_state[42][16] = -1; dfa_state[42][17] = -1; dfa_state[42][18] = -1; dfa_state[42][19] = -1;
        dfa_state[42][20] = -1; dfa_state[42][21] = -1; dfa_state[42][22] = -1; dfa_state[42][23] = -1; dfa_state[42][24] = -1;

        //state43
        dfa_state[43][0] = 44; dfa_state[43][1] = 44; dfa_state[43][2] = 44; dfa_state[43][3] = 70; dfa_state[43][4] = 70;
        dfa_state[43][5] = 70; dfa_state[43][6] = 70; dfa_state[43][7] = 70; dfa_state[43][8] = 44; dfa_state[43][9] = 44;
        dfa_state[43][10] = 70; dfa_state[43][11] = 44; dfa_state[43][12] = 70; dfa_state[43][13] = 70; dfa_state[43][14] = 70;
        dfa_state[43][15] = 70; dfa_state[43][16] = 70; dfa_state[43][17] = 70; dfa_state[43][18] = 70; dfa_state[43][19] = 70;
        dfa_state[43][20] = 70; dfa_state[43][21] = 70; dfa_state[43][22] = 44; dfa_state[43][23] = 44; dfa_state[43][24] = 44;

        //state44
        dfa_state[44][0] = -1; dfa_state[44][1] = -1; dfa_state[44][2] = -1; dfa_state[44][3] = -1; dfa_state[44][4] = -1;
        dfa_state[44][5] = -1; dfa_state[44][6] = -1; dfa_state[44][7] = -1; dfa_state[44][8] = -1; dfa_state[44][9] = -1;
        dfa_state[44][10] = -1; dfa_state[44][11] = -1; dfa_state[44][12] = -1; dfa_state[44][13] = -1; dfa_state[44][14] = -1;
        dfa_state[44][15] = -1; dfa_state[44][16] = -1; dfa_state[44][17] = -1; dfa_state[44][18] = -1; dfa_state[44][19] = -1;
        dfa_state[44][20] = -1; dfa_state[44][21] = -1; dfa_state[44][22] = -1; dfa_state[44][23] = -1; dfa_state[44][24] = -1;

        //state45
        dfa_state[45][0] = 46; dfa_state[45][1] = 46; dfa_state[45][2] = 46; dfa_state[45][3] = 70; dfa_state[45][4] = 70;
        dfa_state[45][5] = 70; dfa_state[45][6] = 70; dfa_state[45][7] = 70; dfa_state[45][8] = 46; dfa_state[45][9] = 46;
        dfa_state[45][10] = 46; dfa_state[45][11] = 46; dfa_state[45][12] = 70; dfa_state[45][13] = 70; dfa_state[45][14] = 70;
        dfa_state[45][15] = 70; dfa_state[45][16] = 70; dfa_state[45][17] = 70; dfa_state[45][18] = 70; dfa_state[45][19] = 70;
        dfa_state[45][20] = 70; dfa_state[45][21] = 70; dfa_state[45][22] = 46; dfa_state[45][23] = 46; dfa_state[45][24] = 46;

        //state46
        dfa_state[46][0] = -1; dfa_state[46][1] = -1; dfa_state[46][2] = -1; dfa_state[46][3] = -1; dfa_state[46][4] = -1;
        dfa_state[46][5] = -1; dfa_state[46][6] = -1; dfa_state[46][7] = -1; dfa_state[46][8] = -1; dfa_state[46][9] = -1;
        dfa_state[46][10] = -1; dfa_state[46][11] = -1; dfa_state[46][12] = -1; dfa_state[46][13] = -1; dfa_state[46][14] = -1;
        dfa_state[46][15] = -1; dfa_state[46][16] = -1; dfa_state[46][17] = -1; dfa_state[46][18] = -1; dfa_state[46][19] = -1;
        dfa_state[46][20] = -1; dfa_state[46][21] = -1; dfa_state[46][22] = -1; dfa_state[46][23] = -1; dfa_state[46][24] = -1;

        //state47
        dfa_state[47][0] = 48; dfa_state[47][1] = 48; dfa_state[47][2] = 48; dfa_state[47][3] = 70; dfa_state[47][4] = 70;
        dfa_state[47][5] = 70; dfa_state[47][6] = 70; dfa_state[47][7] = 70; dfa_state[47][8] = 70; dfa_state[47][9] = 48;
        dfa_state[47][10] = 48; dfa_state[47][11] = 48; dfa_state[47][12] = 70; dfa_state[47][13] = 70; dfa_state[47][14] = 70;
        dfa_state[47][15] = 70; dfa_state[47][16] = 70; dfa_state[47][17] = 70; dfa_state[47][18] = 70; dfa_state[47][19] = 70;
        dfa_state[47][20] = 70; dfa_state[47][21] = 70; dfa_state[47][22] = 48; dfa_state[47][23] = 48; dfa_state[47][24] = 48;

        //state48
        dfa_state[48][0] = -1; dfa_state[48][1] = -1; dfa_state[48][2] = -1; dfa_state[48][3] = -1; dfa_state[48][4] = -1;
        dfa_state[48][5] = -1; dfa_state[48][6] = -1; dfa_state[48][7] = -1; dfa_state[48][8] = -1; dfa_state[48][9] = -1;
        dfa_state[48][10] = -1; dfa_state[48][11] = -1; dfa_state[48][12] = -1; dfa_state[48][13] = -1; dfa_state[48][14] = -1;
        dfa_state[48][15] = -1; dfa_state[48][16] = -1; dfa_state[48][17] = -1; dfa_state[48][18] = -1; dfa_state[48][19] = -1;
        dfa_state[48][20] = -1; dfa_state[48][21] = -1; dfa_state[48][22] = -1; dfa_state[48][23] = -1; dfa_state[48][24] = -1;

        //state49
        dfa_state[49][0] = 50; dfa_state[49][1] = 50; dfa_state[49][2] = 50; dfa_state[49][3] = 70; dfa_state[49][4] = 70;
        dfa_state[49][5] = 70; dfa_state[49][6] = 70; dfa_state[49][7] = 70; dfa_state[49][8] = 50; dfa_state[49][9] = 70;
        dfa_state[49][10] = 50; dfa_state[49][11] = 50; dfa_state[49][12] = 70; dfa_state[49][13] = 70; dfa_state[49][14] = 70;
        dfa_state[49][15] = 70; dfa_state[49][16] = 70; dfa_state[49][17] = 70; dfa_state[49][18] = 70; dfa_state[49][19] = 70;
        dfa_state[49][20] = 70; dfa_state[49][21] = 70; dfa_state[49][22] = 50; dfa_state[49][23] = 50; dfa_state[49][24] = 50;

        //state50
        dfa_state[50][0] = -1; dfa_state[50][1] = -1; dfa_state[50][2] = -1; dfa_state[50][3] = -1; dfa_state[50][4] = -1;
        dfa_state[50][5] = -1; dfa_state[50][6] = -1; dfa_state[50][7] = -1; dfa_state[50][8] = -1; dfa_state[50][9] = -1;
        dfa_state[50][10] = -1; dfa_state[50][11] = -1; dfa_state[50][12] = -1; dfa_state[50][13] = -1; dfa_state[50][14] = -1;
        dfa_state[50][15] = -1; dfa_state[50][16] = -1; dfa_state[50][17] = -1; dfa_state[50][18] = -1; dfa_state[50][19] = -1;
        dfa_state[50][20] = -1; dfa_state[50][21] = -1; dfa_state[50][22] = -1; dfa_state[50][23] = -1; dfa_state[50][24] = -1;

        //state51
        dfa_state[51][0] = 52; dfa_state[51][1] = 52; dfa_state[51][2] = 52; dfa_state[51][3] = 70; dfa_state[51][4] = 70;
        dfa_state[51][5] = 70; dfa_state[51][6] = 70; dfa_state[51][7] = 70; dfa_state[51][8] = 70; dfa_state[51][9] = 52;
        dfa_state[51][10] = 52; dfa_state[51][11] = 70; dfa_state[51][12] = 70; dfa_state[51][13] = 70; dfa_state[51][14] = 70;
        dfa_state[51][15] = 51; dfa_state[51][16] = 70; dfa_state[51][17] = 70; dfa_state[51][18] = 70; dfa_state[51][19] = 70;
        dfa_state[51][20] = 70; dfa_state[51][21] = 70; dfa_state[51][22] = 52; dfa_state[51][23] = 52; dfa_state[51][24] = 52;

        //state52
        dfa_state[52][0] = -1; dfa_state[52][1] = -1; dfa_state[52][2] = -1; dfa_state[52][3] = -1; dfa_state[52][4] = -1;
        dfa_state[52][5] = -1; dfa_state[52][6] = -1; dfa_state[52][7] = -1; dfa_state[52][8] = -1; dfa_state[52][9] = -1;
        dfa_state[52][10] = -1; dfa_state[52][11] = -1; dfa_state[52][12] = -1; dfa_state[52][13] = -1; dfa_state[52][14] = -1;
        dfa_state[52][15] = -1; dfa_state[52][16] = -1; dfa_state[52][17] = -1; dfa_state[52][18] = -1; dfa_state[52][19] = -1;
        dfa_state[52][20] = -1; dfa_state[52][21] = -1; dfa_state[52][22] = -1; dfa_state[52][23] = -1; dfa_state[52][24] = -1;

        //state53
        dfa_state[53][0] = 54; dfa_state[53][1] = 54; dfa_state[53][2] = 54; dfa_state[53][3] = 70; dfa_state[53][4] = 70;
        dfa_state[53][5] = 70; dfa_state[53][6] = 70; dfa_state[53][7] = 70; dfa_state[53][8] = 70; dfa_state[53][9] = 70;
        dfa_state[53][10] = 70; dfa_state[53][11] = 54; dfa_state[53][12] = 70; dfa_state[53][13] = 70; dfa_state[53][14] = 70;
        dfa_state[53][15] = 70; dfa_state[53][16] = 70; dfa_state[53][17] = 70; dfa_state[53][18] = 70; dfa_state[53][19] = 70;
        dfa_state[53][20] = 70; dfa_state[53][21] = 70; dfa_state[53][22] = 54; dfa_state[53][23] = 54; dfa_state[53][24] = 54;

        //state54
        dfa_state[54][0] = -1; dfa_state[54][1] = -1; dfa_state[54][2] = -1; dfa_state[54][3] = -1; dfa_state[54][4] = -1;
        dfa_state[54][5] = -1; dfa_state[54][6] = -1; dfa_state[54][7] = -1; dfa_state[54][8] = -1; dfa_state[54][9] = -1;
        dfa_state[54][10] = -1; dfa_state[54][11] = -1; dfa_state[54][12] = -1; dfa_state[54][13] = -1; dfa_state[54][14] = -1;
        dfa_state[54][15] = -1; dfa_state[54][16] = -1; dfa_state[54][17] = -1; dfa_state[54][18] = -1; dfa_state[54][19] = -1;
        dfa_state[54][20] = -1; dfa_state[54][21] = -1; dfa_state[54][22] = -1; dfa_state[54][23] = -1; dfa_state[54][24] = -1;

        //state55
        dfa_state[55][0] = 70; dfa_state[55][1] = 70; dfa_state[55][2] = 70; dfa_state[55][3] = 70; dfa_state[55][4] = 70;
        dfa_state[55][5] = 70; dfa_state[55][6] = 70; dfa_state[55][7] = 70; dfa_state[55][8] = 70; dfa_state[55][9] = 70;
        dfa_state[55][10] = 70; dfa_state[55][11] = 70; dfa_state[55][12] = 70; dfa_state[55][13] = 70; dfa_state[55][14] = 70;
        dfa_state[55][15] = 70; dfa_state[55][16] = 70; dfa_state[55][17] = 70; dfa_state[55][18] = 70; dfa_state[55][19] = 70;
        dfa_state[55][20] = 70; dfa_state[55][21] = 70; dfa_state[55][22] = 70; dfa_state[55][23] = 70; dfa_state[55][24] = 70;

        //state56
        dfa_state[56][0] = 70; dfa_state[56][1] = 70; dfa_state[56][2] = 70; dfa_state[56][3] = 70; dfa_state[56][4] = 70;
        dfa_state[56][5] = 70; dfa_state[56][6] = 70; dfa_state[56][7] = 70; dfa_state[56][8] = 70; dfa_state[56][9] = 70;
        dfa_state[56][10] = 70; dfa_state[56][11] = 70; dfa_state[56][12] = 70; dfa_state[56][13] = 70; dfa_state[56][14] = 70;
        dfa_state[56][15] = 70; dfa_state[56][16] = 70; dfa_state[56][17] = 70; dfa_state[56][18] = 70; dfa_state[56][19] = 70;
        dfa_state[56][20] = 70; dfa_state[56][21] = 70; dfa_state[56][22] = 70; dfa_state[56][23] = 70; dfa_state[56][24] = 70;

        //state57
        dfa_state[57][0] = 59 ; dfa_state[57][1] = 59; dfa_state[57][2] = 59; dfa_state[57][3] = 70; dfa_state[57][4] = 70;
        dfa_state[57][5] = 70; dfa_state[57][6] = 70; dfa_state[57][7] = 70; dfa_state[57][8] = 70; dfa_state[57][9] = 59;
        dfa_state[57][10] = 70; dfa_state[57][11] = 70; dfa_state[57][12] = 70; dfa_state[57][13] = 70; dfa_state[57][14] = 70;
        dfa_state[57][15] = 70; dfa_state[57][16] = 70; dfa_state[57][17] = 58; dfa_state[57][18] = 70; dfa_state[57][19] = 70;
        dfa_state[57][20] = 70; dfa_state[57][21] = 70; dfa_state[57][22] = 70; dfa_state[57][23] = 70; dfa_state[57][24] = 59;

        //state58
        dfa_state[58][0] = 59; dfa_state[58][1] = 59; dfa_state[58][2] = 59; dfa_state[58][3] = 70; dfa_state[58][4] = 70;
        dfa_state[58][5] = 70; dfa_state[58][6] = 70; dfa_state[58][7] = 70; dfa_state[58][8] = 70; dfa_state[58][9] = 59;
        dfa_state[58][10] = 70; dfa_state[58][11] = 70; dfa_state[58][12] = 70; dfa_state[58][13] = 70; dfa_state[58][14] = 70;
        dfa_state[58][15] = 70; dfa_state[58][16] = 70; dfa_state[58][17] = 70; dfa_state[58][18] = 70; dfa_state[58][19] = 70;
        dfa_state[58][20] = 70; dfa_state[58][21] = 70; dfa_state[58][22] = 70; dfa_state[58][23] = 70; dfa_state[58][24] = 59;

        //state59
        dfa_state[59][0] = -1; dfa_state[59][1] = -1; dfa_state[59][2] = -1; dfa_state[59][3] = -1; dfa_state[59][4] = -1;
        dfa_state[59][5] = -1; dfa_state[59][6] = -1; dfa_state[59][7] = -1; dfa_state[59][8] = -1; dfa_state[59][9] = -1;
        dfa_state[59][10] = -1; dfa_state[59][11] = -1; dfa_state[59][12] = -1; dfa_state[59][13] = -1; dfa_state[59][14] = -1;
        dfa_state[59][15] = -1; dfa_state[59][16] = -1; dfa_state[59][17] = -1; dfa_state[59][18] = -1; dfa_state[59][19] = -1;
        dfa_state[59][20] = -1; dfa_state[59][21] = -1; dfa_state[59][22] = -1; dfa_state[59][23] = -1; dfa_state[59][24] = -1;

        //state60
        dfa_state[60][0] = 62; dfa_state[60][1] = 62; dfa_state[60][2] = 62; dfa_state[60][3] = 70; dfa_state[60][4] = 70;
        dfa_state[60][5] = 70; dfa_state[60][6] = 70; dfa_state[60][7] = 70; dfa_state[60][8] = 70; dfa_state[60][9] = 62;
        dfa_state[60][10] = 70; dfa_state[60][11] = 70; dfa_state[60][12] = 70; dfa_state[60][13] = 70; dfa_state[60][14] = 70;
        dfa_state[60][15] = 70; dfa_state[60][16] = 70; dfa_state[60][17] = 70; dfa_state[60][18] = 70; dfa_state[60][19] = 70;
        dfa_state[60][20] = 70; dfa_state[60][21] = 70; dfa_state[60][22] = 70; dfa_state[60][23] = 70; dfa_state[60][24] = 62;

        //state61
        dfa_state[61][0] = 62; dfa_state[61][1] = 62; dfa_state[61][2] = 62; dfa_state[61][3] = 70; dfa_state[61][4] = 70;
        dfa_state[61][5] = 70; dfa_state[61][6] = 70; dfa_state[61][7] = 70; dfa_state[61][8] = 70; dfa_state[61][9] = 70;
        dfa_state[61][10] = 70; dfa_state[61][11] = 70; dfa_state[61][12] = 70; dfa_state[61][13] = 70; dfa_state[61][14] = 70;
        dfa_state[61][15] = 70; dfa_state[61][16] = 70; dfa_state[61][17] = 70; dfa_state[61][18] = 70; dfa_state[61][19] = 70;
        dfa_state[61][20] = 70; dfa_state[61][21] = 70; dfa_state[61][22] = 70; dfa_state[61][23] = 70; dfa_state[61][24] = 62;

        //state62
        dfa_state[62][0] = -1; dfa_state[62][1] = -1; dfa_state[62][2] = -1; dfa_state[62][3] = -1; dfa_state[62][4] = -1;
        dfa_state[62][5] = -1; dfa_state[62][6] = -1; dfa_state[62][7] = -1; dfa_state[62][8] = -1; dfa_state[62][9] = -1;
        dfa_state[62][10] = -1; dfa_state[62][11] = -1; dfa_state[62][12] = -1; dfa_state[62][13] = -1; dfa_state[62][14] = -1;
        dfa_state[62][15] = -1; dfa_state[62][16] = -1; dfa_state[62][17] = -1; dfa_state[62][18] = -1; dfa_state[62][19] = -1;
        dfa_state[62][20] = -1; dfa_state[62][21] = -1; dfa_state[62][22] = -1; dfa_state[62][23] = -1; dfa_state[62][24] = -1;

        //state63
        dfa_state[63][0] = 65; dfa_state[63][1] = 65; dfa_state[63][2] = 65; dfa_state[63][3] = 70; dfa_state[63][4] = 70;
        dfa_state[63][5] = 64; dfa_state[63][6] = 70; dfa_state[63][7] = 70; dfa_state[63][8] = 70; dfa_state[63][9] = 65;
        dfa_state[63][10] = 70; dfa_state[63][11] = 70; dfa_state[63][12] = 70; dfa_state[63][13] = 70; dfa_state[63][14] = 70;
        dfa_state[63][15] = 70; dfa_state[63][16] = 70; dfa_state[63][17] = 70; dfa_state[63][18] = 70; dfa_state[63][19] = 70;
        dfa_state[63][20] = 70; dfa_state[63][21] = 70; dfa_state[63][22] = 70; dfa_state[63][23] = 70; dfa_state[63][24] = 65;

        //state64
        dfa_state[64][0] = 65; dfa_state[64][1] = 65; dfa_state[64][2] = 65; dfa_state[64][3] = 70; dfa_state[64][4] = 70;
        dfa_state[64][5] = 70; dfa_state[64][6] = 70; dfa_state[64][7] = 70; dfa_state[64][8] = 70; dfa_state[64][9] = 65;
        dfa_state[64][10] = 70; dfa_state[64][11] = 70; dfa_state[64][12] = 70; dfa_state[64][13] = 70; dfa_state[64][14] = 70;
        dfa_state[64][15] = 70; dfa_state[64][16] = 70; dfa_state[64][17] = 70; dfa_state[64][18] = 70; dfa_state[64][19] = 70;
        dfa_state[64][20] = 70; dfa_state[64][21] = 70; dfa_state[64][22] = 70; dfa_state[64][23] = 70; dfa_state[64][24] = 65;

        //state65
        dfa_state[65][0] = 70; dfa_state[65][1] = 70; dfa_state[65][2] = 70; dfa_state[65][3] = 70; dfa_state[65][4] = 70;
        dfa_state[65][5] = 70; dfa_state[65][6] = 70; dfa_state[65][7] = 70; dfa_state[65][8] = 70; dfa_state[65][9] = 70;
        dfa_state[65][10] = 70; dfa_state[65][11] = 70; dfa_state[65][12] = 70; dfa_state[65][13] = 70; dfa_state[65][14] = 70;
        dfa_state[65][15] = 70; dfa_state[65][16] = 70; dfa_state[65][17] = 70; dfa_state[65][18] = 70; dfa_state[65][19] = 70;
        dfa_state[65][20] = 70; dfa_state[65][21] = 70; dfa_state[65][22] = 70; dfa_state[65][23] = 70; dfa_state[65][24] = 70;

        //state66
        dfa_state[66][0] = 67; dfa_state[66][1] = 67; dfa_state[66][2] = 67; dfa_state[66][3] = 67; dfa_state[66][4] = 67;
        dfa_state[66][5] = 67; dfa_state[66][6] = 67; dfa_state[66][7] = 67; dfa_state[66][8] = 67; dfa_state[66][9] = 67;
        dfa_state[66][10] = 67; dfa_state[66][11] = 67; dfa_state[66][12] = 67; dfa_state[66][13] = 67; dfa_state[66][14] = 67;
        dfa_state[66][15] = 67; dfa_state[66][16] = 67; dfa_state[66][17] = 67; dfa_state[66][18] = 67; dfa_state[66][19] = 67;
        dfa_state[66][20] = 67; dfa_state[66][21] = 67; dfa_state[66][22] = 67; dfa_state[66][23] = 67; dfa_state[66][24] = 67;

        //state67
        dfa_state[67][0] = -1; dfa_state[67][1] = -1; dfa_state[67][2] = -1; dfa_state[67][3] = -1; dfa_state[67][4] = -1;
        dfa_state[67][5] = -1; dfa_state[67][6] = -1; dfa_state[67][7] = -1; dfa_state[67][8] = -1; dfa_state[67][9] = -1;
        dfa_state[67][10] = -1; dfa_state[67][11] = -1; dfa_state[67][12] = -1; dfa_state[67][13] = -1; dfa_state[67][14] = -1;
        dfa_state[67][15] = -1; dfa_state[67][16] = -1; dfa_state[67][17] = -1; dfa_state[67][18] = -1; dfa_state[67][19] = -1;
        dfa_state[67][20] = -1; dfa_state[67][21] = -1; dfa_state[67][22] = -1; dfa_state[67][23] = -1; dfa_state[67][24] = -1;

        //state68
        dfa_state[68][0] = 69; dfa_state[68][1] = 69; dfa_state[68][2] = 69; dfa_state[68][3] = 69; dfa_state[68][4] = 69;
        dfa_state[68][5] = 69; dfa_state[68][6] = 69; dfa_state[68][7] = 69; dfa_state[68][8] = 69; dfa_state[68][9] = 69;
        dfa_state[68][10] = 69; dfa_state[68][11] = 69; dfa_state[68][12] = 69; dfa_state[68][13] = 69; dfa_state[68][14] = 69;
        dfa_state[68][15] = 69; dfa_state[68][16] = 69; dfa_state[68][17] = 69; dfa_state[68][18] = 69; dfa_state[68][19] = 69;
        dfa_state[68][20] = 69; dfa_state[68][21] = 69; dfa_state[68][22] = 69; dfa_state[68][23] = 69; dfa_state[68][24] = 69;

        //state69
        dfa_state[69][0] = -1; dfa_state[69][1] = -1; dfa_state[69][2] = -1; dfa_state[69][3] = -1; dfa_state[69][4] = -1;
        dfa_state[69][5] = -1; dfa_state[69][6] = -1; dfa_state[69][7] = -1; dfa_state[69][8] = -1; dfa_state[69][9] = -1;
        dfa_state[69][10] = -1; dfa_state[69][11] = -1; dfa_state[69][12] = -1; dfa_state[69][13] = -1; dfa_state[69][14] = -1;
        dfa_state[69][15] = -1; dfa_state[69][16] = -1; dfa_state[69][17] = -1; dfa_state[69][18] = -1; dfa_state[69][19] = -1;
        dfa_state[69][20] = -1; dfa_state[69][21] = -1; dfa_state[69][22] = -1; dfa_state[69][23] = -1; dfa_state[69][24] = -1;

        //state70
        dfa_state[70][0] = 70; dfa_state[70][1] = 70; dfa_state[70][2] = 70; dfa_state[70][3] = 70; dfa_state[70][4] = 70;
        dfa_state[70][5] = 70; dfa_state[70][6] = 70; dfa_state[70][7] = 70; dfa_state[70][8] = 70; dfa_state[70][9] = 70;
        dfa_state[70][10] = 70; dfa_state[70][11] = 70; dfa_state[70][12] = 70; dfa_state[70][13] = 70; dfa_state[70][14] = 70;
        dfa_state[70][15] = 70; dfa_state[70][16] = 70; dfa_state[70][17] = 70; dfa_state[70][18] = 70; dfa_state[70][19] = 70;
        dfa_state[70][20] = 70; dfa_state[70][21] = 70; dfa_state[70][22] = 70; dfa_state[70][23] = 70; dfa_state[70][24] = 70;

    }

    public static void main(String[] args) {
        File a = getDataFolderFromSystem();
        //setting information we need to run this program like list of letters, digits, keywords, operators, DFA table and symbol table.
        setLetter(letter);
        setDigit(digit);
        setKey(keyword);
        setOperator(operator);
        setDfa_state();
        setFinal_token();
        setKeyword_type(keyword_type);
        setKeyword_no_type(keyword_no_type);
        symbolTable.setKeyword(keyword);
        Extractor.extract(a);


    }

}