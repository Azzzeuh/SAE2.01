import javax.swing.*;
import java.awt.*;

public class FrameDessin extends JFrame {

    FrameVille frameVille;
    FrameRoute frameRoute;
    PanelDessin panelDessin;

    public FrameDessin( Controleur ctrl ) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Réseau routier");
        this.setLocation(50, 100);
        this.setSize(1000, 800);

        frameRoute = new FrameRoute(this.getWidth() + (int) this.getLocation().getX() + 30, 400, null);
        frameVille = new FrameVille(this.getWidth() + (int) this.getLocation().getX() + 30, + 100, frameRoute, this);

        frameRoute.setFrameVille(frameVille);

        panelDessin = new PanelDessin( ctrl );
    
        this.add(panelDessin);

        this.setVisible(true);
    }

    public PanelDessin getPanelDessin() { return this.panelDessin; }
}
