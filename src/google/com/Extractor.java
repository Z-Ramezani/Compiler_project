package google.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Extractor {
    public static void Extractor(File f){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f + "//Lex.txt"));
            while (reader.ready()) {
                String line = reader.readLine();
                String[] s = line.split(" ");
                check v=new check(s);
            }
            reader.close();
        } catch(
                IOException e)
        {
            System.out.print("Error");
        }
    }
}
