package Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
//        Map<Character,Character> map = new Map<>();
//        for(int a = 0 ; a < s.length() ; a++){
//            System.out.println(s.charAt(a) + " " + t.charAt(a));
//            if(map.containsKey(s.charAt(a))){
//                System.out.println("1");
//                if(map.get(s.charAt(a)) != t.charAt(a)){
//                    System.out.println("2");
//                    return false;
//                }
//            } else if (map.containsKey(t.charAt(a))) {
//                System.out.println("3");
//                if(map.get(t.charAt(a)) != s.charAt(a)){
//                    System.out.println("4");
//                    return false;
//                }
//            } else{
//                System.out.println("5");
//                map.put(s.charAt(a),t.charAt(a));
//                map.put(t.charAt(a),s.charAt(a));
//            }
//        }
//        return true;

        int map1[]=new int[200];
        int map2[]=new int[200];

        if(s.length()!=t.length())
            return false;


        for(int i=0;i<s.length();i++)
        {
            if(map1[s.charAt(i)]!=map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)]=i+1;
            map2[t.charAt(i)]=i+1;
        }
        return true;
    }
}
