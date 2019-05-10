import java.awt.Dimension;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import com.github.sarxos.webcam.Webcam;

public class Driver {

	/**
	 * the Driver class starts the program and handles the file I/O side of the exicution
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner kb = new Scanner(System.in);
		String path;
		String we;
		
		System.out.println("Whate folder would you like the program to use fore processing? ");
		we = kb.nextLine();
		System.out.println("What Folder would you like the program to save images to? ");
		path = kb.nextLine();

		Webcam wc = Webcam.getDefault(); //gets the default webcam from the computer
		wc.setViewSize(new Dimension(640, 480)); //sets the resolution of the camera
		wc.open();
		
		ImageProcessor ip = new ImageProcessor(wc, we);
		
		int cycles = 0; //controls the amount that the webcam will run
		boolean procceed = true;

		while (procceed == true) {
			if (cycles > 0) {
				ip.takePic(); //calls the takePic function in ImageProcessor
				
				int corners[][];
				corners = ip.proccessImage(); //this returns a [5][4] array that contains entries of the color value in the four corners of the picture

				
				
				for(int i = 0; i < 5; i++)
					{
					/**
					 * this sends each of the five sets of color data to the jpl interface
					 * if it returns true, the image will be moved and renamed.
					 */
						if (ColorChecker.check(corners[i]) == true){
						SaveHandler.save(path, we);
						TimeUnit.SECONDS.sleep(9);
						cycles -= 9;
						break;
						}
					}
			

				--cycles;
				TimeUnit.SECONDS.sleep(1);
			} else {
				/**
				 * when the cycles run out the user is prompted to restart or if 0 is entered the program will end
				 */
						
				System.out.println("How long would you like to keep going for? ");
				cycles = kb.nextInt();
				if (cycles <= 0)
					procceed = false;
			}
		}wc.close();kb.close();

	}

}
