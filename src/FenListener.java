import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;


public class FenListener extends JFrame  //Une classe qui herite de JFrame et contenant des classes internes.


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
 /*********************************************************************************************************/	 
	   
	   public  FenListener ()
	   
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
		        
		        container.setBackground(Color.white);
		        container.add(north,BorderLayout.NORTH);
		        container.add(south,BorderLayout.SOUTH);
		        
		        
		        
		        ok.addActionListener(new BoutonListener1());
		        ok.setToolTipText("Bouton OK");
		        stop.addActionListener(new BoutonListener2());
		        stop.setToolTipText("Bouton STOP");
		        close.addActionListener(new BoutonListener3());
		        close.setToolTipText("Fermer");
		        
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
			    Thread.sleep(3000);
			  }
	      
	      catch (InterruptedException e) 
	          {
		          e.printStackTrace();
		      }
	      
	      splash.setVisible(false);
       }
	 
  /*********************************************************************************************************/
   
	     class BoutonListener1 implements ActionListener  //Classe interne ecoutant le bouton "OK".
	
	         {
		        public void actionPerformed(ActionEvent e)
		        
		            {
		        	   label1.setText("Vous avez clique sur le bouton OK");
		        	
		            }
		        
		
	         }
	
/*--------------------------------------------------------------------------------------------------------------------*/	
	
	     class BoutonListener2 implements ActionListener    //Classe interne ecoutant le bouton "STOP".
	 	
              {
	               public void actionPerformed(ActionEvent e)
	        
	                  {
	        	         label1.setText("Vous avez clique sur le bouton STOP");
	        	
	                  }
	        
	
             }
	     
/*--------------------------------------------------------------------------------------------------------------------*/
	     
	     class BoutonListener3 implements ActionListener   //Classe interne ecoutant le bouton "FERMER".
	 	
         {
	        public void actionPerformed(ActionEvent e)
	        
	            {
	        	   System.exit(0);
	        	
	            }
	        
	
         }
 /*********************************************************************************************************/ 

	
	
	    public static void main(String[] args)
	
	        {
                new WinListener();		 

	        }

}
