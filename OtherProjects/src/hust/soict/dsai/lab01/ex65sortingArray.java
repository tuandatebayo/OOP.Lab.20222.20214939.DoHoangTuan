package hust.soict.dsai.lab01;
import java.util.Arrays;

public class ex65sortingArray {

	public static void main(String args[]) {
		// TODO Auto-generated constructor stub
		int[] array = {5, 3, 9, 1, 7, 2, 8, 4, 6};
		System.out.println("Initial array: " + Arrays.toString(array));
		Arrays.sort(array);
		System.out.println("Sorted array: " + Arrays.toString(array));
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
		System.out.println("Sum of all elements: " + sum);
		double avg = sum / array.length;
		System.out.println("Average value: " + avg);
	}

}
