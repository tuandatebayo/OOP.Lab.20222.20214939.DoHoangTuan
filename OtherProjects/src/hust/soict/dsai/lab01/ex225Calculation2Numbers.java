package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;
public class ex225Calculation2Numbers {
 public static void main(String[] args){
  String strNum1, strNum2;
  String strNotification = "You've just entered: ";
  strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
  strNotification += strNum1 + " and ";
  strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
  strNotification += strNum2;
  double num1 = Double.parseDouble(strNum1);
  double num2 = Double.parseDouble(strNum2);
  double sum = num1 + num2;
  double diff = num1 - num2;
  double product = num1 * num2;
  double quotient = 0;
  strNotification += "\nSum: " + sum;
  strNotification += "\nDifferent: " + diff;
  strNotification += "\nProduct: " + product;
  if (num2 == 0) {
   strNotification += "\nQuotient: Can't divide number 0";}
  else {
   quotient = num1 / num2;
   strNotification += "\nQuotient: " + quotient;} 
  
  JOptionPane.showMessageDialog(null, strNotification, "Show results", JOptionPane.INFORMATION_MESSAGE);
  System.exit(0);
 }
}