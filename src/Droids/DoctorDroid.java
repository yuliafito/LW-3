package Droids;
import TextColor.TextColor;
import java.util.Random;
import static Fighting.Fighting.sb;

/**
 * Клас,що представляє тип Doctor дроїда
 */
public class DoctorDroid extends Droid {
    /** отрута */
    private final int poison;
    /** ймовірність використати отруту*/
    private final int chancePoison;

    /** Конструктор */
    public DoctorDroid() {
        super(1000, 150, 50,  "Doctor");
        chancePoison = 30;
        poison = 2000;
        givePoison = false;
    }
    /**
     * Метод атаки ворожого дроїда
     * @return удар нанесений дроїдом
     */
    public int attack()
    {
        Random random = new Random();
        if (random.nextInt(100) < chancePoison){
            System.out.println("Doctor give poison! " + TextColor.PURPLE + poison);
            sb.append("Doctor give poison! " + TextColor.PURPLE + poison+"\n");
            givePoison = true;
            return poison;
        }
        else return damage;

    }
}
