/* [AddressBook]
 * Name: Jacqueline Chung
 * Teacher: Mangat Period 4
 * Date: October 31-November 24, 2014
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*; //These imports are required to use GUI components

import java.util.*;
import javax.swing.JList;
import java.awt.FlowLayout;
import java.awt.Panel;

//import javax.swing.JComboBox;
import javax.swing.JFrame;

//Class variables can go here (define your buttons, etc)
public class AddressBook extends JFrame implements ActionListener {  //class name now must extend Jframe, turns your program into a program thatdescribes a frame
  //delcare variables
  String[ ] first = new String[100];
  String[ ] last = new String[100];
  String[ ] address = new String[100];
  String[ ] phone = new String[100];
  String[ ] email = new String[100]; 
  
  String search, newlast, newaddress, newphone, newemail; //, newemail1;
  
  int numofC = 0, count = -1, position, swapped = 0;
  int mc = JOptionPane.WARNING_MESSAGE, em = JOptionPane.ERROR_MESSAGE;
  //JOptionPane.showMessageDialog (null, "Contact deleted!", "Information", JOptionPane.INFORMATION_MESSAGE); //dialog box
  
  JPanel pan1 = new JPanel();
  JPanel pan2 = new JPanel();
  JPanel pan3 = new JPanel();
  
  JScrollPane ScrollPane = new JScrollPane(); 
  
  //Create some GUI components
  JTextField firstField = new JTextField(25); //add text field for the informaton from user
  JTextField lastField = new JTextField(25); //add text field for the informaton from user
  JTextField addressField = new JTextField(26); //add text field for the informaton from user
  JTextField phoneField = new JTextField(27); //add text field for the informaton from user
  JTextField emailField = new JTextField(28); //add text field for the informaton from user
  // JTextField email1Field = new JTextField(6); //add text field for the informaton from user
  JTextField searchField = new JTextField(22); //add text field for the informaton from user
  //add labels for the names, phone numbers, adresses, emails
  JLabel firstLabel = new JLabel("First Name: ", JLabel.RIGHT);
  JLabel lastLabel = new JLabel("Last Name: ", JLabel.RIGHT);
  JLabel addressLabel = new JLabel("Address: ", JLabel.RIGHT);
  JLabel phoneLabel = new JLabel("Phone: ", JLabel.RIGHT);
  JLabel emailLabel = new JLabel("Email: ", JLabel.RIGHT);
  JLabel informLabel = new JLabel("Max. 100 contacts - Search by last name and then first name ", JLabel.RIGHT);
  //add buttons for add, delete, edit, previous, next, and search
  JButton addButton = new JButton("Add");   
  JButton deleteButton = new JButton("Delete"); 
  JButton editButton = new JButton("Edit");
  JButton nextButton = new JButton("Next");
  JButton previousButton = new JButton("Previous");
  JButton searchButton = new JButton("Search");
  JButton clearButton = new JButton("Clear");
  
  public static DefaultListModel listModel = new DefaultListModel(); 
  JList list = new JList(listModel);
  
  // CONSTRUCTOR - Setup your GUI here
  public AddressBook() { 
    
    for (int i = 0; i < 100; i++) {
      last [i] = " "; //start with the contacts being declared as a space
    }
    
    setTitle("Address Book (Jacqueline Chung)");    //Create a window with a title
    setSize(750, 350);           // set the window size
    
    // Create some Layouts    
    GridLayout layout1 = new GridLayout(2,0);       
    FlowLayout layout2 = new FlowLayout();
    
    // Set the frame and both panel layouts
    setLayout(layout1);
    pan1.setLayout(layout2);
    pan2.setLayout(layout2);
    pan3.setLayout (layout2);
    
    ScrollPane.getViewport().add( list );   //add scroll pane to the JList list
    
    // Add an action listener to the button, this allows the program to know if the button was pressed
    //disable button for edit, delete, previous, next buttons 
    addButton.addActionListener(this);  
    deleteButton.addActionListener(this); 
    deleteButton.setEnabled(false);
    editButton.addActionListener(this); 
    editButton.setEnabled(false);
    nextButton.addActionListener(this);
    nextButton.setEnabled(false);
    previousButton.addActionListener(this); 
    previousButton.setEnabled(false);
    searchButton.addActionListener(this); 
    searchButton.setEnabled(false);
    clearButton.addActionListener(this); 
    
    // Add all the components to the second panel
    pan1.add(firstLabel);  // add the first name label 
    pan1.add(firstField); //add a text field for the user to right their first name
    firstField.setText ("Note: No changes allowed when editing"); //advise user that no changes can be made when they are editing contacts
    
    pan1.add(lastLabel);  // add the last name label 
    pan1.add(lastField); //add a text field for the user to right their last name
    
    pan1.add(addressLabel);  // add the address label 
    pan1.add(addressField); //add a text field for the user to right their address
    addressField.setText ("(Civic)"); //advise user that it has to be a civic address (home, apartment)
    
    pan1.add(phoneLabel);  // add the phone number label 
    pan1.add(phoneField); //add a text field for the user to right their phone number
    
    pan1.add(emailLabel);  // add the first email address label 
    pan1.add(emailField); //add a text field for the user to right their email address
    
    // Add all the components to the third  panel
    pan2.add(previousButton);//add button to see the previous contact
    pan2.add(addButton);//add a button to add contact
    pan2.add(deleteButton);//add a button to delete contact
    pan2.add(editButton);//add a button to edit contact
    pan2.add(nextButton);//add button to see the next contact
    pan2.add(clearButton);//add button to see the clear text fields
    
    //Add all componenets to the fourth panel    
    pan3.add(searchField); //add a text field for the user to input the name of the user
    pan3.add(searchButton);//add a button to search for contact
    pan3.add(informLabel);//add label to warn the user or instruct them
    
    // add the panels to the frame and display the window
    add (ScrollPane, BorderLayout.CENTER);
    ScrollPane.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //display scrollbar at all times
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //ensure user can only choose one item at a time
    add(pan1);
    add(pan2);
    add(pan3);
    
    setVisible(true);     
  }
  
// ACTION LISTENER - This method runs when an event occurs
  // Code in here only runs when a user interacts with a component
  // that has an action listener attached to it
  public void actionPerformed(ActionEvent event) {
    
    String command = event.getActionCommand();  //find out the name of the component that was used    
    
    if (command.equals("Add")) {                 // if the ADD button was pressed
      
      System.out.println("Add button pressed");  // display message in console(for testing)
      
      first [numofC] = firstField.getText(); //getText receives value from input
      last[numofC] = lastField.getText(); //getText receives value from input
      address[numofC] = addressField.getText(); //getText receives value from input
      phone[numofC] = phoneField.getText(); //getText receives value from input
      email[numofC] = emailField.getText(); //getText receives value from input
      
      System.out.println ("Name Added: " + first[numofC] + " " + last[numofC]); //display name in console (for testing)
      
      for (int i = 0; i < numofC; i++) {
        if (numofC > 0 && first[numofC].equals (first[i])) { //if name is already on record in the array
          JOptionPane.showMessageDialog (null, "This [first] name is already taken. Please enter another name.", "Message", mc); //warn the user that they need to enter a phone number       
          System.out.println ("This [first] name is already taken. Please enter another name."); //test console
          //make first name equal to a space
          first [numofC] = " ";
          firstField.setText ("");
        }
      }

      if (numofC <= 100 && email[numofC].matches ("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$") && phone[numofC].matches("[0-9]+") && phone[numofC].length() == 10 && !last [numofC].equals ("") && !first [numofC].equals ("") && !first[numofC].equals (" ") && !phone[numofC].equals("") && !email[numofC].equals("")) { //if element is invalid
        listModel.addElement (last [numofC] + ", " + first[numofC]); //add last name and the first name onto the list
        System.out.println("Name: " + last [numofC] + ", " + first [numofC]);
      }
      
      if (first[numofC].equals("")) {   //if the first name field is empty       
        JOptionPane.showMessageDialog (null, "Please enter the first name.", "Message", mc); //warn the user that they need to enter a first name      
        System.out.println ("Please enter the first name."); //test console
      } 
      
      if (last[numofC].equals("")) {   //if the last name field is empty       
        JOptionPane.showMessageDialog (null, "Please enter the last name.", "Message", mc); //warn the user that they need to enter a last name       
        System.out.println ("Please enter the last name.");//test console
      } 
      
      if (phone[numofC].equals("")) {   //if the phone field is empty       
        JOptionPane.showMessageDialog (null, "Please enter the phone number.", "Message", mc); //warn the user that they need to enter a phone number       
        System.out.println ("Please enter the phone number.");//test console
      } 
      
      if (!address[numofC].equals ("") && address[numofC].matches ("^[A-Z0-9]+$")) {//if mailing/home address doesn't have letters, numbers
        JOptionPane.showMessageDialog (null, "Remember, the mailing address must contain valid characters! Please enter it again.", "Message", mc); //warn the user that they need to enter a valid characters in the address       
        System.out.println ("Remember, the mailing address must contain valid characters! Please enter it again.");//test console
      }
      
      if (email[numofC].equals("")) {//if email equals nothing
        JOptionPane.showMessageDialog (null, "Please enter the email address.", "Message", mc); //warn the user that they need to enter an email address     
        System.out.println ("Please enter the email address.");//test console
      } 
      
      if (!phone[numofC].matches("[0-9]+") && !phone[numofC].equals("")) {//if phone numebr invalid
        JOptionPane.showMessageDialog (null, "Remember, the phone number must contain valid characters! Please enter it again.", "Message", mc);//give warning to user that the input is invalid         
        System.out.println("Remember, the phone number must contain valid characters! Please enter it again."); //output message that the input is invalid
        //set value as a space
        phone [numofC] = " ";
        phoneField.setText ("");     
      }
      
      if (phone[numofC].length() != 10 && !phone[numofC].equals("")) { //if phone number is not valid
        JOptionPane.showMessageDialog (null, "Remember, the phone number must contain 10 digits! Please enter it again.", "Message", mc); //output message that the user didn't enter 10 digits
        System.out.println("Remember, the phone number must contain 10 digits! Please enter it again."); //test on Interactions Pane that the user didn't enter 10 digits       
        //set value as space
        phone [numofC] = " ";
        phoneField.setText ("");
      }
      
      if (!email[numofC].matches ("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$") && !email[numofC].equals("")) {//if   email not valid    
        JOptionPane.showMessageDialog (null, "Remember, the email address must contain valid characters! Please enter it again.", "Message", em);   //warn user that they didn't enter vlaid characters                  
        System.out.println("Remember, the email address must contain valid characters! Please enter it again."); //output message that there are no users inputted
        //set value as space
        email [numofC] = " ";
        emailField.setText ("");
      }
      
      if (numofC >= 100) { //if the number of contacts is zero
        JOptionPane.showMessageDialog (null, "Address Book is full!", "Message", em); //tell user Address Book is full
        System.out.println("Address Book is full!"); //output message that there are no users inputted
      }

      if  (numofC <= 100 && email[numofC].matches ("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$") && phone[numofC].matches("[0-9]+") && !last [numofC].equals ("") && !first [numofC].equals ("") && !first[numofC].equals (" ")  && !phone[numofC].equals("") && !email[numofC].equals("") ) {
        numofC = numofC + 1; // count the number of contacts that user adds
        count = count + 1;
        if (numofC == 100) { //if the number of contacts is hundred
          JOptionPane.showMessageDialog (null, "Address Book is full!", "Message", em);
          System.out.println("Address Book is full!"); //output message that there are no users inputted
        }
      }
      
      for (int i = 0; i < 100; i++) {
        if (last [i].equals (" ")) { //if last name equals space
          last[i] = last [numofC]; //set lats name equal to the current last name
        }
      }
      
      if (numofC > 0) { //if number of contacts is greater than 0
        //enable buttons
        previousButton.setEnabled(true);
        deleteButton.setEnabled(true);
        editButton.setEnabled(true);
        nextButton.setEnabled(true);
        searchButton.setEnabled(true);
      }
      
      System.out.println ("The number of contacts are " + numofC); //output numebr of contacts
      System.out.println ("The count is " + count); //output count value
      
      //////////////// DELETE BUTTON////////////////////////
    } else if (command.equals ("Delete")) { //if the user presses the Delete button
      System.out.println("Delete button pressed");  // display message in console(for testing)
      System.out.println("Name Deleted (getSelectedValue): " +  list.getSelectedValue());
      
      String answer = JOptionPane.showInputDialog (null, "Enter the contact's name (last then first): ", "Contact to Delete", JOptionPane.QUESTION_MESSAGE);
      
      if (!answer.equals (list.getSelectedValue())) {
        JOptionPane.showMessageDialog (null, "Please enter the name you selected!", "Message", em); //warn user that they have to enter the name slected
        System.out.println("Please enter the name you selected!");//test console
      }
      
      for (int h = 0; h < numofC; h++) {        
        if (answer.equals (last[h] + ", " + first[h]) && answer.equals (list.getSelectedValue())) { 
          listModel.removeElement(list.getSelectedValue());
          JOptionPane.showMessageDialog (null, "Contact deleted!", "Information", JOptionPane.INFORMATION_MESSAGE);   //dialog box to tell user the contact was deleted          
          for (int i = h; i < h + 1; i++) {  
            //set values to space
            first [i] = " ";  
            last [i]= " "; 
            address [i] = " "; 
            phone [i] = " "; 
            email [i] = " "; 
            //move values up in array
            String tempfirst = first [i];
            first [i] = first [i + 1];
            first [i + 1] = tempfirst;
            
            String templast = last [i];
            last [i] = last [i + 1];
            last [i + 1] = templast;
            
            String tempaddress = address [i];
            address [i] = address [i + 1];
            address [i + 1] = tempaddress;
            
            String tempphone = phone [i];
            phone [i] = phone [i + 1];
            phone [i + 1] = tempphone;
            
            String tempemail = email [i];
            email [i] = email [i + 1];
            email [i + 1] = tempemail;         
          } 
          if (numofC > 0 ) { //if the number of contacts is greater 0
            numofC = numofC - 1; // count the number of contacts that user deletes  
            count = count - 1;
          }
        }
      }
      if (listModel.getSize() < 1) { //if the list is less then disable buttons
        previousButton.setEnabled(false);
        deleteButton.setEnabled(false);
        editButton.setEnabled(false);
        nextButton.setEnabled(false);
        searchButton.setEnabled(false);
      }
      
      System.out.println ("The number of contacts are " + numofC); //output number of contacts
      System.out.println ("The count is " + count); //output count value
    }  
    
    ////////////////////SAVE BUTTON///////////////////////
    if (command.equals ("Edit")) { //if user chooses 
      System.out.println("Edit button pressed");  // display message in console(for testing)     
      
      for (int i = 0; i < numofC; i++) {
        if (firstField.getText().equals (first[i])) {  //if the first name matches in the record of the array  
          //when saving it, if the data is invalid
          newlast = lastField.getText(); //getText receives value from input
          newaddress = addressField.getText(); //getText receives value from input
          newphone = phoneField.getText(); //getText receives value from input
          newemail = emailField.getText(); //getText receives value from input

          if (newphone.equals("")) {   //if the phone field is empty       
            JOptionPane.showMessageDialog (null, "Please enter the phone number.", "Message", mc); //warn the user that they need to enter a phone number       
            System.out.println ("Please enter the phone number.");//test in console
          } 
          
          if (newemail.equals("")) {// || newemail1.equals("")) { //if the email fields empty
            JOptionPane.showMessageDialog (null, "Please enter the email address.", "Message", mc); //warn the user that they need to enter an email address     
            System.out.println ("Please enter the email address.");//test in console
          }           
          
          if (!newaddress.equals ("") && newaddress.matches ("^[A-Z0-9]+$")) {//if mailing/home address doesn't have letters, numbers
            JOptionPane.showMessageDialog (null, "Remember, the mailing address must contain valid characters! Please enter it again.", "Message", mc); //warn the user that they need to enter a valid characters in the address       
            System.out.println ("Remember, the mailing address must contain valid characters! Please enter it again.");//test console
          }
          
          if (!newphone.matches("[0-9]+") && !newphone.equals("")) { //if phone number is valid
            JOptionPane.showMessageDialog (null, "Remember, the phone number must contain valid characters! Please enter it again.", "Message", mc);//give warning to user that the input is invalid         
            System.out.println("Remember, the phone number must contain valid characters! Please enter it again."); //output message that the input is invalid
            //set values to a space
            newphone = " ";
            phoneField.setText ("");     
          }
          
          if (newphone.length() != 10 && !newphone.equals("")) { //if the length is not 10 or is filled
            JOptionPane.showMessageDialog (null, "Remember, the phone number must contain 10 digits! Please enter it again.", "Message", em); //output message that the user didn't enter 10 digits
            System.out.println("Remember, the phone number must contain 10 digits! Please enter it again."); //test on Interactions Pane that the user didn't enter 10 digits       
            //set values to space
            newphone  = " ";
            phoneField.setText ("");
            
            if (!newemail.matches ("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$") && !newemail.equals("")) { //if the edited email is invalid         
              JOptionPane.showMessageDialog (null, "Remember, the email address must contain valid characters! Please enter it again.", "Message", em);   //warn user  that their email is invalid                
              System.out.println("Remember, the email address must contain valid characters! Please enter it again."); //set values to space
              //set values to space
              newemail = " ";
              emailField.setText ("");
            } 
          }    
          
          if  (numofC <= 100 && newemail.matches ("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$") && newphone.matches("[0-9]+") && newphone.length() == 10 && !newlast .equals ("") && !first [i].equals ("") && !first[i].equals (" ") && !newphone.equals("") && !newemail.equals("")) { //if the input is valid
            if (!last [i].equals (newlast)) {//if last name doesn not equal the new last name
              listModel.removeElement(last[i] + ", " + first[i]); //remove  names
              listModel.addElement (lastField.getText() + ", " + firstField.getText()); //add last name and the first name onto the list              
            }
            //set variables to the new edits
            last [i] = newlast;
            address[i] = newaddress;
            phone[i] = newphone;
            email [i] = newemail;
            informLabel.setText ("Contact Updated!");//inform user that their contact has been edited
            System.out.println ("Contact Updated!");//set values to space
          }
          break; //break out of loop so it doesn't continue looping
        } else if (!firstField.getText().equals (first[i])) {
          informLabel.setText ("Contact not found! No edits can be made."); //warn the user that they need to enter a phone number       
          System.out.println ("Contact not found! No edits can be made.");//test console
        }
      }
      
      
    } else if (command.equals ("Clear")) {//if user chooses the 'Clear' button to delete the input from the fields
      firstField.setText ("");
      lastField.setText ("");
      addressField.setText ("");
      phoneField.setText ("");
      emailField.setText ("");
    }
    
    //////////////////////////PREVIOUS BUTTON//////////////////////
    if (command.equals ("Previous")) { //if user chooses Previous button
      //test console
      System.out.println("Previous button pressed");
      System.out.println(firstField.getText()+ " " + lastField.getText());
      searchButton.setEnabled(false); //disable the Search button
      
      if (count > 0) {//if count is greater than 0
        nextButton.setEnabled(true); //enable the next button   
        //Output or set text to the previous set of contacts in alphabtical order
        firstField.setText(first[count - 1]);
        lastField.setText(last[count - 1]);
        addressField.setText(address[count - 1]);
        phoneField.setText(phone[count - 1]);
        emailField.setText(email[count - 1]);
        
        count = count - 1; //subtract by 1
        
      } else if (count == 0) { //if count is equal to 0
        informLabel.setText ("You are at the beginning of the list"); //set text to tell user that they are at the beginning of the list
        previousButton.setEnabled(false); //disable button to ensure the user knows it's the beginning of the list
      }
      
      /////////////////////////NEXT BUTTON//////////////////////////////
    } else if (command.equals ("Next")) { //if user chooses Next button
      //test console
      System.out.println("Next button pressed");
      System.out.println(firstField.getText() + " " + lastField.getText());      
      searchButton.setEnabled(false); //disable the Search button 
      
      if (count < numofC - 1) {
        previousButton.setEnabled(true); //enable previous button         
        
        //Output or set text to the next set of contacts in alphabtical order
        firstField.setText(first[count + 1]);
        lastField.setText(last[count + 1]);
        addressField.setText(address[count + 1]);
        phoneField.setText(phone[count + 1]);
        emailField.setText(email[count + 1]);
        
        count = count + 1; //add by 1
      } else if (count >= numofC - 1) {//if the count is greater than one less than the number of contacts
        informLabel.setText ("You are at the end of the list"); //inform user they are at the end of the lsit
        nextButton.setEnabled(false); //disable the next button, so the user knows its the end of the list
      }
      
      //////////////////////SEARCH BUTTON//////////////////////////
    } else if (command.equals ("Search")) { //if user chooses Search button
      //test console
      System.out.println("Search button pressed");  // display message in console(for testing)
      System.out.println("Search entered: " + searchField.getText());
      
      for (int i = 0; i < numofC; i++) {  
        if (searchField.getText().equals (last [i] + ", " + first [i])) { //if the search matches one of the contacts
          position = i; //set position equal to i
          //set text to the contact searched for
          firstField.setText (first[i]);
          lastField.setText (last [i]);
          addressField.setText (address [i]);
          phoneField.setText (phone [i]);
          emailField.setText (email [i]);
          
          informLabel.setText("Contact found: " + last [i] + ", " + first [i]); //inform user contact was found
          System.out.println ("Contact found: " + first [i] + " " + last [i]); //test console
          
          break; //break out of loop so it doesn't continue looping
          
        } else if (!searchField.getText().equals (last [i] + ", " + first [i])) {
          informLabel.setText("Contact not found!");   //inform user contact not found
          System.out.println ("Contact not found!");//test console
        }        
      }
      count = position; //set count to position
    }        
    //test on console
    System.out.println("The list of contact names: ");
    for (int i = 0; i < numofC; i++) {
      if (!last [i].equals (" ")) { //if the last name is not equal to space
        System.out.println(last [i] + ", " + first [i]); //output names
      }      
    }
    
    System.out.println("The list of SORTED contact names: ");
    //sort the list of contacts alphabetically 
    //BUBBLE SORT   
    do {       //do while swapped is not 0
      listModel.removeAllElements(); //remove all the elements from the list to output them alphabetically 
      for (int h = 0; h < numofC; h++) {
        swapped = 0;//set swapped to 0 so it resets
        for (int i = h + 1; i < numofC; i++) { //checks and swaps from the beginning
          
          if (last [i].compareTo(last [h]) < 0) { //if out of order
            //swap the data
            String tempfirst = first[h];                
            first [h] = first [i];                
            first [i] = tempfirst;
            
            String templast = last[h];                
            last [h] = last [i];                
            last [i] = templast;
            
            String tempaddress = address[h];                
            address [h] = address [i];                
            address [i] = tempaddress;
            
            String tempphone = phone[h];                
            phone [h] = phone [i];                
            phone [i] = tempphone;
            
            String tempemail = email[h];                
            email [h] = email [i];                
            email [i] = tempemail;   
            
            swapped = 1; //swapped is now equal to 1
          }
        }
        
        if (!last [h].equals ("")) {           //if last name has a value
          listModel.addElement(last [h] + ", " + first [h]); //add the element sorte
          System.out.println(last [h] + ", " + first [h]);//output to test console
        }
      }
    } while (swapped != 0);
  }
  
  public static void main(String[] args) { //Main method
    AddressBook frame1 = new AddressBook();  //Start the GUI    
  }  
}