package warsztaty.spring.ailleron.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
//content negotiation
@JacksonXmlRootElement(localName = "userList") //zmiana nazwy taka otacajacego cala przestrzen danych dla XML
public class UserList {

    @JacksonXmlElementWrapper(useWrapping = false)  //usuniecie taga <users> otacajacy liste dla XML
    @JacksonXmlProperty(localName = "user") //zmiana nazwy na user dla taga otaczajacego kazdy z blokow dla XML
    @JsonProperty("userList")               //zmiana nazwy taka otacajacego cala przestrzen danych dla JSON
    private List<User> users;

    public UserList(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
