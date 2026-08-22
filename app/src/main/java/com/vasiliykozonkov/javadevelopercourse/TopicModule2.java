package com.vasiliykozonkov.javadevelopercourse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TopicModule2 extends AppCompatActivity {

    private TextView tvTitle, tvTheory, tvCode, tvOutput, tvAnalogy;
    private Button btnRun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic); // Используем тот же дизайн

        tvTitle = findViewById(R.id.tvTitle);
        tvTheory = findViewById(R.id.tvTheory);
        tvCode = findViewById(R.id.tvCode);
        tvOutput = findViewById(R.id.tvOutput);
        tvAnalogy = findViewById(R.id.tvAnalogy);
        btnRun = findViewById(R.id.btnRun);

        int position = getIntent().getIntExtra("position", 0);
        loadTopicData(position);

        btnRun.setOnClickListener(v -> {
            tvOutput.setVisibility(tvOutput.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
        });
    }
	

    private void loadTopicData(int position) {
        switch (position) {
                 
			case 0:
    tvTitle.setText("Исключения");
    tvTheory.setText(
        "**Исключение (Exception)** — событие, нарушающее нормальный ход программы.\n\n" +
        "**Примеры:**\n" +
        "• Деление на ноль\n" +
        "• Обращение к несуществующему элементу массива\n" +
        "• Открытие несуществующего файла\n" +
        "• Вызов метода у null-объекта\n\n" +
        "**Зачем нужны:**\n" +
        "• Отделить обработку ошибок от основной логики\n" +
        "• Предотвратить краш программы\n" +
        "• Дать понятное сообщение об ошибке"
    );
    tvCode.setText(
        "int[] arr = {1, 2, 3};\n" +
        "try {\n" +
        "    System.out.println(arr[5]);\n" +
        "} catch (ArrayIndexOutOfBoundsException e) {\n" +
        "    System.out.println(\"Ошибка: \" + e.getMessage());\n" +
        "}"
    );
    tvOutput.setText("Ошибка: Index 5 out of bounds for length 3");
    tvAnalogy.setText(
        "Аналогия:\n" +
        "Исключение — как сигнал SOS. Программа кричит: «Помогите, я не могу продолжить!» и ждёт, пока кто-то (catch) её спасёт."
    );
    break;

case 1: // Иерархия исключений
    tvTitle.setText("Иерархия исключений");
    tvTheory.setText(
        "Все исключения наследуются от **Throwable**:\n\n" +
        "**Throwable**\n" +
        "├── **Error** — серьёзные проблемы (не ловим!)\n" +
        "│   ├── OutOfMemoryError\n" +
        "│   ── StackOverflowError\n" +
        "── **Exception** — можно обработать\n" +
        "    ├── **RuntimeException** (непроверяемые)\n" +
        "    │   ├── NullPointerException\n" +
        "    │   └── ArithmeticException\n" +
        "    └── **Checked** (проверяемые)\n" +
        "        ├── IOException\n" +
        "        └── FileNotFoundException\n\n" +
        "**Правило:**\n" +
        "• Checked — ОБЯЗАНЫ обработать или объявить в throws\n" +
        "• Unchecked — можно игнорировать (но не стоит!)"
    );
    tvCode.setText(
        "// Checked — нужно обработать\n" +
        "public void readFile() throws IOException {\n" +
        "    FileReader f = new FileReader(\"file.txt\");\n" +
        "}\n\n" +
        "// Unchecked — компилятор не ругается\n" +
        "public void divide(int a, int b) {\n" +
        "    int result = a / b;\n" +
        "}"
    );
    tvOutput.setText(
        "Checked: компилятор заставляет обработать\n" +
        "Unchecked: компилятор молчит, но может упасть"
    );
    tvAnalogy.setText(
        "Аналогия:\n" +
        "• **Error** = землетрясение (ничего не поделаешь)\n" +
        "• **Checked** = платный мост (обязательно заплати или обойди)\n" +
        "• **Unchecked** = скользкий пол (можешь упасть)"
    );
    break;

case 2: // Способы обработки исключений
    tvTitle.setText("Способы обработки исключений");
    tvTheory.setText(
        "Два способа обработки:\n\n" +
        "1️⃣ **try-catch-finally** — обработать самому\n\n" +
        "2️⃣ **throws** — передать обработку выше\n\n" +
        "**Структура:**\n" +
        "• try — код, который может упасть\n" +
        "• catch — что делать при ошибке\n" +
        "• finally — выполнится ВСЕГДА\n\n" +
        "**Можно несколько catch:**\n" +
        "• От частного к общему\n" +
        "• С Java 7: catch (Exc1 | Exc2 e)"
    );
    tvCode.setText(
        "try {\n" +
        "    int x = 10 / 0;\n" +
        "} catch (ArithmeticException e) {\n" +
        "    System.out.println(\"Деление на 0!\");\n" +
        "} catch (Exception e) {\n" +
        "    System.out.println(\"Другая ошибка\");\n" +
        "} finally {\n" +
        "    System.out.println(\"Выполнится всегда\");\n" +
        "}"
    );
    tvOutput.setText(
        "Деление на 0!\n" +
        "Выполнится всегда"
    );
    tvAnalogy.setText(
        "Аналогия:\n" +
        "• **try** = идёшь по льду\n" +
        "• **catch** = если упал — встаёшь\n" +
        "• **finally** = в любом случае дойдёшь до дома\n" +
        "• **throws** = говоришь другу: «Сам разбирайся»"
    );
    break;

case 3: // try с ресурсами
    tvTitle.setText("try с ресурсами");
    tvTheory.setText(
        "**try-with-resources** — автоматическое закрытие ресурсов (Java 7+).\n\n" +
        "Ресурсы закрываются **автоматически**, даже если была ошибка.\n\n" +
        "**Требование:** ресурс должен реализовывать `AutoCloseable`.\n\n" +
        "**Синтаксис:**\n" +
        "```java\n" +
        "try (Ресурс r = new Ресурс()) {\n" +
        "    // работа\n" +
        "} // r.close() вызывается автоматически!\n" +
        "```\n\n" +
        "**Можно несколько ресурсов:**\n" +
        "```java\n" +
        "try (FileReader r1 = ...; BufferedReader r2 = ...) { }\n" +
        "```"
    );
    tvCode.setText(
        "// ДО (старый способ):\n" +
        "FileReader fr = null;\n" +
        "try {\n" +
        "    fr = new FileReader(\"file.txt\");\n" +
        "} finally {\n" +
        "    if (fr != null) fr.close();\n" +
        "}\n\n" +
        "// ПОСЛЕ (try-with-resources):\n" +
        "try (FileReader fr = new FileReader(\"file.txt\")) {\n" +
        "    // работаем\n" +
        "} // fr.close() автоматически!"
    );
    tvOutput.setText(
        "Ресурс закрыт автоматически!\n" +
        "Даже если была ошибка внутри try."
    );
    tvAnalogy.setText(
        "Аналогия:\n" +
        "• **Обычный try** = взял книгу, сам должен вернуть\n" +
        "• **try-with-resources** = библиотекарь сам заберёт книгу"
    );
    break;

case 4: // Ввод-вывод
    tvTitle.setText("Ввод-вывод (I/O)");
    tvTheory.setText(
        "**I/O** — работа с данными: файлы, консоль, сеть.\n\n" +
        "В Java всё I/O построено на **потоках (streams)**:\n\n" +
        "1️⃣ **Байтовые потоки** (byte streams)\n" +
        "   • Работают с байтами (8 бит)\n" +
        "   • Для бинарных данных: картинки, видео\n" +
        "   • Классы: InputStream, OutputStream\n\n" +
        "2️⃣ **Символьные потоки** (character streams)\n" +
        "   • Работают с символами (16 бит, Unicode)\n" +
        "   • Для текста\n" +
        "   • Классы: Reader, Writer\n\n" +
        "**Направление:**\n" +
        "• Input/Reader — ЧИТАТЬ\n" +
        "• Output/Writer — ПИСАТЬ"
    );
    tvCode.setText(
        "// Чтение текста из файла\n" +
        "try (FileReader fr = new FileReader(\"test.txt\")) {\n" +
        "    int c;\n" +
        "    while ((c = fr.read()) != -1) {\n" +
        "        System.out.print((char) c);\n" +
        "    }\n" +
        "}\n\n" +
        "// Запись текста в файл\n" +
        "try (FileWriter fw = new FileWriter(\"out.txt\")) {\n" +
        "    fw.write(\"Привет, мир!\");\n" +
        "}"
    );
    tvOutput.setText(
        "Чтение: Привет, мир!\n" +
        "Запись: файл out.txt создан"
    );
    tvAnalogy.setText(
        "Аналогия с водопроводом:\n" +
        "• **Поток** = труба\n" +
        "• **Input** = вода течёт К тебе\n" +
        "• **Output** = вода течёт ОТ тебя\n" +
        "• **Байтовый** = узкая труба\n" +
        "• **Символьный** = широкая труба"
    );
    break;

case 5: // Классы потоков ввода-вывода
    tvTitle.setText("Классы потоков ввода-вывода");
    tvTheory.setText(
        "**Основные классы I/O:**\n\n" +
        "🔹 **Байтовые:**\n" +
        "• InputStream / OutputStream\n" +
        "• FileInputStream / FileOutputStream\n" +
        "• BufferedInputStream / BufferedOutputStream\n\n" +
        "🔹 **Символьные:**\n" +
        "• Reader / Writer\n" +
        "• FileReader / FileWriter\n" +
        "• BufferedReader / BufferedWriter\n" +
        "• PrintWriter\n\n" +
        "**Буферизованные** (Buffered*) — быстрее, т.к. читают блоками.\n\n" +
        "**Scanner** — удобен для чтения с консоли."
    );
    tvCode.setText(
        "// Чтение с консоли\n" +
        "Scanner sc = new Scanner(System.in);\n" +
        "String name = sc.nextLine();\n\n" +
        "// Буферизованное чтение файла\n" +
        "try (BufferedReader br = new BufferedReader(\n" +
        "        new FileReader(\"file.txt\"))) {\n" +
        "    String line;\n" +
        "    while ((line = br.readLine()) != null) {\n" +
        "        System.out.println(line);\n" +
        "    }\n" +
        "}"
    );
    tvOutput.setText(
        "Ввод: Василий\n" +
        "Вывод: строки файла по одной"
    );
    tvAnalogy.setText(
        "Аналогия:\n" +
        "• **FileReader** = носить воду по стакану\n" +
        "• **BufferedReader** = носить воду ведром (быстрее!)\n" +
        "• **Scanner** = умный кран с насадками"
    );
    break;

case 6: // Правила работы с потоками I/O
    tvTitle.setText("Правила работы с потоками I/O");
    tvTheory.setText(
        "**Золотые правила:**\n\n" +
        "1️⃣ **Всегда закрывай потоки!**\n" +
        "   • Используй try-with-resources\n" +
        "   • Или finally с проверкой на null\n\n" +
        "2️⃣ **Используй буферизацию** для больших данных\n" +
        "   • BufferedReader вместо FileReader\n\n" +
        "3️⃣ **Обрабатывай IOException**\n" +
        "   • Это checked exception\n\n" +
        "4️⃣ **Не держи файлы открытыми долго**\n" +
        "   • Открыл → прочитал → закрыл\n\n" +
        "5️⃣ **Используй правильную кодировку**\n" +
        "   • UTF-8 — стандарт для текста"
    );
    tvCode.setText(
        "// ПРАВИЛЬНО:\n" +
        "try (BufferedReader br = new BufferedReader(\n" +
        "        new InputStreamReader(\n" +
        "            new FileInputStream(\"file.txt\"),\n" +
        "            StandardCharsets.UTF_8))) {\n" +
        "    String line = br.readLine();\n" +
        "}\n\n" +
        "// НЕПРАВИЛЬНО:\n" +
        "FileReader fr = new FileReader(\"file.txt\");\n" +
        "// забыли закрыть! ❌"
    );
    tvOutput.setText(
        "✅ Поток закрыт автоматически\n" +
        "✅ Кодировка UTF-8\n" +
        "✅ Буферизация для скорости"
    );
    tvAnalogy.setText(
        "Аналогия с краном:\n" +
        "• Открыл кран → набрал воду → **закрыл кран**\n" +
        "• Если не закрыть — вода утечет (утечка ресурсов)\n" +
        "• Буфер = ведро (не носи по капле)"
    );
    break;

case 7: // Сериализация
    tvTitle.setText("Сериализация");
    tvTheory.setText(
        "**Сериализация** — превращение объекта в поток байтов для сохранения или передачи.\n\n" +
        "**Десериализация** — обратный процесс.\n\n" +
        "**Как сделать класс сериализуемым:**\n" +
        "1. Реализовать `Serializable`\n" +
        "2. Добавить `serialVersionUID`\n\n" +
        "**`transient`** — поля с этим модификатором НЕ сериализуются.\n\n" +
        "**Зачем нужно:**\n" +
        "• Сохранить состояние объекта в файл\n" +
        "• Передать объект по сети"
    );
    tvCode.setText(
        "class User implements Serializable {\n" +
        "    private static final long serialVersionUID = 1L;\n" +
        "    \n" +
        "    String name;\n" +
        "    transient String password; // не сохранится!\n" +
        "}\n\n" +
        "// Сериализация:\n" +
        "try (ObjectOutputStream oos = new ObjectOutputStream(\n" +
        "        new FileOutputStream(\"user.dat\"))) {\n" +
        "    oos.writeObject(user);\n" +
        "}"
    );
    tvOutput.setText(
        "Объект User сохранён в user.dat\n" +
        "Поле password НЕ сохранено (transient)"
    );
    tvAnalogy.setText(
        "Аналогия:\n" +
        "• **Сериализация** = упаковать мебель для переезда\n" +
        "• **Десериализация** = распаковать на новом месте\n" +
        "• **transient** = личные вещи, которые не упаковываем"
    );
    break;

case 8: // Алгоритмы
    tvTitle.setText("Алгоритмы");
    tvTheory.setText(
        "**Алгоритм** — последовательность шагов для решения задачи.\n\n" +
        "**Свойства хорошего алгоритма:**\n" +
        "• **Дискретность** — чёткие шаги\n" +
        "• **Определённость** — каждый шаг понятен\n" +
        "• **Результативность** — даёт результат\n" +
        "• **Массовость** — работает для класса задач\n" +
        "• **Конечность** — завершается за конечное время\n\n" +
        "**Как оценивать:**\n" +
        "• По времени (сколько шагов)\n" +
        "• По памяти (сколько места)\n" +
        "• Используем **Big O notation**"
    );
    tvCode.setText(
        "// Пример: поиск максимума в массиве\n" +
        "int max(int[] arr) {\n" +
        "    int m = arr[0];\n" +
        "    for (int i = 1; i < arr.length; i++) {\n" +
        "        if (arr[i] > m) m = arr[i];\n" +
        "    }\n" +
        "    return m;\n" +
        "}\n" +
        "// Сложность: O(n) — один проход"
    );
    tvOutput.setText(
        "max([3, 7, 2, 9, 1]) = 9\n" +
        "Сравнений: 4 (n-1)"
    );
    tvAnalogy.setText(
        "Аналогия с рецептом:\n" +
        "• Алгоритм = рецепт блюда\n" +
        "• Входные данные = ингредиенты\n" +
        "• Результат = готовое блюдо\n" +
        "• Сложность = сколько времени готовишь"
    );
    break;

case 9: // Big O notation
    tvTitle.setText("Big O notation");
    tvTheory.setText(
        "**Big O** — как растёт время работы с увеличением данных.\n\n" +
        "**Основные виды (от лучшего к худшему):**\n\n" +
        "• **O(1)** — константа (мгновенно)\n" +
        "  Пример: доступ к элементу массива\n\n" +
        "• **O(log n)** — логарифм (очень быстро)\n" +
        "  Пример: бинарный поиск\n\n" +
        "• **O(n)** — линейно\n" +
        "  Пример: поиск в неотсортированном массиве\n\n" +
        "• **O(n log n)** — линейно-логарифм\n" +
        "  Пример: быстрая сортировка\n\n" +
        "• **O(n²)** — квадратично (медленно)\n" +
        "  Пример: сортировка пузырьком\n\n" +
        "• **O(2ⁿ)** — экспонента (очень медленно)\n" +
        "  Пример: рекурсивный Фибоначчи"
    );
    tvCode.setText(
        "O(1):   arr[5]              // мгновенно\n" +
        "O(log n): бинарный поиск    // 10 элементов → 3 шага\n" +
        "O(n):   for по массиву      // 10 элементов → 10 шагов\n" +
        "O(n²):  два вложенных for   // 10 элементов → 100 шагов\n" +
        "O(2ⁿ):  рекурсия Фибоначчи  // 10 элементов → 1024 шага"
    );
    tvOutput.setText(
        "Для n = 1000:\n" +
        "O(1)     = 1 операция\n" +
        "O(log n) = 10 операций\n" +
        "O(n)     = 1000 операций\n" +
        "O(n²)    = 1 000 000 операций\n" +
        "O(2ⁿ)    = огромное число!"
    );
    tvAnalogy.setText(
        "Аналогия с поиском книги:\n" +
        "• **O(1)** = знаешь точную полку\n" +
        "• **O(log n)** = делишь библиотеку пополам\n" +
        "• **O(n)** = проверяешь каждую полку\n" +
        "• **O(n²)** = для каждой книги проверяешь все полки"
    );
    break;

case 10: // Виды сортировок
    tvTitle.setText("Виды сортировок");
    tvTheory.setText(
        "**Простые (O(n²)):**\n" +
        "• Пузырьковая (Bubble Sort)\n" +
        "• Выбором (Selection Sort)\n" +
        "• Вставками (Insertion Sort)\n\n" +
        "**Эффективные (O(n log n)):**\n" +
        "• Быстрая (Quick Sort)\n" +
        "• Слиянием (Merge Sort)\n" +
        "• Кучей (Heap Sort)\n\n" +
        "**Quick Sort vs Merge Sort:**\n" +
        "• Quick — быстрее на практике, нестабильная\n" +
        "• Merge — стабильная, гарантированно O(n log n)\n" +
        "• Quick — in-place (меньше памяти)\n" +
        "• Merge — требует доп. память"
    );
    tvCode.setText(
        "// Пузырьковая (простая, но медленная)\n" +
        "for (int i = 0; i < arr.length; i++) {\n" +
        "    for (int j = 0; j < arr.length-1-i; j++) {\n" +
        "        if (arr[j] > arr[j+1]) {\n" +
        "            int tmp = arr[j];\n" +
        "            arr[j] = arr[j+1];\n" +
        "            arr[j+1] = tmp;\n" +
        "        }\n" +
        "    }\n" +
        "}"
    );
    tvOutput.setText(
        "[5, 3, 8, 1, 2]\n" +
        "→ [1, 2, 3, 5, 8]\n\n" +
        "Quick Sort: ~15 сравнений\n" +
        "Bubble Sort: ~25 сравнений"
    );
    tvAnalogy.setText(
        "Аналогия с картами:\n" +
        "• **Bubble** = сравниваешь соседние карты\n" +
        "• **Quick** = берёшь одну карту, раскладываешь остальные по сторонам\n" +
        "• **Merge** = делишь колоду пополам, сортируешь, сливаешь"
    );
    break;

case 11: // Generics
    tvTitle.setText("Generics (Обобщения)");
    tvTheory.setText(
        "**Generics** — параметризация типов. Код работает с разными типами безопасно.\n\n" +
        "**Зачем нужны:**\n" +
        "• Безопасность типов (проверка на компиляции)\n" +
        "• Избавление от casting\n" +
        "• Переиспользование кода\n\n" +
        "**Синтаксис:**\n" +
        "• `<T>` — тип-параметр (Type)\n" +
        "• `<E>` — элемент (Element)\n" +
        "• `<K, V>` — ключ и значение\n\n" +
        "**Ограничения:**\n" +
        "• `<T extends Number>` — только Number и наследники"
    );
    tvCode.setText(
        "// Без generics (плохо):\n" +
        "List list = new ArrayList();\n" +
        "list.add(\"Hello\");\n" +
        "String s = (String) list.get(0);\n\n" +
        "// С generics (хорошо):\n" +
        "List<String> list = new ArrayList<>();\n" +
        "list.add(\"Hello\");\n" +
        "String s = list.get(0);\n\n" +
        "// Свой generic-класс:\n" +
        "class Box<T> {\n" +
        "    private T value;\n" +
        "    public T get() { return value; }\n" +
        "}"
    );
    tvOutput.setText(
        "Box<Integer> intBox = new Box<>();\n" +
        "intBox.value = 42;\n" +
        "Integer x = intBox.get(); // 42"
    );
    tvAnalogy.setText(
        "Аналогия с коробкой:\n" +
        "• **Без generics** = коробка «всё подряд»\n" +
        "• **С generics** = коробка «только книги»\n" +
        "• Компилятор не даст положить ботинок!"
    );
    break;

case 12: // Коллекции
    tvTitle.setText("Коллекции");
    tvTheory.setText(
        "**Коллекции** — структуры для хранения групп объектов (java.util.*).\n\n" +
        "**Три основных типа:**\n" +
        "1️⃣ **List** — упорядоченный список, могут быть дубликаты\n" +
        "2️⃣ **Set** — множество, БЕЗ дубликатов\n" +
        "3️⃣ **Map** — пары ключ-значение\n\n" +
        "**Зачем вместо массивов:**\n" +
        "• Динамический размер\n" +
        "• Много готовых методов\n" +
        "• Удобные алгоритмы"
    );
    tvCode.setText(
        "// List — упорядоченный, с дубликатами\n" +
        "List<String> list = new ArrayList<>();\n" +
        "list.add(\"A\"); list.add(\"B\"); list.add(\"A\");\n" +
        "// [A, B, A]\n\n" +
        "// Set — без дубликатов\n" +
        "Set<String> set = new HashSet<>();\n" +
        "set.add(\"A\"); set.add(\"B\"); set.add(\"A\");\n" +
        "// [A, B]\n\n" +
        "// Map — ключ-значение\n" +
        "Map<String, Integer> map = new HashMap<>();\n" +
        "map.put(\"Вася\", 35);"
    );
    tvOutput.setText(
        "List: [A, B, A] — 3 элемента\n" +
        "Set:  [A, B]    — 2 элемента\n" +
        "Map:  {Вася=35}"
    );
    tvAnalogy.setText(
        "Аналогия:\n" +
        "• **List** = очередь в магазине\n" +
        "• **Set** = набор уникальных марок\n" +
        "• **Map** = телефонная книга"
    );
    break;

case 13: // Иерархия коллекций
    tvTitle.setText("Иерархия коллекций");
    tvTheory.setText(
        "**Интерфейсы:**\n\n" +
        "```\n" +
        "Iterable\n" +
        "  └── Collection\n" +
        "        ├── List\n" +
        "        │     ├── ArrayList\n" +
        "        │     └── LinkedList\n" +
        "        ├── Set\n" +
        "        │     ├── HashSet\n" +
        "        │     └── TreeSet\n" +
        "        └── Queue\n" +
        "\n" +
        "Map (отдельно!)\n" +
        "  ├── HashMap\n" +
        "  ├── LinkedHashMap\n" +
        "  └── TreeMap\n" +
        "```\n\n" +
        "**Map НЕ является Collection!** Но часть фреймворка."
    );
    tvCode.setText(
        "List<String> list = new ArrayList<>();\n" +
        "List<String> linked = new LinkedList<>();\n\n" +
        "Set<Integer> set = new HashSet<>();\n" +
        "Set<Integer> tree = new TreeSet<>();\n\n" +
        "Map<String, Integer> map = new HashMap<>();\n" +
        "Map<String, Integer> treeMap = new TreeMap<>();"
    );
    tvOutput.setText(
        "List → ArrayList (быстрый доступ)\n" +
        "List → LinkedList (быстрые вставки)\n" +
        "Set → HashSet (быстрый поиск)\n" +
        "Map → HashMap (быстрый поиск по ключу)"
    );
    tvAnalogy.setText(
        "Аналогия с транспортом:\n" +
        "• **Collection** = «транспортное средство»\n" +
        "• **List** = «машина»\n" +
        "• **ArrayList** = «спорткар» (быстрый)\n" +
        "• **LinkedList** = «поезд» (легко добавить вагон)"
    );
    break;

case 14: // List
    tvTitle.setText("List (Список)");
    tvTheory.setText(
        "**List** — упорядоченная коллекция, допускает дубликаты.\n\n" +
        "**ArrayList**\n" +
        "• Внутри: массив\n" +
        "• Быстрый доступ по индексу: O(1)\n" +
        "• Медленные вставки в середине: O(n)\n\n" +
        "**LinkedList**\n" +
        "• Внутри: двусвязный список\n" +
        "• Быстрые вставки/удаления: O(1)\n" +
        "• Медленный доступ по индексу: O(n)\n\n" +
        "**Методы:** add(), get(i), set(i, val), remove(i), size()"
    );
    tvCode.setText(
        "List<String> list = new ArrayList<>();\n" +
        "list.add(\"Яблоко\");\n" +
        "list.add(\"Банан\");\n" +
        "list.add(1, \"Апельсин\");\n\n" +
        "System.out.println(list.get(0)); // Яблоко\n" +
        "System.out.println(list.size()); // 3\n" +
        "list.remove(1);\n\n" +
        "for (String s : list) {\n" +
        "    System.out.println(s);\n" +
        "}"
    );
    tvOutput.setText(
        "Яблоко\n" +
        "3\n" +
        "Яблоко\n" +
        "Банан"
    );
    tvAnalogy.setText(
        "Аналогия:\n" +
        "• **ArrayList** = полка с книгами (быстро взять, трудно вставить)\n" +
        "• **LinkedList** = цепочка людей (легко встать, трудно найти 100-го)"
    );
    break;

case 15: // Set
    tvTitle.setText("Set (Множество)");
    tvTheory.setText(
        "**Set** — коллекция БЕЗ дубликатов.\n\n" +
        "**HashSet**\n" +
        "• Быстрый поиск: O(1)\n" +
        "• Порядок НЕ гарантирован\n" +
        "• Требует equals() и hashCode()\n\n" +
        "**LinkedHashSet**\n" +
        "• Сохраняет порядок ВСТАВКИ\n\n" +
        "**TreeSet**\n" +
        "• Сортирует элементы\n" +
        "• Поиск: O(log n)\n\n" +
        "**Методы:** add(), remove(), contains(), size()"
    );
    tvCode.setText(
        "Set<String> set = new HashSet<>();\n" +
        "set.add(\"A\"); set.add(\"B\"); set.add(\"A\");\n" +
        "System.out.println(set); // [A, B]\n\n" +
        "Set<String> linked = new LinkedHashSet<>();\n" +
        "linked.add(\"C\"); linked.add(\"A\"); linked.add(\"B\");\n" +
        "System.out.println(linked); // [C, A, B]\n\n" +
        "Set<Integer> tree = new TreeSet<>();\n" +
        "tree.add(3); tree.add(1); tree.add(2);\n" +
        "System.out.println(tree); // [1, 2, 3]"
    );
    tvOutput.setText(
        "HashSet: [A, B]\n" +
        "LinkedHashSet: [C, A, B]\n" +
        "TreeSet: [1, 2, 3]"
    );
    tvAnalogy.setText(
        "Аналогия:\n" +
        "• **HashSet** = мешок с уникальными камнями\n" +
        "• **LinkedHashSet** = очередь (кто первый встал)\n" +
        "• **TreeSet** = полка по алфавиту"
    );
    break;

case 16: // Map
    tvTitle.setText("Map (Словарь)");
    tvTheory.setText(
        "**Map** — пары ключ-значение. Ключи уникальны!\n\n" +
        "**HashMap**\n" +
        "• Быстрый поиск: O(1)\n" +
        "• Порядок НЕ гарантирован\n" +
        "• Может хранить один null-ключ\n\n" +
        "**LinkedHashMap** — сохраняет порядок вставки\n\n" +
        "**TreeMap** — сортирует по ключу, O(log n)\n\n" +
        "**Методы:** put(), get(), remove(), containsKey(), keySet(), entrySet()"
    );
    tvCode.setText(
        "Map<String, Integer> map = new HashMap<>();\n" +
        "map.put(\"Вася\", 35);\n" +
        "map.put(\"Петя\", 25);\n" +
        "map.put(\"Маша\", 30);\n\n" +
        "System.out.println(map.get(\"Вася\")); // 35\n" +
        "map.put(\"Вася\", 36); // перезапись!\n\n" +
        "for (Map.Entry<String, Integer> e : map.entrySet()) {\n" +
        "    System.out.println(e.getKey() + \" = \" + e.getValue());\n" +
        "}"
    );
    tvOutput.setText(
        "35\n" +
        "Вася = 36\n" +
        "Петя = 25\n" +
        "Маша = 30"
    );
    tvAnalogy.setText(
        "Аналогия:\n" +
        "• **Map** = словарь (слово → перевод)\n" +
        "• **HashMap** = без порядка\n" +
        "• **LinkedHashMap** = в порядке добавления\n" +
        "• **TreeMap** = по алфавиту"
    );
    break;

case 17: // Временная сложность коллекций
    tvTitle.setText("Временная сложность коллекций");
    tvTheory.setText(
        "**Сравнение:**\n\n" +
        "| Операция | ArrayList | LinkedList | HashSet | TreeSet |\n" +
        "|---|---|---|---|---|\n" +
        "| get(i) | O(1) | O(n) | - | O(log n) |\n" +
        "| add() | O(1)* | O(1) | O(1) | O(log n) |\n" +
        "| remove(i) | O(n) | O(1) | O(1) | O(log n) |\n" +
        "| contains() | O(n) | O(n) | O(1) | O(log n) |\n\n" +
        "*O(1) в среднем\n\n" +
        "| Операция | HashMap | TreeMap |\n" +
        "|---|---|---|\n" +
        "| get/put | O(1) | O(log n) |\n\n" +
        "**Вывод:** для большинства задач — ArrayList и HashMap!"
    );
    tvCode.setText(
        "// Когда что использовать:\n\n" +
        "// Частый доступ по индексу → ArrayList\n" +
        "List<String> list = new ArrayList<>();\n\n" +
        "// Частые вставки в середину → LinkedList\n" +
        "List<String> linked = new LinkedList<>();\n\n" +
        "// Уникальные элементы → HashSet\n" +
        "Set<String> set = new HashSet<>();\n\n" +
        "// Пары ключ-значение → HashMap\n" +
        "Map<String, Integer> map = new HashMap<>();"
    );
    tvOutput.setText(
        "1000 элементов:\n" +
        "ArrayList.get(500)   → мгновенно\n" +
        "LinkedList.get(500)  → 500 шагов\n" +
        "HashSet.contains()   → мгновенно\n" +
        "TreeSet.contains()   → 10 шагов"
    );
    tvAnalogy.setText(
        "Аналогия с поиском человека:\n" +
        "• **ArrayList** = знаешь номер дома → сразу нашёл\n" +
        "• **LinkedList** = идёшь от первого дома\n" +
        "• **HashSet** = есть список с фото → сразу узнал\n" +
        "• **TreeSet** = ищешь в телефонной книге"
    );
    break;

case 18: // Неизменяемые коллекции
    tvTitle.setText("Неизменяемые коллекции");
    tvTheory.setText(
        "**Immutable коллекции** — нельзя добавить, удалить или изменить после создания.\n\n" +
        "**Способы создания:**\n\n" +
        "1️⃣ **Методы `.of()`** (Java 9+):\n" +
        "   • `List.of(...)`, `Set.of(...)`, `Map.of(...)`\n\n" +
        "2️⃣ **`Collections.unmodifiable...()`**:\n" +
        "   • `Collections.unmodifiableList(list)`\n\n" +
        "**Зачем нужны:**\n" +
        "• Безопасность\n" +
        "• Можно использовать как константы\n" +
        "• Потокобезопасность"
    );
    tvCode.setText(
        "// Java 9+ способ:\n" +
        "List<String> list = List.of(\"A\", \"B\", \"C\");\n" +
        "Set<Integer> set = Set.of(1, 2, 3);\n" +
        "Map<String, Integer> map = Map.of(\n" +
        "    \"Вася\", 35, \"Петя\", 25\n" +
        ");\n\n" +
        "// Старый способ:\n" +
        "List<String> mutable = new ArrayList<>();\n" +
        "mutable.add(\"A\");\n" +
        "List<String> immutable = \n" +
        "    Collections.unmodifiableList(mutable);\n\n" +
        "immutable.add(\"B\"); // UnsupportedOperationException!"
    );
    tvOutput.setText(
        "list = [A, B, C]\n" +
        "Попытка добавить → ошибка!\n" +
        "Коллекция защищена от изменений"
    );
    tvAnalogy.setText(
        "Аналогия:\n" +
        "• **Обычная коллекция** = доска для записей\n" +
        "• **Неизменяемая** = высечено в камне\n" +
        "• Как String, только для коллекций"
    );
    break;

case 19: // LinkedHashMap, TreeMap
    tvTitle.setText("LinkedHashMap и TreeMap");
    tvTheory.setText(
        "**LinkedHashMap** — HashMap + порядок вставки.\n" +
        "• Сохраняет порядок добавления\n" +
        "• Поиск: O(1)\n" +
        "• Чуть больше памяти\n\n" +
        "**TreeMap** — отсортированный Map.\n" +
        "• Ключи всегда отсортированы\n" +
        "• Поиск: O(log n)\n" +
        "• Методы: firstKey(), lastKey(), subMap()\n\n" +
        "**Когда использовать:**\n" +
        "• LinkedHashMap — когда важен порядок (кэш LRU)\n" +
        "• TreeMap — когда нужна сортировка по ключу"
    );
    tvCode.setText(
        "Map<String, Integer> linked = new LinkedHashMap<>();\n" +
        "linked.put(\"C\", 3);\n" +
        "linked.put(\"A\", 1);\n" +
        "linked.put(\"B\", 2);\n" +
        "// {C=3, A=1, B=2}\n\n" +
        "Map<String, Integer> tree = new TreeMap<>();\n" +
        "tree.put(\"C\", 3);\n" +
        "tree.put(\"A\", 1);\n" +
        "tree.put(\"B\", 2);\n" +
        "// {A=1, B=2, C=3}"
    );
    tvOutput.setText(
        "LinkedHashMap: {C=3, A=1, B=2}\n" +
        "TreeMap: {A=1, B=2, C=3}\n\n" +
        "tree.firstKey() → A\n" +
        "tree.lastKey()  → C"
    );
    tvAnalogy.setText(
        "Аналогия:\n" +
        "• **LinkedHashMap** = гости пришли в порядке: Вася, Петя, Маша\n" +
        "• **TreeMap** = гостей рассадил по алфавиту"
    );
    break;

case 20: // Comparable и Comparator
    tvTitle.setText("Comparable и Comparator");
    tvTheory.setText(
        "Два интерфейса для сортировки:\n\n" +
        "**Comparable<T>** — «естественный» порядок\n" +
        "• Метод: `int compareTo(T o)`\n" +
        "• Встраивается в сам класс\n" +
        "• Пример: String, Integer реализуют Comparable\n\n" +
        "**Comparator<T>** — «внешний» порядок\n" +
        "• Метод: `int compare(T o1, T o2)`\n" +
        "• Отдельный класс/лямбда\n" +
        "• Можно несколько сортировок\n\n" +
        "**Правило:**\n" +
        "• Comparable — когда порядок очевиден\n" +
        "• Comparator — когда нужно несколько вариантов"
    );
    tvCode.setText(
        "// Comparable — в самом классе\n" +
        "class User implements Comparable<User> {\n" +
        "    String name; int age;\n" +
        "    public int compareTo(User u) {\n" +
        "        return this.age - u.age;\n" +
        "    }\n" +
        "}\n\n" +
        "// Comparator — отдельно\n" +
        "Comparator<User> byName = (u1, u2) -> \n" +
        "    u1.name.compareTo(u2.name);\n\n" +
        "Collections.sort(users);  // по age\n" +
        "users.sort(byName);       // по name"
    );
    tvOutput.setText(
        "По age: [Петя(20), Вася(35), Маша(40)]\n" +
        "По name: [Вася(35), Маша(40), Петя(20)]"
    );
    tvAnalogy.setText(
        "Аналогия:\n" +
        "• **Comparable** = у человека есть паспорт (естественный порядок)\n" +
        "• **Comparator** = ты решаешь, как сортировать: по имени, возрасту, росту"
    );
    break;

case 21: // Лямбды и Stream API
    tvTitle.setText("Лямбды и Stream API");
    tvTheory.setText(
        "**Лямбда** — короткая запись анонимной функции.\n" +
        "**Синтаксис:** `(параметры) -> тело`\n\n" +
        "**Примеры:**\n" +
        "• `() -> System.out.println(\"Привет\")`\n" +
        "• `(x, y) -> x + y`\n\n" +
        "**Stream API** — обработка коллекций.\n\n" +
        "**Цепочка:**\n" +
        "1. **Источник** → `list.stream()`\n" +
        "2. **Промежуточные**: filter(), map(), sorted()\n" +
        "3. **Терминальная**: collect(), forEach(), count()\n\n" +
        "**Преимущества:**\n" +
        "• Декларативный стиль\n" +
        "• Легко параллелить: `.parallelStream()`"
    );
    tvCode.setText(
        "List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9,10);\n\n" +
        "// Сумма чётных > 3\n" +
        "int sum = nums.stream()\n" +
        "    .filter(n -> n % 2 == 0)\n" +
        "    .filter(n -> n > 3)\n" +
        "    .mapToInt(n -> n)\n" +
        "    .sum();  // 4+6+8+10 = 28\n\n" +
        "// В верхний регистр\n" +
        "List<String> upper = names.stream()\n" +
        "    .map(s -> s.toUpperCase())\n" +
        "    .collect(Collectors.toList());"
    );
    tvOutput.setText(
        "nums: [1,2,3,4,5,6,7,8,9,10]\n" +
        "Чётные > 3: [4, 6, 8, 10]\n" +
        "Сумма: 28\n\n" +
        "[\"вася\", \"петя\"] → [\"ВАСЯ\", \"ПЕТЯ\"]"
    );
    tvAnalogy.setText(
        "Аналогия с конвейером:\n" +
        "• **stream()** = запустили конвейер\n" +
        "• **filter()** = отбраковали неподходящие\n" +
        "• **map()** = обработали каждую деталь\n" +
        "• **collect()** = сложили в коробку готовое"
    );
    break;
	
	case 22: // Stream API — Шпаргалка
    tvTitle.setText("Stream API — Полная шпаргалка");
    tvTheory.setText(
        "**Stream API** — функциональный подход к обработке коллекций (Java 8+).\n\n" +
        
        "**I. СПОСОБЫ СОЗДАНИЯ СТРИМОВ:**\n" +
        "1. collection.stream() — из коллекции\n" +
        "2. Stream.of(\"a1\",\"a2\") — из значений\n" +
        "3. Arrays.stream(array) — из массива\n" +
        "4. Stream.iterate(1, n->n+1) — бесконечный\n" +
        "5. Stream.generate(() -> \"x\") — генерация\n\n" +
        
        "**II. КОНВЕЙЕРНЫЕ МЕТОДЫ** (возвращают Stream):\n" +
        "• filter() — отбор по условию\n" +
        "• map() — преобразование\n" +
        "• flatMap() — разбить на несколько\n" +
        "• distinct() — убрать дубликаты\n" +
        "• sorted() — сортировка\n" +
        "• limit(n) / skip(n) — ограничение\n" +
        "• peek() — применить функцию\n\n" +
        
        "**III. ТЕРМИНАЛЬНЫЕ МЕТОДЫ** (завершают стрим):\n" +
        "• collect() — сбор в коллекцию\n" +
        "• forEach() — выполнить действие\n" +
        "• count() — количество\n" +
        "• findFirst() / findAny() — поиск\n" +
        "• anyMatch() / allMatch() / noneMatch()\n" +
        "• reduce() — агрегатная функция\n" +
        "• toArray() — в массив\n\n" +
        
        "**IV. COLLECTORS:**\n" +
        "• toList(), toSet(), toMap()\n" +
        "• groupingBy() — группировка\n" +
        "• partitioningBy() — разделение\n" +
        "• joining() — объединение строк\n" +
        "• summingInt(), averagingInt()"
    );
    tvCode.setText(
        "// 1. Создание стримов\n" +
        "List<String> list = Arrays.asList(\"a1\",\"a2\",\"a3\");\n" +
        "list.stream();\n" +
        "Stream.of(\"a1\",\"a2\");\n" +
        "Stream.iterate(1, n -> n + 1).limit(5);\n\n" +
        
        "// 2. Фильтрация и поиск\n" +
        "list.stream()\n" +
        "    .filter(s -> s.contains(\"1\"))\n" +
        "    .findFirst()\n" +
        "    .orElse(\"empty\");\n\n" +
        
        "// 3. Преобразование\n" +
        "list.stream()\n" +
        "    .map(String::toUpperCase)\n" +
        "    .collect(Collectors.toList());\n\n" +
        
        "// 4. Группировка\n" +
        "Map<Boolean, List<String>> parts = list.stream()\n" +
        "    .collect(Collectors.partitioningBy(\n" +
        "        s -> s.startsWith(\"a\")\n" +
        "    ));\n\n" +
        
        "// 5. Агрегация\n" +
        "List<Integer> nums = Arrays.asList(1,2,3,4,5);\n" +
        "int sum = nums.stream()\n" +
        "    .filter(n -> n % 2 == 0)\n" +
        "    .mapToInt(n -> n)\n" +
        "    .sum();  // 2+4 = 6\n\n" +
        
        "// 6. Свой Collector\n" +
        "String result = list.stream()\n" +
        "    .collect(Collectors.joining(\", \", \"[\", \"]\"));"
    );
    tvOutput.setText(
        "Примеры вывода:\n\n" +
        
        "filter + findFirst:\n" +
        "  [a1, a2, a3] → a1\n\n" +
        
        "map + toList:\n" +
        "  [a1, a2, a3] → [A1, A2, A3]\n\n" +
        
        "partitioningBy:\n" +
        "  true=[a1, a2, a3]\n" +
        "  false=[]\n\n" +
        
        "sum чётных:\n" +
        "  [1,2,3,4,5] → 6\n\n" +
        
        "joining:\n" +
        "  [a1, a2, a3] → \"[a1, a2, a3]\""
    );
    tvAnalogy.setText(
        "Аналогия с заводским конвейером:\n\n" +
        
        "• **stream()** = запустили ленту конвейера 🏭\n" +
        "• **filter()** = контролёр отбраковывает детали \n" +
        "• **map()** = станок обрабатывает каждую деталь \n" +
        "• **sorted()** = робот раскладывает по порядку \n" +
        "• **collect()** = упаковщик складывает в коробки \n\n" +
        
        "**Важно:**\n" +
        "✅ Стрим можно использовать только ОДИН раз!\n" +
        "✅ Конвейерные методы НЕ выполняют работу пока нет терминального\n" +
        "✅ Параллельные стримы — только для коротких операций\n" +
        "✅ flatMap — когда один элемент превращается в несколько"
    );
    break;

            default:
                tvTitle.setText("Тема в разработке");
                tvTheory.setText("Эта тема скоро появится!");
                tvCode.setText("// Скоро...");
                tvOutput.setText("Результат будет здесь");
                tvAnalogy.setText("Загляни позже!");
                break;
        }
        setTitle((position + 1) + ". " + tvTitle.getText());
    }
}