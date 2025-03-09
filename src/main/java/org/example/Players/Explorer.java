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
        // Изменяем значения
        int newAggressiveScore = players[playerNumber].getAggressiveScore() + aggressiveDelta;
        int newDiplomacyScore = players[playerNumber].getDiplomacyScore() + diplomacyDelta;

        // Ограничиваем значения в диапазоне от -200 до 200
        newAggressiveScore = Math.max(-200, Math.min(200, newAggressiveScore));
        newDiplomacyScore = Math.max(-200, Math.min(200, newDiplomacyScore));

        // Устанавливаем новые значения
        players[playerNumber].setAggressiveScore(newAggressiveScore);
        players[playerNumber].setDiplomacyScore(newDiplomacyScore);

        // Выводим информацию об изменении отношений
        System.out.println("Отношения игрока " + (playerNumber + 1) + " изменились и теперь они составляют: ");
        System.out.println("!!!" + "Агрессивность: " + players[playerNumber].getAggressiveScore() +
                " Дипломатия: " + players[playerNumber].getDiplomacyScore());
    }


    // Метод проверки, был ли я атакован другими игроками за ход - в итоге я развязываю с ними войну в ответ
    public void doWeAttacked() {
        System.out.println("Я БЫЛ АТАКОВАН ИГРОКОМ? (1 - Да, 0 - Нет)");
        int answer1 = scanner.nextInt();
        if (answer1 == 1) {
            System.out.println("КАКИМ ИГРОКОМ Я АТАКОВАН? ВЫБЕРИТЕ ИГРОКОВ (Цифры от 1 до " + players.length + " через пробел): ");
            scanner.nextLine(); // Очистка буфера
            String input = scanner.nextLine(); // Чтение строки с номерами игроков
            String[] playerNumbers = input.split(" "); // Разделение строки на отдельные номера

            for (String numberStr : playerNumbers) {
                try {
                    int playerNumber = Integer.parseInt(numberStr) - 1; // Индексация с 0
                    if (playerNumber >= 0 && playerNumber < players.length) {
                        updatePlayerRelations(playerNumber, -200, -50);
                        if (players[playerNumber].getAggressiveScore() <= -200) {
                            players[playerNumber].setWar(true); // Меняю флаг войны
                        }
                    } else {
                        System.out.println("НЕВЕРНЫЙ НОМЕР ИГРОКА: " + (playerNumber + 1));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ОШИБКА: Введено не число: " + numberStr);
                }
            }
        }
    }


    // Метод позволяющий прийти к соглашению о мире с рандомным игроком с рандомными условиями
    public void canWeMakePeace() {
        for (int i = 0; i < players.length; i++) { // Используем индекс
            Player player = players[i];
            if (player.isWar()) {
                System.out.println("ОБРАЩАЮСЬ К ИГРОКУ " + (i + 1) + " ХОТИТЕ ЗАКЛЮЧИТЬ МИР? (1 - Да, 0 - Нет)");
                int answer = scanner.nextInt();
                if (answer == 1) {
                    System.out.println("ЗАПЛАТИ МНЕ 50 МОНЕТ ИЛИ ОТДАЙ 1 ПОГРАНИЧНУЮ ТЕРРИТОРИЮ (1 - Да, 0 - Нет)");
                    int answer1 = scanner.nextInt();
                    if (answer1 == 1) {
                        System.out.println("=== ЗАКЛЮЧАЕМ СДЕЛКУ! ТЫ НЕ МОЖЕШЬ НА МЕНЯ НАПАДАТЬ 5 ХОДОВ! ===");
                        System.out.println(" ");

                        player.setWar(false);
                        updatePlayerRelations(i, 200, 50); // Используем индекс игрока
                    } else {
                        System.out.println("=== НЕ УДАЛОСЬ ДОГОВОРИТЬСЯ! ===");
                        System.out.println(" ");

                    }
                }
            }
        }
    }



    public void firstAction() {0
        System.out.println("ВРАГИ В ПРЕДЕЛАХ 1 ЗОНЫ? (1 - Да, 0 - Нет)");
        int isEnemyNear = scanner.nextInt();
        if (isEnemyNear == 1) {
            System.out.println("У МЕНЯ ХВАТАЕТ ОТРЯДОВ? (1 - Да, 0 - Нет)");
            int haveIUnits = scanner.nextInt();
            if (haveIUnits == 1) {
                System.out.println("ЭТО ИГРОК? (1 - Да, 0 - Нет)");
                int isPlayer = scanner.nextInt();
                if (isPlayer == 1) {
                    System.out.println("ВЫБЕРИТЕ ИГРОКОВ (Цифры от 1 до " + players.length + " через пробел):");
                    scanner.nextLine(); // Очистка буфера
                    String input = scanner.nextLine(); // Чтение строки с номерами игроков
                    String[] playerNumbers = input.split(" "); // Разделение строки на отдельные номера

                    for (String numberStr : playerNumbers) {
                        try {
                            int playerNumber = Integer.parseInt(numberStr) - 1; // Индексация с 0
                            if (playerNumber >= 0 && playerNumber < players.length) {
                                updatePlayerRelations(playerNumber, -10, -20);
                            } else {
                                System.out.println("НЕВЕРНЫЙ НОМЕР ИГРОКА: " + (playerNumber + 1));
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("ОШИБКА: Введено не число: " + numberStr);
                        }
                    }
                }

                System.out.println("У МЕНЯ ИМЕЮТСЯ БАШНИ КОТОРЫМИ Я МОГУ АТАКОВАТЬ? (1 - Да, 0 - Нет)");
                int answer1 = scanner.nextInt();
                if (answer1 == 1) {
                    Random random = new Random();
                    if (random.nextInt(100) >= 65 ) {
                        System.out.println("=== СТРЕЛЯЮ БАШНЯМИ ПО ВРАГАМ И УБИВАЮ ПО 1 ЮНИТУ У САМЫХ УГРОЖАЮЩИХ АРМИЙ ЗА КАЖДУЮ БАШНЮ ===");
                        System.out.println(" ");

                    } else {
                        System.out.println("промахнулся");
                    }
                }

                System.out.println("У МЕНЯ ИМЕЕТСЯ МАНА НА ЗАЩИТНЫЕ ЗАКЛИНАНИЯ? (1 - Да, 0 - Нет)");
                int answer2 = scanner.nextInt();
                if (answer2 == 1) {
                    Random random = new Random();
                    if (random.nextInt(100) >= 50) {
                        System.out.println("=== ИСПОЛЬЗУЮ ЗАКЛИНАНИЕ! ===");
                        System.out.println(" ");

                    } else {
                        System.out.println("промахиваюсь заклинанием");
                    }
                } else {
                    System.out.println("не использую заклинание");
                }

                System.out.println("=== ГОТОВЛЮСЬ К ОБОРОНЕ, НО ДВА ОТРЯДА ЗАХВАТЫВАЮТ ОБЛАСТИ ===");
                System.out.println(" ");

            } else {
                System.out.println("=== ОБОРОНЯЮСЬ! ===");
                System.out.println(" ");
            }
        } else if (isEnemyNear == 0) {
            System.out.println("=== ЗАНИМАЮСЬ ЗАХВАТОМ ОБЛАСТЕЙ ===");
            System.out.println(" ");

        }
    }

    public void uniqueAction() {
        Random random = new Random();

        System.out.println("Случайное событие произошло!");
        System.out.println("КТО-ТО ХОЧЕТ ЗАХВАТИТЬ ЦЕННЫЕ РЕСУРСЫ? (1 - Да, 0 - Нет)");
        System.out.println(" ");

        int answer = scanner.nextInt();
            if (answer == 1) {
                System.out.println("У МЕНЯ МАНЫ БОЛЬШЕ ЧЕМ 6? (1 - Да, 0 - Нет)");
                System.out.println(" ");

                int answer2 = scanner.nextInt();
                System.out.println("ВЫБЕРИТЕ ИГРОКА (Цифру от 1 до " + players.length + "):");
                System.out.println(" ");

                int playerNumber = scanner.nextInt() - 1; // Индексация с 0
                System.out.println("Выбран игрок: " + (playerNumber + 1));

                if (playerNumber >= 0 && playerNumber < players.length) {
                    if (answer2 == 1) {
                        System.out.println("!!! Я ПРЕДУПРЕЖДАЮ ТЕБЯ ОТСТУПИТЬ И НЕ ЗАХВАТЫВАТЬ!!! (1 - Да, 0 - Нет)");
                        System.out.println(" ");

                        int answer3 = scanner.nextInt();
                        if (answer3 == 1) {
                            System.out.println("=== ДОГОВОРИЛИСЬ! ТЫ НЕ ЗАХВАТЫВАЕШЬ ЭТУ ЗОНУ ===");
                            System.out.println(" ");

                            updatePlayerRelations(playerNumber, 30, 30); // Улучшение отношений
                        } else {
                        System.out.println("!!! Я УДАРЯЮ ЗАКЛИНАНИЕМ ПО ТВОИМ ЮНИТАМ И УБИВАЮ:" + random.nextInt(4));
                            System.out.println(" ");

                            updatePlayerRelations(playerNumber, -10, -25); // Ухудшение отношений
                        }
                    }
                } else {
                    System.out.println("НЕВЕРНЫЙ НОМЕР ИГРОКА!");
                }
            } else {
                System.out.println("=== ПРОДОЛЖАЮ ЗАХВАТЫВАТЬ ТЕРРИТОРИИ ===");
                System.out.println(" ");

            }
    }

    // Метод используется если ведется война с игроком
    public void attackTargetOnWar() {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        for (int i = 0; i < players.length; i++) { // Проходим по всем игрокам
            Player player = players[i];
            if (player.isWar()) { // Проверяем, ведется ли война с этим игроком
                if (randomNumber >= 80) {
                    System.out.println("=== ФОКУСИРУЮСЬ ПРОТИВ ПРОТИВ ИГРОКА: " + (i + 1) + " ===");
                    System.out.println(" ");

                } else {
                    System.out.println("№1 ТАРГЕТИНГ: Я МОГУ ОПРЕДЕЛИТЬ ПРИОРИТЕТНУЮ ЦЕЛЬ НА ОСНОВЕ ЕГО СИЛЫ? (1 - Да, 0 - Нет)");
                    System.out.println(" ");
                    int answer1 = scanner.nextInt();
                    if (answer1 == 1) {
                        System.out.println("=== ДЕЙСТВУЮ ПРОТИВ СЛАБЕЙШИХ ВРАЖЕСКИХ АРМИЙ, КОТОРАЯ НАХОДИТСЯ ПОБЛИЗОСТИ ОТ МОИХ ТЕРРИТОРИЙ ===");
                        System.out.println(" ");

                        // ВОТ ТУТ ДЛЯ ДРУГОГО ИИ ИГРОКА МОЖНО СДЕЛАТЬ ДРУГИЕ ЗНАЧЕНИЯ ЛИБО ВООБЩЕ СДЕЛАТЬ 100% ЧТО ОН ПОЙДЕТ В АТАКУ БОЛЬШИМ ЧИСЛОМ
                        int random2 = random.nextInt(100);
                        if (random2 > 70) {
                            System.out.println("№2 РАЗВИТИЕ НАСТУПЛЕНИЯ: МОГУ ЛИ Я НАЧАТЬ НАСТУПАТЬ НА ОДНОГО ИЗ ИГРОКА? (1 - Да, 0 - Нет)");
                            int answer2 = scanner.nextInt();
                            if (answer2 == 1) {
                                int units = random.nextInt(4);
                                System.out.println("=== ПРОДОЛЖАЮ НАСТУПЛЕНИЕ ДО " + units + "ЮНИТАМИ ПРОТИВ ИГРОКА С КЕМ ВЕЛ СРАЖЕНИЕ ===");
                                System.out.println(" ");
                            }
                        }
                    } else {
                        System.out.println("=== ЗАНИМАЮ ГЛУХУЮ ОБОРОНУ! ===");
                        System.out.println(" ");

                    }
                }
            }
            break;
        }
    }



    public void getUnits() {
        Random random = new Random();

        System.out.println("В конце хода я покупаю " + random.nextInt(4) + " юнитов");
        if (random.nextInt(100) >= 70) {
            System.out.println("В конце хода я покупаю 1 башню!");
            System.out.println(" ");

        }
        if (random.nextInt(100) >= 90) {
            System.out.println("В конце хода я покупаю 1 замок(+3)");
            System.out.println(" ");

        }
    }

    public void neutralNations() {
        Random random = new Random();

        System.out.println("В конце хода я хожу " + random.nextInt(4) + " отрядами нейтральных народов");
        System.out.println("Восстанавливаю потери " + random.nextInt(4) + " у нейтральных народов");
        System.out.println(" ");

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
            } else if (players[i].getDiplomacyScore() <= -10 && players[i].getDiplomacyScore() > -25) {
                System.out.println("- Я тебе не доверяю! И укрепляю границы от тебя 2 юнитами");
                units = units - 2;
                System.out.println("в запасе осталось " + units + " юнита,ов");
            } else if (players[i].getDiplomacyScore() <= -25 && players[i].getDiplomacyScore() > -40) {
                System.out.println("-- Я тебя опасаюсь и укрепляю границы от тебя еще 1 юнитом и строю 1 башню и  крепость(+3)");
                units = units - 1;
                towers = towers - 1;
                castles = castles - 1;
                System.out.println("в запасе осталось " + units + " юнита,ов и  " + towers + " башен  и " + castles + " крепостей");
            } else if (players[i].getDiplomacyScore() <= -55 && players[i].getDiplomacyScore() >= -70) {
                System.out.println("--- Я считаю тебя угрозой и укрепляю границы еще 2 юнитами и строю еще 1 башню с крепостью(+3)");
                units = units - 2;
                towers = towers - 1;
                castles = castles - 1;
                System.out.println("в запасе осталось " + units + " юнита,ов и  " + towers + " башен  и " + castles + " крепостей");
            } else if (players[i].getDiplomacyScore() <= -90) {
                System.out.println("!!!! Я СЧИТАЮ ТЕБЯ ВРАГОМ, укрепляю границы всеми оставшимися " + units + "юнитами " + " башнями " + towers + " и крепостями(+3) " + castles);
                players[i].setWar(true); // Устанавливаем флаг войны
                players[i].setAggressiveScore(-100);
            }
        }
    }

    public void checkWarScore() {
        for (int i = 0; i < players.length; i++) {
            if (players[i].getAggressiveScore() <= -100) {
                players[i].setWar(true);
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("!!!ВОЙНА С ИГРОКОМ " + (i + 1) + "  я часто буду отправлять часть своей армии против твоих территорий!");
            } else if (players[i].getAggressiveScore() >= 0) {
                players[i].setWar(false);
                System.out.println("### ЗАКЛЮЧАЮ МИР С ИГРОКОМ " + (i+1) + " так как наши отношения достигли нуля");
            } else {
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
            }
        }
    }






}