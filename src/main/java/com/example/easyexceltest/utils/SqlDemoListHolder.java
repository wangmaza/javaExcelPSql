package com.example.easyexceltest.utils;

import com.example.easyexceltest.bo.ReadDemo;

import java.util.ArrayList;

public class SqlDemoListHolder {
        public static  ThreadLocal<ArrayList> holder = new ThreadLocal<>();

}
