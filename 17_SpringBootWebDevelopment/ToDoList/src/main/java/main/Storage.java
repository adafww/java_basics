package main;

import response.Do;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {

    private static int currentId = 1;
    private static HashMap<Integer, Do> list = new HashMap<Integer, Do>();

    public static List<Do> getAllToDoList(){
        ArrayList<Do> toDoList = new ArrayList<Do>();
        toDoList.addAll(list.values());
        return toDoList;
    }

    public synchronized static int add(Do do1){
        int id = do1.getId();
        if(list.containsKey(do1.getId())){
            list.put(id, do1);
            return id;
        }else {
            id = currentId++;
            do1.setId(id);
            list.put(id, do1);
            return id;
        }
    }

    public static Do getToDoString(int id){
        if(list.containsKey(id)){
            return list.get(id);
        }
        return null;
    }

    public synchronized static void deleteToDoString(int id){
        list.remove(id);
    }
}
