package hello;

import jakarta.xml.bind.JAXBException;

import java.io.FileNotFoundException;


public class App {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        System.out.println("----------app----------");
        ObjectsToXml.process();
        System.out.println("----------app end----------");
    }


}
