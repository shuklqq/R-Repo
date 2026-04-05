import java.text.CompactNumberFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyInstance {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        float a = s.nextFloat();
        NumberFormat nf1 = NumberFormat.getCurrencyInstance(Locale.US);
        Locale lnIn  = new Locale("en","IN");
        NumberFormat nf2 = NumberFormat.getCurrencyInstance(lnIn);
        NumberFormat nf3 = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat nf4 = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String dollar = nf1.format(a);
        String india = nf2.format(a);
        String china = nf3.format(a);
        String france = nf4.format(a);
        System.out.println("US: " + dollar);
        System.out.println("India: "+ india);
        System.out.println("China: "+ china);
        System.out.println("France: "+ france);
    }
}
