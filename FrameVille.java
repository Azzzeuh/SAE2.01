import javax.swing.*;

import java.awt.*;

public class FrameVille extends JFrame{

    private JLabel nomJLabel;
    private JLabel xJLabel;
    private JLabel yJLabel;

    private JTextField nomJTextField;
    private JTextField xJTextField;
    private JTextField yJTextField;
    private JButton validerJButton;

    public FrameVille()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Ajouter Ville");
        this.setLocation(10, 10);

        //Layout de la frame
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Initialisation Label
        this.nomJLabel = new JLabel("nom : ");
        this.xJLabel = new JLabel("x : ");
        this.yJLabel = new JLabel("y : ");
        
        //Initialisation TextField
        this.nomJTextField = new JTextField(11);
        this.xJTextField = new JTextField(6);
        this.yJTextField = new JTextField(6);

        //Initialisation Button
        this.validerJButton = new JButton("Valider");

        //Ajout des composants 
        Insets insets = new Insets(10, 10, 10, 5);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = insets;
        this.add(nomJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(nomJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(xJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(xJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(yJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(yJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        this.add(validerJButton, gbc);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FrameVille();
    }
}
