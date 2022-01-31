package com.company.reporter;

import com.company.annotation.Test;
import com.company.annotation.TestType;
import com.company.test.TestSuite;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

public class Reporter {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\033[0;32m";
    private final ArrayList<Method> uiTestArrayList;

    public Reporter() {
        uiTestArrayList = getUiTestArrayList();
    }

    public void getUiTestsInformation() {
        System.out.println("Total number of UI tests: " + getCountOfTotalUiTests() + "\n");

        int count = 1;
        for (Method test : uiTestArrayList) {
            System.out.println("Test " + count + ": " + ANSI_GREEN + getUiTestName(test) + ANSI_RESET);
            System.out.println("    Method name -> " + getTestMethodName(test));
            System.out.println("    Modifiers -> " + getUiTestModifiers(test));
            System.out.println("    Return type -> " + getUiTestReturnType(test));
            System.out.println("    Parameters -> " + getUiTestParameters(test));
            count++;
        }
    }

    private ArrayList<Method> getUiTestArrayList() {
        Class<TestSuite> clazz = TestSuite.class;
        Method[] methodArray = clazz.getDeclaredMethods();
        ArrayList<Method> uiTestArrayList = new ArrayList<>();
        for (Method method : methodArray) {
            if (method.isAnnotationPresent(TestType.class)) {
                TestType annotationTestType = method.getAnnotation(TestType.class);
                if (annotationTestType.name().equalsIgnoreCase("UI")) {
                    uiTestArrayList.add(method);
                }
            }
        }
        return uiTestArrayList;
    }

    private int getCountOfTotalUiTests() {
        return uiTestArrayList.size();
    }

    private String getUiTestName(Method test) {
        return (test.isAnnotationPresent(Test.class)) ? test.getAnnotation(Test.class).value() : "";
    }

    private String getTestMethodName(Method test) {
        return test.getName();
    }

    private String getUiTestModifiers(Method test) {
        return Modifier.toString(test.getModifiers());
    }

    private String getUiTestReturnType(Method test) {
        return String.valueOf(test.getReturnType());
    }

    private String getUiTestParameters(Method test) {
        return Arrays.toString(test.getParameters());
    }
}
