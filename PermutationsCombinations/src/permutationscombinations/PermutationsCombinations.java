/*
Name : مالك علي حميدة
ID : 120211140
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutationscombinations;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Malik
 */
public class PermutationsCombinations {

    // Method to compute factorial using BigInteger
    public static BigInteger factorial(int num) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // Method to compute nPr
    public static BigInteger permutations(int n, int r) {
        return factorial(n).divide(factorial(n - r));
    }

    // Method to compute nCr
    public static BigInteger combinations(int n, int r) {
        return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
    }

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

        // User input for n and r
        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();

        System.out.print("Enter a nonnegative integer r (≤ n): ");
        int r = scanner.nextInt();

        if (r > n || n <= 0 || r < 0) {
            System.out.println("Invalid input. Ensure that 0 ≤ r ≤ n and n > 0.");
            return;
        }

        // Compute permutations and combinations
        BigInteger perm = permutations(n, r);
        BigInteger comb = combinations(n, r);

        // Output results
        System.out.printf("Number of r-permutations P(%d, %d): %s%n", n, r, perm);
        System.out.printf("Number of r-combinations C(%d, %d): %s%n", n, r, comb);

        // Lottery probability (choosing 6 numbers correctly)
        if (n >= 6) {
            BigInteger lotteryComb = combinations(n, 6);
            System.out.println("Number of ways to choose 6 numbers from " + n + ": " + lotteryComb);
            
            // Compute probability
            double lotteryProb = 1.0 / lotteryComb.doubleValue();
            System.out.println("Probability of selecting the correct 6 numbers in a lottery: " + lotteryProb);
        } else {
            System.out.println("Lottery probability cannot be computed since n < 6.");
        }

        scanner.close();
    }

}
