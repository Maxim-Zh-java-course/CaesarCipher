public class Cipher {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я'};

    public String encrypt(String text, int shift) {
        char[] encrypted = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = findIndexInAlphabet(c);

            // Исправление: обработка символов, не входящих в алфавит
            if (index == -1) {
                encrypted[i] = c; // Оставляем символ без изменений
              continue;
            }

            int newIndex = (index + shift) % ALPHABET.length;
            encrypted[i] = ALPHABET[newIndex]; // Добавляем символ в массив
        }
        return new String(encrypted); // Преобразуем массив в строку
    }



public String decrypt(String text, int shift) {
    char[] decrypted = new char[text.length()];
    for (int i = 0; i < text.length(); i++) {
        char c = text.charAt(i);
        int index = findIndexInAlphabet(c);
        // Исправление: обработка символов, не входящих в алфавит
        if (index == -1) {
            decrypted[i] = c; // Оставляем символ без изменений
            continue;
        }

        // Исправление: обработка отрицательных индексов
        int newIndex = (index - shift) % ALPHABET.length;
        if (newIndex < 0) {
            newIndex += ALPHABET.length;
        }

        decrypted[i] = ALPHABET[newIndex]; // Добавляем символ в массив
    }
    return new String(decrypted); // Преобразуем массив в строку
}


    private int findIndexInAlphabet(char c) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if (ALPHABET[i] == c) {
                return i;
            }
        }
        return -1; // Если символ не найден
    }


}
