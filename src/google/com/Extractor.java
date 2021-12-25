package google.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Extractor {
    public static int count = 32;
    //extract is used to read the file line by line and give each line to lexicalAnalysis.
    public static void extract(File f){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f+"//Lex.txt"));
            while (reader.ready()) {

                String line = reader.readLine();
                LexicalAnalysis v=new LexicalAnalysis();
                ArrayList<String> result= v.lexicalAnalysis(line);
                for (int i=0;i<result.size();i++){
                    System.out.println(result.get(i));
                }
            }
            reader.close();
        } catch(IOException e) { System.out.print("Error"); }
    }
}
