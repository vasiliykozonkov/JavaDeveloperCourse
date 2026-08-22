package com.vasiliykozonkov.javadevelopercourse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TopicModule4 extends AppCompatActivity {

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
			
			case 0: // Многопоточность
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

case 1: // Способы создания потоков
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

case 2: // Состояния потоков
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

case 3: // volatile
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

case 4: // Проблемы многопоточности
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
	
	case 5: // java.util.concurrent
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

case 6: // Atomic
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

case 7: // Lock
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

case 8: // Executors
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

case 9: // Future и CompletableFuture
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

case 10: // Синхронизаторы
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
        setTitle((position + 1) + ". " + tvTitle.getText());
    }
}