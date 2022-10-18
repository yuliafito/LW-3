package Droids;
import TextColor.TextColor;
import java.util.Random;
import static Fighting.Fighting.sb;

/**
 * Клас,що представляє тип Pilot дроїда
 */
public class  PilotDroid extends Droid {
    /** ймовірність магічного удару */
    private final int chanceMagicAttack;
    /** магічний удар */
    private final int magicAttack;
    /** ймовірність критичного удару */
    private final int chanceCriticalAttack;
    /** критичний удар */
    private final int criticalAttack;
    /** ймовірність уникнути удару */
    private final int chanceToEscape;

    /** Конструктор */
    public PilotDroid() {
        super(1100, 250, 100,  "FlyingMan");
        chanceMagicAttack = 35;
        magicAttack = 1500;
        chanceCriticalAttack = 35;
        criticalAttack = 1000;
        chanceToEscape = 45;
    }

    /**
     * Метод атаки ворожого дроїда
     * @return удар нанесений дроїдом
     */
    public int attack()
    {
        Random random = new Random();
        if (random.nextInt(100) < chanceCriticalAttack){
            System.out.println("Critical attack! " + TextColor.PURPLE + criticalAttack);
            sb.append("Critical attack! " + TextColor.PURPLE + criticalAttack + "\n");
            return criticalAttack;
        }
        else{
            if (random.nextInt(100) < chanceMagicAttack){
                System.out.println("Magic attack! " + TextColor.PURPLE + magicAttack);
                sb.append("Magic attack! " + TextColor.PURPLE + magicAttack+"\n");
                return magicAttack;
            }
            else return damage;
        }
    }

    /**
     * Метод отримання удару дроїдом
     * @param damage удар
     */
    public void getHit(int damage, Droid d) {
        Random random = new Random();
        if(random.nextInt(100) < chanceToEscape){
            System.out.println(TextColor.RESET + "FlyingMan isn`t damaged");
            sb.append(TextColor.RESET + "FlyingMan isn`t damaged\n");
            isDamaged = false;
        }
        else {
            if(d.isGivePoison()) {
                this.health -= damage;
                System.out.println(TextColor.RESET + name + TextColor.RED + " -" + damage);
                sb.append(TextColor.RESET +name + TextColor.RED + " -" + damage + "\n");
                isDamaged = true;
            }
            else if(damage > armor) {
                damage-=armor;
                this.health -=damage;
                System.out.println(TextColor.RESET + name + TextColor.RED + " -" + damage);
                sb.append(TextColor.RESET +name + TextColor.RED + " -" + damage + "\n");
                isDamaged = true;
            }
            else isDamaged = false;
        }
    }
}
