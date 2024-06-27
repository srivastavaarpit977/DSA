public class sudoku {
    public class SudokuSolver {
        public static void main(String[] args) {
            

        
        public static final int BOARD_SIZE = 9;
        public static final int EMPTY_CELL = 0;

        public static void main(String[] args) {
            int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
            };

            if (solveSudoku(board)) {
                System.out.println("Sudoku solved successfully!");
                printBoard(board);
            } else {
                System.out.println("No solution exists for the given Sudoku board.");
            }
        }
        }

        public static boolean solveSudoku(int[][] board) {
            for (int row = 0; row < BOARD_SIZE; row++) {
                for (int col = 0; col < BOARD_SIZE; col++) {
                    if (board[row][col] == EMPTY_CELL) {
                        for (int num = 1; num <= BOARD_SIZE; num++) {
                            if (isValid(board, row, col, num)) {
                                board[row][col] = num;

                                if (solveSudoku(board)) {
                                    return true;
                                } else {
                                    board[row][col] = EMPTY_CELL;
                                }
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        public static boolean isValid(int[][] board, int row, int col, int num) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (board[row][i] == num || board[i][col] == num) {
                    return false;
                }
            }

            int startRow = row - row % 3;
            int startCol = col - col % 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[startRow + i][startCol + j] == num) {
                        return false;
                    }
                }
            }

            return true;
        }

        public static void printBoard(int[][] board) {
            for (int row = 0; row < BOARD_SIZE; row++) {
                for (int col = 0; col < BOARD_SIZE; col++) {
                    System.out.print(board[row][col] + " ");
                }
                System.out.println();
            }
        }
    
    }
    
}
