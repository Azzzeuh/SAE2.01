import javax.swing.*;

import java.awt.*;

public class FrameRoute extends JFrame
{
	/*--------------*/
	/* Variables    */
	/*--------------*/

	private JLabel tronconsJLabel;
	private JLabel departJLabel;
	private JLabel arriverJLabel;

	private JTextField tronconsJTextField;

	private JComboBox departJComboBox;
	private JComboBox arriverJComboBox;

	private JButton validerJButton;

	private int   nbTroncons;
	private Ville villeDepart;
	private Ville villeArriver;

	/*private ArrayList<Ville> listeVille;*/


	/*--------------*/
	/* Instructions */
	/*--------------*/

	public FrameRoute()
	{

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle ("Ajouter Routes");
		this.setLocation(10, 10);

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		this.setVisible(true);



		// Initialisation des Label
		this.tronconsJLabel = new JLabel("Nombre de tronçons");
		this.departJLabel   = new JLabel("Ville de départ"   );
		this.arriverJLabel   = new JLabel("Ville d'arrivé"    );

		// Initialisation des ComboBox
		this.departJComboBox = new JComboBox(/*this.listeVille*/);
		this.arriverJComboBox = new JComboBox(/*this.listeVille*/);

		//Initialisation du TextField
		this.tronconsJTextField = new JTextField(11);

		//Initialisation du Boutton
		this.validerJButton = new JButton("Valider");


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
