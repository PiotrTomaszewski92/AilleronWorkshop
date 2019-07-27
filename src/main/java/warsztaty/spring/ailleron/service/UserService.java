package warsztaty.spring.ailleron.service;

import org.springframework.stereotype.Service;
import warsztaty.spring.ailleron.exception.UserAlreadyExistException;
import warsztaty.spring.ailleron.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    static List<User> users = Arrays.asList(
            new User("Mariusz","Chrusciel",19),
            new User("Piotr","Tomaszewski",25),
            new User("Aleksander","Kwasniewskich",65)
    );

    public Optional<User> getUserByName(final String name){
        return users.stream().filter( u -> u.getName().equals(name)).findFirst();
    }

    public User addUser(User user) {
        Optional<User> userByName = getUserByName(user.getName());
        if(userByName.isPresent())
            throw new UserAlreadyExistException("User with name "+user.getName()+" already exist");
        users.add(user);
        return user;
    }
}
