package ru.geekbrains.java3.homework6;

import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {

        int[] arr = {2, 8, 2};
        afterLastFour(arr);

        int[] one = {1, 4, 1, 4};
        System.out.println(oneAndFour(one));

    }

    public static int[] afterLastFour(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                index = i + 1;
            }
        }
        int[] newArr = new int[arr.length - index];
        System.arraycopy(arr, index, newArr, 0, newArr.length);
        System.out.println(Arrays.toString(newArr));
        if (index == 0) {
            throw new RuntimeException("В массиве отсутствует 4");
        } else return newArr;
    }

    public static boolean oneAndFour(int[] arr) {
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
