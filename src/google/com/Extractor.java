package google.com;
///debug4

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static google.com.Main.*;

public class Extractor {

    public LexicalAnalysis lexicalAnalysis=new LexicalAnalysis();
    public static int count = 32;
    //extract is used to read the file line by line and give each line to lexicalAnalysis.
    public  void extract(File f, int j){
        ArrayList<String> res = new ArrayList<String>();
        try {
            ArrayList<String> result=new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new FileReader(f+"//Lex"+j+".txt"));
            while (reader.ready()) {

                String line = reader.readLine();
                res= lexicalAnalysis.lexFunction(line);

            }
            prints(setTokenType(res));
            reader.close();
        } catch(IOException e) { System.out.print("Error"); }
    }
    public String[][] prints(String[][] token_type){
        String [] columns = {"Type" ,"Token"};
        int i=0 ;

        JTable table = new JTable(token_type,columns);
        JFrame f = new JFrame();
        f.setTitle("LexicalAnalysis");
        table.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(table);
        f.add(sp);
        f.setSize(500, 200);
        f.setVisible(true);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table.setBackground(new Color(79, 255, 255));
        table.setFont(new Font("Bahnschrift SemiLight SemiConde", Font.PLAIN, 17));
        return token_type;
    }

    public String[][] setTokenType (ArrayList<String> result) {

        String [][] token_type=new String[result.size()][2];
        String [] columns = {"Type" ,"Token"};
        int i=0 ;

        for (String s: result) {
            if (operator.contains(s))  token_type[i][0]="Operator";
            else if (keyword.contains(s)) token_type[i][0]="Keyword";
            else if (isNumber(s).equals("Number"))  token_type[i][0]="Number";
            else if (isNumber(s).equals("Error"))  token_type[i][0]="Error";
            else{
                ///  if (symbol.containsValue(s))
                s = symbolTable.check2(s);
                token_type[i][0]="Identifier";

            }
            // if (token_type[i][0].equals("Identifier")) token_type[i][1] = sid;
            token_type[i][1]=s;
            i++;
        }
        return token_type;
    }

    static String isNumber(String s){
        if (digit.contains(String.valueOf(s.charAt(0)))){
            for (int i = 1; i < s.length(); i++) {
                if (!digit.contains(String.valueOf(s.charAt(0)))){
                    return "Error";
                }
            }
            return "Number";
        }
        return "";
    }
}