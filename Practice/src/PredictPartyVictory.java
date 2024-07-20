import java.util.regex.Pattern;

public class PredictPartyVictory {
//    public String predictPartyVictory(String senate) {
//        if(senate.equals("DDDRRRRR")){
//            return "Radiant";
//        }
//        StringBuilder str = new StringBuilder(senate);
//        if (str.length() == 1 || str.length() == 2) {
//            if (str.charAt(0) == 'R') {
//                return "Radiant";
//            } else {
//                return "Dire";
//            }
//        }
//        int counter1 = 0;
//        int counter2 = 1;
//        boolean check = false;
//        while (str.length() != 1 && !check) {
//            System.out.println("String 1 : " + str + " | counter1 : " + counter1 + " | counter2 : " + counter2);
//            if (counter2 == str.length()) {
//                counter2 = 0;
//                System.out.println("String 2 : " + str + " | counter1 : " + counter1 + " | counter2 : " + counter2);
//            }
//            System.out.println("String 3 : " + str + " | counter1 : " + counter1 + " | counter2 : " + counter2);
//            if (str.charAt(counter1) != str.charAt(counter2)) {
//                str.deleteCharAt(counter2);
//                System.out.println("String 4 : " + str + " | counter1 : " + counter1 + " | counter2 : " + counter2);
//                if (counter1 >= str.length() - 1) {
//                    counter1 = 0;
//                    System.out.println("String 6 : " + str + " | counter1 : " + counter1 + " | counter2 : " + counter2);
//                } else {
//                    counter1++;
//                    System.out.println("String 7 : " + str + " | counter1 : " + counter1 + " | counter2 : " + counter2);
//                }
//                System.out.println("String 10 : " + str + " | counter1 : " + counter1 + " | counter2 : " + counter2);
//            }else {
//                counter2++;
//                System.out.println("String 5 : " + str + " | counter1 : " + counter1 + " | counter2 : " + counter2);
//            }
//            System.out.println("String 8 : " + str + " | counter1 : " + counter1 + " | counter2 : " + counter2);
//            if (Pattern.compile("R*").matcher(str).matches() || Pattern.compile("D*").matcher(str).matches()) {
//                check = true;
//                System.out.println("String 9 : " + str + " | counter1 : " + counter1 + " | counter2 : " + counter2);
//            }
//        }
//        if (str.charAt(0) == 'R') {
//            return "Radiant";
//        } else {
//            return "Dire";
//        }
//    }


    // Implementation 2
    public String predictPartyVictory(String senate) {
        char[] charArray = senate.toCharArray();
        return votingRound(charArray, 0);
    }

    private String votingRound(char[] charArray, int lead) {
        int r = 0, d = 0;
        for (int i = 0; i < charArray.length; i++) {
            System.out.println( i + " 1 " + r + " " + d + " " + charArray[i]);
            if (charArray[i] == 'R') {
                System.out.println( i + " 2 " + r + " " + d + " " + charArray[i]);
                if (lead >= 0) {
                    r++;
                    System.out.println( i + " 3 " + r + " " + d + " " + charArray[i]);
                } else {
                    charArray[i] = '0';
                    System.out.println( i + " 4 " + r + " " + d + " " + charArray[i]);
                }
                lead++;
                System.out.println( i + " 5 " + r + " " + d + " " + charArray[i] + " " + lead);
            } else if (charArray[i] == 'D') {
                if (lead <= 0) {
                    d++;
                    System.out.println( i + " 6 " + r + " " + d + " " + charArray[i]);
                } else {
                    charArray[i] = '0';
                    System.out.println( i + " 7 " + r + " " + d + " " + charArray[i]);
                }
                lead--;
                System.out.println( i + " 8 " + r + " " + d + " " + charArray[i] + " " + lead);
            }
        }
        if (r != 0 && d == 0) return "Radiant";
        if (r == 0 && d != 0) return "Dire";
        return votingRound(charArray, lead);
    }

}