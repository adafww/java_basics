package main;

import com.sun.source.tree.SynchronizedTree;

import java.util.*;

public class ListUrls {

    private static Set<String> list = new TreeSet<>();
    //private static Set<String> list = Collections.synchronizedSet(lst);

    public static void add(String str){
        list.add(str);
    }
    public static boolean contains(String str){
        return list.contains(str);
    }
    public static Set<String> getList(){
        return list;
    }
}

