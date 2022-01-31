package lesson20;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.InputStream;


public class XPathRunner {
    public static void main(String[] args) {
        try (InputStream inputStream = XPathRunner.class.getResourceAsStream("/employee.xml")) {
            Document document = getXml(inputStream);
            XPath xPath = XPathFactory.newInstance().newXPath();
            double avg = (Double) xPath.compile("sum(//employees/employee/employment/@salary) div count(//employees/employee/employment)")
                    .evaluate(document, XPathConstants.NUMBER);
            System.out.println(avg);
            String avgEmployeesExpression = "//employees/employee/employment[@salary > " + avg + "]";
            NodeList nodes = (NodeList) xPath.compile(avgEmployeesExpression)
                    .evaluate(document, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println(element.getTextContent());
                }
            }
            System.out.println(nodes.getLength());
        } catch (IOException | ParserConfigurationException | SAXException | XPathExpressionException e) {
            e.printStackTrace();
        }
    }

    private static Document getXml(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        return builder.parse(inputStream);
    }
}
