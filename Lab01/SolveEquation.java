import javax.swing.JOptionPane;
public class SolveEquation {
 public static void main(String[] args){
  String choose = JOptionPane.showInputDialog(null, "Which equation do you want to solve: \n1. The first-degree equation (linear equation) with one variable \n2. The system of first-degree equations (linear system) with two variables \n3. The second-degree equation with one variable", "Solve", JOptionPane.INFORMATION_MESSAGE);
  String msg = "";
  int type = Integer.parseInt(choose);
  if (type == 1) {
	String stra, strb;
	stra = JOptionPane.showInputDialog(null, "Please input a: ", "ax + b = 0", JOptionPane.INFORMATION_MESSAGE);
  
  	strb = JOptionPane.showInputDialog(null, "Please input b: ", "ax + b = 0", JOptionPane.INFORMATION_MESSAGE);
	double a = Double.parseDouble(stra);
  	double b = Double.parseDouble(strb);
	double x = 0;
	if (a == 0) { 
		if (b == 0) { msg += "The equation has infinitely many solutions";}
		else {  msg += "The equation has no solution";} 
			}
	else { x = -b / a;
		 msg += "x = " + x;}
 				}
  else if (type == 2) {
	String stra11, stra12, stra21, strb1, stra22, strb2;
	stra11 = JOptionPane.showInputDialog(null, "Please input a11: ", "a11x1 + a12x2 = b1", JOptionPane.INFORMATION_MESSAGE);
  
  	stra12 = JOptionPane.showInputDialog(null, "Please input a12: ", "a11x1 + a12x2 = b1", JOptionPane.INFORMATION_MESSAGE);
	
	strb1 = JOptionPane.showInputDialog(null, "Please input b1: ", "a11x1 + a12x2 = b1", JOptionPane.INFORMATION_MESSAGE);
	
	stra21 = JOptionPane.showInputDialog(null, "Please input a21: ", "a21x1 + a22x2 = b2", JOptionPane.INFORMATION_MESSAGE);
  
  	stra22 = JOptionPane.showInputDialog(null, "Please input a22: ", "a21x1 + a22x2 = b2", JOptionPane.INFORMATION_MESSAGE);
	
	strb2 = JOptionPane.showInputDialog(null, "Please input b2: ", "a21x1 + a22x2 = b2", JOptionPane.INFORMATION_MESSAGE);

	double a11 = Double.parseDouble(stra11);
  	double a12 = Double.parseDouble(stra12);
	double b1 = Double.parseDouble(strb1);
  	double a21 = Double.parseDouble(stra21);
	double a22 = Double.parseDouble(stra22);
  	double b2 = Double.parseDouble(strb2);
	double d = a11*a22 - a21*a12;
	double d1 = b1*a22 - b2*a12;
	double d2 = a11*b2 - a21*b1;
	double x1, x2;
	if (d == d1 && d1 == d2 && d == 0) {
		msg += "The equation has infinitely many solutions";}
	else if ( d == 0 && d1 != 0 || d2 != 0) { 
		msg += "The equation has no solution"; }
	else {
		x1 = d1 / d;
		x2 = d2 / d;
		msg += "The equation has 1 solution: \n" + "x1 = " + x1 + "\nx2 = " + x2; }
				   }

  else if (type == 3) {
	String stra, strb, strc;
	stra = JOptionPane.showInputDialog(null, "Please input a: ", "ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
  
  	strb = JOptionPane.showInputDialog(null, "Please input b: ", "ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
	
	strc = JOptionPane.showInputDialog(null, "Please input c: ", "ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);

	double a = Double.parseDouble(stra);
  	double b = Double.parseDouble(strb); 
	double c = Double.parseDouble(strc);
	double x = 0;
	double x1 = 0;
	if (a == 0) { 
		if (b == 0) { 
			if (c == 0) { msg += "The equation has infinitely many solutions";}
			else {  msg += "The equation has no solution";} 
				}
		else { x = -c / b;
		 msg += "x = " + x;}
 				}
	else {
		double delta = b*b - 4*a*c;
		if (delta < 0) { msg += "The equation has no solution";}
		else if (delta == 0) {x = ( -b + Math.sqrt(delta))/(2*a);
					   msg += "	The equation has 2 solutions: x1 = x2 = " + x;}
		else { x = ( -b + Math.sqrt(delta))/(2*a);
			 x1 = ( -b - Math.sqrt(delta))/(2*a);
			 msg += "The equation has 2 solutions: \n" + "x1 = " + x + "\nx2 = " + x1; }
 				}
 					}

  JOptionPane.showMessageDialog(null, msg, "Show results", JOptionPane.INFORMATION_MESSAGE);
  System.exit(0);
 }
}