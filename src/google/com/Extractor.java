package google.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Extractor {
     Extractor(){
        try {
            File file = new File("D:\\New folder\\Lex.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int count = 32 ;
            while (reader.ready()) {

                String line = reader.readLine();
                lexicalAnalysis v=new lexicalAnalysis();
                ArrayList result= v.lexicalAnalysis(line, count);
                for (int i=0;i<result.size();i++){
                    System.out.println(result.get(i));
                }
                count++;
            }
            reader.close();
        } catch(
                IOException e)
        {
            System.out.print("Error");
        }
    }
}
