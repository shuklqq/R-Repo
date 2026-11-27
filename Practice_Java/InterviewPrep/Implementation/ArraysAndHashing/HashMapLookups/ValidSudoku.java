package InterviewPrep.Implementation.ArraysAndHashing.HashMapLookups;

import java.util.ArrayList;
import java.util.HashMap;

/*
You are given a Sudoku board as 9 strings, one per row from top to bottom. Each string has 9 characters. A character is a digit from 1 to 9, or . for an empty cell. Return true if no digit appears twice in the same row, the same column or the same box, and false otherwise.

The board is split into nine boxes of 3 × 3 cells. Rows 0–2, 3–5 and 6–8 meet columns 0–2, 3–5 and 6–8 to form them, so every cell belongs to exactly one box. A 3 × 3 square that crosses a box border is not a box.

Only the digits already on the board are checked. The board may have any number of empty cells, and it does not need to have a solution.

Example 1
3
2
8
4
8
6
5
4
5
2
1
7
1
7
5
3
4
9
1
8
4
2
8
1
6
1
4
8
5
7
5
1
4
Input:
board = [".32...8..",
         "...486.5.",
         "4..5.2.17",
         "..1...7.5",
         "3.49....1",
         "...8....4",
         "2.8...16.",
         ".1..4857.",
         ".5..1.4.."]

Output: true
Explanation: Every row, column and box holds each digit at most once. Empty cells are not checked.

Example 2
8
3
3
1
3
7
9
2
5
7
4
2
7
6
2
8
4
5
1
9
Input:
board = ["8.....3..",
         "..3..1...",
         "37..9...2",
         "...5...7.",
         "....4....",
         ".2...7...",
         "6...2..8.",
         "...4..5..",
         "..1.....9"]

Output: false
Explanation: Row 1 has a 3 in column 2, and row 2 has a 3 in column 0. They are in different rows and different columns, but both are in the top-left box, so that box holds the digit 3 twice.

Example 3
1
2
3
4
5
6
7
8
9
Input:
board = ["12345678.",
         ".........",
         ".........",
         "........9",
         ".........",
         ".........",
         ".........",
         ".........",
         "........."]

Output: true
Explanation: No digit repeats, so the board is valid. It cannot be finished: the last cell of row 0 needs a 9, but column 8 already has one. That does not change the answer.

Constraints
board.length = 9
board[i].length = 9
board[i][j] is one of '1' to '9', or '.'

Topics
Array
Hash Map
Matrix

*/
public class ValidSudoku {
    private static final int SIZE = 9;
    private static final int BOX_SIZE = 3;
    private static final char EMPTY = '.';

    public boolean isValidSudoku(String[] board) {
        /*
        // Approach 1: HashMap<index, ArrayList<Character>> per row / column / box.
        // The board is fixed at 9x9, so strictly this is O(1). Generalised to an N x N board (N = 9):
        // Time:  O(N^3). N^2 cells; for each one, 3 HashMap lookups (O(1) expected, but they hash a boxed
        //        Integer key) plus 3 ArrayList.contains calls, each a linear scan of up to N - 1 values -> O(N).
        //        toCharArray() also copies every row.
        // Space: O(N^2). Up to N^2 digits stored in each of the 3 maps, plus HashMap entry and ArrayList overhead.
        HashMap<Integer, ArrayList<Character>> row = new HashMap<>();
        HashMap<Integer, ArrayList<Character>> col = new HashMap<>();
        HashMap<Integer, ArrayList<Character>> box = new HashMap<>();
        for(int a = 0 ; a < 9 ; a++){
            char[] curr = board[a].toCharArray();
            for(int b = 0 ; b < 9 ; b++){
                if(curr[b] == '.'){
                    continue;
                }
                int boxNumber = ((a / 3) * 3 + (b / 3));
                ArrayList<Character> rowValues = row.computeIfAbsent(a, key -> new ArrayList<>());
                ArrayList<Character> colValues = col.computeIfAbsent(b, key -> new ArrayList<>());
                ArrayList<Character> boxValues = box.computeIfAbsent(boxNumber, key -> new ArrayList<>());
                if(rowValues.contains(curr[b]) || colValues.contains(curr[b]) || boxValues.contains(curr[b])){
                    return false;
                }
                rowValues.add(curr[b]);
                colValues.add(curr[b]);
                boxValues.add(curr[b]);
            }
        }
        return true;
        */

        // Approach 2: boolean arrays indexed directly by [row / column / box][digit].
        // Time:  O(N^2), so O(81) for 9x9. Each cell does 3 array reads and at most 3 writes, all O(1):
        //        no hashing, no boxing, no list scans, no row copies.
        // Space: O(N^2). Three N x N boolean arrays, 243 booleans for 9x9.
        // seenInRow[r][d]: digit d + 1 is already in row r.
        boolean[][] seenInRow = new boolean[SIZE][SIZE];
        boolean[][] seenInColumn = new boolean[SIZE][SIZE];
        boolean[][] seenInBox = new boolean[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                char cell = board[row].charAt(col);
                if (cell == EMPTY) {
                    continue;
                }
                // '1'..'9' becomes 0..8.
                int digitIndex = cell - '1';
                int box = boxIndex(row, col);
                boolean repeated = seenInRow[row][digitIndex]
                        || seenInColumn[col][digitIndex]
                        || seenInBox[box][digitIndex];
                if (repeated) {
                    return false;
                }
                seenInRow[row][digitIndex] = true;
                seenInColumn[col][digitIndex] = true;
                seenInBox[box][digitIndex] = true;
            }
        }
        return true;
    }

    // Boxes run 0 to 8, left to right, top to bottom.
    private int boxIndex(int row, int col) {
        return (row / BOX_SIZE) * BOX_SIZE + col / BOX_SIZE;
    }
}
