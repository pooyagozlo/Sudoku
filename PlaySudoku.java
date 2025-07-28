// Pooya Gozlo
// CS 143
// Assignment: Sudoku Solver Part 2
//
// This program reads multiple sudoku board files from the "boards" folder,
// displays each board, and reports whether it is valid and/or completely solved.

import java.io.*;

public class PlaySudoku {

    // pre: all test files must exist inside a folder named boards and with correct path
    // post: prints each board and reports whether it is valid and/or solved
    public static void main(String[] args) throws Exception {
        String[] filenames = {"col-violation.sdk","dirty-data.sdk","empty.sdk","grid-violation.sdk","row-and-col-violation.sdk","row-violation.sdk","valid-complete.sdk","valid-incomplete.sdk"};
        

        for (String name : filenames) {
            System.out.println("=== Board: " + name + " ===");
            SudokuBoard board = new SudokuBoard("boards/" + name);
            System.out.println(board);
            System.out.println("Valid?   " + board.isValid());
            System.out.println("Solved?  " + board.isSolved());
            System.out.println();
        }
    }
}
/*
 ----jGRASP exec: java -ea PlaySudoku
 === Board: col-violation.sdk ===
 9 . . | . . . | . . . 
 . . . | . . . | . . . 
 6 . . | . . . | . . . 
 ------+-------+------
 . . . | . . . | . . . 
 4 . . | . . . | . . . 
 3 . . | . . . | . . . 
 ------+-------+------
 . . . | . . . | . . . 
 9 . . | . . . | . . . 
 . . . | . . . | . . . 
 
 Valid?   false
 Solved?  false
 
 === Board: dirty-data.sdk ===
 . . . | . . . | . . . 
 1 6 7 | 9 8 5 | 4 2 3 
 . . # | . . . | . . . 
 ------+-------+------
 . . . | . . . | . . . 
 . . . | % . . | . . . 
 . . . | . . . | . . . 
 ------+-------+------
 . . . | . . 2 | . . . 
 . . w | . . . | . . . 
 . . . | . . . | . . . 
 
 Valid?   false
 Solved?  false
 
 === Board: empty.sdk ===
 . . . | . . . | . . . 
 . . . | . . . | . . . 
 . . . | . . . | . . . 
 ------+-------+------
 . . . | . . . | . . . 
 . . . | . . . | . . . 
 . . . | . . . | . . . 
 ------+-------+------
 . . . | . . . | . . . 
 . . . | . . . | . . . 
 . . . | . . . | . . . 
 
 Valid?   true
 Solved?  false
 
 === Board: grid-violation.sdk ===
 . . . | . . . | . . . 
 . . . | . . . | . . . 
 . . . | . . . | . . . 
 ------+-------+------
 . . . | . . . | . . . 
 . . . | . . . | . . . 
 . . . | . . . | . . . 
 ------+-------+------
 . . . | . . . | 1 2 . 
 . . . | . . . | . 3 2 
 . . . | . . . | 5 4 . 
 
 Valid?   false
 Solved?  false
 
 === Board: row-and-col-violation.sdk ===
 . . . | . 4 . | . . . 
 . . . | . 3 . | . . . 
 . . . | . 1 . | 2 . . 
 ------+-------+------
 . . . | . 6 . | . . . 
 . 3 . | . 2 . | 3 . . 
 . . . | . 7 . | . . . 
 ------+-------+------
 . . . | . 8 . | 2 . . 
 . . 3 | . 5 . | . . . 
 . . . | . 9 . | . . . 
 
 Valid?   false
 Solved?  false
 
 === Board: row-violation.sdk ===
 7 . . | . . . | . 1 . 
 2 . . | . . . | . . . 
 . . . | . . . | . . . 
 ------+-------+------
 . . 4 | . 3 . | 4 . . 
 . . . | . . . | . . . 
 . . . | . . . | . . . 
 ------+-------+------
 . . . | . 6 . | . . . 
 . . . | . . . | . 3 . 
 . . . | . . . | . . . 
 
 Valid?   false
 Solved?  false
 
 === Board: valid-complete.sdk ===
 5 3 4 | 6 7 8 | 9 1 2 
 6 7 2 | 1 9 5 | 3 4 8 
 1 9 8 | 3 4 2 | 5 6 7 
 ------+-------+------
 8 5 9 | 7 6 1 | 4 2 3 
 4 2 6 | 8 5 3 | 7 9 1 
 7 1 3 | 9 2 4 | 8 5 6 
 ------+-------+------
 9 6 1 | 5 3 7 | 2 8 4 
 2 8 7 | 4 1 9 | 6 3 5 
 3 4 5 | 2 8 6 | 1 7 9 
 
 Valid?   true
 Solved?  true
 
 === Board: valid-incomplete.sdk ===
 5 3 . | . 7 . | . . . 
 6 . . | 1 9 5 | . . . 
 . 9 8 | . . . | . 6 . 
 ------+-------+------
 8 . . | . 6 . | . . 3 
 4 . . | 8 . 3 | . . 1 
 7 . . | . 2 . | . . 6 
 ------+-------+------
 . 6 . | . . . | 2 8 . 
 . . . | 4 1 9 | . . 5 
 . . . | . 8 . | . 7 9 
 
 Valid?   true
 Solved?  false
 
 
  ----jGRASP: Operation complete.
 
*/

