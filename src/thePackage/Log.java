package thePackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Log {
		
	Date date = new Date();
	
	
	// Preping the log ..
	public void PrepLog(String content) throws IOException {
			
			File file = new File("C:\\ServerLogs\\System.log"); //System log location
			FileWriter print = new FileWriter(file,true);
			BufferedWriter buffer = new BufferedWriter(print);
			PrintWriter writer = new PrintWriter(buffer);
				writer.println( content);
				writer.flush();
				writer.close();
	
	
	}


	public void PrepLog(Exception e) throws IOException{
		File file = new File("C:\\ServerLogs\\Error.log"); // Errorlog Location
		FileWriter print = new FileWriter(file,true);
		BufferedWriter buffer = new BufferedWriter(print);
		PrintWriter writer = new PrintWriter(buffer);
			writer.println(e);
			writer.flush();
			writer.close();
		
}
	}