package StringAndArray;

import java.util.HashMap;

public class ArraySubsetofAnotherArrayUsingHashmap {
    public String isSubset(long a1[], long a2[], long n, long m){
        String ans = "No";

        HashMap<Long,Integer> mapping = new HashMap<>();
        for(int i = 0; i < m ; i++){
            if(mapping.containsKey(a2[i])){
                int replace = mapping.get(a2[i]) + 1;
                mapping.replace(a2[i], replace);
            }else{
                mapping.put(a2[i],1);
            }
        }
        for(int i = 0; i < n; i++){
            if(mapping.containsKey(a1[i])){
                int replace = mapping.get(a1[i]) - 1;
                if(replace == 0){
                    mapping.remove(a1[i]);
                }else{
                    mapping.replace(a1[i], replace);
                }
            }
        }
        if(mapping.isEmpty()){
            ans = "Yes";
        }
        return ans;
    }
    public void InvokeStart(){
        long[] a = {11,7,1,13,21,3,7,3};
        long[] b = {11,3,7,1,7};
        int n = a.length;
        int m = b.length;

        System.out.println("A2 is Subset of A1? : "+isSubset(a,b,n,m));
    }
}
