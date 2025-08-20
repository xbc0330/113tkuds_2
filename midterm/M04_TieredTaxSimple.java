import java.util.*;

public class M04_TieredTaxSimple {
    static int calc(int income) {
        int tax = 0;
        if (income > 1000000) {
            tax += (income - 1000000) * 30 / 100;
            income = 1000000;
        }
        if (income > 500000) {
            tax += (income - 500000) * 20 / 100;
            income = 500000;
        }
        if (income > 120000) {
            tax += (income - 120000) * 12 / 100;
            income = 120000;
        }
        tax += income * 5 / 100;
        return tax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int income = sc.nextInt();
            int t = calc(income);
            sum += t;
            System.out.println("Tax: " + t);
        }
        System.out.println("Average: " + sum / n);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每筆收入計算稅額為常數操作，
 * 處理 n 筆輸入需 O(n)。
 */