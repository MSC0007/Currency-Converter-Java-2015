import javax.swing.JFrame;


public class Fenetre extends JFrame

{
 
    private	Panneau pan= new Panneau();
	
	public Fenetre ()
	   
	
	     {
		   this.setTitle("Animation");
		   this.setSize(500,500);
		   this.setLocationRelativeTo(null);
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.setResizable(false);
		   this.setUndecorated(false);
		   
		   
		   this.setContentPane(pan);
		   this.setVisible(true);
		   play();
         }
	
	
	
	public void play()
	
	     {
	        for (int i=-50; (i<= pan.getWidth() && i<=pan.getHeight()); i++)
	          {
	        	int x =pan.getPosx();
	        	int y = pan.getPosy();
	        	
	        	x++;
	        	y++;
	        	
	        	pan.setPosx(x);
	        	pan.setPosy(y);
	        	
	        	pan.repaint(); //Cette instruction est dit a risque car l'ordinateur va peindre a une vitesse impercevable pour l'oeil humain.
	        	
	        	  try         //D'ou l'utilite de marquer une pause (sleep) avec le bloc try catch.
	        	  {
	        		Thread.sleep(10);
	        	  }
	        	  
	        	  catch (InterruptedException e)
	        	
	        	   {
	        		e.printStackTrace();
	        		
	        	   }
	        	
	          }
		
		
	     }
	
	
	
	  public static void main (String []args)
	  
	           {
		         new Fenetre();
		  
	           }
	
	
	

}
