package org.example;

import java.util.Random;
import java.util.Scanner;

public class Matrix<T extends Number> {
    private T[][] elements;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        elements = (T[][]) new Number[rows][columns];
    }

    public void fillFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Введіть елемент матриці [" + i + "][" + j + "]: ");
                elements[i][j] = (T) (Number) scanner.nextDouble();
            }
        }
    }

    public void fillWithRandomValues() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                elements[i][j] = (T) (Number) random.nextDouble();
            }
        }
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(elements[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Matrix<T> add(Matrix<T> other) {
        if (rows != other.rows || columns != other.columns) {
            throw new IllegalArgumentException("Розміри матриць не відповідають один одному.");
        }

        Matrix<T> result = new Matrix<>(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.elements[i][j] = (T) (Number) (elements[i][j].doubleValue() + other.elements[i][j].doubleValue());
            }
        }
        return result;
    }

    public Matrix<T> subtract(Matrix<T> other) {
        if (rows != other.rows || columns != other.columns) {
            throw new IllegalArgumentException("Розміри матриць не відповідають один одному.");
        }

        Matrix<T> result = new Matrix<>(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.elements[i][j] = (T) (Number) (elements[i][j].doubleValue() - other.elements[i][j].doubleValue());
            }
        }
        return result;
    }

    public Matrix<T> multiply(Matrix<T> other) {
        if (columns != other.rows) {
            throw new IllegalArgumentException("Кількість стовпців першої матриці не дорівнює кількості рядків другої матриці.");
        }

        Matrix<T> result = new Matrix<>(rows, other.columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                result.elements[i][j] = (T) (Number) 0;
                for (int k = 0; k < columns; k++) {
                    result.elements[i][j] = (T) (Number) (result.elements[i][j].doubleValue() + (elements[i][k].doubleValue() * other.elements[k][j].doubleValue()));
                }
            }
        }
        return result;
    }

    public Matrix<T> divide(double divisor) {
        Matrix<T> result = new Matrix<>(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.elements[i][j] = (T) (Number) (elements[i][j].doubleValue() / divisor);
            }
        }
        return result;
    }

    public T findMax() {
        T max = elements[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (elements[i][j].doubleValue() > max.doubleValue()) {
                    max = elements[i][j];
                }
            }
        }
        return max;
    }

    public T findMin() {
        T min = elements[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (elements[i][j].doubleValue() < min.doubleValue()) {
                    min = elements[i][j];
                }
            }
        }
        return min;
    }

    public double calculateAverage() {
        double sum = 0.0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += elements[i][j].doubleValue();
            }
        }
        return sum / (rows * columns);
    }
}
