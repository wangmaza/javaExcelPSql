package com.example.easyexceltest.utils;

import java.io.File;
import java.io.FileInputStream;

public  class StringUtils {


    public static String readBuffer(String filePath) throws Exception {
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

}
