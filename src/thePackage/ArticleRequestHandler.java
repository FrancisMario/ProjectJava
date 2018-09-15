/*Handler for Article related request
 * Sends articles to client
 *Author:Scragger
 *Version: 1.0
 */
package thePackage;

import java.io.IOException;
import java.net.Socket;

public class ArticleRequestHandler implements Runnable{
			
	private Socket ip;
	
	public ArticleRequestHandler(Socket socket) 
	{
		this.ip = socket;
	}


	@Override
	public void run() {
		SocketReadWriter book = new SocketReadWriter(ip);
			
		try {
			book.write("200"); // send code 200 to signal ready
		String code = book.read(); // reads respond 
		
		/*Request codes
		 * ART0: All articles Ever Created;
		 * ART1: Main Article Feed;
		 * 
		 * */
		if(code.equals("ART0")) {
			
			book.write(getAllArticlesEver());
			
		} else if(code.equals("ART1")) {
			
			book.write(getMainArticleFeed());
			
		} else if(code.equals("ART2")) {
			
		} else {
			book.write("400");
		}
		
		} 
		catch (IOException e) {}
		
	}
	
	public String getMainArticleFeed() {
		
		return null;
	}
	
	public String getSpecificArticle(String ArticleId) {
		
		return null;
	}
	
	public String getAllArticlesEver() {
		
		return null;
	}
}
