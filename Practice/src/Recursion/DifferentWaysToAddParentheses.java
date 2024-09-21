/*

Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.



Example 1:

Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2
Example 2:

Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10


Constraints:

1 <= expression.length <= 20
expression consists of digits and the operator '+', '-', and '*'.
All the integer values in the input expression are in the range [0, 99].
The integer values in the input expression do not have a leading '-' or '+' denoting the sign.

 */

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

    // Approach 1 : Simple Recursion
/*    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        int size = expression.length();
        if (size == 0) {
            return ans;
        } else if (size == 1) {
            ans.add(Integer.parseInt(expression));
        } else if (size == 2 && Character.isDigit(expression.charAt(0))) {
            ans.add(Integer.parseInt(expression));
        }

        for (int a = 0; a < expression.length(); a++) {
            char symbol = expression.charAt(a);

            if (Character.isDigit(symbol)) continue;

            List<Integer> leftIntegers = diffWaysToCompute(expression.substring(0, a));
            List<Integer> rightIntegers = diffWaysToCompute(expression.substring(a + 1));
            for (int leftValue : leftIntegers) {
                for (int rightValue : rightIntegers) {
                    int computedResult = 0;

                    // Perform the operation based on the current character
                    switch (symbol) {
                        case '+':
                            computedResult = leftValue + rightValue;
                            break;
                        case '-':
                            computedResult = leftValue - rightValue;
                            break;
                        case '*':
                            computedResult = leftValue * rightValue;
                            break;
                    }

                    ans.add(computedResult);
                }
            }

        }
        return ans;
    }
    */

// Approach 2 : memorization, recursion with index parsing to avoid substring creation and storing previously occured
// expression for a lookup to remove redundant recursion.

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer>[][] memo = new ArrayList[expression.length()][expression.length()];
        return computeResult(expression, memo, 0, expression.length() - 1);
    }

    private List<Integer> computeResult(String expression, List<Integer>[][] memo, int beginIndex, int endIndex) {
        if (memo[beginIndex][endIndex] != null) {
            return memo[beginIndex][endIndex];
        }
        List<Integer> ans = new ArrayList<>();
        if (endIndex == beginIndex) {
            ans.add(expression.charAt(beginIndex) - '0');
            return ans;
        } else if ((endIndex - beginIndex) == 1 && Character.isDigit(expression.charAt(beginIndex))) {
            int tens = expression.charAt(beginIndex) - '0';
            int ones = expression.charAt(endIndex) - '0';
            ans.add((10 * tens) + ones);
            return ans;
        }
        for (int a = beginIndex; a < endIndex; a++) {
            if (Character.isDigit(expression.charAt(a))) {
                continue;
            }
            List<Integer> leftIntegers = computeResult(expression, memo, beginIndex, a - 1);
            List<Integer> rightIntegers = computeResult(expression, memo, a + 1, endIndex);
            for (int b : leftIntegers) {
                for (int c : rightIntegers) {
                    switch (expression.charAt(a)) {
                        case '+':
                            ans.add(b + c);
                            break;
                        case '-':
                            ans.add(b - c);
                            break;
                        case '*':
                            ans.add(b * c);
                            break;
                    }
                }
            }
        }
        memo[beginIndex][endIndex] = ans;
        return ans;
    }
}
