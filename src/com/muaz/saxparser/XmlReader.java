package com.muaz.saxparser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlReader extends DefaultHandler {

	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser reader = factory.newSAXParser();
			reader.parse(new File("ogrenci.xml"), new XmlReader());
		} catch (ParserConfigurationException |SAXException |IOException e) {
			e.printStackTrace();
		}
	}
	
	//d�k�man okuma i�lemi ba�lang�c�
	@Override
	public void startDocument() throws SAXException {
		System.out.println("xml dosya okumaya ba�land�...");
	}
	
	
	//eleman okuma i�lemi ba�lang�c�
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName + ":");
		if (attributes != null) {
			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.println(attributes.getQName(i) + ":" + attributes.getValue(i));
			}
		}
	}
	
	//eleman okuma i�lemi sonu
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("ogrenci")){
			System.out.println("**********************************");
		}
	}
	
	//method bir string de�il karakter dizisi d�n�yor
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		//karakter dizisini ba�tan sona okuyal�m
		String str = new String(ch, start, length);
		if (str.equals("") || str.contains("\t") || str.contains("\n"))
			return;
			System.out.println(str);
	}
	
	//d�k�man okuma i�lemi sonu
	@Override
	public void endDocument() throws SAXException {
		System.out.println("xml dosya okuma i�lemi bitti....");
	}
}



