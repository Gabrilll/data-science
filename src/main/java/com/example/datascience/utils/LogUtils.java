package com.example.datascience.utils;

import java.util.List;

public class LogUtils {
    public static void printList(String tag, List list) {
        System.out.println(tag);
        for (Object obj : list) {
            System.out.println(obj);
        }
        System.out.println();
    }
}
