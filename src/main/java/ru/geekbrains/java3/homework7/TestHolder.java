package ru.geekbrains.java3.homework7;

public class TestHolder {

    @BeforeSuite
    public static void beforeSuite() {
        System.out.println("beforeSuite");
    }

    @Test(priority = 4)
    public static void test1() {
        System.out.println(4);
    }

    @Test(priority = 7)
    public static void test2() {
        System.out.println(7);
    }

    @Test()
    public static void test3() {
        System.out.println(5);
    }

    @Test(priority = 10)
    public static void test4() {
        System.out.println(10);
    }

    @Test(priority = 2)
    public static void test5() {
        System.out.println(2);
    }

    public static void test6() {
        System.out.println("-");
    }

    @AfterSuite
    public static void afterSuite() {
        System.out.println("afterSuite");
    }
}
