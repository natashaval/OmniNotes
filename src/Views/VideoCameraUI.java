package Views;

import javax.swing.JFrame;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;


public class VideoCameraUI {
    
    public VideoCameraUI() {
        Webcam webcam = Webcam.getDefault();

        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setFillArea(true);

        JFrame window = new JFrame("Omninotes - Video Camera");
        window.add(panel);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }
    
}
