package main.resources;
import main.persistence.ToDo;
import main.persistence.ToDoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class DefaultController {

    private final ToDoRepository toDoRepository;

    public DefaultController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping("/todolist/")
    public List<ToDo> list(){
        Iterable<ToDo> toDoIterable = toDoRepository.findAll();
        ArrayList<ToDo> toDo = new ArrayList<>();
        for (ToDo toDo1 : toDoIterable){
            toDo.add(toDo1);
        }
        return toDo;
    }

    @PostMapping("/todolist/")
    public int add(ToDo todo){
        ToDo newToDo = toDoRepository.save(todo);
        return newToDo.getId();
    }

    @GetMapping(value = "/todolist/{id}/{del}")
    public ResponseEntity get(@PathVariable int id, @PathVariable boolean del){
        ToDo d1 = toDoRepository.findById(id).get();
        if(d1 == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }else if(del == false){
            return new ResponseEntity(d1, HttpStatus.OK);
        }else {
            toDoRepository.deleteById(id);
            return new ResponseEntity("Deleted", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/calculator", params = {"a", "b", "type"}, method = RequestMethod.GET)
    public int calculate(@RequestParam("a") int a,
                         @RequestParam("b") int b,
                         @RequestParam("type") CalculateType type
    ){
        if(type.equals(CalculateType.add)){
            return a + b;
        }else if(type.equals(CalculateType.sub)){
            return a - b;
        }else if(type.equals(CalculateType.mul)){
            return a * b;
        }else if(type.equals(CalculateType.div)){
            return a / b;
        }else {
            return -999999999;
        }
    }
}