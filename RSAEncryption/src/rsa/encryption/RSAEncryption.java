/*
Name : مالك علي حميدة
ID : 120211140
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa.encryption;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Malik
 */
public class RSAEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Request user input
        System.out.print("Enter the message to encrypt: ");
        String message = scanner.nextLine();

        System.out.print("Enter the modulus n (n = p * q): ");
        BigInteger n = new BigInteger(scanner.nextLine());

        System.out.print("Enter the public exponent e: ");
        BigInteger e = new BigInteger(scanner.nextLine());

        // Translate the message into blocks of four digits
        String asciiMessage = translateToFourDigitBlocks(message);

        // Display the RSA encryption formula
        System.out.println("\nThe Result RSA Encryption");
        System.out.println("=> C = M^e mod n");

        // Encrypt each block and display the steps
        String[] encryptedBlocks = encryptBlocksWithSteps(asciiMessage, n, e);

        // Output the final encrypted message
        System.out.println("Encrypted message = " + String.join("", encryptedBlocks));

        scanner.close();
    }

  public static String translateToFourDigitBlocks(String message) {
        StringBuilder asciiMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            int numericValue = (c == ' ') ? 27 : (c - 'A' + 0); // A=00, B=01, ..., Z=25, Space=27
            asciiMessage.append(String.format("%02d", numericValue));
        }

        // التأكد من أن الطول يقبل القسمة على 4 بإضافة أصفار عند الحاجة
        while (asciiMessage.length() % 4 != 0) {
            asciiMessage.append("00");
        }

        return asciiMessage.toString();
    }

    public static String[] encryptBlocksWithSteps(String asciiMessage, BigInteger n, BigInteger e) {
        int blockCount = asciiMessage.length() / 4;
        String[] encryptedBlocks = new String[blockCount];

        for (int i = 0; i < asciiMessage.length(); i += 4) {
            String block = asciiMessage.substring(i, i + 4);

            // تحويل الكتلة إلى عدد صحيح BigInteger
            BigInteger m = new BigInteger(block);

            // تشفير الكتلة: C = M^e mod n
            BigInteger c = m.modPow(e, n);

            // طباعة الخطوة
            System.out.println("C" + (i / 4 + 1) + " = " + block + "^" + e + " mod (" + n + ") = [" + c + "]");

            // تخزين الكتلة المشفرة
            encryptedBlocks[i / 4] = c.toString();
        }

        return encryptedBlocks;
    }
}
