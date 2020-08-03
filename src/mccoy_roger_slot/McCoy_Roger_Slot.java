package mccoy_roger_slot;

/**
Project Scope:
This project will demonstrate the use of JOptionPanes, if statements, accumulating variables, a do-while loop and a randomizer.
It will implement these things in a logical fashion to create a java slot machine.
After allowing the user to make wagers and battle the odds, the program allows them to then either play again or break the loop and cash out, displaying their total wagers and total winnings.

Project/Assignment Title: Homework assignment 4, problem 22: Slot Machine Simulation
File Name: McCoy_Roger_Slot.java
Date Complied Last: 10/26/2018
Author: (Roger McCoy)
Complied in: NetBeans 8.2
Integrity Statement: By submitting this project, I am taking the integrity oath that I have not copied
any line(s) of code – partially or completely - from any other individual, former student work, textbook, online
resources, website, and any reference available anywhere.
*/
import javax.swing.JOptionPane;   //to take input and display dialogs
import java.util.Random;    //to create randomizer for our slot machine


public class McCoy_Roger_Slot 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        JOptionPane.showMessageDialog(null, "Welcome to this Java Slot Machine!");
        JOptionPane.showMessageDialog(null, "The rules are simple: You will enter an amount of money to wager and then be shown 3 out of 6 possible randomized words.");
        JOptionPane.showMessageDialog(null, "If 2 of the words match, then you'll double your wager. If all 3 match, then it's tripled! However, if none of the words match, then you'll win nothing..");
        
        double totalWagers; //accumulator
        totalWagers = 0.0;  //set accumulator to 0
        double totalWinnings; //accumulator
        totalWinnings = 0.0;    //set accumulator to 0
        
        int continuePlayingInput;
        boolean continuePlaying;
        
        do
            {
                
                double wager; //current wager
                wager = Double.parseDouble(JOptionPane.showInputDialog("Now then, enter the amount that you'd like to wager"));
                totalWagers = wager + totalWagers; //adds the current wager to the original accumulator
                
                // Cherries, Oranges, Plums, Bells, Melons, Bars will be 0, 1, 2, 3, 4, and 5 respectively
                // Use if statements and , == to see if variables match
                Random randomNumbers = new Random();
                String slot1Word = ("");
                String slot2Word = ("");
                String slot3Word = ("");
                int slot1;
                int slot2;
                int slot3;
                JOptionPane.showMessageDialog(null, "Rolling the slots!");
                slot1 = randomNumbers.nextInt(6);
                if (slot1 == 0)  // This long if statement is to associate the random numbers with the slot machine words.
                    {
                        slot1Word = "Cherries";
                    }else if (slot1 == 1)
                    {
                        slot1Word = "Oranges";
                    }else if (slot1 == 2)
                    {
                        slot1Word = "Plums";
                    }else if (slot1 == 3)
                    {
                        slot1Word = "Bells";
                    }else if (slot1 == 4)
                    {
                        slot1Word = "Melons";
                    }else if (slot1 == 5)
                    {
                        slot1Word = "Bars";
                    }
                slot2 = randomNumbers.nextInt(6);
                if (slot2 == 0)  // This long if statement is to associate the random numbers with the slot machine words.
                    {
                        slot2Word = "Cherries";
                    }else if (slot2 == 1)
                    {
                        slot2Word = "Oranges";
                    }else if (slot2 == 2)
                    {
                        slot2Word = "Plums";
                    }else if (slot2 == 3)
                    {
                        slot2Word = "Bells";
                    }else if (slot2 == 4)
                    {
                        slot2Word = "Melons";
                    }else if (slot2 == 5)
                    {
                        slot2Word = "Bars";
                    }
                slot3 = randomNumbers.nextInt(6);
                if (slot3 == 0)  // This long if statement is to associate the random numbers with the slot machine words.
                    {
                        slot3Word = "Cherries";
                    }else if (slot3 == 1)
                    {
                        slot3Word = "Oranges";
                    }else if (slot3 == 2)
                    {
                        slot3Word = "Plums";
                    }else if (slot3 == 3)
                    {
                        slot3Word = "Bells";
                    }else if (slot3 == 4)
                    {
                        slot3Word = "Melons";
                    }else if (slot3 == 5)
                    {
                        slot3Word = "Bars";
                    }
                
                JOptionPane.showMessageDialog(null, "Images of " + slot1Word + ", " + slot2Word + " and " + slot3Word + " flash upon the screen!");
                double winnings; //current winnings
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
                        break; //this is apparently a cheap way to break the loop
                    }
            } while (continuePlaying = true);
        
        JOptionPane.showMessageDialog(null, String.format("You wagered $%,.2f" , totalWagers) + String.format(" this session and your total winnings are $%,.2f" , totalWinnings) + "!");
    }
}
