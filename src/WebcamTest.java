import javax.swing.JFrame;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;


public class WebcamTest {

	public static void main(String[] args) throws InterruptedException, IOException {

		Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(new Dimension(320, 240));
//
		WebcamPanel panel = new WebcamPanel(webcam);
		panel.setFPSDisplayed(true);
		panel.setDisplayDebugInfo(true);
		panel.setImageSizeDisplayed(true);
		panel.setMirrored(true);
                
                
                JPanel btnPanel = new JPanel();

		JFrame window = new JFrame("Test webcam panel");
                window.setSize(new Dimension(800, 600));
                JButton  btn = new JButton();
                btn.setText("Capture hehe");
                btn.setSize(new Dimension(30,20));
		window.add(panel);
                panel.setMaximumSize(new Dimension(150, 150));
//                window.add(btnPanel);
//                window.add(btn);
		window.setResizable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
                
                webcam.open();

		// get image
		BufferedImage image = webcam.getImage();

		// save image to PNG file
                ImageIO.write(image, "PNG", new File("test.png"));
	}
}