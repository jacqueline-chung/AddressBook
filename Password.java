

public class Password {
  
  passwordField = new JPasswordField(10);
passwordField.setActionCommand(OK);
passwordField.addActionListener(this);
  
  public void actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();
    
    if (OK.equals(cmd)) { //Process the password.
      char[] input = passwordField.getPassword();
      if (isPasswordCorrect(input)) {
        JOptionPane.showMessageDialog(controllingFrame,
                                      "Success! You typed the right password.");
      } else {
        JOptionPane.showMessageDialog(controllingFrame,
                                      "Invalid password. Try again.",
                                      "Error Message",
                                      JOptionPane.ERROR_MESSAGE);
      }
      
      //Zero out the possible password, for security.
      for (int i = 0; i < input.length; i++) {
        input[i] = 0;
      }
      
      passwordField.selectAll();
      resetFocus();
    } else ...//handle the Help button...
  }
}