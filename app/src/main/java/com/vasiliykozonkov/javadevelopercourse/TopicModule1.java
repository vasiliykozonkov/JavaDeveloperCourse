package com.vasiliykozonkov.javadevelopercourse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TopicModule1 extends AppCompatActivity {

    private TextView tvTitle, tvTheory, tvCode, tvOutput, tvAnalogy;
    private Button btnRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        tvTitle = findViewById(R.id.tvTitle);
        tvTheory = findViewById(R.id.tvTheory);
        tvCode = findViewById(R.id.tvCode);
        tvOutput = findViewById(R.id.tvOutput);
        tvAnalogy = findViewById(R.id.tvAnalogy);
        btnRun = findViewById(R.id.btnRun);

        int position = getIntent().getIntExtra("position", 0);
        loadTopicData(position);

        btnRun.setOnClickListener(v -> {
            tvOutput.setVisibility(
                tvOutput.getVisibility() == View.GONE ? View.VISIBLE : View.GONE
            );
        });
    }

    private void loadTopicData(int position) {
        switch (position) {
            

            case 0: // Какие языки программирования бывают
                tvTitle.setText("Виды языков программирования");
                tvTheory.setText(
                    "Языки делятся по уровню абстракции и способу выполнения:\n\n" +
                    "1️⃣ **По уровню:**\n" +
                    "• Низкоуровневые (Assembler) — близки к машинному коду\n" +
                    "• Высокоуровневые (Java, Python, C++) — понятны человеку\n\n" +
                    "2️ **По способу выполнения:**\n" +
                    "• Компилируемые (C, C++, Go) → машинный код\n" +
                    "• Интерпретируемые (Python, JavaScript) → построчно\n" +
                    "• Гибридные (Java, C#) → байт-код + виртуальная машина\n\n" +
                    "**Java — гибридный язык:** компилируется в байт-код (.class), " +
                    "который выполняется JVM. Это даёт кроссплатформенность."
                );
                tvCode.setText(
                    "// C++ (компилируемый):\n" +
                    "#include <iostream>\n" +
                    "int main() {\n" +
                    "    cout << \"Hello\";\n" +
                    "    return 0;\n" +
                    "}\n\n" +
                    "// Java (гибридный):\n" +
                    "public class Hello {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        System.out.println(\"Hello\");\n" +
                    "    }\n" +
                    "}"
                );
                tvOutput.setText("Java: Write Once, Run Anywhere");
                tvAnalogy.setText(
                    "Аналогия с книгами:\n" +
                    "• **C++** = книга на русском (нужен русскоязычный читатель)\n" +
                    "• **Python** = аудиокнига (читает диктор-интерпретатор)\n" +
                    "• **Java** = книга на эсперанто (универсальный язык, " +
                    "понятный всем, кто его изучил)"
                );
                break;
                
            case 1: // JVM, JRE, JDK
                tvTitle.setText("JVM, JRE, JDK");
                tvTheory.setText(
                    "Java состоит из трёх уровней, как матрёшка:\n\n" +
                    "• **JVM** (Java Virtual Machine) — виртуальная машина, " +
                    "которая выполняет байт-код. Это «двигатель» Java.\n\n" +
                    "• **JRE** (Java Runtime Environment) = JVM + библиотеки классов. " +
                    "Нужна, чтобы ЗАПУСКАТЬ программы.\n\n" +
                    "• **JDK** (Java Development Kit) = JRE + компилятор (javac) + " +
                    "инструменты разработчика. Нужна, чтобы ПИСАТЬ программы.\n\n" +
                    "**Запомни формулу:**\n" +
                    "JDK = JRE + компилятор\n" +
                    "JRE = JVM + библиотеки"
                );
                tvCode.setText(
                    "// Компиляция:\n" +
                    "javac HelloWorld.java\n\n" +
                    "// Запуск:\n" +
                    "java HelloWorld\n\n" +
                    "// Вывод:\n" +
                    "// Hello, World!"
                );
                tvOutput.setText(
                    "Компиляция:\n" +
                    "  HelloWorld.java → HelloWorld.class\n\n" +
                    "Запуск:\n" +
                    "  JVM читает HelloWorld.class\n" +
                    "  → Hello, World!"
                );
                tvAnalogy.setText(
                    "Представь завод:\n" +
                    "• **JVM** — это станок, который делает детали\n" +
                    "• **JRE** — это целый цех со станками и заготовками\n" +
                    "• **JDK** — это весь завод с цехами, инженерами и чертежами\n\n" +
                    "Чтобы просто получить деталь — нужен цех (JRE).\n" +
                    "Чтобы создать новый продукт — нужен весь завод (JDK)."
                );
                break;
                
            case 2: // Области памяти
                tvTitle.setText("Области памяти в Java");
                tvTheory.setText(
                    "JVM делит память на 5 основных областей:\n\n" +
                    "1️⃣ **Stack (Стек)** — быстрый, маленький.\n" +
                    "   Хранит: локальные переменные, вызовы методов\n" +
                    "   Примитивы: int x = 5; → значение 5 в стеке\n\n" +
                    "2️⃣ **Heap (Куча)** — большой, медленный.\n" +
                    "   Хранит: ВСЕ объекты (new String, new User)\n" +
                    "   Ссылки живут в стеке, объекты — в куче\n\n" +
                    "3️⃣ **Method Area (Metaspace)** — байт-код классов\n" +
                    "4️⃣ **PC Register** — адрес текущей команды\n" +
                    "5️⃣ **Native Method Stack** — для вызовов C/C++"
                );
                tvCode.setText(
                    "int a = 10;              // 10 → СТЕК\n" +
                    "String s = \"Hello\";      // ссылка s → СТЕК,\n" +
                    "                         // объект \"Hello\" → КУЧА\n" +
                    "int[] arr = new int[3];  // ссылка arr → СТЕК,\n" +
                    "                         // массив → КУЧА"
                );
                tvOutput.setText(
                    "Память:\n" +
                    "  СТЕК: a=10, s→@123, arr→@456\n" +
                    "  КУЧА: \"Hello\" (@123), [0,0,0] (@456)"
                );
                tvAnalogy.setText(
                    "Аналогия с фабрикой:\n" +
                    "• **Стек** = рабочий стол (быстро, но мало места)\n" +
                    "• **Куча** = склад завода (много места, но дольше идти)\n\n" +
                    "Когда берёшь инструмент — идёшь на склад (куча), " +
                    "но записку с номером ячейки держишь на столе (стек)."
                );
                break;
                
            case 3: // Class Loaders
                tvTitle.setText("Class Loaders");
                tvTheory.setText(
                    "Class Loaders — загрузчики классов. Когда пишешь `new User()`, " +
                    "JVM должна найти и загрузить класс User в память.\n\n" +
                    "Иерархия загрузчиков (от главного к местному):\n\n" +
                    "1️⃣ **Bootstrap ClassLoader** — загружает базовые классы Java " +
                    "(java.lang.*, java.util.*). Написан на C.\n\n" +
                    "2️⃣ **Extension ClassLoader** — загружает расширения из jre/lib/ext\n\n" +
                    "3️⃣ **Application ClassLoader** — загружает ТВОИ классы и библиотеки\n\n" +
                    "**Принцип делегирования:** каждый загрузчик сначала спрашивает " +
                    "родителя «у тебя есть этот класс?», и только если нет — ищет сам."
                );
                tvCode.setText(
                    "// Пример загрузки:\n" +
                    "User user = new User();\n\n" +
                    "// JVM ищет класс User:\n" +
                    "// 1. Спрашивает Bootstrap → нет\n" +
                    "// 2. Спрашивает Extension → нет\n" +
                    "// 3. Application находит в твоём проекте"
                );
                tvOutput.setText(
                    "Загрузка класса User:\n" +
                    "  Bootstrap: не найден\n" +
                    "  Extension: не найден\n" +
                    "  Application: найден в app.jar\n" +
                    "  → Класс загружен!"
                );
                tvAnalogy.setText(
                    "Аналогия с поиском документа:\n" +
                    "1. Спрашиваешь главного инженера (Bootstrap)\n" +
                    "2. Если нет — спрашиваешь начальника цеха (Extension)\n" +
                    "3. Если нет — ищешь сам в своём столе (Application)\n\n" +
                    "Это защита от подмены системных классов!"
                );
                break;
                
            case 4: // Объект класса Class
                tvTitle.setText("Объект класса Class");
                tvTheory.setText(
                    "В Java всё объект, даже сами классы! Для каждого класса JVM " +
                    "создаёт специальный объект типа `Class`.\n\n" +
                    "**Три способа получить объект Class:**\n\n" +
                    "1. Через `.class`: `Class<String> c1 = String.class;`\n" +
                    "2. Через объект: `Class<?> c2 = \"Hello\".getClass();`\n" +
                    "3. По имени: `Class<?> c3 = Class.forName(\"java.lang.String\");`\n\n" +
                    "**Зачем это нужно?** Это основа РЕФЛЕКСИИ — возможности изучать " +
                    "и изменять классы во время выполнения. Так работают Spring, Hibernate."
                );
                tvCode.setText(
                    "Class<String> c1 = String.class;\n" +
                    "Class<?> c2 = \"Hello\".getClass();\n\n" +
                    "System.out.println(c1.getName());\n" +
                    "// \"java.lang.String\"\n\n" +
                    "System.out.println(c1.isInterface());\n" +
                    "// false"
                );
                tvOutput.setText(
                    "Имя класса: java.lang.String\n" +
                    "Это интерфейс? false\n" +
                    "Количество методов: 46"
                );
                tvAnalogy.setText(
                    "Class — это как «паспорт» класса. В нём записано всё:\n" +
                    "- Имя\n" +
                    "- Родители (extends, implements)\n" +
                    "- Методы\n" +
                    "- Поля\n" +
                    "- Модификаторы (public, final и т.д.)"
                );
                break;
                
            case 5: // Классы и объекты
                tvTitle.setText("Классы и объекты");
                tvTheory.setText(
                    "**Класс** — это шаблон/чертёж. Описывает, какие поля и методы " +
                    "будут у объектов.\n\n" +
                    "**Объект** — конкретный экземпляр класса, созданный через `new`.\n\n" +
                    "Один класс → много объектов.\n\n" +
                    "**Синтаксис:**\n" +
                    "• Объявление класса: `public class ИмяКласса { ... }`\n" +
                    "• Создание объекта: `ИмяКласса obj = new ИмяКласса();`"
                );
                tvCode.setText(
                    "// Класс (чертёж)\n" +
                    "public class Car {\n" +
                    "    String brand;\n" +
                    "    int year;\n" +
                    "    \n" +
                    "    void start() {\n" +
                    "        System.out.println(brand + \" заводится\");\n" +
                    "    }\n" +
                    "}\n\n" +
                    "// Объекты (конкретные машины)\n" +
                    "Car bmw = new Car();\n" +
                    "bmw.brand = \"BMW\";\n" +
                    "bmw.year = 2020;\n" +
                    "bmw.start();"
                );
                tvOutput.setText("BMW заводится");
                tvAnalogy.setText(
                    "Аналогия:\n" +
                    "• **Класс** = чертёж дома (один)\n" +
                    "• **Объект** = построенные дома по этому чертежу (много)\n\n" +
                    "По чертежу можно построить сколько угодно домов, " +
                    "но каждый дом будет иметь свой адрес и своих жильцов."
                );
                break;
                
            case 6: // Структура класса
                tvTitle.setText("Структура класса");
                tvTheory.setText(
                    "Типичный класс состоит из 4 частей:\n\n" +
                    "1️⃣ **Поля (fields)** — данные объекта (характеристики)\n" +
                    "2️⃣ **Конструкторы** — создают объект, задают начальные значения\n" +
                    "3️⃣ **Методы** — действия объекта (что он умеет делать)\n" +
                    "4️⃣ **Блоки инициализации** — выполняются при создании\n\n" +
                    "**Порядок объявления** (рекомендация):\n" +
                    "поля → конструкторы → методы"
                );
                tvCode.setText(
                    "public class User {\n" +
                    "    // 1. Поля\n" +
                    "    private String name;\n" +
                    "    private int age;\n" +
                    "    \n" +
                    "    // 2. Конструктор\n" +
                    "    public User(String name, int age) {\n" +
                    "        this.name = name;\n" +
                    "        this.age = age;\n" +
                    "    }\n" +
                    "    \n" +
                    "    // 3. Методы\n" +
                    "    public void sayHello() {\n" +
                    "        System.out.println(\"Привет, я \" + name);\n" +
                    "    }\n" +
                    "}"
                );
                tvOutput.setText(
                    "Структура класса User:\n" +
                    "  Поля: name, age\n" +
                    "  Конструктор: User(String, int)\n" +
                    "  Методы: sayHello()"
                );
                tvAnalogy.setText(
                    "Аналогия с человеком:\n" +
                    "• **Поля** = имя, возраст, рост (что есть)\n" +
                    "• **Конструктор** = рождение (как появляется)\n" +
                    "• **Методы** = говорить, ходить, работать (что умеет)"
                );
                break;
                
            case 7: // Поля
                tvTitle.setText("Поля класса");
                tvTheory.setText(
                    "**Поля** — это переменные, объявленные внутри класса. " +
                    "Они хранят состояние объекта.\n\n" +
                    "**Виды полей:**\n" +
                    "• **Экземплярные** (instance) — у каждого объекта свои\n" +
                    "• **Статические** (static) — общие для всех объектов класса\n\n" +
                    "**Модификаторы доступа:**\n" +
                    "• private — только внутри класса\n" +
                    "• protected — пакет + наследники\n" +
                    "• public — везде\n" +
                    "• (без модификатора) — только в пакете\n\n" +
                    "**Правило:** поля лучше делать private, а доступ давать через геттеры/сеттеры."
                );
                tvCode.setText(
                    "public class Car {\n" +
                    "    private String brand;    // приватное\n" +
                    "    public int year;         // публичное\n" +
                    "    static int count;        // общее для всех\n" +
                    "    \n" +
                    "    public String getBrand() {\n" +
                    "        return brand;\n" +
                    "    }\n" +
                    "}"
                );
                tvOutput.setText(
                    "Car car1 = new Car();\n" +
                    "car1.year = 2020;  // ✅ можно (public)\n" +
                    "// car1.brand = \"BMW\";  // ❌ нельзя (private)"
                );
                tvAnalogy.setText(
                    "Аналогия с домом:\n" +
                    "• **private** = спальня (только для хозяина)\n" +
                    "• **public** = гостиная (для всех)\n" +
                    "• **protected** = кухня (для семьи и гостей)\n" +
                    "• **static** = адрес дома (один для всех жильцов)"
                );
                break;
                
            case 8: // Конструкторы
                tvTitle.setText("Конструкторы (this, super)");
                tvTheory.setText(
                    "**Конструктор** — специальный метод без возвращаемого типа, " +
                    "имя совпадает с классом. Вызывается при `new`.\n\n" +
                    "**Правила:**\n" +
                    "• Имя = имя класса\n" +
                    "• Нет возвращаемого типа (даже void)\n" +
                    "• Вызывается один раз при создании объекта\n\n" +
                    "**Ключевые слова:**\n" +
                    "• `this` — ссылка на ТЕКУЩИЙ объект\n" +
                    "• `super` — ссылка на РОДИТЕЛЬСКИЙ класс\n\n" +
                    "**Важно:** `super()` должен быть ПЕРВОЙ строкой в конструкторе!"
                );
                tvCode.setText(
                    "class Animal {\n" +
                    "    String name;\n" +
                    "    public Animal(String name) {\n" +
                    "        this.name = name;\n" +
                    "    }\n" +
                    "}\n\n" +
                    "class Dog extends Animal {\n" +
                    "    String breed;\n" +
                    "    public Dog(String name, String breed) {\n" +
                    "        super(name);  // вызов конструктора родителя\n" +
                    "        this.breed = breed;\n" +
                    "    }\n" +
                    "}"
                );
                tvOutput.setText(
                    "Dog dog = new Dog(\"Шарик\", \"Лабрадор\");\n" +
                    "dog.name = \"Шарик\"    // от Animal\n" +
                    "dog.breed = \"Лабрадор\" // от Dog"
                );
                tvAnalogy.setText(
                    "Аналогия:\n" +
                    "• **Конструктор** = рождение ребёнка\n" +
                    "• **this** = «я сам» (мои руки, мои ноги)\n" +
                    "• **super** = «мой папа» (наследую от него)\n\n" +
                    "Ребёнок сначала получает гены от родителей (super), " +
                    "потом развивает свои черты (this)."
                );
                break;
                
            case 9: // Методы
                tvTitle.setText("Методы (сигнатура, перегрузка)");
                tvTheory.setText(
                    "**Метод** — функция внутри класса. Описывает, что объект умеет делать.\n\n" +
                    "**Сигнатура метода** = имя + типы параметров (в этом порядке).\n" +
                    "Возвращаемый тип НЕ входит в сигнатуру!\n\n" +
                    "**Перегрузка (overloading)** — несколько методов с одинаковым " +
                    "именем, но разными параметрами. Компилятор сам выбирает нужный.\n\n" +
                    "**Правила перегрузки:**\n" +
                    "• Имя одинаковое\n" +
                    "• Параметры разные (тип, количество, порядок)\n" +
                    "• Возвращаемый тип может быть любым"
                );
                tvCode.setText(
                    "class Calculator {\n" +
                    "    int add(int a, int b) {\n" +
                    "        return a + b;\n" +
                    "    }\n" +
                    "    \n" +
                    "    int add(int a, int b, int c) {\n" +
                    "        return a + b + c;\n" +
                    "    }\n" +
                    "    \n" +
                    "    double add(double a, double b) {\n" +
                    "        return a + b;\n" +
                    "    }\n" +
                    "}"
                );
                tvOutput.setText(
                    "Calculator c = new Calculator();\n" +
                    "c.add(1, 2)      → 3 (int, int)\n" +
                    "c.add(1, 2, 3)   → 6 (int, int, int)\n" +
                    "c.add(1.5, 2.5)  → 4.0 (double, double)"
                );
                tvAnalogy.setText(
                    "Аналогия с операцией «сварить»:\n" +
                    "• Сварить(мясо) → бульон\n" +
                    "• Сварить(картошка) → пюре\n" +
                    "• Сварить(яйцо, 5 минут) → всмятку\n\n" +
                    "Название одно, но результат зависит от ингредиентов (параметров)."
                );
                break;
                
            case 10: // Блоки инициализации
                tvTitle.setText("Блоки инициализации");
                tvTheory.setText(
                    "В Java есть два типа блоков инициализации:\n\n" +
                    "1️ **Статический блок** (`static {}`)\n" +
                    "   • Выполняется ОДИН раз при загрузке класса\n" +
                    "   • Используется для инициализации static полей\n\n" +
                    "2️⃣ **Instance блок** (`{}`)\n" +
                    "   • Выполняется КАЖДЫЙ РАЗ при создании объекта\n" +
                    "   • Выполняется ДО конструктора\n\n" +
                    "**Порядок выполнения:**\n" +
                    "1. Static блоки (родитель → потомок)\n" +
                    "2. Instance блоки (родитель → потомок)\n" +
                    "3. Конструкторы (родитель → потомок)"
                );
                tvCode.setText(
                    "class A {\n" +
                    "    static { System.out.println(\"Static A\"); }\n" +
                    "    { System.out.println(\"Instance A\"); }\n" +
                    "    public A() { System.out.println(\"Constructor A\"); }\n" +
                    "}\n\n" +
                    "class B extends A {\n" +
                    "    static { System.out.println(\"Static B\"); }\n" +
                    "    { System.out.println(\"Instance B\"); }\n" +
                    "    public B() { System.out.println(\"Constructor B\"); }\n" +
                    "}\n\n" +
                    "new B(); new B();"
                );
                tvOutput.setText(
                    "Static A          ← один раз\n" +
                    "Static B          ← один раз\n" +
                    "Instance A        ← первый объект\n" +
                    "Constructor A\n" +
                    "Instance B\n" +
                    "Constructor B\n" +
                    "Instance A        ← второй объект\n" +
                    "Constructor A\n" +
                    "Instance B\n" +
                    "Constructor B"
                );
                tvAnalogy.setText(
                    "Аналогия с заводом:\n" +
                    "• **Static блок** = установка оборудования (один раз)\n" +
                    "• **Instance блок** = подготовка рабочего места (каждый раз)\n" +
                    "• **Конструктор** = запуск производства (каждый раз)\n\n" +
                    "Сначала настраиваем завод (static), потом готовим место (instance), " +
                    "потом запускаем (constructor)."
                );
                break;
                
            case 11: // static, final, abstract
                tvTitle.setText("Модификаторы: static, final, abstract");
                tvTheory.setText(
                    "**static** — принадлежит классу, а не объекту.\n" +
                    "• Поля: общие для всех объектов\n" +
                    "• Методы: можно вызывать без создания объекта\n" +
                    "• Блоки: выполняются при загрузке класса\n\n" +
                    "**final** — запрет на изменение.\n" +
                    "• Переменная: константа (нельзя переназначить)\n" +
                    "• Метод: нельзя переопределить\n" +
                    "• Класс: нельзя наследовать\n\n" +
                    "**abstract** — неполная реализация.\n" +
                    "• Метод: без тела, должен быть реализован в наследнике\n" +
                    "• Класс: нельзя создать объект, только наследовать"
                );
                tvCode.setText(
                    "static int count = 0;        // общее поле\n" +
                    "static void hello() { }      // метод класса\n\n" +
                    "final int MAX = 100;         // константа\n" +
                    "final class MyClass { }      // нельзя наследовать\n\n" +
                    "abstract class Shape {\n" +
                    "    abstract double area();  // без тела\n" +
                    "}"
                );
                tvOutput.setText(
                    "static: Math.PI → 3.14159...\n" +
                    "final: String (нельзя изменить)\n" +
                    "abstract: List (нельзя new List())"
                );
                tvAnalogy.setText(
                    "Аналогия:\n" +
                    "• **static** = номер дома (один для всех жильцов)\n" +
                    "• **final** = бетонная стена (нельзя изменить)\n" +
                    "• **abstract** = чертёж без размеров (нужно доработать)"
                );
                break;
                
            case 12: // Модификаторы доступа
                tvTitle.setText("Модификаторы доступа");
                tvTheory.setText(
                    "Модификаторы определяют, кто может получить доступ к полю/методу:\n\n" +
                    "1️⃣ **private** — только внутри КЛАССА\n" +
                    "2️⃣ **package-private** (без модификатора) — в том же ПАКЕТЕ\n" +
                    "3️⃣ **protected** — в пакете + наследники в других пакетах\n" +
                    "4️⃣ **public** — ВЕЗДЕ\n\n" +
                    "**Правило инкапсуляции:**\n" +
                    "• Поля → private\n" +
                    "• Методы → public/protected\n" +
                    "• Доступ через геттеры/сеттеры"
                );
                tvCode.setText(
                    "public class User {\n" +
                    "    private String name;      // только внутри класса\n" +
                    "    int age;                  // в том же пакете\n" +
                    "    protected String email;   // пакет + наследники\n" +
                    "    public String phone;      // везде\n" +
                    "    \n" +
                    "    public String getName() { return name; }\n" +
                    "    public void setName(String n) { name = n; }\n" +
                    "}"
                );
                tvOutput.setText(
                    "User u = new User();\n" +
                    "u.phone = \"123\";      // ✅ public\n" +
                    "u.email = \"a@b\";      // ✅ если в пакете\n" +
                    "u.age = 25;           // ✅ если в пакете\n" +
                    "// u.name = \"Вася\";   // ❌ private"
                );
                tvAnalogy.setText(
                    "Аналогия с домом:\n" +
                    "• **private** = спальня (только хозяин)\n" +
                    "• **package-private** = кухня (семья)\n" +
                    "• **protected** = гостиная (семья + друзья)\n" +
                    "• **public** = двор (все)"
                );
                break;
                
            case 13: // Установка значений
                tvTitle.setText("Установка значений свойств");
                tvTheory.setText(
                    "Есть 3 способа задать значения полей объекта:\n\n" +
                    "1️⃣ **Через поля** (прямое присваивание)\n" +
                    "   • Просто, но нарушает инкапсуляцию\n" +
                    "   • Нельзя добавить проверку\n\n" +
                    "2️ **Через конструктор**\n" +
                    "   • Задаёт значения при создании\n" +
                    "   • Можно сделать обязательные поля\n\n" +
                    "3️⃣ **Через сеттеры**\n" +
                    "   • Можно менять значения после создания\n" +
                    "   • Можно добавить валидацию\n\n" +
                    "**Лучшая практика:** конструктор + сеттеры"
                );
                tvCode.setText(
                    "class User {\n" +
                    "    private String name;\n" +
                    "    private int age;\n" +
                    "    \n" +
                    "    // Способ 2: конструктор\n" +
                    "    public User(String name, int age) {\n" +
                    "        this.name = name;\n" +
                    "        this.age = age;\n" +
                    "    }\n" +
                    "    \n" +
                    "    // Способ 3: сеттер с проверкой\n" +
                    "    public void setAge(int age) {\n" +
                    "        if (age > 0 && age < 150) {\n" +
                    "            this.age = age;\n" +
                    "        }\n" +
                    "    }\n" +
                    "}"
                );
                tvOutput.setText(
                    "User u = new User(\"Вася\", 35);  // конструктор\n" +
                    "u.setAge(36);  // ✅ сеттер с проверкой\n" +
                    "u.setAge(-5);  // ❌ проверка не пройдёт"
                );
                tvAnalogy.setText(
                    "Аналогия с анкетой:\n" +
                    "• **Поля** = заполнить от руки (можно ошибиться)\n" +
                    "• **Конструктор** = заполнить при регистрации (обязательно)\n" +
                    "• **Сеттеры** = редактировать профиль (с проверкой)"
                );
                break;
                
            case 14: // Абстрактные классы и интерфейсы
                tvTitle.setText("Абстрактные классы и интерфейсы");
                tvTheory.setText(
                    "**Абстрактный класс** (abstract class):\n" +
                    "• Может иметь и абстрактные, и обычные методы\n" +
                    "• Может иметь поля и конструкторы\n" +
                    "• Наследуется через `extends` (только ОДИН родитель)\n" +
                    "• Используется, когда есть ОБЩАЯ логика\n\n" +
                    "**Интерфейс** (interface):\n" +
                    "• Только абстрактные методы (до Java 8)\n" +
                    "• Нет полей (только константы)\n" +
                    "• Реализуется через `implements` (можно МНОГО)\n" +
                    "• Используется, когда нужно описать ПОВЕДЕНИЕ\n\n" +
                    "**Когда что использовать:**\n" +
                    "• Abstract class — «это» (Dog IS Animal)\n" +
                    "• Interface — «умеет» (Dog CAN Swim)"
                );
                tvCode.setText(
                    "abstract class Animal {\n" +
                    "    String name;\n" +
                    "    abstract void sound();\n" +
                    "    void breathe() { }\n" +
                    "}\n\n" +
                    "interface Swimmable {\n" +
                    "    void swim();\n" +
                    "}\n\n" +
                    "class Dog extends Animal implements Swimmable {\n" +
                    "    void sound() { System.out.println(\"Гав\"); }\n" +
                    "    public void swim() { System.out.println(\"Плыву\"); }\n" +
                    "}"
                );
                tvOutput.setText(
                    "Dog dog = new Dog();\n" +
                    "dog.sound();  // Гав\n" +
                    "dog.swim();   // Плыву"
                );
                tvAnalogy.setText(
                    "Аналогия:\n" +
                    "• **Abstract class** = базовая модель телефона (есть экран, кнопки)\n" +
                    "• **Interface** = набор функций (камера, GPS, NFC)\n\n" +
                    "Телефон НАСЛЕДУЕТ базовую модель и РЕАЛИЗУЕТ функции."
                );
                break;
                
            case 15: // Иммутабельные объекты
                tvTitle.setText("Изменяемые и неизменяемые объекты");
                tvTheory.setText(
                    "**Mutable (изменяемый)** — состояние можно менять после создания.\n" +
                    "Примеры: StringBuilder, ArrayList, Date\n\n" +
                    "**Immutable (неизменяемый)** — состояние НЕЛЬЗЯ менять.\n" +
                    "Примеры: String, Integer, Boolean\n\n" +
                    "**Как сделать класс неизменяемым:**\n" +
                    "1. Все поля private final\n" +
                    "2. Нет сеттеров\n" +
                    "3. Конструктор инициализирует все поля\n" +
                    "4. Если есть изменяемые поля — делать защитное копирование\n" +
                    "5. Класс объявить final (нельзя наследовать)\n\n" +
                    "**Зачем нужны immutable:**\n" +
                    "• Потокобезопасность\n" +
                    "• Можно использовать как ключи в HashMap\n" +
                    "• Предсказуемое поведение"
                );
                tvCode.setText(
                    "public final class ImmutableUser {\n" +
                    "    private final String name;\n" +
                    "    private final int age;\n" +
                    "    \n" +
                    "    public ImmutableUser(String name, int age) {\n" +
                    "        this.name = name;\n" +
                    "        this.age = age;\n" +
                    "    }\n" +
                    "    \n" +
                    "    public String getName() { return name; }\n" +
                    "    public int getAge() { return age; }\n" +
                    "    // Нет сеттеров!\n" +
                    "}"
                );
                tvOutput.setText(
                    "ImmutableUser u = new ImmutableUser(\"Вася\", 35);\n" +
                    "u.getName();  // \"Вася\"\n" +
                    "// u.setName(\"Петя\");  // ❌ нельзя!"
                );
                tvAnalogy.setText(
                    "Аналогия:\n" +
                    "• **Mutable** = доска для записей (можно стирать и писать)\n" +
                    "• **Immutable** = высечено в камне (навсегда)\n\n" +
                    "String неизменяема: при \"изменении\" создаётся НОВАЯ строка."
                );
                break;
                
            case 16: // Inner и Nested классы
                tvTitle.setText("Inner и Nested классы");
                tvTheory.setText(
                    "Классы могут быть вложены друг в друга:\n\n" +
                    "1️⃣ **Nested class (static inner)**\n" +
                    "   • Объявлен с модификатором static\n" +
                    "   • НЕ имеет доступа к полям внешнего класса\n" +
                    "   • Создаётся: `Outer.Inner obj = new Outer.Inner();`\n\n" +
                    "2️⃣ **Inner class (non-static)**\n" +
                    "   • Без static\n" +
                    "   • ИМЕЕТ доступ ко всем полям внешнего класса\n" +
                    "   • Создаётся: `Outer.Inner obj = new Outer().new Inner();`\n\n" +
                    "**Когда использовать:**\n" +
                    "• Nested — вспомогательный класс, не связанный с экземпляром\n" +
                    "• Inner — тесно связан с внешним объектом"
                );
                tvCode.setText(
                    "class Outer {\n" +
                    "    private String name = \"Outer\";\n" +
                    "    \n" +
                    "    // Nested (static)\n" +
                    "    static class Nested {\n" +
                    "        void show() {\n" +
                    "            // System.out.println(name); // ❌ нет доступа\n" +
                    "        }\n" +
                    "    }\n" +
                    "    \n" +
                    "    // Inner (non-static)\n" +
                    "    class Inner {\n" +
                    "        void show() {\n" +
                    "            System.out.println(name); // ✅ есть доступ\n" +
                    "        }\n" +
                    "    }\n" +
                    "}"
                );
                tvOutput.setText(
                    "Outer.Nested n = new Outer.Nested();\n" +
                    "Outer.Inner i = new Outer().new Inner();\n" +
                    "i.show();  // \"Outer\""
                );
                tvAnalogy.setText(
                    "Аналогия:\n" +
                    "• **Nested** = отдел в компании (существует сам по себе)\n" +
                    "• **Inner** = сотрудник (существует только в компании)"
                );
                break;
                
            case 17: // Локальные и анонимные классы
                tvTitle.setText("Локальные и анонимные классы");
                tvTheory.setText(
                    "**Локальный класс** — объявлен внутри метода.\n" +
                    "• Видим только внутри метода\n" +
                    "• Может использовать локальные переменные (final/effectively final)\n\n" +
                    "**Анонимный класс** — без имени, создаётся и используется сразу.\n" +
                    "• Часто используется для реализации интерфейсов\n" +
                    "• Не имеет конструктора (имя = имя родителя/интерфейса)\n\n" +
                    "**Когда использовать:**\n" +
                    "• Локальный — сложная логика внутри метода\n" +
                    "• Анонимный — простая реализация интерфейса (1-2 метода)"
                );
                tvCode.setText(
                    "void method() {\n" +
                    "    // Локальный класс\n" +
                    "    class LocalHelper {\n" +
                    "        void help() { System.out.println(\"Help\"); }\n" +
                    "    }\n" +
                    "    new LocalHelper().help();\n" +
                    "    \n" +
                    "    // Анонимный класс\n" +
                    "    Runnable r = new Runnable() {\n" +
                    "        @Override\n" +
                    "        public void run() {\n" +
                    "            System.out.println(\"Run\");\n" +
                    "        }\n" +
                    "    };\n" +
                    "    r.run();\n" +
                    "}"
                );
                tvOutput.setText(
                    "Help\n" +
                    "Run"
                );
                tvAnalogy.setText(
                    "Аналогия:\n" +
                    "• **Локальный класс** = временная бригада на проекте\n" +
                    "• **Анонимный класс** = фрилансер на одну задачу"
                );
                break;
                
            case 18: // Класс Object
                tvTitle.setText("Класс Object");
                tvTheory.setText(
                    "**Object** — корень иерархии классов в Java.\n" +
                    "ВСЕ классы неявно наследуются от Object.\n\n" +
                    "`class MyClass` = `class MyClass extends Object`\n\n" +
                    "**Методы Object:**\n" +
                    "• `toString()` — строковое представление\n" +
                    "• `equals()` — сравнение объектов\n" +
                    "• `hashCode()` — хэш-код\n" +
                    "• `getClass()` — получить Class объекта\n" +
                    "• `clone()` — создать копию\n" +
                    "• `finalize()` — перед удалением (устарел)\n" +
                    "• `notify()`, `wait()` — для многопоточности"
                );
                tvCode.setText(
                    "Object obj = new String(\"Hello\");\n" +
                    "\n" +
                    "System.out.println(obj.toString());  // \"Hello\"\n" +
                    "System.out.println(obj.getClass());  // class java.lang.String\n" +
                    "System.out.println(obj.hashCode());  // число"
                );
                tvOutput.setText(
                    "Hello\n" +
                    "class java.lang.String\n" +
                    "69609650"
                );
                tvAnalogy.setText(
                    "Object — это как ДНК всего живого.\n" +
                    "Каждый класс наследует базовые «гены» от Object."
                );
                break;
                
            case 19: // Методы класса Object
                tvTitle.setText("Методы класса Object");
                tvTheory.setText(
                    "Самые важные методы Object:\n\n" +
                    "1️⃣ **toString()** — возвращает строковое представление.\n" +
                    "   По умолчанию: `ClassName@hashCode`\n" +
                    "   Переопределяют для читаемого вывода\n\n" +
                    "2️⃣ **equals()** — сравнение объектов.\n" +
                    "   По умолчанию: сравнивает ссылки (==)\n" +
                    "   Переопределяют для сравнения по содержимому\n\n" +
                    "3️⃣ **hashCode()** — возвращает числовой хэш.\n" +
                    "   Используется в HashMap, HashSet\n\n" +
                    "4️⃣ **getClass()** — возвращает объект Class\n\n" +
                    "5️⃣ **clone()** — создаёт копию объекта"
                );
                tvCode.setText(
                    "class User {\n" +
                    "    String name;\n" +
                    "    \n" +
                    "    @Override\n" +
                    "    public String toString() {\n" +
                    "        return \"User: \" + name;\n" +
                    "    }\n" +
                    "    \n" +
                    "    @Override\n" +
                    "    public boolean equals(Object o) {\n" +
                    "        if (this == o) return true;\n" +
                    "        if (!(o instanceof User)) return false;\n" +
                    "        User u = (User) o;\n" +
                    "        return name.equals(u.name);\n" +
                    "    }\n" +
                    "}"
                );
                tvOutput.setText(
                    "User u1 = new User(); u1.name = \"Вася\";\n" +
                    "User u2 = new User(); u2.name = \"Вася\";\n" +
                    "u1.equals(u2);  // true (после переопределения)"
                );
                tvAnalogy.setText(
                    "Аналогия:\n" +
                    "• **toString()** = визитная карточка\n" +
                    "• **equals()** = проверка «ты ли это?»\n" +
                    "• **hashCode()** = отпечаток пальца"
                );
                break;
                
            case 20: // Контракт equals - hashCode
                tvTitle.setText("Контракт equals - hashCode");
                tvTheory.setText(
                    "**Контракт** — правила, которые нужно соблюдать при переопределении:\n\n" +
                    "1️ Если `equals()` возвращает true → `hashCode()` должен быть одинаковым\n" +
                    "2️⃣ Если `hashCode()` одинаковый → `equals()` НЕ обязательно true\n" +
                    "3️⃣ Переопределяешь equals → ОБЯЗАН переопределить hashCode\n\n" +
                    "**Почему это важно?**\n" +
                    "HashMap и HashSet используют hashCode для быстрого поиска.\n" +
                    "Если контракт нарушен — коллекции работают неправильно!\n\n" +
                    "**Правило:** всегда переопределяй оба метода вместе."
                );
                tvCode.setText(
                    "class User {\n" +
                    "    String name;\n" +
                    "    \n" +
                    "    @Override\n" +
                    "    public boolean equals(Object o) {\n" +
                    "        User u = (User) o;\n" +
                    "        return name.equals(u.name);\n" +
                    "    }\n" +
                    "    \n" +
                    "    @Override\n" +
                    "    public int hashCode() {\n" +
                    "        return name.hashCode();\n" +
                    "    }\n" +
                    "}"
                );
                tvOutput.setText(
                    "User u1 = new User(); u1.name = \"Вася\";\n" +
                    "User u2 = new User(); u2.name = \"Вася\";\n" +
                    "u1.equals(u2);      // true\n" +
                    "u1.hashCode() == u2.hashCode();  // true"
                );
                tvAnalogy.setText(
                    "Аналогия с паспортом:\n" +
                    "• **equals()** = проверка «это один человек?»\n" +
                    "• **hashCode()** = номер паспорта\n\n" +
                    "Если люди одинаковые (equals=true), " +
                    "номера паспортов должны совпадать (hashCode)."
                );
                break;
                
            case 21: // Метод clone
                tvTitle.setText("Метод clone");
                tvTheory.setText(
                    "**clone()** — создаёт копию объекта.\n\n" +
                    "**Как использовать:**\n" +
                    "1. Класс должен реализовать интерфейс `Cloneable`\n" +
                    "2. Переопределить метод `clone()`\n" +
                    "3. Вызвать `super.clone()`\n\n" +
                    "**Виды клонирования:**\n" +
                    "• **Поверхностное (shallow)** — копируются только ссылки\n" +
                    "  (вложенные объекты общие)\n" +
                    "• **Глубокое (deep)** — копируются и вложенные объекты\n\n" +
                    "**Проблемы clone:**\n" +
                    "• Нужно реализовывать Cloneable\n" +
                    "• Не работает с final полями\n" +
                    "• Лучше использовать конструктор копирования"
                );
                tvCode.setText(
                    "class User implements Cloneable {\n" +
                    "    String name;\n" +
                    "    \n" +
                    "    @Override\n" +
                    "    protected Object clone() \n" +
                    "            throws CloneNotSupportedException {\n" +
                    "        return super.clone();\n" +
                    "    }\n" +
                    "}\n\n" +
                    "User u1 = new User();\n" +
                    "u1.name = \"Вася\";\n" +
                    "User u2 = (User) u1.clone();\n" +
                    "u2.name = \"Петя\";\n" +
                    "// u1.name всё ещё \"Вася\""
                );
                tvOutput.setText(
                    "u1.name = \"Вася\"\n" +
                    "u2.name = \"Петя\"\n" +
                    "Это разные объекты!"
                );
                tvAnalogy.setText(
                    "Аналогия:\n" +
                    "• **clone()** = ксерокопия документа\n" +
                    "• Поверхностное = копируется только обложка\n" +
                    "• Глубокое = копируется всё содержимое"
                );
                break;
                
            case 22: // Принципы ООП
                tvTitle.setText("Принципы ООП");
                tvTheory.setText(
                    "4 основных принципа ООП:\n\n" +
                    "1️⃣ **Инкапсуляция** — скрытие внутренней реализации.\n" +
                    "   Поля private, доступ через методы.\n\n" +
                    "2️ **Наследование** — создание новых классов на основе существующих.\n" +
                    "   `extends` — наследование, `implements` — реализация.\n\n" +
                    "3️⃣ **Полиморфизм** — один интерфейс, много реализаций.\n" +
                    "   Один метод — разное поведение у разных классов.\n\n" +
                    "4️⃣ **Абстракция** — выделение главного, отбрасывание деталей.\n" +
                    "   abstract классы и интерфейсы."
                );
                tvCode.setText(
                    "// Инкапсуляция\n" +
                    "class User {\n" +
                    "    private String name;\n" +
                    "    public String getName() { return name; }\n" +
                    "}\n\n" +
                    "// Наследование\n" +
                    "class Dog extends Animal { }\n\n" +
                    "// Полиморфизм\n" +
                    "Animal a = new Dog();\n" +
                    "a.sound();  // Гав\n\n" +
                    "// Абстракция\n" +
                    "abstract class Shape {\n" +
                    "    abstract double area();\n" +
                    "}"
                );
                tvOutput.setText(
                    "ООП = Инкапсуляция + Наследование + " +
                    "Полиморфизм + Абстракция"
                );
                tvAnalogy.setText(
                    "Аналогия с автомобилем:\n" +
                    "• **Инкапсуляция** = руль и педали (не видишь двигатель)\n" +
                    "• **Наследование** = грузовик от легкового\n" +
                    "• **Полиморфизм** = одна педаль «газ» для всех машин\n" +
                    "• **Абстракция** = понятие «транспорт» (без деталей)"
                );
                break;
                
            case 23: // Наследование и Ассоциация
                tvTitle.setText("Наследование и Ассоциация");
                tvTheory.setText(
                    "**Наследование (is-a)** — класс наследует поля и методы родителя.\n" +
                    "• `class Dog extends Animal`\n" +
                    "• Плюсы: переиспользование кода, полиморфизм\n" +
                    "• Минусы: жёсткая связь, хрупкий базовый класс\n\n" +
                    "**Ассоциация (has-a)** — объект содержит другой объект.\n" +
                    "• `class Car { Engine engine; }`\n" +
                    "• Виды: агрегация (слабая), композиция (сильная)\n" +
                    "• Плюсы: гибкость, слабая связь\n" +
                    "• Минусы: больше кода\n\n" +
                    "**Правило:** предпочитай композицию наследованию!"
                );
                tvCode.setText(
                    "// Наследование (is-a)\n" +
                    "class Animal { void breathe() { } }\n" +
                    "class Dog extends Animal { }\n\n" +
                    "// Композиция (has-a)\n" +
                    "class Engine { void start() { } }\n" +
                    "class Car {\n" +
                    "    private Engine engine;\n" +
                    "    public Car() {\n" +
                    "        engine = new Engine();\n" +
                    "    }\n" +
                    "}"
                );
                tvOutput.setText(
                    "Dog dog = new Dog();\n" +
                    "dog.breathe();  // от Animal\n\n" +
                    "Car car = new Car();\n" +
                    "car.engine.start();  // через композицию"
                );
                tvAnalogy.setText(
                    "Аналогия:\n" +
                    "• **Наследование** = ребёнок наследует гены родителей\n" +
                    "• **Ассоциация** = человек имеет машину (не является ею)"
                );
                break;
                
            case 24: // Переопределение методов
                tvTitle.setText("Переопределение методов");
                tvTheory.setText(
                    "**Переопределение (overriding)** — наследник меняет поведение " +
                    "метода родителя.\n\n" +
                    "**Правила:**\n" +
                    "• Имя, параметры и возвращаемый тип — одинаковые\n" +
                    "• Аннотация `@Override` (не обязательна, но рекомендуется)\n" +
                    "• Нельзя уменьшить видимость (public → private ❌)\n" +
                    "• Нельзя переопределить static, final, private методы\n\n" +
                    "**Отличие от перегрузки:**\n" +
                    "• Overriding — тот же метод, другое поведение\n" +
                    "• Overloading — разные методы, одно имя"
                );
                tvCode.setText(
                    "class Animal {\n" +
                    "    void sound() {\n" +
                    "        System.out.println(\"...\");\n" +
                    "    }\n" +
                    "}\n\n" +
                    "class Dog extends Animal {\n" +
                    "    @Override\n" +
                    "    void sound() {\n" +
                    "        System.out.println(\"Гав!\");\n" +
                    "    }\n" +
                    "}\n\n" +
                    "Animal a = new Dog();\n" +
                    "a.sound();  // Гав!"
                );
                tvOutput.setText(
                    "Animal a1 = new Animal(); a1.sound();  // ...\n" +
                    "Animal a2 = new Dog();    a2.sound();  // Гав!"
                );
                tvAnalogy.setText(
                    "Аналогия:\n" +
                    "• **Переопределение** = ребёнок учится говорить по-своему\n" +
                    "• **Перегрузка** = одно слово с разным смыслом «ключ» (от двери, музыкальный)"
                );
                break;
                
            case 25: // Статическое и динамическое связывание
                tvTitle.setText("Статическое и динамическое связывание");
                tvTheory.setText(
                    "**Связывание** — определение, какой метод вызвать.\n\n" +
                    "1️⃣ **Статическое (раннее)** — на этапе компиляции.\n" +
                    "   • Для static, private, final методов\n" +
                    "   • Для перегруженных методов\n" +
                    "   • Быстрое, но не гибкое\n\n" +
                    "2️⃣ **Динамическое (позднее)** — во время выполнения.\n" +
                    "   • Для переопределённых методов\n" +
                    "   • JVM смотрит на РЕАЛЬНЫЙ тип объекта\n" +
                    "   • Основа полиморфизма\n\n" +
                    "**Пример:**\n" +
                    "`Animal a = new Dog(); a.sound();`\n" +
                    "Тип переменной: Animal\n" +
                    "Реальный тип: Dog\n" +
                    "Вызовется метод Dog (динамическое связывание)"
                );
                tvCode.setText(
                    "class Animal {\n" +
                    "    void sound() { System.out.println(\"...\"); }\n" +
                    "    static void info() { System.out.println(\"Animal\"); }\n" +
                    "}\n\n" +
                    "class Dog extends Animal {\n" +
                    "    @Override\n" +
                    "    void sound() { System.out.println(\"Гав\"); }\n" +
                    "    static void info() { System.out.println(\"Dog\"); }\n" +
                    "}\n\n" +
                    "Animal a = new Dog();\n" +
                    "a.sound();  // Гав (динамическое)\n" +
                    "a.info();   // Animal (статическое)"
                );
                tvOutput.setText(
                    "a.sound(); → Гав (реальный тип Dog)\n" +
                    "a.info();  → Animal (тип переменной)"
                );
                tvAnalogy.setText(
                    "Аналогия:\n" +
                    "• **Статическое** = по должности (директор всегда директор)\n" +
                    "• **Динамическое** = по факту (человек в форме может быть актёром)"
                );
                break;
                
            case 26: // Оболочки примитивных типов
                tvTitle.setText("Оболочки примитивных типов");
                tvTheory.setText(
                    "Для каждого примитива есть класс-оболочка (wrapper):\n\n" +
                    "• int → **Integer**\n" +
                    "• double → **Double**\n" +
                    "• boolean → **Boolean**\n" +
                    "• char → **Character**\n" +
                    "• byte → **Byte**, short → **Short**\n" +
                    "• long → **Long**, float → **Float**\n\n" +
                    "**Зачем нужны:**\n" +
                    "• Коллекции работают только с объектами\n" +
                    "• Можно хранить null\n" +
                    "• Есть полезные методы (parseInt, valueOf)\n\n" +
                    "**Autoboxing/Unboxing** — автопреобразование:\n" +
                    "`Integer x = 5;` (autoboxing)\n" +
                    "`int y = x;` (unboxing)\n\n" +
                    "**Важно:** сравнивать через `.equals()`, не через `==`!"
                );
                tvCode.setText(
                    "Integer a = 100;      // autoboxing\n" +
                    "int b = a;            // unboxing\n\n" +
                    "Integer c = Integer.valueOf(100);\n" +
                    "Integer d = Integer.valueOf(100);\n\n" +
                    "System.out.println(a == b);      // true\n" +
                    "System.out.println(c.equals(d)); // true\n" +
                    "System.out.println(c == d);      // true* (кэш -128..127)"
                );
                tvOutput.setText(
                    "a == b: true (unboxing)\n" +
                    "c.equals(d): true (сравнение значений)\n" +
                    "c == d: true (кэш для -128..127)"
                );
                tvAnalogy.setText(
                    "Аналогия:\n" +
                    "• **Примитив** = наличные деньги (быстро, но нельзя в банк)\n" +
                    "• **Оболочка** = банковская карта (можно везде, но медленнее)"
                );
                break;
                
            case 27: // String
                tvTitle.setText("String");
                tvTheory.setText(
                    "**String** — неизменяемая (immutable) последовательность символов.\n\n" +
                    "**Особенности:**\n" +
                    "• Создаётся через `\"...\"` или `new String(\"...\")`\n" +
                    "• Нельзя изменить после создания\n" +
                    "• При «изменении» создаётся НОВЫЙ объект\n\n" +
                    "**Методы String:**\n" +
                    "• `length()` — длина\n" +
                    "• `charAt(i)` — символ по индексу\n" +
                    "• `substring(start, end)` — подстрока\n" +
                    "• `equals()` — сравнение\n" +
                    "• `toLowerCase()`, `toUpperCase()`\n" +
                    "• `trim()` — убрать пробелы\n" +
                    "• `replace()`, `split()`\n\n" +
                    "**Важно:** сравнивать через `.equals()`, не через `==`!"
                );
                tvCode.setText(
                    "String s1 = \"Hello\";\n" +
                    "String s2 = new String(\"Hello\");\n\n" +
                    "System.out.println(s1.length());      // 5\n" +
                    "System.out.println(s1.charAt(0));     // H\n" +
                    "System.out.println(s1.substring(1,3));// el\n" +
                    "System.out.println(s1.equals(s2));    // true\n" +
                    "System.out.println(s1 == s2);         // false"
                );
                tvOutput.setText(
                    "5\n" +
                    "H\n" +
                    "el\n" +
                    "true\n" +
                    "false"
                );
                tvAnalogy.setText(
                    "String — как высечено в камне.\n" +
                    "Нельзя изменить букву — только создать новую надпись."
                );
                break;
                
            case 28: // String pool
                tvTitle.setText("String pool");
                tvTheory.setText(
                    "**String Pool** — специальная область памяти (в Heap) для хранения строковых литералов.\n\n" +
                    "**Как работает:**\n" +
                    "1. При создании строки через `\"...\"` JVM проверяет pool\n" +
                    "2. Если такая строка уже есть — возвращает ссылку на неё\n" +
                    "3. Если нет — создаёт новую и добавляет в pool\n\n" +
                    "**`new String()`** — ВСЕГДА создаёт новый объект, даже если есть в pool.\n\n" +
                    "**Метод `intern()`** — добавляет строку в pool вручную.\n\n" +
                    "**Зачем нужен pool:**\n" +
                    "• Экономия памяти\n" +
                    "• Быстрое сравнение через `==` (для литералов)"
                );
                tvCode.setText(
                    "String s1 = \"Hello\";    // в pool\n" +
                    "String s2 = \"Hello\";    // та же ссылка из pool\n" +
                    "String s3 = new String(\"Hello\"); // новый объект\n\n" +
                    "System.out.println(s1 == s2);      // true\n" +
                    "System.out.println(s1 == s3);      // false\n" +
                    "System.out.println(s1.equals(s3)); // true\n\n" +
                    "String s4 = s3.intern();\n" +
                    "System.out.println(s1 == s4);      // true"
                );
                tvOutput.setText(
                    "s1 == s2: true (одна ссылка из pool)\n" +
                    "s1 == s3: false (разные объекты)\n" +
                    "s1.equals(s3): true (одинаковое содержимое)\n" +
                    "s1 == s4: true (intern добавил в pool)"
                );
                tvAnalogy.setText(
                    "Аналогия с библиотекой:\n" +
                    "• **Pool** = каталог книг\n" +
                    "• **Литерал** = взять книгу из каталога\n" +
                    "• **new String()** = купить новую копию\n" +
                    "• **intern()** = добавить свою книгу в каталог"
                );
                break;
                
            case 29: // StringBuilder, StringBuffer
                tvTitle.setText("StringBuilder, StringBuffer");
                tvTheory.setText(
                    "Для изменяемых строк используют:\n\n" +
                    "1️⃣ **StringBuilder** — быстрый, НЕ потокобезопасный.\n" +
                    "   Используйте в большинстве случаев.\n\n" +
                    "2️⃣ **StringBuffer** — медленнее, потокобезопасный (synchronized).\n" +
                    "   Используйте только в многопоточных приложениях.\n\n" +
                    "**Методы:**\n" +
                    "• `append()` — добавить\n" +
                    "• `insert()` — вставить\n" +
                    "• `delete()` — удалить\n" +
                    "• `replace()` — заменить\n" +
                    "• `reverse()` — перевернуть\n" +
                    "• `toString()` — получить String\n\n" +
                    "**Почему не String?**\n" +
                    "String неизменяем — при каждой операции создаётся новый объект. " +
                    "StringBuilder меняет содержимое без создания новых объектов."
                );
                tvCode.setText(
                    "StringBuilder sb = new StringBuilder();\n" +
                    "sb.append(\"Hello\");\n" +
                    "sb.append(\" \");\n" +
                    "sb.append(\"World\");\n" +
                    "sb.insert(5, \",\");\n" +
                    "sb.reverse();\n\n" +
                    "String result = sb.toString();\n" +
                    "System.out.println(result);"
                );
                tvOutput.setText(
                    "Hello, World\n" +
                    "После reverse: dlroW ,olleH"
                );
                tvAnalogy.setText(
                    "Аналогия:\n" +
                    "• **String** = каменная табличка (нельзя изменить)\n" +
                    "• **StringBuilder** = доска для записей (можно стирать)\n" +
                    "• **StringBuffer** = доска с замком (только один пишет)"
                );
                break;
				
				case 30: // Git - Система контроля версий
    tvTitle.setText("Git — Система контроля версий");
    tvTheory.setText(
        "**Git** — система для отслеживания изменений в коде.\n\n" +
        "**Зачем нужен:**\n" +
        "• Сохранять версии (коммиты)\n" +
        "• Откатываться к рабочим версиям\n" +
        "• Работать в команде\n" +
        "• Создавать релизы (теги)\n\n" +
        "**Основные понятия:**\n" +
        "• **Репозиторий** — папка с историей\n" +
        "• **Коммит** — сохранение состояния\n" +
        "• **Ветка** — параллельная разработка\n" +
        "• **Тег** — закладка версии (v1.0)\n" +
        "• **GitHub** — облачное хранилище\n\n" +
        "**Ежедневный workflow:**\n" +
        "1. git status — проверить статус\n" +
        "2. git add . — добавить файлы\n" +
        "3. git commit -m \"...\" — сохранить\n" +
        "4. git push — отправить на GitHub"
    );
    tvCode.setText(
        "=== ОСНОВНЫЕ КОМАНДЫ GIT ===\n\n" +
        
        "1. НАСТРОЙКА (один раз):\n" +
        "git config --global user.name \"Имя\"\n" +
        "git config --global user.email \"email@test.com\"\n\n" +
        
        "2. СОЗДАНИЕ РЕПОЗИТОРИЯ:\n" +
        "git init                    # Инициализировать репозиторий\n" +
        "git clone <URL>             # Скачать репозиторий\n\n" +
        
        "3. ЕЖЕДНЕВНАЯ РАБОТА:\n" +
        "git status                  # Показать статус\n" +
        "git add .                   # Добавить все файлы\n" +
        "git add Main.java           # Добавить конкретный файл\n" +
        "git commit -m \"Сообщение\"   # Сохранить изменения\n" +
        "git commit --amend          # Исправить последний коммит\n" +
        "git push origin master      # Отправить на GitHub\n" +
        "git pull origin master      # Скачать с GitHub\n\n" +
        
        "4. РАБОТА С ВЕТКАМИ:\n" +
        "git branch                  # Показать ветки\n" +
        "git branch feature          # Создать ветку\n" +
        "git checkout feature        # Переключиться на ветку\n" +
        "git checkout -b feature     # Создать И переключиться\n" +
        "git switch feature          # Переключиться (новая команда)\n" +
        "git switch -c feature       # Создать и переключиться\n" +
        "git merge feature           # Влить ветку в текущую\n" +
        "git branch -d feature       # Удалить ветку\n" +
        "git checkout -b hotfix      # Создать hotfix ветку\n\n" +
        
        "5. РАБОТА С ТЕГАМИ:\n" +
        "git tag                     # Показать теги\n" +
        "git tag v1.0                # Создать тег\n" +
        "git tag -a v1.0 -m \"v1.0\"   # Создать аннотированный тег\n" +
        "git push origin v1.0        # Отправить тег\n" +
        "git push --tags             # Отправить все теги\n" +
        "git tag -d v1.0             # Удалить тег локально\n" +
        "git push --delete origin v1.0  # Удалить тег на GitHub\n\n" +
        
        "6. ПРОСМОТР ИСТОРИИ:\n" +
        "git log                     # Полная история\n" +
        "git log --oneline           # Краткая история\n" +
        "git log -5                  # Последние 5 коммитов\n" +
        "git log --graph             # История с графиком\n" +
        "git log --all --decorate    # Все ветки и теги\n" +
        "git show abc123             # Показать конкретный коммит\n" +
        "git diff                    # Изменения (до git add)\n" +
        "git diff --staged           # Изменения (после git add)\n\n" +
        
        "7. ОТМЕНА ИЗМЕНЕНИЙ:\n" +
        "git restore file            # Отменить изменения в файле\n" +
        "git restore --staged file   # Убрать файл из индекса\n" +
        "git reset --soft HEAD~1     # Отменить коммит (сохранить изменения)\n" +
        "git reset --mixed HEAD~1    # Отменить коммит и add\n" +
        "git reset --hard HEAD~1     # Полностью отменить (ОПАСНО!)\n" +
        "git revert abc123           # Отменить коммит новым коммитом\n" +
        "git clean -fd               # Удалить неотслеживаемые файлы\n\n" +
        
        "8. ВРЕМЕННОЕ СОХРАНЕНИЕ:\n" +
        "git stash                   # Временно сохранить изменения\n" +
        "git stash list              # Показать сохранённые\n" +
        "git stash pop               # Вернуть изменения\n" +
        "git stash apply             # Применить без удаления\n" +
        "git stash drop              # Удалить сохранение\n\n" +
        
        "9. СИНХРОНИЗАЦИЯ С GitHub:\n" +
        "git fetch                   # Скачать изменения (не сливать)\n" +
        "git pull                    # Скачать и слить (fetch + merge)\n" +
        "git pull --rebase           # Скачать и переместить коммиты\n" +
        "git push -u origin master   # Отправить и установить связь\n" +
        "git remote -v               # Показать удалённые репозитории\n" +
        "git remote add origin <URL> # Добавить удалённый репозиторий\n\n" +
        
        "10. ПОИСК И АНАЛИЗ:\n" +
        "git log --grep=\"баг\"       # Найти коммит по сообщению\n" +
        "git log -S\"текст\"           # Найти коммит, где изменился текст\n" +
        "git blame file              # Кто последним менял каждую строку\n" +
        "git shortlog                # Статистика по авторам\n\n" +
        
        "11. .GITIGNORE:\n" +
        "echo \"*.class\" >> .gitignore\n" +
        "echo \"target/\" >> .gitignore\n" +
        "git add .gitignore\n" +
        "git commit -m \"Add .gitignore\""
    );
    tvOutput.setText(
        "$ git status\n" +
        "On branch master\n" +
        "Changes not staged:\n" +
        "  modified:   Main.java\n" +
        "Untracked files:\n" +
        "  Employee.java\n\n" +
        
        "$ git log --oneline\n" +
        "abc1234 Добавил Git тему\n" +
        "def5678 Исправил баг\n" +
        "ghi9012 Начальный коммит\n\n" +
        
        "$ git branch -a\n" +
        "* master\n" +
        "  feature-login\n" +
        "  remotes/origin/master\n\n" +
        
        "$ git tag\n" +
        "v1.0\n" +
        "v1.1\n" +
        "v1.2 (Latest)\n\n" +
        
        "$ git checkout -b feature-new\n" +
        "Switched to a new branch 'feature-new'\n\n" +
        
        "$ git stash list\n" +
        "stash@{0}: WIP on master: abc1234 Временные изменения"
    );
    tvAnalogy.setText(
        "АНАЛОГИИ:\n\n" +
        "• **git init** = Купить блокнот для записей 📓\n" +
        "• **git clone** = Скопировать чужую тетрадь 📋\n" +
        "• **git add** = Положить работу в портфель 💼\n" +
        "• **git commit** = Сфотографировать результат 📸\n" +
        "• **git push** = Отправить работу учителю 📮\n" +
        "• **git pull** = Скачать работу одноклассника 📥\n" +
        "• **git branch** = Начать черновик ✍️\n" +
        "• **git checkout -b** = Начать черновик и сразу перейти к нему 🚀\n" +
        "• **git merge** = Вклеить черновик в основную тетрадь 📎\n" +
        "• **git tag** = Поставить закладку на странице 🔖\n" +
        "• **git stash** = Убрать в ящик на время 🗄️\n" +
        "• **git revert** = Написать исправление поверх ошибки ✏️\n" +
        "• **git reset** = Порвать страницу (ОПАСНО!) ️\n" +
        "• **.gitignore** = Чёрный список файлов 🚫\n\n" +
        
        "**ВАЖНО ЗАПОМНИТЬ:**\n" +
        "✅ git checkout -b name = создать ветку И переключиться\n" +
        "✅ git commit делай каждые 30-60 минут\n" +
        "✅ Пиши понятные сообщения в коммитах!\n" +
        "✅ Теги (v1.0) запускают GitHub Actions\n" +
        "✅ Не коммитьте .class, target/, .settings/"
    );
    break;

            // ... все остальные case от 2 до 30 ...

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