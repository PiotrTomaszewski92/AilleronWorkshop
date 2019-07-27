package warsztaty.spring.ailleron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import warsztaty.spring.ailleron.exception.UserNotFoundException;
import warsztaty.spring.ailleron.model.User;
import warsztaty.spring.ailleron.service.UserService;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;
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

    @GetMapping("/{id}")
    public User getSurnameByName(@PathVariable Long id){
        Optional<User> userByName = userService.getUserById(id);
        if(userByName.isPresent())
            return userByName.get();
        throw new UserNotFoundException("User with id "+id+" not found.");
    }

    @GetMapping
    public List<User> gerUser(){
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody @Valid User user){
         userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity modifyUser(@PathVariable Long id, @RequestBody @Valid User user){
        userService.modifyUser(id,user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }



}
