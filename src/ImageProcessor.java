import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.github.sarxos.webcam.Webcam;

/**
 * The ImageProcessor class takes the picture with the webcam and also handles extracting
 * the color information from the picture.
 * @author Thomas
 *
 */

public class ImageProcessor {
	Webcam wc;
	String we; //this is the folder that the image is saved in

	public ImageProcessor(Webcam wc, String we) {
		this.wc = wc;
		this.we = we;
	}

	public void takePic() throws IOException {
		ImageIO.write(wc.getImage(), "BMP", new File(we + "\\Processing.bmp")); //Takes a picture
	}

	public int[][] proccessImage() throws IOException {
		BufferedImage image;
		File input = new File(we + "\\Processing.bmp");
		image = ImageIO.read(input);

		Color c;
		int values[][] = new int[5][4];

		for (int i = 0; i < 5; i++) {
			/**
			 * This loop reads the color information from the corners and places them in an array
			 */
			c = new Color(image.getRGB(85, 19 + (2 * i)));
			values[i][0] = c.getRGB() & 0xFFFFFF;

			c = new Color(image.getRGB(530, 19 + (2 * i)));
			values[i][1] = c.getRGB() & 0xFFFFFF;

			c = new Color(image.getRGB(530, 454 + (2 * i)));
			values[i][2] = c.getRGB() & 0xFFFFFF;

			c = new Color(image.getRGB(85, 454 + (2 * i)));
			values[i][3] = c.getRGB() & 0xFFFFFF;
		}

		return values;
	}
}
