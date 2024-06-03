public class Route {
    
    private int nbTroncons;
    private Ville villeDepart;
    private Ville villeArriver;
    public Route(int nbTroncons, Ville villeDepart, Ville villeArriver)
    {
        if((nbTroncons >= 0 && nbTroncons <= 10) && villeDepart != null && villeArriver != null)
        {
            this.nbTroncons = nbTroncons;
            this.villeDepart = villeDepart;
            this.villeArriver = villeArriver;
        }
    }

    public int getNbTroncons() { return this.nbTroncons; }
    public Ville getVilleDepart() { return this.villeDepart; }
    public Ville getVilleArriver() { return this.villeArriver; }
    
}
