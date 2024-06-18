public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n){
        if(flowerbed.length == 1 && flowerbed[0] == 0){
            flowerbed[0] = 1;
            n--;
            System.out.println(flowerbed[0] + "   " + n);
        }else {
            for (int a = 0; a < flowerbed.length; a++) {
                if (flowerbed[a] == 0) {
                    if (a == 0) {
                        if (flowerbed[a + 1] == 0) {
                            flowerbed[a] = 1;
                            n--;
                        }
                    } else if (a == flowerbed.length - 1) {
                        if (flowerbed[a - 1] == 0) {
                            flowerbed[a] = 1;
                            n--;
                        }
                    } else if (flowerbed[a - 1] == 0 && flowerbed[a + 1] == 0) {
                        flowerbed[a] = 1;
                        n--;
                    }
                }
                System.out.println(a + "   " + flowerbed[a] + "   " + n);
            }
        }
        if(n<=0){
            return true;
        }else{
            return false;
        }
    }
}
