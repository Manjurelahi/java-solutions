import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class XmlParseDomSaxStax {
    private void addEmployeeInXML(XMLStreamWriter writer, String id, String name, String salary, String currency) throws XMLStreamException {
        writer.writeStartElement("Employee");
        writer.writeAttribute("ID", id);
        writer.writeStartElement("Name");
        writer.writeCharacters(name);
        writer.writeEndElement();
        writer.writeStartElement("Salary");
        writer.writeAttribute("Currency", currency);
        writer.writeCharacters(salary);
        writer.writeEndElement();
        writer.writeEndElement();
    }
    private void writeXML(File file) throws XMLStreamException, FileNotFoundException {
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        OutputStream outputStream = new FileOutputStream(file);
        XMLStreamWriter writer = xmlOutputFactory.createXMLStreamWriter(outputStream);
		writer.writeStartElement("Employees");
        addEmployeeInXML(writer, "1", "Manjur", "100", "INR");
        addEmployeeInXML(writer, "2", "Elahi", "200", "USD");
        writer.writeEndElement();
        writer.writeEndDocument();
        writer.flush();
        writer.close();
    }

    private void parseXmlDOM(File file) throws ParserConfigurationException, IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(file);
        NodeList nodeList = doc.getElementsByTagName("Employees").item(0).getChildNodes();
        for (int i=0; i<nodeList.getLength(); i++) {
            Node employee = nodeList.item(i);
            System.out.println("ID: "+employee.getAttributes().item(0).getTextContent());
            NodeList empNodeList = employee.getChildNodes();
            for (int j=0; j<empNodeList.getLength(); j++) {
                Element element = (Element) empNodeList.item(j);
                if ("Name".equals(element.getTagName())) {
                    System.out.println("Name: "+element.getTextContent());
                } else if ("Salary".equals(element.getTagName())) {
                    System.out.print("Salary: "+element.getTextContent() + " ");
                    System.out.println(element.getAttribute("Currency"));
                }
            }
        }
    }

    private void parseXmlSAX(File file) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser =  saxParserFactory.newSAXParser();
        DefaultHandler handler = new DefaultHandler() {
            boolean isName = false, isSalary = false;
            String currency = "";

            @Override
            public void startElement (String uri, String localName, String qName, Attributes attributes) {
                if (qName.equals("Employee")) {
                    System.out.println("ID: "+attributes.getValue("ID"));
                }
                if (qName.equals("Name")) {
                    isName = true;
                }
                if (qName.equals("Salary")) {
                    currency = attributes.getValue("Currency");
                    isSalary = true;
                }
            }
            @Override
            public void characters (char ch[], int start, int length) {
                if (isName) {
                    System.out.println("Name: "+new String(ch, start, length));
                    isName = false;
                }
                if (isSalary) {
                    System.out.println("Salary: "+new String(ch, start, length)+" "+currency);
                    isSalary = false;
                }
            }
        };
        saxParser.parse(file, handler);
    }

    private void parseXmlStAX(File file) throws FileNotFoundException, XMLStreamException {
        boolean isName = false, isSalary = false;
        String currency = "";
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileReader(file));
        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            if (xmlEvent.isStartElement()) {
                StartElement startElement = (StartElement) xmlEvent;
                if (startElement.getName().toString().equals("Employee")) {
                    System.out.println("ID: "+((Attribute)startElement.getAttributes().next()).getValue());
                }
                if (startElement.getName().toString().equals("Name")) {
                    isName = true;
                }
                if (startElement.getName().toString().equals("Salary")) {
                    currency = ((Attribute)startElement.getAttributes().next()).getValue();
                    isSalary = true;
                }
            }
            if (xmlEvent.isCharacters()) {
                Characters characters = (Characters) xmlEvent;
                if (isName) {
                    System.out.println("Name: "+characters.getData());
                    isName = false;
                }
                if (isSalary) {
                    System.out.println("Salary: "+characters.getData()+ " "+currency);
                    isSalary = false;
                }
            }
        }
    }

    public static void main(String[] args) throws XMLStreamException, IOException, ParserConfigurationException, SAXException {
        XmlParseDomSaxStax xmlParseDomSaxStax = new XmlParseDomSaxStax();
        File file = new File("Employees.xml");
        xmlParseDomSaxStax.writeXML(file);
        System.out.println("-----XML Parsing By DOM-----");
        xmlParseDomSaxStax.parseXmlDOM(file);
        System.out.println("-----XML Parsing By SAX-----");
        xmlParseDomSaxStax.parseXmlSAX(file);
        System.out.println("-----XML Parsing By StAX-----");
        xmlParseDomSaxStax.parseXmlStAX(file);
    }
}

/*
Output:
-----XML Parsing By DOM-----
ID: 1
Name: Manjur
Salary: 100 INR
ID: 2
Name: Elahi
Salary: 200 USD
-----XML Parsing By SAX-----
ID: 1
Name: Manjur
Salary: 100 INR
ID: 2
Name: Elahi
Salary: 200 USD
-----XML Parsing By StAX-----
ID: 1
Name: Manjur
Salary: 100 INR
ID: 2
Name: Elahi
Salary: 200 USD
 */