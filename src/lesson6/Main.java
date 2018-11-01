package lesson6;

import lesson6.battleunit.*;
import lesson6.calculator.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Knight knight = new Knight(100, 20);
//        Spearman spearman = new Spearman(60, 70);
//
//        knight.attack(spearman);
//
//        Doctor doctor = new Doctor(50, 10);
//        doctor.attack(knight);
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите название персонажа");
//        String userChoise = scanner.nextLine();
//
//        BattleUnitFactory unitFactory = new BattleUnitFactory();
//        BattleUnit unit = unitFactory.create(userChoise);
//
//        Fight fight = new Fight(unit, spearman);
//        fight.fight();
//        System.out.println(fight.fightResult());
        int a = 2;
        int b = 0;
        Operation plus = new Plus(a, b);
        System.out.println("Сложение дает результат = " + plus.execute(a ,b ));

        Operation minus = new Minus(a, b);
        System.out.println("Вычитание дает результат = " + minus.execute(a, b));

        Operation delenie = new Delenie(a, b);
        System.out.println("Деление дает результат = " + delenie.execute(a, b));

        Operation umnojenie = new Umnojenie(a, b);
        System.out.println("Умножение дает результат = " + umnojenie.execute(a, b));



        }
}
