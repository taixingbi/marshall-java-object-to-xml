package hello.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Chunk {
    private List<User> users;
    public Chunk() {} // must keep it
    public Chunk(List<User> users) {
        super();
        this.users = users;
    }

    @XmlElement
    public List<User> getUser() { // set XmlElement name
        return users;
    }
    public void setUser(List<User> users) {
        this.users = users;
    }
}