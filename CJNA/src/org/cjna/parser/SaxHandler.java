package org.cjna.parser;

import org.cjna.Global;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * @author Pree
 *
 */
public class SaxHandler extends DefaultHandler {
		private boolean title = false;
		private boolean description = false;
		private FeedMessage fm;
		public SaxHandler() {
		}
		
		@Override
		public void startDocument() throws SAXException {
			System.out.print("Document processing started...");
		}
		@Override
		public void endDocument() throws SAXException {
			System.out.println("\nDocument processing finished...");
		}
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
			
	        if (qName.equalsIgnoreCase("title")) {
				fm = new FeedMessage();
				title = true;
	        }
	        
	        if (qName.equalsIgnoreCase("description")) {
	        	description = true;
	        }
		}
		
		@Override
		public void characters(char ch[], int start, int length) throws SAXException {
			if(title) {
				fm.setTitle(new String(ch, start, length));
				title = false;
			}
			if(description) {
				fm.setDescription(new String(ch, start, length));
				description = false;
				// remove the duplicate message first before adding to the list
				checkDuplicate dup = new checkDuplicate(); 
				if(!dup.isDuplicate(Global.myFeed.getMessages(), fm)) {
					Global.myFeed.getMessages().add(fm);
				}
				else {
					System.out.println("Message is already in the list.");
				}
			}
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
		
	    }
}// end class SaxHandler
