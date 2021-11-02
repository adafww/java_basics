package main.resources;

import main.persistence.ToDo;
import main.persistence.ToDoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class IndexController {

    private final ToDoRepository toDoRepository;

    public IndexController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @RequestMapping("/")
    public String index(Model model){
        Iterable<ToDo> toDoIterable = toDoRepository.findAll();
        ArrayList<ToDo> toDo = new ArrayList<>();
        for (ToDo toDo1 : toDoIterable){
            toDo.add(toDo1);
        }
        model.addAttribute("toDo", toDo);
        model.addAttribute("toDoCount", toDo.size());
        return "index";
    }
}
