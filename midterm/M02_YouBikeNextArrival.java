import java.util.*;

public class M02_YouBikeNextArrival {
    static int toMinutes(String t) {
        String[] p = t.split(":");
        return Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        String[] times = new String[n];
        int[] mins = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = sc.nextLine();
            mins[i] = toMinutes(times[i]);
        }
        String query = sc.nextLine();
        int q = toMinutes(query);

        int l = 0, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mins[mid] > q) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        if (ans == -1) System.out.println("No bike");
        else System.out.println(times[ans]);
    }
}