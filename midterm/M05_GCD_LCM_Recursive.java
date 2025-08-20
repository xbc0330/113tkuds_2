import java.util.*;

public class M05_GCD_LCM_Recursive {
    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(), b = sc.nextLong();
        long g = gcd(a, b);
        long l = a / g * b;
        System.out.println("GCD: " + g);
        System.out.println("LCM: " + l);
    }
}

/*
 * Time Complexity: O(log(min(a, b)))
 * 說明：歐幾里得演算法每次遞迴取餘數，
 * 值呈倍數下降，因此為對數時間。
 */