package warsztaty.spring.ailleron.service;

import org.springframework.stereotype.Service;
import warsztaty.spring.ailleron.exception.UserAlreadyExistException;
import warsztaty.spring.ailleron.exception.UserNotFoundException;
import warsztaty.spring.ailleron.model.User;
import warsztaty.spring.ailleron.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

   // static List<User> users = new ArrayList<>();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public UserService(){
//       if(users.isEmpty()) {
//           users.add(new User(1L,"Mariusz", "Chrusciel", 19));
//           users.add(new User(2L,"Piotr", "Tomaszewski", 25));
//           users.add(new User(3L,"Aleksander", "Kwasniewskich", 65));
//       }
//   }

    public Optional<User> getUserByName(final String name){
        return userRepository.findUserByName(name);
   }

    public User addUser(User user) {
        Optional<User> userByName = getUserByName(user.getName());
        if(userByName.isPresent())
            throw new UserAlreadyExistException("User with name "+user.getName()+" already exist");
        return userRepository.save(user);
//        user.setId((long) (users.size()+1));
//        users.add(user);
//        return user;
    }

    public List<User> getAllUsers() {
//       return users;
        return userRepository.findAll();
    }

    public void modifyUser(Long id, User user) {
        Optional<User> userById =  getUserById(id);
        if(!userById.isPresent())
            throw new UserNotFoundException("User with id: "+id+" not foud");
        user.setId(id);
        userRepository.save(user);
//        users.remove(userById.get());
//        users.add(user);
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
//        User userById =  getUserById(id).orElseThrow(()->new UserNotFoundException("User not found"));
//        users.remove(userById);
        getUserById(id).orElseThrow(()->new UserNotFoundException("User not found"));
        userRepository.deleteById(id);
    }
}
