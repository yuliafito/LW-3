package Droids;

import TextColor.TextColor;
import static Fighting.Fighting.sb;

/**
 * Базовий клас Droid
 * @author Yuliia Fito
 */
public class Droid {
    /** ім'я дроїда */
    protected String name;
    /** здоров'я дроїда */
    protected int health;
    /** урон, який може нанести дроїд */
    protected int damage;
    /** броня дроїда */
    protected int armor;
    /** чи дроїд поранений*/
    protected boolean isDamaged;
    /** чи дроїд використовує отруту*/
    protected boolean givePoison;


    /**
     * Конструктор
     * @param health здоров'я
     * @param damage урон
     * @param armor броня
     * @param name ім'я
     */
    public Droid(int health, int damage, int armor, String name) {
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        this.name = name;
        isDamaged = false;
    }

    /**
     * Метод атаки ворожого дроїда
     * @return урон нанесений дроїдом
     */
    public int attack()
    {
         return damage;
    }

    /**
     * Метод отримання удару дроїдом
     * @param damage урон, сила удару
     * @param d дроїд, який наносить удар
     */
    public void getHit(int damage, Droid d)
    {
        if(d.isGivePoison()) {
            this.health -= damage;
        }
        else {
            damage -= armor;
            this.health -= damage;
        }
        System.out.println(TextColor.RESET + name + TextColor.RED + " -" + damage);
        sb.append(TextColor.RESET + name + TextColor.RED + " -" + damage + "\n");
        isDamaged = true;
    }

    /**
     * Геттер для поля name
     * @return ім'я дроїда
     */
    public String getName() {
        return name;
    }

    /**
     * Геттер для поля damage
     * @return урон, який має дроїд
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Геттер для поля armor
     * @return броню, яку має дроїд
     */
    public int getArmor(){
        return armor;
    }

    /**
     * Геттер для поля health
     * @return здоров'я дроїда
     */
    public int getHealth() {
        return health;
    }

    /**
     * Метод, який визначає чи дроїд має отруту
     * @return true - якщо має, false - якщо не має
     */
    public boolean isGivePoison() {
        return givePoison;
    }

    /**
     * Метод, який визначає чи дроїд поранений
     * @return true - якщо поранений, false - якщо ні
     */
    public boolean isDamaged() {
        return isDamaged;
    }

    /**
     * Сеттер для поля health
     * @param health здоров'я дроїда
     */
    public void setHealth(int health){
        this.health = health;
    }

    /**
     * Перевизначений метод toString()
     * @return повертає символьний рядок, що описує об’єкт
     */
    @Override
    public String toString(){
        String str = name + " (health: " + health + ", damage: " + damage+ ", armor: " + armor + ", chanceCritic: " + ", criticAttack";
        str += ")";
        return str;
    }

}
