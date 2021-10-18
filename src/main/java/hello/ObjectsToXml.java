package hello;

import hello.model.User;
import hello.model.Chunk;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.ArrayList;

public class ObjectsToXml {
    public static void process() throws JAXBException, FileNotFoundException {
        User user1 = new User(101,"taixing bi","tb@gmail.com");
        User user2 = new User(102,"hunter","hunter@gmail.com");

        ArrayList<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);

        Chunk chunk = new Chunk(list);
        jaxbObjectToXML(chunk);
    }

    private static String jaxbObjectToXML(Object object)
    {
        java.io.StringWriter sw = new StringWriter();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Chunk.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
            jaxbMarshaller.marshal(object, sw);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        String xml= sw.toString();
        System.out.println(xml);

        return xml;
    }
}
