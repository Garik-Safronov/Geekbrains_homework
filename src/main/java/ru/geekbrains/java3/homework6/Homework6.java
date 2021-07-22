package ru.geekbrains.java3.homework6;

import java.util.Arrays;

public class Homework6 {

    public int[] afterLastFour(int[] arr) {
        if (arr.length == 0){
            throw new NullPointerException("Массив пустой");
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                index = i + 1;
            }
        }
        if (index == 0) {
            throw new RuntimeException("В массиве отсутствует 4");
        }
        int[] newArr = new int[arr.length - index];
        System.arraycopy(arr, index, newArr, 0, newArr.length);
        System.out.println(Arrays.toString(newArr));
        return newArr;
    }

    public boolean oneAndFour(int[] arr) {
        if (arr.length == 0){
            throw new NullPointerException("Массив пустой");
        }
        boolean one = false;
        boolean four = false;
        for (int value : arr) {
            if (value == 1)
                one = true;
            else if (value == 4)
                four = true;
            else
                return false;
        }
        return one && four;
    }
}
