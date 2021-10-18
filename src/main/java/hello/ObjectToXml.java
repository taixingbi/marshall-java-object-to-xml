package hello;

import hello.model.User;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.StringWriter;

public class ObjectToXml {
    public static void process() {
        User user = new User();
        user.setId(0);
        user.setName("taixingbi");
        user.setEmail("bt@gmail.com");
        jaxbObjectToXML(user);
    }

    private static String jaxbObjectToXML(Object object)
    {
        java.io.StringWriter sw = new StringWriter();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
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
