package org.example.Players;

import java.util.Random;
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

    private void updatePlayerRelations(int playerNumber, int aggressiveDelta, int diplomacyDelta) {
        players[playerNumber].setAggressiveScore(players[playerNumber].getAggressiveScore() + aggressiveDelta);
        players[playerNumber].setDiplomacyScore(players[playerNumber].getDiplomacyScore() + diplomacyDelta);
        System.out.println("Отношения игрока " + (playerNumber + 1) + " изменились и теперь они составляют: ");
        System.out.println("!!!" + "Агрессивность: " + players[playerNumber].getAggressiveScore() +
                " Дипломатия: " + players[playerNumber].getDiplomacyScore());
    }

    public void firstAction() {
        System.out.println("ВРАГИ В ПРЕДЕЛАХ 1 ЗОНЫ? (1 - Да, 0 - Нет)");
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
                        updatePlayerRelations(playerNumber, -10, -20);
                        System.out.println("!!!Изменение уровня отношений с игроком " + (playerNumber + 1));
                        System.out.println("!!!" + "Агрессивность: " + players[playerNumber].getAggressiveScore() +
                                " Дипломатия: " + players[playerNumber].getDiplomacyScore());
                    } else {
                        System.out.println("НЕВЕРНЫЙ НОМЕР ИГРОКА!");
                    }
                }
                System.out.println("=== ГОТОВЛЮСЬ К ОБОРОНЕ, НО ДВА ОТРЯДА ЗАХВАТЫВАЮТ ОБЛАСТИ ===");
            }
        } else if (isEnemyNear == 0) {
            System.out.println("=== ЗАНИМАЮСЬ ЗАХВАТОМ ОБЛАСТЕЙ ===");
        }
    }

    public void uniqueAction() {
        Random random = new Random();

        System.out.println("Случайное событие произошло!");
        System.out.println("КТО-ТО ХОЧЕТ ЗАХВАТИТЬ ЦЕННЫЕ РЕСУРСЫ? (1 - Да, 0 - Нет)");
        int answer = scanner.nextInt();
            if (answer == 1) {
                System.out.println("У МЕНЯ МАНЫ БОЛЬШЕ ЧЕМ 6? (1 - Да, 0 - Нет)");
                int answer2 = scanner.nextInt();
                System.out.println("ВЫБЕРИТЕ ИГРОКА (Цифру от 1 до " + players.length + "):");
                int playerNumber = scanner.nextInt() - 1; // Индексация с 0
                System.out.println("Выбран игрок: " + (playerNumber + 1));

                if (playerNumber >= 0 && playerNumber < players.length) {
                    if (answer2 == 1) {
                        System.out.println("!!! Я ПРЕДУПРЕЖДАЮ ТЕБЯ ОТСТУПИТЬ И НЕ ЗАХВАТЫВАТЬ!!! (1 - Да, 0 - Нет)");
                        int answer3 = scanner.nextInt();
                        if (answer3 == 1) {
                            System.out.println("=== ДОГОВОРИЛИСЬ! ТЫ НЕ ЗАХВАТЫВАЕШЬ ЭТУ ЗОНУ ===");
                            updatePlayerRelations(playerNumber, 20, 30); // Улучшение отношений
                            System.out.println("+ Наши отношения улучшились! Агрессивность: " + players[playerNumber].getAggressiveScore());
                            System.out.println("+ Наши отношения улучшились! Дипломатия: " + players[playerNumber].getDiplomacyScore());
                        } else {
                        System.out.println("!!! Я УДАРЯЮ ЗАКЛИНАНИЕМ ПО ТВОИМ ЮНИТАМ И УБИВАЮ:" + random.nextInt(3));
                        updatePlayerRelations(playerNumber, -10, -25); // Ухудшение отношений
                            System.out.println("- Наши отношения ухудшились! Агрессивность: " + players[playerNumber].getAggressiveScore());
                            System.out.println("- Наши отношения ухудшились! Дипломатия: " + players[playerNumber].getDiplomacyScore());
                        }
                    }
                } else {
                    System.out.println("НЕВЕРНЫЙ НОМЕР ИГРОКА!");
                }
            } else {
                System.out.println("=== ПРОДОЛЖАЮ ЗАХВАТЫВАТЬ ТЕРРИТОРИИ ===");
            }
    }

    public void getUnits() {
        Random random = new Random();

        System.out.println("В конце хода я покупаю " + random.nextInt(4) + " юнитов");
        if (random.nextInt(100) >= 70) {
            System.out.println("В конце хода я покупаю 1 башню!");
        }
        if (random.nextInt(100) >= 90) {
            System.out.println("В конце хода я покупаю 1 замок(+3)");
        }
    }


    public void checkDiplomacyScore() {
        System.out.println("==================================================================================================");
        int towers = 7;
        int castles = 5;
        int units = 14;
        for (int i = 0; i < players.length; i++) {
            System.out.println("Расчет значений для игрока №" + (i + 1));
            if (players[i].getDiplomacyScore() >= 80) {
                System.out.println("+++ Му добрые соседи! Держи от меня 30 монет! +++");
            } else if (players[i].getDiplomacyScore() >= 50) {
                System.out.println("+ Хочу заключить с тобой союз! и хочу дать тебе в дар 10 монет +++");
            } else if (players[i].getDiplomacyScore() <= -10 && players[i].getDiplomacyScore() > - 25) {
                System.out.println("- Я тебе не доверяю! И укрепляю границы от тебя 2 юнитами");
                units = units -2;
                System.out.println("в запасе осталось " + units + " юнита,ов");
            } else if (players[i].getDiplomacyScore() <= -25 && players[i].getDiplomacyScore() > -40) {
                System.out.println("-- Я тебя опасаюсь и укрепляю границы от тебя еще 1 юнитом и строю 1 башню и  крепость(+3)");
                units = units -1;
                towers = towers -1;
                castles = castles -1;
                System.out.println("в запасе осталось " + units + " юнита,ов и  " + towers + " башен  и " + castles + " крепостей" );
            } else if (players[i].getDiplomacyScore() <= -55 && players[i].getDiplomacyScore() >= -70) {
                System.out.println("--- Я считаю тебя угрозой и укрепляю границы еще 2 юнитами и строю еще 1 башню с крепостью(+3)");
                units = units -2;
                towers = towers -1;
                castles = castles - 1;
                System.out.println("в запасе осталось " + units + " юнита,ов и  " + towers + " башен  и " + castles + " крепостей" );
            } else if (players[i].getDiplomacyScore() <= -90) {
                System.out.println("!!!! Я СЧИТАЮ ТЕБЯ ВРАГОМ, укрепляю границы всеми оставшимися " + units + "юнитами " + " башнями " + towers + " и крепостями(+3) " + castles);
            }
        }
    }

    public void checkWarScore() {
        System.out.println("==================================================================================================");
        for (int i = 0; i < players.length; i++) {
            if (players[i].getAggressiveScore() <= -100) {
                System.out.println("!!!Я ОБЪЯВЛЯЮ ТЕБЕ ВОЙНУ ИГРОКУ " + (i + 1) + " и теперь я часто буду отправлять часть своей армии против твоих территорий!");
            } else {
                System.out.println(" ");
            }
        }
    }
}