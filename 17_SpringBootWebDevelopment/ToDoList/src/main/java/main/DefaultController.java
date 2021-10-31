package main;
import persistence.Storage;
import org.springframework.http.HttpStatus;
import persistence.Do;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class DefaultController {
    private int id;

    @RequestMapping("/")
    public String index(){
        return (new Date().toString());
    }

    @GetMapping("/todolist/")
    public List<Do> list(){

        return Storage.getAllToDoList();
    }

    @PostMapping("/todolist/")
    public int add(Do do1){

        Storage.add(do1);
        return Storage.getAllToDoList().size();
    }

    @GetMapping(value = "/todolist/{id}/{del}")
    public ResponseEntity get(@PathVariable int id, @PathVariable boolean del){
        Do d1 = Storage.getToDoString(id);
        if(d1 == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }else if(del == false){
            return new ResponseEntity(d1, HttpStatus.OK);
        }else {
            Storage.deleteToDoString(id);
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
