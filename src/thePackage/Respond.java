package thePackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Respond implements Runnable{
	
	private Socket socket = null;
	Log log = new Log();
	
	public Respond(Socket socket)
		{
		this.socket = socket;
		}

	@Override
	public void run() {
		
		try {
//			  To read request from client
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));			
			String code = reader.readLine();
			System.out.println(code);
			int request = Integer.parseInt(code); // converting request to readable code
			
			sortRequest(request);
			
		} catch (IOException e) {
			e.printStackTrace();
				try {
					log.PrepLog(e);
				} catch (Exception e1) {
//					FileNotFound
				}
		}
		
	}
	
//	Sort request for submission to different respond handlers
	public void sortRequest(int request) {
		
		if(request == 0) {
			
		} else if(request == 1) {
			ArticleRequestHandler handler = new ArticleRequestHandler(socket);
			handler.run();
		} else if (request == 2){
			
		} else if(request == 3){
			
		}
		
		
	}
	
	public void start() {
		run();
	}
}
