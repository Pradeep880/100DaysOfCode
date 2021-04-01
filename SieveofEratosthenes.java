import java.util.Arrays;

/**
 * SieveofEratosthenes
 */
public class SieveofEratosthenes {

    public static void Sieve(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j = j + i) {
                    prime[j] = false;
                }
            }
        }
        System.out.print("Prime number within the Range " + n + ":");
        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                System.out.print(" " + i);
            }
        }
    }

    public static void main(String[] args) {
        int n = 150;
        Sieve(n);
    }
}