package DesignTicTacToe;

public class Demo {
    /*
     * Piece - X, O, #,$ - can be extensible
     * Board - n * n
     * Player - 1, 2 id assigned to player as well the piece
     * Game - board, list of players
     * */
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        String gameWinner = game.startGame();
        System.out.println("game Winner: " + gameWinner);
    }
}
