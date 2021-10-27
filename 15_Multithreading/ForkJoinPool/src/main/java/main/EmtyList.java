package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EmtyList {
    private static List<String> list = new ArrayList<>();

    public static void add(String str){
        list.add(str);
    }
    public static boolean contains(String str){
        return list.contains(str);
    }
    public static List<String> getList(){
        return list;
    }
    public static int getSize(){
        return list.size();
    }
}
