package StringAndArray;

public class ContainerWithMostWater {
    public int maxArea(int[] height){
        int a = 0;
        int b = height.length -1;
        int maxArea = 0;
        int leftIndex = a;
        int rightIndex = b;
        int area = 0;
        while((a<=rightIndex) && (b>=leftIndex) ){
            System.out.println("right Index1 : " + rightIndex + " Left Index1 : " + leftIndex);
            if(height[leftIndex] < height[a]){
                System.out.println("Left Height1 : " + height[leftIndex] + " height[a]1 : " + height[a]);
                System.out.println("Area1 : " + area);
                leftIndex = a;
                System.out.println("right Index2 : " + rightIndex + " Left Index2 : " + leftIndex);
                area = Math.min(height[leftIndex],height[rightIndex]) * (rightIndex - leftIndex);
                System.out.println("Area2 : " + area);
                maxArea = Math.max(maxArea,area);
            }
            if(height[rightIndex] < height[b]){
                System.out.println("Area3 : " + area);
                rightIndex = b;
                System.out.println("right Index4 : " + rightIndex + " Left Index4 : " + leftIndex);
                area = Math.min(height[leftIndex],height[rightIndex]) * (rightIndex - leftIndex);
                System.out.println("Area4 : " + area);
                maxArea = Math.max(maxArea,area);
                System.out.println("a1 : " + a + " b1 :  " + b);
            }
            area = Math.min(height[leftIndex],height[rightIndex]) * (rightIndex - leftIndex);
            maxArea = Math.max(maxArea,area);
            if(height[leftIndex] <= height[rightIndex]){
                a++;
            }
            if(height[rightIndex] <= height[leftIndex]) {

                b--;
            }
            System.out.println("a2 : " + a + " b2 :  " + b);
            System.out.println("________________________________________________________________________________________");
            System.out.println("Max Area Final : " + maxArea);
            System.out.println("________________________________________________________________________________________");
        }
        return maxArea;
    }
}
