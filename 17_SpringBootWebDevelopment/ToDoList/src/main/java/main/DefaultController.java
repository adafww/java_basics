package main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DefaultController {
    @RequestMapping("/")
    public String index(){
        return (new Date().toString());
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
