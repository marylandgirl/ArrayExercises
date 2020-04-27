import java.util.Scanner;
import java.util.Arrays;
/* This class was created for an assignment given at Java Bootcamp
*  It provides different scenarios for practice in working with arrays
*   Kim Levin
*   4/24/2020
*/
public class ArrayExercises {
   public static void main(String[] args) {

      Scanner keyboard = new Scanner(System.in);
      System.out.println("Displaying a string value in reverse.");
      reverseString(keyboard);

      System.out.println("Removing duplicates from a 10 integer array.");
      removeDuplicates(keyboard);
      System.out.println();

      System.out.println("Printing array elements that add up to 13.");
      String rptStr = sumArrays();
      System.out.println(rptStr);

      System.out.println("Counting even & odd numbers out of 10.");
      countOddEven(keyboard);

      System.out.print("Counting characters in words ");
      System.out.println("from one line string entered by user.");
      countWordChars(keyboard);
   }

   //This method displays a string entered by the user in reverse
   static void reverseString(Scanner keyIn) {

      //Declare & Initialize variables
      String inputString = "";
      char[] tempChars;
      int lastIndex;
      String reverseString;
      char character;

      //Prompt user to enter a string
      System.out.print("Please enter a string to reverse: ");
      inputString = keyIn.next();
      keyIn.nextLine();
      tempChars = new char[inputString.length()];
      
      lastIndex = inputString.length() - 1;
      for (int i = lastIndex; i >= 0; i--) {
         character = inputString.charAt(i);
         tempChars[lastIndex - i] = character;
      }
      reverseString = new String(tempChars);
      System.out.println(reverseString);
   }

   //This method prompts user for 10 integers and stores them
   //   in an array. If there are any duplicates, it removes them
   static void removeDuplicates(Scanner keyIn) {

      //Declare & Initialize variables
      int[] numberArray = new int[10];
      int[] tempArray = new int[10];
      int idxVal = 0;
      boolean done = false;
      int counter = 0;

      //Add user inputted integers to an array
      do{
         System.out.print("Enter up to 10 integers ");
         System.out.println("and include duplicates ");
         String inputString = keyIn.nextLine();
         Scanner inStr = new Scanner(inputString);
         while(inStr.hasNextInt()) {
         // System.out.println(inStr.nextInt());
            numberArray[idxVal] = inStr.nextInt();
            counter++;
            idxVal++;
         }
         if (idxVal >= 9) {
            done = true;
         } else {
            System.out.println(Arrays.toString(numberArray));
            System.out.println((10 - counter) + " more integers needed.");
         }
      } while(!done);
      System.out.print("These are the numbers in the array before ");
      System.out.print("removing duplicates. ");
      System.out.println(Arrays.toString(numberArray));
      Arrays.sort(numberArray);
      counter = 0;
      for (int i = 0; i < 9; i++) { 
         if (numberArray[i] != numberArray[i+1]) {
            tempArray[counter] = numberArray[i];
            counter++;
         }
      }
      tempArray[counter] = numberArray[numberArray.length - 1];
      for (int i = 0; i < tempArray.length; i++) {
         if (tempArray[i] != 0){
            System.out.print(tempArray[i] + " ");
         } else {
            if (tempArray[i] == 0 && i == 0) {
               System.out.print(tempArray[i] + " ");
            }
         }
      }
//    System.out.println(Arrays.toString(tempArray));
   }

   //This method displays only those elements of 2 arrays that
   //   add up to 13
   static String sumArrays() {

      //Initialize variables
      int[] array1 = {1,7,6,5,9};
      int[] array2 = {2,7,6,3,4};
      String retStr = "";

      //Loop throught the arrays to find elements that add
      //   up to 13
      
      for (int i = 0; i < array1.length; i++) {
         for (int j = 0; j < array2.length; j++) {
            if ( array1[i] + array2[j] == 13) {
               if (!retStr.contains("," + array1[i])) {
                  retStr = retStr.concat("(");
                  retStr = retStr.concat(Integer.toString(array1[i]));
                  retStr = retStr.concat(",");
                  retStr = retStr.concat(Integer.toString(array2[j]));
                  retStr = retStr.concat(")");
                  retStr = retStr.concat("\n");
               }
            }
         }
      }
      return retStr;
   }

   //This method displays a string entered by the user in reverse
   static void countOddEven(Scanner keyIn) {

      //Initialize variables
      int[] numArray = new int[10];
      int intCount = 0;
      int evenCount = 0;
      int oddCount = 0;
      int intsLeft = 0;
      boolean done = false;
      String inputString = "";
      int enteredInt;

      //Prompt user to enter a string
      do {
         System.out.print("Please enter up to 10 integers: ");
         inputString = keyIn.nextLine();
         Scanner inStr = new Scanner(inputString);
         while(inStr.hasNext()) {
            enteredInt = Integer.parseInt(inStr.next());
            numArray[intCount] = enteredInt;
            intCount++;
            if (enteredInt%2 == 0) {
               evenCount++;
            } else {
               oddCount++;
            }
         }
         intsLeft = 10 - intCount;
         if (intsLeft == 0) {
            done = true;
         } else {
            done = false;
            
         }
         System.out.println(Arrays.toString(numArray));
         System.out.println(intsLeft + " more integers needed.");
      } while(!done);
      System.out.print("The number of even integers ");
      System.out.printf("out of the 10 is %d\n",evenCount);
      System.out.print("The number of odd integers ");
      System.out.printf("out of the 10 is %d\n",oddCount);
   }

   //This method displays a string entered by the user in reverse
   static void countWordChars(Scanner keyIn) {

      //Declare & Initialize variables
      String final_str = "";
      String[] word_array;
      int word_count = 0;
      int[] character_count;

      //Prompt user to enter a one line string
      System.out.print("Enter a string ");
      System.out.println("(max number of characters is 132)");
      final_str = keyIn.nextLine();
      if (final_str.length() > 132) {
         final_str = final_str.substring(0,132);
      }
      Scanner inputString = new Scanner(final_str);
      do {
         inputString.next();
         word_count++;
      }while (inputString.hasNext());

      word_array = new String[word_count];
      character_count = new int[word_count];

      inputString = new Scanner(final_str);
      String word = "";
      for (int i = 0; i < word_count; i++) {
         word = inputString.next();
         word_array[i] = word;
         character_count[i] = word.length();
      }
      System.out.printf("You entered: %s\n",final_str);
      for (int j = 0; j < word_count; j++) {
//       System.out.printf("%s\n",word_array[j],character_count[j]);
         System.out.printf("%s has ",word_array[j]);
         System.out.printf("%d characters\n",character_count[j]);
      }
   }
}
