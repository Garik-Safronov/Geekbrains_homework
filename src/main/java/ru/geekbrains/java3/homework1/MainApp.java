package ru.geekbrains.java3.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        // Задание1:
        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] arr2 = {"a", "b", "c", "d", "e", "f", "g"};

        System.out.println(Arrays.toString(arr1));
        swapTwoElements(arr1, 0, 1);
        System.out.println(Arrays.toString(arr1));

        System.out.println(Arrays.toString(arr2));
        swapTwoElements(arr2, 0, 1);
        System.out.println(Arrays.toString(arr2));


        // Заданиие2:
        Integer[] arrInt = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        arrayToArrayList(arrInt);

        String[] arrString = {"a", "b", "c", "d", "e", "f", "g"};
        arrayToArrayList(arrString);


        // Задание3:
        Apple apple = new Apple();
        Orange orange = new Orange();

        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();
        Box<Orange> box3 = new Box<>();

        box1.addFruit(apple);
        box1.addFruit(apple);
        box1.addFruit(apple);
        box2.addFruit(orange);
        box2.addFruit(orange);

        System.out.println("Ящик яблок весит " + box1.getWeight());
        System.out.println("Ящик апельсин весит " + box2.getWeight());
        System.out.println(box1.compare(box2));
        box2.removeFruits(box3);
        System.out.println("Ящик апельсин1 весит " + box2.getWeight());
        System.out.println("Ящик апельсин2 весит " + box3.getWeight());
    }


    public static <T> void swapTwoElements(T[] array, int firstIndex, int secondIndex) {
        try {
            T temp = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = temp;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Неверно указаны элементы массива");
        }
    }

    public static <T> void arrayToArrayList(T[] array) {
        List<T> list = new ArrayList(Arrays.asList(array));
        System.out.println(Arrays.toString(array));
    }

}
