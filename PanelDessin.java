import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PanelDessin extends JPanel implements ActionListener
{
	private Controleur ctrl;
	private Graphics2D g2;

    private List<Ville> villeList;
    private List<Route> routeList;

	public PanelDessin ( Controleur ctrl )
	{
		this.ctrl = ctrl;
        this.villeList = new ArrayList<>();
        this.routeList = new ArrayList<>();
	}

	public void actionPerformed ( ActionEvent evt )
	{
		this.repaint();
	}

    public void dessinerVille(int x, int y, String nomVille)
    {
        Ville ville = new Ville(nomVille, x, y);
        this.villeList.add(ville);
        this.repaint();
    }

    public void dessinerRoute(int troncons, Ville villeDepart, Ville villeArrivee)
    {
        Route r = new Route(troncons, villeDepart, villeArrivee);
        this.routeList.add(r);
        this.repaint();
    }

	public void paintComponent(Graphics g)	
	{
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		
        // Dessiner ville
        for (Ville ville : villeList )
        {
            g2.setColor(Color.BLUE);
            g2.fillOval(ville.getX() - 20, ville.getY() - 20, 26, 26);
            g2.setColor(Color.BLACK);
            g2.drawString(ville.getNom(), ville.getX() - 16, ville.getY() - 25);
        }
        
        // Dessiner route
        for(Route route : routeList)
        {
            Ville villeDepart = route.getVilleDepart();
            Ville villeArrivee = route.getVilleArriver();
            g2.setColor(Color.BLACK);
            g2.drawLine(villeDepart.getX(), villeDepart.getY(), villeArrivee.getX(), villeArrivee.getY());
        }

	}

}