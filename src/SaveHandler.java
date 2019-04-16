import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveHandler {

	public static void save(String path, String we) {
		DateFormat df = new SimpleDateFormat("MM_dd_yyyy HH.mm.ss");
		Date date = new Date();
		
		File image = new File(we + "\\Processing.bmp");
		File destination = new File(path + "\\Notes_" + df.format(date) + ".bmp");
		//File destination = new File("E:\\Programs\\Eclipse\\Workspace\\CS_4080_PrologProject\\PicsGoHere\\Processed.bmp");
		
		if (image.renameTo(destination) == true) {
			System.out.println("Save successful");
		}
		else {
			System.out.println("Save failed.");
		}
	}
	
}
