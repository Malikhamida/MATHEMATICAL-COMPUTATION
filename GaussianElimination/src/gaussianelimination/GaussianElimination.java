/*
 * Name: مالك علي حميدة
 * ID : 120211140
 * Java program to implement Algorithm 6.1 
(Gaussian Elimination with Backward Substitution) on page 364.
 */
package gaussianelimination;

/**
 *
 * @author Malik
 */
public class GaussianElimination {

    public static void solveLinearSystem(double[][] A, int n) {
        // Step 1: Elimination process
        for (int i = 0; i < n - 1; i++) {
            // Step 2: Find pivot
            int p = i;
            while (p < n && Math.abs(A[p][i]) < 1e-10) {
                p++;
            }

            // Check if no pivot found
            if (p >= n) {
                System.out.println("No unique solution exists");
                return;
            }

            // Step 3: Swap rows if necessary
            if (p != i) {
                for (int j = 0; j <= n; j++) {
                    double temp = A[i][j];
                    A[i][j] = A[p][j];
                    A[p][j] = temp;
                }
            }

            // Step 4: Elimination
            for (int j = i + 1; j < n; j++) {
                // Step 5: Calculate multiplier
                double mji = A[j][i] / A[i][i];

                // Step 6: Row operation
                for (int k = i; k <= n; k++) {
                    A[j][k] = A[j][k] - mji * A[i][k];
                }
            }
        }

        // Step 7: Check if system is solvable
        if (Math.abs(A[n - 1][n - 1]) < 1e-10) {
            System.out.println("No unique solution exists");
            return;
        }

        // Backward substitution
        double[] x = new double[n];

        // Step 8: Solve for xn
        x[n - 1] = A[n - 1][n] / A[n - 1][n - 1];

        // Step 9: Solve for remaining variables
        for (int i = n - 2; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (A[i][n] - sum) / A[i][i];
        }

        // Step 10: Output solution
        System.out.println("Solution:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.6f\n", i + 1, x[i]);
        }
    }

    public static void main(String[] args) {
        // Example usage
        // 2x1 + x2 - x3 = 5
        // x1 - 3x2 + 2x3 = -4
        // 3x1 + x2 - 2x3 = 3

        int n = 3;
        double[][] A = {
            {2, 1, -1, 5},
            {1, -3, 2, -4},
            {3, 1, -2, 3}
        };

        System.out.println("Augmented Matrix:");
        printMatrix(A, n);
        System.out.println("\nSolving the system...");
        solveLinearSystem(A, n);
    }

    // Helper method to print the matrix
    public static void printMatrix(double[][] A, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.printf("%8.3f", A[i][j]);
            }
            System.out.println();
        }
    }

}
