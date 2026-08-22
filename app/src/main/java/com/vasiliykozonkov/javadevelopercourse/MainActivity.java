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
        "• Какие языки программирования бывают",
        "• JVM, JRE, JDK",
        "• Области памяти в Java",
        "• Class Loaders",
        "• Объект класса Class",
        "• Классы и объекты",
        "• Структура класса",
        "• Поля",
        "• Конструкторы (super и this)",
        "• Методы (сигнатура, перегрузка)",
        "• Статические и нестатические блоки инициализации",
        "• Модификаторы: static, final, abstract",
        "• Модификаторы доступа",
        "• Установка значений свойств объектов",
        "• Абстрактные классы и интерфейсы",
        "• Изменяемые и неизменяемые объекты",
        "• Inner и Nested классы",
        "• Локальные и анонимные классы",
        "• Класс Object",
        "• Методы класса Object",
        "• Контракт equals - hashCode",
        "• Метод clone",
        "• Принципы ООП",
        "• Наследование и Ассоциация",
        "• Переопределение методов",
        "• Статическое и динамическое связывание",
        "• Оболочки примитивных типов",
        "• String",
        "• String pool",
        "• StringBuilder, StringBuffer",
        "• Git — Система контроля версий"
    };

// ... после module1Expanded = false; добавь:



private String[] module2TopicsArray = {
    "• Исключения",
    "• Иерархия исключений",
    "• Способы обработки исключений",
    "• try с ресурсами",
    "• Ввод-вывод (I/O)",
    "• Классы потоков ввода-вывода",
    "• Правила работы с потоками I/O",
    "• Сериализация",
    "• Алгоритмы",
    "• Big O notation",
    "• Виды сортировок",
    "• Generics",
    "• Коллекции",
    "• Иерархия коллекций",
    "• List",
    "• Set",
    "• Map",
    "• Временная сложность коллекций",
    "• Неизменяемые коллекции",
    "• LinkedHashMap, TreeMap",
    "• Comparable и Comparator",
    "• Лямбды и Stream API",
	"• Stream API — Полная шпаргалка"
};

private String[] module3TopicsArray = {
    "• SOLID принципы",
    "• Паттерны проектирования",
    "• Git — углублённо",
    "• push, pull, fetch",
    "• Слияние веток: merge и rebase",
    "• cherry-pick и squash",
    "• patch и stash",
    "• reset и revert",
    "• Сборщики: Gradle и Maven",
    "• Этапы сборки Maven",
    "• Где хранятся зависимости"
};

    private String[] module4TopicsArray = {
    "• Многопоточность",
    "• Способы создания потоков",
    "• Виды состояния потоков",
    "• Ключевое слово volatile",
    "• Проблемы многопоточности",
    "• Пакет java.util.concurrent",
    "• Atomic переменные",
    "• Lock (блокировки)",
    "• Executors",
    "• Future и CompletableFuture",
    "• Синхронизаторы"
};

private String[] module5TopicsArray = {
    "• Разбиение на команды",
    "• Работа над общим проектом",
    "• Презентация проекта"
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        module1TopicsLayout = findViewById(R.id.module1Topics);
        module1Arrow = findViewById(R.id.module1Arrow);
		
				  // Инициализация Модуля 2
        module2TopicsLayout = findViewById(R.id.module2Topics);
        module2Arrow = findViewById(R.id.module2Arrow);
		
		module3TopicsLayout = findViewById(R.id.module3Topics);
        module3Arrow = findViewById(R.id.module3Arrow);
		
	    module4TopicsLayout = findViewById(R.id.module4Topics);
        module4Arrow = findViewById(R.id.module4Arrow);
		
	    module5TopicsLayout = findViewById(R.id.module5Topics);
        module5Arrow = findViewById(R.id.module5Arrow);
		
		  

        // Добавляем темы Модуля 1 — БЕЗ ИНДЕКСОВ!
        for (int i = 0; i < module1TopicsArray.length; i++) {
            TextView topicView = new TextView(this);
            topicView.setText(module1TopicsArray[i]);
            topicView.setTextSize(16);
            topicView.setTextColor(android.graphics.Color.parseColor("#333333"));
            topicView.setPadding(16, 12, 16, 12);

            final int position = i;  // локальная позиция 0, 1, 2...

            topicView.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, TopicModule1.class);
                intent.putExtra("position", position);  // передаём позицию
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
		


    // Добавляем темы Модуля 2 (локальные индексы 0-22)
    for (int i = 0; i < module2TopicsArray.length; i++) {
        TextView topicView = new TextView(this);
        topicView.setText(module2TopicsArray[i]);
        topicView.setTextSize(16);
        topicView.setTextColor(android.graphics.Color.parseColor("#333333"));
        topicView.setPadding(16, 12, 16, 12);
        
        final int position = i; // Локальный индекс!
        
        topicView.setOnClickListener(v -> {
            // ЗАПУСКАЕМ TopicModule2 вместо TopicActivity!
            Intent intent = new Intent(MainActivity.this, TopicModule2.class);
            intent.putExtra("position", position);  // передаём позицию
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
	
	
	    // Добавляем темы Модуля 3 (локальные индексы 0-22)
    for (int i = 0; i < module3TopicsArray.length; i++) {
        TextView topicView = new TextView(this);
        topicView.setText(module3TopicsArray[i]);
        topicView.setTextSize(16);
        topicView.setTextColor(android.graphics.Color.parseColor("#333333"));
        topicView.setPadding(16, 12, 16, 12);
        
        final int position = i; // Локальный индекс!
        
        topicView.setOnClickListener(v -> {
            // ЗАПУСКАЕМ TopicModule2 вместо TopicActivity!
            Intent intent = new Intent(MainActivity.this, TopicModule3.class);
            intent.putExtra("position", position);  // передаём позицию
            startActivity(intent);
        });
        module3TopicsLayout.addView(topicView);
    }
    
    // Клик на заголовок Модуля 3
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
	

    // Добавляем темы Модуля 4 (локальные индексы 0-22)
    for (int i = 0; i < module4TopicsArray.length; i++) {
        TextView topicView = new TextView(this);
        topicView.setText(module4TopicsArray[i]);
        topicView.setTextSize(16);
        topicView.setTextColor(android.graphics.Color.parseColor("#333333"));
        topicView.setPadding(16, 12, 16, 12);
        
        final int position = i; // Локальный индекс!
        
        topicView.setOnClickListener(v -> {
            // ЗАПУСКАЕМ TopicModule2 вместо TopicActivity!
            Intent intent = new Intent(MainActivity.this, TopicModule4.class);
            intent.putExtra("position", position);  // передаём позицию
            startActivity(intent);
        });
        module4TopicsLayout.addView(topicView);
    }
    
    // Клик на заголовок Модуля 4
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
	

    // Добавляем темы Модуля 5 (локальные индексы 0-22)
    for (int i = 0; i < module5TopicsArray.length; i++) {
        TextView topicView = new TextView(this);
        topicView.setText(module5TopicsArray[i]);
        topicView.setTextSize(16);
        topicView.setTextColor(android.graphics.Color.parseColor("#333333"));
        topicView.setPadding(16, 12, 16, 12);
        
        final int position = i; // Локальный индекс!
        
        topicView.setOnClickListener(v -> {
            // ЗАПУСКАЕМ TopicModule2 вместо TopicActivity!
            Intent intent = new Intent(MainActivity.this, TopicModule5.class);
            intent.putExtra("position", position);  // передаём позицию
            startActivity(intent);
        });
        module5TopicsLayout.addView(topicView);
    }
    
    // Клик на заголовок Модуля 5
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


