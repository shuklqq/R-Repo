import java.util.*;

public class DetermineIfTwoStringsAreClosed {
    public boolean closeStrings(String word1, String word2) {
        char[] a1 = word1.toCharArray();
        char[] a2 = word2.toCharArray();
        if (a1.length != a2.length) {
            return false;
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        if (Arrays.equals(a1, a2)) {
            return true;
        }
        HashMap<Character, Integer> n2 = new HashMap<>();
        for (char itr : a2) {
            if (n2.containsKey(itr)) {
                int s = n2.get(itr);
                s++;
                n2.put(itr, s);
            } else {
                n2.put(itr, 1);
            }
        }

        HashMap<Character, Integer> n1 = new HashMap<>();
        for (char itr : a1) {
            if (n1.containsKey(itr)) {
                int s = n1.get(itr);
                s++;
                n1.put(itr, s);
            } else {
                n1.put(itr, 1);
            }
        }
        HashMap<Character, Integer> n3 = new HashMap<>();
        ArrayList<Character> n4 = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : n1.entrySet()) {
            char key = (char) entry.getKey();
            int value = (int) entry.getValue();
            if (!n2.containsKey(key)) {
                System.out.println("First if");
                return false;
            } else {
                if (n2.get(key) != value) {
                    System.out.println("Second if");
                    if (!n2.containsValue(value)) {
                        System.out.println("Third if");
                        return false;
                    } else {
                        System.out.println("fourth if");
                        int m = 0;
                        for (Map.Entry<Character, Integer> entry1 : n2.entrySet()) {
                            char key1 = (char) entry1.getKey();
                            System.out.println("Eighth if");
                            System.out.println( " || value : " + value + " || key1 : " + key1 + " || key : " + key + " || key1 Value : " + n1.get(key1) + " || key Value : " + n2.get(key));
                            if (Objects.equals(n1.get(key1), n2.get(key)) && !n4.contains(key1)) {
                                System.out.println("Fifth if");
                                n3.put(key, n1.get(key1));
                                n4.add(key1);
                                System.out.println("Before Break");
                                System.out.println(n3);
                                m++;
                                break;
                            }
                        }
                        if (m == 0) {
                            System.out.println("Sixth if");
                            return false;
                        }
                    }
                } else {
                    System.out.println("Seventh if");
                    n3.put(key, value);
                }
            }
        }
        System.out.println("n2 : " + n2);
        System.out.println("n3 : " + n3);
        return n3.equals(n2);
    }
}
