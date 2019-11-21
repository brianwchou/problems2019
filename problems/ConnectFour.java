package problems;

public class ConnectFour {

    public static void main(String[] args) {
        boolean[][] boardWithSolution = new boolean[7][6];
        boardWithSolution[2][0] = true;
        boardWithSolution[2][1] = true;
        boardWithSolution[2][2] = true;
        boardWithSolution[2][3] = true;

        assert connectfour(boardWithSolution, 4) : "Cannot find solution on board";

        boolean[][] emptyBoard = new boolean[7][6];
        assert !connectfour(emptyBoard, 4) : "Should return false on emptyBoard";
    }

    // we are given NxM board
    public static boolean connectfour(boolean[][] board, int k) {
        
        for (int x = 0; x < board.length; x++) { // N xaxis
            for (int y = 0; y < board[x].length; y++) { // M yaxis
                boolean top = y + k < board[x].length;
                boolean bottom = y - k >= 0;

                boolean right =  x + k < board.length;
                boolean left = x - k >= 0;

                boolean answer = false;

                if (top) {
                    answer = checkHorizontal(board, x, y, 1, k) || answer;
                }
                
                if (bottom) {
                    answer = checkHorizontal(board, x, y, -1, k) || answer;
                }

                if (left) {
                    answer = checkVertical(board, x, y, -1, k) || answer;
                }

                if (right) {
                    answer = checkVertical(board, x, y, 1, k) || answer;
                }

                if (top && right) {
                    answer = checkDiagonal(board, x, y, 1, 1, k) || answer;
                }

                if (top && left) {
                    answer = checkDiagonal(board, x, y, -1, 1, k) || answer;
                }

                if (bottom && right) {
                    answer = checkDiagonal(board, x, y, 1, -1, k) || answer;
                }

                if (bottom && left) {
                    answer = checkDiagonal(board, x, y, -1, -1, k) || answer;
                }

                if (answer) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private static boolean checkHorizontal(boolean[][] board, int x, int y, int direction, int k) {
        for (int i = 0; i < k; i++) {
            if (!board[x + (i * direction)][y]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkVertical(boolean[][] board, int x, int y, int direction, int k) {
        for (int i = 0; i < k; i++) {
            if (!board[x][y + (i * direction)]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDiagonal(boolean[][] board, int x, int y, int x_direction, int y_direction, int k) {
        for (int i = 0; i < k; i++) {
            if (!board[x + (i * x_direction)][y + (i * y_direction)]) {
                return false;
            }
        }
        return true;
    }
}