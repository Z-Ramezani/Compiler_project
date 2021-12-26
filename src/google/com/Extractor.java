package google.com;
///debug4

import javax.sound.midi.Soundbank;
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

    public static int count = 32;
    //extract is used to read the file line by line and give each line to lexicalAnalysis.
    public static void extract(File f){
        try {
            ArrayList<String> result=new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new FileReader(f+"//Lex.txt"));
            while (reader.ready()) {

                String line = reader.readLine();
                LexicalAnalysis v=new LexicalAnalysis();
                ArrayList<String> res= v.lexicalAnalysis(line);
                for (String s:res)result.add(s);
            }
            prints(result);
            reader.close();
        } catch(IOException e) { System.out.print("Error"); }
    }
    public static  void prints(ArrayList<String > result){
        HashMap symbol=symbolTable.getSymbol_table();

        String [] columns = {"Type" ,"Token"};
        Object [][] token_type=new Object[result.size()][2];
        int i=0 ;

        for (String s: result) {
            if (operator.contains(s))  token_type[i][0]="Operator";
            else if (keyword.contains(s)) token_type[i][0]="Keyword";
            else if (digit.contains(s))  token_type[i][0]="Number";
            else{
                ///  if (symbol.containsValue(s))


                s = symbolTable.check2(s);


                token_type[i][0]="Identifier";

            }
           // if (token_type[i][0].equals("Identifier")) token_type[i][1] = sid;
            token_type[i][1]=s;
            i++;
        }
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
    }
}