public class Effect {
    static private final int DELAY = 250;
    static private final String[] SYMBOLS = new String[]{".", "..", "...", "....", ".....", "......", ".......", ".........",".........."};

    static void EffectWait() {
        for (String symbol : SYMBOLS) {
            System.out.print("Идёт процесс загрузки" + symbol + "\r");
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print("Идёт процесс загрузки.........100%\n");
    }

    static void EffectLineStar(int star) {
        System.out.println("*".repeat(star));
    }
// IDE подсказала как можно по другому выстроить длинный sout - красиво !!!
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
