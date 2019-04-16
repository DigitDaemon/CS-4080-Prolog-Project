import java.awt.Dimension;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.github.sarxos.webcam.Webcam;

public class Driver {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner kb = new Scanner(System.in);
		String path;
		String we;
		
		System.out.println("Whate folder would you like the program to use fore processing? ");
		we = kb.nextLine();
		System.out.println("What Folder would you like the program to save images to? ");
		path = kb.nextLine();

		Webcam wc = Webcam.getDefault();
		wc.setViewSize(new Dimension(640, 480));
		wc.open();
		
		ImageProcessor ip = new ImageProcessor(wc, we);
		
		int cycles = 0;
		boolean procceed = true;

		while (procceed == true) {
			if (cycles > 0) {
				//ip.takePic();
				ip.testPic();
				int corners[];
				corners = ip.proccessImage();

				/*System.out.println("top left corner, blue");
				System.out.println("Red :" + corners[0][0]);
				System.out.println("Green :" + corners[0][1]);
				System.out.println("Blue :" + corners[0][2]);
				System.out.println("");

				System.out.println("top right corner, Red");
				System.out.println("Red :" + corners[1][0]);
				System.out.println("Green :" + corners[1][1]);
				System.out.println("Blue :" + corners[1][2]);
				System.out.println("");

				System.out.println("bottom right corner, purple");
				System.out.println("Red :" + corners[2][0]);
				System.out.println("Green :" + corners[2][1]);
				System.out.println("Blue :" + corners[2][2]);
				System.out.println("");

				System.out.println("bottom left corner, green");
				System.out.println("Red :" + corners[3][0]);
				System.out.println("Green :" + corners[3][1]);
				System.out.println("Blue :" + corners[3][2]);
				System.out.println("");*/
				
				if (ColorChecker.check(corners) == true) 
					{SaveHandler.save(path, we);}

				--cycles;
				TimeUnit.SECONDS.sleep(1);
			} else {
				System.out.println("How long would you like to keep going for? ");
				cycles = kb.nextInt();
				if (cycles <= 0)
					procceed = false;
			}
		}
		wc.close();
		kb.close();
	}

	static boolean placeholder() {
		return true;
	}
}
