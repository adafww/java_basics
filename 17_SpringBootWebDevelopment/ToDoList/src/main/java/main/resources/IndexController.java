package main.resources;

import main.persistence.ToDo;
import main.persistence.ToDoRepository;
import main.persistence.ToDoRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class IndexController {

    private final ToDoRepository toDoRepository;

    public IndexController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @RequestMapping("/todo")
    public String index(@ModelAttribute ToDo toDo, Model model){
        Iterable<ToDo> toDoIterable = toDoRepository.findAll();
        ArrayList<ToDo> toDoArrayList = new ArrayList<>();
        for (ToDo toDoIter : toDoIterable){
            toDoArrayList.add(toDoIter);
        }
        model.addAttribute("toDoAdd", toDo);
        model.addAttribute("toDo", toDoArrayList);
        model.addAttribute("toDoCount", toDoArrayList.size());
        toDoRepository.save(toDo);
        return "index";
    }
}
