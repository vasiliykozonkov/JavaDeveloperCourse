package com.vasiliykozonkov.javadevelopercourse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TopicModule5 extends AppCompatActivity {

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
			
			case 0: // Разбиение на команды
    tvTitle.setText("Разбиение на команды");
    tvTheory.setText(
        "**Командная работа** — основа реальной разработки.\n" +
        "Один человек редко делает всё от начала до конца.\n\n" +
        "**Основные роли в команде:**\n" +
        "• **Team Lead** — управляет процессом, убирает препятствия\n" +
        "• **Backend** — серверная логика, БД, API\n" +
        "• **Frontend / Android** — интерфейс и связь с сервером\n" +
        "• **QA Engineer** — ищет баги, пишет тесты\n" +
        "• **Product Owner** — определяет ЧТО делать\n" +
        "• **Designer** — определяет КАК это выглядит\n\n" +
        "**Зачем делить роли:**\n" +
        "• Параллельная работа\n" +
        "• Каждый отвечает за свою часть\n" +
        "• Выше качество кода"
    );
    tvCode.setText(
        "// Пример задачи: \"Экран профиля\"\n\n" +
        "// 1. Product Owner:\n" +
        "// \"Пользователь должен видеть аватар, имя\n" +
        "//  и кнопку Выйти\"\n\n" +
        "// 2. Designer: рисует макет в Figma\n\n" +
        "// 3. Backend: создаёт API\n" +
        "//    GET /api/user/profile\n\n" +
        "// 4. Android: верстает экран,\n" +
        "//    делает запрос к API\n\n" +
        "// 5. QA: проверяет при плохом интернете"
    );
    tvOutput.setText(
        "Результат разделения:\n" +
        "✅ Backend готов за 2 дня\n" +
        "✅ Android готов за 3 дня\n" +
        "✅ Параллельно = 3 дня вместо 5\n" +
        "✅ Каждый эксперт в своей области"
    );
    tvAnalogy.setText(
        "Аналогия: Съёмки фильма 🎬\n" +
        "• Режиссёр (Team Lead) не играет все роли\n" +
        "• Сценарист пишет текст\n" +
        "• Оператор снимает\n" +
        "• Актёры играют\n" +
        "• Монтажёр собирает всё\n\n" +
        "Если оператор начнёт монтировать —\n" +
        "получится хаос!"
    );
    break;

case 1: // Работа над общим проектом
    tvTitle.setText("Работа над общим проектом");
    tvTheory.setText(
        "**Правила командной работы:**\n\n" +
        "1️⃣ **Трекер задач** (Jira, Trello, GitHub Issues)\n" +
        "   Нет задачи в трекере = работы не существует\n\n" +
        "2️⃣ **Git Flow**\n" +
        "   Никто не пушит в main напрямую!\n" +
        "   • Создаём ветку: feature/login\n" +
        "   • Делаем коммиты\n" +
        "   • Создаём Pull Request (PR)\n\n" +
        "3️ **Code Review**\n" +
        "   Минимум 1-2 коллеги проверяют код\n" +
        "   Ищут ошибки и нарушения стандартов\n\n" +
        "4️⃣ **Daily Standup** (15 мин)\n" +
        "   • Что сделал вчера?\n" +
        "   • Что сделаю сегодня?\n" +
        "   • Что мешает?"
    );
    tvCode.setText(
        "// Жизненный цикл задачи:\n\n" +
        "1. Берёшь задачу в Jira\n" +
        "2. git checkout -b feat/validation\n" +
        "3. Пишешь код, коммитишь\n" +
        "4. git push origin feat/validation\n" +
        "5. Создаёшь Pull Request в develop\n" +
        "6. Коллега пишет: \"Используй Regex\"\n" +
        "7. Исправляешь, новый коммит\n" +
        "8. Коллега одобряет (Approve)\n" +
        "9. Код вливается (Merge) в develop"
    );
    tvOutput.setText(
        "Результат:\n" +
        "✅ Никто не сломал чужой код\n" +
        "✅ Все изменения проверены\n" +
        "✅ История чистая и понятная\n" +
        "✅ Баги найдены до релиза"
    );
    tvAnalogy.setText(
        "Аналогия: Сборка LEGO втроём \n" +
        "• Общая инструкция (ТЗ)\n" +
        "• Ты — левое крыло, я — правое\n" +
        "  (Git ветки)\n" +
        "• Периодически прикладываем детали\n" +
        "  (Code Review)\n" +
        "• Если кто-то вставит не ту деталь —\n" +
        "  остановим, пока не сломал всё"
    );
    break;

case 2: // Презентация проекта
    tvTitle.setText("Презентация проекта");
    tvTheory.setText(
        "**Структура презентации** (5-7 минут):\n\n" +
        "1️ **Проблема** — какую боль решаем?\n\n" +
        "2️ **Решение** — что сделали?\n" +
        "   (демо работающего приложения)\n\n" +
        "3️⃣ **Архитектура и стек**\n" +
        "   На чём и как сделано?\n\n" +
        "4️⃣ **Сложности и решения** ⭐\n" +
        "   Самый важный пункт!\n" +
        "   Показывает твой рост как разработчика\n\n" +
        "5️ **Планы на будущее** (v2.0)\n\n" +
        "**Главное:** фокус на ПОЛЬЗЕ и РЕШЕНИЯХ,\n" +
        "а не на зачитывании кода!"
    );
    tvCode.setText(
        "// Пример питча:\n\n" +
        "\"Мы сделали StudyTracker.\n\n" +
        "Проблема: студенты пропускают\n" +
        "сдачу лабораторных.\n\n" +
        "Решение: пуш-уведомления за 24ч\n" +
        "до дедлайна.\n\n" +
        "Стек: Java, Room, MVVM.\n\n" +
        "Сложность: синхронизация при\n" +
        "плохом интернете. Решили через\n" +
        "WorkManager.\n\n" +
        "В v2.0 добавим виджет.\""
    );
    tvOutput.setText(
        "Хорошая презентация:\n" +
        "✅ Понятна заказчику\n" +
        "✅ Показывает твой рост\n" +
        "✅ Демонстрирует решения\n" +
        "✅ Оставляет желание спросить"
    );
    tvAnalogy.setText(
        "Аналогия: Продажа машины 🚗\n" +
        "• Покупателю не интересно слушать\n" +
        "  10 минут про впрыск топлива (код)\n" +
        "• Ему важно: безопасна, экономична,\n" +
        "  удобна (бизнес-ценность)\n" +
        "• Но если спросит про двигатель\n" +
        "  (архитектуру) — отвечай уверенно!"
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