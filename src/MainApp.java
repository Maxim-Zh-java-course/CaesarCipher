import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws InterruptedException, IOException {
        int number;
        Scanner scanner = new Scanner(System.in);

        Effect.EffectWait();
        Effect.EffectLineStar(30);

        Effect.printMenu();

        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера после nextInt()
                switch (number) {
                    case 1 -> {
                        System.out.println("Введите путь к файлу для шифрования:");
                        String filePath = scanner.nextLine();

                        try {
                            String fileContent = FileManager.readFile(filePath);
                            System.out.println("Введите ключ шифрования:");
                            int keyCrypt = scanner.nextInt();
                            scanner.nextLine(); // Очистка буфера после nextInt()

                            Effect.EffectWait();

                            Cipher cipher = new Cipher();
                            FileManager.writeFile(cipher.encrypt(fileContent, keyCrypt), filePath);

                            System.out.println("Процесс успешно завершен."); // Вывод сообщения

                        } catch (IOException e) {
                            System.err.println("Ошибка при чтении файла: " + e.getMessage());
                        }

                        Effect.printMenu();
                    }
                    case 2 -> {
                        System.out.println("Введите путь к файлу для расшифровки:");
                        String filePath = scanner.nextLine();

                        try {
                            String fileContent = FileManager.readFile(filePath);
                            System.out.println("Введите ключ шифрования:");
                            int keyCrypt = scanner.nextInt();
                            scanner.nextLine(); // Очистка буфера после nextInt()

                            Effect.EffectWait();
                            Cipher cipher = new Cipher();
                            FileManager.writeFile(cipher.decrypt(fileContent, keyCrypt), filePath);

                            System.out.println("Процесс успешно завершен.\n"); // Вывод сообщения
                        } catch (IOException e) {
                            System.err.println("Ошибка при чтении файла: " + e.getMessage());
                        }
                        Effect.printMenu();
                    }
                    case 3 -> {
                        System.out.println("Расшифровка текста с помощью brute force (перебор всех вариантов):");

                        Effect.printMenu();
                    }
                    case 0 -> {
                        scanner.close(); // Закрываем Scanner
                        System.out.println("Программа завершена.");
                        return; // Завершение программы
                    }
                    default -> System.out.println("Ошибка: введите 1, 2, 3 или 0");
                }
            } else {
                System.out.println("Ошибка: введите корректное число");
                scanner.next(); // Очистка некорректного ввода
            }
        }
    }
}
