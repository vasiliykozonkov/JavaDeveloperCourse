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
	
	private LinearLayout module3TopicsLayout;
    private ImageView module3Arrow;
    private boolean module3Expanded = false;
	
    private LinearLayout module4TopicsLayout;
    private ImageView module4Arrow;
    private boolean module4Expanded = false;
	
	private LinearLayout module5TopicsLayout;
    private ImageView module5Arrow;
    private boolean module5Expanded = false;

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
        "30. StringBuilder, StringBuffer",
		"31. Git — Система контроля версий"
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
	
	private String[] module3TopicsArray = {
    "1. SOLID принципы",
    "2. Паттерны проектирования",
    "3. Git — углублённо",
    "4. push, pull, fetch",
    "5. Слияние веток: merge и rebase",
    "6. cherry-pick и squash",
    "7. patch и stash",
    "8. reset и revert",
    "9. Сборщики: Gradle и Maven",
    "10. Этапы сборки Maven",
    "11. Где хранятся зависимости"
};

    private String[] module4TopicsArray = {
    "1. Многопоточность",
    "2. Способы создания потоков",
    "3. Виды состояния потоков",
    "4. Ключевое слово volatile",
    "5. Проблемы многопоточности",
    "6. Пакет java.util.concurrent",
    "7. Atomic переменные",
    "8. Lock (блокировки)",
    "9. Executors",
    "10. Future и CompletableFuture",
    "11. Синхронизаторы"
};

private String[] module5TopicsArray = {
    "1. Разбиение на команды",
    "2. Работа над общим проектом",
    "3. Презентация проекта"
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

            final int index = 31 + i;  // СМЕЩЕНИЕ! Модуль 2 начинается с индекса 30
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
		
		// Инициализация Модуля 3
module3TopicsLayout = findViewById(R.id.module3Topics);
module3Arrow = findViewById(R.id.module3Arrow);

for (int i = 0; i < module3TopicsArray.length; i++) {
    TextView topicView = new TextView(this);
    topicView.setText(module3TopicsArray[i]);
    topicView.setTextSize(16);
    topicView.setTextColor(android.graphics.Color.parseColor("#333333"));
    topicView.setPadding(16, 12, 16, 12);
    
    final int index = 53 + i;  // Смещение! Модуль 3 начинается с индекса 53
    topicView.setOnClickListener(v -> {
        Intent intent = new Intent(MainActivity.this, TopicActivity.class);
        intent.putExtra("topic_index", index);
        startActivity(intent);
    });
    
    module3TopicsLayout.addView(topicView);
}

findViewById(R.id.module3Header).setOnClickListener(v -> {
    if (module3Expanded) {
        module3TopicsLayout.setVisibility(View.GONE);
        module3Arrow.setRotation(0);
    } else {
        module3TopicsLayout.setVisibility(View.VISIBLE);
        module3Arrow.setRotation(180);
    }
    module3Expanded = !module3Expanded;
});

// Инициализация Модуля 4
module4TopicsLayout = findViewById(R.id.module4Topics);
module4Arrow = findViewById(R.id.module4Arrow);

for (int i = 0; i < module4TopicsArray.length; i++) {
    TextView topicView = new TextView(this);
    topicView.setText(module4TopicsArray[i]);
    topicView.setTextSize(16);
    topicView.setTextColor(android.graphics.Color.parseColor("#333333"));
    topicView.setPadding(16, 12, 16, 12);
    
    final int index = 64 + i;  // Смещение! Модуль 4 начинается с индекса 64
    topicView.setOnClickListener(v -> {
        Intent intent = new Intent(MainActivity.this, TopicActivity.class);
        intent.putExtra("topic_index", index);
        startActivity(intent);
    });
    
    module4TopicsLayout.addView(topicView);
}

findViewById(R.id.module4Header).setOnClickListener(v -> {
    if (module4Expanded) {
        module4TopicsLayout.setVisibility(View.GONE);
        module4Arrow.setRotation(0);
    } else {
        module4TopicsLayout.setVisibility(View.VISIBLE);
        module4Arrow.setRotation(180);
    }
    module4Expanded = !module4Expanded;
});

// Инициализация Модуля 5
module5TopicsLayout = findViewById(R.id.module5Topics);
module5Arrow = findViewById(R.id.module5Arrow);

for (int i = 0; i < module5TopicsArray.length; i++) {
    TextView topicView = new TextView(this);
    topicView.setText(module5TopicsArray[i]);
    topicView.setTextSize(16);
    topicView.setTextColor(android.graphics.Color.parseColor("#333333"));
    topicView.setPadding(16, 12, 16, 12);
    
    final int index = 75 + i;  // Смещение! Модуль 5 начинается с индекса 75
    topicView.setOnClickListener(v -> {
        Intent intent = new Intent(MainActivity.this, TopicActivity.class);
        intent.putExtra("topic_index", index);
        startActivity(intent);
    });
    
    module5TopicsLayout.addView(topicView);
}

findViewById(R.id.module5Header).setOnClickListener(v -> {
    if (module5Expanded) {
        module5TopicsLayout.setVisibility(View.GONE);
        module5Arrow.setRotation(0);
    } else {
        module5TopicsLayout.setVisibility(View.VISIBLE);
        module5Arrow.setRotation(180);
    }
    module5Expanded = !module5Expanded;
});


        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Java Developer Course");
        }
    }
}