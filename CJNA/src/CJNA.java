import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import parser.FeedParser;
import cjna.GetNewsList;
import cjna.Global;

/**
 * @author Pree
 */

public class CJNA {
	public static void main(String args[]) throws SAXException, IOException, ParserConfigurationException {
		GetNewsList myList = new GetNewsList();
		FeedParser fp;
		
		System.out.println("News List are as following: ");
		for(int i = 0; i < Global.URI.size(); i++) {
			System.out.println(Global.URI.get(i));
		}
		System.out.println();
		
		// loop through news list
		for(int i = 0; i < Global.URI.size(); i++) {
			fp = new FeedParser(Global.URI.get(i));
		
			// show feed messages
			for(int j = 0; j < Global.myFeed.getSize(); j++) {
				System.out.println(Global.myFeed.getMessages().get(j));
			}
			System.out.println("CJNA Reader now has : " + Global.myFeed.getSize() + " messages.");
			System.out.println();
		}
	
		System.out.println("Done!");
	}
}// end class CJNA
