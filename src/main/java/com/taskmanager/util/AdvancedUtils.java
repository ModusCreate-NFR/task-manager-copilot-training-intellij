package com.taskmanager.util;
/**
 * Utility class for advanced operations.
 *
 * This class includes:
 * 1. A method to calculate the nth Fibonacci number using dynamic programming.
 * 3. A method to validate an email address.
 * 4. A method to find the longest common subsequence between two strings.
 */


public class AdvancedUtils {

    /**
     * Calculates the nth Fibonacci number using dynamic programming.
     *
     * @param n the index of the Fibonacci number to calculate
     * @return the nth Fibonacci number
     */
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    /**
     * Validates an email address.
     *
     * @param email the email address to validate
     * @return true if the email address is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(regex);
    }

    /**
     * Finds the longest common subsequence between two strings.
     *
     * @param s1 the first string
     * @param s2 the second string
     * @return the longest common subsequence
     */
    public static String longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int index = dp[m][n];
        char[] lcs = new char[index];
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs[index - 1] = s1.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return new String(lcs);
    }

}
