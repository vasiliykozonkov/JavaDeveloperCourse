package com.vasiliykozonkov.javadevelopercourse;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    
    private String[] topics = {
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
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ListView listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter<>(
            this,
            android.R.layout.simple_list_item_1,
            topics
        ));
        
        // При клике переходим на TopicActivity
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, TopicActivity.class);
            intent.putExtra("topic_index", position);
            startActivity(intent);
        });
        
        setContentView(listView);
        
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Java Developer Course");
        }
    }
}