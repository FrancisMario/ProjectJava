package thePackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Main {
	static Log log = new Log();
	static Date date = new Date();
			//	Listen for incoming Connections 
	@SuppressWarnings("deprecation")
	private static void Listen(int port) throws FileNotFoundException {
		
		
		try {
			
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(port); //Creating a listening Socket
			log.PrepLog("================"+ date.toGMTString()+ "==================");
			log.PrepLog("Server socket Created");
			
			int x = 0;
			while(true) {
			System.out.println("Waiting For connection " + x + " on port: " + port);
			Socket socket =  server.accept();
			log.PrepLog(date.toGMTString() + ": " + socket.getInetAddress() + " has connected");
			Respond respond = new Respond(socket);
			respond.start();
			x++;
			}
		}
		catch (IOException e)
		{
			
			
				
		}
		
	}	
	
		public static void main(String args[]) throws FileNotFoundException {
			
			Listen(9999);
		}
	

}
