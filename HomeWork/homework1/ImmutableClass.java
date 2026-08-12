/**
 * Домашнее задание 1: Иммутабельный класс с изменяемым полем
 * 
 * Задача: Реализовать иммутабельный класс, который содержит поле с изменяемым классом.
 * 
 * Решение: Класс Employee (неизменяемый) содержит поля:
 * - name (String - неизменяемый)
 * - hireDate (Date - изменяемый) ← здесь нужно защитное копирование!
 * - skills (List<String> - изменяемый) ← и здесь тоже!
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

// ============================================
// ИЗМЕНЯЕМЫЙ КЛАСС (для демонстрации проблемы)
// ============================================
class Department {
    private String name;
    private String location;
    
    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }
    
    // Сеттеры делают класс ИЗМЕНЯЕМЫМ
    public void setName(String name) {
        this.name = name;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getName() {
        return name;
    }
    
    public String getLocation() {
        return location;
    }
    
    @Override
    public String toString() {
        return "Department{name='" + name + "', location='" + location + "'}";
    }
}

// ============================================
// ИММУТАБЕЛЬНЫЙ КЛАСС (главное задание)
// ============================================
public final class ImmutableEmployee {
    
    // Все поля private и final
    private final String name;
    private final int age;
    private final Department department;  // Изменяемый объект!
    private final List<String> skills;    // Изменяемый список!
    private final Date hireDate;          // Изменяемая дата!
    
    /**
     * Конструктор с ЗАЩИТНЫМ КОПИРОВАНИЕМ
     * Мы создаём копии изменяемых объектов, чтобы никто не мог изменить наш Employee
     */
    public ImmutableEmployee(String name, int age, Department department, 
                             List<String> skills, Date hireDate) {
        this.name = name;
        this.age = age;
        
        // ЗАЩИТНОЕ КОПИРОВАНИЕ для Department
        // Создаём НОВЫЙ объект с теми же значениями
        this.department = new Department(department.getName(), department.getLocation());
        
        // ЗАЩИТНОЕ КОПИРОВАНИЕ для List
        // Создаём НОВЫЙ список с теми же элементами
        this.skills = new ArrayList<>(skills);
        
        // ЗАЩИТНОЕ КОПИРОВАНИЕ для Date
        // Создаём НОВУЮ дату с тем же временем
        this.hireDate = new Date(hireDate.getTime());
    }
    
    // ГЕТТЕРЫ (без сеттеров!)
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    /**
     * Возвращаем КОПИЮ Department, чтобы нельзя было изменить оригинал
     */
    public Department getDepartment() {
        return new Department(department.getName(), department.getLocation());
    }
    
    /**
     * Возвращаем НЕИЗМЕНЯЕМУЮ копию списка
     * Collections.unmodifiableList() запрещает добавлять/удалять элементы
     */
    public List<String> getSkills() {
        return Collections.unmodifiableList(new ArrayList<>(skills));
    }
    
    /**
     * Возвращаем КОПИЮ даты
     */
    public Date getHireDate() {
        return new Date(hireDate.getTime());
    }
    
    @Override
    public String toString() {
        return "ImmutableEmployee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                ", skills=" + skills +
                ", hireDate=" + hireDate +
                '}';
    }
    
    // ============================================
    // ТЕСТ ИММУТАБЕЛЬНОСТИ
    // ============================================
    public static void main(String[] args) {
        System.out.println("=== ТЕСТ ИММУТАБЕЛЬНОСТИ ===\n");
        
        // 1. Создаём изменяемые объекты
        Department originalDept = new Department("IT", "Москва");
        List<String> originalSkills = new ArrayList<>();
        originalSkills.add("Java");
        originalSkills.add("SQL");
        Date originalDate = new Date();
        
        // 2. Создаём иммутабельного сотрудника
        ImmutableEmployee employee = new ImmutableEmployee(
            "Василий", 35, originalDept, originalSkills, originalDate
        );
        
        System.out.println("1. Создан сотрудник:");
        System.out.println(employee);
        System.out.println();
        
        // 3. Пытаемся изменить ОРИГИНАЛЬНЫЕ объекты
        System.out.println("2. Пытаемся изменить оригинальные объекты...\n");
        
        originalDept.setName("HR");
        originalDept.setLocation("Питер");
        System.out.println("Изменили Department: " + originalDept);
        
        originalSkills.add("Python");
        originalSkills.remove("Java");
        System.out.println("Изменили список навыков: " + originalSkills);
        
        // Пытаемся изменить через геттер
        employee.getSkills().add("C++");  // Это не сработает!
        employee.getDepartment().setName("Finance");  // Это тоже не сработает!
        
        System.out.println();
        System.out.println("3. Проверяем сотрудника после изменений:");
        System.out.println(employee);
        System.out.println();
        
        // 4. Проверяем результат
        System.out.println("=== РЕЗУЛЬТАТ ===");
        
        boolean deptUnchanged = employee.getDepartment().getName().equals("IT");
        boolean skillsUnchanged = employee.getSkills().size() == 2 && 
                                   employee.getSkills().contains("Java");
        
        if (deptUnchanged && skillsUnchanged) {
            System.out.println("✅ УСПЕХ! Класс действительно иммутабельный!");
            System.out.println("   - Department не изменился: " + employee.getDepartment());
            System.out.println("   - Навыки не изменились: " + employee.getSkills());
        } else {
            System.out.println("❌ ОШИБКА! Класс изменяемый!");
        }
    }
}