import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ActionWriter {
	
	private static final String FILENAME = "export.txt";	
	private FileWriter fw;
	private BufferedWriter bw;
	
	public ActionWriter() {

		try {
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(String name, Object[] args) {
		String line = name;
		for(int i = 0; i < args.length; i++){
			line += " " + args[i].toString();
		}
		try {
			bw.write(line + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
