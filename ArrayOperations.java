/**
*@author Grace-lilie Acheampong
*@since March 26 2025 
*@class CSE 007
*@IDE Java, VS Code
*@Descr: This program implements various operations on an array of characters, including binary search, reversing, and case changing
*/

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class ArrayOperations{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        char [] chrs = new char[20];
        Random rand = new Random();
        for(int i =0; i<chrs.length ; i++){
            chrs[i] = (char)(rand.nextInt(123-97)+97);
        }
        
        boolean valid = true;
        while(valid){
            display();
            System.out.println("Enter a menu option");
            if(scan.hasNextInt()){
                int menu = scan.nextInt();
                //Using a switch case to produce required output
                switch(menu){
                    case 1:
                        System.out.print("Characters: ");
                        display(chrs);
                        break;
                    case 2:
                        reverse(chrs);
                        break;
                    case 3:
                        binarySearch(chrs);
                        break;
                    case 4:
                        changeCase(chrs);
                        break;
                    case 5: 
                        System.out.print("Goodbye");
                        valid = false; //Exit loop when 5 is entered
                        break;
                    default:
                        System.out.println("Invalid menu option try again");
                }
            }
            else{
                valid = false;// handle invalid scan
            }
        }

        scan.close();
    }
    /** 
    Displays a the menu options to the user including  Display Characters, Reverse Characters, Search Characters, Change Character Case, Exit 
    *@param None
    *@return None 
    */
    public static void display(){
        //Displaying menu options
        System.out.println("1. Display Characters\n2. Reverse Characters\n3. Search Characters\n4. Change Character Case\n5. Exit");
    } 

    /**
    Displays the letters provided including 
    *@param char [] An arry of letters  
    *@return None 
    */  
    public static void display(char[] chrs){
        for (char c : chrs ){ //using a for-each loop
            System.out.print(c +" ");
        }
        System.out.println();

    }
    /**
    Performs a binary search for a a group of letters through array of letters
    * @param char[]  An array of letters
    * @return: Nothing 
   */
    public static void binarySearch(char[] chrs){
        Arrays.sort(chrs);

        Random rand = new Random();
        char key = (char)(rand.nextInt(123-97)+97);
        System.out.println("Searching for "+ key);
        int high =chrs.length-1; 
        int low =0;
        int count =0;
        while(low <= high){
            int mid = (low+high)/2;
            count++;
            if (key == chrs[mid]){
                System.out.println("It took " + count+ " comparisons to determine..." );
                System.out.println( key+ " found at index =" + mid);
                break;
            }
            else if( key< chrs[mid]){
                high = mid-1;                
            }
            else{
                low = mid +1;
            }

        }
            System.out.println("Searching for "+ key);
            System.out.println("It took " + count+ " comparisons to determine..." );
            System.out.println(key + " NOT found");
        }

    /** Reverse the letters in the array letters
    * @param char[] An array of letters
    * @return Nothing
    * */  
    public static void reverse(char[] chrs) {
    int n = chrs.length;  // Get the length of the array
    for (int i = 0; i < n / 2; i++) {  // Loop only halfway through the array
        char temp = chrs[i];  // Store the current letter in a temporary variable
        chrs[i] = chrs[n - 1 - i];  // Swap the letter at position i with its mirror position
        chrs[n - 1 - i] = temp;  // Assign temp to the mirrored position
    }
}
    /** Changes the case of the letters in the array from one form to the other 
    * @param char[] An array of chrs
    * @return Nothing
    * */  
    public static void changeCase(char[]chrs){
        for(int i =0; i<chrs.length; i++){
            if(Character.isLowerCase(chrs[i])){
                chrs[i] = Character.toUpperCase(chrs[i]);
            }
            else{
                chrs[i] =Character.toLowerCase(chrs[i]);
            }
        }
    }
}
