package com.muaz.domparser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlReader {

	public static void main(String[] args) {
		DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("ogrenci.xml"));
			Element root = doc.getDocumentElement();
			NodeList nList = root.getElementsByTagName("ogrenci");
			for (int i = 0; i < nList.getLength(); i++) {
				System.out.println("ogrenci:" );
				Node ogrenciNode = nList.item(i);
				NamedNodeMap namedNodeMap = ogrenciNode.getAttributes();
				System.out.println("no: " + namedNodeMap.getNamedItem("no").
						getNodeValue());
				NodeList altNodeList = ogrenciNode.getChildNodes();
				for (int j = 0; j < altNodeList.getLength(); j++) {
					Node node = altNodeList.item(j);
					if (node.getNodeType() != Node.TEXT_NODE) {
						System.out.println(node.getNodeName() + ": " + 
					node.getTextContent());
					}
				}
				
				System.out.println("***********************************");
			}
		} catch (ParserConfigurationException | SAXException |IOException e) {
			e.printStackTrace();
		}

	}

}
