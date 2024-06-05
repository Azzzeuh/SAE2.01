import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; 

public class FrameRoute extends JFrame implements ActionListener
{
	/*--------------*/
	/* Variables    */
	/*--------------*/

	private JTable tableRoute;
	private String[] nomCol = {"Nombre de tronçons", "Ville de départ", "Ville d'arriver"};
	private DefaultTableModel modelTable;

	private ArrayList<Ville> listVille;
	private ArrayList<Route> listRoute;

	private JLabel tronconsJLabel;
	private JLabel departJLabel;
	private JLabel arriverJLabel;

	private JTextField tronconsJTextField;

	private JComboBox departJComboBox;
	private JComboBox arriverJComboBox;

	private JButton validerJButton;

	private JPanel panelGauche;
	private JPanel panelDroite;

	private Ville[] array;

	/*--------------*/
	/* Instructions */
	/*--------------*/

	public FrameRoute()
	{

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 300);
		this.setTitle ("Ajouter Routes");
		this.setLocation(10, 10);
		this.setLayout(new BorderLayout());



		//Initialisation Liste des Ville et des Route
		this.listVille = new ArrayList<>();
		Ville v1 = new Ville("test", 1, 1);
		Ville v2 = new Ville("test2", 2, 15);
		this.listVille.add(v1);
		this.listVille.add(v2);
		array = listVille.toArray(new Ville[listVille.size()]);

		this.listRoute = new ArrayList<>();



		// Initialisation des Label
		this.tronconsJLabel  = new JLabel("Nombre de tronçons");
		this.departJLabel    = new JLabel("Ville de départ"   );
		this.arriverJLabel   = new JLabel("Ville d'arrivé"    );

		// Initialisation des ComboBox
		this.departJComboBox  = new JComboBox();
		this.arriverJComboBox = new JComboBox();
		for (Ville item : listVille)
		{
			String nom = item.getNom();

			departJComboBox.addItem(nom);
			arriverJComboBox.addItem(nom);
		}

		//Initialisation du TextField
		this.tronconsJTextField = new JTextField(11);

		//Initialisation du Boutton
		this.validerJButton = new JButton("Valider");



		//Initialisation du Tableau
		this.modelTable = new DefaultTableModel(nomCol, 0);
		for (Route route : listRoute)
		{
			this.modelTable.addRow(new Object[]
			{
				route.getNbTroncons(),
				route.getVilleDepart(),
				route.getVilleArriver()
			});
		}

		this.tableRoute = new JTable(modelTable);
		this.add(tableRoute);

		tableRoute.setFont(new Font("Arial", Font.PLAIN, 15));
		tableRoute.setRowHeight(20);
		tableRoute.getTableHeader().setReorderingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(tableRoute);
		scrollPane.setPreferredSize(new Dimension(500, 200));



		// Ajout des Composants

		// Panel Gauche
		this.panelGauche = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		this.panelGauche.add(scrollPane, gbc);

		// Panel Droit
		this.panelDroite = new JPanel(new GridBagLayout());
		GridBagConstraints gbc2 = new GridBagConstraints();

			// Ajout Troçons
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		this.panelDroite.add(tronconsJLabel, gbc2);

		gbc2.gridx = 1;
		gbc2.gridy = 0;
		this.panelDroite.add(tronconsJTextField, gbc2);

			// Ajout Ville Départ
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		this.panelDroite.add(departJLabel, gbc2);

		gbc2.gridx = 1;
		gbc2.gridy = 1;
		this.panelDroite.add(departJComboBox, gbc2);

			// Ajout Ville Arriver
		gbc2.gridx = 0;
		gbc2.gridy = 2;
		this.panelDroite.add(arriverJLabel, gbc2);

		gbc2.gridx = 1;
		gbc2.gridy = 2;
		this.panelDroite.add(arriverJComboBox, gbc2);

			// Ajout Bouton Valider
		gbc2.gridx = 0;
		gbc2.gridy = 3;
		gbc2.gridwidth = 2;
		this.panelDroite.add(validerJButton, gbc2);

		this.validerJButton.addActionListener( this );

		this.add(panelGauche, BorderLayout.WEST);
		this.add(panelDroite, BorderLayout.EAST);

		this.pack();
		this.setVisible(true);
	}


	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.validerJButton)
		{
			int   nbTroncons  = Integer.parseInt(tronconsJTextField.getText());
			Ville depart      = new Ville("test3", 4 , 20); // listeVille avec le num
			Ville arriver     = new Ville("test", 1, 1);
			Route r = new Route(nbTroncons, depart, arriver);
			//depart.ajouterRoute(r);
			//arriver.ajouterRoute(r);
			this.listRoute.add(r);

			this.modelTable.addRow(new Object[]{
				r.getNbTroncons(),
				r.getVilleDepart().getNom(),
				r.getVilleArriver().getNom(),
			});
		}
	}

	public static void main(String[] a)
	{
		new FrameRoute();
	}

}
