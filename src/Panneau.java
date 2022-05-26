import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Panneau extends  JPanel

{
      
      private int posx=-50;
      private int posy=-50;
      
      
     /*-------------------Declaration de la methode paintCOmponent---------------------*/ 
      
      public void paintComponent (Graphics g)
      
           {
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, this.getWidth(), this.getHeight());
    	     g.setColor(Color.blue);
             g.fillRect(posx, posy, 45,45);    	  
    	  
           }
      
   /*---------------------- Declaration des accesseurs-------------------------- */
      
        public int getPosx()
        
              {
        	     return posx;
              }
        
        public int getPosy()
        
             {
	           return posy;
             }
        
        
   /*---------------------- Declaration des accesseurs-------------------------- */
        
        public void setPosx(int posx)
        
           {
  	         this.posx=posx;
           }

        public void setPosy(int posy)
        
           {
        	 this.posy=posy;
           }
    
    
    
    
    
    }
