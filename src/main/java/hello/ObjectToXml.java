package hello;

import hello.model.SimpleUser;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.StringWriter;

public class ObjectToXml {
    public static void process() {
        System.out.println("----------app----------");
        SimpleUser user1 = new SimpleUser();
        user1.setId(0);
        user1.setName("taixingbi");
        user1.setEmail("bt@gmail.com");

        jaxbObjectToXML(user1);

        System.out.println("----------app end----------");
    }

    private static String jaxbObjectToXML(Object object)
    {
        java.io.StringWriter sw = new StringWriter();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(SimpleUser.class);
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
