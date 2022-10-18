package File;

import Fighting.Fighting;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Клас для зчитування з файлу та запису в файл
 */
public class DroidsFile {
    /**
     * Метод запису в файл
     * @throws IOException
     */
    public static void addToFile() throws IOException {
        FileWriter fw = new FileWriter( "fight.txt" );
        fw.write(Fighting.sb.toString());
        fw.close();
    }

    /**
     * Метод зчитування з файлу
     * @throws IOException
     */
    public static void readFile() throws IOException {
        FileReader fr = new FileReader( "fight.txt" );
        Scanner scan = new Scanner(fr);
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        fr.close();
    }
}
