// Pooya Gozlo
// CS 143
// Long Homework #2 - Sudoku #2 (isValid, isSolved) 
// Core topics: sets, maps, efficiency, and boolean zen
// In This update to the class, I am adding some methods to verify whether a sudoku board is valid
// (isValid()) and whether it is fully and correctly solved (isSolved(). These methods ensure that all characters are
// legal, rows,columns, 3x3 boxes contain no duplicates, and that the board contains exactly nine of each digit  if solved.



import java.io.*;
import java.util.*;

public class SudokuBoard {
    private char[][] myBoard;
     //pre: must have file that has exactly 9 lines, each containing  9 characters
     // post: makes a sudoku board by reading the file and storing the data into a 2d array field named myboard
    public SudokuBoard(String fileInput) throws FileNotFoundException {
        myBoard = new char[9][9];
        Scanner input = new Scanner(new File(fileInput));

        for (int x = 0; x < 9; x++) {
            String l = input.nextLine();
            for (int y = 0; y < 9; y++) {
                myBoard[x][y] = l.charAt(y);
            }
        }
        input.close();
    }

    //pre: none
    //post: returns a string model of the board
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < 9; x++) {
            if (x % 3 == 0 && x != 0) {
                sb.append("------+-------+------\n");
            }
            for (int y = 0; y < 9; y++) {
                if (y % 3 == 0 && y != 0) {
                    sb.append("| ");
                }
                sb.append(myBoard[x][y]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    // pre: none
    // post: returns true if the board follows all Sudoku rules (no duplicates, valid chars)
    public boolean isValid() {
        return hasValidCharacters() && noRowDuplicates() && noColumnDuplicates() && noBoxDuplicates();
    }
    // pre: none
    // post: returns true if the board is completely filled, contains 9 of each digit, and is valid
    public boolean isSolved() {
        if (!isValid()) {
            return false;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (char c = '1'; c <= '9'; c++) {
            countMap.put(c, 0);
        }
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                char ch = myBoard[x][y];
                if (ch == '.') {
                    return false;
                }
                if (countMap.containsKey(ch)) {
                    countMap.put(ch, countMap.get(ch) + 1);
                }
            }
        }
        for (char c = '1'; c <= '9'; c++) {
            if (countMap.get(c) != 9) {
                return false;
            }
        }
        return true;
    }


    // pre: none
    // post: returns true if all characters on the board are '.', or between '1' and '9'
    private boolean hasValidCharacters() {
        Set<Character> valid = new HashSet<>(Arrays.asList('.', '1','2','3','4','5','6','7','8','9'));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!valid.contains(myBoard[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    // post: none
    // post: returns true if all rows have no duplicate digits
    private boolean noRowDuplicates() {
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char val = myBoard[row][col];
                if (val != '.') {
                    if (seen.contains(val)) {
                        return false;
                    }
                    seen.add(val);
                }
            }
        }
        return true;
    }

    // pre: none
    // post: returns true if all columns have no duplicate digits
    private boolean noColumnDuplicates() {
        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char val = myBoard[row][col];
                if (val != '.') {
                    if (seen.contains(val)) {
                        return false;
                    }
                    seen.add(val);
                }
            }
        }
        return true;
    }

    // pre: none
    // post: returns true if all 3x3 mini-boxes have no duplicate digits
    private boolean noBoxDuplicates() {
        for (int box = 0; box < 9; box++) {
            Set<Character> seen = new HashSet<>();
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    int row = (box / 3) * 3 + r;
                    int col = (box % 3) * 3 + c;
                    char val = myBoard[row][col];
                    if (val != '.') {
                        if (seen.contains(val)) {
                            return false;
                        }
                        seen.add(val);
                    }
                }
            }
        }
        return true;
    }
}
