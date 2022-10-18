package Droids;

import TextColor.TextColor;
import java.util.Random;
import static Fighting.Fighting.sb;

/**
 * Клас,що представляє тип Killer дроїда
 */
public class KillerDroid extends Droid {

    /** ймовірність критичного удару */
    private final int chanceCriticalAttack;
    /** критичний удар */
    private final int criticalAttack;

    /** Конструктор */
    public KillerDroid() {
        super(1300, 300,350,  "Killer");
        chanceCriticalAttack = 35;
        criticalAttack = 1000;
    }

    /**
     * Метод атаки ворожого дроїда
     * @return удар нанесений дроїдом
     */
    public int attack()
    {
        Random random = new Random();
        if (random.nextInt(100) > chanceCriticalAttack) return damage;
        else{
            System.out.println("Critical attack! " + TextColor.PURPLE + criticalAttack);
            sb.append("Critical attack! " + TextColor.PURPLE).append(criticalAttack).append("\n");
            return criticalAttack;
        }
    }

    /**
     * Метод отримання удару дроїдом
     * @param damage удар
     * @param d дроїд, який наносить удар
     */
    public void getHit(int damage, Droid d)
    {
        if(d.isGivePoison()) {
            this.health -= damage;
            System.out.println(TextColor.RESET + name + TextColor.RED + " -" + damage);
            sb.append(TextColor.RESET +name + TextColor.RED + " -" + damage + "\n");
            isDamaged = true;
        }
        else if(damage > armor) {
            damage -= armor;
            this.health -= damage;
            System.out.println(TextColor.RESET + name + TextColor.RED + " -" + damage);
            sb.append(TextColor.RESET +name + TextColor.RED + " -" + damage + "\n");
            isDamaged = true;
        }
        else {
            System.out.println(TextColor.RESET + "Killer has super armor that reflects the hit!");
            sb.append(TextColor.RESET + "Killer has super armor that reflects the hit!" + "\n");
            isDamaged = false;
        }
    }
}
