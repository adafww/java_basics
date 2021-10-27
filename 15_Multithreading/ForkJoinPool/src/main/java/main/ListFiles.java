package main;

import java.util.ArrayList;
import java.util.List;

public class ListFiles {
    private static List<String> list = new ArrayList<>();
    public static void addAll(List<String> list1){
        list.addAll(list1);
    }
    public static int getSize(){
        return list.size();
    }
    public static List<String> getList(){
        return list;
    }
}
