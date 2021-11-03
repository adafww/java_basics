package main.persistence;

public class ToDoRequest {

    private long id;
    private String toDoString;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToDoString() {
        return toDoString;
    }

    public void setToDoString(String toDoString) {
        this.toDoString = toDoString;
    }

}
