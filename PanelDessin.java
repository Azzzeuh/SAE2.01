import javax.swing.*;
import java.awt.event.*;

import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PanelDessin extends JPanel implements ActionListener
{
	private Controleur ctrl;
	private JButton    btnAction;
	private Graphics2D g2;

	private JTextField txtCoordX;
	private JTextField txtCoordY;

	private Image      imgFond;


	public PanelDessin ( Controleur ctrl )
	{
		this.ctrl = ctrl;

		JPanel panelTracer, panelAction;

		this.setLayout ( new BorderLayout() );

		// crÃ©ation des composants;
		panelTracer  = new JPanel ();
		panelAction  = new JPanel ();

		panelTracer.setOpaque ( false );
		panelAction.setOpaque ( false );
		
		this.btnAction = new JButton ( "Action" );

		this.txtCoordX = new JTextField ( 10 );
		this.txtCoordY = new JTextField ( 10 );


		// positionnement des composants
		panelAction.add ( new JLabel ( "x :") );
		panelAction.add ( this.txtCoordX );
		
		panelAction.add ( new JLabel ( "y :") );
		panelAction.add ( this.txtCoordY );
		
		panelAction.add ( this.btnAction );


		this.add ( panelTracer, BorderLayout.CENTER );
		this.add ( panelAction, BorderLayout.SOUTH  );


		// activation des composants
		this.btnAction.addActionListener(this);
	}

	public void actionPerformed ( ActionEvent evt )
	{
		this.repaint();
	}

	

	public void paintComponent(Graphics g)			// @1
	{
		int x, y;

		super.paintComponent(g);

		g2 = (Graphics2D) g;
		
		
		// Ajout de l'image du fond
		if ( imgFond != null )
		{
			g2.drawImage ( imgFond, 0 , 0 ,this );
		}
		
		try 
		{
			x = Integer.parseInt( this.txtCoordX.getText() );
			y = Integer.parseInt( this.txtCoordY.getText() );

			g2.drawRect ( x-50, y-75, 100, 150 );

		} catch (Exception e) {}

		
	}

}



/*------*/
/*  @1  */
/*-----------------------------------------------------------------------------------------------------*/
/* Vous remarquerez que l'on dessine sur la Panel Principal                                            */
/*                                                                                                     */
/* PanelTracer nous sert strictement Ã  rien                                                            */
/*-----------------------------------------------------------------------------------------------------*/