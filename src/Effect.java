public class Effect {
    static int delay = 250;
    static String[] symbols = new String[]{".", "..", "...", "....", ".....", "......", ".......", ".........",".........."};

    static void EffectWait() {
        for (int j = 0; j < symbols.length; j++) {
            System.out.print("Идёт процесс загрузки" + symbols[j] + "\r");
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print("Идёт процесс загрузки.........100%\n");
    }

    static void EffectLineStar(int star) {
        System.out.println("*".repeat(star));
    }

    static void printMenu() {
        Effect.EffectLineStar(30);
        System.out.println("""
                Выберите режим работы:\s
                1. Шифрование текста
                2. Расшифровка текста с помощью ключа
                3. Расшифровка текста с помощью brute force (перебор всех вариантов)
                0. Выход из программы.""");
        Effect.EffectLineStar(31);
    }

}
