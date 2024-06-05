import java.util.ArrayList;

public class Ville {

    private static int nbVille = 0;
    private int numVille;
    private String nom;
    private int x;
    private int y;
    private ArrayList<Route> listeRoute;

    public Ville(String nom, int x, int y)
    {
        if(nom != null && (x >= 0 && x <= 1000) && (y >= 0 && y <= 800))
        {
            this.nom = nom;
            this.x = x;
            this.y = y;
            this.numVille = ++nbVille;
        }
    }

    public String getNom                 () { return this.nom; }
    public int getX                      () { return this.x; }
    public int getY                      () { return this.y; }
    public int getNumVille               () { return this.numVille; }
    public ArrayList<Route> getListeRoute() { return this.listeRoute; } 
    public Ville getVille() { return this; }

    public void setNom  (String nom) { if(nom != null && nom != this.nom) this.nom = nom; }
    public void setX    (int x)      { if(x >= 0 && x <= 1000) this.x = x; }
    public void setY    (int y)      { if(y >= 0 && y <= 800 ) this.y = y; }
    
    public boolean ajouterRoute(Route route)
    {
        if(route != null)
        {
            this.listeRoute.add(route);
            return true;
        }
        return false;
    }

    public boolean supprimerRoute(Route route)
    {
        if(route != null)
        {
            this.listeRoute.remove(route);
            return true;
        }
        return false;
    }
}