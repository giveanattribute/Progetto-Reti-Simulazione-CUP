package frames;
/*
 * Questa classe serve per creare la finestra di login per gli utenti.
 */

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/* Invece di instanziare un oggetto di tipo JFrame estendiamo la nostra classe
 * e successivamente implementiamo ActionListner che ci servira' per gli eventi
 * "Azione" dei buttons.
 */

public class RicettaFrame extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	private JPanel loginPanel;
	private JLabel[] labels = new JLabel[3];
	private JTextField[] textFields = new JTextField[2];
	private JButton[] buttons = new JButton[2];
	
	/* Costruttore con accesso "private" per la regola del design pattern Singleton.
	 * Al suo interno inserisco tutti i metodi necessari alla costruzione della
	 * finestra del login.
	 */
	public RicettaFrame()
	{
		super("Ricetta");
		super.setSize(new Dimension(350,350));
		setupTextField();
		setupButtons();
		setupLabels();
		setupPanel();
		super.add(loginPanel);
		super.setLocation(new Point(400,100));
		super.setVisible(true);
		super.setResizable(false);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/*
	 * Con il seguente metodo installo all'interno della finestra del login
	 * gli oggetti di tipo grafico necessari alla sua completazza.
	 * All'interno vi sono tre cicli for con i quali aggiungo alla mia finestra
	 * login le labels, i textFields e i buttons necessari.
	 */
	private void setupPanel()
	{
		loginPanel = new JPanel();
		loginPanel.setVisible(true);
		loginPanel.setLayout(null);
		
		for(int i=0; i<labels.length; i++)
			loginPanel.add(labels[i]);
		
		for(int i=0; i<textFields.length; i++)
			loginPanel.add(textFields[i]);
		
		for(int i=0; i<buttons.length; i++)
			loginPanel.add(buttons[i]);
		
	}
	
	/*
	 * Con questo metodo vado ad posizionare le labels al posto desiderato.
	 * Poichè ogni label ha una sua posizione specifica ho utilizzato uno switch()
	 * per poterli identificare univocamente e successivamente lavorarci su.
	 */
	private void setupLabels()
	{
		for(int i=0; i<labels.length;i++)
		{
			labels[i] = new JLabel();
			labels[i].setVisible(true);
			
			switch(i)
			{
			case 0:
				labels[i].setIcon(new ImageIcon("src/logo.jpg"));
				labels[i].setLocation(new Point(65, 10));
				labels[i].setSize(new Dimension(200,121));
			break;
			
			case 1:
				labels[i].setText("Username: ");
				labels[i].setLocation(new Point(10, 150));
				labels[i].setSize(new Dimension(100,15));
			break;
			
			case 2:
				labels[i].setText("Password: ");
				labels[i].setLocation(new Point(10, 200));
				labels[i].setSize(new Dimension(100,15));
			break;
				
			}
		}
	}
	
	/*
	 * Con questo metodo vado ad posizionare le textFields al posto desiderato.
	 * Poichè ogni textField ha una sua posizione specifica ho utilizzato uno switch()
	 * per poterli identificare univocamente e successivamente lavorarci su.
	 */
	private void setupTextField()
	{
		for(int i=0; i<textFields.length; i++)
		{
			switch(i)
			{
				case 0:
					textFields[i] = new JTextField();
					textFields[i].setLocation(new Point(100,150));
					break;
			
				case 1:
					textFields[i] = new JPasswordField();
					textFields[i].setLocation(new Point(100, 200));
					break;				
			}
			textFields[i].setVisible(true);
			textFields[i].setSize(new Dimension(200, 25));
			textFields[i].setFont(new Font("Sans-serif", Font.BOLD, 15));
			textFields[i].setBorder(BorderFactory.createBevelBorder(1, Color.lightGray, Color.black));
		}
	}
	
	/*
	 * Con questo metodo vado ad posizionare le buttons al posto desiderato.
	 * Poichè ogni button ha una sua posizione specifica ho utilizzato uno switch()
	 * per poterli identificare univocamente e successivamente lavorarci su.
	 */
	private void setupButtons()
	{
		buttons[0] = new JButton("Accedi");
		buttons[1] = new JButton("Registrati");
		for(int i=0; i<buttons.length; i++)
		{
			
			buttons[i].setVisible(true);
			buttons[i].setContentAreaFilled(true);
			buttons[i].setBorderPainted(true);
			buttons[i].setOpaque(false);
			
			buttons[i].addActionListener(this);
			
			switch(i)
			{
				case 0:
					buttons[i].setText("Accedi");
					buttons[i].setSize(new Dimension(130,50));
					buttons[i].setLocation(new Point(30,250));
				break;
				
				case 1:
					buttons[i].setText("Registrati");
					buttons[i].setSize(new Dimension(130,50));
					buttons[i].setLocation(new Point(175,250));
				break;
				
					
			}
		}
	}
	
	
	/*
	 * Con questo metodo vado a fare un override su un metodo della classe ActionEvent
	 * creando così un'action per i buttons.
	 * 
	 * METODO DA COMPLETARE: BISOGNA FARE I CONTROLLI SU UN FILE
	 */
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String nameButton= e.getActionCommand(); //Crea la stringa "nameButton" con all'interno il nome che identifica il bottone premuto.
		
		if(nameButton.equals("Accedi")) //Nel caso in cui il bottone premuto sia "Accedi" allora effettua il controllo
		{
			
		}
		else
		{
			
		}
			
	}
}