package Syntax;

import javafx.util.Pair;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ParsingTable {

    HashMap <Pair<String , String>, String> table = new HashMap <Pair<String, String>, String>() ;
    public void setTable () {
        Pair pair1 = new Pair("Main-Stmt", "int");
        table.put(pair1, "int X");

        Pair pair2 = new Pair("Main-Stmt", "void");
        table.put(pair2, "void X");

        //////////

        Pair pair3 = new Pair("X", "main");
        table.put(pair3, "main ( ) { Single-Stmt");

        ////////

        Pair pair4 = new Pair("Single-Stmt", "int");
        table.put(pair4, "Initialization-Stmt");

        Pair pair5 = new Pair("Single-Stmt", "{");
        table.put(pair5, "Combine-Stmt");

        Pair pair6 = new Pair("Single-Stmt", "id");
        table.put(pair6, "Calculate-Stmt");

        Pair pair7 = new Pair("Single-Stmt", "float");
        table.put(pair7, "Initialization-Stmt");

        Pair pair8 = new Pair("Single-Stmt", "char");
        table.put(pair8, "Initialization-Stmt");

        Pair pair9 = new Pair("Single-Stmt", "if");
        table.put(pair9, "If-Stmt");

        Pair pair10 = new Pair("Single-Stmt", "while");
        table.put(pair10, "Loop-Stmt");

        Pair pair11 = new Pair("Single-Stmt", "do");
        table.put(pair11, "Loop-Stmt");

        Pair pair12 = new Pair("Single-Stmt", "for");
        table.put(pair12, "Loop-Stmt");

        Pair pair13 = new Pair("Single-Stmt", "break");
        table.put(pair13, "Skip-Stmt");

        Pair pair14 = new Pair("Single-Stmt", "continue");
        table.put(pair14, "Skip-Stmt");

        Pair pair15 = new Pair("Single-Stmt", "return");
        table.put(pair15, "Skip-Stmt");

        ////////

        Pair pair16 = new Pair("End", ";");
        table.put(pair16, "; End-tmp");

        //////

        Pair pair17 = new Pair("End-tmp", "int");
        table.put(pair17, "Single-Stmt");

        Pair pair18 = new Pair("End-tmp", "{");
        table.put(pair18, "Single-Stmt");

        Pair pair19 = new Pair("End-tmp", "}");
        table.put(pair19, "bracket");

        Pair pair20 = new Pair("End-tmp", "e");
        table.put(pair20, "bracket");

        Pair pair21 = new Pair("End-tmp", "id");
        table.put(pair21, "Single-Stmt");

        Pair pair22 = new Pair("End-tmp", "float");
        table.put(pair22, "Single-Stmt");

        Pair pair23 = new Pair("End-tmp", "char");
        table.put(pair23, "Single-Stmt");

        Pair pair24 = new Pair("End-tmp", "if");
        table.put(pair24, "Single-Stmt");

        Pair pair25 = new Pair("End-tmp", "while");
        table.put(pair25, "Single-Stmt");

        Pair pair26 = new Pair("End-tmp", "for");
        table.put(pair26, "Single-Stmt");

        Pair pair27 = new Pair("End-tmp", "break");
        table.put(pair27, "Single-Stmt");

        Pair pair28 = new Pair("End-tmp", "continue");
        table.put(pair28, "Single-Stmt");

        Pair pair29 = new Pair("End-tmp", "return");
        table.put(pair29, "Single-Stmt");

        /////////

        Pair pair30 = new Pair("bracket", "}");
        table.put(pair30, "} bracket-tmp");

        Pair pair31 = new Pair("bracket", "e");
        table.put(pair31, "e");

        /////


        Pair pair32 = new Pair("bracket-tmp", "int");
        table.put(pair32, "Single-Stmt");

        Pair pair33 = new Pair("bracket-tmp", "{");
        table.put(pair33, "Single-Stmt");

        Pair pair34 = new Pair("bracket-tmp", "}");
        table.put(pair34, "}");

        Pair pair35 = new Pair("bracket-tmp", "id");
        table.put(pair35, "Single-Stmt");

        Pair pair36 = new Pair("bracket-tmp", "float");
        table.put(pair36, "Single-Stmt");

        Pair pair37 = new Pair("bracket-tmp", "char");
        table.put(pair37, "Single-Stmt");

        Pair pair38 = new Pair("bracket-tmp", "if");
        table.put(pair38, "Single-Stmt");

        Pair pair39 = new Pair("bracket-tmp", "while");
        table.put(pair39, "Single-Stmt");

        Pair pair40 = new Pair("bracket-tmp", "do");
        table.put(pair40, "Single-Stmt");

        Pair pair41 = new Pair("bracket-tmp", "for");
        table.put(pair41, "Single-Stmt");

        Pair pair42 = new Pair("bracket-tmp", "break");
        table.put(pair42, "Single-Stmt");

        Pair pair43 = new Pair("bracket-tmp", "continue");
        table.put(pair43, "Single-Stmt");

        Pair pair44 = new Pair("bracket-tmp", "return");
        table.put(pair44, "Single-Stmt");

        ///////

        Pair pair45 = new Pair("Calculate-Stmt", "id");
        table.put(pair45, "id Calculate-Stmt-tmp");

        Pair pair46 = new Pair("Calculate-Stmt", "id");
        table.put(pair46, "id Calculate-Stmt-tmp");

        //////

        Pair pair47 = new Pair("Calculate-Stmt-tmp", "++");
        table.put(pair47, "++ End");

        Pair pair48 = new Pair("Calculate-Stmt-tmp", "--");
        table.put(pair48, "-- End");

        Pair pair49 = new Pair("Calculate-Stmt-tmp", "=");
        table.put(pair49, "Calculator Expression-Stmt End");

        Pair pair50 = new Pair("Calculate-Stmt-tmp", "+=");
        table.put(pair50, "Calculator Expression-Stmt End");

        Pair pair51 = new Pair("Calculate-Stmt-tmp", "-=");
        table.put(pair51, "Calculator Expression-Stmt End");

        Pair pair52 = new Pair("Calculate-Stmt-tmp", "*=");
        table.put(pair52, "Calculator Expression-Stmt End");

        Pair pair53 = new Pair("Calculate-Stmt-tmp", "/=");
        table.put(pair53, "Calculator Expression-Stmt End");

        Pair pair54 = new Pair("Calculate-Stmt-tmp", "%=");
        table.put(pair54, "Calculator Expression-Stmt End");

        /////

        Pair pair55 = new Pair("Calculator", "=");
        table.put(pair55, "=");

        Pair pair56 = new Pair("Calculator", "+=");
        table.put(pair56, "+=");

        Pair pair57 = new Pair("Calculator", "-=");
        table.put(pair57, "-=");

        Pair pair58 = new Pair("Calculator", "*=");
        table.put(pair58, "*=");

        Pair pair59 = new Pair("Calculator", "/=");
        table.put(pair59, "/=");

        Pair pair60 = new Pair("Calculator", "%=");
        table.put(pair60, "%=");

        ///////

        Pair pair61 = new Pair("Operator", "+");
        table.put(pair61, "+");

        Pair pair62 = new Pair("Operator", "-");
        table.put(pair62, "-");

        Pair pair63 = new Pair("Operator", "*");
        table.put(pair63, "*");

        Pair pair64 = new Pair("Operator", "/");
        table.put(pair61, "/");

        Pair pair65 = new Pair("Operator", "%");
        table.put(pair61, "%");

        ///////

        Pair pair66 = new Pair("Expression-Stmt", "id");
        table.put(pair66, "Variable E");

        Pair pair67 = new Pair("Expression-Stmt", "digit");
        table.put(pair67, "Variable E");

        ///////

        Pair pair68 = new Pair("E", ")");
        table.put(pair68, "e");

        Pair pair69 = new Pair("E", ";");
        table.put(pair69, "e");

        Pair pair70 = new Pair("E", "+");
        table.put(pair70, "Operator Expression-Stmt");

        Pair pair71 = new Pair("E", "-");
        table.put(pair71, "Operator Expression-Stmt");

        Pair pair72 = new Pair("E", "*");
        table.put(pair72, "Operator Expression-Stmt");

        Pair pair73 = new Pair("E", "/");
        table.put(pair73, "Operator Expression-Stmt");

        Pair pair74 = new Pair("E", "%");
        table.put(pair70, "Operator Expression-Stmt");

        Pair pair75 = new Pair("E", "==");
        table.put(pair75, "e");

        Pair pair76 = new Pair("E", ">=");
        table.put(pair76, "e");

        Pair pair77 = new Pair("E", "<=");
        table.put(pair77, "e");

        Pair pair78 = new Pair("E", "!=");
        table.put(pair78, "e");

        Pair pair79 = new Pair("E", ">");
        table.put(pair79, "e");

        Pair pair80 = new Pair("E", "<");
        table.put(pair80, "e");

        /////

        Pair pair81 = new Pair("Initialization-Stmt", "int");
        table.put(pair81, "type id Initialization-Stmt-tmp");

        Pair pair82 = new Pair("Initialization-Stmt", "float");
        table.put(pair82, "type id Initialization-Stmt-tmp");

        Pair pair83 = new Pair("Initialization-Stmt", "char");
        table.put(pair83, "type id Initialization-Stmt-tmp");

        ///////

        Pair pair84 = new Pair("Initialization-Stmt-tmp", ";");
        table.put(pair84, "End");

        Pair pair85 = new Pair("Initialization-Stmt-tmp", ";");
        table.put(pair85, "= Expression-Stmt End");

        Pair pair86 = new Pair("Initialization-Stmt-tmp", ";");
        table.put(pair86, "= Expression-Stmt End");
















    }
}
