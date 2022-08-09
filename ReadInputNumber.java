// Add a java class by importing its package to use it in your program
import java.util.Scanner;

/* 
 * This Java program, demonstrates reading inputs from standard input
 * program reads each number and displays on standard output 
 * we will be using java.util.Scanner to read the input in this example, 
 * there are other ways too, which we can explore later
 * 
 * Your public class name and File name should be same for JAVA program to compile and run successfully
 */
public class ReadInputNumber {
    public static void main(String[] input) {
        // Instruct the user of the program how to use
        System.out.println("Enter two numbers of string to read!");

        // Read from STDIN
		// PARSE it into a variable
		// Consider each inpuut as a new number

		// initialize scanner to read from standard input 
		Scanner scanner = new Scanner(System.in);

		// Read the next input as number
		int num1 = scanner.nextInt();

        // Read one more line
		int num2 = scanner.nextInt();

		// When done reading expected number of inputs, close the scanner listening from input to avoid any memory leak or unexpected behavior of the program
		scanner.close();
		
        // Now display the inputs on standard output 
		System.out.println("Number 1 " + num1);
		System.out.println("Number 2 " + num2);
	}
}
