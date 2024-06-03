import javax.swing.*;

import java.awt.*;

public class FrameRoute extends JFrame implements ActionListener
{
	/*--------------*/
	/* Variables    */
	/*--------------*/

	private JTable tableVille;
	private String[] nomCol = {"Ville de départ", "Ville d'arriver", "Nombre de tronçons"};
	private String[][] modelTable;

	private ArrayList<Ville> listeVille;

	private JLabel tronconsJLabel;
	private JLabel departJLabel;
	private JLabel arriverJLabel;

	private JTextField tronconsJTextField;

	private JComboBox<Ville> departJComboBox;
	private JComboBox<Ville> arriverJComboBox;

	private JButton validerJButton;

	private JPanel panelGauche;
	private JPanel panelDroite;

	private int   nbTroncons;
	private Ville villeDepart;
	private Ville villeArriver;

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

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		this.setVisible(true);



		// Initialisation des Label
		this.tronconsJLabel  = new JLabel("Nombre de tronçons");
		this.departJLabel    = new JLabel("Ville de départ"   );
		this.arriverJLabel   = new JLabel("Ville d'arrivé"    );

		// Initialisation des ComboBox
		this.departJComboBox = new JComboBox<Ville>(this.listeVille);
		this.arriverJComboBox = new JComboBox<Ville>(this.listeVille);

		//Initialisation du TextField
		this.tronconsJTextField = new JTextField(11);

		//Initialisation du Boutton
		this.validerJButton = new JButton("Valider");

		this.panelGauche = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		this.listVille = new ArrayList<>();
		this.listVille.add(new Ville("test", 1, 1));
		this.modelTable = new String[this.listVille.size()][4];
		for(int i = 0; i < listVille.size(); i++)
		{
			this.modelTable[i][0] = String.valueOf(this.listVille.get(i).getNumVille());
			this.modelTable[i][1] = this.listVille.get(i).getNom();
			this.modelTable[i][2] = String.valueOf(this.listVille.get(i).getX());
			this.modelTable[i][3] = String.valueOf(this.listVille.get(i).getY());
		}


		// Ajout des Composants
		Insets insets = new Insets(10, 10, 10, 5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = insets;
		this.add(tronconsJLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(tronconsJTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(departJLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(departJComboBox, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(arriverJLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(arriverJComboBox, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		this.add(validerJButton, gbc);

		this.pack();
		this.setVisible(true);
	}

/*
	public void itemStateChanged(ItemEvent e) 
	{
		// si l'état d'un combobox est modifiée 
		switch (e.getSource()) {
			case deparComboBox:
				this.villeDepart = villeDepart.getSelectedItem();
			case arriverComboBox:
				this.villeArriver = villeArriver.getSelectedItem();
			default:
				this.villeDepart = null;
				break;
			}
	}
*/

	public static void main(String[] a)
	{
		new FrameRoute();
	}

}
