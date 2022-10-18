package Fighting;

import TextColor.TextColor;
import Droids.Droid;
import Team.Team;
import java.util.List;
import java.util.Random;

/**
 * Клас бою дроїдів
 */
public class Fighting {
    /** в sb записується бій, який потім додається до файлу */
    public static StringBuilder sb = new StringBuilder();

    /**
     * Метод битви команд
     * @param t1 команда1
     * @param t2 команда2
     * @param size кількість гравців в команді
     */
    public static void startWar(Team t1, Team t2, int size) {
        sb.delete(0, sb.length());
        int n1 = 0, n2 = 0;
        Random r = new Random();
        while (true) {
            if(r.nextInt(100) < 50) {
                printOpponents(t1.droids().get(n1), t2.droids().get(n2), 1);
                fight(t1.droids().get(n1), t2.droids().get(n2));
                if(t2.droids().get(n2).isDamaged()) RecoverAndPrint(t2, n2, size, 2);

                if (isDead(t2.droids().get(n2))) {
                    printWhoIsKilled(t2.droids().get(n2),1);
                    if (n2 < size - 1) n2++;
                    else {
                        printResult(1);
                        break;
                    }
                }
            }
            else {
                printOpponents(t2.droids().get(n2), t1.droids().get(n1), 2);
                fight(t2.droids().get(n2), t1.droids().get(n1));
                if(t1.droids().get(n1).isDamaged()) RecoverAndPrint(t1, n1, size, 1);
                if (isDead(t1.droids().get(n1))){
                    printWhoIsKilled(t1.droids().get(n1),2);
                    if (n1 < size - 1) n1++;
                    else{
                        printResult(2);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Метод, який виводить суперників
     * @param d1 дроїд, який наносить удар
     * @param d2 дроїд, який приймає удар
     * @param num  номер дроїда
     */
    public static void printOpponents(Droid d1, Droid d2, int num) {
        if(num==1) {
            System.out.printf(TextColor.BLACK + d1.getName() + "1 VS " + d2.getName() + "2: ");
            sb.append(TextColor.BLACK + d1.getName() + "1 VS " + d2.getName() + "2: ");
        }
        else{
            System.out.printf(TextColor.BLACK + d1.getName() + "2 VS " + d2.getName() + "1: ");
            sb.append(TextColor.BLACK + d1.getName() + "2 VS " + d2.getName() + "1: ");
        }
    }

    /**
     * Метод битви
     * @param d1 дроїд, який наносить удар
     * @param d2 дроїд, який приймає удар
     */
    public static void fight(Droid d1, Droid d2){
        int damage;

        damage = d1.attack();
        if(d1.getHealth() < 400 && d1.getHealth() > 100)damage -= 100;

        d2.getHit(damage,d1);
    }

    /**
     * Метод, який перевіряє чи серед гравців команди є лікар
     * @param list список всіх дроїдів
     * @param n індекс дроїда
     * @param size кількість гравців в команді
     * @return true, якщо в команді є лікар, false - якщо нема
     */
    public static boolean hasDoctor(List<Droid> list, int n, int size){
        for(int i = n+1; i < size; i++){
            if(list.get(i).getName().equals("Doctor"))return true;
        }
        return false;
    }

    /**
     * Метод відновлення здоров'я і виводу дроїда, якого полікували
     * @param t2 команда 2, дроїд якої приймає удар
     * @param n2 індекс дроїда
     * @param size кількість гравців в команді
     * @param n номер дроїда
     */
    public static void RecoverAndPrint(Team t2, int n2, int size, int n) {
        if (hasDoctor(t2.droids(), n2, size) && t2.droids().get(n2).getHealth() > 0) {
            t2.droids().get(n2).setHealth(t2.droids().get(n2).getHealth() + 100);
            if(n==1){
                System.out.println(TextColor.BLACK + t2.droids().get(n2).getName() + "1" + TextColor.GREEN + " +100");
                sb.append(TextColor.BLACK + t2.droids().get(n2).getName() + "1" + TextColor.GREEN + " +100\n");
            }
            else{
                System.out.println(TextColor.BLACK + t2.droids().get(n2).getName() + "2" + TextColor.GREEN + " +100");
                sb.append(TextColor.BLACK + t2.droids().get(n2).getName() + "2" + TextColor.GREEN + " +100\n");
            }
        }
    }


    /**
     * Метод,  який перевіряє чи дроїд живий
     * @param d дроїд, який приймає удар
     * @return true, якщо дроїд вбитий, false - якщо живий
     */
    public static boolean isDead(Droid d) {
        return d.getHealth() <= 0;
    }

    /**
     * Метод, який виводить якого дроїда вбили
     * @param d дроїд, якого вбили
     * @param num номер дроїда
     */
    public static void printWhoIsKilled(Droid d,int num){
        if(num==1){
            System.out.println(TextColor.RED + d.getName() + "2 is killed");
            sb.append(TextColor.RED + d.getName() + "2 is killed\n");
        }
        else{
            System.out.println(TextColor.RED + d.getName() + "1 is killed");
            sb.append(TextColor.RED + d.getName() + "1 is killed\n");
        }
    }

    /**
     * Метод виводу результату битви
     * @param num номер команди
     */
    public static void printResult(int num){
        if(num==1) {
            System.out.println("Team 2 has lost.");
            System.out.println(TextColor.GREEN + "Team 1, congratulate you on your victory! :)");
            sb.append("Team 2 has lost.\n" + TextColor.GREEN + "Team 1, congratulate you on your victory! :)\n");
        }
        else{
            System.out.println("Team 1 has lost.");
            System.out.println(TextColor.GREEN + "Team 2, congratulate you on your victory! :)");
            sb.append("Team 1 has lost.\n" + TextColor.GREEN + "Team 2, congratulate you on your victory! :)\n");
        }
    }
}
