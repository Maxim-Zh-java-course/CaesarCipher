import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class BruteForce {

    // Метод для подбора лучшего ключа
    public static int findBestKey(String encryptedText, Set<String> trigrams, Cipher cipher, int maxKeyRange) {
        int maxMatches = 0;
        int bestKey = 0;

        // Перебираем ключи
        for (int key = 1; key <= maxKeyRange; key++) {
            String decryptedText = cipher.decrypt(encryptedText, key);

            // Считаем совпадения
            int matches = countMatches(decryptedText, trigrams);

            if (matches > maxMatches) {
                maxMatches = matches;
                bestKey = key;
            }
        }

        return bestKey;
    }

    // Метод для подсчета совпадений трехбуквенных сочетаний
    public static int countMatches(String text, Set<String> trigrams) {
        int count = 0;

        // Проверяем совпадения трехбуквенных комбинаций
        for (int i = 0; i <= text.length() - 3; i++) {
            String trigram = text.substring(i, i + 3);
            if (trigrams.contains(trigram)) {
                count++;
            }
        }

        return count;
    }

    // Метод для чтения текста из файла
    public static String readTextFromFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }

    // Метод для чтения трехбуквенных сочетаний из файла
    public static Set<String> readTrigramsFromFile(String filePath) throws IOException {
        return new HashSet<>(Files.readAllLines(Path.of(filePath)));
    }
}
