import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ActionReader {
	
	private static final String FILENAME = "export.txt";	
	private FileReader fr;
	private BufferedReader br;
	
	public ActionReader() {

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void read() {
		try {
			String line;
			do {
				line = br.readLine();
				//for() {
					
				//}
				
			}
			while(line != null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
