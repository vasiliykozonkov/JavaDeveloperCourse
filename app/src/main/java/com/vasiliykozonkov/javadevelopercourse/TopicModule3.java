package com.vasiliykozonkov.javadevelopercourse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TopicModule3 extends AppCompatActivity {

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
			
			case 0: // SOLID
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

case 1: // Паттерны проектирования
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

case 2: // Git углублённо
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

case 3: // push, pull, fetch
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

case 4: // merge и rebase
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
	
	case 5: // cherry-pick и squash
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

case 6: // patch и stash
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

case 7: // reset и revert
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
	
	case 8: // Gradle и Maven
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

case 9: // Этапы сборки Maven
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

case 10: // Где хранятся зависимости
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