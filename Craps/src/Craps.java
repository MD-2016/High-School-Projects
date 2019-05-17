/*
 * Program: Craps
 * Programmer: Jay
 * Date: Tuesday April 6th, 2010
 * Filename: Craps.java
 * Purpose: To play a game of craps. User clicks the roll button and message is displayed to the user stating the outcome of the roll.
 * Follows the rules of craps.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Craps  extends JApplet implements ActionListener{

 //variables for game status
 final int won = 0, lost = 0, Continue = 2;
 
 boolean firstRoll = true;
 int sumofDice = 0;
 int mypoint = 0;
 int gameStatus = Continue;
 
 //GUI compenets
 JLabel die1label, die2label, sumlabel, pointlabel;
 JTextField die1field, die2field, sumfield, pointfield;
 JButton roll, exit;
 
 public void init()
 {
  //label and field for die 1
  Container c = getContentPane();
  c.setLayout(new FlowLayout());
  die1label = new JLabel( "Die 1" );
  c.add(die1label);
  die1field = new JTextField (10);
  die1field.setEditable(false);
  c.add(die1field);
  
  //label and field for die 2
  die2label = new JLabel("Die 2");
  c.add(die2label);
  die2field = new JTextField(10);
  die2field.setEditable(false);
  c.add(die2field);
  
  //label and field for sum
  sumlabel = new JLabel("Sum is");
  c.add(sumlabel);
  sumfield = new JTextField(10);
  sumfield.setEditable(false);
  c.add(sumfield);
  
  //label and field for point
  pointlabel = new JLabel("Point is");
  c.add(pointlabel);
  pointfield = new JTextField(10);
  pointfield.setEditable(false);
  c.add(pointfield);
  
  //button
  roll = new JButton("Roll Dice");
  roll.addActionListener(this);
  roll.setActionCommand("Roll Dice");
  c.add(roll);
  exit = new JButton("Exit");
  exit.addActionListener(this);
  exit.setActionCommand("Exit");
  c.add(exit);
 }
 public void actionPerformed(ActionEvent e)
 {
  String arg = e.getActionCommand();
  if(arg == "Roll Dice")
  {
  sumofDice = rollDice();
  
  if(firstRoll)
  {
   switch(sumofDice)
   {
   case 7:
   case 11:
    gameStatus = won;
    pointfield.setText("");
    break;
   case 2:
   case 3:
   case 12:
           gameStatus = lost;
           pointfield.setText("");
           break;
           
        default:
         gameStatus = Continue;
         mypoint = sumofDice;
         pointfield.setText(Integer.toString(mypoint));
         firstRoll = false;
         break;
   }
  }
  else
  {
   if(sumofDice == mypoint)
    gameStatus = won;
   else
    if(sumofDice == 7)
     gameStatus = lost;
  }
  displayMessage();
  }
  if(arg == "Exit")
  {
   System.exit(0);
  }
 }
 public int rollDice()
 {
  int die1 = 1 + (int) (Math.random() * 6);
  int die2 = 1 + (int) (Math.random() * 6);
  int sum = die1 + die2;
  
  die1field.setText(Integer.toString(die1));
  die2field.setText(Integer.toString(die2));
  sumfield.setText(Integer.toString(sum));
  
  return sum;
 }
 public void displayMessage()
 {
  if(gameStatus == Continue)
   showStatus("Roll Again");
  else
  {
   if(gameStatus == won)
    showStatus("Player wins. Click Roll Dice to play again");
   else
    showStatus("Player loses. Click Roll Dice to play again");
   
   firstRoll = true;
  }
 }
}
