package warsztaty.spring.ailleron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warsztaty.spring.ailleron.exception.UserNotFoundException;
import warsztaty.spring.ailleron.model.User;
import warsztaty.spring.ailleron.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{name}")
    public User getSurnameByName(@PathVariable String name){
        Optional<User> userByName = userService.getUserByName(name);
        if(userByName.isPresent())
            return userByName.get();
        throw new UserNotFoundException("User with name "+name+" not found.");
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
