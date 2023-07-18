package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class HotDrink {
    private String Name;
    private int Volume;
    private int Price;

    public HotDrink(String name, int volume, int price) {
        this.Name = name;
        this.Volume = volume;
        this.Price = price;
    }

    public String GetName(){
        return this.Name;
    }
    public int GetPrice(){
        return this.Price;
    }
    public int GetVolume(){
        return this.Volume;
    }

}
class DrinkTemp extends HotDrink {
     private int Temp;
    public int GetTemp(){
        return this.Temp;
    }
    public DrinkTemp(String name, int volume, int temperature, int price){
        super(name, volume, price);
        this.Temp = temperature;
    }
}

class HotDrinkMachine {
    private ArrayList<DrinkTemp> hdm = new ArrayList<DrinkTemp>();
    public void addDrink(DrinkTemp dr){
        this.hdm.add(dr);
    }
    public void getProduct(String name, int volume, int temperature) {
        int count = -1;
        for (int i = 0; i < hdm.size(); i++) {
             if (hdm.get(i).GetName().toLowerCase().equals(name)
             && hdm.get(i).GetTemp() == temperature
             && hdm.get(i).GetVolume() == volume){
                  count = i;
             }
        }
        if (count != -1) {
            System.out.printf("Вы выбрали %s, стоимость: %d", hdm.get(count).GetName(), hdm.get(count).GetPrice());
        }
        else {
            System.out.println("Такого напитка нет!");
        }

    }
    public void Selection(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название напитка: ");
        String name = in.nextLine().toLowerCase();
        System.out.println("Введите объём: ");
        int vol = Integer.parseInt(in.nextLine());
        System.out.println("Введите температуру: ");
        int temp = Integer.parseInt(in.nextLine());
        getProduct(name, vol, temp);
    }
}
public class Main {
    public static void main(String[] args){
        DrinkTemp coffee1 = new DrinkTemp("Кофе", 200, 85, 150);
        DrinkTemp coffee2 = new DrinkTemp("Кофе", 100, 85, 100);
        DrinkTemp tea1 = new DrinkTemp("Зеленый чай", 200, 95, 100);
        DrinkTemp tea2 = new DrinkTemp("Зеленый чай", 100, 95, 70);
        DrinkTemp tea3 = new DrinkTemp("Черный чай", 200, 95, 100);
        DrinkTemp tea4 = new DrinkTemp("Черный чай", 100, 95, 70);
        HotDrinkMachine machine = new HotDrinkMachine();
        machine.addDrink(coffee1);
        machine.addDrink(coffee2);
        machine.addDrink(tea1);
        machine.addDrink(tea2);
        machine.addDrink(tea3);
        machine.addDrink(tea4);
        machine.Selection();

    }
}