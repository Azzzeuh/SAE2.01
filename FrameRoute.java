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

	private JComboBox<String> departJComboBox;
	private JComboBox<String> arriverJComboBox;

	private JButton validerJButton;

	private JPanel panelGauche;
	private JPanel panelDroite;

	private FrameVille frameVille;

	/*--------------*/
	/* Instructions */
	/*--------------*/

	public FrameRoute(int x, int y, ArrayList<Ville> listVille)
	{

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 300);
		this.setTitle ("Ajouter Route");
		this.setLocation(x, y);
		this.setLayout(new BorderLayout());


		//Initialisation Liste des Ville et des Route
		this.listVille = listVille != null ? listVille : new ArrayList<>();
		this.listRoute = new ArrayList<>();

		// Initialisation des Label
		this.tronconsJLabel  = new JLabel("Nombre de tronçons");
		this.departJLabel    = new JLabel("Ville de départ"   );
		this.arriverJLabel   = new JLabel("Ville d'arrivé"    );


		// Initialisation des ComboBox
		this.departJComboBox  = new JComboBox<>();
		this.arriverJComboBox = new JComboBox<>();
		MisAJourComboBox(this.listVille);

		//Initialisation du TextField
		this.tronconsJTextField = new JTextField(11);

		//Initialisation du Boutton
		this.validerJButton = new JButton("Valider");


		//Initialisation du Tableau
		this.modelTable = new DefaultTableModel(nomCol, 0);
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

	public void MisAJourListVille(ArrayList<Ville> listVille) 
	{
		this.listVille = listVille;
	}

	public void MisAJourComboBox(ArrayList<Ville> listVille)
	{
		departJComboBox.removeAllItems();
		arriverJComboBox.removeAllItems();
		for(Ville v : listVille)
		{
			departJComboBox.addItem(v.getNom());
			arriverJComboBox.addItem(v.getNom());
		}
	}

	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource() == this.validerJButton)
		{
			int troncons = Integer.parseInt(tronconsJTextField.getText());			
            Ville depart = listVille.get(departJComboBox.getSelectedIndex());
            Ville arriver = listVille.get(arriverJComboBox.getSelectedIndex());
            
			if((troncons >= 1 && troncons <= 10) && depart != null && arriver != null) 
			{
				Route route = new Route(troncons, depart, arriver);
            	listRoute.add(route);
			
				modelTable.addRow(new Object[]{
					route.getNbTroncons(),
					route.getVilleDepart().getNom(),
					route.getVilleArriver().getNom()
					});
				
				frameVille.ajouterRoute(troncons, depart, arriver);

				frameVille.getPanelDessin().dessinerRoute(troncons, depart, arriver);
			}
		}
	}

	public void setFrameVille(FrameVille frameVille)
	{
		this.frameVille = frameVille;
	}


}
