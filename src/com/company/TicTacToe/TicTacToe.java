package com.company.TicTacToe;

import java.util.*;

public class TicTacToe {
    private int boardSize;
    private static List<Integer> players = List.of(1, 2);
    private String[][] board;

    public static void main(String[] args) {
        TicTacToe tc = new TicTacToe(3);
        tc.start();
    }

    public TicTacToe(int boardSize) {
        this.boardSize = boardSize;
        this.intializeBoard();
    }

    public void intializeBoard() {
        this.board = new String[boardSize][boardSize];
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++) {
                this.board[i][j] = "-";
            }
        }
    }

    public void start() {
        this.displayBoard();
        Random rand = new Random();
        int currentPlayer = this.players.get(rand.nextInt(this.players.size()));
        while (true) {
            System.out.println(String.format("Player %s please select your spot", currentPlayer));
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter row to be filled: ");
            int row = sc.nextInt();
            System.out.println(" ");
            System.out.print("Please enter col to be filled: ");
            int col = sc.nextInt();
            this.markSpot(row, col, currentPlayer);
            Boolean playerWin = this.checkGameStatus(currentPlayer);
            if (this.isBoardFilled()) {
                System.out.println("The game is a draw");
                this.displayBoard();
                break;
            }
            if (playerWin) {
                System.out.println(String.format("Player %s has won the game", currentPlayer));
                this.displayBoard();
                break;
            }
            currentPlayer = this.switchPlayer(currentPlayer);
            this.displayBoard();

        }
    }


    public void markSpot(int row, int col, int player) {
        if (player == 1) {
            this.board[row - 1][col - 1] = "x";
        } else {
            this.board[row - 1][col - 1] = "o";
        }
    }

    public Boolean checkGameStatus(int CurrentPlayer) {
        String winningChar = CurrentPlayer == 1 ? "x" : "o";
        Boolean win=false;
//        Check rows
        for (int i = 0; i < this.boardSize; i++) {
            win = true;
            for (int j = 0; j < this.boardSize; j++) {
                if (this.board[i][j] != winningChar) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return win;
            }
        }
        for (int i = 0; i < this.boardSize; i++) {
            win = true;
            for (int j = 0; j < this.boardSize; j++) {
                if (this.board[j][i] != winningChar) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return win;
            }
        }
        for (int i = 0; i < this.boardSize; i++) {
            win = true;
            if (this.board[i][i] != winningChar) {
                win = false;
                break;
            }
        }
        if (win) {
            return win;
        }
        for (int i = 0; i < this.boardSize; i++) {
            win = true;
            if (this.board[i][this.boardSize - i-1] != winningChar) {
                win = false;
                break;
            }
        }
        if (win) {
            return win;
        }
        return false;
    }

    public int switchPlayer(int CurrentPlayer) {
        Random rand = new Random();
        while (true) {
            int randomElement = this.players.get(rand.nextInt(this.players.size()));
            if (randomElement != CurrentPlayer) {
                return randomElement;
            }
        }
    }

    public Boolean isBoardFilled() {
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++) {
                if (this.board[i][j] == "-") {
                    return false;
                }
            }
        }
        return true;
    }

    public void displayBoard() {
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++) {
                System.out.print(this.board[i][j]);
                System.out.print("\t");
            }
            System.out.println("  ");
        }
    }
}


