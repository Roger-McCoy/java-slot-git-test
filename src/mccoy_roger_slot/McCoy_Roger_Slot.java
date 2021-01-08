package mccoy_roger_slot;

/**
 * Project Scope:
 * This project will demonstrate the use of JOptionPanes, if statements, accumulating variables, a do-while loop and a randomizer.
 * It will implement these things in a logical fashion to create a java slot machine.
 * After allowing the user to make wagers and battle the odds, the program allows them to then either play again or break the loop 
 * and cash out, displaying their total wagers and total winnings.
 *
 * Project/Assignment Title: Homework assignment 4, problem 22: Slot Machine Simulation
 * File Name: McCoy_Roger_Slot.java
 * Date Complied Last: 10/26/2018
 * Author: (Roger McCoy)
 * Complied in: NetBeans 8.2
 * Integrity Statement: By submitting this project, I am taking the integrity oath that I have not copied
 * any line(s) of code – partially or completely - from any other individual, former student work, textbook, online
 * resources, website, and any reference available anywhere.
 */
import javax.swing.JOptionPane;     // To take input and display dialogs.
import java.util.Random;            // To create randomizer for the slot machine.


public class McCoy_Roger_Slot 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        JOptionPane.showMessageDialog(null, "Welcome to this slot machine!");
        JOptionPane.showMessageDialog(null, "The rules are simple: You will enter an amount of money to wager and then be shown 3 out of 6 possible randomized words.");
        JOptionPane.showMessageDialog(null, "If 2 of the words match, then you'll double your wager. If all 3 match, then it's tripled! However, if none of the words match, then you'll win nothing..");
        
        double totalWagers;             // Accumulator.
        totalWagers = 0.0;              // Set accumulator to 0.
        double totalWinnings;           // Accumulator.
        totalWinnings = 0.0;            // Set accumulator to 0.
        
        int continuePlayingInput;
        boolean continuePlaying = true; // Flag to end loop.
        
        do
        {
            double wager = checkingAndParsingInput("Now then, enter the amount that you'd like to wager"); //Current wager.
            totalWagers = wager + totalWagers; // Adds the current wager to the original accumulator.
            
            Random randomNumber = new Random();
            
            JOptionPane.showMessageDialog(null, "Rolling the slots!");
            int slot1 = randomNumber.nextInt(6);
            int slot2 = randomNumber.nextInt(6);
            int slot3 = randomNumber.nextInt(6);
            String slot1Word = slotAssigner(slot1);
            String slot2Word = slotAssigner(slot2);
            String slot3Word = slotAssigner(slot3);
            
            JOptionPane.showMessageDialog(null, "Images of " + slot1Word + ", " + slot2Word + " and "
                    + slot3Word + " flash upon the screen!");
            
            double winnings; // Current winnings.
            if (slot1 == slot2 && slot1 == slot3) // == && is the "and" operator and || is the "or" operator. Useful for testing conditions.
            {
                winnings = wager*3;
                    totalWinnings = winnings + totalWinnings; //adds the current winnings to the original accumulator
                    JOptionPane.showMessageDialog(null, "Congratulations! You have three matches so your wager was tripled!");
                }else if (slot1 == slot2 || slot1 == slot3 || slot2 == slot3)
                {
                    winnings = wager*2;
                    totalWinnings = winnings + totalWinnings; //adds the current winnings to the original accumulator
                    JOptionPane.showMessageDialog(null, "Congratulations! You have two matches so your wager was doubled!");
                }else
                {
                    JOptionPane.showMessageDialog(null, "No matches.. Better luck next time!");
                }
                
            continuePlayingInput = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Continue?", JOptionPane.YES_NO_OPTION);
            if (continuePlayingInput == JOptionPane.YES_OPTION)
                {
                    continuePlaying = true;
                } else if (continuePlayingInput == JOptionPane.NO_OPTION)
                {
                    continuePlaying = false; 
                }  
        } while (continuePlaying == true);
        
        JOptionPane.showMessageDialog(null, String.format("You wagered $%,.2f" , totalWagers) + String.format(" this session "
                + "and your total winnings are $%,.2f" , totalWinnings) + "!");
    }
    
    public static double checkingAndParsingInput(String inputWindowText)
    {
        double numberToCheck = 0;
        int errorCheckFlag = -1;
        while (errorCheckFlag != 0)
        {
            try
            {
                numberToCheck = Double.parseDouble(JOptionPane.showInputDialog(null, inputWindowText));
                if (numberToCheck < 0)
                    throw new IllegalArgumentException("You must enter a positive number.");
                else
                    errorCheckFlag += 1;
            }
            catch (NumberFormatException nonDoubleValueError)
            {
                JOptionPane.showMessageDialog(null, "Your input must be a number. Try again.");
            }
            catch (IllegalArgumentException negativeSaleError)
            {
                JOptionPane.showMessageDialog(null, "Your input cannot be a negative number. Try again.");
            }
        }
        return numberToCheck;
    }
    
    public static String slotAssigner(int randomNumber)
    {
        String returnString = "";
        switch (randomNumber)
        {
            case 0:
                returnString = "Cherries";
                break;
            case 1:
                returnString = "Oranges";
                break;
            case 2:
                returnString = "Plums";
                break;
            case 3:
                returnString = "Bells";
                break;
            case 4:
                returnString = "Melons";
                break;
            case 5:
                returnString = "Bars";
                break;
        }
        return returnString;
    }  
}
