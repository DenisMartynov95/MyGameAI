package org.example;

import org.example.Players.Explorer;

public class Main {
    public static void main(String[] args) {
        Explorer explorer = new Explorer(3); // 4 игрока


        // Цикл для хранения всех изменений в данных игры
        for (int i = 0; i < 100000; i++) {
            explorer.firstAction();
            explorer.checkDiplomacyScore();
            explorer.checkWarScore();

        }

    }
}