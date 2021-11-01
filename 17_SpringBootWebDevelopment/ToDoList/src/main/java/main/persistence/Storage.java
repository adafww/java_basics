package main.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage {

    private static AtomicInteger currentId = new AtomicInteger();
    private static AtomicInteger addId = new AtomicInteger();
    private static ConcurrentHashMap<Integer, ToDo> list = new ConcurrentHashMap<>();

    public static List<ToDo> getAllToDoList(){
        ArrayList<ToDo> toDoList = new ArrayList<>();
        toDoList.addAll(list.values());
        return toDoList;
    }

    public static int add(ToDo todo){
        addId.addAndGet(todo.getId());
        if(list.containsKey(addId.intValue())){
            list.put(addId.intValue(), todo);
            return addId.intValue();
        }else {
            currentId.incrementAndGet();
            todo.setId(currentId.intValue());
            list.put(currentId.intValue(), todo);
            return currentId.intValue();
        }
    }

    public static ToDo getToDoString(int id){
        if(list.containsKey(id)){
            return list.get(id);
        }
        return null;
    }

    public static void deleteToDoString(int id){
        list.remove(id);
    }
}
