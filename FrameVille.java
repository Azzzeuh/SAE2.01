import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; 

public class FrameVille extends JFrame implements ActionListener{

    private JTable tableVille;
    private String[] nomCol = { "Numéro", "Nom", "X", "Y"};
    private DefaultTableModel modelTable;

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

    private FrameRoute frameRoute;
    private FrameDessin frameDessin;
    private PanelDessin panelDessin;

    public FrameVille(int x, int y, FrameRoute frameRoute, FrameDessin frameDessin)
    {
        this.frameRoute = frameRoute;
        this.frameDessin = frameDessin;
        this.panelDessin = frameDessin.getPanelDessin();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Ajouter Ville");
        this.setLocation(x, y);
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

        this.modelTable = new DefaultTableModel(nomCol, 0);
        

        this.tableVille = new JTable(modelTable);
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
        this.modifierJButton.addActionListener( this );
    
        this.add(panelGauche, BorderLayout.WEST);
        this.add(panelDroite, BorderLayout.EAST);

        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.ajouterJButton)
        {
            String nom = "";
            int x = -1;
            int y = -1;
    
            if( nomJTextField.getText() != null &&
                  xJTextField.getText() != null &&
                  yJTextField.getText() != null )
            {
                nom = nomJTextField.getText();
                x = Integer.parseInt(xJTextField.getText());
                y = Integer.parseInt(yJTextField.getText());
            }
            if(nom != null && (x > 0 && x < 1000) && (y > 0 && y < 800))
            {
                Ville v = new Ville(nom, x, y);
                this.listVille.add(v);
            
                frameDessin.getPanelDessin().dessinerVille(x, y, nom);

                this.modelTable.addRow(new Object[]{
                    v.getNumVille(),
                    v.getNom(),
                    v.getX(),
                    v.getY()
                });

                if (frameRoute != null) 
                {
                    frameRoute.MisAJourListVille(this.listVille);
                    frameRoute.MisAJourComboBox(this.listVille);

                    frameDessin.getPanelDessin().setRouteList(frameRoute.getListRoute());
                    
                    frameDessin.getPanelDessin().redessinerRoute();
                }
            }
        }

        if(e.getSource() == this.modifierJButton)
        {
            int ligneSelectionner = tableVille.getSelectedRow();
            if( ligneSelectionner != -1 )
            {
                Ville ville = listVille.get(ligneSelectionner);
                ville.setNom(nomJTextField.getText());
                ville.setX(Integer.parseInt(xJTextField.getText()));
                ville.setY(Integer.parseInt(yJTextField.getText()));

                modelTable.setValueAt(ville.getNom(), ligneSelectionner, 1);
                modelTable.setValueAt(ville.getX(), ligneSelectionner, 2);
                modelTable.setValueAt(ville.getY(), ligneSelectionner, 3);

                panelDessin.repaint();
            }
        }
    }

    public JTable getTableVille() { return this.tableVille; }
    public ArrayList<Ville> getListVille  ()    { return listVille  ; }
    public PanelDessin      getPanelDessin()    { return panelDessin; }
    public void setFrameDessin(FrameDessin frameDessin) { this.frameDessin = frameDessin; }

    public void ajouterRoute(int troncons, Ville villeDepart, Ville villeArrivee) {
        frameDessin.getPanelDessin().dessinerRoute(troncons, villeDepart, villeArrivee);
        frameDessin.getPanelDessin().redessinerRoute();
    }

    
}
