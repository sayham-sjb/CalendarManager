import java.io.*; 
/**
 * @author Sayham Chowdhury
 * The Class CalendarManager.
 */
public class CalendarManager { 
	
	/** The entries. */
	String entries [] = new String[31];//Date entries array 
	
	/** The directory. */
	String directory ; 
	
	/** The dir. */
	File dir;
	
	/**
	 * Instantiates a new calendar manager.
	 */
	public CalendarManager() { 
		directory = "Calendar" ; 
		File dir = new File(directory); 
		if (dir.exists()!= true ) //if it does not exist then create 
		dir.mkdir(); 
	} 
	
	/**
	 * Gets the file.
	 *
	 * @param month the month
	 * @param year the year
	 * @return the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void getFile(String month, String year) throws IOException { 
		String filename = directory + "\\" + month.trim() + year.trim(); 
		File file = new File(filename); 
		if (!file.exists()) { //If file does not exist then create a new string array
			entries = new String[31]; 
			} 
		else { //Otherwise read entries from the file and store them in to the array
				try { FileInputStream fis = new FileInputStream(filename); 
				ObjectInputStream ois = new ObjectInputStream(fis); 
				entries =(String[])ois.readObject(); 
				ois.close(); 
				fis.close(); 
				} 
				catch (ClassNotFoundException exception){ 
					entries = new String[31]; 
					} 
				catch (IOException exception){ 
					entries = new String[31]; 
					}
			} 
		}

	/**
	 * Gets the entry.
	 *
	 * @param month the month
	 * @param day the day
	 * @param year the year
	 * @return the entry
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String getEntry(String month, String day, String year) throws IOException { 
		getFile(month, year); //Call getfile() method
		int index=Integer.parseInt (day)-1; 
		if ( entries [index]!= null ) { //If date entry exists then return the entry
			return("From Record => " + entries [index]);
			//return entries [index]; 
		} 
		else //Or return error message
			return "The entry does not exist!" ; 
	}

	/**
	 * Save entry.
	 *
	 * @param month the month
	 * @param day the day
	 * @param year the year
	 * @param entry the entry
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String saveEntry(String month, String day, String year, String entry)throws IOException{   
		try {
		getFile(month, year);  //Call getfile() method
		int dayInt = Integer.parseInt(day);
		dayInt = dayInt-1;
		entries[dayInt] = entry;
		String filename = new String(directory +"\\"+ month + year);
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(entries);
		oos.close();
		fos.close();

		return "Successfully added entry to the file!";
	}
		catch(Exception ex)
	{
		return "Error adding entry to the file!";
	}
	}
}

