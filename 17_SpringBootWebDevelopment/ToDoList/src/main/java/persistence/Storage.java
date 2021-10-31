package persistence;

import persistence.Do;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage {

    private static AtomicInteger currentId = new AtomicInteger();
    private static AtomicInteger addId = new AtomicInteger();
    private static Hashtable<Integer, Do> list = new Hashtable<>();

    public static List<Do> getAllToDoList(){
        ArrayList<Do> toDoList = new ArrayList<>();
        toDoList.addAll(list.values());
        return toDoList;
    }

    public static int add(Do do1){
        addId.addAndGet(do1.getId());
        if(list.containsKey(addId.intValue())){
            list.put(addId.intValue(), do1);
            return addId.intValue();
        }else {
            currentId.incrementAndGet();
            do1.setId(currentId.intValue());
            list.put(currentId.intValue(), do1);
            return currentId.intValue();
        }
    }

    public static Do getToDoString(int id){
        if(list.containsKey(id)){
            return list.get(id);
        }
        return null;
    }

    public static void deleteToDoString(int id){
        list.remove(id);
    }
}
