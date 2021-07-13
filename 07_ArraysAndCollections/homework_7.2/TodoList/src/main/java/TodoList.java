import java.util.ArrayList;

public class TodoList {

    ArrayList<String> toDoList = new ArrayList<>();

    public void add(String todo) {

        toDoList.add(todo);
        System.out.println("Добавлено дело " + "\"" + todo + "\"");
    }

    public void add(int index, String todo) {

        if(index <= toDoList.size() + 1 && index >= 0){

            if(index == toDoList.size() + 1){

                toDoList.add(todo);
                System.out.println("Добавлено дело " + "\"" + todo + "\"");
            }else {

                toDoList.add(index, todo);
                System.out.println("Добавлено дело " + index + " - \"" + todo + "\"");
            }
        }else {
            System.out.println("Ошибка");
        }
    }

    public void edit(String todo, int index) {

        if(index <= toDoList.size() && index >= 0){

            String list = toDoList.get(index);
            toDoList.set(index, todo);
            System.out.println("Дело " + "\"" + list + "\"" + " Заменено на " + "\""+ todo + "\"");
        }else{

            System.out.println("Ошибка");
        }

        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
    }

    public void delete(int index) {

        if(index <= toDoList.size() -1 && index >= 0){

            toDoList.remove(index);
            System.out.println("Удалено");
        }else {

            System.out.println("Дело с таким номером не существует");
        }

        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return toDoList;
    }

}