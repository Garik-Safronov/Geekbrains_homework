package ru.geekbrains.java3.homework7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        start(TestHolder.class);
    }


    public static void start(Class TestHolder) throws InvocationTargetException, IllegalAccessException {

        Method[] allMethods = TestHolder.getDeclaredMethods();
        List<Method> methodsToTest = new ArrayList<>();

        for (Method method : allMethods) {
            if (method.getAnnotation(Test.class) != null) {
                methodsToTest.add(method);
            }
            methodsToTest.sort((method1, method2) ->
                    method2.getAnnotation(Test.class).priority()-method1.getAnnotation(Test.class).priority());
        }

        for (Method method : allMethods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                if (methodsToTest.get(0).getAnnotation(BeforeSuite.class) != null) {
                    throw new RuntimeException("Возможна только одна аннотация BeforeSuite");
                } else methodsToTest.add(0, method);
            }

                if (method.getAnnotation(AfterSuite.class) != null) {
                    if (methodsToTest.get(methodsToTest.size() - 1).getAnnotation(AfterSuite.class) != null) {
                        throw new RuntimeException("Возможна только одна аннотация AfterSuite");
                    } else methodsToTest.add(method);
                }
            }

            for (Method methodToTest : methodsToTest) {
                methodToTest.invoke(null);
            }
        }
    }
