package ru.geekbrains.java3.homework7;

public class TestHolder {

    @BeforeSuite
    public static void beforeSuite() {
        System.out.println("beforeSuite");
    }

    @Test(priority = 4)
    public void test1() {
        System.out.println("Test 1");
    }

    @Test(priority = 7)
    public void test2() {
        System.out.println("Test 2");
    }

    @Test()
    public void test3() {
        System.out.println("Test 3");
    }

    @Test(priority = 10)
    public void test4() {
        System.out.println("Test 4");
    }

    @Test(priority = 2)
    public void test5() {
        System.out.println("Test 5");
    }

    public void test6() {
        System.out.println("Test 6");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite");
    }
}
