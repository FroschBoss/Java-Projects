import java.awt.Button; // Import the Button class from the AWT package for creating buttons.
import java.io.*; // Import input-output classes.
import java.awt.*; // Import the entire AWT package for GUI components.

// Define a public class named sampleGui that extends EasyApp class.
public class sampleGui extends EasyApp {
	  
    String Mode = "MODE";
    // Declare GUI components: buttons, text fields, labels, checkbox, list, and choice.
    Button bEnter = addButton("Enter number",25,50,175,50, this); // Create a button with specified text and position.
    Button bChoices = addButton("Choices",225,50,175,50, this); // Create another button.
    Button bQuit = addButton("Quit",500,350,50,50, this); // Create a quit button.
    Button UCL = addButton("UCL",300,250,150,50, this); // Create a quit button.
    Button Superbowl = addButton("Superbowl",300,200,150,50, this); // Create a quit button.
    TextField tDisplay = addTextField("",150,100,200,50,this); // Create a text field with initial text and position.
    Label lDisplay  = addLabel("Current number",45,100,100,50,this); // Create a label with specified text and position.
    Checkbox cBox = addCheckbox(Mode,45,150, 150, 50, this); // Create a checkbox with specified label and position.
    Choice lList = addChoice("Eastern Finalist ",45,200,150,50,this); // Create a list with specified label and position.
    Choice cChoice = addChoice("Western Finalist ",45,250,150,50,this); // Create a choice (dropdown) with specified label and position.

    // Constructor for initializing GUI components.
    public sampleGui() {
        // Add predefined items to the choice and list components.
        cChoice.add("Celtics"); // Add an item to the choice component.
        cChoice.add("Pacers"); // Add another item to the choice component.
        
        lList.add("Mavericks"); // Add another item to the list component.
        lList.add("Timberwolves"); // Add another item to the list component.
      
    }

    // Method to handle actions performed on GUI components.
    public void actions(Object source,String command) {
        // Check if the source of the action is the "Enter number" button.
       
    
       
       
        // Check if the checkbox is checked.
        if(cBox.getState() == true) 
        { 
        	Mode = "Power";
            // Display a message indicating the choice is noted.
           if (source == bEnter) {
        	   
           String val = input("Enter a new amount"); 
           // Parse the input string to an integer.
           int amount = Integer.parseInt(val);
           // Double the entered number.
           int powerAmount = power(amount);
           // Display the doubled number in the text field.
           tDisplay.setText("" + powerAmount);
           }
          
         }
        
        if(cBox.getState() == false) 
        { 
        	Mode = "Factorial";
            // Display a message indicating the choice is noted.
           if (source == bEnter) {
           String val = input("Enter a new amount"); 
           // Parse the input string to an integer.
           int amount = Integer.parseInt(val);
           // Double the entered number.
           int factorialAmount = factorial(amount);
           // Display the doubled number in the text field.
           tDisplay.setText("" + factorialAmount);
           
          
           }
          
        	 
         }
           
            
           
            
              
            
            
        

        // Check if the source of the action is the "Choices" button.
        if(source == bChoices) {
            // Display the selected index of the list and choice components.
            output("Selected index of list: " + lList.getSelectedIndex());
            output("Selected index of choice: " + cChoice.getSelectedIndex());
            // Display the selected items from list and choice components.
            tDisplay.setText(" " + lList.getItem(lList.getSelectedIndex()) + " " + cChoice.getSelectedIndex());  
        }
        
        if(lList.getSelectedIndex() == 2 && cChoice.getSelectedIndex() == 2)
        {
        	output("Correct pick");
        }
        else if(lList.getSelectedIndex() == 1 && cChoice.getSelectedIndex() == 1)
        {
        	output("WRONG!!!!!!");
        }
        else if(lList.getSelectedIndex() == 2 && cChoice.getSelectedIndex() == 1 || lList.getSelectedIndex() == 1 && cChoice.getSelectedIndex() == 2 )
        {
        	output("almost correct, but one team shouldn't be here");
        }
        else
        {
        	
        }

        // Check if the source of the action is the "Quit" button.
        if(source == bQuit) 
        {  
            // Exit the application.
            System.exit(0);
        } 
       
        if(source == UCL)
        {
        	String UEFA = input("Who wins the Champions League"); 
        	
        	if(UEFA.equals("Eintracht Frankfurt"))
        	{
        		output("Correct!");
        	}
        	else
        	{
        		output("Incorrect, try again");
        	}
        
        }
        
        if(source == Superbowl)
        {
        	String BOWL = input("Who wins the Superbowl"); 
        	
        	if(BOWL.equals("Kansas City Chiefs") || BOWL.equals("Chiefs") || BOWL.equals("Kansas City") || BOWL.equals("kcc") || BOWL.equals("KCC")  )
        	{
        		output("WRONG! Who are you, George?");
        	}
        	else
        	{
        		output("Correct!, anyone but the Chiefs win");
        	}
        
        }
        
       
    }

    // Method to double a given number.
    public int factorial(int am) {
        // Perform the doubling operation.
    	{
    		int sum = 1;
    		
    		for(int val = am; val > 0; val--)
    		{
    			sum = sum*val;
    		}
    			
    			return sum;
    		}
    }
    public int power(int am) {
    	        // Perform the doubling operation.
    	    	{
    	    		int sum2 = 1;
    	    		
    	    		for(int val = am; val > 0; val--)
    	    		{
    	    			sum2 = sum2*am;
    	    		}
    	    			
    	    			return sum2;
    	    		}
    	
    	
       
        // Return the doubled value.
    	    	
   }
    
   
    
 // Entry point for the program.
    public static void main(String[] args) 
    {
        // Create an instance of the sampleGui class to initiate the GUI application.
        new sampleGui();
    }
}
