package com.practice.ood.LowLevelDesign.tic.tac.toe;

public class Player {
    private String playerName;
    private int playerId;
    PlayingPiece playingPiece;

    public Player(String playerName, int playerId, PlayingPiece playingPiece) {
        this.playerName = playerName;
        this.playerId = playerId;
        this.playingPiece = playingPiece;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public PlayingPiece getplayingPiece() {
        return playingPiece;
    }

    public void setplayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }
}
