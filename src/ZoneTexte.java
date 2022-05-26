import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.text.MaskFormatter;

import org.omg.CORBA.portable.ValueBase;


public class ZoneTexte extends JFrame  //Une classe qui herite de JFrame et contenant des classes internes.


{
       
	   private JWindow splash=new JWindow();
       private JPanel  splashpan =new JPanel();
	   private JPanel south=new JPanel() ;
	   private JPanel north=new JPanel() ;
	   private JPanel container= new JPanel();
	   private JButton ok =new JButton("OK");
	   private JButton stop =new JButton("STOP");
	   private JButton close =new JButton(new ImageIcon("src/close.png"));
	   private JLabel label1= new JLabel("Veuillez Cliquez sur un bouton !");
	   private JLabel label2;
	   
	   private JLabel label3=new JLabel("FCFA: ");
	   private JLabel label4=new JLabel("  EURO: ");
	   private JLabel label5=new JLabel(" 1 Euro correspond a 600 FCFA");
	   private JFormattedTextField jftf1 = new JFormattedTextField(NumberFormat.getIntegerInstance());
	   private JFormattedTextField jftf2 =  new JFormattedTextField(NumberFormat.getIntegerInstance());
	   private JPanel p0=new JPanel() ;
	   private JPanel p1=new JPanel() ;
	   private JPanel p2=new JPanel() ;
	   private JPanel p3=new JPanel() ;
	   private JButton convert1 =new JButton("FCFA >> EURO");
	   private JButton convert2 =new JButton("EURO >> FCFA");
 /*********************************************************************************************************/	 
	   
	   public  ZoneTexte ()
	   
	          {
		        this.setTitle("Ma JFrame");
		        this.setSize(1000, 700); 
		        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		        this.setLocationRelativeTo(null);
		        this.setResizable(false); 
		        this.setAlwaysOnTop(false);
		        
		        
		       
		        
		        
		        
		        Font police=new Font("Times new roman",Font.ITALIC,18);
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
		        
		        
		        jftf1.setPreferredSize(new Dimension(400,40));
		        jftf1.setHorizontalAlignment(JFormattedTextField.RIGHT);
		        jftf1.setBorder(BorderFactory.createTitledBorder("Montant"));		        
		        jftf1.setBackground(Color.white);
		        jftf1.setForeground(Color.BLACK);
		        jftf1.setFont(police);
		        
		        convert1.addActionListener(new BoutonListener1());
		        convert2.addActionListener(new BoutonListener2());
		        
		        jftf2.setPreferredSize(new Dimension(300,40));
		        jftf2.setHorizontalAlignment(JFormattedTextField.RIGHT);
		        jftf2.setBorder(BorderFactory.createTitledBorder("Montant"));		        
		        jftf2.setBackground(Color.white);
		        jftf2.setForeground(Color.BLACK);
		        jftf2.setFont(police);
		        
		        p0.setLayout(new BorderLayout());
		        p0.setPreferredSize(new Dimension(990,690));
		        p1.setBackground(Color.white);
		        p1.add(label3);
		        p1.add(jftf1);
		        p1.add(label4);
		        p1.add(jftf2);
		       
		        p3.add(label5);
		        
		        p0.add(p1,BorderLayout.NORTH);
		        p0.add(p3,BorderLayout.CENTER);
		        p0.add(p2,BorderLayout.SOUTH);
		        convert1.setPreferredSize(new Dimension(200,40));
		        convert2.setPreferredSize(new Dimension(200,40));
		        
		        label1.setHorizontalAlignment(JLabel.CENTER);
		        north.setPreferredSize(new Dimension(500,40));
		        north.setBackground(Color.LIGHT_GRAY);
		        north.add(label1);
		        
		        ok.setPreferredSize(new Dimension(100,30));
		        stop.setPreferredSize(new Dimension(100,30));
		        close.setPreferredSize(new Dimension(40,30));
                south.setPreferredSize(new Dimension(500,40));		       
		        south.add(ok);
		        south.add(stop);
		        south.add(close);
		        
		        p2.add(convert1);
		        p2.add(convert2);
		        
		        
		        container.setBackground(Color.white);
		        container.add(north,BorderLayout.NORTH);		         
		        container.add(p0,BorderLayout.CENTER);
		        container.add(south,BorderLayout.SOUTH);
		        
/*----------------------------------------------------------------------------------------------------------------------------------------------*/		        
		        
		        ok.addActionListener(new  ActionListener() { //Debut de la classe anonyme implementant ActionListener et ecoutant le bouton "OK"
					
				 
					                                            public void actionPerformed(ActionEvent arg0) 
					                                               
					                                                {
						                                                label1.setText("Vous avez clique sur le bouton OK");						
					                                                }
					                                            
				                                              });  //Fin de la classe anonyme implementant ActionListener et ecoutant le bouton "OK"
		        
		        
		        ok.setToolTipText("Bouton OK");
/*-----------------------------------------------------------------------------------------------------------------------------------------------*/			        
		        
		        
		        stop.addActionListener(new ActionListener() { //Debut de la classe anonyme implementant ActionListener et ecoutant le bouton "STOP"
					
					 
					                                              public void actionPerformed(ActionEvent arg0)
					                                               
					                                                 {						 
					                                            	     label1.setText("Vous avez clique sur le bouton STOP");
					                                                 }
					                                              
			                                               	}); //Fin de la classe anonyme implementant ActionListener et ecoutant le bouton "STOP"
		        
		        stop.setToolTipText("Bouton STOP");
/*-------------------------------------------------------------------------------------------------------------------------------------------------*/	   
		        
		        close.addActionListener(new ActionListener() { //Debut de la classe anonyme implementant ActionListener et ecoutant le bouton "FERMER"
					
					
					                                               public void actionPerformed(ActionEvent arg0) 
					                                               
					                                                       {						                                                      
						                                                      System.exit(0);
					                                                       }
					                                               
			                                               	 }); //Fin de la classe anonyme implementant ActionListener et ecoutant le bouton "FERMER"
		        
		        close.setToolTipText("Fermer");
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/		        
		        
		        screen();
		        this.setContentPane(container);
		        this.setVisible(true);		   
		        
	          }
/*******************************************************************************************************************************************/
/*----------------Methode definissant le Splash screen--------------------------------------------------*/  
	   
   public void screen ()
   
       {
	      label2=new JLabel(new ImageIcon("images/hacker.jpg"));
	      splashpan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	      splashpan.setBackground(Color.cyan);
	      splashpan.setLayout(new BorderLayout());
	      splashpan.add(label2,BorderLayout.CENTER);
	      splash.setContentPane(splashpan);
	      
	      splash.setSize(700, 400);
	      splash.setLocationRelativeTo(null);
	      splash.setVisible(true);
	      
	      try {
			    Thread.sleep(1000);
			  }
	      
	      catch (InterruptedException e) 
	          {
		          e.printStackTrace();
		      }
	      
	      splash.setVisible(false);
       }
	 
   
 /*********************************************************************************************************/ 
   
   class BoutonListener1 implements ActionListener
   
          {
	         public void actionPerformed (ActionEvent e)
	         
	           {
	        	    String str= jftf1.getText();   //On suppose que 1 Euro vaut 600 FCFA
	     	        double tmp=Double.valueOf(str).doubleValue();
	     	        double res= tmp/600;
	     	        String ch= String.valueOf(res);
	     	        jftf2.setText(ch);   
	           }
	      
          }
   
   
   class BoutonListener2 implements ActionListener
   
   {
      public void actionPerformed (ActionEvent e)
      
        {
     	     
    	  String str= jftf2.getText();   //On suppose que 1 Euro vaut 600 FCFA
	        double tmp=Double.valueOf(str).doubleValue();
	        double res= tmp*600;
	        String ch= String.valueOf(res);
	       jftf1.setText(ch);
	       
    	
        }
   
   }

   
   /*********************************************************************************************************/ 

	
	
	    public static void main(String[] args)
	
	        {
                new ZoneTexte();		 

	        }

}
