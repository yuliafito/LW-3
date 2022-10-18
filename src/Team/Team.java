package Team;

import Droids.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**Клас для представлення команди */
public class Team {
    /** розмір команди */
    private int size;
    private List<Droid> droidsList = new ArrayList<>();

    /**
     * Конструктор
     * @param size розмір команди
     */
    public Team(int size){
        this.size = size;
    }

    /**Метод створення команди */
    public void createTeam(){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < size; i++)
            droidsList.add(getDroid(sc.next()));
    }

    /**
     * Метод, який повертає дроїда
     * @param name ім'я дроїда
     * @return дроїда
     */
    public Droid getDroid(String name){
        if (name.equals("Doctor"))return new DoctorDroid();
        if (name.equals("FlyingMan"))return new PilotDroid();
        return new KillerDroid();
    }

    /**
     * Метод, який повертає список всіх дроїдів
     * @return список всіх дроїдів
     */
    public List<Droid> droids(){
        return droidsList;
    }
}
