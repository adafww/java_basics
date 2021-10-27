package main;

import com.sun.source.tree.SynchronizedTree;

import java.util.*;

public class ListUrls {

    private static Set<String> list = new TreeSet<>();

    public static void add(String str){
        list.add(str);
        //System.out.println(list.size() + " - " + str);
        System.out.println(str);
    }
    public static boolean contains(String str){
        return list.contains(str);
    }
    public static Set<String> getList(){
        return list;
    }
    public static int getSize(){
        return list.size();
    }
}

