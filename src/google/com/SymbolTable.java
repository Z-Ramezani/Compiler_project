package google.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SymbolTable {

    HashMap<Integer , ArrayList<String>> symbol_table = new HashMap<Integer, ArrayList<String>>();

    public void setKeyword(HashSet<String> keyword){
        Iterator<String> i = keyword.iterator();
        int j = 0;
        while(i.hasNext()){
            ArrayList<String> key = new ArrayList<String>();
            key.add("keyword");
            key.add(i.next());
            symbol_table.put(j, key);
            j++;
        }
    }
    public HashMap<Integer, ArrayList<String>> getSymbol_table() {
        return symbol_table;
    }

    public void setSymbol_table(int row, String token_name, String type, String name) {
        if (!check(name)) {
            ArrayList<String> id = new ArrayList<String>();
            id.add(token_name);
            id.add(type);
            id.add(name);
            symbol_table.put(row, id);
        }

    }
    public boolean check (String name){
        boolean result = false;
        int i = 0;
        while(i < symbol_table.size()){
            ArrayList<String> tmp = symbol_table.get(i);
            if (tmp.get(2).equals(name)){
                result = true;
                break;
            }
        }
        return result;
    }
}
