package ru.otus.hw01;

import com.google.common.base.MoreObjects;

import java.util.Date;

public class HelloOtus {

    public static String breakEvenDate() {
        String returnValue = null;
        if (new Date().getTime() % 2 == 0) {
            returnValue = "DateTime is even";
        }
        return returnValue;
    }

    public static String isEvenDate(String even, String odd) {
        return MoreObjects.firstNonNull(even, odd);
    };

    public static void main(String[] args) {
        String oddDate = "DateTime is odd";

        System.out.println(isEvenDate(breakEvenDate(),oddDate));
    }
}
