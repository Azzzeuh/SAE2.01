public class Route {

	private int   nbTroncons;
	private Ville villeDepart;
	private Ville villeArriver;

	// Fabrique de Route
	public static Route creerRoute(int nbTroncons, Ville villeDepart, Ville villeArriver)
	{
		if(nbTroncons <= 0 || nbTroncons >= 10) { return null; }
		else if(villeDepart  == null)           { return null; }
		else if(villeArriver == null)           { return null; }
		else { return new Route(nbTroncons, villeDepart, villeArriver); }
	}


	private Route(int nbTroncons, Ville villeDepart, Ville villeArriver)
	{
		this.nbTroncons   = nbTroncons;
		this.villeDepart  = villeDepart;
		this.villeArriver = villeArriver;

	}

	// Accesseurs
	public int getNbTroncons()     { return this.nbTroncons;   }
	public Ville getVilleDepart()  { return this.villeDepart;  }
	public Ville getVilleArriver() { return this.villeArriver; }
}
