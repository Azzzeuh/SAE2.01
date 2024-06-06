import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PanelDessin extends JPanel implements ActionListener, MouseListener, MouseMotionListener
{
	private Controleur ctrl;

    private ArrayList<Ville> villeList;
    private ArrayList<Route> routeList;

    private Ville villeSelectionner;

    private FrameVille frameVille;
    private FrameRoute frameRoute;

    private JTable tableVille;

    private int nvX;
    private int nvY;

	public PanelDessin ( Controleur ctrl , FrameVille frameville, FrameRoute frameRoute)
	{
		this.ctrl = ctrl;
        this.frameVille = frameville;
        this.tableVille = frameville.getTableVille();
        this.frameRoute = frameRoute;
        this.villeList = new ArrayList<>();
        this.routeList = new ArrayList<>();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
	}

	public void actionPerformed ( ActionEvent evt )
	{
		this.repaint();
	}

    public void setRouteList(ArrayList<Route> routeList) {
        this.routeList = routeList;
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

    public void redessinerRoute() 
    {
        repaint();
    }

	public void paintComponent(Graphics g)	
	{
		super.paintComponent(g);

        // Dessiner route
        for(Route route : routeList)
        {
            Ville villeDepart = route.getVilleDepart();
            Ville villeArrivee = route.getVilleArriver();
            g.setColor(Color.BLACK);
            g.drawLine(villeDepart.getX(), villeDepart.getY(), villeArrivee.getX(), villeArrivee.getY());
        }

        // Dessiner ville
        for (Ville ville : villeList )
        {
            g.setColor(Color.BLUE);
            g.fillOval(ville.getX() - 13, ville.getY() - 13, 26, 26);
            g.setColor(Color.BLACK);
            g.drawOval(ville.getX() - 13, ville.getY() - 13, 26, 26);
            g.drawString(ville.getNom(), ville.getX() - 16, ville.getY() - 25);
        }

	}

    public Ville getVilleSelectionner (int x, int y)
    {
        for(Ville ville : villeList) 
        {
            int dx = x - ville.getX();
            int dy = y - ville.getY();
            if(Math.sqrt(dx * dx + dy * dy) < 13)
            {
                return ville;
            }
        }

        return null;
    }

    public void mousePressed(MouseEvent e)
    {
        int x = e.getX(); 
        int y = e.getY();
        villeSelectionner = getVilleSelectionner(x, y);

        if (villeSelectionner != null) {
            nvX = x - villeSelectionner.getX();
            nvY = y - villeSelectionner.getY();
        }

    }

    public void mouseDragged(MouseEvent e)
    {
        if( villeSelectionner != null)
        {
            villeSelectionner.setX(e.getX() - nvX);
            villeSelectionner.setY(e.getY() - nvY);

            for(Ville v : villeList)
            {
                if ( v == villeSelectionner )
                {
                    v.setX(e.getX());
                    v.setY(e.getY());
                }
            }

            this.frameRoute.MisAJourListVille(villeList);

            int indLig = villeList.indexOf(villeSelectionner);
            if (indLig != -1) {
                tableVille.setValueAt(e.getX(), indLig, 2);
                tableVille.setValueAt(e.getY(), indLig, 3); 
            }
        }
        
        redessinerRoute();
    }

    public void mouseReleased(MouseEvent e)
    {
        villeSelectionner = null;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}