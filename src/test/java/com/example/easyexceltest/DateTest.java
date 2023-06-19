package com.example.easyexceltest;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTest {



    @Test
    public void dateTest(){
//        Date date = new Date();
//        Date date1 = new Date("2023-08-31");
//        System.out.println(date1);
//        System.out.println(date);

        LocalDate date1 = LocalDate.of(2023, 6, 11);
        LocalDate date2 = LocalDate.of(2023, 6, 12);


        // 计算两个日期之间的天数
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        System.out.println("相差天数: " + daysBetween);

    }
}
