//Name: Daniel Qi
//Date: November 17, 2014
//Teacher: Anandrajan
//Description: Address book that can hold up to 100 people, contains Name, Address, Phone, and E-Mail
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//Adding the event for the action listener
public class GUIAdressBookD extends JFrame implements ActionListener
{
  
  //Creating Panels
  JPanel pan1=new JPanel();
  JPanel pan2=new JPanel();
  JPanel pan3=new JPanel();
  JPanel pan4=new JPanel();
  JPanel pan5=new JPanel();
  
  //Creating GUI components
  JLabel firstnameLabel=new JLabel("First Name: ", JLabel.RIGHT);
  JLabel lastnameLabel=new JLabel("Last Name: ", JLabel.RIGHT);
  JLabel addressLabel=new JLabel("Address: ", JLabel.RIGHT);
  JLabel phoneLabel=new JLabel("Phone Number: ", JLabel.RIGHT);
  JLabel mailLabel=new JLabel("E-Mail: ", JLabel.RIGHT);
  JTextField firstnameField=new JTextField(10);
  JTextField lastnameField=new JTextField(10);
  JTextField addressField=new JTextField(10);
  JTextField phoneField=new JTextField(10);
  JTextField mailField=new JTextField(10);
  JButton saveButton=new JButton("Save");
  JButton cancelButton=new JButton("Cancel");
  JButton deleteButton=new JButton("Delete");
  JButton editButton=new JButton("Edit");
  JButton searchButton=new JButton("Search");
  JButton prevousButton=new JButton("Prevous");
  JButton nextButton=new JButton("Next");
  JButton clearButton=new JButton("Clear");
  JLabel instructionsLabel=new JLabel("     Enter your personal information     ", JLabel.RIGHT);
  JLabel searchnameLabel=new JLabel("Name: ", JLabel.RIGHT);
  JLabel searchaddressLabel=new JLabel("Address: ", JLabel.RIGHT);
  JLabel searchphoneLabel=new JLabel("Phone Number: ", JLabel.RIGHT);
  JLabel searchmailLabel=new JLabel("E-Mail: ", JLabel.RIGHT);
  
  
  //Creating some variables and Arrays
  int length = 100;
  int position = 0;
  int location, value=-1;
  String firstname[] = new String[length];
  String lastname[] = new String[length];
  String address[] = new String[length];
  String mail[] = new String[length];
  String phone[] = new String[length];
  
  //The GUI contructor
  public GUIAdressBookD()
  {
    setTitle("Address Book");//Setting the title of GUI
    setSize(320,350);//Setting the size of the window
    setResizable(false);//Making the window not resizable
    
    //Creating Layouts
    FlowLayout layout2 = new FlowLayout();
    BoxLayout layout1=new BoxLayout(pan1,BoxLayout.Y_AXIS);
    BoxLayout layout4=new BoxLayout(pan2,BoxLayout.Y_AXIS);
    BoxLayout layout5=new BoxLayout(pan4,BoxLayout.Y_AXIS);
    BoxLayout layout6=new BoxLayout(pan5,BoxLayout.Y_AXIS);
    
    //Set frame and panel layouts
    setLayout(layout2);//Layout for whole frame
    pan1.setLayout(layout1);//Layout for panel 1
    pan2.setLayout(layout4);//Layout for panel 2
    pan3.setLayout(layout2);//Layout for panel 3
    pan4.setLayout(layout5);//Layout for panel 4
    pan5.setLayout(layout6);//Layout for panel 5
    
    //Adding action listeners to all buttons
    saveButton.addActionListener(this);
    cancelButton.addActionListener(this);
    deleteButton.addActionListener(this);
    editButton.addActionListener(this);
    searchButton.addActionListener(this);
    prevousButton.addActionListener(this);
    nextButton.addActionListener(this);
    clearButton.addActionListener(this);
    
    //Adding the GUI components to the panels
    pan1.add(firstnameLabel);
    pan1.add(firstnameField);
    pan1.add(lastnameLabel);
    pan1.add(lastnameField);
    pan1.add(addressLabel);
    pan1.add(addressField);
    pan1.add(phoneLabel);
    pan1.add(phoneField);
    pan1.add(mailLabel);
    pan1.add(mailField);
    pan2.add(saveButton);
    pan2.add(cancelButton);
    pan2.add(deleteButton);
    pan2.add(editButton);
    pan2.add(searchButton);
    pan2.add(clearButton);
    pan3.add(instructionsLabel);
    pan4.add(searchnameLabel);
    pan4.add(searchaddressLabel);
    pan4.add(searchphoneLabel);
    pan4.add(searchmailLabel);
    pan5.add(prevousButton);
    pan5.add(nextButton);
    
    //Adding panels to frame
    add(pan1);
    add(pan2);
    add(pan3);
    add(pan4);
    add(pan5);
    setVisible(true); //set panels to display in window
  }
  
  //The action Listener, runs when a button is pressed
  public void actionPerformed(ActionEvent event) 
  {
    String command = event.getActionCommand();// Find name of button that was pressed
    if(command.equals("Save"))//If button Save was pressed
    {
      if(position<100)//check if there is still space in the address book for new contacts
      {
        //Message in console for testing
        System.out.println("Save button pressed");
        System.out.println("Name:" + firstnameField.getText()+" "+ lastnameField.getText());
        System.out.println("Address:"+addressField.getText());
        System.out.println("E-Mail:"+mailField.getText());
        System.out.println("Phone Number:"+phoneField.getText());
        instructionsLabel.setText("Hello " + firstnameField.getText()+" "+ lastnameField.getText()+", your personal information was saved."); //Change instructions label to display appropriate message
        
        //Saving the data entered into the arrays
        firstname[position]= firstnameField.getText();
        lastname[position]= lastnameField.getText();
        address[position]= addressField.getText();
        mail[position]= mailField.getText();
        phone[position]= phoneField.getText();
        
        //Changing the labels at bottom to display entered Data
        searchnameLabel.setText("Name: "+firstname[position]+" "+lastname[position]);
        searchaddressLabel.setText("Address: "+address[position]);
        searchphoneLabel.setText("Phone Number: "+phone[position]);
        searchmailLabel.setText("E-Mail: "+mail[position]);
        position++;
        value++;
        if(position>1)
        {
          for (int i = 0 ; i < position -2 ; i++)
          {
            for (int j = 0 ; j < position -1 - i ; j++)
            {
              if (lastname[j].compareTo(lastname[j+1])<0)
              {
                String atempfirstname = firstname [j];
                firstname [j]=firstname [j+1];
                firstname [j+1]=atempfirstname;
                String atemplastname = lastname [j];
                lastname [j]=lastname [j+1];
                lastname [j+1]=atemplastname;
                String atempaddress = address [j];
                address [j]=address [j+1];
                address [j+1]=atempaddress;
                String atempmail = mail [j];
                mail [j]=mail [j+1];
                mail [j+1]=atempmail;
                String atempphone = phone [j];
                phone [j]=phone [j+1];
                phone [j+1]=atempphone;
              }
            }
          }
        }
      }
      else
      {
        instructionsLabel.setText("There are already 100 contacts in the address book"); 
      }
    }
    if(command.equals("Delete"))//If button Delete was pressed 
    {
      //Message in console for testing
      System.out.println("Delete button pressed");
      System.out.println("Name:" + firstnameField.getText()+" "+ lastnameField.getText());
      for(int i = 0 ; i < position ; i++)
      {
        if(firstname[i].equals (firstnameField.getText()) && lastname[i].equals (lastnameField.getText()))//checking if the name entered is in the addressbook
        {
          instructionsLabel.setText("                   Deleted " + firstnameField.getText() +" "+ lastnameField.getText()+" from the list.                  ");//Change instructions label to display appropriate message
          for (int j = i ; j < i+1 ; j++)
          {
            //Moving the array values one up
            String tempfirstname = firstname [j];
            firstname [j]=firstname [j+1];
            firstname [j+1]=tempfirstname;
            String templastname = lastname [j];
            lastname [j]=lastname [j+1];
            lastname [j+1]=templastname;
            String tempaddress = address [j];
            address [j]=address [j+1];
            address [j+1]=tempaddress;
            String tempmail = mail [j];
            mail [j]=mail [j+1];
            mail [j+1]=tempmail;
            String tempphone = phone [j];
            phone [j]=phone [j+1];
            phone [j+1]=tempphone;
          }
          value--;
          position--;
          break;
        }
        else
        {
          instructionsLabel.setText("The name entered is not in contacts.");//Change instructions label to display appropriate message
        }
      }
    }
    if(command.equals("Edit"))//If button Edit was pressed
    {
      //Message in console for testing
      System.out.println("Edit button pressed");
      System.out.println("Name:" + firstnameField.getText()+" "+ lastnameField.getText());
      for (int i = 0 ; i < position ; i++)
      {
        if(firstname[i].equals (firstnameField.getText()) && lastname[i].equals (lastnameField.getText()))
        {
          //Change the values stored to input fields
          address[i]= addressField.getText();
          mail[i]= mailField.getText();
          phone[i]= phoneField.getText();
          instructionsLabel.setText("    "+firstnameField.getText() +" "+ lastnameField.getText()+"'s information has been edited.    ");//Change instructions label to display appropriate message
          break;
        }
        else
        {
          instructionsLabel.setText("The name was not found in the contacts.");//Change instructions label to display appropriate message
        }
      }
    }
    if(command.equals("Search"))//If button Search was pressed
    {
      //Message in console for testing
      System.out.println("Search button pressed");
      System.out.println("Name:" + firstnameField.getText()+" "+ lastnameField.getText());
      for (int i = 0 ; i < position ; i++)
      {
        if(firstname[i].equals(firstnameField.getText()) && lastname[i].equals(lastnameField.getText()))//checking if name is in the address book
        {
          location=i;
          instructionsLabel.setText("           Found "+firstnameField.getText()+" "+lastnameField.getText()+" in the contacts.          ");//Change instructions label to display appropriate message
          searchnameLabel.setText("Name: "+firstname[i]+" "+lastname[i]);
          searchaddressLabel.setText("Address: "+address[i]);
          searchphoneLabel.setText("Phone Number: "+phone[i]);
          searchmailLabel.setText("E-Mail: "+mail[i]);
          break;
        }
        else
        {
          instructionsLabel.setText("Name was not found in the contacts.");//Change instructions label to display appropriate message
        }
      }
      value=location;
    }
    if(command.equals("Clear"))//If button Clear was pressed
    {
      //Message in console for testing
      System.out.println("Clear button pressed");
      System.out.println("Name:" + firstnameField.getText()+" "+ lastnameField.getText());
      instructionsLabel.setText("All information fields have been cleared.");//Change instructions label to display appropriate message
      //Clearing all text fields
      firstnameField.setText("");
      lastnameField.setText("");
      addressField.setText("");
      mailField.setText("");
      phoneField.setText("");
    }
    if(command.equals("Prevous"))//If button Prevous was pressed
    {
      //Message in console for testing
      System.out.println("Prevous button pressed");
      System.out.println("Name:" + firstnameField.getText()+" "+ lastnameField.getText());
      if (value>0)
      {
        instructionsLabel.setText("               Moved to prevous contact.               ");//Change instructions label to display appropriate message
        //Display the prevous array values
        searchnameLabel.setText("Name: "+firstname[value-1]+" "+lastname[value-1]);
        searchaddressLabel.setText("Address: "+address[value-1]);
        searchphoneLabel.setText("Phone Number: "+phone[value-1]);
        searchmailLabel.setText("E-Mail: "+mail[value-1]);
        value--;
      }
      else
      {
        instructionsLabel.setText("               No prevous position.               ");//Change instructions label to display appropriate message
      }
    }
    if(command.equals("Next"))//If button Next was pressed
    {
      //Message in console for testing
      System.out.println("Next button pressed");
      System.out.println("Name:" + firstnameField.getText()+" "+ lastnameField.getText());
      if (value<position-1)
      {
        instructionsLabel.setText("               Moved to next contact.               ");//Change instructions label to display appropriate message
        //Display the next array values
        searchnameLabel.setText("Name: "+firstname[value+1]+" "+lastname[value+1]);
        searchaddressLabel.setText("Address: "+address[value+1]);
        searchphoneLabel.setText("Phone Number: "+phone[value+1]);
        searchmailLabel.setText("E-Mail: "+mail[value+1]);
        value++;
      }
      else
      {
        instructionsLabel.setText("                    No next position.                    ");//Change instructions label to display appropriate message
      }
    }
  }
  
  //Main method
  public static void main(String[] args) 
  {
    //Start the GUI
    GUIAdressBookD frame = new GUIAdressBookD();
  }
}


