public class NQueen {
    private static int solutionCount = 0;
    
    public static void solveNQueen(int n) {
        int[][] board = new int[n][n];
        solveAll(board, 0);
        System.out.println("\nTotal number of solutions: " + solutionCount);
    }
    
    public static void solveAll(int[][] board, int row) {
        if (row >= board.length) {
            solutionCount++;
            System.out.println("\nSolution " + solutionCount + ":");
            printBoard(board);
            return;
        }
        
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                solveAll(board, row + 1);
                board[row][col] = 0; // backtrack
            }
        }
    }
    
    public static boolean isSafe(int[][] board, int row, int col) {
        // Check if there's a queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        
        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        // Check upper-right diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.err.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("All solutions for " + n + "-Queens problem:");
        solveNQueen(n);
    }
}