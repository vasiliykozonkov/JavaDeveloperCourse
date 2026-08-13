package com.vasiliykozonkov.javadevelopercourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout module1TopicsLayout;
    private ImageView module1Arrow;
    private boolean module1Expanded = false;
    
    private LinearLayout module2TopicsLayout;
    private ImageView module2Arrow;
    private boolean module2Expanded = false;

    private String[] module1TopicsArray = {
        "1. Какие языки программирования бывают",
        "2. JVM, JRE, JDK",
        "3. Области памяти в Java",
        "4. Class Loaders",
        "5. Объект класса Class",
        "6. Классы и объекты",
        "7. Структура класса",
        "8. Поля",
        "9. Конструкторы (super и this)",
        "10. Методы (сигнатура, перегрузка)",
        "11. Статические и нестатические блоки инициализации",
        "12. Модификаторы: static, final, abstract",
        "13. Модификаторы доступа",
        "14. Установка значений свойств объектов",
        "15. Абстрактные классы и интерфейсы",
        "16. Изменяемые и неизменяемые объекты",
        "17. Inner и Nested классы",
        "18. Локальные и анонимные классы",
        "19. Класс Object",
        "20. Методы класса Object",
        "21. Контракт equals - hashCode",
        "22. Метод clone",
        "23. Принципы ООП",
        "24. Наследование и Ассоциация",
        "25. Переопределение методов",
        "26. Статическое и динамическое связывание",
        "27. Оболочки примитивных типов",
        "28. String",
        "29. String pool",
        "30. StringBuilder, StringBuffer"
    };

    private String[] module2TopicsArray = {
        "1. Исключения",
        "2. Иерархия исключений",
        "3. Способы обработки исключений",
        "4. try с ресурсами",
        "5. Ввод-вывод (I/O)",
        "6. Классы потоков ввода-вывода",
        "7. Правила работы с потоками I/O",
        "8. Сериализация",
        "9. Алгоритмы",
        "10. Big O notation",
        "11. Виды сортировок",
        "12. Generics",
        "13. Коллекции",
        "14. Иерархия коллекций",
        "15. List",
        "16. Set",
        "17. Map",
        "18. Временная сложность коллекций",
        "19. Неизменяемые коллекции",
        "20. LinkedHashMap, TreeMap",
        "21. Comparable и Comparator",
        "22. Лямбды и Stream API"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация Модуля 1
        module1TopicsLayout = findViewById(R.id.module1Topics);
        module1Arrow = findViewById(R.id.module1Arrow);

        // Добавляем темы Модуля 1 (индексы 0-29)
        for (int i = 0; i < module1TopicsArray.length; i++) {
            TextView topicView = new TextView(this);
            topicView.setText(module1TopicsArray[i]);
            topicView.setTextSize(16);
            topicView.setTextColor(android.graphics.Color.parseColor("#333333"));
            topicView.setPadding(16, 12, 16, 12);

            final int index = i;
            topicView.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, TopicActivity.class);
                intent.putExtra("topic_index", index);
                startActivity(intent);
            });

            module1TopicsLayout.addView(topicView);
        }

        // Клик на заголовок Модуля 1
        findViewById(R.id.module1Header).setOnClickListener(v -> {
            if (module1Expanded) {
                module1TopicsLayout.setVisibility(View.GONE);
                module1Arrow.setRotation(0);
            } else {
                module1TopicsLayout.setVisibility(View.VISIBLE);
                module1Arrow.setRotation(180);
            }
            module1Expanded = !module1Expanded;
        });

        // Инициализация Модуля 2
        module2TopicsLayout = findViewById(R.id.module2Topics);
        module2Arrow = findViewById(R.id.module2Arrow);

        // Добавляем темы Модуля 2 (индексы 30-51)
        for (int i = 0; i < module2TopicsArray.length; i++) {
            TextView topicView = new TextView(this);
            topicView.setText(module2TopicsArray[i]);
            topicView.setTextSize(16);
            topicView.setTextColor(android.graphics.Color.parseColor("#333333"));
            topicView.setPadding(16, 12, 16, 12);

            final int index = 30 + i;  // СМЕЩЕНИЕ! Модуль 2 начинается с индекса 30
            topicView.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, TopicActivity.class);
                intent.putExtra("topic_index", index);
                startActivity(intent);
            });

            module2TopicsLayout.addView(topicView);
        }

        // Клик на заголовок Модуля 2
        findViewById(R.id.module2Header).setOnClickListener(v -> {
            if (module2Expanded) {
                module2TopicsLayout.setVisibility(View.GONE);
                module2Arrow.setRotation(0);
            } else {
                module2TopicsLayout.setVisibility(View.VISIBLE);
                module2Arrow.setRotation(180);
            }
            module2Expanded = !module2Expanded;
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Java Developer Course");
        }
    }
}