package StringAndArray;

public class MaximumNumberOfVowels {
    public int maxVowels(String s, int k) {
        int maximumVowels = 0;
        int vowels = 0;
        for(int a = 0 ; a < k ; a++){
            System.out.println("Previous : " + s.charAt(a));
            if("aeiou".indexOf(s.charAt(a)) != -1){
                vowels++;
                System.out.println(s.charAt(a));
            }
        }
        maximumVowels = Math.max(maximumVowels,vowels);
        int b = 1;
        while(b <= s.length() - k){
            if("aeiou".indexOf(s.charAt(b-1)) != -1){
                vowels--;
            }
            if("aeiou".indexOf(s.charAt(b+k-1)) != -1){
                vowels++;
            }
            maximumVowels = Math.max(maximumVowels,vowels);
            b++;
        }
        return maximumVowels;
    }
    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
