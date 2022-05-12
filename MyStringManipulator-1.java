//Ksusha Gotham 

import java.util.Scanner;
   
public class MyStringManipulator{
   public static void main(String []args){
      //declaring filler variables and scanner
      Scanner scan = new Scanner(System.in);
      String inputString = "";
      String inputCommand = "";
      String reverse = "";
      
      System.out.println("Enter the string to be manipulated");
      inputString = scan.nextLine();
      
      System.out.println("Enter your command (quit, print reverse, replace all, replace single, remove)");
      inputCommand = scan.nextLine();
      
      while (!inputCommand.toLowerCase().equals("quit")){
         switch (inputCommand.toLowerCase()){ //using a switch case for every scenario if user input
               case "print reverse":
                  //printReverse(inputString);
                  printReverse(inputString);
                  break;
               case "replace all":
                  System.out.println("Enter the character to replace: ");
                  char oldChar = scan.nextLine().charAt(0);
                  System.out.println("Enter the new character: ");
                  char newChar = scan.nextLine().charAt(0);
                  replaceAll(inputString, oldChar, newChar);
                  break;
               case "remove":
                  System.out.println("Enter the character to remove: ");
                  char remChar = scan.nextLine().charAt(0);
                  remove(inputString, remChar);
                  break;
               case "replace single":
                  System.out.println("Enter the character to replace: ");
                  char oldChar2 = scan.nextLine().charAt(0);
                  System.out.println("Enter the new character: ");
                  char newChar2 = scan.nextLine().charAt(0);
                  replaceSingle(inputString, oldChar2, newChar2);
                  break;

         }
      //ask for input again to update inputCommand and see if the user wants to quit  
      System.out.println("Enter your command (quit, print reverse, replace all, replace single, remove)");
      inputCommand = scan.nextLine();
      }
   }
   
   public static void printReverse(String inputString){
      String reverseString = "";
      //for loop that takes the letters from the back and out it into reverseString
      for(int i =inputString.length()-1; i>=0; i--){
         reverseString = reverseString + inputString.charAt(i);
      }
      System.out.println("Your new sentence is: "+reverseString+"!");
   }
   
   public static String replaceAll(String inputString, char oldChar, char newChar) {
      //new arrat ch that takes the input string as a character array
      char[] ch = inputString.toCharArray();
      //boolean for documenting if character exists in the input or not
      boolean change = false;
      for(int i = ch.length-1; i>=0; i--){
         if(ch[i] == oldChar){
           ch[i] = newChar;
           change = true;
         }
      } 
      
      String str = new String(ch);
      //if else statement to alert the user if the character doesn't exist in the input
      if(change){
         System.out.println("Your new sentence is: " + str +"!");
      }else {
         System.out.println("Error: The string does not contain the given character.");
      }
      
      
      return str;
      
   }
   
   public static String remove(String str, char rem){
        int change = 0;
        char[] ch = str.toCharArray();
        //checking all characters in array but the last one
        for(int i =0; i < ch.length-1; i++){
            if(ch[i] == rem){
                for(int x = i; x < ch.length-1; x++){
                    ch[x] = ch[x + 1];
                }
                change += 1;
                i -= 1;
            }
        }
        //checking last character
        if(ch[ch.length-1] == rem){
            change += 1;
        }

        char[] red = new char[ch.length - change];
        for(int y = 0; y < red.length; y++){
            red[y] = ch[y];
        }
        String ret = new String(red);
        //testing to see if string contains the given character
        if(change>=1){
         System.out.println("Your new sentence is: " + ret +"!");
        }else {
         System.out.println("Error: The string does not contain the given character.");
        }

        
        return ret;
    } 
    
       
   public static String replaceSingle(String inputString, char oldChar, char newChar) {
      //same thing as replace all except the early return happens at the first instance of the replacement character
      char[] ch = inputString.toCharArray();
      for(int i = 0; i<ch.length; i++){
         if(ch[i] == oldChar){
           ch[i] = newChar;
           String str = new String(ch);
           System.out.println("Your new sentence is: " + str +"!");
           return str;
         }
      }
      String str = new String(ch);
      return str;
      
   }
  
  
}