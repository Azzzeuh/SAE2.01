import javax.swing.*;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; 

public class FrameVille extends JFrame implements ActionListener{

    private JTable tableVille;
    private String[] nomCol = { "Numéro", "Nom", "X", "Y"};
    private String[][] modelTable;

    private ArrayList<Ville> listVille;

    private JLabel nomJLabel;
    private JLabel xJLabel;
    private JLabel yJLabel;

    private JPanel panelGauche;
    private JPanel panelDroite;

    private JTextField nomJTextField;
    private JTextField xJTextField;
    private JTextField yJTextField;

    private JButton ajouterJButton;
    private JButton modifierJButton;


    public FrameVille()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Ville");
        this.setLocation(10, 10);
        this.setSize(600, 300);
        this.setLayout(new BorderLayout());

        //Initialisation Label
        this.nomJLabel = new JLabel("Nom : ");
        this.xJLabel = new JLabel("X : ");
        this.yJLabel = new JLabel("Y : ");
        
        //Initialisation TextField
        this.nomJTextField = new JTextField(9);
        this.xJTextField = new JTextField(6);
        this.yJTextField = new JTextField(6);

        //Initialisation Button
        this.ajouterJButton = new JButton("Ajouter");
        this.modifierJButton = new JButton("Modifier");

        //Initialisation Table et côté gauche
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

        this.tableVille = new JTable(modelTable, nomCol);
        this.add(tableVille);

        tableVille.setFont(new Font("Arial", Font.PLAIN, 15));
        tableVille.setRowHeight(20);
        tableVille.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(tableVille);
        scrollPane.setPreferredSize(new Dimension(500, 200));
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.panelGauche.add(scrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 5, 5, 20);
        this.panelGauche.add(modifierJButton, gbc);

        //Initialisation panel droite 
        this.panelDroite = new JPanel(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();

            // Ajout nom
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        this.panelDroite.add(nomJLabel, gbc2);

        gbc2.gridx = 1;
        gbc2.gridy = 0;
        this.panelDroite.add(nomJTextField, gbc2);

            // Ajout X
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        this.panelDroite.add(xJLabel, gbc2);
    
        gbc2.gridx = 1;
        gbc2.gridy = 1;
        this.panelDroite.add(xJTextField, gbc2);

            // Ajout Y
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        this.panelDroite.add(yJLabel, gbc2);

        gbc2.gridx = 1;
        gbc2.gridy = 2;
        this.panelDroite.add(yJTextField, gbc2);

            // Ajout Ajouterbouton
        gbc2.gridx = 0;
        gbc2.gridy = 3;
        gbc2.gridwidth = 2;
        this.panelDroite.add(ajouterJButton, gbc2);

        this.ajouterJButton.addActionListener( this );

    
        this.add(panelGauche, BorderLayout.WEST);
        this.add(panelDroite, BorderLayout.EAST);

        this.pack();
        this.setVisible(true);
    }

    public ArrayList<Ville> getListVille() { return listVille; }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.ajouterJButton)
        {
            String nom = nomJTextField.getText();
            int x = Integer.parseInt(xJTextField.getText());
            int y = Integer.parseInt(yJTextField.getText());
            this.listVille.add(new Ville(nom, x, y));
            
        }
    }

    public static void main(String[] args) {
        new FrameVille();
    }
}
