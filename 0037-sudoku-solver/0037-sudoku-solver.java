class Solution {
    private static boolean findEmptyCell(char[][] board, int[] emptyCell) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Fix: Correct 2D array syntax and comparison
                if (board[i][j] == '.') { 
                    emptyCell[0] = i; // Fix: Assign row index
                    emptyCell[1] = j; // Fix: Assign column index
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean solveSudokuHelper(char[][] board) {
        int[] emptyCell = new int[2]; // Fix: Correct array initialization
        
        // Fix: If NO empty cell is found (!), the board is complete
        if (!findEmptyCell(board, emptyCell)) {
            return true;
        }

        int rowIndex = emptyCell[0];
        int colIndex = emptyCell[1];

        // Fix: Directly loop through char digits '1' to '9'
        for (char num = '1'; num <= '9'; num++) {
            if (isSafeToPlace(board, num, rowIndex, colIndex)) {
                board[rowIndex][colIndex] = num; // Make choice

                if (solveSudokuHelper(board)) {
                    return true; 
                }

                board[rowIndex][colIndex] = '.'; // Undo choice (Backtrack)
            }
        }
        return false; 
    }

    private static boolean isSafeToPlace(char[][] board, char charValue, int rowIndex, int colIndex) {
        // Fix: Row and column loops simplified
        for (int i = 0; i < 9; i++) {
            if (board[rowIndex][i] == charValue) return false;
            if (board[i][colIndex] == charValue) return false;
        }

        // Fix: Box start-index formula using modulo
        int startRow = rowIndex - rowIndex % 3;
        int startCol = colIndex - colIndex % 3;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == charValue) {
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
}
