package org.example;

import org.example.Players.Explorer;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Explorer explorer = new Explorer(2); // количество игроков


        // Цикл для хранения всех изменений в данных игры
        for (int i = 0; i < 100000; i++) {
            explorer.firstAction();

            if (random.nextInt(100) >= 50) {
                explorer.uniqueAction();
            } else {
                System.out.println("Уникальное событие от Открывателя не произошло!");
            }
            explorer.getUnits();
            explorer.checkDiplomacyScore();
            explorer.checkWarScore();

        }

    }
}