package com.practice.ood.LowLevelDesign.tic.tac.toe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    // Game will have followings
    // board,players
    Deque<Player>players;
    private Board gameBoard;

    public TicTacToeGame() {
       initializeGame();
    }

    private void initializeGame() {
        // create 2 players and a board
        players = new LinkedList<>();
        PlayingPieceX playingPieceX = new PlayingPieceX(PieceType.X);
        PlayingPieceO playingPieceO = new PlayingPieceO(PieceType.O);
        Player player1 = new Player("player1",1,playingPieceX);
        Player player2 = new Player("player2",2,playingPieceO);
        players.add(player1);
        players.add(player2);
        gameBoard = new Board(3);
    }
    public String startGame(){
        boolean noWinner = true;
        while (noWinner){
            Player playerTurn = this.players.removeFirst();
            // get the free space of the board
            gameBoard.printBoard();
            List<Pair<Integer,Integer>>freeSpaces = gameBoard.getFreeCells();
            if (freeSpaces.isEmpty()){
                noWinner = false;
                continue;
            }
            // read the user input
            System.out.println("Player: "+ playerTurn.getPlayerName() +" Enter row,col: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[]values = s.split(",");
            int row = Integer.parseInt(values[0]),col = Integer.parseInt(values[1]);
            // place the piece if there is a place is valid and the board has free spaces
            boolean pieceAddedSuccessfully = gameBoard.addPiece(row,col,playerTurn.playingPiece);
            if (!pieceAddedSuccessfully){
                // player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            boolean winner = isThereWinner(row,col,playerTurn.playingPiece.getPieceType());
            if (winner) {
                return playerTurn.getPlayerName();
            }
        }
        return "tie";
    }

    private boolean isThereWinner(int row, int col, PieceType pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;
        // need to check in row
        PlayingPiece[][]grid = gameBoard.getBoard();
        for(int c = 0; c < gameBoard.getSize();++c){
            if (grid[row][c] == null || grid[row][c].getPieceType() != pieceType){
                rowMatch = false;
            }
        }
        // need to check for col
        for (int r = 0; r < gameBoard.getSize();++r){
            if(grid[r][col] == null || grid[r][col].getPieceType()  != pieceType){
                columnMatch = false;
            }
        }
        // need to check diagonal
        for (int r = 0,c = 0; r <gameBoard.getSize();++r,++c){
            if(grid[r][c] == null || grid[r][c].getPieceType() != pieceType){
                diagonalMatch = false;
            }
        }
        for (int r = 0,c = gameBoard.getSize()-1; r < gameBoard.getSize() && c >= 0;++r,--c){
            if (grid[r][c] == null || grid[r][c].getPieceType() != pieceType){
                antiDiagonalMatch = false;
            }
        }
        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
