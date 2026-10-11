package Math;

import java.util.Scanner;

public class Test {

    // Two strings share a difference pattern iff every adjacent delta matches.
    // Compared on the fly with early exit — no pattern arrays materialized.
    private static boolean samePattern(String a, String b) {
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) - a.charAt(i - 1) != b.charAt(i) - b.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static String oddOneOut(String[] series) {
        // If the first two disagree, the third string is the tiebreaker:
        // whichever of the first two it matches is majority, the other is odd.
        if (!samePattern(series[0], series[1])) {
            return samePattern(series[0], series[2]) ? series[1] : series[0];
        }
        // First two agree, so they hold the majority pattern; scan for the outlier.
        for (int i = 2; i < series.length; i++) {
            if (!samePattern(series[0], series[i])) {
                return series[i];
            }
        }
        return ""; // unreachable: exactly one odd string is guaranteed
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] series = new String[n];
        for (int i = 0; i < n; i++) {
            series[i] = sc.next();
        }
        sc.close();
        System.out.println(oddOneOut(series));
    }
}
