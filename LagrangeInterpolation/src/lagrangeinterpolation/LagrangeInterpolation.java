/*
 * Name:مالك علي حميدة
 * ID:120211140
 * and open the template in the editor.
 */
package lagrangeinterpolation;

/**
 *
 * @author Malik
 */
public class LagrangeInterpolation {

    // Data points
    static double[] years = {1950, 1960, 1970, 1980, 1990, 2000};
    static double[] population = {151326, 179323, 203302, 226542, 249633, 281422}; // in thousands

    public static void main(String[] args) {
        double[] evalPoints = {1940, 1975, 2020};

        // Calculate and evaluate polynomials of degree 1, 2, and 3
        for (int degree = 1; degree <= 3; degree++) {
            System.out.println("\nDegree " + degree + " Polynomial:");
            for (double x : evalPoints) {
                double result = lagrangeInterpolation(x, degree);
                System.out.printf("P%d(%.0f) = %.2f thousand%n", degree, x, result);
            }
        }
    }

    public static double lagrangeInterpolation(double x, int degree) {
        double result = 0;

        int n = degree + 1; // number of points to use
        // Use first n points from the data
        for (int i = 0; i < n; i++) {
            double term = population[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term *= (x - years[j]) / (years[i] - years[j]);
                }
            }
            result += term;
        }
        return result;
    }

}
