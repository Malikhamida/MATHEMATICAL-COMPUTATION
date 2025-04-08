/*
 *Name : مالك علي حميدة
 *ID : 120211140
 * and open the template in the editor.
 */
package fixedpointiteration;

/**
 *
 * @author Malik
 */
public class FixedPointIteration {

    // Interface for the function g(p)
    interface Function {

        double g(double p);
    }

    public static double fixedPoint(double p0, double TOL, int N0, Function g) {
        int i = 1;  // Step 1: Set i = 1

        while (i <= N0) {  // Step 2: While i ≤ N0
            double p = g.g(p0);  // Step 3: Compute p = g(p0)

            // Step 4: Check if |p - p0| < TOL
            if (Math.abs(p - p0) < TOL) {
                System.out.println("Approximate solution: " + p);
                System.out.println("Number of iterations: " + i);
                return p;  // Procedure successful
            }

            i++;  // Step 5: Increment i
            p0 = p;  // Step 6: Update p0
        }

        // Step 7: Method failed
        System.out.println("The method failed after N0 iterations, N0 = " + N0);
        return Double.NaN;  // Return NaN to indicate failure
    }

    // Example usage with a specific function
    public static void main(String[] args) {        
//        To use this with a different 
//        function, you would modify the function definition in the main method. 
//        For example, to solve x = e^(-x), you could change the function to:
//          Function g = (x) -> Math.exp(-x);


        // Example: solving x = cos(x)
        Function g = (x) -> Math.cos(x);

        double p0 = 0.5;    // Initial approximation
        double TOL = 1e-6;  // Tolerance
        int N0 = 100;       // Maximum iterations

        System.out.println("Fixed Point Iteration for g(x) = cos(x)");
        System.out.println("Initial approximation p0 = " + p0);
        System.out.println("Tolerance = " + TOL);
        System.out.println("Max iterations = " + N0);

        fixedPoint(p0, TOL, N0, g);
    }

}
