import javax.swing.*;

import java.awt.*;

public class FrameRoute extends JFrame
{
	private JLabel tronconsJLabel;
	private JLabel departJLabel;
	private JLabel arriveJLabel;

	private JTextField tronconsJTextField;

	private JComboBox departJComboBox;
	private JComboBox arriveJComboBox;

	private JButton validerJButton;

	public FrameRoute()
	{
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle ("Ajouter Routes");
		this.setLocation(10, 10);

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();


		this.setVisible(true);

		// Label
		this.tronconsJLabel = new JLabel("Nombre de tronçons");
		this.departJLabel   = new JLabel("Ville de départ"   );
		this.arriveJLabel   = new JLabel("Ville d'arrivé"    );

		this.departJComboBox = new JComboBox();
		this.arriveJComboBox = new JComboBox();

		this.tronconsJTextField = new JTextField(11);

		this.validerJButton = new JButton("Valider");

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
		this.add(arriveJLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(arriveJComboBox, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		this.add(validerJButton, gbc);

		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] a)
	{
		new FrameRoute();
	}

}
