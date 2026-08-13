package com.vasiliykozonkov.javadevelopercourse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TopicActivity extends AppCompatActivity {
    
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
        
        int topicIndex = getIntent().getIntExtra("topic_index", 0);
        loadTopicData(topicIndex);
        
        btnRun.setOnClickListener(v -> {
            tvOutput.setVisibility(tvOutput.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
        });
    }
    
    private void loadTopicData(int index) {
        switch (index) {
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
				
				
				
				
				
				// Исключения
                
			case 30:
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

case 31: // Иерархия исключений
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

case 32: // Способы обработки исключений
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

case 33: // try с ресурсами
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

case 34: // Ввод-вывод
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

case 35: // Классы потоков ввода-вывода
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

case 36: // Правила работы с потоками I/O
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

case 37: // Сериализация
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

case 38: // Алгоритмы
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

case 39: // Big O notation
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

case 40: // Виды сортировок
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

case 41: // Generics
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

case 42: // Коллекции
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

case 43: // Иерархия коллекций
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

case 44: // List
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

case 45: // Set
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

case 46: // Map
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

case 47: // Временная сложность коллекций
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

case 48: // Неизменяемые коллекции
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

case 49: // LinkedHashMap, TreeMap
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

case 50: // Comparable и Comparator
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

case 51: // Лямбды и Stream API
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
	
            default:
                tvTitle.setText("Тема в разработке");
                tvTheory.setText("Эта тема скоро появится!");
                tvCode.setText("// Скоро...");
                tvOutput.setText("Результат будет здесь");
                tvAnalogy.setText("Загляни позже!");
                break;
        }
        
        setTitle((index + 1) + ". " + tvTitle.getText());
    }
}