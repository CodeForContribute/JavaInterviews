package DesignTicTacToe;

import java.util.ArrayList;
import java.util.List;
public class Board {
    private final int size;
    private final PlayingPiece[][] board;//board has pieces

    public Board(int size) {
        this.size = size;
        // initializing the board
        this.board = new PlayingPiece[size][size];
    }

    public void printBoard() {
        for (int r = 0; r < size; ++r) {
            for (int c = 0; c < size; ++c) {
                System.out.print(board[r][c] == null ? "__ " : board[r][c].getPieceType() + " ");
            }
            System.out.println();
        }
    }

    public List<Pair<Integer, Integer>> getFreeCells() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();
        for (int r = 0; r < size; ++r) {
            for (int c = 0; c < size; ++c) {
                if (board[r][c] == null) {
                    Pair<Integer, Integer> rowCol = new Pair<>(r, c);
                    freeCells.add(rowCol);
                }
            }
        }
        return freeCells;
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece) {
        if (board[row][col] != null) {
            return false;
        }
        board[row][col] = playingPiece;
        return true;
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }
}
