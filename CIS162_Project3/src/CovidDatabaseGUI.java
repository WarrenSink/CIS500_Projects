import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
/*************************************************************
 * GUI for a Covid-19 Database
 * 
 * @author Scott Grissom
 * @author <insesrt your name>
 * @version June 1, 2020
 ************************************************************/
public class CovidDatabaseGUI extends JFrame implements ActionListener{

    /** the database object */
    // FIX ME: define a CovidDatabase object called database
	CovidDatabase database;

    /** last date of records on file */
    private static final int MONTH = 9;
    private static final int DAY = 27;

    /** Buttons to initiate each action */
    JButton dailyInfections; 

    // FIX ME: define additional buttons for: safe, peakDeaths, topTen;
    JButton safe, peakDeaths, topTen;

    /** Results */
    JTextArea results;

    /** Data entry fields: month, day and minimum */
    JTextField monthFld; 
    JTextField dayFld; 
    JTextField minFld; 

    // FIX ME: define additional data fields: stateFld, countFld;
    JTextField stateFld, countFld;

    /** menu items */
    JMenuBar menus;
    JMenu fileMenu;
    JMenuItem quitItem;
    JMenuItem openItem;  
    JMenuItem statsItem;  

    DecimalFormat fmt = new DecimalFormat("#,###");

    /*****************************************************************
     * Main Method
     ****************************************************************/ 
    public static void main(String args[]){
        CovidDatabaseGUI gui = new CovidDatabaseGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // FIX ME: Include your name in the title
        gui.setTitle("Covid Database (editor: Warren Sink)");
        gui.pack();
        gui.setVisible(true);
    }

    /*****************************************************************
     * constructor installs all of the GUI components
     ****************************************************************/    
    public CovidDatabaseGUI(){

        // instantiate the analyzer and read the data file    
        database = new CovidDatabase();

        // set the layout to GridBag
        setLayout(new GridBagLayout());
        GridBagConstraints loc = new GridBagConstraints();

        // create results area to span one column and 11 rows
        results = new JTextArea(20,60);
        JScrollPane scrollPane = new JScrollPane(results);
        loc.gridx = 0;
        loc.gridy = 1;
        loc.gridheight = 11;  
        loc.insets.left = 20;
        loc.insets.right = 20;
        loc.insets.bottom = 20;
        add(scrollPane, loc);

        // create Results label
        loc = new GridBagConstraints();
        loc.gridx = 0;
        loc.gridy = 0;
        loc.insets.bottom = 10;
        loc.insets.top = 20;
        add(new JLabel("Results"), loc);

        // create Choices label
        loc.gridx = 1;
        loc.gridy = 0;
        loc.gridwidth = 2;
        add(new JLabel("Parameters"), loc);

        // Month Label and text field
        loc = new GridBagConstraints();  
        loc.insets = new Insets(2, 2, 2, 2);
        loc.gridheight = 1;
        loc.gridx = 1;
        loc.gridy = 1;
        loc.anchor = GridBagConstraints.LINE_START;
        add(new JLabel("Month"), loc);

        monthFld = new JTextField(4);        
        loc.gridx = 2;
        loc.gridy = 1;
        add(monthFld, loc);

        //create label, textfield for day
        loc.gridx = 1;
        loc.gridy = 2;        
        add(new JLabel("Day"), loc);

        dayFld = new JTextField(4);        
        loc.gridx = 2;
        loc.gridy = 2;
        add(dayFld, loc);  

        //FIX ME: create label, textfield for state
        loc.gridx = 1;
        loc.gridy = 3;        
        add(new JLabel("State"), loc);
        
        stateFld = new JTextField(4);        
        loc.gridx = 2;
        loc.gridy = 3;
        add(stateFld, loc);

        //create button for safe to open
        safe = new JButton("Safe to Open");
        loc = new GridBagConstraints(); 
        loc.anchor = GridBagConstraints.CENTER;
        loc.insets = new Insets(3, 3, 3, 3);
        loc.gridwidth = 2;
        loc.gridx = 1;
        loc.gridy = 6;
        add(safe, loc);

        // create button for peak daily deaths
        peakDeaths = new JButton("Peak Daily Deaths");
        loc.gridx = 1;
        loc.gridy = 4;
        add(peakDeaths, loc);

        // create button for top ten
        topTen = new JButton("Top Ten");
        loc.gridx = 1;
        loc.gridy = 5;
        add(topTen, loc);

        //FIX ME: create button for min daily infections
        dailyInfections = new JButton("Min Daily Infections");
        loc.gridx = 1;
        loc.gridy = 9;
        add(dailyInfections, loc);

        // create JLabels and JTextField for minimum
        loc.gridx = 1;
        loc.gridy = 8; 
        loc.gridwidth = 1;
        loc.insets.top = 0;
        loc.anchor = GridBagConstraints.LINE_START;
        loc.insets = new Insets(2, 2, 2, 2);
        add(new JLabel("Minimum"), loc);

        minFld = new JTextField(4);
        loc.gridx = 2;
        loc.gridy = 8;
        add(minFld, loc);

        // register the button listeners
        dailyInfections.addActionListener(this);
        // FIX ME: register the button listeners (safe, peakDeaths, topTen)
        safe.addActionListener(this);
        peakDeaths.addActionListener(this);
        topTen.addActionListener(this);

        setupMenus();
    }

    /*****************************************************************
     * @param ArrayList <CovidEntry> - list to display 
     ****************************************************************/ 
    private void displayRecords(ArrayList <CovidEntry> list){
        for (CovidEntry z : list){
            results.append(z + "\n");
        }
        results.append("Total Results: " + list.size());

    }

    /*****************************************************************
     * This method is called when any button is clicked.  The proper
     * internal method is called as needed.
     * 
     * @param e the event that was fired
     ****************************************************************/       
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == quitItem){
            System.exit(1);
        }
        else if (e.getSource() == openItem){
            openFile();
        }
        else if(database.countRecords() == 0){
            JOptionPane.showMessageDialog(this, "Did you open the database?");
            return;
        }
        else if (e.getSource() == statsItem){
            displayStats();
        }
        else if (e.getSource() == dailyInfections){
            displayDailyInfections();
        }
        // FIX ME: include else if instructions for (safe, peakDeaths, topTen)
        else if (e.getSource() == safe){
        	displaySafeToOpen();
        }
        else if (e.getSource() == peakDeaths){
        	displayPeakDeaths();
        }
        else if (e.getSource() == topTen){
        	displayTopTen();
        }

    }

    /*****************************************************************
     * open a data file with the name selected by the user
     ****************************************************************/ 
    private void openFile(){

        // create File Chooser so that it starts at the current directory
        String userDir = System.getProperty("user.dir");
        JFileChooser fc = new JFileChooser(userDir);

        // show File Chooser and wait for user selection
        int returnVal = fc.showOpenDialog(this);

        // did the user select a file?
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getName();
            database.readCovidData(filename);          
        }
    }

    /***************************************************************
    Helper method retrieves input from month and day fields
    and calls peakDailyDeaths
     ***************************************************************/  
    private void displayPeakDeaths(){
        CovidEntry c;
        if (stateFld.getText().length() == 0) {
        	
            //for if no state text input
        	
        } else if (isValidState()){ 
            String st = stateFld.getText();
            results.setText("Peak Daily Deaths for " + st.toUpperCase() + "\n");
            c = database.peakDailyDeaths(st);
            if (c != null) {
                results.append(c.toString());
            }
            else{
            	if (isValidDay() && isValidMonth()) {
            		results.append("No records found for the state");
            	}
            	results.append("Enter valid date");
            }
        } 
        if (monthFld.getText().length() == 0 || dayFld.getText().length() == 0) {
        	
        	//for if no day or month text input
        	
        } else if (isValidDay() && isValidMonth()) {
        	
            int m = Integer.parseInt(monthFld.getText());
            int d = Integer.parseInt(dayFld.getText());
            results.setText("Peak Daily Deaths on " + m + "/" + d + "\n");
            c = database.peakDailyDeaths(m, d);
            if (c != null) {
                results.append(c.toString());
            } else {
        	results.append("Enter valid date");
        	
            }
        }

    }

    /***************************************************************
     * Helper method to display minimum daily infections 
     ***************************************************************/ 
    private void displayDailyInfections(){
        if(isValidMonth() && isValidDay() && isValidMinInfections()){
            int month = Integer.parseInt(monthFld.getText());
            int day = Integer.parseInt(dayFld.getText());
            int min = Integer.parseInt(minFld.getText());
            ArrayList <CovidEntry> list = database.listMinimumDailyInfections(month, day, min);
            results.setText("All states with at least " + min 
                + " infections on " + month + "/" + day + "\n");
            if (list.size() > 0) {
                displayRecords (list);
            }    
            else {
                results.append("No records found for the date and minimum value");
            }
        }
        else {
            results.append("Invalid values for input parameters");
        }
    }

    /***************************************************************
     * Helper method to display safe to open
     ***************************************************************/ 
    private void displaySafeToOpen(){
        // FIX ME: write the logic for this method
    	if(isValidState()) {
    		
    		String state = stateFld.getText();
    		ArrayList <CovidEntry> list = database.safeToOpen(state);
            results.setText("Last five days: \n");
    		if (list.size() > 0) {
                displayRecords (list);
            }    
            else {
                results.append("Never safe to open");
            }
        }
        else {
            results.append("Invalid values for input parameters");
        }

    }

    /***************************************************************
     * Helper method to display top ten
     ***************************************************************/ 
    private void displayTopTen(){
        // FIX ME: write the logic for this method
    	if(isValidMonth() && isValidDay()) {
    		
            int m = Integer.parseInt(monthFld.getText());
            int d = Integer.parseInt(dayFld.getText());
    		ArrayList <CovidEntry> list = database.topTenDeaths(m, d);
            results.setText("Top ten states ranked by daily deaths on " + m + "/" + d + ": \n");
            displayRecords (list);
            } 
    	else {
            results.append("Invalid values for input parameters");
        }

    }

    /***************************************************************
     * Helper method to display statistics 
     ***************************************************************/ 
    private void displayStats(){
        // FIX ME: write the logic for this method
    	int count = database.countRecords();
    	int totalDeaths = database.getTotalDeaths();
    	int totalInfections = database.getTotalInfections();
    	CovidEntry mTotalDeaths = database.mostTotalDeaths();
    	results.append("The number of records: " + fmt.format(count) + "\n");
    	results.append("Total deaths: " + fmt.format(totalDeaths) + "\n");
    	results.append("Total infections: " + fmt.format(totalInfections) + "\n");
    	results.append("State with most total deaths: " + mTotalDeaths.toString() + "\n");
    }
    
    /***************************************************************
     * Helper method to display min daily 
     ***************************************************************/ 
    private void displayMinDaily(){
        // FIX ME: write the logic for this method
        if(isValidMonth() && isValidDay() && isValidMinInfections()){
            int month = Integer.parseInt(monthFld.getText());
            int day = Integer.parseInt(dayFld.getText());
            int count = Integer.parseInt(countFld.getText());
            ArrayList <CovidEntry> list = database.listMinimumDailyInfections(month, day,count);
            results.setText("All states with at least " + count 
                + " infections on " + month + "/" + day + "\n");
            if (list.size() > 0) {
                displayRecords (list);
            }    
            else {
                results.append("No records found for the date and minimum value");
            }
        }
        else {
            results.append("Invalid values for input parameters");
        }
    }

    /************************************************************
    Set up menu items
     ************************************************************/    
    private void setupMenus(){

        // create quit menu item
        quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(this);

        // creates menu items
        openItem = new JMenuItem("Open...");    
        statsItem = new JMenuItem("Stats");
        statsItem.addActionListener(this);
        openItem.addActionListener(this);

        // add each item to File menu
        fileMenu = new JMenu("File");
        fileMenu.add(openItem); // add Open... menu item
        fileMenu.add(statsItem); // add stats menu item
        fileMenu.add(quitItem);

        // display menu bar and File menu
        menus = new JMenuBar();
        menus.add(fileMenu);  
        setJMenuBar(menus);
    }

    /*****************************************************************
     * Check if the String contains a valid integer month.  Display
     * an appropriate warning if it is not valid.
     * 
     * @return true if valid
     ****************************************************************/   
    private boolean isValidMonth(){
        boolean isValid = true;
        try{
            int val = Integer.parseInt(monthFld.getText());
            if(val<1 || val > 12)
                throw new NumberFormatException();
            // display error message if not a valid integer    
        }catch(NumberFormatException e){
            isValid = false;
            JOptionPane.showMessageDialog(this, "Enter a valid month (1-12)");

        }    
        return isValid;
    }

    /*****************************************************************
     * Check if the String contains a valid integer day (1-31).  Display
     * an appropriate warning if it is not valid.
     * 
     * @return true if valid
     ****************************************************************/ 
    private boolean isValidDay(){
        // FIX ME: write the logic for this method
        boolean isValid = true;
        try{
            int val = Integer.parseInt(monthFld.getText());
            if(val<1 || val > 31)
                throw new NumberFormatException();
            // display error message if not a valid integer    
        }catch(NumberFormatException e){
            isValid = false;
            JOptionPane.showMessageDialog(this, "Enter a valid day (1-31)");

        }    
        return isValid;
    }    

    /*****************************************************************
     * Check if the String contains a valid integer value  Display
     * an appropriate warning if it is not valid.
     * 
     * @return true if valid
     ****************************************************************/ 
    private boolean isValidMinInfections(){
        // FIX ME: write the logic for this method
        boolean isValid = true;
        try{
            int val = Integer.parseInt(monthFld.getText());
            if(val<1)
                throw new NumberFormatException();
            // display error message if not a valid integer    
        }catch(NumberFormatException e){
            isValid = false;
            JOptionPane.showMessageDialog(this, "Enter a valid day (1-31)");

        }    
        return isValid;
    }  

    /*****************************************************************
     * Check if the String contains a string
     * 
     * @return true if valid
     ****************************************************************/ 
    private boolean isValidState(){
        // FIX ME: write the logic for this method
    	boolean isValid = true;
    	try {
    		if (stateFld.getText().length() != 2 || 
    			State.valueOf(stateFld.getText().toUpperCase()) == null) {
    			
    			throw new IllegalArgumentException();	
    			
    		}
    		
    	} catch (IllegalArgumentException e){
    		
    		isValid = false;
            JOptionPane.showMessageDialog(this, "Enter a valid state abbreviation");
    		
    	}
    	
    	return isValid;

    }    
}