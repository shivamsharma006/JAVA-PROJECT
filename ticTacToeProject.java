import java.util.Scanner;

class TicTacToe {
    char[][] board;

    public TicTacToe() {
        board = new char[3][3];
        initBoard();
    }

    void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    void placeMark(int row, int col, char ch) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (board[row][col] == ' ') {
                board[row][col] = ch;
            } else {
                System.out.println("Position already taken. Try again.");
            }
        } else {
            System.out.println("INVALID POSITION.");
        }
    }

    boolean checkColWin() {
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        return false;
    }

    boolean checkRowWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    boolean checkDiagonalWin() {
        return (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
               (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    boolean checkWin() {
        return checkRowWin() || checkColWin() || checkDiagonalWin();
    }
}

public class ticTacToeProject {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        System.out.println("START");
        t.displayBoard();
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println("Make sure to select numbers between 0 and 2. Always place the value in a different spot.");
        System.out.println();

        boolean gameWon = false;
        char currentPlayer = 'X';

        while (!gameWon) {
            System.out.println("Enter row for " + currentPlayer + " (0-2):");
            int row = sc.nextInt();
            System.out.println("Enter col for " + currentPlayer + " (0-2):");
            int col = sc.nextInt();

            t.placeMark(row, col, currentPlayer);
            t.displayBoard();

            if (t.checkWin()) {
                System.out.println("WIN " + currentPlayer);
                gameWon = true;
            }

            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        sc.close();
    }
}
