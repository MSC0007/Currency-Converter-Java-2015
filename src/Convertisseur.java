import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.UIManager;


public class Convertisseur extends JFrame  //Une classe qui herite de JFrame et contenant des classes internes.


{
       
	   private Thread t;
	   private JProgressBar bar;
	
	   private JWindow splash=new JWindow();
       private JPanel  splashpan =new JPanel();
	   private JPanel south=new JPanel() ;
	   private JPanel north=new JPanel() ;
	   private JPanel container= new JPanel();	   
	   private JButton close =new JButton(new ImageIcon("src/close.png"));
	   private JLabel label1= new JLabel("Convertisseur de monnaie FCFA, EURO, DOLLAR !");
	   private JLabel label2;
	   
	   private JLabel label3=new JLabel("FCFA: ");
	   private JLabel label4=new JLabel("  EURO: ");
	   private JLabel label5=new JLabel(" 1 Euro correspond a 600 FCFA");
	   private JFormattedTextField jftf1 = new JFormattedTextField(NumberFormat.getNumberInstance());
	   private JFormattedTextField jftf2 =  new JFormattedTextField(NumberFormat.getNumberInstance());
	   private JPanel p0=new JPanel() ;
	   private JPanel p1=new JPanel() ;
	   private JPanel p2=new JPanel() ;
	   private JPanel p3=new JPanel() ;
	   private JButton convert1 =new JButton("FCFA >> EURO");
	   private JButton convert2 =new JButton("EURO >> FCFA");
	   private JOptionPane jop;
	   private ImageIcon icon =new ImageIcon("images/roll.png");
	   //private ImageIcon img =new ImageIcon("images/quit.png");
	   private ImageIcon logo =new ImageIcon("images/sonko.png");
	   private ImageIcon img =new ImageIcon("images/progress.gif");
	   
      
	  
 /*********************************************************************************************************/	 
	   
	   public  Convertisseur ()
	   
	          {
		        this.setIconImage(logo.getImage()); //Logo de la fenetre de l'application.
		        this.setTitle("EURO to FCFA Inverter by MSCreation Software");
		        this.setSize(800, 400); 
		        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        this.setLocationRelativeTo(null);
		        this.setResizable(false); 
		        this.setAlwaysOnTop(false);
		       
		       
		        
		        t = new Thread(new Traitement()); //Nouvel thread pour la barre de progression de notre "screensplash"		       
		        bar  = new JProgressBar(); //Barre de progression.		        
		        bar.setMaximum(500);
		        bar.setMinimum(0);
		        //bar.setString("Traitement en cours...");
		        //bar.setBackground(Color.white);
		        //bar.setForeground(Color.lightGray);
		        bar.setStringPainted(true);
          
		        
		        
		        Font police=new Font("Times new roman",Font.ITALIC,18);
		        Font police2=new Font("Agency",Font.ITALIC,18);
                container.setLayout(new BorderLayout());
                
		        label1.setForeground(Color.BLACK);
		        label1.setFont(police);
		        
		        label3.setForeground(Color.BLACK);
		        label3.setFont(police);
		        
		        label4.setForeground(Color.BLACK);
		        label4.setFont(police);
		        
		        label5.setForeground(Color.BLACK);
		        label5.setFont(police);
		        label5.setHorizontalAlignment(JLabel.CENTER);
		        
		        
		        jftf1.setPreferredSize(new Dimension(300,40));
		        jftf1.setHorizontalAlignment(JFormattedTextField.RIGHT);
		        jftf1.setBorder(BorderFactory.createTitledBorder("Montant"));		        
		        jftf1.setBackground(Color.white);
		        jftf1.setForeground(Color.BLUE);
		        jftf1.setFont(police2);
		        
		       
		        convert1.addActionListener(new BoutonListener1());
		        convert2.addActionListener(new BoutonListener2());
		        //convert1.setPressedIcon(icon);
		        convert1.setRolloverSelectedIcon(img);
		      
		        jftf2.setPreferredSize(new Dimension(300,40));
		        jftf2.setHorizontalAlignment(JFormattedTextField.RIGHT);
		        jftf2.setBorder(BorderFactory.createTitledBorder("Montant"));		        
		        jftf2.setBackground(Color.white);
		        jftf2.setForeground(Color.RED);
		        jftf2.setFont(police2);
		        
		        p0.setLayout(new BorderLayout());
		        p0.setPreferredSize(new Dimension(450,680));
		        p1.setBackground(Color.white);
		        p1.add(label3);
		        p1.add(jftf1);
		        p1.add(label4);
		        p1.add(jftf2);
		       
		        p3.add(label5);
		        
		        p3.setBackground(Color.black);
		        p0.add(p1,BorderLayout.NORTH);
		        p0.add(p3,BorderLayout.CENTER);
		        p0.add(p2,BorderLayout.SOUTH);
		        convert1.setPreferredSize(new Dimension(150,40));
		        convert2.setPreferredSize(new Dimension(150,40));
		        
		        label1.setHorizontalAlignment(JLabel.CENTER);
		        north.setPreferredSize(new Dimension(500,40));
		        north.setBackground(Color.LIGHT_GRAY);
		        north.add(label1);
		        
		        
		        close.setPreferredSize(new Dimension(40,30));
		        close.setPressedIcon(img);
		        close.setRolloverSelectedIcon(img);
		       
                south.setPreferredSize(new Dimension(500,40));		       
		        
		        south.add(close);
		        
		        p2.setBackground(Color.black);
		        p2.add(convert1);
		        p2.add(convert2);
		        
		        t.start();
		        container.setBackground(Color.white);
		        container.add(north,BorderLayout.NORTH);		         
		        container.add(p0,BorderLayout.CENTER);
		        container.add(south,BorderLayout.SOUTH);
		        
/*----------------------------------------------------------------------------------------------------------------------------------------------*/		        
		  
/*-------------------------------------------------------------------------------------------------------------------------------------------------*/	   
		        
		        close.addActionListener(new ActionListener() { //Debut de la classe anonyme implementant ActionListener et ecoutant le bouton "FERMER"
					
					
					                                               public void actionPerformed(ActionEvent arg0) 
					                                               
					                                                       {
					                                            	           int k= jop.showConfirmDialog(null,"Voulez-vous quitter ?","INFORMATION",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,img);
						                                                       if (k==0)
						                                                          {
						                                                    	    System.exit(0);
						                                                          }
					                                                       }
					                                               
			                                               	 }); //Fin de la classe anonyme implementant ActionListener et ecoutant le bouton "FERMER"
		        
		        close.setToolTipText("Fermer");
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/		        
		        
		        screen(); //Appel de la methode screen permettant d'afficher le "Screen_Splash".
		        this.setContentPane(container);
		        this.setVisible(true);		   
		        
	          }
/*******************************************************************************************************************************************/
/*----------------Methode definissant le Splash screen--------------------------------------------------*/  
	   
   public void screen ()
   
       {
	      label2=new JLabel(new ImageIcon("images/splash.png"));
	      splashpan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	      splashpan.setBackground(Color.gray);
	      splashpan.setLayout(new BorderLayout());
	      splashpan.add(label2,BorderLayout.CENTER);
	      splashpan.add(bar, BorderLayout.SOUTH);
	      splash.setContentPane(splashpan);
	      
	      splash.setSize(700, 400);
	      splash.setLocationRelativeTo(null);
	      splash.setVisible(true);
	      
	      
	      
	      
	      try {
	    	  
	    	  
			    Thread.sleep(5000); //Pause de 5 secondes.
			  }
	      
	      catch (InterruptedException e) 
	          {
		          e.printStackTrace();
		      }
	      
	      splash.setVisible(false); //Apres 5 secondes, le screen splash disparait.
       }
	 
   
/*******************************************************************************************************************************************/
   /*----------------Methode  la barre de progression--------------------------------------------------*/    
   
   class Traitement implements Runnable
   
       {   
	          public void run()
	    
	               {
	     
	         
			                 for(int val = 0; val <= 500; val++)
			      
			                    {
					                 bar.setValue(val);
					                 
					                 try
					                    {
					                        t.sleep(9);
					                    } 
					        
					                 catch (InterruptedException e)					        
					                     {
					                          // TODO Auto-generated catch block
					                          e.printStackTrace();
					                     }	
					                 
					               
	                            }
	     
	                }  
	    }
	 
      
 /*********************************************************************************************************/ 
   
   class BoutonListener1 implements ActionListener  //convert1 FCFA >> EURO
   
          {
	         public void actionPerformed (ActionEvent e)
	         
	           {
	        	   
	        	 try{
	 		        URL url = getClass().getResource("sons/numero.wav");
	 		 	    AudioClip ac1 = Applet.newAudioClip(url);
	 		       //ac1.stop();
	 		     
	 		 	   ac1.play();
	 		        
	 		        }
	 		        
	 		        catch (Exception f)
	 		        
	 		        {
	 		        System.out.println();	
	 		        }
	        	 
	        		Number res=(Number) jftf1.getValue();   //On suppose que 1 Euro vaut 600 FCFA
	        		double tmp= res.doubleValue(); 
	        		       tmp /=600; //equivaut a tmp=tmp/600.
	     	        
	     	        jftf2.setValue(tmp); 
	     	         
	        	   
	           }
	      
          }
/*---------------------------------------------------------------------------------------------------------*/   
   
   class BoutonListener2 implements ActionListener    //convert2 EURO >> FCFA
   
   {
      public void actionPerformed (ActionEvent e)
      
        {
    	  
    	  try {
                   AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("sons/numero.wav"));
                        // Get a sound clip resource.
                   Clip clip = AudioSystem.getClip();
                   // Open audio clip and load samples from the audio input stream.
                         clip.open(audioIn);
               } 
    	  
    	  catch (UnsupportedAudioFileException h) 
    	      
    	      {
                 h.printStackTrace();
              } 
    	  
    	  catch (IOException f) 
    	      {
                  f.printStackTrace();
              }
    	  
    	  catch (LineUnavailableException g) 
    	      {
                  g.printStackTrace();
              } 
    	  
    	  
    	  
    	   Number res= (Number)  jftf2.getValue();   //On suppose que 1 Euro vaut 600 FCFA
    	    double tmp= res.doubleValue();    
    	          tmp*=600; //Equivaut a tmp=tmp*600.
    	         
	         
	       jftf1.setValue(tmp);
	       
	       
    	
        }
   
   }

   
   /*********************************************************************************************************/ 

	
	
	    public static void main(String[] args)
	
	        {
	    	
	    	 try{
	                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");	//Apperance new look de la fenetre           
	                new Convertisseur();
	             }
		      
	          catch (Exception e)
	               {
	               }
	    	
	    	
	    	
               	 

	        }

}
