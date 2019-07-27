package warsztaty.spring.ailleron.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)       //zmiana statusu na 404; przez implementacje obslugi wyjatkow nie potrzebna jest ta adnotacja

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
