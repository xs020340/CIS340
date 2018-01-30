import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteData {

	public static void main(String[] args) {
		
		try {
			File file = new File("testIO/scores.txt");
			file.createNewFile();
			PrintWriter output = new PrintWriter(file);
			
			output.print("John");
			output.println(90);
			output.print("Eric");
			output.println(93);
			
			output.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
