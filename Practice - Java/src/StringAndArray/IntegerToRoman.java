package StringAndArray;

public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        while (num > 0) {
            if (num - 1000 >= 0) {
                ans.append("M");
                num = num - 1000;
            } else if (num - 500 >= 0) {
                if (num / 100 == 9) {
                    ans.append("CM");
                    num = num - 900;
                } else {
                    ans.append("D");
                    num = num - 500;
                }
            } else if (num - 100 >= 0) {
                if (num / 100 == 4) {
                    ans.append("CD");
                    num = num - 400;
                } else {
                    ans.append("C");
                    num = num - 100;
                }
            } else if (num - 50 >= 0) {
                if (num / 10 == 9) {
                    ans.append("XC");
                    num = num - 90;
                } else {
                    ans.append("L");
                    num = num - 50;
                }
            } else if (num - 10 >= 0) {
                if (num / 10 == 4) {
                    ans.append("XL");
                    num = num - 40;
                } else {
                    ans.append("X");
                    num = num - 10;
                }
            } else if (num - 5 >= 0) {
                if (num == 9) {
                    ans.append("IX");
                    num = 0;
                } else {
                    ans.append("V");
                    num = num - 5;
                }
            } else {
                if (num == 4) {
                    ans.append("IV");
                    num = 0;
                } else {
                    ans.append("I");
                    num = num - 1;
                }
            }
            System.out.println(num);
        }
        return ans.toString();
    }
}