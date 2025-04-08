/*
 * Name : مالك علي حميدة
 * ID : 120211140
 * and open the template in the editor.
 */
package newtonsmethod;

/**
 *
 * @author Malik
 */
public class NewtonsMethod {

    // Define the function f(x) = x^2 - 2 as an example
    public static double f(double x) {
        return x * x - 2;
    }

    // Define the derivative f'(x) = 2x for the example function
    public static double fPrime(double x) {
        return 2 * x;
    }

    public static double newtonMethod(double p0, double TOL, int N0) {
        int i = 1;  // Step 1

        while (i <= N0) {  // Step 2
            // Step 3: Compute p using Newton's formula
            double p = p0 - f(p0) / fPrime(p0);

            // Step 4: Check if tolerance is met
            if (Math.abs(p - p0) < TOL) {
                System.out.println("Approximate solution found: " + p);
                return p;  // Procedure successful
            }

            // Step 5: Increment counter
            i++;

            // Step 6: Update p0
            p0 = p;
        }

        // Step 7: Method failed
        System.out.println("The method failed after N0 iterations, N0 = " + N0);
        return Double.NaN;  // Return NaN to indicate failure
    }

    public static void main(String[] args) {
        // Example usage
        double initialGuess = 1.0;    // p0
        double tolerance = 0.0001;    // TOL
        int maxIterations = 20;       // N0

        System.out.println("Starting Newton's Method with:");
        System.out.println("Initial approximation p0 = " + initialGuess);
        System.out.println("Tolerance TOL = " + tolerance);
        System.out.println("Maximum iterations N0 = " + maxIterations);

        double result = newtonMethod(initialGuess, tolerance, maxIterations);

        // Verify the result if successful
        if (!Double.isNaN(result)) {
            System.out.println("Verification: f(" + result + ") = " + f(result));
        }
    }

}
