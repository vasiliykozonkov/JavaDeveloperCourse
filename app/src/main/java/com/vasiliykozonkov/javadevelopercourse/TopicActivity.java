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
				
				
				
				// Исключения
                
			case 31:
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

case 32: // Иерархия исключений
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

case 33: // Способы обработки исключений
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

case 34: // try с ресурсами
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

case 35: // Ввод-вывод
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

case 36: // Классы потоков ввода-вывода
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

case 37: // Правила работы с потоками I/O
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

case 38: // Сериализация
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

case 39: // Алгоритмы
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

case 40: // Big O notation
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

case 41: // Виды сортировок
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

case 42: // Generics
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

case 43: // Коллекции
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

case 44: // Иерархия коллекций
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

case 45: // List
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

case 46: // Set
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

case 47: // Map
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

case 48: // Временная сложность коллекций
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

case 49: // Неизменяемые коллекции
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

case 50: // LinkedHashMap, TreeMap
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

case 51: // Comparable и Comparator
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

case 52: // Лямбды и Stream API
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
	
	case 53: // SOLID
    tvTitle.setText("SOLID принципы");
    tvTheory.setText(
        "**SOLID** — 5 принципов ООП для хорошего кода:\n\n" +
        "**S** — Single Responsibility (Единая ответственность)\n" +
        "• Класс должен иметь только одну причину для изменения\n" +
        "• Один класс = одна задача\n\n" +
        "**O** — Open/Closed (Открыт/Закрыт)\n" +
        "• Открыт для расширения, закрыт для модификации\n" +
        "• Добавляем функционал через наследование\n\n" +
        "**L** — Liskov Substitution (Подстановка Лисков)\n" +
        "• Объекты дочерних классов должны заменять родительские\n" +
        "• Наследник не должен ломать поведение родителя\n\n" +
        "**I** — Interface Segregation (Разделение интерфейсов)\n" +
        "• Много маленьких интерфейсов лучше одного большого\n" +
        "• Класс не должен реализовывать ненужные методы\n\n" +
        "**D** — Dependency Inversion (Инверсия зависимостей)\n" +
        "• Зависеть от абстракций, а не от конкретных классов\n" +
        "• Использовать интерфейсы вместо реализаций"
    );
    tvCode.setText(
        "// S — Single Responsibility\n" +
        "class User { private String name; }\n" +
        "class UserRepository { void save(User u) { } }\n\n" +
        "// O — Open/Closed\n" +
        "interface Shape { double area(); }\n" +
        "class Circle implements Shape { }\n" +
        "class Square implements Shape { }\n\n" +
        "// D — Dependency Inversion\n" +
        "interface Database { void save(String data); }\n" +
        "class MySQL implements Database { }\n" +
        "class PostgreSQL implements Database { }"
    );
    tvOutput.setText(
        "Преимущества SOLID:\n" +
        "✅ Код легче понимать\n" +
        "✅ Легче тестировать\n" +
        "✅ Легче поддерживать\n" +
        "✅ Меньше багов при изменениях"
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **S** = Один нож = одна задача \n" +
        "• **O** = Розетка (включаешь новый прибор без переделки проводки) 🔌\n" +
        "• **L** = Пульт от ТВ работает и от DVD 📺\n" +
        "• **I** = Меню ресторана (разделы: напитки, еда) 📋\n" +
        "• **D** = USB-разъём (любой девайс подходит) "
    );
    break;

case 54: // Паттерны проектирования
    tvTitle.setText("Паттерны проектирования");
    tvTheory.setText(
        "**Паттерн** — типовое решение распространённой проблемы\n\n" +
        "**Порождающие:**\n" +
        "• **Singleton** — только один экземпляр класса\n" +
        "• **Factory** — создание объектов через фабрику\n" +
        "• **Builder** — пошаговое создание сложных объектов\n\n" +
        "**Структурные:**\n" +
        "• **Adapter** — адаптер несовместимых интерфейсов\n" +
        "• **Decorator** — добавление функциональности\n" +
        "• **Facade** — простой интерфейс к сложной системе\n\n" +
        "**Поведенческие:**\n" +
        "• **Observer** — подписка на изменения\n" +
        "• **Strategy** — семейство алгоритмов\n" +
        "• **Command** — инкапсуляция запроса как объекта"
    );
    tvCode.setText(
        "// Singleton\n" +
        "class Database {\n" +
        "    private static Database instance;\n" +
        "    private Database() { }\n" +
        "    public static Database getInstance() {\n" +
        "        if (instance == null)\n" +
        "            instance = new Database();\n" +
        "        return instance;\n" +
        "    }\n" +
        "}\n\n" +
        "// Factory\n" +
        "interface Animal { void speak(); }\n" +
        "class Dog implements Animal { }\n" +
        "class Cat implements Animal { }\n" +
        "class AnimalFactory {\n" +
        "    Animal create(String type) {\n" +
        "        if (type.equals(\"dog\")) return new Dog();\n" +
        "        return new Cat();\n" +
        "    }\n" +
        "}"
    );
    tvOutput.setText(
        "Database db1 = Database.getInstance();\n" +
        "Database db2 = Database.getInstance();\n" +
        "db1 == db2  // true! Один объект\n\n" +
        "AnimalFactory f = new AnimalFactory();\n" +
        "Animal dog = f.create(\"dog\");  // Dog"
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **Singleton** = Президент страны (только один) 👔\n" +
        "• **Factory** = Ресторан (меню создаёт блюда) 🍽️\n" +
        "• **Builder** = Сборка компьютера по частям 💻\n" +
        "• **Adapter** = Переходник для розетки \n" +
        "• **Observer** = Подписка на YouTube-канал 🔔"
    );
    break;

case 55: // Git углублённо
    tvTitle.setText("Git — углублённо");
    tvTheory.setText(
        "**Git** — система контроля версий\n\n" +
        "**Основные понятия:**\n" +
        "• **Репозиторий** — папка с историей\n" +
        "• **Коммит** — сохранение состояния\n" +
        "• **Ветка** — параллельная разработка\n" +
        "• **Тег** — закладка версии (v1.0)\n" +
        "• **HEAD** — указатель на текущий коммит\n\n" +
        "**Ежедневный workflow:**\n" +
        "1. git status — проверить статус\n" +
        "2. git add . — добавить файлы\n" +
        "3. git commit -m \"...\" — сохранить\n" +
        "4. git push — отправить на GitHub\n\n" +
        "**Важно:**\n" +
        "• Коммить каждые 30-60 минут\n" +
        "• Понятные сообщения коммитов\n" +
        "• Не коммитить .class, target/, .settings/"
    );
    tvCode.setText(
        "# Настройка (один раз)\n" +
        "git config --global user.name \"Имя\"\n" +
        "git config --global user.email \"email@test.com\"\n\n" +
        "# Создание репозитория\n" +
        "git init                    # Инициализировать\n" +
        "git clone <URL>             # Скачать\n\n" +
        "# Ежедневная работа\n" +
        "git status                  # Статус\n" +
        "git add .                   # Добавить все\n" +
        "git commit -m \"Сообщение\"   # Сохранить\n" +
        "git push origin master      # Отправить\n" +
        "git pull origin master      # Скачать"
    );
    tvOutput.setText(
        "$ git status\n" +
        "On branch master\n" +
        "Changes not staged:\n" +
        "  modified:   Main.java\n\n" +
        "$ git log --oneline\n" +
        "abc1234 Добавил Git тему\n" +
        "def5678 Исправил баг"
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **Git** = Машина времени для кода ⏰\n" +
        "• **Коммит** = Сохранение в игре \n" +
        "• **Ветка** = Черновик главы книги ✍️\n" +
        "• **Тег** = Закладка в книге 🔖\n" +
        "• **GitHub** = Google Drive для кода ☁️"
    );
    break;

case 56: // push, pull, fetch
    tvTitle.setText("push, pull, fetch");
    tvTheory.setText(
        "**Три команды для работы с удалённым репозиторием**\n\n" +
        "**git push** — отправить ваши коммиты на GitHub\n" +
        "• Загружает изменения из локального репозитория\n" +
        "• Другие разработчики видят ваши изменения\n\n" +
        "**git pull** — скачать изменения с GitHub и сразу слить\n" +
        "• Это комбинация fetch + merge\n" +
        "• Получаете последние изменения коллег\n\n" +
        "**git fetch** — только скачать изменения, НЕ сливать\n" +
        "• Безопаснее, чем pull\n" +
        "• Можно сначала посмотреть, что изменилось\n\n" +
        "**Разница:**\n" +
        "• pull = fetch + merge (сразу сливает)\n" +
        "• fetch = только скачать (вы решаете, что делать)"
    );
    tvCode.setText(
        "// Отправить изменения на GitHub\n" +
        "git push origin master\n\n" +
        "// Скачать и слить изменения\n" +
        "git pull origin master\n\n" +
        "// Только скачать (без слияния)\n" +
        "git fetch origin\n\n" +
        "// Посмотреть, что скачалось\n" +
        "git log origin/master\n\n" +
        "// Слить вручную после fetch\n" +
        "git merge origin/master\n\n" +
        "// Pull с rebase (более чистая история)\n" +
        "git pull --rebase origin master"
    );
    tvOutput.setText(
        "$ git push origin master\n" +
        "To github.com:user/repo.git\n" +
        "   abc1234..def5678  master -> master\n\n" +
        "$ git fetch origin\n" +
        "From github.com:user/repo\n" +
        "   abc1234..ghi9012  master -> origin/master\n\n" +
        "$ git pull origin master\n" +
        "Already up to date."
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **push** = Отправить письмо по почте 📮\n" +
        "• **pull** = Скачать обновления приложения 📥\n" +
        "• **fetch** = Посмотреть, есть ли новые письма, но не открывать 📬\n\n" +
        "**Когда что использовать:**\n" +
        "✅ push — после коммита\n" +
        "✅ pull — утром, перед началом работы\n" +
        "✅ fetch — когда хотите сначала посмотреть изменения"
    );
    break;

case 57: // merge и rebase
    tvTitle.setText("Слияние веток: merge и rebase");
    tvTheory.setText(
        "**Два способа объединить ветки**\n\n" +
        "**git merge** — создаёт коммит слияния\n" +
        "• Сохраняет полную историю\n" +
        "• Видно, когда и что сливалось\n" +
        "• История выглядит как граф с ветками\n\n" +
        "**git rebase** — перемещает коммиты на другую ветку\n" +
        "• Делает историю линейной\n" +
        "• Убирает \"шум\" от коммитов слияния\n" +
        "• Переписывает историю (опасно!)\n\n" +
        "**Когда что использовать:**\n" +
        "• merge — для слияния feature-веток в main\n" +
        "• rebase — для обновления feature-ветки\n\n" +
        "**Правило:**\n" +
        "Никогда не делайте rebase опубликованных коммитов!"
    );
    tvCode.setText(
        "// MERGE\n" +
        "git checkout main\n" +
        "git merge feature-login\n" +
        "// Создаёт коммит слияния\n\n" +
        "// REBASE\n" +
        "git checkout feature-login\n" +
        "git rebase main\n" +
        "// Перемещает коммиты feature на вершину main\n\n" +
        "// Пример workflow:\n" +
        "1. git checkout feature\n" +
        "2. git rebase main\n" +
        "3. git checkout main\n" +
        "4. git merge feature"
    );
    tvOutput.setText(
        "MERGE:\n" +
        "C0 → C1 → C2 → C3 (main)\n" +
        "           ↘     ↗\n" +
        "            C4 → C5 (merge commit)\n\n" +
        "REBASE:\n" +
        "C0 → C1 → C2 → C3 (main)\n" +
        "                  → C4' → C5' (feature)\n\n" +
        "$ git merge feature\n" +
        "Merge made by the 'recursive' strategy."
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **merge** = Склеить две ветки дерева 🌳\n" +
        "• **rebase** = Пересадить ветку на другое дерево 🌱\n\n" +
        "**merge:**\n" +
        "— Сохраняет историю как есть\n" +
        "— Видно, кто и когда сливал\n" +
        "— Безопасно\n\n" +
        "**rebase:**\n" +
        "— Делает историю чистой и линейной\n" +
        "— Как будто вы начали работу позже\n" +
        "— Опасно для опубликованных коммитов"
    );
    break;
	
	case 58: // cherry-pick и squash
    tvTitle.setText("cherry-pick и squash");
    tvTheory.setText(
        "**cherry-pick** — взять конкретный коммит и применить его\n" +
        "• Не нужно сливать всю ветку\n" +
        "• Можно взять один коммит из другой ветки\n" +
        "• Создаёт копию коммита в текущей ветке\n\n" +
        "**squash** — объединить несколько коммитов в один\n" +
        "• Делает историю чище\n" +
        "• Убирает промежуточные коммиты\n" +
        "• Делается через rebase -i\n\n" +
        "**Когда использовать:**\n" +
        "• cherry-pick — нужно взять только один фикс\n" +
        "• squash — перед merge, чтобы объединить мелкие коммиты"
    );
    tvCode.setText(
        "// CHERRY-PICK\n" +
        "git checkout main\n" +
        "git cherry-pick abc1234\n" +
        "// Берёт коммит abc1234 и применяет к main\n\n" +
        "// Взять несколько коммитов\n" +
        "git cherry-pick abc1234 def5678\n\n" +
        "// SQUASH через rebase\n" +
        "git rebase -i HEAD~3\n" +
        "// В редакторе:\n" +
        "// pick abc1234 Первый коммит\n" +
        "// squash def5678 Второй коммит\n" +
        "// squash ghi9012 Третий коммит\n\n" +
        "// SQUASH при merge\n" +
        "git merge --squash feature\n" +
        "git commit -m \"Все изменения в одном коммите\""
    );
    tvOutput.setText(
        "$ git cherry-pick abc1234\n" +
        "[main def5678] Исправил баг в логине\n" +
        " 1 file changed, 2 insertions(+)\n\n" +
        "$ git rebase -i HEAD~3\n" +
        "pick abc1234 Первый коммит\n" +
        "squash def5678 Второй коммит\n" +
        "squash ghi9012 Третий коммит\n\n" +
        "Результат: один коммит вместо трёх!"
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **cherry-pick** = Выбрать одну вишню из корзины 🍒\n" +
        "• **squash** = Сжать несколько файлов в один архив 📦\n\n" +
        "**cherry-pick:**\n" +
        "— Берёте только нужное\n" +
        "— Остальное игнорируете\n" +
        "— Как копипаст коммита\n\n" +
        "**squash:**\n" +
        "— Объединяете мелочи в одно\n" +
        "— Чище история\n" +
        "— Как \"сохранить как\" в редакторе"
    );
    break;

case 59: // patch и stash
    tvTitle.setText("patch и stash");
    tvTheory.setText(
        "**git stash** — временно отложить изменения\n" +
        "• Сохраняет незакоммиченные изменения\n" +
        "• Очищает рабочую директорию\n" +
        "• Можно вернуться к изменениям позже\n" +
        "• Удобно, когда нужно переключить ветку\n\n" +
        "**patch** — файл с изменениями\n" +
        "• Можно отправить патч по почте\n" +
        "• Применить патч к другому репозиторию\n" +
        "• Не требует общего репозитория\n\n" +
        "**Когда использовать stash:**\n" +
        "• Начали работу, но нужно срочно переключиться\n" +
        "• Хотите попробовать что-то, не коммитя\n" +
        "• Нужно pull, но есть незакоммиченные изменения"
    );
    tvCode.setText(
        "// STASH\n" +
        "git stash                    // Сохранить изменения\n" +
        "git stash list               // Показать сохранённые\n" +
        "git stash pop                // Вернуть и удалить из stash\n" +
        "git stash apply              // Вернуть, но оставить в stash\n" +
        "git stash drop               // Удалить из stash\n" +
        "git stash clear              // Очистить весь stash\n\n" +
        "// Именованный stash\n" +
        "git stash save \"WIP: логин\"\n\n" +
        "// PATCH\n" +
        "git diff > changes.patch     // Создать патч\n" +
        "git apply changes.patch      // Применить патч"
    );
    tvOutput.setText(
        "$ git stash\n" +
        "Saved working directory and index state WIP on master\n\n" +
        "$ git stash list\n" +
        "stash@{0}: WIP on master: abc1234 Временные изменения\n" +
        "stash@{1}: WIP on feature: def5678 Другая работа\n\n" +
        "$ git stash pop\n" +
        "On branch master\n" +
        "Changes not staged for commit:\n" +
        "  modified:   Main.java"
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **stash** = Положить работу в ящик стола 🗄️\n" +
        "• **patch** = Заплатка на одежду 🧵\n\n" +
        "**stash:**\n" +
        "— Отложили, занялись другим\n" +
        "— Вернулись, достали из ящика\n" +
        "— Как черновик в почте\n\n" +
        "**patch:**\n" +
        "— Файл с изменениями\n" +
        "— Можно передать другому\n" +
        "— Как diff, но в файле"
    );
    break;

case 60: // reset и revert
    tvTitle.setText("reset и revert");
    tvTheory.setText(
        "**git reset** — отменить коммиты (локально)\n" +
        "• --soft: отменить коммит, сохранить изменения\n" +
        "• --mixed: отменить коммит и add (по умолчанию)\n" +
        "• --hard: полностью удалить коммит и изменения\n" +
        "• ⚠️ Опасно для опубликованных коммитов!\n\n" +
        "**git revert** — отменить коммит новым коммитом\n" +
        "• Создаёт новый коммит с обратными изменениями\n" +
        "• История не ломается\n" +
        "• Безопасно для опубликованных коммитов\n\n" +
        "**Когда что использовать:**\n" +
        "• reset — для локальных коммитов, которые ещё не запушили\n" +
        "• revert — для опубликованных коммитов"
    );
    tvCode.setText(
        "// RESET\n" +
        "git reset --soft HEAD~1      // Отменить коммит, изменения в индексе\n" +
        "git reset --mixed HEAD~1     // Отменить коммит и add\n" +
        "git reset --hard HEAD~1      // Полностью удалить (ОПАСНО!)\n\n" +
        "// Отменить несколько коммитов\n" +
        "git reset --hard HEAD~3\n\n" +
        "// REVERT\n" +
        "git revert abc1234           // Отменить конкретный коммит\n" +
        "git revert HEAD              // Отменить последний коммит\n" +
        "git revert --no-commit HEAD  // Отменить без создания коммита"
    );
    tvOutput.setText(
        "$ git reset --soft HEAD~1\n" +
        "Changes to be committed:\n" +
        "  modified:   Main.java\n\n" +
        "$ git revert abc1234\n" +
        "[main def5678] Revert \"Добавил фичу\"\n" +
        " 1 file changed, 2 deletions(-)\n\n" +
        "История:\n" +
        "abc1234 Добавил фичу\n" +
        "def5678 Revert \"Добавил фичу\"  ← Новый коммит!"
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **reset** = Стереть написанное ластиком 🧹\n" +
        "• **revert** = Написать исправление поверх ошибки ✏️\n\n" +
        "**reset:**\n" +
        "— Как будто коммита не было\n" +
        "— История меняется\n" +
        "— Опасно для общих коммитов\n\n" +
        "**revert:**\n" +
        "— Создаёт новый коммит\n" +
        "— История сохраняется\n" +
        "— Безопасно"
    );
    break;
	
	case 61: // Gradle и Maven
    tvTitle.setText("Сборщики проектов: Gradle и Maven");
    tvTheory.setText(
        "**Сборщик** — инструмент для автоматизации сборки проекта\n\n" +
        "**Maven:**\n" +
        "• Использует XML (pom.xml)\n" +
        "• Строгая структура проекта\n" +
        "• Конвенция важнее конфигурации\n" +
        "• Зрелый, стабильный\n" +
        "• Медленнее Gradle\n\n" +
        "**Gradle:**\n" +
        "• Использует Groovy/Kotlin DSL\n" +
        "• Гибкая конфигурация\n" +
        "• Быстрее Maven (инкрементальная сборка)\n" +
        "• Используется в Android\n" +
        "• Более современный\n\n" +
        "**Что делают сборщики:**\n" +
        "• Компиляция кода\n" +
        "• Управление зависимостями\n" +
        "• Запуск тестов\n" +
        "• Создание JAR/APK\n" +
        "• Деплой"
    );
    tvCode.setText(
        "// MAVEN (pom.xml)\n" +
        "<project>\n" +
        "    <dependencies>\n" +
        "        <dependency>\n" +
        "            <groupId>junit</groupId>\n" +
        "            <artifactId>junit</artifactId>\n" +
        "            <version>4.12</version>\n" +
        "        </dependency>\n" +
        "    </dependencies>\n" +
        "</project>\n\n" +
        "// GRADLE (build.gradle)\n" +
        "dependencies {\n" +
        "    implementation 'junit:junit:4.12'\n" +
        "    implementation 'com.google.code.gson:gson:2.8.6'\n" +
        "}\n\n" +
        "// Команды Maven:\n" +
        "mvn compile        // Компиляция\n" +
        "mvn test           // Тесты\n" +
        "mvn package        // Создать JAR\n" +
        "mvn install        // Установить локально"
    );
    tvOutput.setText(
        "Maven:\n" +
        "$ mvn clean install\n" +
        "[INFO] BUILD SUCCESS\n" +
        "[INFO] Total time: 15.234 s\n\n" +
        "Gradle:\n" +
        "$ ./gradlew build\n" +
        "BUILD SUCCESSFUL in 8s\n" +
        "12 actionable tasks: 10 executed, 2 up-to-date"
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **Maven** = IKEA (строгие инструкции, всё по стандарту) 🛋️\n" +
        "• **Gradle** = Конструктор LEGO (гибко, можно по-разному) \n\n" +
        "**Maven:**\n" +
        "— Простой, предсказуемый\n" +
        "— Много проектов используют\n" +
        "— XML многословный\n\n" +
        "**Gradle:**\n" +
        "— Гибкий, мощный\n" +
        "— Быстрее\n" +
        "— Стандарт для Android"
    );
    break;

case 62: // Этапы сборки Maven
    tvTitle.setText("Этапы сборки в Maven");
    tvTheory.setText(
        "**Maven Lifecycle** — последовательность этапов сборки\n\n" +
        "**default lifecycle:**\n" +
        "1. **validate** — проверка структуры проекта\n" +
        "2. **compile** — компиляция исходного кода\n" +
        "3. **test** — запуск тестов\n" +
        "4. **package** — упаковка в JAR/WAR\n" +
        "5. **verify** — проверка качества\n" +
        "6. **install** — установка в локальный репозиторий\n" +
        "7. **deploy** — публикация в удалённый репозиторий\n\n" +
        "**Важно:**\n" +
        "• Запуск любого этапа выполняет все предыдущие\n" +
        "• mvn test → выполнит validate, compile, test\n" +
        "• mvn package → выполнит все до package\n\n" +
        "**Другие lifecycle:**\n" +
        "• clean — очистка (mvn clean)\n" +
        "• site — генерация документации"
    );
    tvCode.setText(
        "// Запуск этапов\n" +
        "mvn validate              // Проверка\n" +
        "mvn compile               // Компиляция\n" +
        "mvn test                  // Тесты\n" +
        "mvn package               // Создать JAR\n" +
        "mvn install               // Установить локально\n" +
        "mvn deploy                // Опубликовать\n\n" +
        "// Комбинации\n" +
        "mvn clean install         // Очистить и установить\n" +
        "mvn clean package         // Очистить и упаковать\n" +
        "mvn test -Dtest=MyTest    // Запустить конкретный тест\n\n" +
        "// Пропустить тесты\n" +
        "mvn package -DskipTests"
    );
    tvOutput.setText(
        "$ mvn clean install\n" +
        "[INFO] --- maven-clean-plugin:3.1.0:clean ---\n" +
        "[INFO] Deleting target\n" +
        "[INFO] --- maven-compile-plugin:3.8.1:compile ---\n" +
        "[INFO] Compiling 15 source files\n" +
        "[INFO] --- maven-test-plugin:2.22.2:test ---\n" +
        "[INFO] Tests run: 42, Failures: 0\n" +
        "[INFO] --- maven-jar-plugin:3.2.0:jar ---\n" +
        "[INFO] Building jar: target/app-1.0.jar\n" +
        "[INFO] BUILD SUCCESS"
    );
    tvAnalogy.setText(
        "Аналогия с заводом:\n" +
        "• **validate** = Проверка чертежей 📋\n" +
        "• **compile** = Производство деталей 🔧\n" +
        "• **test** = Контроль качества ✅\n" +
        "• **package** = Упаковка в коробку 📦\n" +
        "• **install** = Склад завода \n" +
        "• **deploy** = Доставка в магазин 🚚\n\n" +
        "**Запуск любого этапа = выполнение всех предыдущих!**"
    );
    break;

case 63: // Где хранятся зависимости
    tvTitle.setText("Где хранятся зависимости");
    tvTheory.setText(
        "**Локальный репозиторий** — папка на вашем компьютере\n\n" +
        "**Maven:**\n" +
        "• Путь: `~/.m2/repository/`\n" +
        "• Структура: groupId/artifactId/version/\n" +
        "• Пример: `~/.m2/repository/junit/junit/4.12/`\n\n" +
        "**Gradle:**\n" +
        "• Путь: `~/.gradle/caches/`\n" +
        "• Структура: modules-2/files-2.1/\n" +
        "• Пример: `~/.gradle/caches/modules-2/files-2.1/junit/`\n\n" +
        "**Как это работает:**\n" +
        "1. Сборщик проверяет локальный репозиторий\n" +
        "2. Если зависимости нет — скачивает из интернета\n" +
        "3. Сохраняет в локальный репозиторий\n" +
        "4. В следующий раз берёт из локального\n\n" +
        "**Центральный репозиторий:**\n" +
        "• Maven Central: repo1.maven.org\n" +
        "• Google: maven.google.com"
    );
    tvCode.setText(
        "// Посмотреть локальный репозиторий Maven\n" +
        "ls ~/.m2/repository/\n\n" +
        "// Очистить кеш Maven\n" +
        "mvn dependency:purge-local-repository\n\n" +
        "// Очистить кеш Gradle\n" +
        "./gradlew cleanBuildCache\n\n" +
        "// Посмотреть зависимости проекта\n" +
        "mvn dependency:tree\n" +
        "./gradlew dependencies\n\n" +
        "// Принудительно обновить зависимости\n" +
        "mvn clean install -U\n" +
        "./gradlew build --refresh-dependencies"
    );
    tvOutput.setText(
        "Структура ~/.m2/repository/:\n" +
        "junit/\n" +
        "  junit/\n" +
        "    4.12/\n" +
        "      junit-4.12.jar\n" +
        "      junit-4.12.pom\n\n" +
        "$ mvn dependency:tree\n" +
        "[INFO] com.example:my-app:jar:1.0\n" +
        "[INFO] +- junit:junit:jar:4.12:test\n" +
        "[INFO] \\- org.hamcrest:hamcrest-core:jar:1.3:test"
    );
    tvAnalogy.setText(
        "Аналогия:\n" +
        "• **Локальный репозиторий** = Ваша библиотека дома 📚\n" +
        "• **Центральный репозиторий** = Городская библиотека 🏛️\n" +
        "• **Зависимость** = Книга 📖\n\n" +
        "**Процесс:**\n" +
        "1. Нужна книга? Проверяете домашнюю библиотеку\n" +
        "2. Нет? Идёте в городскую библиотеку\n" +
        "3. Берёте книгу домой\n" +
        "4. В следующий раз она уже дома!\n\n" +
        "**Очистка кеша** = Выбросить старые книги"
    );
    break;
	
	case 64: // Многопоточность
    tvTitle.setText("Многопоточность");
    tvTheory.setText(
        "**Многопоточность** — выполнение нескольких задач одновременно\n\n" +
        "**Процесс vs Поток:**\n" +
        "• **Процесс** — независимая программа (своя память)\n" +
        "• **Поток** — лёгкая единица выполнения внутри процесса\n" +
        "• Потоки одного процесса разделяют память\n\n" +
        "**Зачем нужна многопоточность:**\n" +
        "• Использовать несколько ядер CPU\n" +
        "• Не блокировать UI при долгих операциях\n" +
        "• Обрабатывать множество клиентов (сервер)\n" +
        "• Параллельные вычисления\n\n" +
        "**Проблемы многопоточности:**\n" +
        "• Состояние гонки (race condition)\n" +
        "• Дедлоки (взаимная блокировка)\n" +
        "• Непредсказуемый порядок выполнения"
    );
    tvCode.setText(
        "// Создание потока через Runnable\n" +
        "Runnable task = () -> {\n" +
        "    System.out.println(\"Поток: \" + \n" +
        "        Thread.currentThread().getName());\n" +
        "};\n" +
        "Thread thread = new Thread(task);\n" +
        "thread.start();\n\n" +
        "// Создание потока через наследование\n" +
        "class MyThread extends Thread {\n" +
        "    public void run() {\n" +
        "        System.out.println(\"Работаю...\");\n" +
        "    }\n" +
        "}\n" +
        "new MyThread().start();\n\n" +
        "// Главный поток\n" +
        "public static void main(String[] args) {\n" +
        "    System.out.println(\"Главный: \" + \n" +
        "        Thread.currentThread().getName());\n" +
        "}"
    );
    tvOutput.setText(
        "Главный поток: main\n" +
        "Поток: Thread-0\n" +
        "Работаю...\n\n" +
        "Потоки выполняются параллельно!\n" +
        "Порядок вывода может меняться."
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **Процесс** = Ресторан 🍽️\n" +
        "• **Поток** = Официант в ресторане 👨‍\n" +
        "• **Многопоточность** = Несколько официантов обслуживают столики одновременно\n\n" +
        "**Преимущества:**\n" +
        "✅ Быстрее (параллельная работа)\n" +
        "✅ Отзывчивость (UI не зависает)\n" +
        "✅ Эффективность (использование CPU)\n\n" +
        "**Недостатки:**\n" +
        " Сложнее отлаживать\n" +
        "❌ Проблемы синхронизации\n" +
        "❌ Race conditions"
    );
    break;

case 65: // Способы создания потоков
    tvTitle.setText("Способы создания потоков");
    tvTheory.setText(
        "**3 способа создать поток в Java:**\n\n" +
        "**1. Наследование Thread:**\n" +
        "• Простой способ\n" +
        "• Ограничение: нельзя наследовать другой класс\n" +
        "• Переопределить метод run()\n\n" +
        "**2. Реализация Runnable:**\n" +
        "• Более гибкий (можно наследовать другой класс)\n" +
        "• Разделяет задачу и поток\n" +
        "• Рекомендуется чаще\n\n" +
        "**3. Реализация Callable:**\n" +
        "• Может возвращать результат\n" +
        "• Может выбрасывать исключения\n" +
        "• Используется с ExecutorService\n\n" +
        "**Какой способ выбрать?**\n" +
        "• Runnable — для простых задач\n" +
        "• Callable — когда нужен результат\n" +
        "• Thread — редко, только если нужно переопределить поведение потока"
    );
    tvCode.setText(
        "// Способ 1: Наследование Thread\n" +
        "class MyThread extends Thread {\n" +
        "    public void run() {\n" +
        "        System.out.println(\"Поток 1\");\n" +
        "    }\n" +
        "}\n" +
        "new MyThread().start();\n\n" +
        "// Способ 2: Runnable (рекомендуется)\n" +
        "class MyTask implements Runnable {\n" +
        "    public void run() {\n" +
        "        System.out.println(\"Поток 2\");\n" +
        "    }\n" +
        "}\n" +
        "new Thread(new MyTask()).start();\n\n" +
        "// Способ 3: Callable (с результатом)\n" +
        "Callable<Integer> task = () -> {\n" +
        "    return 42;\n" +
        "};\n" +
        "ExecutorService executor = \n" +
        "    Executors.newSingleThreadExecutor();\n" +
        "Future<Integer> future = executor.submit(task);\n" +
        "Integer result = future.get(); // 42"
    );
    tvOutput.setText(
        "Поток 1\n" +
        "Поток 2\n" +
        "Результат: 42\n\n" +
        "Разница:\n" +
        "• Thread — простой, но ограниченный\n" +
        "• Runnable — гибкий, рекомендуемый\n" +
        "• Callable — с возвратом результата"
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **Thread** = Работник с фиксированной должностью 👷\n" +
        "• **Runnable** = Фрилансер (можно нанять для любой задачи) 🧑‍💻\n" +
        "• **Callable** = Фрилансер, который отчитывается о результате 📊\n\n" +
        "**Почему Runnable лучше Thread:**\n" +
        "✅ Можно наследовать другой класс\n" +
        "✅ Разделяет задачу и выполнение\n" +
        "✅ Можно переиспользовать"
    );
    break;

case 66: // Состояния потоков
    tvTitle.setText("Виды состояния потоков");
    tvTheory.setText(
        "**Жизненный цикл потока:**\n\n" +
        "**1. NEW** — создан, но не запущен\n" +
        "• Thread t = new Thread()\n" +
        "• Ещё не вызван start()\n\n" +
        "**2. RUNNABLE** — готов к выполнению\n" +
        "• Вызван start()\n" +
        "• Ждёт процессорное время\n\n" +
        "**3. BLOCKED** — заблокирован\n" +
        "• Ждёт монитор (synchronized)\n" +
        "• Не может выполняться\n\n" +
        "**4. WAITING** — ожидает уведомления\n" +
        "• Вызван wait()\n" +
        "• Ждёт notify() или notifyAll()\n\n" +
        "**5. TIMED_WAITING** — ожидает с таймаутом\n" +
        "• Вызван sleep(), wait(timeout), join(timeout)\n\n" +
        "**6. TERMINATED** — завершён\n" +
        "• Метод run() завершился\n" +
        "• Поток больше не существует"
    );
    tvCode.setText(
        "Thread t = new Thread(() -> {\n" +
        "    // RUNNABLE\n" +
        "    try {\n" +
        "        Thread.sleep(1000);  // TIMED_WAITING\n" +
        "        synchronized(obj) {  // BLOCKED если занято\n" +
        "            obj.wait();      // WAITING\n" +
        "        }\n" +
        "    } catch (InterruptedException e) { }\n" +
        "});\n" +
        "// NEW\n" +
        "t.start();  // RUNNABLE\n" +
        "// ... выполнение ...\n" +
        "// TERMINATED"
    );
    tvOutput.setText(
        "Состояния:\n" +
        "NEW → RUNNABLE → RUNNING → TERMINATED\n" +
        "                    ↓\n" +
        "              BLOCKED/WAITING\n" +
        "                    ↓\n" +
        "                  RUNNABLE\n\n" +
        "Thread.getState():\n" +
        "NEW, RUNNABLE, BLOCKED, WAITING, \n" +
        "TIMED_WAITING, TERMINATED"
    );
    tvAnalogy.setText(
        "Аналогия с работником:\n" +
        "• **NEW** = Нанят, но ещё не начал работу 📝\n" +
        "• **RUNNABLE** = Готов работать, ждёт задачу ⏳\n" +
        "• **RUNNING** = Работает 🔧\n" +
        "• **BLOCKED** = Ждёт, пока освободится инструмент 🚫\n" +
        "• **WAITING** = Ждёт звонка от начальника 📞\n" +
        "• **TIMED_WAITING** = Взял перерыв на 10 минут ☕\n" +
        "• **TERMINATED** = Уволился 👋"
    );
    break;

case 67: // volatile
    tvTitle.setText("Ключевое слово volatile");
    tvTheory.setText(
        "**volatile** — гарантирует видимость изменений между потоками\n\n" +
        "**Проблема:**\n" +
        "• Каждый поток может кэшировать переменную\n" +
        "• Изменения в одном потоке не видны другому\n" +
        "• Получаем устаревшие данные\n\n" +
        "**Решение — volatile:**\n" +
        "• Запрещает кэширование переменной\n" +
        "• Все чтения/записи идут в основную память\n" +
        "• Изменения сразу видны всем потокам\n\n" +
        "**Когда использовать:**\n" +
        "• Флаги остановки потока (boolean running)\n" +
        "• Простые переменные, которые читают/пишут разные потоки\n" +
        "• Не защищает от race condition!\n\n" +
        "**volatile vs synchronized:**\n" +
        "• volatile — только видимость, не атомарность\n" +
        "• synchronized — видимость + атомарность + блокировка"
    );
    tvCode.setText(
        "// Без volatile — проблема!\n" +
        "class Worker {\n" +
        "    private boolean running = true;  // Кэшируется!\n" +
        "    \n" +
        "    public void run() {\n" +
        "        while (running) {  // Может не увидеть изменение\n" +
        "            // работа...\n" +
        "        }\n" +
        "    }\n" +
        "    \n" +
        "    public void stop() {\n" +
        "        running = false;  // Другой поток может не увидеть!\n" +
        "    }\n" +
        "}\n\n" +
        "// С volatile — работает!\n" +
        "class Worker {\n" +
        "    private volatile boolean running = true;\n" +
        "    // Теперь изменения видны всем потокам\n" +
        "}"
    );
    tvOutput.setText(
        "Без volatile:\n" +
        "Поток 1: running = false\n" +
        "Поток 2: всё ещё видит running = true (из кэша) ❌\n\n" +
        "С volatile:\n" +
        "Поток 1: running = false\n" +
        "Поток 2: сразу видит running = false ✅"
    );
    tvAnalogy.setText(
        "Аналогия:\n" +
        "• **Без volatile** = У каждого работника своя копия документа 📄\n" +
        "• **С volatile** = Все работают с одним документом на столе 📋\n\n" +
        "**volatile гарантирует:**\n" +
        "✅ Видимость изменений\n" +
        "✅ Порядок операций (happens-before)\n\n" +
        "**volatile НЕ гарантирует:**\n" +
        "❌ Атомарность (i++ всё ещё не безопасно)\n" +
        "❌ Защиту от race condition"
    );
    break;

case 68: // Проблемы многопоточности
    tvTitle.setText("Проблемы многопоточности");
    tvTheory.setText(
        "**1. Race Condition (Состояние гонки):**\n" +
        "• Два потока изменяют одну переменную\n" +
        "• Результат зависит от порядка выполнения\n" +
        "• Непредсказуемое поведение\n\n" +
        "**2. Deadlock (Дедлок):**\n" +
        "• Два потока ждут друг друга\n" +
        "• Никто не может продолжить\n" +
        "• Программа зависает навсегда\n\n" +
        "**3. Livelock (Лайвлок):**\n" +
        "• Потоки активны, но не продвигаются\n" +
        "• Постоянно реагируют друг на друга\n" +
        "• Как два человека в коридоре, которые не могут разойтись\n\n" +
        "**Как избежать:**\n" +
        "• synchronized — блокировки\n" +
        "• Lock — явные блокировки\n" +
        "• Atomic — атомарные операции\n" +
        "• Правильный порядок захвата блокировок"
    );
    tvCode.setText(
        "// RACE CONDITION\n" +
        "int counter = 0;\n" +
        "// Поток 1: counter++ (читает 0, пишет 1)\n" +
        "// Поток 2: counter++ (читает 0, пишет 1)\n" +
        "// Результат: 1 вместо 2! ❌\n\n" +
        "// Решение: synchronized\n" +
        "synchronized(this) {\n" +
        "    counter++;\n" +
        "}\n\n" +
        "// DEADLOCK\n" +
        "synchronized(lock1) {\n" +
        "    synchronized(lock2) {  // Поток 1 ждёт lock2\n" +
        "        // ...\n" +
        "    }\n" +
        "}\n" +
        "synchronized(lock2) {\n" +
        "    synchronized(lock1) {  // Поток 2 ждёт lock1\n" +
        "        // ...\n" +
        "    }\n" +
        "}\n" +
        "// Оба ждут друг друга = DEADLOCK!"
    );
    tvOutput.setText(
        "Race Condition:\n" +
        "Ожидалось: 1000\n" +
        "Получилось: 987 ❌\n\n" +
        "Deadlock:\n" +
        "Поток 1: держит lock1, ждёт lock2\n" +
        "Поток 2: держит lock2, ждёт lock1\n" +
        "Программа зависла! ❌\n\n" +
        "Livelock:\n" +
        "Потоки работают, но не продвигаются 🔄"
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **Race Condition** = Два человека пишут в одну тетрадь одновременно ✍️\n" +
        "• **Deadlock** = Два автомобиля на перекрёстке, каждый ждёт другого \n" +
        "• **Livelock** = Два человека в коридоре, оба шагают в одну сторону 🚶\n\n" +
        "**Как избежать deadlock:**\n" +
        "✅ Всегда захватывать блокировки в одном порядке\n" +
        "✅ Использовать tryLock() с таймаутом\n" +
        "✅ Избегать вложенных блокировок"
    );
    break;
	
	case 69: // java.util.concurrent
    tvTitle.setText("Пакет java.util.concurrent");
    tvTheory.setText(
        "**java.util.concurrent** — пакет для многопоточного программирования\n\n" +
        "**Основные компоненты:**\n\n" +
        "**Executor Framework:**\n" +
        "• ExecutorService — управление пулом потоков\n" +
        "• Executors — фабрика для создания пулов\n" +
        "• ThreadPoolExecutor — настраиваемый пул\n\n" +
        "**Concurrent Collections:**\n" +
        "• ConcurrentHashMap — потокобезопасная HashMap\n" +
        "• CopyOnWriteArrayList — потокобезопасный ArrayList\n" +
        "• BlockingQueue — очередь с блокировкой\n\n" +
        "**Synchronizers:**\n" +
        "• CountDownLatch — ожидание завершения\n" +
        "• CyclicBarrier — барьер для потоков\n" +
        "• Semaphore — семафор\n" +
        "• Exchanger — обмен данными\n\n" +
        "**Atomic Variables:**\n" +
        "• AtomicInteger, AtomicLong\n" +
        "• AtomicReference\n" +
        "• Без блокировок (lock-free)"
    );
    tvCode.setText(
        "// ExecutorService\n" +
        "ExecutorService executor = \n" +
        "    Executors.newFixedThreadPool(4);\n" +
        "executor.submit(() -> {\n" +
        "    System.out.println(\"Работа в пуле\");\n" +
        "});\n" +
        "executor.shutdown();\n\n" +
        "// ConcurrentHashMap\n" +
        "ConcurrentHashMap<String, Integer> map = \n" +
        "    new ConcurrentHashMap<>();\n" +
        "map.put(\"key\", 42);  // Потокобезопасно\n\n" +
        "// BlockingQueue\n" +
        "BlockingQueue<String> queue = \n" +
        "    new LinkedBlockingQueue<>();\n" +
        "queue.put(\"task\");\n" +
        "String task = queue.take();\n\n" +
        "// CountDownLatch\n" +
        "CountDownLatch latch = new CountDownLatch(3);\n" +
        "latch.countDown();\n" +
        "latch.await();"
    );
    tvOutput.setText(
        "ExecutorService:\n" +
        "Создан пул из 4 потоков\n" +
        "Задача выполнена в pool-1-thread-1\n\n" +
        "ConcurrentHashMap:\n" +
        "Потокобезопасная работа без synchronized\n\n" +
        "CountDownLatch:\n" +
        "Главный поток ждёт завершения 3 задач"
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **ExecutorService** = Менеджер, распределяющий задачи между работниками 👔\n" +
        "• **ConcurrentHashMap** = Таблица, за которой работают несколько человек \n" +
        "• **BlockingQueue** = Конвейер на заводе 🏭\n" +
        "• **CountDownLatch** = Стартовый пистолет 🔫\n" +
        "• **Semaphore** = Парковка с ограниченным числом мест 🅿️"
    );
    break;

case 70: // Atomic
    tvTitle.setText("Atomic переменные");
    tvTheory.setText(
        "**Atomic** — атомарные операции без блокировок\n\n" +
        "**Проблема:**\n" +
        "• i++ не атомарно (чтение → изменение → запись)\n" +
        "• Нужен synchronized для безопасности\n" +
        "• Блокировки медленные\n\n" +
        "**Решение — Atomic:**\n" +
        "• Использует CAS (Compare-And-Swap)\n" +
        "• Атомарные операции без блокировок\n" +
        "• Быстрее synchronized\n\n" +
        "**Основные классы:**\n" +
        "• AtomicInteger — атомарный int\n" +
        "• AtomicLong — атомарный long\n" +
        "• AtomicBoolean — атомарный boolean\n" +
        "• AtomicReference — атомарная ссылка на объект\n\n" +
        "**Методы:**\n" +
        "• get() — получить значение\n" +
        "• set() — установить значение\n" +
        "• incrementAndGet() — увеличить и получить\n" +
        "• compareAndSet() — CAS операция"
    );
    tvCode.setText(
        "// Без Atomic (не безопасно)\n" +
        "int counter = 0;\n" +
        "counter++;  // Race condition!\n\n" +
        "// С Atomic (безопасно)\n" +
        "AtomicInteger counter = new AtomicInteger(0);\n" +
        "counter.incrementAndGet();  // Атомарно!\n\n" +
        "// Основные операции\n" +
        "AtomicInteger atomic = new AtomicInteger(10);\n" +
        "atomic.get();           // 10\n" +
        "atomic.set(20);         // Установить 20\n" +
        "atomic.incrementAndGet();  // 21\n" +
        "atomic.decrementAndGet();  // 20\n" +
        "atomic.addAndGet(5);    // 25\n\n" +
        "// CAS операция\n" +
        "boolean success = atomic.compareAndSet(25, 30);\n" +
        "// Если текущее 25, установить 30"
    );
    tvOutput.setText(
        "AtomicInteger:\n" +
        "Начальное значение: 0\n" +
        "После incrementAndGet(): 1\n" +
        "После addAndGet(5): 6\n" +
        "CAS(6, 10): true\n" +
        "Текущее значение: 10\n\n" +
        "1000 потоков делают increment:\n" +
        "Без Atomic: 987 ❌\n" +
        "С Atomic: 1000 ✅"
    );
    tvAnalogy.setText(
        "Аналогия:\n" +
        "• **Без Atomic** = Несколько людей считают деньги вместе, могут ошибиться 💰\n" +
        "• **С Atomic** = Кассовый аппарат (считает точно) 🧮\n\n" +
        "**CAS (Compare-And-Swap):**\n" +
        "— Проверяю: значение = 25?\n" +
        "— Если да: меняю на 30\n" +
        "— Если нет: не меняю, возвращаю false\n\n" +
        "**Преимущества Atomic:**\n" +
        "✅ Быстрее synchronized\n" +
        "✅ Нет блокировок\n" +
        "✅ Нет deadlock"
    );
    break;

case 71: // Lock
    tvTitle.setText("Lock (блокировки)");
    tvTheory.setText(
        "**Lock** — явные блокировки (альтернатива synchronized)\n\n" +
        "**ReentrantLock:**\n" +
        "• Более гибкий, чем synchronized\n" +
        "• Можно попробовать захватить без ожидания\n" +
        "• Можно установить таймаут\n" +
        "• Можно освободить в другом методе\n\n" +
        "**ReadWriteLock:**\n" +
        "• Разделяет чтение и запись\n" +
        "• Несколько читателей могут работать одновременно\n" +
        "• Запись эксклюзивна\n\n" +
        "**Методы Lock:**\n" +
        "• lock() — захватить (блокирует)\n" +
        "• unlock() — освободить\n" +
        "• tryLock() — попробовать захватить\n" +
        "• tryLock(time) — захватить с таймаутом\n" +
        "• lockInterruptibly() — захватить с прерыванием\n\n" +
        "**Важно:**\n" +
        "Всегда освобождать Lock в finally!"
    );
    tvCode.setText(
        "// ReentrantLock\n" +
        "Lock lock = new ReentrantLock();\n\n" +
        "lock.lock();  // Захватить\n" +
        "try {\n" +
        "    // Критическая секция\n" +
        "    counter++;\n" +
        "} finally {\n" +
        "    lock.unlock();  // Обязательно освободить!\n" +
        "}\n\n" +
        "// tryLock (не блокирует)\n" +
        "if (lock.tryLock()) {\n" +
        "    try {\n" +
        "        // Работа\n" +
        "    } finally {\n" +
        "        lock.unlock();\n" +
        "    }\n" +
        "} else {\n" +
        "    // Не удалось захватить\n" +
        "}\n\n" +
        "// ReadWriteLock\n" +
        "ReadWriteLock rwLock = new ReentrantReadWriteLock();\n" +
        "rwLock.readLock().lock();    // Несколько читателей\n" +
        "rwLock.writeLock().lock();   // Один писатель"
    );
    tvOutput.setText(
        "ReentrantLock:\n" +
        "Поток 1 захватил lock\n" +
        "Поток 2 ждёт...\n" +
        "Поток 1 освободил lock\n" +
        "Поток 2 захватил lock\n\n" +
        "tryLock:\n" +
        "Поток 1: lock захвачен ✅\n" +
        "Поток 2: lock занят, пропускаем ⏭️"
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **synchronized** = Автоматическая дверь (вошёл — закрылась, вышел — открылась) \n" +
        "• **Lock** = Замок с ключом (сам решаешь, когда открыть/закрыть) 🔐\n\n" +
        "**Преимущества Lock:**\n" +
        "✅ Можно попробовать без ожидания\n" +
        "✅ Можно установить таймаут\n" +
        "✅ Можно прервать ожидание\n" +
        "✅ ReadWriteLock для чтения/записи\n\n" +
        "**Недостатки:**\n" +
        "❌ Нужно вручную освобождать\n" +
        "❌ Можно забыть unlock()"
    );
    break;

case 72: // Executors
    tvTitle.setText("Executors");
    tvTheory.setText(
        "**Executors** — фабрика для создания пулов потоков\n\n" +
        "**Зачем нужен пул:**\n" +
        "• Создание потока дорогое\n" +
        "• Пул переиспользует потоки\n" +
        "• Ограничивает количество одновременных задач\n" +
        "• Управляет очередью задач\n\n" +
        "**Типы пулов:**\n" +
        "• **newFixedThreadPool(n)** — фиксированное число потоков\n" +
        "• **newCachedThreadPool()** — создаёт по необходимости\n" +
        "• **newSingleThreadExecutor()** — один поток\n" +
        "• **newScheduledThreadPool()** — для отложенных задач\n" +
        "• **newWorkStealingPool()** — ворующий работу (Java 8+)\n\n" +
        "**Методы ExecutorService:**\n" +
        "• execute(Runnable) — выполнить без результата\n" +
        "• submit(Callable) — выполнить с результатом\n" +
        "• shutdown() — завершить после текущих задач\n" +
        "• shutdownNow() — немедленно завершить"
    );
    tvCode.setText(
        "// Fixed ThreadPool\n" +
        "ExecutorService executor = \n" +
        "    Executors.newFixedThreadPool(4);\n" +
        "for (int i = 0; i < 10; i++) {\n" +
        "    executor.submit(() -> {\n" +
        "        System.out.println(\"Задача в \" + \n" +
        "            Thread.currentThread().getName());\n" +
        "    });\n" +
        "}\n" +
        "executor.shutdown();\n\n" +
        "// Cached ThreadPool\n" +
        "ExecutorService cached = \n" +
        "    Executors.newCachedThreadPool();\n" +
        "// Создаёт потоки по необходимости\n\n" +
        "// Scheduled ThreadPool\n" +
        "ScheduledExecutorService scheduled = \n" +
        "    Executors.newScheduledThreadPool(2);\n" +
        "scheduled.scheduleAtFixedRate(() -> {\n" +
        "    System.out.println(\"Каждые 5 секунд\");\n" +
        "}, 0, 5, TimeUnit.SECONDS);"
    );
    tvOutput.setText(
        "FixedThreadPool(4):\n" +
        "Задача в pool-1-thread-1\n" +
        "Задача в pool-1-thread-2\n" +
        "Задача в pool-1-thread-3\n" +
        "Задача в pool-1-thread-4\n" +
        "Задача в pool-1-thread-1  ← Переиспользование!\n\n" +
        "Всего 10 задач, но только 4 потока"
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **FixedThreadPool** = Команда из N работников 👷‍♂️👷‍♀️👷‍♂️👷‍♀️\n" +
        "• **CachedThreadPool** = Фрилансеры (нанимаем по необходимости) 🧑‍💻\n" +
        "• **SingleThreadExecutor** = Один работник 👤\n" +
        "• **ScheduledThreadPool** = Работники по расписанию \n\n" +
        "**Преимущества пула:**\n" +
        "✅ Переиспользование потоков\n" +
        "✅ Контроль количества\n" +
        "✅ Очередь задач\n" +
        "✅ Управление жизненным циклом"
    );
    break;

case 73: // Future и CompletableFuture
    tvTitle.setText("Future и CompletableFuture");
    tvTheory.setText(
        "**Future** — результат асинхронной операции\n\n" +
        "**Future:**\n" +
        "• Представляет результат, который будет готов позже\n" +
        "• get() — блокирует до получения результата\n" +
        "• isDone() — проверка готовности\n" +
        "• cancel() — отмена задачи\n\n" +
        "**CompletableFuture (Java 8+):**\n" +
        "• Более мощный, чем Future\n" +
        "• Можно комбинировать задачи\n" +
        "• Callback-и вместо блокировки\n" +
        "• Цепочки операций\n\n" +
        "**Методы CompletableFuture:**\n" +
        "• supplyAsync() — асинхронное выполнение\n" +
        "• thenApply() — преобразовать результат\n" +
        "• thenAccept() — обработать результат\n" +
        "• thenCombine() — объединить два Future\n" +
        "• allOf() — ждать все Future\n" +
        "• anyOf() — ждать любой Future"
    );
    tvCode.setText(
        "// Future\n" +
        "ExecutorService executor = \n" +
        "    Executors.newSingleThreadExecutor();\n" +
        "Future<Integer> future = executor.submit(() -> {\n" +
        "    Thread.sleep(1000);\n" +
        "    return 42;\n" +
        "});\n" +
        "Integer result = future.get();  // Блокирует!\n\n" +
        "// CompletableFuture\n" +
        "CompletableFuture<Integer> cf = \n" +
        "    CompletableFuture.supplyAsync(() -> {\n" +
        "        return 42;\n" +
        "    });\n" +
        "cf.thenApply(result -> result * 2)\n" +
        "  .thenAccept(result -> \n" +
        "      System.out.println(result))\n" +
        "  .join();  // 84\n\n" +
        "// Комбинирование\n" +
        "CompletableFuture<Integer> cf1 = \n" +
        "    CompletableFuture.supplyAsync(() -> 10);\n" +
        "CompletableFuture<Integer> cf2 = \n" +
        "    CompletableFuture.supplyAsync(() -> 20);\n" +
        "cf1.thenCombine(cf2, (a, b) -> a + b)\n" +
        "   .thenAccept(System.out::println);  // 30"
    );
    tvOutput.setText(
        "Future:\n" +
        "Результат: 42 (через 1 секунду)\n\n" +
        "CompletableFuture:\n" +
        "42 → 84 (thenApply)\n" +
        "Вывод: 84\n\n" +
        "Комбинирование:\n" +
        "10 + 20 = 30"
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **Future** = Квитанция из химчистки (придёте позже за результатом) 🧾\n" +
        "• **CompletableFuture** = Курьер, который привезёт и сразу обработает \n\n" +
        "**Future:**\n" +
        "— Получили квитанцию\n" +
        "— Ждём (блокируем)\n" +
        "— Забираем результат\n\n" +
        "**CompletableFuture:**\n" +
        "— Заказали\n" +
        "— Продолжаем работу\n" +
        "— Callback когда готово"
    );
    break;

case 74: // Синхронизаторы
    tvTitle.setText("Синхронизаторы");
    tvTheory.setText(
        "**Синхронизаторы** — инструменты для координации потоков\n\n" +
        "**CountDownLatch:**\n" +
        "• Ожидание завершения нескольких задач\n" +
        "• Счётчик уменьшается\n" +
        "• Когда = 0, все продолжают\n" +
        "• Нельзя сбросить\n\n" +
        "**CyclicBarrier:**\n" +
        "• Барьер для группы потоков\n" +
        "• Все ждут, пока не соберутся\n" +
        "• Можно использовать повторно\n\n" +
        "**Semaphore:**\n" +
        "• Ограничивает количество одновременных доступов\n" +
        "• Как парковка с N местами\n" +
        "• acquire() — занять место\n" +
        "• release() — освободить место\n\n" +
        "**Exchanger:**\n" +
        "• Обмен данными между двумя потоками\n" +
        "• Оба потока ждут друг друга\n" +
        "• Обмениваются данными"
    );
    tvCode.setText(
        "// CountDownLatch\n" +
        "CountDownLatch latch = new CountDownLatch(3);\n" +
        "for (int i = 0; i < 3; i++) {\n" +
        "    new Thread(() -> {\n" +
        "        // работа...\n" +
        "        latch.countDown();\n" +
        "    }).start();\n" +
        "}\n" +
        "latch.await();  // Ждать все 3 задачи\n" +
        "System.out.println(\"Все завершены!\");\n\n" +
        "// CyclicBarrier\n" +
        "CyclicBarrier barrier = new CyclicBarrier(3);\n" +
        "for (int i = 0; i < 3; i++) {\n" +
        "    new Thread(() -> {\n" +
        "        // работа...\n" +
        "        barrier.await();  // Ждать остальных\n" +
        "        // Продолжить вместе\n" +
        "    }).start();\n" +
        "}\n\n" +
        "// Semaphore\n" +
        "Semaphore semaphore = new Semaphore(2);  // 2 места\n" +
        "semaphore.acquire();  // Занять\n" +
        "// работа...\n" +
        "semaphore.release();  // Освободить"
    );
    tvOutput.setText(
        "CountDownLatch:\n" +
        "Задача 1 завершена\n" +
        "Задача 2 завершена\n" +
        "Задача 3 завершена\n" +
        "Все завершены! ✅\n\n" +
        "CyclicBarrier:\n" +
        "Поток 1 ждёт...\n" +
        "Поток 2 ждёт...\n" +
        "Поток 3 ждёт...\n" +
        "Все собрались! Продолжаем!\n\n" +
        "Semaphore:\n" +
        "2 места занято, 3-й ждёт..."
    );
    tvAnalogy.setText(
        "Аналогии:\n" +
        "• **CountDownLatch** = Стартовый пистолет (все бегут после сигнала) 🔫\n" +
        "• **CyclicBarrier** = Туристическая группа (все ждут отстающих) 👥\n" +
        "• **Semaphore** = Парковка (N мест, остальные ждут) 🅿️\n" +
        "• **Exchanger** = Обмен документами между коллегами 📄\n\n" +
        "**Когда что использовать:**\n" +
        "✅ CountDownLatch — ждать завершения задач\n" +
        "✅ CyclicBarrier — синхронизировать этапы\n" +
        "✅ Semaphore — ограничить доступ к ресурсу\n" +
        "✅ Exchanger — обмен данными между парой потоков"
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