/*
 * Name:مالك علي حميدة.
 * ID:120211140
 * and open the template in the editor.
 */
package bisectionmethod;

/**
 *
 * @author Malik
 */
public class BisectionMethod {

    // Interface for the function f(x)
    interface Function {

        double apply(double x);
    }

    public static double bisection(Function f, double a, double b, double tol, int maxIterations) {
        // Step 1: Initialize variables
        int i = 1;
        double FA = f.apply(a);

        // Step 2: Main iteration loop
        while (i <= maxIterations) {
            // Step 3: Calculate midpoint and function value
            double p = a + (b - a) / 2;
            double FP = f.apply(p);

            // Step 4: Check for convergence
            if (FP == 0 || (b - a) / 2 < tol) {
                System.out.println("Procedure completed successfully.");
                return p;
            }

            // Step 5: Increment counter
            i++;

            // Step 6: Update interval
            if (FA * FP > 0) {
                a = p;
                FA = FP;
            } else {
                b = p;
            }
        }

        // Step 7: Method failed
        System.out.println("Method failed after N0 iterations, N0 = " + maxIterations);
        return Double.NaN; // Return NaN to indicate failure
    }

    /**
     * @param args the command line arguments
     */
    // Example usage
    public static void main(String[] args) {
        // Example function: f(x) = x^2 - 4
        Function f = x -> x * x - 4;

        double a = 1.0;           // Left endpoint
        double b = 3.0;           // Right endpoint
        double tol = 0.0001;      // Tolerance
        int maxIterations = 100;  // Maximum number of iterations

        // Verify that f(a) and f(b) have opposite signs
        if (f.apply(a) * f.apply(b) >= 0) {
            System.out.println("Error: f(a) and f(b) must have opposite signs");
            return;
        }

        double result = bisection(f, a, b, tol, maxIterations);
        if (!Double.isNaN(result)) {
            System.out.printf("Approximate solution: %.6f%n", result);
            System.out.printf("Function value at solution: %.6f%n", f.apply(result));
        }

    }

}
