Программа "Шифр Цезаря"

Программа разработана для выполнения базовых условий итоговой работы 
по модулю "Java Syntax". Она выполняет следующие действия:

1.Читает текст из файла и шифрует его с использованием указанного пользователем ключа.
2.Читает шифрованный текст из файла и расшифровывает его с использованием указанного пользователем ключа.
3.Читает шифрованный текст из файла и методом перебора ключей, 
  используя сравнение результата с часто встречающимися трехбуквенными началами слов, определяет расшифровку текста.
4.Завершает работу программы при выборе цифры "0".
  Проект разработан с использованием описанного каркаса из лекций JavaRush, а также при частых консультациях с ИИ.

Сложности:
Основные трудности при разработке вызвали:
- Работа с файлами (потоки ввода/вывода).
- Обработка исключений.

Класс BruteForce стал наиболее сложным элементом проекта. Идея была взята из лекций JavaRush, 
с добавлением внешнего файла с заготовками начальных букв слов (источник: Google). 
Для упрощения реализации я использовал только один принцип определения правильности текста после расшифровки.
Стоит отметить, что класс BruteForce написан на 95% с использованием ИИ. 
Я лишь отобрал варианты кода, которые действительно понимаю, и адаптировал их для работы в проекте.

Дополнения:
Для шифровки и расшифровки текста я использовал приватный массив букв, 
исключив часто встречающиеся символы, такие как запятые, точки, пробелы и т.д.
Я выбрал вариант, при котором такие символы возвращаются в текст без изменений при шифровании.
Класс Cipher был написан с меньшим участием ИИ, но с частыми консультациями. 
Основные идеи и структура были разработаны мной, а отдельные моменты уточнены с помощью ИИ.

Особенности программы:
Программа имеет следующие особенности, которые я оставил без изменений:
- При шифровке текста из файла результат записывается обратно в файл, при этом оригинал текста затирается.
- При расшифровке текста из файла результат также записывается в файл, заменяя шифрованный текст.
- Программа не записывает в файл результат расшифровки текста методом перебора ключей (BruteForce). 
  Вместо этого результат выводится на экран, что позволяет использовать найденный ключ для проверки
  его правильности в пункте расшифровки с известным ключом.
