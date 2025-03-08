package org.example.Players;

import java.util.Scanner;

public class Explorer {

    Scanner scanner = new Scanner(System.in);
    private final Player[] players;

    public Explorer(int numberOfPlayers) {
        players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player();
        }
    }

    public void firstAction() {
        System.out.println("ВРАГИ В ПРЕДЕЛАХ 2 ЗОН? (1 - Да, 0 - Нет)");
        int isEnemyNear = scanner.nextInt();
        if (isEnemyNear == 1) {
            System.out.println("У МЕНЯ ХВАТАЕТ ОТРЯДОВ? (1 - Да, 0 - Нет)");
            int haveIUnits = scanner.nextInt();
            if (haveIUnits == 1) {
                System.out.println("ЭТО ИГРОК? (1 - Да, 0 - Нет)");
                int isPlayer = scanner.nextInt();
                if (isPlayer == 1) {
                    System.out.println("ВЫБЕРИТЕ ИГРОКА (Цифру от 1 до " + players.length + "):");
                    int playerNumber = scanner.nextInt() - 1; // Индексация с 0
                    if (playerNumber >= 0 && playerNumber < players.length) {
                        players[playerNumber].setDiplomacyScore(players[playerNumber].getDiplomacyScore() - 10);
                        players[playerNumber].setAggressiveScore(players[playerNumber].getAggressiveScore() - 20);
                        System.out.println("!!!Изменение уровня отношений с игроком " + (playerNumber + 1));
                        System.out.println("!!!" + "Агрессивность: " + players[playerNumber].getAggressiveScore() +
                                " Дипломатия: " + players[playerNumber].getDiplomacyScore());
                    } else {
                        System.out.println("НЕВЕРНЫЙ НОМЕР ИГРОКА!");
                    }
                }
                System.out.println("=== ГОТОВЛЮСЬ К ОБОРОНЕ ===");
            }
        } else if (isEnemyNear == 0) {
            System.out.println("=== ЗАНИМАЮСЬ ЗАХВАТОМ ОБЛАСТЕЙ ===");
        }
    }

    public void checkDiplomacyScore() {
        System.out.println("==================================================================================================");
        for (int i = 0; i < players.length; i++) {
            System.out.println(" ");
            System.out.println("Расчет значений для игрока №" + (i + 1));
            if (players[i].getDiplomacyScore() >= 80) {
                System.out.println("+++ Держи от меня помощь в 30 монет! +++");
            } else if (players[i].getDiplomacyScore() >= 50) {
                System.out.println("+++ Хочу заключить с тобой союз! +++");
            } else {
                System.out.println("--- Я тебе не доверяю!");
            }
        }
    }

    public void checkWarScore() {
        System.out.println("==================================================================================================");
        for (int i = 0; i < players.length; i++) {
            System.out.println("Расчет значений для игрока №" + (i + 1));
            if (players[i].getAggressiveScore() <= -100) {
                System.out.println("!!!Я ОБЪЯВЛЯЮ ТЕБЕ ВОЙНУ ИГРОКУ " + (i + 1));
            } else {
                System.out.println("Между нами МИР");
            }
        }
    }
}