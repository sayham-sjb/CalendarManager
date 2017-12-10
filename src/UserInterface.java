import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.io.IOException;

/**
 * @author Sayham Chowdhury
 * The Class UserInterface.
 */
@SuppressWarnings("serial")
public class UserInterface extends JFrame implements ActionListener { 
	
	/** The cm. */
	CalendarManager cm ; // Create month and day string arrays for the combo boxes 
	
	/** The Month. */
	String Month[] = { "Jan" , "Feb" , "Mar" , "Apr" , "May" , "Jun" , "Jul" , "Aug" , 
			"Sep" , "Oct" , "Nov" , "Dec" }; 
	
	/** The Day. */
	String Day[] = { "1" , "2" , "3" , "4" , 
			"5" , "6" , "7" , "8" , "9" , "10" , "11" , "12" , "13" , "14" , "15" , 
			"16" , "17" , "18" , "19" , "20" , "21" , "22" , "23" , "24" , "25" , "26" , 
			"27" , "28" , "29" , "30" , "31" }; 
			
			/** The month. */
			JComboBox month;
			
			/** The day. */
			JComboBox day; 
			
			/** The year. */
			JTextField year; 
			
			/** The entry. */
			JTextArea entry; 
			
			/** The scroller. */
			JScrollPane scroller; 
			
			/** The get. */
			JButton get;
			
			/** The save. */
			JButton save; 
			
			/**
			 * Instantiates a new user interface.
			 */
			public UserInterface() { 
				super ("cManager-sjb"); 
				setLayout( new FlowLayout());
				cm = new CalendarManager(); 
				month = new JComboBox(Month); //Set preferred size of month, day, and year 
				month.setPreferredSize(new Dimension(75, 25)); //5 rows in the month dropdown box 
                month.setMaximumRowCount(5);
                day = new JComboBox(Day); 
                day.setPreferredSize(new Dimension(75, 25)); //5 rows in the day dropdown box 
                day.setMaximumRowCount(5); 
                year = new JTextField("" ,4); 
                year.setPreferredSize(new Dimension(75, 25)); //Text area with scroll pane 
                entry = new JTextArea(8, 20); 
                scroller = new JScrollPane(entry); 
                get = new JButton("Get"); //Set up actionListeners for the buttons 
                save = new JButton("Save"); //Set up actionListeners for the buttons 
                get.addActionListener(this); 
                save.addActionListener(this); 
                add( month ); 
                add( day ); 
                add( year ); 
                add( scroller ); 
                add( get ); 
                add( save );
			}

			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public 	void actionPerformed(ActionEvent ev) { //Get the date and entry information into strings 
				String m = (String) month.getSelectedItem(); 
				String d = (String) day.getSelectedItem(); 
				String y = year.getText(); 
				String e = entry.getText(); //Get the result 
				if (ev.getSource() == save ) { 
					try {
						e = cm.saveEntry(m, d, y, e);
					} catch (IOException e1) {
						e1.printStackTrace();
					} 
					} 
				else if (ev.getSource() == get ) { 
					try {
						e = cm.getEntry(m, d, y);
					} catch (IOException e1) {
						e1.printStackTrace();
					} 
					}
				entry .setText(e); //Display result
			}
}