import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class FrameVille extends JFrame{

    private JTable tableVille;
    private String[] nomCol = { "Numéro", "Nom", "X", "Y"};
    private String[][] model;

    private ArrayList<Ville> listVille;

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
        this.setTitle("Ville");
        this.setLocation(10, 10);

        //Layout de la frame
        this.setLayout(new GridLayout(1, 2));

        //Initialisation Label
        this.nomJLabel = new JLabel("nom : ");
        this.xJLabel = new JLabel("x : ");
        this.yJLabel = new JLabel("y : ");
        
        //Initialisation TextField
        this.nomJTextField = new JTextField(11);
        this.xJTextField = new JTextField(6);
        this.yJTextField = new JTextField(6);

        //Initialisation Button
        this.validerJButton = new JButton("Ajouter");

        //Initialisation Table
        this.listVille = new ArrayList<>();
        this.model = new String[listVille.size()][4];
        for(int i = 0; i < 4; i++)



        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FrameVille();
    }
}
