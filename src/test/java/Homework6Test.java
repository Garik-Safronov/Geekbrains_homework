import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.java3.homework6.Homework6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Homework6Test {
    private Homework6 hw6;

    @BeforeEach
    void init() {
        hw6 = new Homework6();
    }

    private static Stream<Arguments> dataForTask2() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[]{1, 1, 1, 4}, true));
        list.add(Arguments.arguments(new int[]{4, 4, 1, 4}, true));
        list.add(Arguments.arguments(new int[]{1, 1, 1, 1}, false));
        list.add(Arguments.arguments(new int[]{4, 4, 4, 4}, false));
        list.add(Arguments.arguments(new int[]{4, 4, 1, 2}, false));
        return list.stream();
    }

    @Test
    @DisplayName("Task1: Тест")
    void testTask1() {
        Assertions.assertArrayEquals(new int[]{1, 2, 8}, hw6.afterLastFour(new int[]{4, 8, 4, 7, 4, 1, 2, 8}));
    }

    @Test
    @DisplayName("Task1: Отсутствие в массиве 4")
    void testTask1Without4() {
        Assertions.assertThrows(RuntimeException.class, () -> hw6.afterLastFour(new int[]{3, 8, 9, 1, 1}));
    }

    @Test
    @DisplayName("Task1: Проверка на пустой массив")
    void testTask1Null() {
        Assertions.assertThrows(NullPointerException.class, () -> hw6.afterLastFour(new int[]{}));
    }

    @ParameterizedTest
    @MethodSource("dataForTask2")
    @DisplayName("Task2: parametrized")
    void paramTestTask2(int[] arr, boolean result) {
        Assertions.assertEquals(result, hw6.oneAndFour(arr));
    }

    @Test
    @DisplayName("Task2: Проверка на пустой массив")
    void testTask2Null() {
        Assertions.assertThrows(NullPointerException.class, () -> hw6.oneAndFour(new int[]{}));
    }
}