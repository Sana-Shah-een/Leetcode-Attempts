class Solution {
    public boolean isValidSudoku(char[][] board) {
// Solution-1: Boolean Arrays
       boolean[][] rows=new boolean[9][9];
       boolean[][] cols=new boolean[9][9];
       boolean[][] boxes=new boolean[9][9];

       for(int r=0;r<9;r++){
        for(int c=0;c<9;c++){

            if(board[r][c]=='.') continue;

// char digit ko index 0-8 mein convert karte hain bcoz arrays 0-based indexing use krte if we range digits 1-9 but when rows[r][9] then index out of bounds error aega so thats why it is crucial step
            // example: '1'→0, '5'→4, '9'→8
            int num=board[r][c]-'1';

            //formula: (r/3) * totalcols = 3 + (c/3)
            int boxIndex=(r/3)*3+(c/3);

//if  true then this block executes mean duplicates exist in somewhere like in row,col or box(3x3)
            if(rows[r][num] || cols[c][num] || boxes[boxIndex][num]){ 
                return false;
            }
            rows[r][num]=true;
            cols[c][num]=true;
            boxes[boxIndex][num]=true;
        }
       }
       return true;

    }
}

// //Solution-2: HashSet-> automatically unique values store krta he

// import java.util.HashSet;

// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         HashSet<String> seen = new HashSet<>();

//         for (int r = 0; r < 9; r++) {
//             for (int c = 0; c < 9; c++) {
//                 char num = board[r][c];
//                 if (num == '.') continue;

//                 String rowKey = num + " in row " + r;
//                 String colKey = num + " in col " + c;
//                 String boxKey = num + " in box " + (r/3) + "-" + (c/3);

// // Agar rowKey already set mein tha → add() returns false → !false = true → duplicate detected
// // Agar rowKey pehle se nahi tha → add() returns true → !true = false → safe

//                 if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
// }

// Time Complexity:
// Outer × Inner = 9 × 9 = 81 cells
// Each cell → constant O(1) operations
// O(81) → O(1) constant time

// Space Complexity:
// Each array: 9×9 = 81 elements
// Total memory: 3 × 81 = 243 booleans
// O(9*9*3) → O(1) constant space

// Note for Interviews:
// For a general n×n Sudoku, with √n×√n boxes:
// Time → O(n²)
// Space → O(n²)
// But since standard Sudoku is 9×9 → constant time & space.
