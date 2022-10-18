package MainDroidWar;

import Fighting.Fighting;
import File.DroidsFile;
import Team.Team;
import TextColor.TextColor;

import java.io.IOException;
import java.util.Scanner;

/**
 * Клас бою Дроїдів
 */
public class DroidWar {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int var;
        System.out.print(menu());
        while(true){
            System.out.print(TextColor.BLACK +"\nChoose an option: ");
            var = sc.nextInt();
            switch (var) {
                case 1 -> System.out.println(droidsList());
                case 2 -> {
                    startFighting(1);
                    DroidsFile.addToFile();
                }
                case 3 -> {
                    Scanner scan = new Scanner(System.in);
                    System.out.print("\nChoose the number of droids in the team: ");
                    int size = scan.nextInt();
                    startFighting(size);
                    DroidsFile.addToFile();
                }
                case 4 -> DroidsFile.readFile();
                case 5 -> {
                    System.out.println("The end!:)");
                    return;
                }
            }
        }
    }

    /**
     * Метод початку битви
     * @param size кількість дроїдів в команді
     */
    public static void startFighting(int size){
        Team t1 = new Team(size);
        Team t2 = new Team(size);
        System.out.println("\nDroids: Doctor, FlyingMan, Killer");
        if(size == 1)System.out.print("Team 1, choose 1 droid: ");
        else System.out.print("Team 1, choose " + size + " droids: ");
        t1.createTeam();
        if(size == 1)System.out.print("Team 2, choose 1 droid: ");
        else System.out.print("Team 2, choose " + size + " droids: ");
        t2.createTeam();
        System.out.println(TextColor.RED + "\nThe battle has begun!");
        Fighting.startWar(t1, t2, size);
    }

    /**
     * Метод, який повертає список всіх дроїдів та їх опис
     * @return список всіх дроїдів та їх опис
     */
    public static String droidsList(){
        return TextColor.GREEN + "\nDoctor: the doctor droid has the ability to treat other droids. He can use poison which unable armor. " +
                TextColor.CYAN + "\nFlyingMan: the droid is able to fly. He has ability to avoid the damage. He can use magic attack" +
                TextColor.PURPLE + "\nKiller: the killer droid is strong, has the best health and armor ."+
                TextColor.RESET;
    }

    /**
     * Метод,який повертає меню команд
     * @return меню команд
     */
    public static String menu(){
        return TextColor.RED + "It is recommended to check the list of drones before starting the battle." + TextColor.RESET +
                "\n1. The list of all droids." +
                "\n2. One-on-one battle." +
                "\n3. Team battle." +
                "\n4. Reproduce the final fight." +
                "\n5. An exit from the game.";
    }
}
