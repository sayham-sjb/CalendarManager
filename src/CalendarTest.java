import javax.swing.*; 
/**
 * @author Sayham Chowdhury
 * The Class CalendarTest.
 */
public class CalendarTest { 
	
	/**
	 * The main method.
	 * @param args the arguments
	 */
	public static void main(String[] args) { 
		UserInterface uInterface = new UserInterface(); 
		uInterface.setSize(270, 250); 
		uInterface.setVisible( true );
		uInterface.setLocationRelativeTo(null);//Set frame location
		uInterface.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE );
	}
}