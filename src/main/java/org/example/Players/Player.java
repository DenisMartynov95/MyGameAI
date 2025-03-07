package org.example.Players;

public class Player {
    private int diplomacyScore;
    private int aggressiveScore;

    public Player() {
        this.diplomacyScore = 0; // Начальное значение
        this.aggressiveScore = 0; // Начальное значение
    }

    public int getDiplomacyScore() {
        return diplomacyScore;
    }

    public void setDiplomacyScore(int diplomacyScore) {
        this.diplomacyScore = diplomacyScore;
    }

    public int getAggressiveScore() {
        return aggressiveScore;
    }

    public void setAggressiveScore(int aggressiveScore) {
        this.aggressiveScore = aggressiveScore;
    }
}