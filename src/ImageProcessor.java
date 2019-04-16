import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

public class ImageProcessor {
	Webcam wc;
	String we;
	public ImageProcessor(Webcam wc, String we)
	{
		this.wc = wc;
		this.we = we;
	}
	
	public void takePic() throws IOException {
		ImageIO.write(wc.getImage(), "BMP", new File(we + "\\Processing.bmp"));
	}
	
	public void testPic(){
		
	}
	
	
	public int[] proccessImage() throws IOException {
		BufferedImage image;
		File input = new File(we + "\\Processing.bmp");
		image = ImageIO.read(input);
		
		Color c;
		
		int values[] = new int[4];
		c = new Color(image.getRGB(85, 25));
		values[0] = c.getRGB();
		/*values[0][0] = c.getRed();
		values[0][1] = c.getGreen();
		values[0][2] = c.getBlue();*/
		
		c = new Color(image.getRGB(530, 25));
		values[1] = c.getRGB();
		/*values[1][0] = c.getRed();
		values[1][1] = c.getGreen();
		values[1][2] = c.getBlue();
		image.setRGB(620, 20, Color.white.hashCode());*/
		
		c = new Color(image.getRGB(530, 460));
		values[2] = c.getRGB();
		/*values[2][0] = c.getRed();
		values[2][1] = c.getGreen();
		values[2][2] = c.getBlue();
		image.setRGB(620, 460, Color.white.hashCode());*/
		
		c = new Color(image.getRGB(85, 460));
		values[3] = c.getRGB();
		/*values[3][0] = c.getRed();
		values[3][1] = c.getGreen();
		values[3][2] = c.getBlue();
		image.setRGB(20, 460, Color.white.hashCode());*/
		
		return values;
	}
}
