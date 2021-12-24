package google.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Extractor {
     Extractor(){
        try {
            File file = new File("D:\\New folder\\Lex.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.ready()) {
                System.out.println("111111");
                String line = reader.readLine();
                lexicalAnalysis v=new lexicalAnalysis();
              LinkedList result= v.lexicalAnalysis(line);
                for (int i=0;i<result.size();i++){
                    System.out.println(result.get(i));
                }
            }
            reader.close();
        } catch(
                IOException e)
        {
            System.out.print("Error");
        }
    }
}
