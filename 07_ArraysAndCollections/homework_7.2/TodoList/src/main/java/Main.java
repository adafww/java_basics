import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {

        String regex = "(EDIT|ADD|LIST|DELETE)(\\s)([0-9]*|[A-Za-z\\s]*|)(\\s|)([A-Za-z\\s]+|)";
        Scanner scanner = new Scanner(System.in);

        while (true){
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            String pattern = Pattern.compile(regex).matcher(input).replaceAll("$1");

            if(pattern.equals("ADD")){

                if(Pattern.compile(regex).matcher(input).replaceAll("$3").equals("")){

                    todoList.add(Pattern.compile(regex).matcher(input).replaceAll("$5"));
                }else {

                    todoList.add(Integer.parseInt(Pattern.compile(regex).matcher(input).replaceAll("$3")), Pattern.compile(regex).matcher(input).replaceAll("$5"));
                }
            }

            if(pattern.equals("EDIT")){

                todoList.edit(Pattern.compile(regex).matcher(input).replaceAll("$5"), Integer.parseInt(Pattern.compile(regex).matcher(input).replaceAll("$3")));
            }

            if(pattern.equals("LIST")){

                for(int i = 0; i < todoList.getTodos().size(); i++){

                    System.out.println(todoList.toDoList.get(i));
                }
            }

            if(pattern.equals("DELETE")){

                todoList.delete(Integer.parseInt(Pattern.compile(regex).matcher(input).replaceAll("$3")));
            }
        }
        // TODO: написать консольное приложение для работы со списком дел todoList
    }
}
