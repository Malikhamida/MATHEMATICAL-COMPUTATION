/*
 * Name : مالك علي حميدة
 * id : 120211140
 * and open the template in the editor.
 */
package euclideanalgorithm;

import java.util.Scanner;

/**
 *
 * @author Malik
 */
public class EuclideanAlgorithm {

    public static int gcd(int a, int b) {
        // Ensure a is the smaller number
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        // Print the initial step
        System.out.print("gcd(" + a + "," + b + ")");

        int remainder = 1;
        // Apply Euclidean Algorithm: gcd(a, b) = gcd(a, b % a)
        while (remainder != 0) {
            remainder = b % a;
            b = a;
            a = remainder;

            // Print the intermediate steps
            if (a != 0) {
                System.out.print(" = gcd(" + b + "," + a + ")");
            }
        }

        // Print the final step when a becomes 0
        System.out.print(" = gcd(" + b + "," + a + ")");

        // When a becomes 0, b is the GCD
        System.out.println(" = " + b);
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two integers
        System.out.print("Enter the first integer (a): ");
        int a = scanner.nextInt();

        System.out.print("Enter the second integer (b): ");
        int b = scanner.nextInt();

        // Compute GCD
        int result = gcd(a, b);

        // Output the result
        System.out.println("The GCD of " + a + " and " + b + " is: " + result);

        scanner.close();

    }

}
