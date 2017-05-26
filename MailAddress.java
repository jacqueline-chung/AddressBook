import java.io.*;
 public class MailAddress{
 public static void main(String args[]){
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  String name="";
  
  try{
   System.out.println("Please enter your Home Address: ");
   name=br.readLine();
//  String addressToken="[\\p{Punct}&&[#,.()-]]+\\d*+\\s?+[\\p{Alpha}+\\s?]*";
  //#45 Australia St.Addition Hills, Binan, Laguna
   String addressToken="[\\d*+\\s?+[\\p{Alpha}+\\s?]*
  String addressPattern="("+addressToken+"){1,10}";
  
  if(name.matches(addressPattern))
   System.out.println("You entered a VALID Home Address format.");
  else
   System.out.println("You entered an INVALID Home Address format.");
  }

  catch(Exception e){
  e.printStackTrace();
  }
  
    

 }//end of main
}//end of class

