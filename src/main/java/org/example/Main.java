package org.example;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {


        //Task1

        Array<Integer> integerArray = new Array<>(5);
        System.out.println("Заповнення масиву з клавіатури:");
        integerArray.fillFromKeyboard();
        System.out.println("Масив:");
        integerArray.display();

        System.out.println("Максимальне значення: " + integerArray.findMax());
        System.out.println("Мінімальне значення: " + integerArray.findMin());
        System.out.println("Середнє арифметичне: " + integerArray.calculateAverage());


        System.out.println("Сортування масиву по зростанню:");
        integerArray.sortAscending();
        integerArray.display();

        System.out.println("Сортування масиву по спаданню:");
        integerArray.sortDescending();
        integerArray.display();



        int oldValue = 42;
        int newValue = 99;
        System.out.println("Заміна значення " + oldValue + " на " + newValue + ":");
        integerArray.replaceValue(oldValue, newValue);
        integerArray.display();


        //Task2

        Matrix<Double> matrix1 = new Matrix<>(3, 3);
        Matrix<Double> matrix2 = new Matrix<>(3, 3);

        System.out.println("\nЗаповнення першої матриці з клавіатури:");
        matrix1.fillFromKeyboard();
        System.out.println("Перша матриця:");
        matrix1.display();

        System.out.println("\nЗаповнення другої матриці випадковими значеннями:");
        matrix2.fillWithRandomValues();
        System.out.println("\nДруга матриця:");
        matrix2.display();

        Matrix<Double> sumMatrix = matrix1.add(matrix2);
        System.out.println("\nСума матриць:");
        sumMatrix.display();

        Matrix<Double> differenceMatrix = matrix1.subtract(matrix2);
        System.out.println("\nРізниця матриць:");
        differenceMatrix.display();

        Matrix<Double> productMatrix = matrix1.multiply(matrix2);
        System.out.println("\nДобуток матриць:");
        productMatrix.display();

        System.out.println("\nМаксимальний елемент у першій матриці: " + matrix1.findMax());
        System.out.println("Мінімальний елемент у другій матриці: " + matrix2.findMin());

        double averageValue = matrix1.calculateAverage();
        System.out.println("Середнє арифметичне значення у першій матриці: " + averageValue);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число для ділення матриці 1: ");
        double divisor = scanner.nextDouble();
        Matrix<Double> divisionMatrix = matrix1.divide(divisor);
        System.out.println("Результат ділення першої матриці на число: ");
        divisionMatrix.display();
    }
}