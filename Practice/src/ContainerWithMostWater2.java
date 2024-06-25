public class ContainerWithMostWater2 {
    public int maxArea(int[] height){
        int ans=0;
        int i=0;
        int j=height.length-1;
        while(i<j){
            int min = Math.min(height[i],height[j]);
            int area = (j-i)*min;
            ans = Math.max(area,ans);
            while(i<j && height[i]<=min){
                i++;
            }
            while(i<j && height[j]<=min){
                j--;
            }
        }
        return ans;
    }
}
