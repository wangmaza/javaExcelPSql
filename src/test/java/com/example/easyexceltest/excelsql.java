package com.example.easyexceltest;

import com.alibaba.excel.EasyExcel;
import com.example.easyexceltest.bo.Demo;
import com.example.easyexceltest.bo.ReadDemo;
import com.example.easyexceltest.bo.SqlDemo;
import com.example.easyexceltest.lister.ExcelListener;
import com.example.easyexceltest.lister.notSelfExcelListener;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class excelsql {


    @Test
    void contextLoads() {
        List<Demo> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Demo demo = new Demo();
            demo.setSno(i);
            demo.setSname("data" + i);
            list.add(demo);
        }
        String filename = "D:/temp/test.xlsx";
        EasyExcel.write(filename, Demo.class).sheet("学生列表").doWrite(list);
    }


    //测试读
    @Test
    void read() {
        String filename = "D:/temp/test.xlsx";
        EasyExcel.read(filename, ReadDemo.class, new ExcelListener()).sheet().doRead();
    }


    //生成非自保件sql
    @Test
    void readNotSelf() {
        String filename = "D:/temp/sql.xlsx";
        EasyExcel.read(filename, SqlDemo.class, new notSelfExcelListener()).sheet().doRead();
    }

    @Test
    void readfile() throws Exception {
        String filename = "D:/temp/onlyoneweek.sql";
        String s = readBuffer(filename);

    }

    @Test
    void writerfile() throws Exception {
        String filename = "D:/temp/product.sql";
        Writer writer = null;
        try {
            File file = new File(filename);
            //创建文件
            if (!file.exists()) {
                file.createNewFile();
            }
            //实例化writer对象
            writer = new FileWriter(file);
            //write()方法用于覆盖已有文件内容
            String sfilename = "D:/temp/onlyoneweek.sql";
            String s = readBuffer(sfilename);
            writer.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭writer对象
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String readBuffer(String filePath) throws Exception {
        File file = new File(filePath);
        FileInputStream fis = null;
        String sql = null;
        try {
            fis = new FileInputStream(file);
            byte[] buf = new byte[102400];//长度可以定义成1024的整数倍。
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                sql = new String(buf, 0, len);
            }
        } catch (Exception e) {

        } finally {
            fis.close();
        }

        return sql;
    }


    @Test
    public void fenGeFu() {
        String orign = "wo,我你他,是,ssss";
        String s = "";
        if (orign.contains(",")) {
            String[] split = orign.split(",");
            for (int i = 0; i < split.length; i++) {
                if (i != (split.length - 1)) {
                    s = s + split[i] + "','";
                }else {
                    s = s + split[i];
                }
            }
        }
        System.out.println(s);
    }


}
