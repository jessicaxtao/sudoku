public class sudoku {

    private static boolean solve(int[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == 0) {
                    for(int num = 1; num <= 9; num++) {
                        board[i][j] = num;
                        if(isValid(board, i, j) && solve(board)) {
                            return true;
                        }
                        board[i][j] = 0;
                    }
                    return false;
                }

            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int i, int j) {
        // row is good
        for(int count = 0; count < 9; count++) {
            if(board[i][j] == board[i][count] && j != count) {
                return false;
            }
        }
        // column is good
        for(int count = 0; count < 9; count++) {
            if(board[i][j] == board[count][j] && i != count) {
                return false;
            }
        }

        // box is good
        int divi = i / 3;
        int divj = j / 3;
        for(int row = divi*3; row < divi + 3; row++) {
            for(int col = divj*3; col < divj + 3; col++) {
                if(board[i][j] == board[row][col] && (i != row && j!= col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void toString(int[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
                if(j % 3 == 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i % 3 == 2) {
                System.out.println("------------");
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {7, 8, 0, 4, 0, 0, 1, 2, 0},
                {6, 0, 0, 0, 7, 5, 0, 0, 9},
                {0, 0, 0, 6, 0, 1, 0, 7, 8},
                {0, 0, 7, 0, 4, 0, 2, 6, 0},
                {0, 0, 1, 0, 5, 0, 9, 3, 0},
                {9, 0, 4, 0, 6, 0, 0, 0, 5},
                {0, 7, 0, 3, 0, 0, 0, 1, 2},
                {1, 2, 0, 0, 0, 7, 4, 0, 0},
                {0, 4, 9, 2, 0, 6, 0, 0, 7}
        };
        solve(board);
        toString(board);
    }

}
