package warsztaty.spring.ailleron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import warsztaty.spring.ailleron.exception.UserNotFoundException;
import warsztaty.spring.ailleron.model.User;
import warsztaty.spring.ailleron.service.UserService;

import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{name}")
    public User getSurnameByName(@PathVariable String name){

        Optional<User> userByName = userService.getUserByName(name);
        if(userByName.isPresent())
            return userByName.get();
        throw new UserNotFoundException("User with name "+name+" not found.");
    }

    public User addUser(User user){
        return userService.addUser(user);
    }
}
