package com.muaz.jdomparser;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XmlReader {

	public static void main(String[] args) {
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = builder.build(new File("ogrenci.xml"));
			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
			outputter.output(document, System.out);
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
		

	}

}
