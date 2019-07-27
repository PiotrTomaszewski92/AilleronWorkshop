package warsztaty.spring.ailleron.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import warsztaty.spring.ailleron.exception.UserNotFoundException;

@RestController
public class UserController {

    @GetMapping("/users/{name}")
    public String getSurnameByName(@PathVariable String name){
        if("Mariusz".equals(name))
            return "Chruściel";
        else if("Piotr".equals(name))
            return "Tomaszewski";
        throw new UserNotFoundException("User with name "+name+" not found.");
    }
}
