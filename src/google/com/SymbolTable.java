package google.com;
///debug4

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
// symbol table has created here by using hashmap which has an integer pointer as key and arrayList from tokenName , type and name as value.

public class SymbolTable {

    HashMap<Integer , ArrayList<String>> symbol_table = new HashMap<>();

    // setting keywords to symbol table. This method is called in class Main method main to set keywords in symbol table.
    public void setKeyword(HashSet<String> keyword){
        Iterator<String> i = keyword.iterator();
        int j = 0;
        while(i.hasNext()){
            ArrayList<String> key = new ArrayList<>();
            key.add("keyword");
            key.add(i.next());
            key.add("");
            symbol_table.put(j, key);
            j++;
        }
    }

    public HashMap<Integer, ArrayList<String>> getSymbol_table() { return symbol_table; }

    // This method is used to set tokens that are id in symbol table.It needs token_name,type and name.
    public void setSymbol_table(int row, String token_name, String type, String name) {
        if (!check(name)) {
            ArrayList<String> id = new ArrayList<>();
            id.add(token_name);
            id.add(type);
            id.add(name);
            Extractor.count ++ ;
            symbol_table.put(row, id);
        }

    }
    //here we check if the id that we found has been set to symbol table before or not.we call this method in setSymbol_table method.
    public boolean check (String name){
        boolean result = false;
        int i = 0;
        while(i < symbol_table.size()){
            ArrayList<String> tmp = symbol_table.get(i);
            if (tmp.get(2).equals(name)){
                result = true;
                break;
            }
            i++;
        }
        return result;
    }
}