package hello.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Chunk {
    private int id;
    private List<User> users;
    public Chunk() {} // must keep it
    public Chunk(int id, List<User> users) {
        super();
        this.id = id;
        this.users = users;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public List<User> getUser() { // set XmlElement name
        return users;
    }
    public void setUser(List<User> users) {
        this.users = users;
    }
}