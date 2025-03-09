package org.example.Players;

public class Player {
    private int diplomacyScore;
    private int aggressiveScore;
    private boolean isWar; // Создал переменную-флаг который будет работать при -200 дипломатии и в методах canWeMakePeace doWeAttacked


    public Player() {
        this.diplomacyScore = 0; // Начальное значение
        this.aggressiveScore = 0; // Начальное значение
        this.isWar = false;
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

    public boolean isWar() {
        return isWar;
    }

    public void setWar(boolean war) {
        isWar = war;
    }
}