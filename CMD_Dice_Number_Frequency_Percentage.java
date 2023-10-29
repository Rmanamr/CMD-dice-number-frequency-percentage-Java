import java.util.Arrays;
import java.util.Scanner;

/**Java CMD program for printing the frequency and percentage of each dice number after x dice rolls.
* using Java version 1.8.0
* @version : 1.0
* @license: MIT License
* @author : Arman Azarnik
* contact me at : armanazarnik@gmail.com
*/
public class CMD_Dice_Number_Frequency_Percentage{

    /** main class for interacting with the user */
    public static void main(String args []){

        /** while loop to keep the program running */
        while(true){
            System.out.println("Please enter the number of dice rolls :");
            Scanner input = new Scanner(System.in);

            /** reading the next integer number and storing it in number_Of_Dice_Rolls integer variable */
            int number_Of_Dice_Rolls = input.nextInt();

            /** passing the number_Of_Dice_Rolls to dice_Roll_Frequency_Calculator method and storig the result in dice_Roll_Frequency array of integers variable */
            int[] dice_Number_Frequency = dice_Number_Frequency_Calculator(number_Of_Dice_Rolls);

            /** passing the dice_Roll_Frequency to array_Element_Percentage_Calculator method and storig the result in dice_Rolls_Percentage array of doubles variable */
            double[] dice_Rolls_Percentage = array_Element_Percentage_Calculator(dice_Number_Frequency);
            System.out.println("Your dice number frequency after " +number_Of_Dice_Rolls+ " dice rolls :");
            System.out.println(Arrays.toString(dice_Number_Frequency));
            System.out.println();
            System.out.println("Your dice number percentage after " +number_Of_Dice_Rolls+ " dice rolls :");
            System.out.println(Arrays.toString(dice_Rolls_Percentage));
            System.out.println("*******************************************************************************************************"); 
        }
    }  

    /** 
     * method for rolling a dice and get the dice number.
     * @return  dice number after dice roll
     * <pre>
     *      roll_Dice(); // Output: 1
     *      roll_Dice(); // Output: 5
     * </pre>
    */
    public static int roll_Dice(){
    /** generating a random integer number between 1 and 6 for each dice roll */
    int dice_Number = (int)Math.floor(Math.random()*6) + 1;
    return dice_Number;
    } 

    /** 
     * method for rolling a dice and get the dice number frequency after x dice rolls.
     * @param number_Of_Dice_Rolls  number of dice rolls
     * @return dice_Numbers_Frequency  frequency of each dice number after x dice rolls
     * <pre>
     *      dice_Number_Frequency_Calculator(); // Output: 1
     *      dice_Number_Frequency_Calculator(); // Output: 5
     * </pre>
    */
    public static int[] dice_Number_Frequency_Calculator(int number_Of_Dice_Rolls){
        int [] dice_Numbers_Frequency = new int[6];
        for(int i = 1; i<=number_Of_Dice_Rolls; i++){

            /** calling roll_Dice method in each iteration to generate a dice number and storing the result in dice_Roll_Number variable */
            int dice_Roll_Number = roll_Dice();
            switch(dice_Roll_Number){
                case 1:
                    dice_Numbers_Frequency[0]++;
                    break;
                case 2:
                    dice_Numbers_Frequency[1]++;
                    break;
                case 3:
                    dice_Numbers_Frequency[2]++;
                    break;
                case 4:
                    dice_Numbers_Frequency[3]++;
                    break;
                case 5:
                    dice_Numbers_Frequency[4]++;
                    break;
                case 6:
                    dice_Numbers_Frequency[5]++;
                    break;
            }
        }
        return dice_Numbers_Frequency;
    }
    
    /** 
     * method for calculating the percentage of each array element.
     * @param array  array of integer elements
     * @return  array_Element_Percentage  percentage of each element in array
     * <pre>
     *      int [] array_1 = [];
     *      int [] array_2 = [1, 5, 10, 4];
     *      array_Element_Percentage_Calculator(array_1); // Output: []
     *      array_Element_Percentage_Calculator(array_2); // Output: [0.05, 0.25, 0.5, 0.2]
     * </pre>
    */
    public static double[] array_Element_Percentage_Calculator(int[] array){
        double [] array_Element_Percentage = new double[array.length];
        int sum_Of_Array_Elements = 0;
        /** loop for counting the total number of all elements */
        for(int i=0; i<array.length; i++){
            sum_Of_Array_Elements += array[i];
        }
        for(int i=0; i<array.length; i++){
            /** setting the array percentage element to 0.0 if the element was empty to avoid division by 0 and NaN types */
            if(array[i] == 0){
                array_Element_Percentage[i] = 0.0;
                continue;
            }
            array_Element_Percentage[i] = Double.valueOf(array[i]) / sum_Of_Array_Elements;
        }
        return array_Element_Percentage ;
    } 
} 