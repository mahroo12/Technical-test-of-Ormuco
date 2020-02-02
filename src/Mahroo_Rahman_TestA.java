import java.util.Scanner;

/*
 * Your goal for this question is to write a program
 * that accepts two lines (x1,x2) and (x3,x4) on the x-axis
 * and returns whether they overlap. 
 * As an example, (1,5) and (2,6) overlaps but not (1,5) and (6,8).
 */
public class Mahroo_Rahman_TestA {
	public static void main(String[] args) {
		
		// Creates a Scanner object that takes the first input which x1
		Scanner value1 = new Scanner(System.in); 
		System.out.println("enter x1");
		int x1 = value1.nextInt(); // Reads the user input

		// Creates a Scanner object that takes the first input which x2
		Scanner value2 = new Scanner(System.in); 
		System.out.println("enter x2");
		int x2 = value2.nextInt();// Reads the user input

		// Creates a Scanner object that takes the first input which x3
		Scanner value3 = new Scanner(System.in); 
		System.out.println("enter x3");
		int x3 = value3.nextInt();// Reads the user input

		// Creates a Scanner object that takes the first input which x4
		Scanner value4 = new Scanner(System.in); 
		System.out.println("enter x4");
		int x4 = value4.nextInt();// Reads the user input

		// we create an array of length such that it can hold the number from x1 to x2 inclusive
		int arr1[];
		arr1 = new int[x2 - x1 + 1];

		// we create an array of length such that it can hold the number from x3 to x4 inclusive
		int arr2[];
		arr2 = new int[x4 - x3 + 1];

		
		// we now store the numbers from x1 to x2 inclusive to create a kind of a number line
		for (int y = 0; y < arr1.length; y++) {
			arr1[y] = y + x1;
			System.out.println("the values in the array  arr1 are: " + arr1[y]);

		}

		System.out.println("\n");

		// we now store the numbers from x3 to x4 inclusive to create a kind of a number line
		for (int y = 0; y < arr2.length; y++) {
			arr2[y] = y + x3;
			System.out.println("the values in the array  arr2 are: " + arr2[y]);

		}

		
		// here we check if any numbers overlap in the number line. 
		// if there is an overlap we get a print on our screen indicating there is an overlap
		// this is on O(n^2) but we can check linearly using cases where x3<x2  etc. but this guarantees all cases
		// we could have also used a boolean function returning true if the lines overlapped or false if they didn't
		// but this is more interactive that is why I chose to display the results.
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] != arr2[j]) {
					j++;

				}

				else {
					System.out.println("The two lines overlap");
				}
			}

		}

	}
}
