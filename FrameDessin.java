import javax.swing.*;
import java.awt.*;

public class FrameDessin extends JFrame {
 
    FrameVille frameVille;
    // FrameRoute frameRoute;

    public FrameDessin()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Réseau routier");
        this.setLocation(50, 20);
        this.setSize(1000, 800);

        frameVille = new FrameVille(this.getWidth() + (int) this.getLocation().getX() + 30, 20);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FrameDessin();
    }
}
