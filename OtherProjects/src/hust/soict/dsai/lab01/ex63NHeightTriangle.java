package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public class ex63NHeightTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		String strn;
		String strmsg = "\n";

		strn = JOptionPane.showInputDialog(null, "Please input n: ", "n_height_triangle", JOptionPane.INFORMATION_MESSAGE);
		int n = Integer.parseInt(strn);
		for (int i = 1; i <= n; i++) {
			for (int k = 1; k <= n - i; k++) {
				strmsg += " ";
			}
			for (int h = 1; h <= 1 + (i-1)*2; h++) {
				strmsg += "*";
				
			}
			strmsg += "\n";
			
		}
		JOptionPane.showMessageDialog(null, strmsg, "Show results", JOptionPane.INFORMATION_MESSAGE);
		  System.exit(0);
	}

}
