import java.awt.List;
import java.util.LinkedList;
import java.util.ListIterator;



public class ListeChainee 
{

	public static void main(String[] args) 
	{
		LinkedList list = new LinkedList();
		
	    list.add("obj1");
	    list.add("obj2");
	    list.add("obj3");
	    list.addFirst("obj0");
	    ListIterator iter=list.listIterator();
	     while(iter.hasNext())
	     
	     {
	    	 Object o=iter.next();
	    	 System.out.println("Element "+ o );
	     }
	     
	     
	      

	}

}
