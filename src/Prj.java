 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JWindow;
import javax.swing.KeyStroke;


public class FenetreOnglets extends JFrame

{
   private JTabbedPane tab;
   private ImageIcon img=new ImageIcon("images/pc.png");
   private ImageIcon pict=new ImageIcon("images/info.png");

   private JLabel label3;
   private JWindow splash=new JWindow();
   private JPanel  splashpan =new JPanel();
   private JOptionPane jop;
    
                                                      //Rmq: une menubar fait partie de la composition d'une JFrame.Cependant,nous n'utiliserons pas l'objet Menubar,
   private JMenuBar menubar=new JMenuBar();          //car c'est un composant AWT,contrairement au composant SWING JMenuBar que nous utiliserons.
   private JMenu M1=new JMenu("Fichier");
   private JMenu M1_2=new JMenu("Sous fichier ");	
   private JMenu M2=new JMenu("Edition");
   private JMenu M3=new JMenu("?");  
   private JMenu M4=new JMenu("Mise à jour");
   private JMenu M5=new JMenu("Affichage");
   
     private JMenuItem item1=new JMenuItem("> Ouvrir");
     private JMenuItem item2 =new JMenuItem("> Fermer");
	 private JMenuItem item3 =new JMenuItem("> Saisie");
	 private JMenuItem item4=new JMenuItem("> Modification");
	 private JMenuItem item8=new JMenuItem(" > Gestion");
	 private JMenuItem item5=new JMenuItem("> A propos");
	 private JMenuItem item6=new JMenuItem("> Màj...");
	 private JMenuItem item7=new JMenuItem(" > Afficher");
	 private JMenuItem item9=new JMenuItem(" > Chercher");
	 
   public FenetreOnglets()
   
        {
          this.setTitle("Interface de suivi des anciennes promotion de AMRT");
          this.setSize(900,600);
           
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setLocationRelativeTo(null);
          this.setIconImage(img.getImage()); //La methode "setIconImage" permet de changer l'icone d'une JFrame.
          
          Panneau [] tpan={new Panneau(Color.gray), new Panneau(Color.black),new Panneau(Color.yellow),new Panneau(Color.cyan), new Panneau(Color.lightGray)}; //creation d'un tableau de Panneaux.
         
          tab=new JTabbedPane( JTabbedPane.NORTH); //Instanciation de l'objet "tab".
          int i=0;
          
          for(Panneau pan : tpan) //On stock dans la variable tampon "pan" les elements de "tpan" qui sont des panneaux de couleurs differentes.
               {                //Cette synthaxe du for est tres performante pour le parcours des tableaux.
        	    
        	     tab.add(pan); //Vous pouvez aussi utiliser la methode add("Onglets N"+(++i),pan);
        	     
               }          
	         
       // Ici, le premier parametre concerne l'indice de l'onglet(cette indice va de  0 à N):  tab.setIconAt(0, new ImageIcon("images/red.png")); on insere l'image dans l'onglet d'indice 1
          tab.setIconAt(0, new ImageIcon("images/gestion.png")); 
          tab.setIconAt(1, new ImageIcon("images/saisie.png")); 
          tab.setIconAt(2, new ImageIcon("images/modify.png"));
          tab.setIconAt(3, new ImageIcon("images/affichage.png"));
          tab.setIconAt(4, new ImageIcon("images/search.png"));
         
        // Titre des Onglets
          tab.setTitleAt(0,"Gestion");
          tab.setTitleAt(1,"Saisie");
          tab.setTitleAt(2,"Modification");
          tab.setTitleAt(3,"Affichage");
          tab.setTitleAt(4,"Recherche");
          
           

	        this.menubar.add(M1); //"menubar" est de type JMenuBar et fait partie de notre JFrame donc signifit: this fait reference a notre JFrame.
	        this.menubar.add(M2);
	        this.menubar.add(M5);
	        this.menubar.add(M3);
	        
	        this.setJMenuBar(menubar);
          
	        
	      initMenuBar(); //Appel de la methode initialisant le menu de la JFrame.
	      
          this.getContentPane().add(tab);
          screen();
          this.setVisible(true);
          	   
        } //Fin du constructeur de FenetreOnglets.
   
   
   public void screen ()
   
   {
	      label3=new JLabel(new ImageIcon("images/hacker.jpg"));
	      splashpan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	      splashpan.setBackground(Color.cyan);
	      splashpan.setLayout(new BorderLayout());
	      splashpan.add(label3,BorderLayout.CENTER);
	      splash.setContentPane(splashpan);
	      
	      splash.setSize(700, 400);
	      splash.setLocationRelativeTo(null);
	      splash.setVisible(true);
	      
	      try {
			    Thread.sleep(2000);
			    
		      }
	      catch (InterruptedException e) 
	        {
		      e.printStackTrace();
		    }
	      splash.setVisible(false);
   }
   
   
   
   public void initMenuBar()  //Il est un bon style de programmation de creer une methode pour l'initialisation de ses menus.
   
   {
	    this.M1.setMnemonic('F');
	    this.M2.setMnemonic('E');
	    this.M5.setMnemonic('A');
	   
	    item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));  //CTRL_DOWN_MASK est plus recente que CTRL_MASK donc il est conseille de l'utiliser !.
	     
	    item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));  // VK signifit "Value of Key"
	    item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK+ KeyEvent.SHIFT_DOWN_MASK));
	    item4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_DOWN_MASK));
	    item5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
	    item6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M ,KeyEvent.CTRL_DOWN_MASK));
	    
	  
	   
	    this.M1.add(item1);
	   
	    JCheckBoxMenuItem check1=new JCheckBoxMenuItem("Choix 1");
	    JCheckBoxMenuItem check2=new JCheckBoxMenuItem("Choix 2");
	    
	    M1_2.add(check1);
	    M1_2.add(check2);
	    
	    M1_2.addSeparator(); //Ajout d'un separateur "un trait".
	    
	    JRadioButtonMenuItem jrmi1=new JRadioButtonMenuItem("Radio 1");
	    jrmi1.setSelected(true);
	    JRadioButtonMenuItem jrmi2=new JRadioButtonMenuItem("Radio 2");
	    
	    ButtonGroup bg =new ButtonGroup(); //Ajout des RadioButton dans un ButtonGroup afin que l'une d'elles soit selectionnable a la fois.
	    bg.add(jrmi1);
	    bg.add(jrmi2);
	   M1_2.setMnemonic('S'); //Ajout d'un mnemonique.
	   M1_2.add(jrmi1);
	   M1_2.add(jrmi2);
	   this.M1.add(M1_2);
	   
	   
	   this.M1.add(item2);
	   item2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0)
		     {
			  
			     int k= jop.showConfirmDialog(null,"Voulez-vous quitter ?","INFORMATION",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,pict);
                  if (k==0)
                     {
          	            System.exit(0);
                     }			   
			
		     }
	       });
	   
	   M2.add(item8);
	   M2.addSeparator();   
	   M2.add(item3);
	    
	   M2.add(item4);
	   
	   M4.add(item6);
	   item6.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			   jop=new JOptionPane();	//Rmq:L'objet ImageIcon ne supportent pas l'extension "ico" .			  
			   jop.showMessageDialog(null,"IMPOSSIBLE DE SE CONNECTER AU SERVEUR\n Details: http://www.sonko.net server not found\n Please check your connection\n","Mise à jour....",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("images/maj.png"));	 
			
		}
	});
	   
	   M3.add(item5);
	   M3.addSeparator();    	  
	   M3.add(M4);
	   item5.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0)
		      {
			   jop=new JOptionPane();				   
			   jop.showMessageDialog(null,"Ce programme a été codé par :\n M. Pape Moussa SONKO.\n Tel: 706438029 / 773764792","A propos de l'auteur",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("images/pape.png"));
			
		      }
	   });		  
	 
	 	
	   
	   M5.add(item7);
	   M5.addSeparator();
	   M5.add(item9);
	   
	   
}
   
	 
   
	
	public static void main (String []args)
	      
	       {
		      FenetreOnglets fen= new FenetreOnglets();
	       }
	

}
