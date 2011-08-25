import java.io.IOException;
import java.util.Properties;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


import parser.FeedParser;
import cjna.GetNewsList;
import cjna.Global;

/**
 * @author Pree
 */

public class CJNA {
	public static void main(String args[]) throws IOException, InterruptedException{
	
		
		
		GetNewsList myList = new GetNewsList();
		myList.run();
		myList.join();
		
		Vector<FeedParser> fps = new Vector<FeedParser>();
		
		// show the news list and initialize threads
		System.out.println("News List are as following: ");
		for(int i = 0; i < Global.URI.size(); i++) {
			System.out.println(Global.URI.get(i));
			FeedParser fp = new FeedParser(Global.URI.get(i));
			fps.add(fp);
		}
		System.out.println();
		
		// wait for this thread to die
		
		
		for(int i = 0; i < Global.URI.size(); i++) {
			try {
				
				fps.elementAt(i).run();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
