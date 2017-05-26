
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*; //These imports are required to use GUI components

import java.util.*;

import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.util.Scanner;
class Test {
  public static void main(String args[]) {  //main method
    
    Scanner userInput = new Scanner(System.in); 
    
    String answer;
    System.out.println("Address:");
    answer = userInput.next();
    
//    if (answer.contains ("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")) {
    if (answer.matches ("^[A-Z0-9]+$")) {
   // if (answer.contains ("^[a-z0-9-]+$")) {  
      System.out.println("Valid"); 
    } else {
      System.out.println("Invalid"); 
    }
  }
}
