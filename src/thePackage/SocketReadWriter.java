/*
 * Writes To the Active Socket
 * Reads from the socket;
 * returns if written successfully otherwise false
 * Author Scragger
 * */

package thePackage;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketReadWriter {
	
	private Socket socket;
	Log log = new Log();
	public SocketReadWriter(Socket socket) {
		this.socket = socket;
	}
	
	
	public String read() throws IOException {
		
		try {
			InputStreamReader r = new InputStreamReader(socket.getInputStream());
			BufferedReader buffer = new BufferedReader(r); 
			String value = buffer.readLine();
			if(value != null) {
				
				return value;
			} else
			{
				return "-1";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.PrepLog(e);
			return "-1";
		}
		
	}
	

	public Boolean write(String content) throws IOException {
	
		try {

			DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
			writer.write(content.getBytes());
			writer.flush();
			writer.close();
			return true;
		} catch (IOException e) {
			log.PrepLog(e);
		} 
		
		return false;
		
	}

}
