package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Array<T extends Comparable<T>> {
    private T[] elements;

    public Array(int size) {
        elements = (T[]) new Comparable[size];
    }

    public void fillFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < elements.length; i++) {
            System.out.print("Введіть елемент #" + (i + 1) + ": ");
            elements[i] = (T) scanner.next();
        }
    }

    public void fillWithRandomValues() {
        Random random = new Random();
        for (int i = 0; i < elements.length; i++) {
            elements[i] = (T) (Integer.valueOf(random.nextInt(100)));
        }
    }

    public void display() {
        System.out.println(Arrays.toString(elements));
    }

    public T findMax() {
        T max = elements[0];
        for (T element : elements) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    public T findMin() {
        T min = elements[0];
        for (T element : elements) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
    }

    public double calculateAverage() {
        double sum = 0.0;
        for (T element : elements) {
            sum += Double.parseDouble(element.toString());
        }
        return sum / elements.length;
    }

    public void sortAscending() {
        Arrays.sort(elements);
    }

    public void sortDescending() {
        Arrays.sort(elements, (a, b) -> b.compareTo(a));
    }

    public boolean binarySearch(T value) {
        sortAscending();
        int left = 0;
        int right = elements.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int comparison = value.compareTo(elements[middle]);

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return false;
    }

    public void replaceValue(T oldValue, T newValue) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(oldValue)) {
                elements[i] = newValue;
            }
        }
    }
}
