package main.persistence;

import javax.persistence.*;

@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String toDoString;

    public ToDo(int id, String toDoString) {
        this.id = id;
        this.toDoString = toDoString;
    }

    public ToDo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToDoString() {
        return toDoString;
    }

    public void setToDoString(String toDoString) {
        this.toDoString = toDoString;
    }
}
