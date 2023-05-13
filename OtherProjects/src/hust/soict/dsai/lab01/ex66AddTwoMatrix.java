package hust.soict.dsai.lab01;

public class ex66AddTwoMatrix {

	public static void main(String args[]) {
		// TODO Auto-generated constructor stub
		int a[][] = { { 1, 2, 3 }, { 3, 4, 5 } };
        int b[][] = { { 4, 5, 6 }, { 5, 6, 7 } };
        int res[][] = new int[2][3];
        System.out.print("First matrix:\n");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                res[i][j] = a[i][j] + b[i][j];
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("Second matrix: \n"); 
        for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    res[i][j] = a[i][j] + b[i][j];
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
        }
        System.out.print("Result: \n");         
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                res[i][j] = a[i][j] + b[i][j];
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
	}
}
